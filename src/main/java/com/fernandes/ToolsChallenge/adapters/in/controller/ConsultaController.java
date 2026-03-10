package com.fernandes.ToolsChallenge.adapters.in.controller;

import com.fernandes.ToolsChallenge.adapters.in.controller.dto.PagamentoDTO;
import com.fernandes.ToolsChallenge.adapters.in.controller.mapper.PagamentoDTOMapper;
import com.fernandes.ToolsChallenge.application.ports.in.BuscarPagamentoPorIdInputPort;
import com.fernandes.ToolsChallenge.application.ports.in.BuscarPagamentosInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final BuscarPagamentosInputPort buscarPagamentosInputPort;

    private final BuscarPagamentoPorIdInputPort buscarPagamentoPorIdInputPort;

    private final PagamentoDTOMapper mapper;

    @GetMapping
    public ResponseEntity<List<PagamentoDTO>> buscarTodos(){
        var listaPagamentos = buscarPagamentosInputPort.buscarTodosPagamentos();
        List<PagamentoDTO> listDTO = listaPagamentos.stream().map(mapper::toPagamentoDTO).toList();
        return ResponseEntity.ok(listDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPagamentoPorId(@PathVariable("id") String id){
        var pagamento = buscarPagamentoPorIdInputPort.buscarPorId(id);
        return ResponseEntity.ok(mapper.toPagamentoDTO(pagamento));
    }
}
