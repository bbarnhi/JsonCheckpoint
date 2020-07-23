package com.jsoncheckpoint.jsoncheckpoint;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.jsoncheckpoint.jsoncheckpoint.Movies.*;

@RestController
public class checkpoint {

    @GetMapping("/movies/movie")
    // public Map<String, String> getMovie() { //MAP forces type thats wrong
    public Movies getMovie(){
        Movies movies = new Movies();
        //Movie 1 //Only takes Strings...needs to take a variety...
//        movieDetails.put("minutes", "175");
//        Original method.   needs to be be set to correctly referenc emovies.
//        Put works to display directly to screen

        movies.setTitle("The Godfather");
        movies.setGenre("Crime, Drama");
        movies.setRating(9.2);
        movies.setMetaScore(100);
        movies.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        movies.setVotes(1561591);
        movies.setGross(134.97);
        movies.setYear("1972");
        movies.setMinutes(175);

        //movieDetails.put("credits", credits);

        //Credits
        Movies.Credit[] credits = new Movies.Credit[5]; //hard coded 5?

        //credits.put("credits", "placeholder");

        // Actors -- Need to create a new PERSON for each object
        Movies.Credit.Person person1 = new Movies.Credit.Person();
        person1.setRole("director");
        person1.setFirstName("Francis Ford");
        person1.setLastName("Copolla");
        Movies.Credit.Person person2 = new Movies.Credit.Person();
        person2.setRole("Star");
        person2.setFirstName("Marlon");
        person2.setLastName("Brando");
        Movies.Credit.Person person3 = new Movies.Credit.Person();
        person3.setRole("Star");
        person3.setFirstName("Al");
        person3.setLastName("Pacino");
        Movies.Credit.Person person4 = new Movies.Credit.Person();
        person4.setRole("Star");
        person4.setFirstName("James");
        person4.setLastName("Caan");
        Movies.Credit.Person person5 = new Movies.Credit.Person();
        person5.setRole("Star");
        person5.setFirstName("Diane");
        person5.setLastName("Keaton");

        // Adding New person objects to the Credits object
        // could be done in a for loop?
        credits[0] = new Movies.Credit();
        credits[0].setPerson(person1);
        credits[1] = new Movies.Credit();
        credits[1].setPerson(person2);
        credits[2] = new Movies.Credit();
        credits[2].setPerson(person3);
        credits[3] = new Movies.Credit();
        credits[3].setPerson(person4);
        credits[4] = new Movies.Credit();
        credits[4].setPerson(person5);
        movies.setCredits(credits);

        return movies;
    }

    @PostMapping("/movies/gross/total")
    // public String findGross(@RequestBody Movies movieDetails){  //Original method (bad)
        public Map<String, Double> totalGross(@RequestBody() Movies[] movieDetails){
//        Movies returnValue = new Movies(); // Original Attempt...
//        returnValue.setGross(movieDetails.getGross()); //Close but not quite
        Double total = 0.0;
        //for (int i =0; i < movieDetails.getGross(); i++) {
        for (Movies movies : movieDetails){  // for (ClassName LocalVariableName : PublicFunctionVariable)
            total +=movies.getGross();
        }
        Map<String, Double> result = new HashMap<>(); // creating a new hashmap to force result into total gross format
        result.put("result", total);

        return result; // Returns almost correctly....but to the 10 decimal placE?
    }
}
