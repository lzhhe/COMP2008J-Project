package general;

import card.Card;
import card.CardKind;

import card.actionCard.ActionCard;
import card.actionCard.PassGo;
import card.actionCard.steal.StealDeal;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;

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
            boolean status = oneStep();
            if (!status){
                //pass
                break;

            }

            if (player.winGame()){
                win=true;
                break;
            }

            step++;
        }

        player.deleteCard();
        return win;
    }

    public boolean oneStep(){
        //need print
        player.printDeck();

        //accept the input of user
        Action action = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert what do you want to do: ");
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
                    }else if (bankCard  instanceof ActionCard card1){
                        card1.bank(player);
                    }
                    break;



                case USE:
                    System.out.println("please choose a card");
                    Card card = player.selectCardInDeck();
                    CardKind useCard = card.cardKind;
                    switch (useCard){
                        case PropertyCard:
                            System.out.println("you choose a property card");
                            PropertyCard propertyCard = (PropertyCard) card;
                            propertyCard.use(player);
                            player.printProperty();

                            break;

                        case StealDeal:
                            break;


                        case DealBreaker:
                            break;

                        case PassGo:
                            PassGo passGo = (PassGo) card;
                            passGo.use(player);
                            break;
                        case ForceDeal:
                            break;

                        case DoubleRent:
                            break;

                        /*case SayNo:
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


                case FLIP:
                    break;


                    //name of a wild card
                case PASS:
                    //skip the round
                    System.out.println("you skip you round");
                    return false;

            }
        }
        return true;
    }

}