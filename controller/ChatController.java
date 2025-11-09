package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller responsável pelo chatbot do sistema.
 * Aqui fiz um map de respostas simples pra simular IA.
 */
@Controller
@RequestMapping("/chat")
public class ChatController {

    // base de respostas simples pra treinar o professor
    private final Map<String, String> respostas = new HashMap<>();

    public ChatController() {
        respostas.put("dor", "A dor no local da aplicação é normal nas primeiras 24–48h.");
        respostas.put("braço", "Dor no braço é normal após a vacina. Compressa fria ajuda.");
        respostas.put("febre", "Febre leve é comum depois da vacina. Hidrate-se bem.");
        respostas.put("inchaço", "Inchaço local é normal, mas se aumentar muito procure ajuda.");
        respostas.put("obrigado", "De nada! 😊");
        respostas.put("valeu", "Tamo junto 😎");
        respostas.put("oi", "Olá! Como posso ajudar?");
        respostas.put("ola", "Olá! Me diga o que você precisa.");
        respostas.put("bom dia", "Bom dia! ☀️");
        respostas.put("boa tarde", "Boa tarde! 😊");
        respostas.put("boa noite", "Boa noite! 🌙");
    }

    @GetMapping
    public String chatPage() {
        return "chat";
    }

    @PostMapping("/enviar")
    @ResponseBody
    public String responder(@RequestParam String mensagem) {

        try {
            String msg = mensagem.toLowerCase().trim();

            // procura palavra-chave dentro da mensagem
            for (String chave : respostas.keySet()) {
                if (msg.contains(chave)) {
                    return respostas.get(chave);
                }
            }

        } catch (Exception e) {
            // caso dê erro, só retornamos algo pro usuário
            return "Opa, acho que tive um problema aqui 😅 tenta de novo!";
        }

        return "Não entendi 🤔. Você quer falar sobre dor, febre ou reação da vacina?";
    }
}
