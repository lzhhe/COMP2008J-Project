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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import card.actionCard.aoe.RentCard;
import card.actionCard.aoe.BirthdayCard;








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
           ArrayList<Player> playerList = new ArrayList<>();

           playerList.add(user);
           playerList.add(target1);
           playerList.add(target1);

           user.bank(new MoneyCard(10,"ten dollar"));
           target1.bank(new MoneyCard(10,"ten dollar"));
           target1.bank(new MoneyCard(10,"ten dollar"));

           // Prepare user input
           ByteArrayInputStream inputStream = new ByteArrayInputStream("USE".getBytes());
           System.setIn(inputStream);



           // Redirect console output
           ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
           PrintStream originalOut = System.out;
           System.setOut(new PrintStream(outputStream));

           try {
               // Test use()
               BirthdayCard testBirthdayCard = new BirthdayCard();
               testBirthdayCard.use(playerList, user);

               // Get console output
               String consoleOutput = outputStream.toString();

               // Validate console output
               Assert.assertTrue(consoleOutput.contains("Jerry1 still need to pay 2"));




           } finally {
               // Reset System.in and System.out
               System.setIn(System.in);
               System.setOut(originalOut);
           }
       }
}

