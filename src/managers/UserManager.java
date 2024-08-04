package managers;

import entities.User;
import exceptions.UserNotMatchLoanException;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
  private User user;
  private List<LoanManager> activeLoans = new ArrayList<>();
  private List<LoanManager> loanHistory = new ArrayList<>();

  public UserManager(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public List<LoanManager> getActiveLoans() {
    return activeLoans;
  }

  public List<LoanManager> getLoanHistory() {
    return loanHistory;
  }

  public Integer getQuantityOfActiveLoans() {
    return activeLoans.size();
  }

  public Boolean isUserEligibility() {
    return activeLoans.stream().noneMatch(LoanManager::isLoanLate);
  }

  public void addActiveLoan(LoanManager loanManager) {
    if (loanManager.notMatchUser(this)) {
      throw new UserNotMatchLoanException();
    }

    activeLoans.add(loanManager);
    loanHistory.add(loanManager);
  }

  public void removeActiveLoan(LoanManager loanManager) {
    if (loanManager.notMatchUser(this)) {
      throw new UserNotMatchLoanException();
    }

    activeLoans.remove(loanManager);
  }

  public boolean isBookOnActiveLoans(BookManager bookManager) {
    return activeLoans.stream().anyMatch(loanManager -> loanManager.getBookManager() == bookManager);
  }
}
