package be.ordina.prestige.service;

import be.ordina.prestige.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by JoLe on 01/02/2017.
 */
@Service
public class GitHubService {

    private final static HttpStatus STATUS_204 = HttpStatus.NO_CONTENT;
    private final static String GITHUB_MEMBERS_URI = "https://api.github.com/orgs/ordina-jworks/members/";

    private RestTemplate basicAuthRestTemplate;

    @Autowired
    public GitHubService(RestTemplate basicAuthRestTemplate){
        this.basicAuthRestTemplate = basicAuthRestTemplate;
    }

    public boolean isMemberOfJWorks(final GithubUser githubUser){
        return STATUS_204.equals(basicAuthRestTemplate.getForEntity(GITHUB_MEMBERS_URI + githubUser.getUser(), GithubUser[].class).getStatusCode());
    }
}
