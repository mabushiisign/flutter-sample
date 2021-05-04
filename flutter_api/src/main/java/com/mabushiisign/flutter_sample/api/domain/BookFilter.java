package com.mabushiisign.flutter_sample.api.domain;

import java.util.Map;
import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class BookFilter {

  private Optional<String> id;
  private Optional<String> title;
  private Optional<Integer> minPrice;
  private Optional<Integer> maxPrice;

  public static BookFilter fromMap(Map<String, Object> args) {

    String id = args.get("id") == null ? null : String.valueOf(args.get("id"));
    String title = args.get("title") == null ? null : String.valueOf(args.get("title"));
    Integer minPrice =
        args.get("minPrice") == null ? null : Integer.valueOf(String.valueOf(args.get("minPrice")));
    Integer maxPrice =
        args.get("maxPrice") == null ? null : Integer.valueOf(String.valueOf(args.get("maxPrice")));

    return BookFilter.builder()
        .id(Optional.ofNullable(id))
        .title(Optional.ofNullable(title))
        .minPrice(Optional.ofNullable(minPrice))
        .maxPrice(Optional.ofNullable(maxPrice))
        .build();
  }
}
