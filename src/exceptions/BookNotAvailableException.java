package exceptions;

public class BookNotAvailableException extends RuntimeException {
  public BookNotAvailableException() {
    super("Book is not available");
  }
}
