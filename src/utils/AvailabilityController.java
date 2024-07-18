package utils;

public class AvailabilityController {
  private Boolean available;

  public AvailabilityController() {
    available = true;
  }

  public AvailabilityController(Boolean available) {
    this.available = available;
  }

  public Boolean isAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }
}
