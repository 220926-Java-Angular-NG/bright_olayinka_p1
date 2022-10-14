package com.brightola.models;


import java.util.List;

public class Cache {
        public enum Level {NONE, EMPLOYEE, MANAGER}

        public Level level = Level.NONE;

        public String curUser_name = null;
        public int curUserID = -1;

        public List<Ticket> ticketList;

    }

