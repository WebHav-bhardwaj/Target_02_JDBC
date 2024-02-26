package org.example.jdbc;

import org.example.jdbc.model.Customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCExecutor {
    public static void main(String... args){
        DatabaseConnectionManager dcm= new DatabaseConnectionManager("localhost"
                ,"postgres","postgres","123456789");
        try {
            Connection connection= dcm.getConnection();
            CustomerDAO customerDAO=new CustomerDAO(connection);
            Customer cstm = customerDAO.findById(100);
            System.out.println("This is Customers");
            System.out.println(cstm);

//                //Insert
//                Customer customer2=new Customer();
//                customer2.setId(300);
//                customer2.setFirstName("Prince");
//                customer2.setLastName("Raj");
//                customer2.setEmail("prince@123gmail.com");
//                customer2.setPhone("9602723097");
//                customer2.setAddress("Delhi");
//                customer2.setCity("Noida");
//                customer2.setState("Delhi");
//                customer2.setZipcode("201303");
//                customerDAO.create(customer2);
//update Data from Database
//                Customer customer=customerDAO.findById(10000);
//                System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
//                customer.setEmail("update it yet");
//                customer.setFirstName("Kartik");
//                customer.setLastName("Goel");
//                customer=customerDAO.update(customer);
//                System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());

            List<Customer> allCustomers = customerDAO.findAll();

            for(Customer l : allCustomers){
                System.out.println(l.getFirstName());
            }
        }catch (SQLException e){

            e.printStackTrace();

        }
    }
}
