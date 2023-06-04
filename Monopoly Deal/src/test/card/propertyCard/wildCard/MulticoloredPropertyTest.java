package test.card.propertyCard.wildCard; 

import card.propertyCard.PropertyCard;
import card.propertyCard.wildCard.MulticoloredProperty;
import general.Colour;
import general.Game;
import general.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MulticoloredProperty Tester. 
* 
* @author tianj
*/ 
public class MulticoloredPropertyTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: flip(Player player, Colour colour) 
* 
*/ 
@Test
public void testFlip() throws Exception {
    PropertyCard propertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLACK);
    Player player = new Player("john",new Game());
    propertyCard.use(player);
    MulticoloredProperty multicoloredProperty = new MulticoloredProperty();
    multicoloredProperty.flip(player,Colour.BLUE);
    Assert.assertEquals(multicoloredProperty.rentList.length,3);
} 


} 
