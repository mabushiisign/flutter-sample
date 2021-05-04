package com.mabushiisign.flutter_sample.api.application.service;

import java.util.List;
import javax.inject.Singleton;
import com.mabushiisign.flutter_sample.api.domain.Book;
import com.mabushiisign.flutter_sample.api.domain.BookFilter;
import lombok.extern.java.Log;

@Singleton
@Log
public class BookService {

  public List<Book> find(BookFilter filter) {
    log.info("filter:" + filter.toString());
    return List.of(
        Book.builder()
            .id("123")
            .title("MyBook")
            .price(1000)
            .build(),
        Book.builder()
            .id("1234")
            .title("Your Book")
            .price(2500)
            .build());
  }
}
