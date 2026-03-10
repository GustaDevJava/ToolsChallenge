package com.fernandes.ToolsChallenge.adapters.in.controller;

import com.fernandes.ToolsChallenge.adapters.in.controller.dto.PagamentoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.mapper.PagamentoDTOMapper;
import com.fernandes.ToolsChallenge.application.core.domain.Pagamento;
import com.fernandes.ToolsChallenge.application.ports.in.SolicitacaoPagamentoInputPort;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final SolicitacaoPagamentoInputPort solicitacaoPagamentoInputPort;

    private final PagamentoDTOMapper mapper;

    @PostMapping
    public ResponseEntity<PagamentoDTO> pagamento(@Valid @RequestBody PagamentoDTO pagamentoDTO){
        var pagamento = mapper.toPagamento(pagamentoDTO);
        pagamento = solicitacaoPagamentoInputPort.solicitarPagamento(pagamento);
        return ResponseEntity.ok(mapper.toPagamentoDTO(pagamento));
    }
}
