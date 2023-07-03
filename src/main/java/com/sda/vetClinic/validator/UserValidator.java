package com.sda.vetClinic.validator;

import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.User;
import com.sda.vetClinic.enums.Role;
import com.sda.vetClinic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;


    public void validate(UserDto userDto, BindingResult bindingResult) {
        validateFirstName(userDto, bindingResult);
        validateLastName(userDto, bindingResult);
        validateEmail(userDto, bindingResult);
        validatePassword(userDto, bindingResult);
        validatePhoneNo(userDto, bindingResult);
        validateDateOfBirth(userDto, bindingResult);
        validateRole(userDto, bindingResult);
    }


    // first name
    private void validateFirstName(UserDto userDto, BindingResult bindingResult) {
        validateFirstNameNotEmpty(userDto, bindingResult);
        validateFirstNameNotContainSpecialChars(userDto, bindingResult);
        validateFirstNameMinSize(userDto, bindingResult);
        validateFirstNameMaxSize(userDto, bindingResult);
    }


    private void validateFirstNameNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getFirstName().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "firstName", "First name cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateFirstNameNotContainSpecialChars(UserDto userDto, BindingResult bindingResult) {
        if (!userDto.getFirstName().matches("^[a-zA-Z -]+$")) {
            FieldError fieldError = new FieldError("userDto", "firstName",
                    "Wrong format! First name cannot contain illegal characters!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateFirstNameMinSize(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getFirstName().length() < 2) {
            FieldError fieldError = new FieldError("userDto", "firstName",
                    "Invalid length! First name should be at least 3 characters.");
            bindingResult.addError(fieldError);
        }
    }

    private void validateFirstNameMaxSize(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getFirstName().length() > 15) {
            FieldError fieldError = new FieldError("userDto", "firstName", "Invalid length! First name cannot contain more than 15 characters!");
            bindingResult.addError(fieldError);
        }
    }


    //last name
    private void validateLastName(UserDto userDto, BindingResult bindingResult) {
        validateLastNameNotEmpty(userDto, bindingResult);
        validateLastNameNotContainSpecialChars(userDto, bindingResult);
        validateLastNameMinSize(userDto, bindingResult);
        validateLastNameMaxSize(userDto, bindingResult);
    }


    private void validateLastNameNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getLastName().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "lastName", "Last name cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateLastNameNotContainSpecialChars(UserDto userDto, BindingResult bindingResult) {
        if (!userDto.getLastName().matches("^[a-zA-Z -]+$")) {
            FieldError fieldError = new FieldError("userDto", "lastName",
                    "Wrong format! Last name cannot contain illegal characters!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateLastNameMinSize(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getLastName().length() < 3) {
            FieldError fieldError = new FieldError("userDto", "lastName",
                    "Invalid length! Last name should be at least 3 characters.");
            bindingResult.addError(fieldError);
        }
    }

    private void validateLastNameMaxSize(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getLastName().length() > 15) {
            FieldError fieldError = new FieldError("userDto", "lastName", "Invalid length! Last name cannot contain more than 15 characters!");
            bindingResult.addError(fieldError);
        }
    }


    // email
    private void validateEmail(UserDto userDto, BindingResult bindingResult) {
        validateEmailNotEmpty(userDto, bindingResult);
        validateUniqueEmail(userDto, bindingResult);
    }


    private void validateEmailNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getEmail().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "email", "Enter valid email!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateUniqueEmail(UserDto userDto, BindingResult bindingResult) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()) {
            FieldError fieldError = new FieldError("userDto", "email",
                    "E-mail is already in use!");
            bindingResult.addError(fieldError);
        }
    }


    // password
    private void validatePassword(UserDto userDto, BindingResult bindingResult) {
        validatePasswordNotEmpty(userDto, bindingResult);
//        validatePasswordRules(userDto, bindingResult);
    }

    private void validatePasswordNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getPassword().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "password", "Password cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    //    at least one upper case letter, one lower case letter,
//    one numeric digit
//    one special character
//    minimum length 8
//    private void validatePasswordRules(UserDto userDto, BindingResult bindingResult) {
//        if (userDto.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,15}$")) {
//            FieldError fieldError = new FieldError("userDto", "password",
//                    "Wrong format! Password must be between 8 - 15 characters, must contain numbers and at least one lowercase and one uppercase character!");
//            bindingResult.addError(fieldError);
//        }
//
//    }


    // phone number

    private void validatePhoneNo(UserDto userDto, BindingResult bindingResult) {
        validatePhoneNoNotEmpty(userDto, bindingResult);
        validatePhoneNoBeNineChar(userDto, bindingResult);
        validatePhoneNoContainOnlyNo(userDto, bindingResult);
    }

    private void validatePhoneNoNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getPhoneNo().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "phoneNo", "Phone number cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validatePhoneNoContainOnlyNo(UserDto userDto, BindingResult bindingResult) {
        if (!userDto.getPhoneNo().matches("^[0-9]+$")) {
            FieldError fieldError = new FieldError("userDto", "phoneNo",
                    "Wrong format! Phone number can only contain numbers!");
            bindingResult.addError(fieldError);
        }
    }

    private void validatePhoneNoBeNineChar(UserDto userDto, BindingResult bindingResult) {
        if (!userDto.getPhoneNo().matches("^\\d{10}$")) {
            FieldError fieldError = new FieldError("userDto", "phoneNo",
                    "Wrong format! Phone number has to be 9 characters!");
            bindingResult.addError(fieldError);
        }
    }


    // date
    private void validateDateOfBirth(UserDto userDto, BindingResult bindingResult) {
        validateDateOfBirthNotEmpty(userDto, bindingResult);
        validateDateOfBirthAgeMin16(userDto, bindingResult);
    }

    private void validateDateOfBirthNotEmpty(UserDto userDto, BindingResult bindingResult) {
        if (userDto.getDateOfBirth().isEmpty()) {
            FieldError fieldError = new FieldError("userDto", "dateOfBirth",
                    "Date of birth should be filled!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateDateOfBirthAgeMin16(UserDto userDto, BindingResult bindingResult) {
        LocalDate dateOfBirth = LocalDate.parse(userDto.getDateOfBirth());
        if (dateOfBirth.isAfter(LocalDate.now().minusYears(16))) {
            FieldError fieldError = new FieldError("userDto", "dateOfBirth", "Age must be at least 16! Talk to your parents!");
            bindingResult.addError(fieldError);
        }
    }


    // role
    private void validateRole(UserDto userDto, BindingResult bindingResult) {
        try {
            Role.valueOf(userDto.getRole());
        } catch (Exception e) {
            FieldError fieldError = new FieldError("userDto", "role", "Please select a role from the list!");
            bindingResult.addError(fieldError);
        }
    }

}
