package exceptions;

public class LoanAlreadyReturnedException extends RuntimeException {
  public LoanAlreadyReturnedException() {
    super("Loan is already returned");
  }
}
