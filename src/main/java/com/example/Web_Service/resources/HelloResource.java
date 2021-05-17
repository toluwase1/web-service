////package com.example.Web_Service.resources;
////
////import javax.ws.rs.GET;
////import javax.ws.rs.Path;
////import javax.ws.rs.Produces;
////
////@Path("/hello-world")
////public class HelloResource {
////    @GET
////    @Produces({"text/plain"})
////    public String hello() {
////        return "Hello, World!";
////    }
////
////    @GET
////    @Produces({"application/xml"})
////    public  String greetAsXml () {
////        return "<?xml version = \"1.0\" ?>\n" +
////                "    <greeting>\n" +
////                "        <message>Hello world</message>\n" +
////                "        <from>Toluwase</from>\n" +
////                "    </greeting>";
////    }
////
////    @GET
////    @Produces({"application/json"})
////    public String greetAsJson () {
////        return "{\n" +
////                "        \"message\": \"hello world\",\n" +
////                "        \"from\": \"tolu\"\n" +
////                "    }";
////    }
////
////}
//
//
//package com.example.Web_Service.resources;
//
//import com.example.Web_Service.dao.ContactsDao;
//import com.example.Web_Service.dao.DaoException;
//import com.example.Web_Service.dao.DaoFactory;
//import com.example.Web_Service.entity.Contact;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.Response;
//
//@Path("/contacts")
//public class ContactsResource {
//    private ContactsDao contactsDao;
//
//    public ContactsResource () throws DaoException {
//        contactsDao = DaoFactory.getContactsDao();
//    }
//
////    @GET
////    @Produces({"text/plain"})
////    public String hello() {
////        return "Hello, World!";
////    }
//
//    @GET
//    @Produces({"application/xml"})
//    public  String greetAsXml () {
//        return "<?xml version = \"1.0\" ?>\n" +
//                "    <greeting>\n" +
//                "        <message>Hello world</message>\n" +
//                "        <from>Tolu, xml</from>\n" +
//                "    </greeting>";
//    }
////
////    @GET
////    @Produces({"application/abc"})
////    public  String greetAsABC () {
////        return "<?xml version = \"1.0\" ?>\n" +
////                "    <greeting>\n" +
////                "        <message>Hello world</message>\n" +
////                "        <from>ABC</from>\n" +
////                "    </greeting>";
////    }
//////
////    @GET
////    @Produces({"application/json"})
////    public String greetAsJson () {
////        return "{\n" +
////                "        \"message\": \"hello world\",\n" +
////                "        \"from\": \"tolu, json\"\n" +
////                "    }";
////    }
//
//
//    @GET
//    @Produces({"application/json"})
//    public Response getAllContacts () throws DaoException {
//        return  Response.ok(contactsDao.findAll()).build();
//    }
//
//    @Path("/{contact_id}")
//    @Produces({"application/json"})
//    @GET
//    public Response getOneContact (@PathParam("contact_id") Integer id) throws DaoException {
//        return  Response.ok(contactsDao.findById(id)).build();
//    }
//
//    @POST
//    @Produces({"application/json"})
//    @Consumes({"application/json"})
//    public Response addNewContact(Contact contact) throws DaoException {
//        contact = contactsDao.addContact(contact);
//        return Response.ok(contact).build();
//    }
//}
