package com.mabushiisign.flutter_sample.graphql;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import com.mabushiisign.flutter_sample.domain.Book;
import com.mabushiisign.flutter_sample.domain.BookFilter;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.DataFetchingFieldSelectionSet;
import io.micronaut.security.utils.SecurityService;
import lombok.extern.java.Log;

@Singleton
@Log
public class BookDataFetcher implements DataFetcher<List<Book>> {

  @Inject
  protected SecurityService securityService;

  @Override
  public List<Book> get(DataFetchingEnvironment env) {
    BookFilter filter = BookFilter.fromMap(env.getArgument("filter"));
    log.info("username:" + securityService.username().get());
    DataFetchingFieldSelectionSet selectionSet = env.getSelectionSet();
    selectionSet.getFields().forEach(field -> {
      log.info("select:" + field.getName());
    });

    return list(filter);
  }

  public List<Book> list(BookFilter filter) {
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
