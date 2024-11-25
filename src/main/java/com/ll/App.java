package com.ll;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

  private final Scanner scanner;
  private int lastId;
  private final List<WiseSaying> wiseSayings;


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
      } else if (cmd.startsWith("삭제?id=")) {
        int id = Integer.parseInt(cmd.split("=")[1]);

        actionDelete(id);
      } else if (cmd.startsWith("수정?id=")) {
        int id = Integer.parseInt(cmd.split("=")[1]);

        actionModify(id);
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

  private void actionList() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("------------------------");

    for (WiseSaying wiseSaying : wiseSayings.reversed()) {
      System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
    }
  }

  private void actionDelete(int id) {
    boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

    if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
    else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
  }

  private void actionModify(int id) {
    WiseSaying foundWiseSaying = null;

    for (WiseSaying wiseSaying : wiseSayings) {
      if (wiseSaying.getId() == id) {
        foundWiseSaying = wiseSaying;
        break;
      }
    }

    if (foundWiseSaying == null) {
      System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
      return;
    }

    System.out.println("명언(기존) : %s".formatted(foundWiseSaying.getContent()));
    System.out.print("명언 : ");
    String content = scanner.nextLine();

    System.out.println("작가(기존) : %s".formatted(foundWiseSaying.getAuthor()));
    System.out.print("작가 : ");
    String author = scanner.nextLine();

    foundWiseSaying.setContent(content);
    foundWiseSaying.setAuthor(author);

    System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
  }
}