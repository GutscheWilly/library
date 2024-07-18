package managers;

import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
  private User user;
  private List<LoanManager> activeLoans = new ArrayList<>();
  private List<LoanManager> loanHistory = new ArrayList<>();

  public UserManager(User user) {
    this.user = user;
  }

  public Integer getQuantityOfActiveLoans() {
    return activeLoans.size();
  }

  public Boolean isUserEligibility() {
    return activeLoans.stream().noneMatch(LoanManager::isLoanLate);
  }

  public void addActiveLoan(LoanManager loanManager) {
    activeLoans.add(loanManager);
    loanHistory.add(loanManager);
  }

  public void removeActiveLoan(LoanManager loanManager) {
    activeLoans.remove(loanManager);
  }
}
