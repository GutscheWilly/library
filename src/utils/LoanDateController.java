package utils;

import config.ConfigurationManager;

import java.time.LocalDate;

public class LoanDateController {
  private LocalDate loanStartDate;
  private LocalDate loanEndDate;
  private LocalDate loanReturnedDate;

  public LoanDateController() {
    loanStartDate = LocalDate.now();
    loanEndDate = loanStartDate.plusDays(ConfigurationManager.getBaseLoanTimeInDays());
  }

  public LocalDate getLoanStartDate() {
    return loanStartDate;
  }

  public LocalDate getLoanEndDate() {
    return loanEndDate;
  }

  public LocalDate getLoanReturnedDate() {
    return loanReturnedDate;
  }

  private void setLoanEndDate(LocalDate loanEndDate) {
    this.loanEndDate = loanEndDate;
  }

  private void setLoanReturnedDate(LocalDate loanReturnedDate) {
    this.loanReturnedDate = loanReturnedDate;
  }

  public Boolean isLoanReturned() {
    return loanReturnedDate != null;
  }

  public Boolean isLoanLate() {
    LocalDate currentDate = LocalDate.now();

    if (currentDate.isAfter(loanEndDate)) {
      return !isLoanReturned();
    }

    return false;
  }

  public void giveBackLoan() {
    if (isLoanReturned()) {
      throw new RuntimeException("Loan is already returned");
    }

    setLoanReturnedDate(LocalDate.now());
  }

  public void renewLoanEndDate() {
    if (isLoanReturned()) {
      throw new RuntimeException("Loan is already returned");
    }

    if (isLoanLate()) {
      throw new RuntimeException("Loan is late. So, you can't renew it");
    }

    LocalDate renewedLoanEndDate = loanEndDate.plusDays(ConfigurationManager.getBaseLoanTimeInDays());

    setLoanEndDate(renewedLoanEndDate);
  }
}
