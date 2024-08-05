package utils;

import managers.LoanManager;

import java.util.ArrayList;
import java.util.List;

public class LoansController {
  private List<LoanManager> activeLoans = new ArrayList<>();
  private List<LoanManager> loanHistory = new ArrayList<>();

  public LoansController() {}

  public LoansController(List<LoanManager> activeLoans, List<LoanManager> loanHistory) {
    this.activeLoans = activeLoans;
    this.loanHistory = loanHistory;
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

  public Boolean areActiveLoansEligibility() {
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
