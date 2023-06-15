package test.card.actionCard.aoe;

import card.Card;
import card.moneyCard.MoneyCard;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import card.CardKind;
import card.actionCard.aoe.BirthdayCard;
import general.Player;
import java.time.LocalDate;
import card.actionCard.DoubleRent;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Game;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.After;







/*
test for aoe.BirthdayCard

 @author tianj
*/


public class BirthdayCardTest {
        @Before
        public void before() throws Exception {
        }
        @After
        public void after() throws Exception {
        }




/*test for use()*/


       @Test
        public void testUse() throws Exception {
            // Set up user and target players
            Player user = new Player("Tom", LocalDate.of(2001, 9, 10));
            Player target1 = new Player("Jerry1", LocalDate.of(2002, 9, 10));
            Player target2 = new Player("Jerry2", LocalDate.of(2002, 9, 10));
            ArrayList<Player>  playerList = new ArrayList<>();

            playerList.add(user);
            playerList.add(target1);
            playerList.add(target1);

            user.bank(new MoneyCard(10,"ten dollar"));
            target1.bank(new MoneyCard(10,"ten dollar"));
            target1.bank(new MoneyCard(10,"ten dollar"));

            // Test use()
            BirthdayCard birthdayCard = new BirthdayCard();
            birthdayCard.use(playerList, user);

           // Assert statements to verify the expected behavior

           Assert.assertEquals(10, target1.getDeck());
           Assert.assertEquals(10, target2.getDeck());
       }
}

