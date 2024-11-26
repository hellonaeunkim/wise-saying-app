package com.ll;

import com.ll.domain.wiseSaying.controller.WiseSayingController;
import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  private final Scanner scanner;
  private int lastId;
  private final List<WiseSaying> wiseSayings;
  private final WiseSayingController wiseSayingController;


  // App 생성자 추가
  public App() {
    scanner = new Scanner(System.in);
    int lastId = 0;
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
        actionAdd();
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

  private WiseSaying addWiseSaying(String content, String author) {
    int id = ++lastId;

    WiseSaying wiseSaying = new WiseSaying(id, content, author);

    wiseSayings.add(wiseSaying);

    return wiseSaying;
  }

  // 액션 함수들
  private void actionAdd() {
    System.out.print("명언 : ");
    String content = scanner.nextLine();
    System.out.print("작가 : ");
    String author = scanner.nextLine();

    WiseSaying wiseSaying = addWiseSaying(content, author);

    System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
  }

}