package com.ll.domain.wiseSaying.controller;

import com.ll.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
  private final Scanner scanner;
  private final List<WiseSaying> wiseSayings;
  private int lastId;

  // 생성자 추가
  public WiseSayingController(Scanner scanner) {
    this.scanner = scanner;
    this.wiseSayings = new ArrayList<>();
    this.lastId = 0;
  }

  private WiseSaying addWiseSaying(String content, String author) {
    int id = ++lastId;

    WiseSaying wiseSaying = new WiseSaying(id, content, author);

    wiseSayings.add(wiseSaying);

    return wiseSaying;
  }
  // 액션 함수들
  public void actionAdd() {
    System.out.print("명언 : ");
    String content = scanner.nextLine();
    System.out.print("작가 : ");
    String author = scanner.nextLine();

    WiseSaying wiseSaying = addWiseSaying(content, author);

    System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
  }

  public void actionList() {
    System.out.println("번호 / 작가 / 명언");
    System.out.println("------------------------");

    for (WiseSaying wiseSaying : wiseSayings.reversed()) {
      System.out.println("%d / %s / %s".formatted(wiseSaying.getId(), wiseSaying.getAuthor(), wiseSaying.getContent()));
    }
  }

  public void actionDelete(String cmd) {
    int id = Integer.parseInt(cmd.split("=")[1]);
    boolean removed = wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);

    if (removed) System.out.println("%d번 명언을 삭제했습니다.".formatted(id));
    else System.out.println("%d번 명언은 존재하지 않습니다.".formatted(id));
  }

  public void actionModify(String cmd) {
    int id = Integer.parseInt(cmd.split("=")[1]);

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



