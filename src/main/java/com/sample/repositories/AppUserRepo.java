package com.sample.repositories;

import com.sample.models.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Long> {

  Optional<AppUser> findByEmail(String email);

}
