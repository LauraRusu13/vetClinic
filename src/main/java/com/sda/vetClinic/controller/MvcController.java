package com.sda.vetClinic.controller;


import com.sda.vetClinic.dto.PetDto;
import com.sda.vetClinic.dto.VetDto;
import com.sda.vetClinic.service.PetService;
import com.sda.vetClinic.service.VetService;
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
    private VetService vetService;


    @GetMapping("/homePage")
    public String homePageGet(Model model) {
        return "homePage";
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

    @GetMapping("/addVet")
    public String addVetGet(Model model) {
        VetDto vetDto = new VetDto();
        model.addAttribute("vetDto", vetDto);
        return "addVet";
    }


    @PostMapping("/addVet")
    public String addVetPost(@ModelAttribute(name = "vetDto") VetDto vetDto) {
        vetService.addVet(vetDto);
        return "redirect:/addVet";
    }


}
