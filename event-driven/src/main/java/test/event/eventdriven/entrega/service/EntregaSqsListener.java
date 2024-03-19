package test.event.eventdriven.entrega.service;

import org.springframework.stereotype.Component;

import io.awspring.cloud.sqs.annotation.SqsListener;

@Component
public class EntregaSqsListener {
    
    private final EntregaService entregaService;

    public EntregaSqsListener(EntregaService entregaService) {
        this.entregaService = entregaService;
    }

    @SqsListener("payments")
    public void receberMensagemSQS(String mensagemSQS) {
        try {
            // Aqui você pode processar a mensagem SQS como uma String simples
            System.out.println("Mensagem SQS recebida: " + mensagemSQS);

            // Você pode chamar o serviço de entrega diretamente ou converter a String para o formato desejado, se necessário
            entregaService.processarMensagemSQS(mensagemSQS);
        } catch (Exception e) {
            // Tratamento de exceção adequado, se necessário
            e.printStackTrace();
        }
    }
}
