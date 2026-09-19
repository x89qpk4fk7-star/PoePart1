package prog5121poe;  // IMPORTANT: Change this to match your actual package name

import java.util.regex.Pattern;

/**
 * The Login class handles all user authentication logic, including
 * username, password, and cell phone number validation.
 * 
 * @author Your Name (Student Number)
 * @version 1.0
 */
public class main{

    /**
     * Validates the username based on the required criteria.
     * The username must contain an underscore (_) and be no more than 5 characters long.
     * 
     * @param username The username entered by the user.
     * @return true if the username is valid, false otherwise.
     */
    public boolean checkUserName(String username) {
        // Basic null check to prevent crashes
        if (username == null) {
            return false;
        }
        // Check for underscore and length constraint
        return username.contains("_") && username.length() <= 5;
    }

    /**
     * Validates the password complexity.
     * The password must be at least 8 characters long, contain a capital letter, 
     * a number, and a special character.
     * 
     * @param password The password entered by the user.
     * @return true if the password meets all criteria, false otherwise.
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        // Loop through each character to check the conditions
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }

        // All three conditions must be met
        return hasCapital && hasNumber && hasSpecial;
    }

    /**
     * Validates the South African cell phone number.
     * It must contain the international country code (+27) and be no more than 10 digits long.
     * 
     * Reference: Oracle. (2023). Pattern (Java Platform SE 8). [online] 
     * Available at: https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html 
     * [Accessed 20 May 2024].
     * 
     * @param cellNumber The cell phone number entered by the user.
     * @return true if the number is correctly formatted, false otherwise.
     */
    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        
        // Regex explanation: 
        // ^\\+27 : Starts with +27
        // [0-9]{9,10}$ : Followed by 9 or 10 digits. 
        // (This ensures the total length is either 12 or 13 characters, 
        // which fits the "international code followed by number" criteria)
        String regex = "^\\+27[0-9]{9,10}$";
        
        // Using Pattern.matches() to test the string against the regex
        return Pattern.matches(regex, cellNumber);
    }

    /**
     * Registers the user by validating all inputs and returning the appropriate message.
     * 
     * @param username The chosen username.
     * @param password The chosen password.
     * @param cellNumber The user's cell phone number.
     * @return A string message indicating success or the specific validation error.
     */
    public String registerUser(String username, String password, String cellNumber) {
        // Check username first
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        // Check password second
        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        
        // Check cell phone number last
        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
        
        // If all checks pass, return the success message
        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    /**
     * Verifies if the login details match the stored credentials.
     * 
     * @param enteredUsername The username entered during login.
     * @param enteredPassword The password entered during login.
     * @param storedUsername The username saved during registration.
     * @param storedPassword The password saved during registration.
     * @return true if credentials match, false otherwise.
     */
    public boolean loginUser(String enteredUsername, String enteredPassword, String storedUsername, String storedPassword) {
        // Using .equals() for string comparison, not ==
        return enteredUsername.equals(storedUsername) && enteredPassword.equals(storedPassword);
    }

    /**
     * Returns a welcome or error message based on the login status.
     * 
     * @param isLoggedIn Boolean indicating if login was successful.
     * @param firstName The user's first name.
     * @param lastName The user's last name.
     * @return A string containing the appropriate login status message.
     */
    public String returnLoginStatus(boolean isLoggedIn, String firstName, String lastName) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}