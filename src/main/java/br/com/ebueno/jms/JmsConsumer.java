package br.com.ebueno.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class JmsConsumer implements MessageListener {
    private final String name;

    public JmsConsumer() {
        this.name = "consumer";
    }

    public JmsConsumer(String name) {
        this.name = name;
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                String text = ((TextMessage) message).getText();
                System.out.println("[" + name + "] Received: " + text);
            } else {
                System.out.println("[" + name + "] Received non-text message: " + message);
            }
        } catch (Exception e) {
            System.err.println("[" + name + "] Error processing message: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
