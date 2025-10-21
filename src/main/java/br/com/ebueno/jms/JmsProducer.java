package br.com.ebueno.jms;

import org.springframework.jms.core.JmsTemplate;

public class JmsProducer {
    private JmsTemplate jmsTemplate;

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendToProductQueue(final String message) {
        jmsTemplate.send("product.queue", session -> session.createTextMessage(message));
    }

    public void sendToCategoryQueue(final String message) {
        jmsTemplate.send("category.queue", session -> session.createTextMessage(message));
    }
}
