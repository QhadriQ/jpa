package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        // Create books
        Book book1 = new Book("Java Programming", "John Doe", 29.99);
        Book book2 = new Book("Spring Boot Guide", "Jane Smith", 39.99);
        
        session.save(book1);
        session.save(book2);
        
        transaction.commit();
        
        // Read books
        List<Book> books = session.createQuery("FROM Book", Book.class).list();
        System.out.println("All Books:");
        books.forEach(System.out::println);
        
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}