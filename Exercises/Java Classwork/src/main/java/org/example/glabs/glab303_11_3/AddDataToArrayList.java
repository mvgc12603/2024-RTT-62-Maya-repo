package org.example.glabs.glab303_11_3;

import java.util.ArrayList;
import java.util.Iterator;

public class AddDataToArrayList {
    public ArrayList<Book> bookdetails() {
//User-defined class objects in Java ArrayList
        ArrayList<Book> list = new ArrayList<Book>();
// Passing data using Constructors
        Book b1 = new Book(1, "Crime and Punishment", "Fyodor Dostoevsky", "Philosophical");
        Book b2 = new Book(2, "To Kill a Mockingbird", "Harper Lee", "Historical Fiction");
        Book b3 = new Book(3, "Andromaque", "Jean-Baptiste Racine", "Tragedy");
        Book b4 = new Book(4, "The Giver", "Lois Lowry", "Dystopia");
// Passing data using setter
        Book b5 = new Book();
        b5.setNumber(5);
        b5.setName("Animal Farm");
        b5.setAuthor("George Orwell");
        b5.setCategory("Political Satire");
// Adding Books objects to Arraylist
        list.add(b1);
        list.add(b2);
        list.add(b3);
        list.add(b4);
        list.add(b5);
        return list;
    }
}
