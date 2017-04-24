/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package takarivi.bibtex;

import org.junit.rules.ExternalResource;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author pyykkomi
 */
public class ServerRule extends ExternalResource {
    private int port;
    ConfigurableApplicationContext app;

    public ServerRule(int port) {
        this.port = port;
    }
    
    @Override
    public void before() throws Throwable {
        app = SpringApplication.run(App.class);
    }
    
    @Override
    public void after() {
        app.close();
    }
}

