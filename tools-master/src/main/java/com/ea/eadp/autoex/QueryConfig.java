package com.ea.eadp.autoex;

/**
 * Created by kouyang on 12/11/2014.
 */
public class QueryConfig {
    private String loginDN;
    private String password;

    private String ldapHost;
    private int ldapPort;

    private String searchBase;
    private String searchFilter;
    private int searchScope;

    public String getLoginDN() {
        return loginDN;
    }

    public void setLoginDN(String loginDN) {
        this.loginDN = loginDN;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLdapHost() {
        return ldapHost;
    }

    public void setLdapHost(String ldapHost) {
        this.ldapHost = ldapHost;
    }

    public int getLdapPort() {
        return ldapPort;
    }

    public void setLdapPort(int ldapPort) {
        this.ldapPort = ldapPort;
    }

    public String getSearchBase() {
        return searchBase;
    }

    public void setSearchBase(String searchBase) {
        this.searchBase = searchBase;
    }

    public String getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(String searchFilter) {
        this.searchFilter = searchFilter;
    }

    public int getSearchScope() {
        return searchScope;
    }

    public void setSearchScope(int searchScope) {
        this.searchScope = searchScope;
    }
}
