# ActiveMQ Example (Java 1.8, Spring XML, no Spring Boot)

Projeto de exemplo que demonstra produtor e consumidor JMS usando ActiveMQ.

Características:
- Java 1.8
- Configuração Spring via XML (`applicationContext.xml`)
- Credenciais e broker configurable via variáveis de ambiente, encapsuladas em `AppConfig`.
- Filas fixas: `product.queue` e `category.queue`.

Variáveis de ambiente (opcionais):
- ACTIVEMQ_URL (default: tcp://localhost:61616)
- ACTIVEMQ_USER (default: admin)
- ACTIVEMQ_PASSWORD (default: admin)

Como compilar:

```bash
mvn -q -DskipTests package
```

Como executar (assumindo ActiveMQ na máquina local):

```bash
java -jar target/activemq-example-1.0.0.jar
```

Se quiser usar variáveis de ambiente:

```bash
ACTIVEMQ_URL="tcp://broker:61616" ACTIVEMQ_USER=me ACTIVEMQ_PASSWORD=secret java -jar target/activemq-example-1.0.0.jar
```

O `AppMain` envia duas mensagens de exemplo (uma para cada fila) e aguarda 5 segundos para permitir o consumo.

Comando para subir o activemq:
```
docker run -d --name activemq \
-p 61616:61616 \
-p 8161:8161 \
rmohr/activemq:5.15.9
```