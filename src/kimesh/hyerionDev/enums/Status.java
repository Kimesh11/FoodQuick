package kimesh.hyerionDev.enums;

public enum Status {
  // Status enum for order tracking
  PENDING("Order is pending"), PROCESSING("Order is being processed"),
  COMPLETED("Order has been completed"), CANCELLED("Order has been cancelled");

  private String description;

  Status(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
