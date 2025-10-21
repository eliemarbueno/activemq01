package br.com.ebueno.config;

/**
 * Classe de configuração simples que carrega URL, usuário e senha do ActiveMQ
 * a partir de variáveis de ambiente com valores padrão.
 */
public class AppConfig {
    private final String brokerUrl;
    private final String user;
    private final String password;

    public AppConfig() {
        String url = System.getenv("ACTIVEMQ_URL");
        if (url == null || url.isEmpty()) {
            url = "tcp://localhost:61616";
        }
        this.brokerUrl = url;

        String u = System.getenv("ACTIVEMQ_USER");
        if (u == null) {
            u = "admin";
        }
        this.user = u;

        String p = System.getenv("ACTIVEMQ_PASSWORD");
        if (p == null) {
            p = "admin";
        }
        this.password = p;
    }

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
