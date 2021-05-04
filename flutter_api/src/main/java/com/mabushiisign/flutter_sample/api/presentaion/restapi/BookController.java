package com.mabushiisign.flutter_sample.api.presentaion.restapi;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.mabushiisign.flutter_sample.api.application.service.BookService;
import com.mabushiisign.flutter_sample.api.domain.Book;
import com.mabushiisign.flutter_sample.api.domain.BookFilter;
import com.mabushiisign.flutter_sample.api.presentaion.restapi.form.BookFindForm;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

@Controller("/api/book")
public class BookController {

  private BookService bookService;

  public BookController(BookService bookService) {
    this.bookService = bookService;
  }

  /**
   * 本一覧を取得
   * 
   * @return 本一覧
   */
  @Get(uri = "/", produces = MediaType.APPLICATION_JSON)
  public List<Book> find(Optional<String> id, Optional<String> title, Optional<Integer> minPrice) {
    BookFilter filter = BookFilter.builder().id(id).title(title).minPrice(minPrice).build();
    return bookService.find(filter);
  }

  @Post(uri = "/post", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
  public List<Book> post(@Body @Valid BookFindForm form) {
    BookFilter filter = form.toFilter();
    return bookService.find(filter);
  }
}
