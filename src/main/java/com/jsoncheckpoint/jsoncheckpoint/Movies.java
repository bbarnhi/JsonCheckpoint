package com.jsoncheckpoint.jsoncheckpoint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Movies {

    //Only important field for this checkpoint is Gross
    private double gross;
    public double getGross() {
        return gross;
    }
    public void setGross(double gross) {
        this.gross = gross;
    }
    ///////////////////////////////////////////////////

///////////////// Remaining JSON fields  In Primary Tier
    private String title;
    private int minutes;
    private String genre;
    private double rating;
    private int metaScore;
    private String description;
    private int votes;
    private String year;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getMinutes() { return minutes; }
    public void setMinutes(int minutes) { this.minutes = minutes; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getMetaScore() { return metaScore; }
    public void setMetaScore(int metaScore) { this.metaScore = metaScore; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getVotes() { return votes; }
    public void setVotes(int votes) { this.votes = votes; }
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }
///////////////////////////

///////////////////////////  Tier 2 of Json
//    private String[] credits;  // This doesnt work in this case
//  Per Json... Credit is "credits: ["  this is an array with inner class of Person
    private Credit[] credits;

    @JsonProperty("Credits")
    public Credit[] getCredits() { return credits; }
    @JsonProperty("credits")
    public void setCredits(Credit[] credits) { this.credits = credits; }

    ////////////////  Setting up Tier 3 - Inner class of Person inside Credits
    static class Credit {
        private Person person;

        @JsonProperty("Person") //Forces Json to print out with Camel Case
        public Person getPerson() { return person; }
        @JsonProperty("person") //Forces any return of Json to be Snake Case
        public void setPerson(Person person) { this.person = person; }

        @JsonInclude(JsonInclude.Include.NON_NULL) //Removes returns that contain a null
        static class Person {
            private String firstName;
            private String lastName;
            private String role;

            public String getRole() { return role; }
            public void setRole(String role) { this.role = role; }

            @JsonProperty("FirstName") //Forces Json to print out with Camel Case
            public String getFirstName() { return firstName; }
            @JsonProperty("firstName") //Forces any return of Json to be Snake Case
            public void setFirstName(String firstName) { this.firstName = firstName; }

            @JsonProperty("LastName") //Forces Json to print out with Camel Case
            public String getLastName() { return lastName; }
            @JsonProperty("lastName") //Forces any return of Json to be Snake Case
            public void setLastName(String lastName) { this.lastName = lastName; }
        }
    }
}
