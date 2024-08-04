package exceptions;

public class UserNotEligibilityException extends RuntimeException {
  public UserNotEligibilityException() {
    super("User is not eligibility");
  }
}
