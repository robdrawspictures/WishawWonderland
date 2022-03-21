package attractions;

import behaviours.IReviewed;
import behaviours.ITicketed;
import people.Visitor;

public class Dodgems extends Attraction implements IReviewed, ITicketed {

    public Dodgems(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice(){
        return 4.50;
    }

    public double priceFor(Visitor visitor){
        if(visitor.getAge() < 12){
            return 2.25;
        } else {
            return defaultPrice();
        }
    }

    public void charge(Visitor visitor){
        double cost = priceFor(visitor);
        double wallet = visitor.getMoney();
        double newValue = wallet - cost;
        visitor.setMoney(newValue);
    }
}
