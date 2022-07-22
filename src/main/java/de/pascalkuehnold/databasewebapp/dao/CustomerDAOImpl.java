package de.pascalkuehnold.databasewebapp.dao;

import de.pascalkuehnold.databasewebapp.entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    //need to have a session factory
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        //create a query
        Query<Customer> query =
                currentSession.createQuery("from Customer", Customer.class);

        //return the results
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
