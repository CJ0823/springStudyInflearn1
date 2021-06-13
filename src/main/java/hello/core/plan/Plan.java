package hello.core.plan;

public class Plan {

  private Long creatureId;
  private int expense;
  private int totalExpense;

  public Plan(Long creatureId, int expense, int totalExpense) {
    this.creatureId = creatureId;
    this.expense = expense;
    this.totalExpense = totalExpense;
  }

  public Long getCreatureId() {
    return creatureId;
  }

  public void setCreatureId(Long creatureId) {
    this.creatureId = creatureId;
  }

  public int getTotalExpense() {
    return expense;
  }

  public void setTotalExpense(int expense) {
    this.expense = expense;
  }

  public int getExpense() {
    return expense;
  }

  public void setExpense(int expense) {
    this.expense = expense;
  }

  @Override
  public String toString() {
    return "Plan{" +
        "creatureId=" + creatureId +
        ", expense=" + expense +
        ", totalExpense=" + totalExpense +
        '}';
  }
}
