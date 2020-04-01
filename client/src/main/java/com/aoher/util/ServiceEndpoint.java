package com.aoher.util;

public class ServiceEndpoint {

    public static final String GET_EMPLOYEES_JSON = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesJSON";
    public static final String GET_EMPLOYEES_XML = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeesXML";
    public static final String GET_EMPLOYEES_BY_ID_JSON = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdJSON/";
    public static final String GET_EMPLOYEES_BY_ID_XML = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/getEmployeeByIdXML/";
    public static final String ADD_EMPLOYEE = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/addEmployee/";
    public static final String UPDATE_EMPLOYEE = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/updateEmployee/";
    public static final String DELETE_EMPLOYEE = "http://localhost:8080/REST-EJB-JPA-1.0-SNAPSHOT/resources/employee/deleteEmployeeById/";;

    private ServiceEndpoint() {
    }
}
