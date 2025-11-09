package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.EfeitoAdverso;
import repository.EfeitoAdversoRepository;

/**
 * Controller dos efeitos adversos.
 * Aqui faço CRUD básico.
 */
@Controller
public class EfeitoAdversoController {

    @Autowired
    private EfeitoAdversoRepository efeitoAdversoRepository;

    @GetMapping("/efeitos")
    public String listarEfeitos(Model model) {
        model.addAttribute("efeitos", efeitoAdversoRepository.findAll());
        return "efeitos";
    }

    @PostMapping("/efeitos")
    public String cadastrarEfeito(
        @RequestParam String descricao,
        @RequestParam String intensidade,
        @RequestParam String dataRelato
    ) {

        try {
            EfeitoAdverso e = new EfeitoAdverso();
            e.setDescricao(descricao);
            e.setIntensidade(intensidade);
            e.setDataRelato(dataRelato);

            efeitoAdversoRepository.save(e);

        } catch (Exception erro) {
            System.out.println("Erro ao salvar efeito: " + erro.getMessage());
        }

        return "redirect:/efeitos";
    }
}
