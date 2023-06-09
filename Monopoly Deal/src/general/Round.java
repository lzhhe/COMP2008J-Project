package general;

import card.Card;
import card.CardKind;

import card.actionCard.ActionCard;
import card.actionCard.PassGo;
import card.actionCard.steal.DealBreaker;
import card.actionCard.steal.StealDeal;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;
import card.propertyCard.wildCard.MulticoloredProperty;
import card.propertyCard.wildCard.WildCard;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static general.Game.*;

public class Round {

    int step = 0;

    Player player;

    public Round(Player player){
        this.player = player;
    }
    public boolean inRound(){
        boolean win = false;


        if (player.decks.size()==0){
            for (int i=0; i<5;i++){
                Card card= cardLibrary.pop();
                player.decks.add(card);
            }

        }else{
            for (int i=0; i<2;i++){
                Card card= cardLibrary.pop();
                player.decks.add(card);
            }
        }

        while(step<3){
            int status = oneStep();
            if (status==-1){

                //pass
                break;

            }else if (status==0){
                //flip will not occupy a step
                step--;
            }

            if (player.winGame()){
                win=true;
                System.out.println(player.name+" WINNING!!!!!!!");
                break;
            }

            step++;
        }

        player.deleteCard();
        if (cardLibrary.size()<7){
            cardLibrary.addAll(discard);
            shuffle();

        }
        return win;
    }

    public int oneStep(){
        System.out.println("other player cards");
        //need print
        for (Player otherPlayer:playerList ){
            if (!Objects.equals(otherPlayer,player)){
                otherPlayer.printBankAndProperty();
            }
        }
        System.out.println("your cards");
        player.printDeck();

        //accept the input of user
        Action action = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert what do you want to do: (BANK/USE/FLIP/PASS)");
        String userInput = scanner.nextLine();
        try {
            action = Action.valueOf(userInput);


        } catch (IllegalArgumentException e) {
            //check the action
            System.out.println("you insert a wrong action, please try again");
        }

        if (action != null) {

            switch (action){
                //use card and ask information //switch
                //do some action
                case BANK:
                    System.out.println("please choose a money card");
                    Card bankCard = player.selectCardInDeck();
                    if (bankCard  instanceof MoneyCard card1){
                        card1.bank(player);
                    }else if (bankCard instanceof ActionCard card1){
                        card1.bank(player);
                    }
                    return 1;



                case USE:
                    System.out.println("please choose a card");
                    Card card = player.selectCardInDeck();
                    CardKind useCard = card.cardKind;


                    switch (useCard){
                        //different enum so it need to divide

                        case WildCard:
                            System.out.println("you choose a wild card");
                            WildCard wildCard =(WildCard) card;
                            wildCard.use(player);
                            player.printProperty();
                            break;
                        /*case MulticoloredProperty:
                            System.out.println("you choose a multicolored property card");
                            MulticoloredProperty multicoloredProperty =(MulticoloredProperty) card;
                            multicoloredProperty.use(player);
                            player.printProperty();

                            break;*/
                        case PropertyCard:
                            System.out.println("you choose a property card");
                            PropertyCard propertyCard =(PropertyCard) card;
                            propertyCard.use(player);
                            player.printProperty();

                            break;

                        case StealDeal:
                            StealDeal stealDeal = (StealDeal) card;
                            stealDeal.use(player,insertPlayer(),insetColour());
                            break;

                        case DealBreaker:
                            DealBreaker dealBreaker = (DealBreaker) card;
                            dealBreaker.use(player,insertPlayer(),insetColour());
                            break;

                        case PassGo:
                            PassGo passGo = (PassGo) card;
                            passGo.use(player);
                            break;
                        case ForceDeal:

                            break;

                        /*case DoubleRent:
                            break;*/


                        case BuildHouse:
                            break;

                        case BuildHotel:
                            break;

                        case BirthdayCard:
                            break;

                        case DebtCollector:
                            break;

                        case RectCard:
                            break;

                        case MulticoloredRentCard:
                            break;



                    }
                    discard.add(card);
                    return 1;


                case FLIP:
                    System.out.println("please insert the origin colour");
                    Scanner in  = new Scanner(System.in);
                    String colour1Name = in.next();

                    Colour originalColour = Colour.valueOf(colour1Name);

                    ArrayList<PropertyCard> tempList=player.propertiesByColour.get(originalColour);
                    WildCard wildCard = null;
                    for (PropertyCard propertyCard:tempList){
                        if (propertyCard instanceof WildCard){
                            wildCard =(WildCard) propertyCard;
                        }
                    }
                    if (wildCard != null) {
                        wildCard.flip(player);
                    }




                    return 0;


                    //name of a wild card
                case PASS:
                    //skip the round
                    System.out.println("you skip you round");
                    return -1;

            }
        }
        return -1;

    }

    public Player insertPlayer(){
        System.out.println("Please insert a target");
        Scanner in = new Scanner(System.in);
        String name  = in.next();
        for (Player target:playerList){
            if (Objects.equals(target.name, name)){
                return target;
            }

        }

        return null;
    }

    public Colour insetColour(){
        System.out.println("Please insert a colour");
        Scanner in = new Scanner(System.in);
        return Colour.valueOf(in.next());


    }

}