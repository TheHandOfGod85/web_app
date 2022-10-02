package com.sample.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;

// a class to simply register the details of the users
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class UserRegistration{
  private  String firstName;
  private  String lastName;
  private  String email;
  private  String password;

}
