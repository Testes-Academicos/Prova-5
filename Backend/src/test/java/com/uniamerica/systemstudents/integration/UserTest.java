//package com.uniamerica.systemstudents.integration;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.uniamerica.systemstudents.repository.UserRepository;
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//public class UserTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    String url = "/api/v1";
//
//    @Test
//    void getAllUsers() throws Exception {
//        String url = "/contactos";
//        mockMvc.perform(
//                MockMvcRequestBuilders.get(url)
//        ).andExpect(status().isOk());
//    }
//}
