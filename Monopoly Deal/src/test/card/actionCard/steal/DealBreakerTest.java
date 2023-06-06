package test.card.actionCard.steal;



import card.CardKind;


import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Game;
import general.Player;
import card.actionCard.steal.DealBreaker;
import card.actionCard.steal.StealDeal;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

public class DealBreakerTest {
	/** 
	* DealBreaker Tester. 
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
			Player user = new Player("Tom",new Game());
			Player target = new Player("Jerry",new Game());
	        Colour colour = Colour.BLUE; 
	        
	        PropertyCard targetPropertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLUE);
	        ArrayList<PropertyCard> targetOriginalList = new ArrayList<>();
	        targetOriginalList.add(targetPropertyCard);
	        target.propertiesByColour.put(colour, targetOriginalList);
	        
	        DealBreaker dealBreaker = new DealBreaker();
	        dealBreaker.use(user, target, colour);
	        // check target card amount
	        ArrayList<PropertyCard> updatedTargetList = target.propertiesByColour.get(colour);
	        Assert.assertNull(updatedTargetList);

	        // check target card amount

	        Assert.assertTrue(user.propertiesByColour.containsKey(colour));
	    
	}

}
