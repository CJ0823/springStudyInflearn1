package hello.core.singleton;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonService {

  //자바 실행 시 static 영역에 미리 instance를 생성해놓는다.
  private static final SingletonService instance = new SingletonService();

  //생성자가 private 이라서 외부에서 new 키워드를 통해서 객체를 생성할 수 없다.
  private SingletonService() {
  }

  //생성은 못하지만, 조회는 되도록 public으로 메소드를 열어둔다.
  public static SingletonService getInstance() {
    return instance;
  }

  public void print() {
    System.out.println("싱글톤 객체 호출");
  }

  @Test
  @DisplayName("같은 인스턴스인지 확인")
  void sameInstance() {
    SingletonService instance1 = SingletonService.getInstance();
    SingletonService instance2 = SingletonService.getInstance();

    System.out.println("instance1 = " + instance1);
    System.out.println("instance2 = " + instance2);
  }
}
