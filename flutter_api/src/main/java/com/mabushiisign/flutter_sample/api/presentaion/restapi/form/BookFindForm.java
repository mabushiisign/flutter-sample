package com.mabushiisign.flutter_sample.api.presentaion.restapi.form;

import java.util.Optional;
import javax.validation.constraints.Min;
import com.mabushiisign.flutter_sample.api.domain.BookFilter;
import io.micronaut.core.annotation.Introspected;
import lombok.Data;


@Introspected
@Data
public class BookFindForm {

  private Optional<String> id;
  private Optional<String> title;
  @Min(value = 0)
  private Optional<Integer> minPrice;
  @Min(value = 0)
  private Optional<Integer> maxPrice;

  public BookFilter toFilter() {
    return BookFilter.builder()
        .id(this.id)
        .title(this.title)
        .minPrice(this.minPrice)
        .maxPrice(this.maxPrice)
        .build();
  }
}
