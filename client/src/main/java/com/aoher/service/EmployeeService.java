package com.aoher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.HttpMethod;

import static com.aoher.util.ServiceEndpoint.*;

public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final String username;
    private final String password;

    public EmployeeService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getEmployeesJSON() {
        BufferedReader reader = connect(GET_EMPLOYEES_JSON, HttpMethod.GET);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String getEmployeesXML() {
        BufferedReader reader = connect(GET_EMPLOYEES_XML, HttpMethod.GET);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String getEmployeeByIdJSON(String id) {
        BufferedReader reader = connect(GET_EMPLOYEES_BY_ID_JSON + id, HttpMethod.GET);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String getEmployeeByIdXML(String id) {
        BufferedReader reader = connect(GET_EMPLOYEES_BY_ID_XML + id, HttpMethod.GET);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String addEmployee(String name, String address) {
        BufferedReader reader = connect(
                getURI(ADD_EMPLOYEE, name, address), HttpMethod.POST);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String updateEmployee(String id, String name, String address) {
        BufferedReader reader = connect(
                getURI(UPDATE_EMPLOYEE, id, name, address), HttpMethod.PUT
        );
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    public String deleteEmployeeById(String id) {
        BufferedReader reader = connect(DELETE_EMPLOYEE + id, HttpMethod.DELETE);
        if (reader != null) {
            try {
                String message = IOUtils.toString(reader);
                reader.close();

                log.info(message);
                return message;
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return null;
    }

    private BufferedReader connect(String serviceName, String httpMethod) {
        try {
            URL url = new URL(serviceName);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(httpMethod);
            connection.setDoOutput(true);
            connection.setRequestProperty("Authorization", String.format("Basic %s", encode()));
            InputStream content = connection.getInputStream();
            return new BufferedReader(new InputStreamReader(content));
        } catch (Exception e) {
            log.error("Please input the service name correctly!");
            log.error(e.getMessage());
        }
        return null;
    }

    private String encode() {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    }

    private String getURI(String url, String... params) {
        String param = String.join("/", params);
        return url + param.replace(" ", "%20");
    }
}
