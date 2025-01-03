package com.ll.domain.wiseSaying.entity;

public class WiseSaying {
  private int id;
  private String content;
  private String author;

  // 생성자 추가
  public WiseSaying(int id, String content, String author) {
    this.id = id;
    this.content = content;
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public String getAuthor() {
    return author;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  // 목록 내용 확인용
  @Override
  public String toString() {
    return "WiseSaying (id=%d, content=\"%s\", author=\"%s\")".formatted(id, content, author);
  }

}
