package exceptions;

public class LoanLateException extends RuntimeException {
  public LoanLateException() {
    super("Loan is late");
  }
}
