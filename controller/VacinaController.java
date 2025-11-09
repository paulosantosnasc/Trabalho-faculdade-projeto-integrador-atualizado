package controller;

import model.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.VacinaRepository;

/**
 * Controller responsável pelas vacinas cadastradas.
 * Faz CRUD geral.
 */
@Controller
@RequestMapping("/vacinas")
public class VacinaController {

    @Autowired
    private VacinaRepository vacinaRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("vacinas", vacinaRepository.findAll());
        model.addAttribute("vacina", new Vacina());
        return "vacinas";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Vacina vacina) {

        try {
            // tentativa de salvar no banco
            vacinaRepository.save(vacina);

        } catch (Exception e) {
            System.out.println("Erro ao salvar vacina: " + e.getMessage());
        }

        return "redirect:/vacinas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Vacina vacina = vacinaRepository.findById(id).orElse(new Vacina());
        model.addAttribute("vacina", vacina);
        model.addAttribute("vacinas", vacinaRepository.findAll());
        return "vacinas";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") int id) {
        vacinaRepository.deleteById(id);
        return "redirect:/vacinas";
    }
}
