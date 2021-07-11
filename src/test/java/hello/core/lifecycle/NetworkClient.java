package hello.core.lifecycle;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
  private String url;

  public NetworkClient() {
    System.out.println("생성자 호출, url = " + url);
  }

  //서비스 시작 시 호출
  public void connect() {
    System.out.println("connect: " + url);
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void call(String message) {
    System.out.println("call = " + url + " message = " + message);
  }

  //서비스 종료 시 호출
  public void disconnect() {
    System.out.println("close: " + url);
  }

  //BeanFactory에 의해 property가 설정된 뒤 실행되는 메서드
  @PostConstruct
  public void init()  {
    connect();
    call("초기화 연결 메시지");
  }

  //종료 전에 호출
  @PreDestroy
  public void destroy()  {
    disconnect();
  }
}
