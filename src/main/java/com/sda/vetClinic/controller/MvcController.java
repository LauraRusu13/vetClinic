package com.sda.vetClinic.controller;


import com.sda.vetClinic.dto.LoginDto;
import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.dto.UserDto;
import com.sda.vetClinic.service.LoginService;
import com.sda.vetClinic.service.PetService;
import com.sda.vetClinic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//        Inregistrare pet
//        Inregistrare vet
//        Adaugare programare
//        Preluare programare de catre vet
//        Procesare consult(programarea devine un consult cu informatii adaugate de vet)
//
//        Utilizatori autentificati
//        Adaugati pagini de register si login. Introduceti doua tipuri de useri: vet si pet owner.
//        Doar utilizatorii autentificati pot accesa paginile aplicatiei.
//        Doar vets pot prelua si procesa programari
//        Doar pet owners pot solicita programari.
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


    @GetMapping("/homepageOwner")
    public String homepageOwnerGet(Model model) {
        return "homepageOwner";
    }


    @GetMapping("/homepageVeterinarian")
    public String homepageVeterinarianGet(Model model) {
        return "homepageVeterinarian";
    }


    @GetMapping("/addPet")
    public String addPetGet(Model model) {
        PetDto petDto = new PetDto();
        model.addAttribute("petDto", petDto);
        return "addPet";
    }


    @PostMapping("/addPet")
    public String addPetPost(@ModelAttribute(name = "petDto") PetDto petDto) {
        petService.addPet(petDto);
        return "redirect:/addPet";

    }

    @GetMapping("/registration")
    public String registrationGet(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute(userDto);
        return "registration";
    }


    @PostMapping("/registration")
    public String registrationPost(@ModelAttribute(name = "userDto") UserDto userDto) {
        userService.createUser(userDto);
        return "redirect:/registration";

    }



    @GetMapping("/login")
    public String loginGet(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute(loginDto);
        return "login";
    }


    @PostMapping("/login")
    public String loginPost(@ModelAttribute(name = "loginDto") LoginDto loginDto, Model model) {
        Boolean loginWasSuccessful = loginService.login(loginDto);
        if (loginWasSuccessful) {
            model.addAttribute("loginMessage", "Login was successful!");
        } else {
            model.addAttribute("loginMessage", "Login unsuccessful! Try again.");
        }
        return "login";

    }


}
