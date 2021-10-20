package com.example.demo.enums;

public enum RtvPlanStatus {
  DRAFT(1),
  PUBLISHED_FOR_APPROVAL(2),
  PARTIALLY_APPROVED(3),
  APPROVED(4),
  PARTIALLY_REJECTED(5),
  REJECTED(6),
  CANCELLED(7),
  RO_CREATED(8),
  PARTIAL_RO_CREATED(9);

  private final int value;

  RtvPlanStatus(int value) {
    this.value = value;
  }

  public int getIntValue() {
    return this.value;
  }
}