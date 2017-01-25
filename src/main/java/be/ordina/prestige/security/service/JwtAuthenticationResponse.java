package be.ordina.prestige.security.service;

import java.io.Serializable;

/**
 * Created by JoLe on 25/01/2017.
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
