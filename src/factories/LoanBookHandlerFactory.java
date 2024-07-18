package factories;

import handlers.BookAvailabilityHandler;
import handlers.LoanBookHandler;
import handlers.LoanLimitHandler;
import handlers.UserEligibilityHandler;

public class LoanBookHandlerFactory {
  public static LoanBookHandler getInstance() {
    LoanBookHandler firstHandler = new BookAvailabilityHandler();

    firstHandler
        .setNextHandler(new UserEligibilityHandler())
        .setNextHandler(new LoanLimitHandler());

    return firstHandler;
  }
}
