package com.brightola.models;

public class Employee {
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private String user_name;
    private String email;
    private String pass_word;
    private String phone_no;
    private boolean isManager = false;


        public Employee() {
        }

        public Employee(int id, String first_name, String last_name, String gender, String user_name, String email, String pass_word, Boolean isManager) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.gender = gender;
            this.user_name = user_name;
            this.email = email;
            this.pass_word = pass_word;
            this.phone_no = phone_no;
            this.isManager = isManager;
        }

    public Employee(String first_name, String last_name, String gender, String user_name, String email, String pass_word, Boolean isManager) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.user_name = user_name;
        this.email = email;
        this.pass_word = pass_word;
        this.phone_no = phone_no;
        this.isManager = isManager;
    }

    public Employee(int id, String first_name, String last_name, String gender, String user_name, String email, String pass_word, String phone_no, Boolean isManager) {
    }

    public Employee(String s, String s1, boolean b) {

    }

    public static int create(Employee employee) {
        return 0;
    }

    //get and set here
        //id
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        //first_name
        public String getFirst_name() {
            return first_name;
        }

         public void setFirst_name(String first_name) {
        this.first_name = first_name;
         }

         //last_name
        public String getLast_name() {
        return last_name;
         }
         public void setLast_name(String last_name) {
         this.last_name = last_name;
         }

         //gender


        public String getGender() {
        return gender;
        }

        public void setGender(String gender) {
        this.gender = gender;
        }

        //user_name
        public String getUser_name() {
        return user_name;
        }
        public void setUser_name(String user_name) {
        this.user_name = user_name;
        }

    //Email
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        //Password
        public String getPass_word(){
            return pass_word;
        }
        public void setPass_word(String pass_word){
            this.pass_word = pass_word;
        }
        //Phone_no
         public String getPhone_no(){
        return phone_no;
        }
        public void setPhone_no(String phone_no){
        this.phone_no = phone_no;
        }

        //isManager
       public boolean getIsManager() {
        return isManager;
        }
        public void setIsManager(boolean isManager) {
        this.isManager = isManager;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", first_name='" + first_name + '\'' +
                    ", last_name='" + last_name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", user_name='" + user_name + '\'' +
                    ", email='" + email + '\'' +
                    ", pass_word='" + pass_word + '\'' +
                    ", phone_no='" + phone_no + '\'' +
                    ", isManager=" + isManager +
                    '}';
        }

}

