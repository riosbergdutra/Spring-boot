package test.event.eventdriven.pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.event.eventdriven.pagamento.dto.request.PagamentoRequestDto;
import test.event.eventdriven.pagamento.dto.response.PagamentoResponseDto;
import test.event.eventdriven.pagamento.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/processar")
    public ResponseEntity<PagamentoResponseDto> processarPagamento(@RequestBody PagamentoRequestDto pagamentoDto) {
        PagamentoResponseDto responseDto = pagamentoService.processarPagamento(pagamentoDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }
}
