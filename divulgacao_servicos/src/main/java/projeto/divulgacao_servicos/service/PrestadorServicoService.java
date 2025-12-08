package projeto.divulgacao_servicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import projeto.divulgacao_servicos.mapper.PrestadorServicoMapper;
import projeto.divulgacao_servicos.model.PrestadorServico;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoRequestDTO;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoResponseDTO;
import projeto.divulgacao_servicos.repository.PrestadorServicoRepository;

import java.util.List;

@Service
public class PrestadorServicoService {

    @Autowired
    private PrestadorServicoMapper mapper;

    final PrestadorServicoRepository repository;

    public PrestadorServicoService(PrestadorServicoRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true )
    public List<PrestadorServicoResponseDTO> findAll() {
        List<PrestadorServico> prestadoresServicos = this.repository.findAll();
        return prestadoresServicos.stream().map(prestadorServico -> new PrestadorServicoResponseDTO(
                        prestadorServico.getIdPrestadorServico(),
                        prestadorServico.getNome())
                )
                .toList();
    }
    //mudar depois
    @Transactional
    public PrestadorServicoResponseDTO save(PrestadorServicoRequestDTO dto) {
        PrestadorServico prestadorServico = this.mapper.toEntity(dto);
        this.repository.save(prestadorServico);
        return this.carregarInfoPrestadorServico(dto.nome());
    }

    @Transactional(readOnly =  true )
    public PrestadorServicoResponseDTO carregarInfoPrestadorServico(String nome) {
        PrestadorServico prestadorServico = this.repository.carregarInfoPrestadorServico(nome);
        return this.mapper.toDto(prestadorServico);
    }
}
