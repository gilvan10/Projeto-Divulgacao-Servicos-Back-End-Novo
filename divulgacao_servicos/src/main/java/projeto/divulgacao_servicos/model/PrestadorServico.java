package projeto.divulgacao_servicos.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "prestador_servicos")
@EqualsAndHashCode(of = "id")
public class PrestadorServico {

    //UUID é um string aleatória que é gerada automáticamente
    @Id
    @Column(name = "id_prestador_servicos")
    @GeneratedValue(strategy=GenerationType.UUID)
    private String idPrestadorServico;

    @Column(name = "nome")
    private String nome;

    public PrestadorServico() {

    }

    public PrestadorServico(String nome) {
        this.nome = nome;
    }

    public String getIdPrestadorServico() {
        return idPrestadorServico;
    }
    public void setIdPrestadorServico(String idPrestadorServico) {
        this.idPrestadorServico = idPrestadorServico;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }



}
