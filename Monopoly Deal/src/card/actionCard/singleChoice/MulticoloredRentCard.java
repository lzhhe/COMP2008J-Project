package card.actionCard.singleChoice;

import card.CardKind;
import card.actionCard.ActionCard;
import card.actionCard.aoe.AOE;
import general.Colour;
import general.Player;

import java.util.Objects;
import java.util.Scanner;

public class MulticoloredRentCard extends ActionCard implements SingleChoice{


    public MulticoloredRentCard() {
        super(3, "MulticoloredRentCard", CardKind.MulticoloredRentCard);
    }

    @Override
    public void use(Player user,Player target) {
        System.out.println("Please insert a colour you want to choose");
        Scanner in = new Scanner(System.in);
        Colour colour = Colour.valueOf(in.next());


        int number = user.propertiesByColour.get(colour).size();
        //in case oversize
        number= Math.max(user.propertiesByColour.get(colour).get(0).fullSets, number);
        int rent = user.propertiesByColour.get(colour).get(0).rentList[number];


        if (target.whetherSayNo()){
            return;
        }else{
            target.pay(rent,user);
        }

        user.decks.remove(this);

    }



}
