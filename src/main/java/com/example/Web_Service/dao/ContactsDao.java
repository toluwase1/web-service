package com.example.Web_Service.dao;

import com.example.Web_Service.entity.Contact;

import java.util.List;

public interface ContactsDao {

    //CRUD OPERATIONS
    public Contact addContact(Contact contact) throws DaoException;
    public Contact findById (Integer id) throws DaoException;
    public Contact updateContact (Contact contact) throws DaoException;
    public void deleteContact (Integer id) throws DaoException;


    //Queries
    public List <Contact> findAll () throws DaoException;
    public List<Contact> findByCity () throws DaoException;
    public List<Contact> findByCountry () throws DaoException;

}
