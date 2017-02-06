package be.ordina.prestige.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by JoLe on 01/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUser {

    @JsonProperty("login")
    private String user;

    public GithubUser(){
        
    }

    public GithubUser(String name){
        this.user = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Github user: " + getUser();
    }


}
