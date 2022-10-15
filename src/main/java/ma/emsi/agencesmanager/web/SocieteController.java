package ma.emsi.agencesmanager.web;

import ma.emsi.agencesmanager.Entities.Agence;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SocieteController {
    @Autowired
    AgenceRepository agenceRepository;
    @Autowired
    SocieteRepository societeRepository;
    @GetMapping("/user/SocieteInfo")
    private String info(Model model,Long id){
Page<Agence> listagences= agenceRepository.findAllBySocieteAgence(id,PageRequest.ofSize(5));
model.addAttribute("listagence",listagences.getContent());
        return "societeInfo";
    }
    @GetMapping("/user/indexsociete")
    private String index(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
                         @RequestParam(name = "motCle", defaultValue = "") String mc) {
        Page<Societe> pagesociete = societeRepository.findByNomSocieteContains(mc, PageRequest.of(page, 5));
        model.addAttribute("listSociete", pagesociete.getContent());
        model.addAttribute("pages", new int[pagesociete.getTotalPages()]);
        model.addAttribute("CurrentPage", page);
        model.addAttribute("motCle" , mc);
        return "societe";
    }
    @GetMapping("/admin/deletesociete")
    public String delete(Long id,int page,String motCle){
        societeRepository.deleteById(id);
        return "redirect:/user/indexsociete?page="+page+"&motCle="+motCle;
    }
    @GetMapping("/admin/editsociete")
    public String edit(Model model,Long id){
        Societe societe=societeRepository.findById(id).get();
        model.addAttribute("societes",societe);
        return "editSociete";
    }
    @PostMapping("/admin/savesociete")
    public String save(Model model, @Validated Societe societe, BindingResult bindingResult){
        if (bindingResult.hasErrors()) return "formSociete";
        societeRepository.save(societe);
        return "redirect:/user/indexsociete";
    }
    @GetMapping("/admin/formSociete")
    public String formulaire(Model model){
        model.addAttribute("societe",new Societe());
        return "formSociete";
    }
}
