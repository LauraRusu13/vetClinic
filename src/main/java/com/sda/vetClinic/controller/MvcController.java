package com.sda.vetClinic.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/homePage")
    public String homePageGet(Model model) {
        return "homePage";
    }


    @GetMapping("/login")
    public String loginGet(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost() {
        return "homePage";
    }


    @GetMapping("/equipment")
    public String equipmentGet(Model model) {
        return "equipment";
    }


    @GetMapping("/services")
    public String servicesGet(Model model) {
        return "services";
    }


    @GetMapping("/veterinaryMed")
    public String veterinaryMedGet(Model model) {
        return "veterinaryMed";
    }


    @GetMapping("/grooming")
    public String groomingGet(Model model) {
        return "grooming";
    }


    @GetMapping("/appointments")
    public String appointmentsGet(Model model) {
        return "appointments";
    }


    @GetMapping("/petShop")
    public String petShopGet(Model model) {
        return "petShop";
    }


    @GetMapping("/contact")
    public String contactGet(Model model) {
        return "contact";
    }


}
