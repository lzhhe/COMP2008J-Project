package general;

import card.Card;
import card.CardKind;

import card.actionCard.ActionCard;
import card.actionCard.ForcedDeal;
import card.actionCard.PassGo;
import card.actionCard.aoe.BirthdayCard;
import card.actionCard.aoe.RentCard;
import card.actionCard.buildHouse.BuildHotel;
import card.actionCard.buildHouse.BuildHouse;
import card.actionCard.singleChoice.DebtCollector;
import card.actionCard.singleChoice.MulticoloredRentCard;
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
        player.printBankAndProperty();

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
                        case MulticoloredProperty:
                            System.out.println("you choose a multicolored property card");
                            MulticoloredProperty multicoloredProperty =(MulticoloredProperty) card;
                            multicoloredProperty.use(player);
                            player.printProperty();
                            break;
                        case PropertyCard:
                            System.out.println("you choose a property card");
                            PropertyCard propertyCard =(PropertyCard) card;
                            propertyCard.use(player);
                            player.printProperty();

                            break;

                        case StealDeal:
                            System.out.println("you choose to use a steal deal card");
                            StealDeal stealDeal = (StealDeal) card;
                            stealDeal.use(player,insertPlayer(),insetColour());
                            break;

                        case DealBreaker:
                            System.out.println("you choose to use a deal breaker card");
                            DealBreaker dealBreaker = (DealBreaker) card;
                            dealBreaker.use(player,insertPlayer(),insetColour());
                            break;

                        case PassGo:
                            System.out.println("you choose to use a PassGo card");
                            PassGo passGo = (PassGo) card;
                            passGo.use(player);
                            break;
                        case ForceDeal:
                            System.out.println("you choose to use a force deal card");
                            System.out.println("Please insert parameter following this order: target player, target colour, your colour");
                            ForcedDeal forcedDeal = (ForcedDeal) card;
                            forcedDeal.use(player,insertPlayer(),insetColour(),insetColour());
                            break;

                        case BuildHouse:
                            System.out.println("Please insert a colour to build house");
                            BuildHouse buildHouse = (BuildHouse) card;
                            buildHouse.use(player,insetColour());

                            break;

                        case BuildHotel:
                            System.out.println("Please insert a colour to build hotel");
                            BuildHotel buildHotel = (BuildHotel) card;
                            buildHotel.use(player,insetColour());

                            break;

                        case BirthdayCard:
                            System.out.println("you choose to use a birthday card");
                            BirthdayCard birthdayCard = (BirthdayCard) card;
                            birthdayCard.use(playerList,player);
                            break;

                        case DebtCollector:
                            System.out.println("you choose to use a debt collector card, please insert a player to ask 5M");
                            DebtCollector debtCollector = (DebtCollector) card;
                            debtCollector.use(player,insertPlayer());
                            break;

                        case RectCard:
                            System.out.println("you choose to use a rent card, please insert a colour to rent");
                            RentCard rentCard = (RentCard) card;
                            rentCard.use(playerList,player);//the last one is the use who ask money
                            break;

                        case MulticoloredRentCard:
                            System.out.println("you choose to use a multicolored rent card, please insert a colour and a player to rent");
                            MulticoloredRentCard multicoloredRentCard = (MulticoloredRentCard) card;
                            multicoloredRentCard.use(player,insertPlayer());
                            break;



                    }
                    discard.add(card);
                    return 1;


                case FLIP:
                    System.out.println("please insert a original colour");

                    Colour originalColour = insetColour();

                    ArrayList<PropertyCard> tempList=player.propertiesByColour.get(originalColour);

                    for (PropertyCard propertyCard:tempList){
                        if (propertyCard instanceof WildCard wildCard)
                        {
                            wildCard.flip(player);
                            break;
                        }else if (propertyCard instanceof MulticoloredProperty multicoloredProperty){
                            System.out.println("detect a multicoloredProperty card, you need insert a new target colour");
                            Colour targetColour  = insetColour();
                            multicoloredProperty.flip(player,targetColour);
                            break;
                        }
                    }


                    return 0;

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
        //for finish
        return null;
    }

    public Colour insetColour(){
        System.out.println("Please insert a colour");
        Scanner in = new Scanner(System.in);
        return Colour.valueOf(in.next());


    }

}