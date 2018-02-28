package com.example.demo.Controller;
import com.example.demo.Model.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Mina_Yousry on 27/02/2018.
 */

@RestController
public class
HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String getHello(){
        return "Hello world";
    }

    @RequestMapping(value = "/leagues", method = RequestMethod.GET)
    public League[] getLeague()
    {

        final String uri = "https://www.football-data.org/v1/competitions/";
        RestTemplate restTemplate = new RestTemplate();
        League[] lea =  restTemplate.getForObject(uri, League[].class);
        return (lea);
    }
    @RequestMapping(value = "/leagues/{id}", method = RequestMethod.GET)
    public Table getLeague(@PathVariable String id)
    {

        final String uri = "https://www.football-data.org/v1/competitions/"+id+"/leagueTable";
        RestTemplate restTemplate = new RestTemplate();
        Table lea =  restTemplate.getForObject(uri, Table.class);
        return (lea);
    }
    @RequestMapping(value = "/leagues/{id}/teams", method = RequestMethod.GET)
    public LeagueTeams getLeagueteam(@PathVariable String id)
    {

        final String uri = "https://www.football-data.org/v1/competitions/"+id+"/teams";
        RestTemplate restTemplate = new RestTemplate();
        LeagueTeams lea =  restTemplate.getForObject(uri, LeagueTeams.class);
        return (lea);
    }

    @RequestMapping(value = "/teams/{id}/players", method = RequestMethod.GET)
    public Team getTeam(@PathVariable String id)
    {
        final String uri = "https://www.football-data.org/v1/teams/"+id+"/players";
        RestTemplate restTemplate = new RestTemplate();
        Team lea =  restTemplate.getForObject(uri, Team.class);
        return (lea);
    }


    @RequestMapping(value = "/teams/{id}/fixtures", method = RequestMethod.GET)
    public Fixtures getTeamFixtures(@PathVariable String id)
    {
        final String uri = "https://www.football-data.org/v1/teams/"+id+"/fixtures";
        RestTemplate restTemplate = new RestTemplate();
        Fixtures lea =  restTemplate.getForObject(uri, Fixtures.class);
        return (lea);
    }


}