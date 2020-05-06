///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package testcases;
//
//import logic.AdminLogic;
//import model.Admin;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author ica
// */
//public class ChangePasswordTest {
//
//    private Admin admin;
//
//    @BeforeAll
//    public void setUp() throws Exception {
//        admin = new Admin();
//    }
//
//    @Test
//    public void testLogin_valid_both() {
//        admin.setOldPassword("admin1234");
//        admin.setPassword("admin4312");
//        AdminLogic ad = new AdminLogic();
//        if (ad.changePassword(admin)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//      @Test
//    public void testLogin_null() {
//        admin.setOldPassword("");
//        admin.setPassword("");
//        AdminLogic ad = new AdminLogic();
//        if (ad.changePassword(admin)) {
//            assertTrue(true);
//        } else {
//            assertTrue(false);
//        }
//    }
//
//}
