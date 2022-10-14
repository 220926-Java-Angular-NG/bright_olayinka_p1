package com.brightola.services;

import com.brightola.models.Ticket;
import com.brightola.repos.TicketRepo;
import com.brightola.repos.EmployeeRepo;
import com.brightola.models.Employee;

import java.util.List;

public class TicketServices {

    private TicketRepo ticketRepo;

    public TicketServices() {
        ticketRepo = new TicketRepo();
    }

    public TicketServices(TicketRepo ticketRepo) {
        this.ticketRepo = ticketRepo;
    }



    //    create
    public int createticket(Ticket ticket){

        return ticketRepo.create(ticket);
    }

    public List<Ticket> getTicketByCreator_id(int creator_id){

        return ticketRepo.getTicketByCreator_id(creator_id);
    }

    public List<Ticket> getAll(){

        return ticketRepo.getAll();
    }

    public boolean UpdateTicket(int id, Ticket.Status status){

        return ticketRepo.updateTicket(id, status);
    }

    public boolean updateTicket(int id, Ticket.Status status) {
        return false;
    }
}