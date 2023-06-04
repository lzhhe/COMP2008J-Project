package test.card.moneyCard;


import card.moneyCard.MoneyCard;

import general.Colour;
import general.Game;
import general.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import static org.junit.Assert.*;
import card.Bank;

/** 
* MoneyCard Tester. 
* 
* @author tianj
*/ 

public class MoneyCardTest {



@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 



/** 
* 
* Method: Bank(Player Player) 
* 
*/ 
@Test
public void testBank() throws Exception {
	MoneyCard moneyCard = new MoneyCard(10, "Test Card");

    Player player = new Player("john",new Game());

    moneyCard.Bank(player);

    assertTrue(player.bankCount.contains(moneyCard));
}

/** 
* 
* Method: toString() 
* 
*/ 
@Test
public void testToString() throws Exception {
	String expected = "MoneyCard{value=100, name='Test Card'}";
    String actual = expected.toString();
    assertEquals(expected, actual);
} 

}