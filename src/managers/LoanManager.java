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
    this.loanDateController = new LoanDateController();
    verifyLoanValidation(loanBookHandler);
  }

  public BookManager getBookManager() {
    return bookManager;
  }

  private void verifyLoanValidation(LoanBookHandler loanBookHandler) {
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
    loanDateController.giveBackLoan();
    userManager.removeActiveLoan(this);
    bookManager.setBookAvailabilityToTrue();
  }

  public void renewLoan() {
    loanDateController.renewLoanEndDate();
  }

  public boolean notMatchUser(UserManager userManager) {
    return this.userManager != userManager;
  }

  public boolean notMatchBook(BookManager bookManager) {
    return this.bookManager != bookManager;
  }

  public boolean notMatchUserBook(UserManager userManager, BookManager bookManager) {
    return notMatchUser(userManager) || notMatchBook(bookManager);
  }
}
