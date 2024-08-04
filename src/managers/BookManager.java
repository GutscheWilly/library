package managers;

import entities.Book;
import mediators.LibraryMediator;
import utils.AvailabilityController;

public class BookManager {
  private Book book;
  private AvailabilityController availabilityController;

  public BookManager(Book book) {
    this.book = book;
    this.availabilityController = new AvailabilityController();
  }

  public BookManager(Book book, Boolean available) {
    this.book = book;
    this.availabilityController = new AvailabilityController(available);
  }

  public LoanManager loanBook(LibraryMediator libraryMediator) {
    return libraryMediator.loanBook(this);
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
