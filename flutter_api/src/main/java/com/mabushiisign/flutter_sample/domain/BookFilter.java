package com.mabushiisign.flutter_sample.domain;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class BookFilter {

  private String id;
  private String title;

  public static BookFilter fromMap(Map<String, String> args) {
    return BookFilter.builder().id(args.get("id")).title(args.get("title")).build();
  }
}
