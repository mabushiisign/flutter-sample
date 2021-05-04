package com.mabushiisign.flutter_sample.api.application.repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.inject.Singleton;
import com.mabushiisign.flutter_sample.api.domain.User;

@Singleton
public class UserRepository {

  private static final Map<String, User> USERS = new HashMap<>();

  static {
    USERS.put("test",
        User.builder()
            .username("test")
            .firstName("test")
            .lastName("Test")
            .password("password")
            .roles(Arrays.asList("ROLE_USER"))
            .build());
    USERS.put("admin",
        User.builder()
            .username("admin")
            .firstName("Tak")
            .lastName("Matsu")
            .password("password")
            .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
            .build());
  }

  public Optional<User> findByUsername(String username) {
    return Optional.ofNullable(USERS.get(username));
  }

}
