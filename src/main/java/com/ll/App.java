package com.ll;

import com.ll.domain.wiseSaying.controller.WiseSayingController;
import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  private final Scanner scanner;
  private final List<WiseSaying> wiseSayings;
  private final WiseSayingController wiseSayingController;


  // App 생성자 추가
  public App() {
    scanner = new Scanner(System.in);
    wiseSayings = new ArrayList<>();
    wiseSayingController = new WiseSayingController();

  }

  public void run() {
    System.out.println("== 명언 앱 ==");

    while (true) {
      System.out.print("명령 ) ");
      String cmd = scanner.nextLine();

      if (cmd.equals("종료")) {
        break;
      } else if (cmd.equals("등록")) {
        wiseSayingController.actionAdd(scanner, wiseSayings);
      } else if (cmd.equals("목록")) {
        wiseSayingController.actionList(wiseSayings);
      } else if (cmd.startsWith("삭제?id=")) {
        wiseSayingController.actionDelete(wiseSayings, cmd);
      } else if (cmd.startsWith("수정?id=")) {
        wiseSayingController.actionModify(scanner, wiseSayings, cmd);
      }
    }
    scanner.close();
  }
}


