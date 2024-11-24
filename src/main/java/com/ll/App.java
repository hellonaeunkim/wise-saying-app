package com.ll;

import java.util.Scanner;

public class App {

  Scanner scanner;
  int lastId;


  // App 생성자 추가
  public App() {
    scanner = new Scanner(System.in);
    int lastId = 0;

  }

  public void run() {
    System.out.println("== 명언 앱 ==");

    while (true) {
      System.out.print("명령 ) ");
      String cmd = scanner.nextLine();

      if (cmd.equals("종료")) {
        break;
      } else if (cmd.equals("등록")) {
        actionAdd();
      } else if (cmd.equals("목록")) {
        actionList();
      }
    }
    scanner.close();
  }

  void actionAdd() {
    System.out.println("명언 : ");
    String content = scanner.nextLine();
    System.out.print("작가 : ");
    String author = scanner.nextLine();
    int id = ++lastId;
  }

  void actionList() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("------------------------");

  }

}