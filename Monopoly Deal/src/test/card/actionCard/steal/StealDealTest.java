package test.card.actionCard.steal;

import card.CardKind;

import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Game;
import general.Player;
import card.actionCard.steal.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 


public class StealDealTest {


/** 
* StealDeal Tester. 
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
	// setting user and target
	Player user = new Player("Tom",new Game());
    Player target = new Player("Jerry",new Game());
    PropertyCard targetPropertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLUE);
    Colour colour =Colour.BLUE;
    // add target property card
    ArrayList<PropertyCard> targetOriginalList = new ArrayList<>();
    targetOriginalList.add(targetPropertyCard);
    target.propertiesByColour.put(colour, targetOriginalList);

    // test use()
    StealDeal stealDeal = new StealDeal();
    stealDeal.use(user, target, colour);

    // check target card amount
    ArrayList<PropertyCard> updatedTargetList = target.propertiesByColour.get(colour);
    Assert.assertEquals(2, updatedTargetList.size()); 

    // check target card amount
    ArrayList<PropertyCard> updatedUserList = user.propertiesByColour.get(colour);
    Assert.assertEquals(1, updatedUserList.size()); 

    
}



} 
