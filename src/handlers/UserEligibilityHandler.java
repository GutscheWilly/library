package handlers;

import exceptions.UserNotEligibilityException;
import managers.LoanManager;

public class UserEligibilityHandler extends LoanBookHandler {
  public LoanManager handleLoan(LoanManager loanManager) {
    if (loanManager.isUserEligibility()) {
      return super.nextHandler.handleLoan(loanManager);
    }

    throw new UserNotEligibilityException();
  }
}
