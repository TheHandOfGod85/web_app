package com.sample.services;

import com.sample.models.AppUser;
import com.sample.models.AppUserRole;
import com.sample.models.UserRegistration;
import com.sample.repositories.AppUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

  private final AppUserRepo appUserRepo;
  private final AppUser appUser;


  // check if the user is registered or throw an exception
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return appUserRepo.findByEmail(email).orElseThrow(
        () -> new UsernameNotFoundException(
            String.format("User with email %s not found", email)));
  }

  // register the users
  public void register(UserRegistration request) {
    //check if the user exist in the database
    boolean userExist = appUserRepo.findByEmail(appUser.getEmail()).isPresent();
    if (userExist) {
      throw new IllegalStateException("Email already taken");
    }
    // create an encoded password
    String encodedPassword = new BCryptPasswordEncoder().encode(request.getPassword());
    // register the
    appUser.setFirstName(request.getFirstName());
    appUser.setLastName(request.getLastName());
    appUser.setEmail(request.getEmail());
    appUser.setAppUserRole(AppUserRole.USER);
    appUser.setEnabled(true);
    appUser.setPassword(encodedPassword);
    appUserRepo.save(appUser);
  }
}