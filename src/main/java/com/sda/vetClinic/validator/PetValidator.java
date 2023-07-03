package com.sda.vetClinic.validator;

import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.enums.Breed;
import com.sda.vetClinic.enums.Gender;
import com.sda.vetClinic.enums.Pedigree;
import com.sda.vetClinic.enums.Species;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class PetValidator {



    public void validate(PetDto petDto, BindingResult bindingResult) {
        validateName(petDto, bindingResult);
        validateDateOfBirth(petDto, bindingResult);
        validateWeight(petDto, bindingResult);
        validateAge(petDto, bindingResult);
        validatePetSpecies(petDto, bindingResult);
        validatePetBreed(petDto, bindingResult);
//        validateGender(petDto, bindingResult);
//        validatePedigree(petDto, bindingResult);

    }


    // name
    private void validateName(PetDto petDto, BindingResult bindingResult) {
        validateNameNotEmpty(petDto, bindingResult);
        validateNameNotContainSpecialChars(petDto, bindingResult);
        validateNameMinSize(petDto, bindingResult);
        validateNameMaxSize(petDto, bindingResult);
    }


    private void validateNameNotEmpty(PetDto petDto, BindingResult bindingResult) {
        if (petDto.getName().isEmpty()) {
            FieldError fieldError = new FieldError("petDto", "name", "Name cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateNameNotContainSpecialChars(PetDto petDto, BindingResult bindingResult) {
        if (!petDto.getName().matches("^[a-zA-Z -]+$")) {
            FieldError fieldError = new FieldError("petDto", "name",
                    "Wrong format! Name cannot contain illegal characters!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateNameMinSize(PetDto petDto, BindingResult bindingResult) {
        if (petDto.getName().length() < 2) {
            FieldError fieldError = new FieldError("petDto", "name",
                    "Invalid length! Name should be at least 3 characters.");
            bindingResult.addError(fieldError);
        }
    }

    private void validateNameMaxSize(PetDto petDto, BindingResult bindingResult) {
        if (petDto.getName().length() > 15) {
            FieldError fieldError = new FieldError("petDto", "name", "Invalid length! Name cannot contain more than 15 characters!");
            bindingResult.addError(fieldError);
        }
    }

    // owner email



    // pet species
    private void validatePetSpecies(PetDto petDto, BindingResult bindingResult) {
        try {
            Species.valueOf(petDto.getSpecies());
        } catch (Exception e) {
            FieldError fieldError = new FieldError("petDto", "species", "Please select a species from the list!");
            bindingResult.addError(fieldError);
        }
    }


//     pet breed

    private void validatePetBreed(PetDto petDto, BindingResult bindingResult) {
        try {
            Breed.valueOf(petDto.getBreed());
        } catch (Exception e) {
            FieldError fieldError = new FieldError("petDto", "breed", "Please select a breed from the list!");
            bindingResult.addError(fieldError);
        }
    }




    // gender
//    private void validateGender(PetDto petDto, BindingResult bindingResult) {
//        try {
//            Gender.valueOf(petDto.getGender());
//        } catch (Exception e) {
//            FieldError fieldError = new FieldError("petDto", "gender", "Please select a gender from the list!");
//            bindingResult.addError(fieldError);
//        }
//    }


    // date of birth
    private void validateDateOfBirth(PetDto petDto, BindingResult bindingResult) {
        if(petDto.getDateOfBirth().isEmpty()){
            FieldError fieldError = new FieldError("petDto","dateOfBirth",
                    "Date of birth should be filled!");
            bindingResult.addError(fieldError);
        }
    }


    // weight
    private void validateWeight(PetDto petDto, BindingResult bindingResult) {
        validateWeightNotEmpty(petDto, bindingResult);
        validateWeightContainOnlyNoAndDecimals(petDto, bindingResult);

    }

    private void validateWeightNotEmpty(PetDto petDto, BindingResult bindingResult) {
        if(petDto.getWeight().isEmpty()){
            FieldError fieldError = new FieldError("petDto","weight",
                    "Weight cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateWeightContainOnlyNoAndDecimals(PetDto petDto, BindingResult bindingResult) {
        if (!petDto.getWeight().matches("^[0-9]+(\\.[0-9]+)?$")) {
            FieldError fieldError = new FieldError("petDto", "weight",
                    "Wrong format! Weight can only contain numbers and \" . \"!");
            bindingResult.addError(fieldError);
        }
    }



    // age
    private void validateAge(PetDto petDto, BindingResult bindingResult) {
        validateAgeNotEmpty(petDto, bindingResult);
        validateAgeContainOnlyNo(petDto, bindingResult);

    }

    private void validateAgeNotEmpty(PetDto petDto, BindingResult bindingResult) {
        if(petDto.getAge().isEmpty()){
            FieldError fieldError = new FieldError("petDto","age",
                    "Age cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateAgeContainOnlyNo(PetDto petDto, BindingResult bindingResult) {
        if (!petDto.getWeight().matches("^[0-9]+$")) {
            FieldError fieldError = new FieldError("petDto", "age",
                    "Wrong format! Age can only contain numbers!");
            bindingResult.addError(fieldError);
        }
    }


    // pedigree
//    private void validatePedigree(PetDto petDto, BindingResult bindingResult) {
//        try {
//            Pedigree.valueOf(petDto.getPedigree());
//        } catch (Exception e) {
//            FieldError fieldError = new FieldError("petDto", "pedigree", "Please select if pet has pedigree!");
//            bindingResult.addError(fieldError);
//        }
//    }

}
