package test.card.actionCard;

import card.actionCard.*;
import card.CardKind;

import card.CardKind;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Game;
import general.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



public class DoubleRentTest {
/** 
* Double Rent Tester. 
* 
* @author tianj
*/ 
	@Before
	public void before() throws Exception { 
	} 

	@After
	public void after() throws Exception { 
	} 
	
	/** 
	* 
	* Method: use(Player user, Player target, Colour colour) 
	* 
	*/ 
	@Test
	public void testUse() throws Exception {
	// Set up user and target players
    Player user = new Player("Tom", LocalDate.of(2001, 9, 10));
    Player target = new Player("Jerry", LocalDate.of(2002, 9, 10));

    // Test use()
    DoubleRent doubleRent = new DoubleRent(4,"test",CardKind.MoneyCard);
    doubleRent.use(user, target);

    // Check if user's double rent flag is set to true
    Assert.assertTrue(user.isDoubleRent());
	}
}
