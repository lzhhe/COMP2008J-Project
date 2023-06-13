package card.actionCard.aoe;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class RentCard extends ActionCard implements AOE {

    Colour colour1;
    Colour colour2;


    public RentCard(String name,Colour colour1,Colour colour2) {
        //maybe some question
        super(1,name,CardKind.RectCard);
        this.colour1 = colour1;
        this.colour2 = colour2;


    }

    @Override
    public void use(ArrayList<Player> playerList,Player user) {

        System.out.println("Please choose a colour to ask rent: [1]: "+colour1.toString()+" [2]: "+colour2.toString());
        //calculate the rent
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        Colour colour = choice==1?colour1:colour2;
        int number = user.propertiesByColour.get(colour).size();
        //in case oversize
        number= Math.min(user.propertiesByColour.get(colour).get(0).fullSets, number);
        int rent = user.propertiesByColour.get(colour).get(0).rentList[number-1];


        System.out.println("The rent you ask is "+rent);

        //need an if else to use double rent
        if (user.whetherDoubleRent()){
            rent = rent*2;
        }

        for (Player player : playerList){
            if (Objects.equals(user,player)){
                continue;
            }
            if (player.whetherSayNo()){
                continue;
            }else{
                player.pay(rent,user);
            }
        }
        user.decks.remove(this);


    }


}
