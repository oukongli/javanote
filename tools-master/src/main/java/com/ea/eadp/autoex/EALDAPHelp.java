package com.ea.eadp.autoex;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

/**
 * Created by kouyang on 12/15/2014.
 */
public class EALDAPHelp {
    public static final int searchScope = LDAPConnection.SCOPE_BASE;
    public static final String ldapHost = "ad.ea.com";
    public static final int ldapPort = 389;
    public static final String searchBase = "DC=ad,DC=ea,DC=com";
    public static final String searchFilter = "(subRefs=*)";

    public List<String> getHostList() {
        List<String> hostList = new ArrayList<String>();

        Properties properties = LDAPUtil.getProperties(this);
        QueryConfig config = new QueryConfig();
        config.setLoginDN(properties.getProperty("loginDN"));
        config.setPassword(properties.getProperty("password"));
        config.setSearchScope(searchScope);
        config.setLdapHost(ldapHost);
        config.setLdapPort(ldapPort);
        config.setSearchBase(searchBase);
        config.setSearchFilter(searchFilter);

        LDAP ldap = new LDAP(config);
        List<LDAPEntry> queryResult = ldap.query();

        for (LDAPEntry entry : queryResult) {
            LDAPAttribute ldapAttribute = entry.getAttribute("subRefs");
            if (ldapAttribute != null) {
                Enumeration<String> attrValues = ldapAttribute.getStringValues();
                if (attrValues == null) {
                    continue;
                }
                while (attrValues.hasMoreElements()) {
                    String value = attrValues.nextElement();
                    if (value.startsWith("DC=")) {
                        hostList.add(value);
                    }
                }
            }
        }
        return hostList;
    }

}
