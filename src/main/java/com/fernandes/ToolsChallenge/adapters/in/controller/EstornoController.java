package com.fernandes.ToolsChallenge.adapters.in.controller;

import com.fernandes.ToolsChallenge.adapters.in.controller.dto.PagamentoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.mapper.PagamentoDTOMapper;
import com.fernandes.ToolsChallenge.application.ports.in.SolicitacaoEstornoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estornos")
@RequiredArgsConstructor
public class EstornoController {

    private final SolicitacaoEstornoInputPort solicitacaoEstornoInputPort;

    private final PagamentoDTOMapper mapper;

    @PostMapping()
    public ResponseEntity<PagamentoDTO> solicitacaoEstorno(@RequestParam("id") String id){
        var pagamento = solicitacaoEstornoInputPort.solicitacaoEstorno(id);
        return ResponseEntity.ok(mapper.toPagamentoDTO(pagamento));
    }

}
