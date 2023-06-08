package general;

import card.Card;
import card.CardKind;
import card.actionCard.ActionCard;
import card.actionCard.steal.StealDeal;
import card.propertyCard.PropertyCard;

import java.util.Objects;
import java.util.Scanner;

public class Round {

    int step = 0;

    Player player;

    public Round(Player player){
        this.player = player;
    }
    public boolean inRound(){
        boolean win = false;
        //need a draw card

        while(step<3){
            boolean status = oneStep();
            if (!status){
                System.out.println("you pass your round");
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

        //accept the input of user
        Action action = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("please insert what What do you want to do: ");
        String userInput = scanner.nextLine();
        try {
            action = Action.valueOf(userInput);


        } catch (IllegalArgumentException e) {
            //check the action
            System.out.println("you insert a wrong action, please try again");
        }

        if (action != null) {
            String useOrder;
            String[] parts;
            scanner = new Scanner(System.in);
            useOrder = scanner.nextLine();
            parts = useOrder.split(" ");

            switch (action){
                //use card and ask information //switch
                //do some action
                case BANK:

                    for (Card card : player.decks){
                        if (Objects.equals(card.name, parts[0])){
                            player.bank(card);
                        }
                    }

                    //action card name or money card
                case USE:
                    CardKind useCard = CardKind.valueOf(parts[0]);
                    switch (useCard){
                        case PropertyCard  :
                            //add to propertyList
                            String name  = parts[1];
                            for (Card card:player.decks){
                                if (card instanceof PropertyCard propertyCard){
                                    if (Objects.equals(name,propertyCard.name)){
                                        propertyCard.use(player);
                                    }
                                }
                            }
                        case StealDeal:
                            String userName = parts[1];
                            String targetName = parts[2];
                            Colour colour = Colour.valueOf(parts[3]);
                            for (Card card:player.decks){
                                if (card instanceof StealDeal stealDeal){
                                    stealDeal.use();
                                }
                            }
                        case DealBreaker:
                        case PassGo:
                        case ForceDeal:
                        case DoubleRent:
                        case SayNo:
                        case BuildHouse:
                        case BuildHotel:
                        case BirthdayCard:
                        case DebtCollector:
                        case RectCard:
                        case MulticoloredRentCard:


                    }


                case FLIP:








                    //name of a wild card
                case PASS:
                    //skip the round
                    return false;

            }
        }







        return true;
    }

}