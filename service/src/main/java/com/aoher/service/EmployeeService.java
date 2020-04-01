package com.aoher.service;

import com.aoher.bean.EmployeeBean;
import com.aoher.config.Config;
import com.aoher.model.Employee;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("employee")
public class EmployeeService extends Config {

    private static final String STATUS_OK = "{\"status\":\"ok\"}";

    @EJB
    private EmployeeBean employeeBean;

    @GET
    @Path("getEmployeeByIdJSON/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeByIdJSON(@PathParam("id") String id) {
        return employeeBean.getEmployeeById(id);
    }

    @GET
    @Path("getEmployeeIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Employee getEmployeeByIdXML(@PathParam("id") String id) {
        return employeeBean.getEmployeeById(id);
    }

    @GET
    @Path("getEmployeesJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeesJSON() {
        return employeeBean.getEmployees();
    }

    @GET
    @Path("getEmployeesXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Employee> getEmployeesXML() {
        return employeeBean.getEmployees();
    }

    @POST
    @Path("addEmployee/{name}/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee(@PathParam("name") String name,
                              @PathParam("address") String address) {
        employeeBean.addEmployee(name, address);
        return STATUS_OK;
    }

    @PUT
    @Path("updateEmployee/{id}/{name}/{address}")
    @Produces(MediaType.APPLICATION_JSON)
    public String updateEmployee(@PathParam("id") String id,
                                 @PathParam("name") String name,
                                 @PathParam("address") String address) {
        employeeBean.updateEmployee(id, name, address);
        return STATUS_OK;
    }

    @DELETE
    @Path("deleteEmployeeById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteEmployeeById(@PathParam("id") String id) {
        employeeBean.deleteEmployee(id);
        return STATUS_OK;
    }

}
