package projeto.divulgacao_servicos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;
import projeto.divulgacao_servicos.model.PrestadorServico;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoRequestDTO;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoResponseDTO;

@Mapper(componentModel = "spring")
public interface PrestadorServicoMapper {

    //para salvar PrestadorServico
    @Mappings({
            @Mapping(target = "idPrestadorServico", ignore = true),
            @Mapping(source = "dto.nome", target = "nome"),
    })
    PrestadorServico toEntity(PrestadorServicoRequestDTO dto);

    @Mappings({
            @Mapping(source = "entidade.idPrestadorServico", target = "idPrestadorServico"),
            @Mapping(source = "entidade.nome", target = "nome"),
    })
    PrestadorServicoResponseDTO toDto(PrestadorServico entidade);
}
