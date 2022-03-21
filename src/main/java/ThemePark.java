import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;
import stalls.Stall;

import java.util.ArrayList;
import java.util.HashMap;

public class ThemePark {

    private String name;
    private ArrayList<Attraction> attractions;
    private ArrayList<Stall> stalls;
    private HashMap<String, Integer> reviews;

    public ThemePark(String name){
        this.name = name;
        this.attractions = new ArrayList<>();
        this.stalls = new ArrayList<>();
        this.reviews = new HashMap<>();
    }

    public int getAttractCount(){
        return this.attractions.size();
    }

    public ArrayList<IReviewed> getReviewed(){
        ArrayList reviewed = new ArrayList<>();
        for(Attraction attraction : attractions){
            reviewed.add(attraction);
        }
        for(Stall stall : stalls){
            reviewed.add(stall);
        }
        return reviewed;
    }

    public void addAttraction(Attraction attraction){
        this.attractions.add(attraction);
    }

    public void addStall(Stall stall){
        this.stalls.add(stall);
    }

    public void visit(Visitor visitor, Attraction attraction){
        visitor.attractionVisited(attraction);
        attraction.incremenetVisitCount();
    }

    public HashMap<String, Integer> getReviews(){
        return this.reviews;
    }

    public int getHashSize(){
        return this.reviews.size();
    }

    public void createReviewHash(){
        ArrayList<IReviewed> reviewed = getReviewed();
        for(IReviewed review : reviewed){
            this.reviews.put(review.getName(), review.getRating());
        }
    }
}
