package managers;

import entities.Book;
import factories.LoanBookHandlerFactory;
import handlers.LoanBookHandler;
import utils.AvailabilityController;

public class BookManager {
  private Book book;
  private AvailabilityController availabilityController;

  public BookManager(Book book) {
    this.book = book;
    availabilityController = new AvailabilityController();
  }

  public BookManager(Book book, Boolean available) {
    this.book = book;
    availabilityController = new AvailabilityController(available);
  }

  public LoanManager loanBook(UserManager userManager) {
    LoanBookHandler loanBookHandler = LoanBookHandlerFactory.getInstance();
    return new LoanManager(userManager, this, loanBookHandler);
  }

  public Boolean isBookAvailable() {
    return availabilityController.isAvailable();
  }

  public void setBookAvailabilityToFalse() {
    availabilityController.setAvailable(false);
  }

  public void setBookAvailabilityToTrue() {
    availabilityController.setAvailable(true);
  }
}
