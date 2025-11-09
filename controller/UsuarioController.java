package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import model.Usuario;
import repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String listarUsuarios(Model model) {

        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("listaDeUsuarios", usuarios);

        // ✅ Objeto vazio para o formulário funcionar
        model.addAttribute("usuario", new Usuario());

        return "usuarios";
    }

    @PostMapping
    public String salvarUsuario(@ModelAttribute Usuario usuario) {

        usuarioRepository.save(usuario);

        return "redirect:/usuarios";
    }
}
