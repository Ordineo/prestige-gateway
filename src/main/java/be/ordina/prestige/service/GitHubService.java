package be.ordina.prestige.service;

import be.ordina.prestige.model.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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

    private final static String GITHUB_MEMBERS_URI_1 = "https://api.github.com/orgs/ordina-jworks/members?page=1";
    private final static String GITHUB_MEMBERS_URI_2 = "https://api.github.com/orgs/ordina-jworks/members?page=2";
    private final static String GITHUB_MEMBERS_URI_3 = "https://api.github.com/orgs/ordina-jworks/members?page=3";
    private final static String PAGINATION_INFO = "Link";


    private RestTemplate basicAuthRestTemplate;

    @Autowired
    public GitHubService(RestTemplate basicAuthRestTemplate){
        this.basicAuthRestTemplate = basicAuthRestTemplate;
    }

    public List<GithubUser> getUsersFromJWorks(){

        GithubUser[] users_1 = basicAuthRestTemplate.getForObject(GITHUB_MEMBERS_URI_1, GithubUser[].class);
        GithubUser[] users_2 = basicAuthRestTemplate.getForObject(GITHUB_MEMBERS_URI_2, GithubUser[].class);
        GithubUser[] users_3 = basicAuthRestTemplate.getForObject(GITHUB_MEMBERS_URI_3, GithubUser[].class);


        //TODO This should be rewritten based on the hypermedia links send in the "Link" header
        //List<String> linkString =  basicAuthRestTemplate.getForEntity(GITHUB_MEMBERS_URI, GithubUser[].class).getHeaders().get(PAGINATION_INFO);

        return Stream
                .of(Arrays.stream(users_1), Arrays.stream(users_2), Arrays.stream(users_3))
                .flatMap(stream -> stream)
                .collect(Collectors.toList());
    }

    public boolean isMemberOfJWorks(final GithubUser githubUser){
        return getUsersFromJWorks()
                .stream()
                .anyMatch(e -> e.getUser().equals(githubUser.getUser()));
    }
}
