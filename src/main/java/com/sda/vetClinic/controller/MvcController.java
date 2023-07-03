package com.sda.vetClinic.controller;


import com.sda.vetClinic.dto.AppointmentDto;
import com.sda.vetClinic.dto.LoginDto;
import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.entity.Appointment;
import com.sda.vetClinic.enums.Role;
import com.sda.vetClinic.service.AppointmentService;
import com.sda.vetClinic.service.LoginService;
import com.sda.vetClinic.service.PetService;
import com.sda.vetClinic.service.UserService;
import com.sda.vetClinic.validator.AppointmentValidator;
import com.sda.vetClinic.validator.PetValidator;
import com.sda.vetClinic.validator.UserValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

//        Inregistrare pet x
//        Inregistrare vet x
//        Adaugare programare x
//        Preluare programare de catre vet
//        Procesare consult(programarea devine un consult cu informatii adaugate de vet)
//
//        Utilizatori autentificati x
//        Adaugati pagini de register si login. Introduceti doua tipuri de useri: vet si pet owner. x
//        Doar utilizatorii autentificati pot accesa paginile aplicatiei. x
//        Doar vets pot prelua si procesa programari
//        Doar pet owners pot solicita programari. x
//
//        Pet ownerul poate lasa feedback/rate/review
//        Pet ownerul poate vizualiza istoricul programarilor;
//        Pet ownerul poate avea MAI MULTI PETS!!
//        Fiecare pet are propriul sau istoric de programari si istoric medical;




@Controller
public class MvcController {

    @Autowired
    private PetService petService;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private AppointmentService appointmentService;



    @Autowired
    private UserValidator userValidator;
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private AppointmentValidator appointmentValidator;


    @GetMapping("/error")
    public String errorGet() {
        return "error";
    }


    @GetMapping("/homepageOwner")
    public String homepageOwnerGet(Model model, Authentication authentication) {
        List<PetDto> petDtoList = petService.getPetDtoListByOwnerEmail(authentication.getName());
        model.addAttribute("petDtoList", petDtoList);
        return "homepageOwner";
    }


    @GetMapping("/homepageVeterinarian")
    public String homepageVeterinarianGet(Model model, Authentication authentication) {
        List<AppointmentDto> appointmentDtoList = appointmentService.getAppointmentDtoListByPetUserEmail(authentication.getName());
        model.addAttribute("appointmentDtoList", appointmentDtoList);
        System.out.println(appointmentDtoList);
        return "homepageVeterinarian";
    }

    @GetMapping("/loginSuccessful")
    public String loginSuccessfulGet(Authentication authentication) {
        if (authentication.getAuthorities().stream().anyMatch(role->role.getAuthority().equals(Role.ROLE_OWNER.name()))){
          return "redirect:/homepageOwner";
        } else
            return "redirect:/homepageVeterinarian";
    }


    @GetMapping("/addPet")
    public String addPetGet(Model model) {
        PetDto petDto = new PetDto();
        model.addAttribute("petDto", petDto);
        return "addPet";
    }


    @PostMapping("/addPet")
    public String addPetPost(@ModelAttribute(name = "petDto") @Valid PetDto petDto, BindingResult bindingResult) {
       petValidator.validate(petDto, bindingResult);
       if (bindingResult.hasErrors()) {
           return "error";
       }
        petService.addPet(petDto);
        return "redirect:/addPet";

    }
    @GetMapping("/addAppointment")
    public String addAppointGet(Model model, Authentication authentication) {
        AppointmentDto appointmentDto = new AppointmentDto();
        model.addAttribute("appointmentDto", appointmentDto);

        List<String> petNames = petService.getPetNameListByOwnerEmail(authentication.getName());
        model.addAttribute("petNameList", petNames);

        List<String> vetNames = userService.getAllVetNameList();
        model.addAttribute("vetNameList", vetNames);
        return "addAppointment";
    }

    @PostMapping("/addAppointment")
    public String addAppointmentPost(@ModelAttribute(name = "appointmentDto") @Valid AppointmentDto appointmentDto, BindingResult bindingResult) {
        appointmentValidator.validate(appointmentDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "error";
        }
        appointmentService.addAppointment(appointmentDto);
        return "redirect:/addAppointment";
    }




    @GetMapping("/registration")
    public String registrationGet(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute(userDto);
        return "registration";
    }


    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute(name = "userDto")  @Valid UserDto userDto, BindingResult bindingResult) {
        userValidator.validate(userDto, bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userService.createUser(userDto);
        return "redirect:/registration";

    }



    @GetMapping("/login")
    public String loginGet(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute(loginDto);
        return "login";
    }


//    @PostMapping("/login")
//    public String loginPost(@ModelAttribute(name = "loginDto") LoginDto loginDto, Model model) {
//        Boolean loginWasSuccessful = loginService.login(loginDto);
//        if (loginWasSuccessful) {
//            model.addAttribute("loginMessage", "Login was successful!");
//        } else {
//            model.addAttribute("loginMessage", "Login unsuccessful! Try again.");
//        }
//        return "login";
//
//    }




    @GetMapping("/appointment/{appointmentId}")
    public String viewAppointmentGet(@PathVariable(value = "appointmentId") String appointmentId, Model model) {
        Optional<AppointmentDto> optionalAppointmentDto = appointmentService.getOptionalAppointmentDtoById(appointmentId);

        if (optionalAppointmentDto.isEmpty()) {
            return "error";
        }
        AppointmentDto appointmentDto = optionalAppointmentDto.get();
        model.addAttribute("appointmentDto", appointmentDto);
        return "viewAppointments";
    }


    @ModelAttribute("requestUrl")
    public String requestUrl(HttpServletRequest request){
        return request.getRequestURI();
    }


}
