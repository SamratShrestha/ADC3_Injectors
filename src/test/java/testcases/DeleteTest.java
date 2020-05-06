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
//public class DeleteTest {
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
//
//        AdminLogic ad = new AdminLogic();
//        if (ad.deleteClient(client)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//
//    @Test
//    public void testLogin_null() {
//        client.setId(0);
//        AdminLogic ad = new AdminLogic();
//        if (ad.deleteClient(client)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//}
