package br.com.ebueno.app;

import br.com.ebueno.jms.JmsProducer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting application context...");
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        JmsProducer producer = (JmsProducer) ctx.getBean("jmsProducer");

        System.out.println("Sending demo messages...");
        producer.sendToProductQueue("Product: {id:1, name:\"Camisa\"}");
        producer.sendToCategoryQueue("Category: {id:10, name:\"Vestuário\"}");

        System.out.println("Messages sent. Waiting 5 seconds to receive messages...");
        Thread.sleep(5000);

        ctx.close();
        System.out.println("Context closed. Exiting.");
    }
}
