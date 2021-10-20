package com.example.demo.enums;

public enum RtvPlanDetailStatus {
  DRAFT(1),
  PUBLISHED_FOR_APPROVAL(2),
  APPROVED(3),
  REJECTED(4);

  private final int value;

  RtvPlanDetailStatus(int value) {
    this.value = value;
  }

  public int getIntValue() {
    return this.value;
  }
}

