package com.brightola.models;

public class Ticket {
    private int id;
    private double amount;
    private String description;
    private int creator_id;

    public Object getType() {
        return null;
    }

    public boolean getIsManager() {
        return false;
    }

    public String getUser_name() {
        return null;
    }
//    private String status;

    public enum Status {pending, approved, denied}

    public Ticket.Status status = Status.pending;

    public Ticket() {
    }

    public Ticket(double amount, String description, int creator_id) {
        this.amount = amount;
        this.description = description;
        this.creator_id = creator_id;
    }

    public Ticket(double amount, String description, Status status,  int creator_id) {
        this.amount = amount;
        this.description = description;
        this.status = status;
        this.creator_id = creator_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", creator_id=" + creator_id +
                ", status=" + status +
                '}';
    }
}
