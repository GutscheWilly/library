package handlers;

import exceptions.BookNotAvailableException;
import managers.LoanManager;

public class BookAvailabilityHandler extends LoanBookHandler {
  public LoanManager handleLoan(LoanManager loanManager) {
    if (loanManager.isBookAvailable()) {
      return super.nextHandler.handleLoan(loanManager);
    }

    throw new BookNotAvailableException();
  }
}
