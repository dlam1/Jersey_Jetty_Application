package org.dlam.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.dlam.User;

import java.util.ArrayList;
import java.util.List;

@Path("/")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Jersey Jetty example.";
    }

    @Path("/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User hello(@PathParam("username") String name) {

        User obj = new User();
        obj.setId(0);
        obj.setName(name);

        return obj;

    }

    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> helloList() {

        List<User> list = new ArrayList<>();

        User obj1 = new User();
        obj1.setId(1);
        obj1.setName("mkyong");
        list.add(obj1);

        User obj2 = new User();
        obj2.setId(2);
        obj2.setName("zilap");
        list.add(obj2);

        return list;

    }

    @Path("/htmllist")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String htmlList() {

        return "<html><body><h2>Hello World</h2>" +
               // "<style> table {border: 1px solid black;} td {border: 1px solid black;}</style>" +
                "<table>" +
                "    <tr>" +
                "        <th>Player</th>" +
                "        <th>Gloobles</th>" +
                "        <th>Za'taak</th>" +
                "    </tr>" +
                "    <tr>" +
                "        <td >TR-7</th>" +
                "        <td>7</td>" +
                "        <td>4,569</td>" +
                "    </tr>" +
                "    <tr>" +
                "        <td>Khiresh Odo</th>" +
                "        <td>7</td>" +
                "        <td>7,223</td>" +
                "    </tr>" +
                "    <tr>" +
                "        <td>Mia Oolong</th>" +
                "        <td>9</td>" +
                "        <td>6,219</td>" +
                "    </tr></td>" +
                "</table>" +
                "<link rel=\"stylesheet\" href=\"http://localhost:8080/files/css/styles.css\">" +
                "</body></html>";

    }


}
