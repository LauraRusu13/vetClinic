package com.sda.vetClinic.validator;

import com.sda.vetClinic.dto.AppointmentDto;
import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.Appointment;
import com.sda.vetClinic.enums.AppointmentType;
import com.sda.vetClinic.enums.Role;
import com.sda.vetClinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.LocalDate;

@Component
public class AppointmentValidator {

    @Autowired
    private AppointmentRepository appointmentRepository;



    public void validate(AppointmentDto appointmentDto, BindingResult bindingResult) {
        validateAppointmentType(appointmentDto, bindingResult);
        validateDateTime(appointmentDto, bindingResult);
        validateOtherIssues(appointmentDto, bindingResult);
        validateDetails(appointmentDto, bindingResult);
    }


    // pet

    //vet

    // appointment type
    private void validateAppointmentType(AppointmentDto appointmentDto, BindingResult bindingResult) {
        try {
            AppointmentType.valueOf(appointmentDto.getAppointmentType());
        } catch (Exception e) {
            FieldError fieldError = new FieldError("appointmentDto", "appointmentType", "Please select an appointment type from the list!");
            bindingResult.addError(fieldError);
        }
    }


    // details

    private void validateDetails(AppointmentDto appointmentDto, BindingResult bindingResult){
        validateDetailsNotEmpty(appointmentDto, bindingResult);
        validateDetailsNotContainSpecialChars(appointmentDto, bindingResult);
    }


    private void validateDetailsNotEmpty(AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (appointmentDto.getDetails().isEmpty()) {
            FieldError fieldError = new FieldError("appointmentDto", "details", "Details cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateDetailsNotContainSpecialChars(AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (!appointmentDto.getDetails().matches("^[a-zA-Z -]+$")) {
            FieldError fieldError = new FieldError("appointmentDto", "details",
                    "Wrong format! Details cannot contain illegal characters!");
            bindingResult.addError(fieldError);
        }
    }

    // other issues
    private void validateOtherIssues(AppointmentDto appointmentDto, BindingResult bindingResult){
        validateOtherIssuesNotEmpty(appointmentDto, bindingResult);
        validateOtherIssuesNotContainSpecialChars(appointmentDto, bindingResult);
    }


    private void validateOtherIssuesNotEmpty(AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (appointmentDto.getOtherMedicalIssues().isEmpty()) {
            FieldError fieldError = new FieldError("appointmentDto", "otherMedicalIssues", "Other issues cannot be empty!");
            bindingResult.addError(fieldError);
        }
    }

    private void validateOtherIssuesNotContainSpecialChars(AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (!appointmentDto.getOtherMedicalIssues().matches("^[a-zA-Z -]+$")) {
            FieldError fieldError = new FieldError("appointmentDto", "otherMedicalIssues",
                    "Wrong format! Other issues cannot contain illegal characters!");
            bindingResult.addError(fieldError);
        }
    }


    //date time
    private void validateDateTime(AppointmentDto appointmentDto, BindingResult bindingResult) {
       validateDateTimeNotEmpty(appointmentDto, bindingResult);
    }

    private void validateDateTimeNotEmpty(AppointmentDto appointmentDto, BindingResult bindingResult) {
        if (appointmentDto.getDateTime().isEmpty()) {
            FieldError fieldError = new FieldError("appointmentDto", "dateTime",
                    "Date and time of appointment should be filled!");
            bindingResult.addError(fieldError);
        }
    }







}
