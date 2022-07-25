package de.pascalkuehnold.databasewebapp.dao;

import de.pascalkuehnold.databasewebapp.entities.Customer;
import de.pascalkuehnold.databasewebapp.util.SortUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to have a session factory
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers(int sortValue) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        String fieldName = null;

        switch (sortValue) {
            case SortUtils.FIRST_NAME:
                fieldName = "firstName";
                break;
            case SortUtils.LAST_NAME:
                fieldName = "lastName";
                break;
            case SortUtils.EMAIL:
                fieldName = "email";
                break;
            default:
                fieldName = "lastName";
        }

        String queryString = "from Customer order by " + fieldName;

        //create a query
        Query<Customer> query =
                currentSession.createQuery(queryString, Customer.class);

        //return the results
        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        //Get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //save the customer or update the customer if id exists
        currentSession.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {

        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //get the customer
        //return the customer
        return currentSession.get(Customer.class, id);
    }

    @Override
    public void deleteCustomer(int id) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //delete the customer by id
        Query query =
                currentSession.createQuery("DELETE from Customer where id=:customerId");
        query.setParameter("customerId", id);

        query.executeUpdate();
    }

    @Override
    public List<Customer> searchCustomers(String customerName) {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //search customers by name
        Query query = null;

        //only search by name if customerName is not empty
        if (customerName != null && customerName.trim().length() > 0) {
            //search for firstName or lastName -> case insensitive
            query = currentSession.createQuery("from Customer where lower(firstName) like:_customerName " +
                    "or lower(lastName) like:_customerName", Customer.class);
            query.setParameter("_customerName", "%" + customerName.toLowerCase(Locale.ROOT) + "%");
        } else {
            //the customerName is empty, so all customers are received
            query = currentSession.createQuery("from Customer", Customer.class);
        }

        //execute the query and get the result list
       return query.getResultList();

    }

    //region Getters and Setters

    //Setter for the hibernate sessionfactory, handled by dependency injection
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    //endregion
}
