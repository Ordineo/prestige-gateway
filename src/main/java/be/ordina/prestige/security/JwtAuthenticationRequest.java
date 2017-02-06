package be.ordina.prestige.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String gitHubAlias;
    private String password;
    @JsonProperty("authenticated")
    private Boolean authenticated;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String username, String gitHubAlias, String password, Boolean authenticated) {
        this.setUsername(username);
        this.setGitHubAlias(gitHubAlias);
        this.setPassword(password);
        this.setAuthenticated(authenticated);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGitHubAlias() {
        return this.gitHubAlias;
    }

    public void setGitHubAlias(String gitHubAlias) {
        this.gitHubAlias = gitHubAlias;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAuthenticated() {
        return this.authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

}
