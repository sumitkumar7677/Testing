package org.example;

public class Employee {
    public static void main (String [] args){
        mysqlConn Operations = new mysqlConn();
        Operations.createDatabase("TestingDb");
        Operations.createTable("TestinggDb", "Employee_Detail");
    }
}


