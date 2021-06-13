package hello.core.creature;

public class Creature {

  private Long id;
  private String name;
  private int weight;
  private Grade grade;

  public Creature(Long id, String name, int weight, Grade grade) {
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.grade = grade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public Grade getGrade() {
    return grade;
  }

  public void setGrade(Grade grade) {
    this.grade = grade;
  }
}
