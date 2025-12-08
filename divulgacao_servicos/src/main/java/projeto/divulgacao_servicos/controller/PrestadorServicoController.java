package projeto.divulgacao_servicos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoRequestDTO;
import projeto.divulgacao_servicos.model.dto.PrestadorServicoResponseDTO;
import projeto.divulgacao_servicos.service.PrestadorServicoService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/prestador-servico")
public class PrestadorServicoController {

    @Autowired
    final PrestadorServicoService service;

    public PrestadorServicoController(PrestadorServicoService service) {
        this.service = service;
    }

    @GetMapping(produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrestadorServicoResponseDTO>> findAll(){
        return ResponseEntity.ok(this.service.findAll());
    }
    //@Valid
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrestadorServicoResponseDTO> save(@RequestBody PrestadorServicoRequestDTO dto) {
        return ResponseEntity.ok(this.service.save(dto));
    }
}
