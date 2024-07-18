package handlers;

import config.ConfigurationManager;
import managers.LoanManager;

public class LoanLimitHandler extends LoanBookHandler {
  public LoanManager handleLoan(LoanManager loanManager) {
    if (loanManager.getUserQuantityOfActiveLoans() < ConfigurationManager.getUserLoanLimit()) {
      return super.handleLoan(loanManager);
    }

    throw new RuntimeException("User has no remaining loan limit");
  }
}
