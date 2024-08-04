package exceptions;

public class UserNotMatchLoanException extends RuntimeException {
  public UserNotMatchLoanException() {
    super("User not match with loan");
  }
}
