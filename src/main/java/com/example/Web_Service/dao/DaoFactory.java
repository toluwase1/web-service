package com.example.Web_Service.dao;

public final class DaoFactory {
    private static final  String IMPLEMENTATION_TYPE = "jdbc";
    private DaoFactory(){

    }

    public static ContactsDao getContactsDao() throws DaoException {
        switch (IMPLEMENTATION_TYPE) {
            case "jdbc": return new JdbcContactsDao();
            default: throw new DaoException("IMPLEMENTATION NOT AVAILABLE");
        }
    }
}
