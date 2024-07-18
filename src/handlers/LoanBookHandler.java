package handlers;

import managers.LoanManager;

public abstract class LoanBookHandler {
  protected LoanBookHandler nextHandler;

  public LoanBookHandler setNextHandler(LoanBookHandler nextHandler) {
    this.nextHandler = nextHandler;
    return nextHandler;
  }

  public LoanManager handleLoan(LoanManager loanManager) {
    if (nextHandler == null) {
      return loanManager;
    }

    return nextHandler.handleLoan(loanManager);
  }
}
