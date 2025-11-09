package model;

import jakarta.persistence.*;

@Entity
@Table(name = "chat_mensagem")
public class ChatMensagem {

    // ID da mensagem no banco, gerado automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Relacionamento: várias mensagens podem ser de um mesmo usuário
    // Uso ManyToOne porque cada linha da tabela tem só um usuário
    @ManyToOne
    @JoinColumn(name = "usuario_id") // nome da coluna no banco
    private Usuario usuario;

    // Aqui eu guardo a mensagem que o usuário digitou no chat
    private String mensagemUsuario;

    // Aqui vai a resposta que o bot deu pra ele
    private String respostaBot;

    // Só estou guardando a data e hora como texto mesmo pra simplificar
    private String dataHora;

    // ---------- Getters e Setters (coisa padrão do Java) ----------

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public Usuario getUsuario() { 
        return usuario; 
    }
    public void setUsuario(Usuario usuario) { 
        this.usuario = usuario; 
    }

    public String getMensagemUsuario() { 
        return mensagemUsuario; 
    }
    public void setMensagemUsuario(String mensagemUsuario) { 
        this.mensagemUsuario = mensagemUsuario; 
    }

    public String getRespostaBot() { 
        return respostaBot; 
    }
    public void setRespostaBot(String respostaBot) { 
        this.respostaBot = respostaBot; 
    }

    public String getDataHora() { 
        return dataHora; 
    }
    public void setDataHora(String dataHora) { 
        this.dataHora = dataHora; 
    }
}
