package ma.emsi.agencesmanager.web;

import ma.emsi.agencesmanager.Entities.Agence;
import ma.emsi.agencesmanager.Entities.Client;
import ma.emsi.agencesmanager.dao.AgenceRepository;
import ma.emsi.agencesmanager.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AgenceRepository agenceRepository;
    @GetMapping("/user/indexclient")
    private String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "motCle", defaultValue = "") String mc) {
        Page<Client> pageclients = clientRepository.findByPrenomClientContains(mc, PageRequest.of(page, 5));
        List<Agence> agenceList=agenceRepository.findAll();
        model.addAttribute("listAgences",agenceList);
        model.addAttribute("listClients", pageclients.getContent());
        model.addAttribute("pages", new int[pageclients.getTotalPages()]);
        model.addAttribute("CurrentPage", page);
        model.addAttribute("motCle" , mc);
        return "client";
    }
    @PostMapping("/client/ajouter")
    public String save(Model model,@Validated Client client ,BindingResult bindingResult){
        model.addAttribute("client",new Client());
        if (bindingResult.hasErrors()) return "login";
        clientRepository.save(client);
        return "client";
    }
}
