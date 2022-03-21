package attractions;

import behaviours.IReviewed;
import behaviours.ISecurity;
import behaviours.ITicketed;
import people.Visitor;

public class RollerCoaster extends Attraction implements IReviewed, ISecurity, ITicketed {

    public RollerCoaster(String name, int rating) {
        super(name, rating);
    }

    public double defaultPrice(){
        return 8.40;
    }

    public double priceFor(Visitor visitor){
        if(visitor.getHeight() > 200){
            return 16.80;
        } else {
            return defaultPrice();
        }
    }

    public boolean isAllowed(Visitor visitor){
        if(visitor.getAge() >= 12 && visitor.getHeight() >= 145){
            return true;
        } else{
            return false;
        }
    }

    public void charge(Visitor visitor) {
        if (isAllowed(visitor)) {
            double cost = priceFor(visitor);
            double wallet = visitor.getMoney();
            double newValue = wallet - cost;
            visitor.setMoney(newValue);
        }
    }


}
