package managers;

import entities.User;
import utils.LoansController;

public class UserManager {
  private User user;
  private LoansController loansController;

  public UserManager(User user) {
    this.user = user;
    this.loansController = new LoansController();
  }

  public UserManager(User user, LoansController loansController) {
    this.user = user;
    this.loansController = loansController;
  }

  public User getUser() {
    return user;
  }

  public void addLoan(LoanManager loanManager) {
    loansController.addActiveLoan(loanManager);
  }

  public Integer getUserQuantityOfActiveLoans() {
    return loansController.getQuantityOfActiveLoans();
  }

  public Boolean isUserEligibility() {
    return loansController.areActiveLoansEligibility();
  }

  public void removeLoan(LoanManager loanManager) {
    loansController.removeActiveLoan(loanManager);
  }
}
