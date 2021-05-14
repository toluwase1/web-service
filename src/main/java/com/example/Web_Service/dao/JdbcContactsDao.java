package com.example.Web_Service.dao;

import com.example.Web_Service.entity.Contact;
import com.example.Web_Service.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JdbcContactsDao implements ContactsDao{
    @Override
    public Contact addContact(Contact contact) throws DaoException {
        String sql = "insert into contacts(name, gender, email, phone, city, country) values(?, ?, ?, ?, ?, ?)";

        try(
                Connection connection = DbUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ) {
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getGender());
            statement.setString(3, contact.getEmail());
            statement.setString(4, contact.getPhone());
            statement.setString(5, contact.getCity());
            statement.setString(6, contact.getCountry());

            statement.executeUpdate();
            ResultSet keys =statement.getGeneratedKeys();

            keys.next();
            contact.setId(keys.getInt(1));
            return contact;

        } catch (Exception ex) {
            throw new DaoException();
        }
    }

    @Override
    public Contact findById(Integer id) throws DaoException {
        String sql = "select * from contacts where id = ?";

        try (
                Connection connection = DbUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setName(resultSet.getString("name"));
                contact.setGender(resultSet.getString("gender"));
                contact.setEmail(resultSet.getString("email"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setCity(resultSet.getString("city"));
                contact.setCountry(resultSet.getString("country"));
            }

        } catch (Exception e) {
            throw new DaoException("");
        }

        return null;
    }

    @Override
    public Contact updateContact(Contact contact) throws DaoException {
        String sql = "update contacts set name=?, gender = ?, email = ?, phone = ?, phone = ?, city = ?, country = ? where id = ?";

        try (
                Connection connection = DbUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getGender());
            statement.setString(3, contact.getEmail());
            statement.setString(4, contact.getPhone());
            statement.setString(5, contact.getCity());
            statement.setString(6, contact.getCountry());
            statement.setInt(7, contact.getId());

            int count = statement.executeUpdate();
            if (count == 0) {
                throw new DaoException("No record Updated, Invalid record supplied. "+ contact.getId());
            }

        } catch (Exception e) {
                throw new DaoException(e);
        }

        return contact;
    }

    @Override
    public void deleteContact(Integer id) throws DaoException {
        String sql = "delete from contacts where id = ?";
        try (
                Connection connection = DbUtils.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ){
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            if (count == 0) {
                throw new DaoException("No record Deleted, Invalid record supplied. "+ id);
            }

        } catch (Exception e) {

        }

    }

    @Override
    public List<Contact> findAll() throws DaoException {
        return null;
    }

    @Override
    public List<Contact> findByCity() throws DaoException {
        return null;
    }

    @Override
    public List<Contact> findByCountry() throws DaoException {
        return null;
    }
}
