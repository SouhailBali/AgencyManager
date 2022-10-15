package ma.emsi.agencesmanager.web;

import ma.emsi.agencesmanager.Entities.Agence;
import ma.emsi.agencesmanager.Entities.Client;
import ma.emsi.agencesmanager.Entities.Societe;
import ma.emsi.agencesmanager.dao.AgenceRepository;
import ma.emsi.agencesmanager.dao.SocieteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AgenceController {
    @Autowired
    SocieteRepository societeRepository;
    @Autowired
    private AgenceRepository agenceRepository;

    @GetMapping("/user/index")
    private String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "motCle", defaultValue = "") String mc) {
        Page<Agence> pageagences = agenceRepository.findByTitleAgenceContains(mc,PageRequest.of(page, 5));
        model.addAttribute("listAgences", pageagences.getContent());
        model.addAttribute("pages", new int[pageagences.getTotalPages()]);
        model.addAttribute("CurrentPage", page);
        model.addAttribute("motCle" , mc);


        return "agence";
    }
    @GetMapping("/admin/delete")
   public String delete(Long id,int page,String motCle){
        agenceRepository.deleteById(id);
        return "redirect:/user/index?page="+page+"&motCle="+motCle;
    }
    @GetMapping("/admin/formAgence")
    public String formulaire(Model model){
        List<Societe> societesList=societeRepository.findAll();
        model.addAttribute("listSocietes",societesList);
        model.addAttribute("agence",new Agence());
        return "formAgence";
    }
    @GetMapping("/admin/edit")
    public String edit(Model model,Long id){
        Agence agence=agenceRepository.findById(id).get();
        model.addAttribute("agences",agence);
        return "editAgence";
    }

    @PostMapping("/admin/save")
    public String save(Model model,@Validated Agence agence, BindingResult bindingResult){ 
        if (bindingResult.hasErrors()) return "formAgence";
agenceRepository.save(agence);
        return "redirect:/user/index";
    }

    @GetMapping("/")
    public String def(){
        return "redirect:/user/index";
    }
    @GetMapping("/403")
    public String exception(){
        return "403";
    }
    @GetMapping("/login")
    public String login(Model model){
        List<Agence> agenceList=agenceRepository.findAll();
        model.addAttribute("listAgences",agenceList);
        model.addAttribute("client",new Client());
        return "login";
    }


}
