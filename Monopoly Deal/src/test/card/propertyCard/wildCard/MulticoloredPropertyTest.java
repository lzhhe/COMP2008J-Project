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

import java.time.LocalDate;

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
    Player player = new Player("john", LocalDate.of(2001, 9, 10));
    MulticoloredProperty multicoloredProperty = new MulticoloredProperty();
    multicoloredProperty.flip(player,Colour.BLUE);
    Assert.assertEquals(2,multicoloredProperty.rentList.length);
    Assert.assertEquals(1,player.propertiesByColour.get(Colour.BLUE).size());
} 


} 
