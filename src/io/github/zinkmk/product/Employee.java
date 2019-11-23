package io.github.zinkmk.product;

public class Employee {
  StringBuilder name;
  String username;
  String password;
  String email;

  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    checkName(this.name);
    isValidPassword(password);
  }

  private void setUsername(StringBuilder name) {
    String temp = name.toString().toLowerCase();
    this.username = temp.charAt(0) + temp.substring(name.indexOf(" ") + 1);
  }

  private void setEmail(StringBuilder name) {
    this.email = name.toString().toLowerCase().replace(" ", ".") + "@oracleacademy.Test";
  }

  private boolean isValidPassword(String password) {
    if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).+$")) {
      this.password = password;
      return true;

    }
    this.password = "pw";
    return false;
  }

  private boolean checkName(StringBuilder name) {

    if (name.toString().indexOf(" ") != -1) {
      setUsername(name);
      setEmail(name);
      return false;
    } else {
      this.username = "default";
      this.email = "user@oracleacademy.Test";
      return true;
    }
  }

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
