package com.example.Web_Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces({"text/plain"})
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces({"application/xml"})
    public  String greetAsXml () {
        return "<?xml version = \"1.0\" ?>\n" +
                "    <greeting>\n" +
                "        <message>Hello world</message>\n" +
                "        <from>Tolu</from>\n" +
                "    </greeting>";
    }

    @GET
    @Produces({"application/json"})
    public String greetAsJson () {
        return "{\n" +
                "        \"message\": \"hello world\",\n" +
                "        \"from\": \"tolu\"\n" +
                "    }";
    }

}