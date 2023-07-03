package com.sda.vetClinic.repository;

import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);


    List<User> findByRole(Role role);

    Optional<User> findByRoleAndFirstNameAndLastName(Role role, String firstName, String lastName);
}
