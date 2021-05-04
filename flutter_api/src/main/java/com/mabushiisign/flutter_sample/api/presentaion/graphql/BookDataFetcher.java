package com.mabushiisign.flutter_sample.api.presentaion.graphql;

import java.util.List;
import javax.inject.Singleton;
import com.mabushiisign.flutter_sample.api.application.service.BookService;
import com.mabushiisign.flutter_sample.api.domain.Book;
import com.mabushiisign.flutter_sample.api.domain.BookFilter;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import io.micronaut.security.utils.SecurityService;
import lombok.extern.java.Log;

@Singleton
@Log
public class BookDataFetcher implements DataFetcher<List<Book>> {

  private SecurityService securityService;
  private BookService bookService;

  public BookDataFetcher(SecurityService securityService, BookService bookService) {
    this.securityService = securityService;
    this.bookService = bookService;
  }

  @Override
  public List<Book> get(DataFetchingEnvironment env) {
    BookFilter filter = BookFilter.fromMap(env.getArgument("filter"));
    log.info("username:" + securityService.username().get());
    DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
    selectionSet.getFields().forEach(field -> {
      log.info("select:" + field.getName());
    });

    return bookService.find(filter);
  }


}
