package com.sample.controllers;

import com.sample.models.AppUser;
import com.sample.models.UserRegistration;
import com.sample.services.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/")
public class AppUserController {
  private final AppUserService appUserService;

  @PostMapping("register")
  public void registerUser(@RequestBody UserRegistration user){
    appUserService.register(user);
  }

}
