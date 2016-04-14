package at.wortha.dezsys09.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.inject.Named;

/**
 * JerseyConfig
 *
 * @author Simon Wortha 5BHIT
 * @version 20160311.1
 */
@Named
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        this.register(UserEndpoint.class);
        this.register(UserRegisterEndpoint.class);
        this.register(UserLoginEndpoint.class);
        this.register(JacksonFeature.class);
    }
}