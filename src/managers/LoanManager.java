package managers;

import handlers.LoanBookHandler;
import utils.LoanDateController;

public class LoanManager {
  private UserManager userManager;
  private BookManager bookManager;
  private LoanDateController loanDateController;

  public LoanManager(UserManager userManager, BookManager bookManager, LoanBookHandler loanBookHandler) {
    this.userManager = userManager;
    this.bookManager = bookManager;
    loanDateController = new LoanDateController();

    loanBookHandler.handleLoan(this);
    applyVerifiedLoanSetup();
  }

  private void applyVerifiedLoanSetup() {
    bookManager.setBookAvailabilityToFalse();
    userManager.addActiveLoan(this);
  }

  public Boolean isBookAvailable() {
    return bookManager.isBookAvailable();
  }

  public Integer getUserQuantityOfActiveLoans() {
    return userManager.getQuantityOfActiveLoans();
  }

  public Boolean isLoanLate() {
    return loanDateController.isLoanLate();
  }

  public Boolean isUserEligibility() {
    return userManager.isUserEligibility();
  }

  public void giveBackLoan() {

  }
}
