package handlers;

import config.ConfigurationManager;
import exceptions.UserHasNoLoanLimitException;
import managers.LoanManager;

public class LoanLimitHandler extends LoanBookHandler {
  public LoanManager handleLoan(LoanManager loanManager) {
    if (loanManager.getUserQuantityOfActiveLoans() < ConfigurationManager.getUserLoanLimit()) {
      return super.handleLoan(loanManager);
    }

    throw new UserHasNoLoanLimitException();
  }
}
