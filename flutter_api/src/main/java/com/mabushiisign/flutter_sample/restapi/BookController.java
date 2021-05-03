package com.mabushiisign.flutter_sample.restapi;

import java.util.List;

import com.mabushiisign.flutter_sample.domain.Book;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/book")
public class BookController {

  /**
   * 本一覧を取得
   * 
   * @return 本一覧
   */
  @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
  public List<Book> list() {
    return List.of(Book.builder().id("123").title("MyBook").price(1000).build());
  }
}
