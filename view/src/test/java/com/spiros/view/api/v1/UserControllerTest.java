package com.spiros.view.api.v1;

import com.spiros.common.model.City;
import com.spiros.common.model.User;
import com.spiros.core.service.CityService;
import com.spiros.core.service.UserService;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private CityService cityService;

    @Test
    void findUserByUsername_whenUserNotExists_thenThrowExceptionWithRightMessage() {
        Exception exception = assertThrows(Exception.class, () ->
                mvc.perform(get("/api/v1/user/username/someNonExistedUser")));

        String expectedMessage = "User not found, please specify an existing user";

        assertTrue(exception.getMessage().contains(expectedMessage));
    }

    @Test
    void findUserByUsername_whenUserExists_thenGetUserAsJson() throws Exception {

        City city = new City();
        city.setName("Corfu");
        city = cityService.saveCity(city).get();

        User user = new User();
        user.setFirstName("Deep");
        user.setLastName("Purple");
        user.setUsername("deep_purple");
        user.setCity(city);
        userService.saveUser(user);

        mvc.perform(get("/api/v1/user/username/deep_purple")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName", Is.is("Deep")))
                .andExpect(jsonPath("$.lastName", Is.is("Purple")))
                .andExpect(jsonPath("$.username", Is.is("deep_purple")))
                .andExpect(jsonPath("$.city.name", Is.is("Corfu")));

    }

}