package handlers;

import managers.LoanManager;

public class UserEligibilityHandler extends LoanBookHandler {
  public LoanManager handleLoan(LoanManager loanManager) {
    if (loanManager.isUserEligibility()) {
      return super.nextHandler.handleLoan(loanManager);
    }

    throw new RuntimeException("User is not eligibility");
  }
}
