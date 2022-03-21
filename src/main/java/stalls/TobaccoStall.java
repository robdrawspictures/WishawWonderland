package stalls;

import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

public class TobaccoStall extends Stall implements IReviewed, ISecurity {

    public TobaccoStall(String name, int rating, String ownerName, ParkingSpot parkingSpot) {
        super(name, rating, ownerName, parkingSpot);
    }

    public boolean isAllowed(Visitor visitor){
        if(visitor.getAge() < 18){
            return false;
        } else{
            return true;
        }
    }

    public void sellBaccy(Visitor visitor){
        if(isAllowed(visitor)){
            double virginiaGold = 5.0;
            double wallet = visitor.getMoney();
            double charge = wallet - virginiaGold;
            visitor.setMoney(charge);
        }
    }
}
