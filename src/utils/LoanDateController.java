package utils;

import config.ConfigurationManager;
import exceptions.LoanAlreadyReturnedException;
import exceptions.LoanLateException;

import java.time.LocalDate;

public class LoanDateController {
  private LocalDate loanStartDate;
  private LocalDate loanEndDate;
  private LocalDate loanReturnedDate;

  public LoanDateController() {
    this.loanStartDate = LocalDate.now();
    this.loanEndDate = loanStartDate.plusDays(ConfigurationManager.getBaseLoanTimeInDays());
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
      throw new LoanAlreadyReturnedException();
    }

    setLoanReturnedDate(LocalDate.now());
  }

  public void renewLoanEndDate() {
    if (isLoanReturned()) {
      throw new LoanAlreadyReturnedException();
    }

    if (isLoanLate()) {
      throw new LoanLateException();
    }

    LocalDate renewedLoanEndDate = loanEndDate.plusDays(ConfigurationManager.getBaseLoanTimeInDays());
    setLoanEndDate(renewedLoanEndDate);
  }
}
