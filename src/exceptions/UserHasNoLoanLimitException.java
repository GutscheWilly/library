package exceptions;

public class UserHasNoLoanLimitException extends RuntimeException {
  public UserHasNoLoanLimitException() {
    super("User has no remaining loan limit");
  }
}
