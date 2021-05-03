package com.mabushiisign.flutter_sample.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Book {
  /** ID */
  @Schema(description = "ID")
  private String id;
  /** タイトル */
  @Schema(description = "タイトル")
  private String title;
  /** 価格 */
  @Schema(description = "価格")
  private int price;
}
