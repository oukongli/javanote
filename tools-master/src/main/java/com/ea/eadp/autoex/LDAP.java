package com.ea.eadp.autoex;

import com.novell.ldap.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kouyang on 12/8/2014.
 */
public class LDAP {

    public LDAP(QueryConfig queryConfig) {
        this.queryConfig = queryConfig;
    }

    public LDAPConnection connection;
    private QueryConfig queryConfig;

    public void openConnection() throws LDAPException {
        if (connection == null) {
            connection = new LDAPConnection();
                connection.connect(queryConfig.getLdapHost(), queryConfig.getLdapPort());
                connection.bind(LDAPConnection.LDAP_V3, queryConfig.getLoginDN(), queryConfig.getPassword().getBytes());

        }
    }

    public void closeConnection() {
        try {
            if (connection.isConnected())
                connection.disconnect();
        } catch (LDAPException e) {
            e.printStackTrace();
        }
    }

    public List<LDAPEntry> query() {
        try {
            openConnection();
        } catch (LDAPException e) {
            return null;
        }
        List<LDAPEntry> result = new ArrayList<LDAPEntry>();
        try {
            LDAPSearchResults searchResults = connection.search(queryConfig.getSearchBase(), queryConfig.getSearchScope(), queryConfig.getSearchFilter(), null, false);
            while (searchResults.hasMore()) {
                LDAPEntry nextEntry = null;
                try {
                    nextEntry = searchResults.next();
                    result.add(nextEntry);
                } catch (LDAPException e) {
                    if (e.getResultCode() == LDAPException.LDAP_TIMEOUT) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
        } catch (LDAPException e) {
            e.printStackTrace();
            System.exit(1);
        } finally {
            closeConnection();
        }
        return result;
    }
}
