package mediators;

import factories.LoanBookHandlerFactory;
import handlers.LoanBookHandler;
import managers.BookManager;
import managers.LoanManager;
import managers.UserManager;

public class LibraryMediator {
  private UserManager userManager;

  public LibraryMediator(UserManager userManager) {
    this.userManager = userManager;
  }

  public LoanManager loanBook(BookManager bookManager) {
    LoanBookHandler loanBookHandler = LoanBookHandlerFactory.getInstance();
    return new LoanManager(userManager, bookManager, loanBookHandler);
  }
}
