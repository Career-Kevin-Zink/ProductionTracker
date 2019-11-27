package io.github.zinkmk.product;

/**
 * @author Kevin Zink We made this class to play with the logic behind the employee tab, mainly to
 * generate it's password/Username.
 */
class Employee {
    private final StringBuilder name;
    private String username;
    private String password;
    private String email;

    /**
     * Constructor, calls checkName and IsValidPassword.
     *
     * @param name     name of the employee
     * @param password password the employee is obtaining
     */
    public Employee(String name, String password) {
        this.name = new StringBuilder(name);
        checkName(this.name);
        isValidPassword(password);
    }

    /**
     * Checks username then sets it to one of the two possibilities
     *
     * @param name name of the employee
     */
    private void setUsername(StringBuilder name) {
        String temp = name.toString().toLowerCase();
        this.username = temp.charAt(0) + temp.substring(name.indexOf(" ") + 1);
    }

    /**
     * Really just puts @oracleacademy.Test at the end and says "he he that's the email"
     *
     * @param name name of the employee
     */
    private void setEmail(StringBuilder name) {
        this.email = name.toString().toLowerCase().replace(" ", ".") + "@oracleacademy.Test";
    }

    /**
     * Uses a regular expression to make sure we have a-Z and !@#$%^&* specifically one of each. If it
     * doesn't find a match then it sets the password to "pw"
     *
     * @param password password the employee is obtaining
     */
    private void isValidPassword(String password) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).+$")) {
            this.password = password;
        }
        this.password = "pw";
    }

    /**
     * Checks for a space in the username and if it doesn't find one sets it to default / user
     *
     * @param name name of the employee
     */
    private void checkName(StringBuilder name) {

        if (name.toString().indexOf(" ") != -1) {
            setUsername(name);
            setEmail(name);
        } else {
            this.username = "default";
            this.email = "user@oracleacademy.Test";
        }
    }

    /**
     * Yes, Another toString this shows up in Employee tabs view
     *
     * @return returns the text we want as a part of our toString
     */
    public String toString() {
        return "Employee Details\nName : "
                + name
                + "\nUsername : "
                + username
                + "\nEmail : "
                + email
                + "\nInitial Password : "
                + password;
    }
}
