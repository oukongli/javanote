package com.ea.eadp.autoex;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;

import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by kouyang on 12/9/2014.
 */
public class OrgTreeContact {
    private String[] searchAttrs;
    private String spaces;
    boolean tabTag;
    private QueryConfig config;
    private int queryTimes;

    private StringBuffer buffer;


    public String[] getSearchAttrs() {
        return searchAttrs;
    }

    public void setSearchAttrs(String[] searchAttrs) {
        this.searchAttrs = searchAttrs;
    }

    public String getSpaces() {
        return spaces;
    }

    public void setSpaces(String spaces) {
        this.spaces = spaces;
    }

    public void init() {
        level = 1;
        queryTimes = 1;
        setSpaces("");
        Properties properties = LDAPUtil.getProperties(this);
        setSearchAttrs(properties.getProperty("searchAtts").split(","));
        if (properties.getProperty("tabTag").equalsIgnoreCase("true")) {
            tabTag = true;
        } else {
            tabTag = false;
        }

        config = new QueryConfig();
        config.setLoginDN(properties.getProperty("loginDN"));
        config.setPassword(properties.getProperty("password"));
        config.setSearchScope(LDAPConnection.SCOPE_SUB);
        config.setLdapHost(properties.getProperty("ldapHost"));
        config.setLdapPort(Integer.parseInt(properties.getProperty("ldapPort")));
        config.setSearchBase(properties.getProperty("searchBase"));
        config.setSearchFilter(properties.getProperty("searchFilter"));
    }

    public void startQuery() {
        init();
        query(config);
    }

//    private Stack<Integer> stack = new Stack<Integer>();

//    public void serialAdd() {
//        stack.push(stack.pop() + 1);
//    }

    private int level;

    public void query(QueryConfig queryConfig) {
        LDAP ladp = new LDAP(queryConfig);
        List<LDAPEntry> queryResult = ladp.query();

        if (queryResult.size() == 0 && queryTimes == 1) {
            EALDAPHelp help = new EALDAPHelp();
            List<String> hostList = help.getHostList();
            for (String host : hostList) {
                delay(1000);
                queryConfig.setLdapHost(LDAPUtil.getLdapHostByDN(host));
                queryConfig.setSearchBase(LDAPUtil.getSearchBaseByDN(host));
                ladp = new LDAP(queryConfig);
//                queryResult = ladp.query();
                List<LDAPEntry> r = ladp.query();
                if (r != null)
                    queryResult.addAll(r);
//                if (queryResult.size() > 0){
//                    break;
//                }
            }
        }
        queryTimes++;
        for (LDAPEntry entry : queryResult) {
            outPut(entry);
            if (entry.getAttribute("directReports") != null) {
                Enumeration<String> directReportsValues = entry.getAttribute("directReports").getStringValues();
                if (directReportsValues == null) {
                    continue;
                }
                spaces += "\t";
                level++;
//                serialAdd();
//                stack.push(stack.peek());
                while (directReportsValues.hasMoreElements()) {
                    String dn = directReportsValues.nextElement();
                    delay(3000);
                    config.setLdapHost(LDAPUtil.getLdapHostByDN(dn));
                    config.setSearchBase(LDAPUtil.getSearchBaseByDN(dn));
                    config.setSearchFilter(LDAPUtil.getSearchFilterByDN(dn));
                    query(config);
                }
//                stack.pop();
                level--;
                spaces = spaces.replaceFirst("\t", "");
            }
        }
    }

    public void outPut(LDAPEntry entry) {
        if (!tabTag) {
            spaces = "";
        }
        System.out.print(spaces + level + " [ ");
        buffer.append(spaces + level + " [ ");
        for (String attr : getSearchAttrs()) {
            LDAPAttribute ldapAttribute = entry.getAttribute(attr);
            if (ldapAttribute == null) {
                System.out.print(attr + "=null");
                buffer.append(attr + "=null");
                continue;
            }
            Enumeration<String> attrValues = ldapAttribute.getStringValues();
            if (attrValues == null) {
                continue;
            }
            System.out.print(attr + "=");
            while (attrValues.hasMoreElements()) {
                String value = attrValues.nextElement();
                System.out.print(value + "; ");
                buffer.append(value + "; ");
            }
        }
        System.out.print("]");
        System.out.println();
        buffer.append("]\r\n");
    }

    public void delay(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String searchFilter = LDAPUtil.getProperties(this).getProperty("searchFilter");
        System.out.println("Your searchFilter: ( " + searchFilter + " )");
        buffer = new StringBuffer();
        buffer.append("Your searchFilter: ( " + searchFilter + " )"+"\r\n");
        System.out.println("-------------Start query---------------");
        buffer.append("-------------Start query---------------"+"\r\n");
        startQuery();
        System.out.println("-------------Query completed---------------");
        buffer.append("-------------Query completed---------------"+"\r\n");
        writeToFile();
    }

    public void writeToFile(){
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedOutputStream((new FileOutputStream("result.txt"))));
            out.println(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                out.close();
        }
    }
}
