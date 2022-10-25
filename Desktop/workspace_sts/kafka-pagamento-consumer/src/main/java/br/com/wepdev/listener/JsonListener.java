package br.com.wepdev.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.wepdev.model.Pagamento;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {
	
	
	@SneakyThrows
	@KafkaListener(topics = "pagamento-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraude(@Payload Pagamento pagamento) {
		
		log.info("Recebi o pagamento {}", pagamento.toString());
		Thread.sleep(2000);
		
		log.info("Validando fraude... ");
		Thread.sleep(2000);
		
		log.info("Compra aprovada... ");
		Thread.sleep(2000);
	}

	
	@SneakyThrows
	@KafkaListener(topics = "pagamento-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pdfGenerator(@Payload Pagamento pagamento) {
		Thread.sleep(3000);
		log.info("Gerando PDF do produto de id {} ... ", pagamento.getId());
		Thread.sleep(3000);
	}
	
	
	@SneakyThrows
	@KafkaListener(topics = "pagamento-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() {
		
		Thread.sleep(3000);
		log.info("Enviando email de confirmação ... ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
