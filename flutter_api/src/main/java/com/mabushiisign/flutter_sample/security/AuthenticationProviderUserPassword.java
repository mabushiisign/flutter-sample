package com.mabushiisign.flutter_sample.security;

import java.util.Optional;
import javax.inject.Singleton;
import com.mabushiisign.flutter_sample.domain.User;
import com.mabushiisign.flutter_sample.repository.UserRepository;
import org.reactivestreams.Publisher;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationFailureReason;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

  private final UserRepository userRepository;

  public AuthenticationProviderUserPassword(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest,
      AuthenticationRequest<?, ?> authenticationRequest) {
    Optional<User> user =
        userRepository.findByUsername((String) authenticationRequest.getIdentity());

    if (!user.isPresent()) {
      return Flowable.just(new AuthenticationFailed(AuthenticationFailureReason.USER_NOT_FOUND));
    }

    if (authenticationRequest.getSecret().equals(user.get().getPassword())) {
      return Flowable.just(new UserDetails(user.get().getUsername(), user.get().getRoles()));
    }

    return Flowable
        .just(new AuthenticationFailed(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH));
  }
}
