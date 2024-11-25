package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  Scanner scanner;
  int lastId;
  List<WiseSaying> wiseSayings;



  // App 생성자 추가
  public App() {
    scanner = new Scanner(System.in);
    int lastId = 0;
    wiseSayings = new ArrayList<>();

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

  WiseSaying addWiseSaying(String content, String author) {
    int id = ++lastId;

    WiseSaying wiseSaying = new WiseSaying(id, content, author);

    wiseSayings.add(wiseSaying);

    return wiseSaying;
  }

  // 액션 함수들
  void actionAdd() {
    System.out.print("명언 : ");
    String content = scanner.nextLine();
    System.out.print("작가 : ");
    String author = scanner.nextLine();

    WiseSaying wiseSaying = addWiseSaying(content, author);

    System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
  }

  void actionList() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("------------------------");

    for (WiseSaying wiseSaying : wiseSayings.reversed()) {
      System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
    }
  }

}