package projeto.divulgacao_servicos.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import projeto.divulgacao_servicos.model.PrestadorServico;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PrestadorServicoRepository extends JpaRepository<PrestadorServico, String> {

    @Query("SELECT ps FROM PrestadorServico ps WHERE ps.nome = (:nome)")
    PrestadorServico carregarInfoPrestadorServico(@Param("nome") String nome);
}
