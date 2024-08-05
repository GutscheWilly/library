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

  private void verifyLoanValidation(LoanBookHandler loanBookHandler) {
    loanBookHandler.handleLoan(this);
    applyVerifiedLoanSetup();
  }

  private void applyVerifiedLoanSetup() {
    bookManager.setBookAvailabilityToFalse();
    userManager.addLoan(this);
  }

  public Boolean isBookAvailable() {
    return bookManager.isBookAvailable();
  }

  public Integer getUserQuantityOfActiveLoans() {
    return userManager.getUserQuantityOfActiveLoans();
  }

  public Boolean isLoanLate() {
    return loanDateController.isLoanLate();
  }

  public Boolean isUserEligibility() {
    return userManager.isUserEligibility();
  }

  public void giveBackLoan() {
    loanDateController.giveBackLoan();
    userManager.removeLoan(this);
    bookManager.setBookAvailabilityToTrue();
  }

  public void renewLoan() {
    loanDateController.renewLoanEndDate();
  }

  public Boolean notMatchUser(UserManager userManager) {
    return this.userManager != userManager;
  }

  public Boolean notMatchBook(BookManager bookManager) {
    return this.bookManager != bookManager;
  }

  public Boolean notMatchUserOrBook(UserManager userManager, BookManager bookManager) {
    return notMatchUser(userManager) || notMatchBook(bookManager);
  }
}
