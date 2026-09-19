/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package prog5121poe;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */

public class LoginTest {
    
    Login login = new Login();

    // Username Tests
    @Test
    public void testUsernameCorrectlyFormatted() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    // Password Tests
    @Test
    public void testPasswordMeetsRequirements() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testPasswordDoesNotMeetRequirements() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    // Cell Phone Tests
    @Test
    public void testCellPhoneCorrectlyFormatted() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }

    // Login Status Tests
    @Test
    public void testLoginSuccessful() {
        boolean isLoggedIn = login.loginUser("kyl_1", "Ch&&sec@ke99!", "kyl_1", "Ch&&sec@ke99!");
        assertTrue(isLoggedIn);
        
        String expectedMessage = "Welcome Kyl, Smith it is great to see you again.";
        assertEquals(expectedMessage, login.returnLoginStatus(true, "Kyl", "Smith"));
    }

    @Test
    public void testLoginFailed() {
        boolean isLoggedIn = login.loginUser("kyl_1", "WrongPass", "kyl_1", "Ch&&sec@ke99!");
        assertFalse(isLoggedIn);
        
        String expectedMessage = "Username or password incorrect, please try again.";
        assertEquals(expectedMessage, login.returnLoginStatus(false, "Kyl", "Smith"));
    }
}
    

