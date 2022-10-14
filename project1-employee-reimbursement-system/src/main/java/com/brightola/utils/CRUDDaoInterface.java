package com.brightola.utils;
import com.brightola.models.Ticket;

import java.util.List;
import java.util.List;


public interface CRUDDaoInterface <T>{
    //DOA - Data Access Object
    // a pattern that provides an abstract interface to
    // some type of database or other persistence mechanism

    // we are returning an int because we are returning the primary key of this newly added row
    int create(T t);

    //arrayList of whatever type I query
    List<T> getAll();

    List<Ticket> getTicketByCreator_id(int creator_id);

    T getById(int id);

    Ticket getLogin(String username, String password);

    T update(T t);

    boolean updateTicket(int id, Ticket.Status status);

    boolean delete(T t);

}
