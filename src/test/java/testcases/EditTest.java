///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package testcases;
//
//import logic.AdminLogic;
//import model.Client;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author ica
// */
//public class EditTest {
//
//    private Client client;
//
//    @BeforeAll
//    public void setUp() throws Exception {
//        client = new Client();
//    }
//
//    @Test
//    public void testLogin_all_valid() {
//        client.setId(1);
//        client.setUsername("client");
//        client.setPassword("client1234");
//        client.setEmail("client@client.com");
//        client.setGender("male");
//        client.setAddress("Kathmandu");
//        client.setPhone("9831231231");
//        client.setCountry("Nepal");
//        client.setFirstname("client");
//        client.setLastname("client");
//
//        AdminLogic ad = new AdminLogic();
//        if (ad.editClient(client)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//
//    @Test
//    public void testLogin_null() {
//        client.setId(0);
//        client.setUsername("");
//        client.setPassword("");
//        client.setEmail("");
//        client.setGender("");
//        client.setAddress("");
//        client.setPhone("");
//        client.setCountry("");
//        client.setFirstname("");
//        client.setLastname("");
//
//        AdminLogic ad = new AdminLogic();
//        if (ad.editClient(client)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//}
