package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public class Playground extends Attraction implements IReviewed, ISecurity {

    public Playground(String name, int rating) {
        super(name, rating);
    }

    public boolean isAllowed(Visitor visitor){
        if(visitor.getAge() <= 15){
            return true;
        } else{
            return false;
        }
    }
}
