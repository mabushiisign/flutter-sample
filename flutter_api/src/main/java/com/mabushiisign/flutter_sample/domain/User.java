package com.mabushiisign.flutter_sample.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class User {
  private final String username;
  private final String password;
  private final String firstName;
  private final String lastName;
  private final List<String> roles;
}
