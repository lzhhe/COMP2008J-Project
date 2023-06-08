package general;

import card.CardKind;
import card.actionCard.steal.DealBreaker;
import card.moneyCard.MoneyCard;
import card.propertyCard.PropertyCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Test {

    public static void main(String[] arg){

        Player player = new Player("Aegis",LocalDate.parse("2003-01-23", DateTimeFormatter.ISO_LOCAL_DATE));
        player.bank(new MoneyCard(10,"ten dollar"));
        player.bank(new MoneyCard(10,"ten dollar"));

        player.decks.add(new MoneyCard(10,"ten dollar"));
        player.decks.add(new DealBreaker());

        PropertyCard propertyCard1 = new PropertyCard(3, "Yellow1", CardKind.PropertyCard, new int[]{2, 4, 6},Colour.YELLOW);
        PropertyCard propertyCard2 = new PropertyCard(3, "Yellow2", CardKind.PropertyCard, new int[]{2, 4, 6},Colour.YELLOW);
        PropertyCard propertyCard3 = new PropertyCard(3, "Yellow1", CardKind.PropertyCard, new int[]{2, 4, 6},Colour.YELLOW);

        propertyCard1.use(player);


        player.printInformation();
    }
}
