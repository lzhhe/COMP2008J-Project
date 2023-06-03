package test.card.propertyCard; 

import card.propertyCard.PropertyCard;

import general.Colour;
import general.Game;
import general.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* PropertyCard Tester. 
* 
* @author tianj
*/ 
public class PropertyCardTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: use(Player player) 
* 
*/ 
@Test
public void testUse() throws Exception {
    PropertyCard propertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLACK);
    Player player = new Player("john",new Game());
    propertyCard.use(player);
    Assert.assertEquals(player.propertiesByColour.get(Colour.BLACK).size(),1);
    propertyCard.use(player);
    Assert.assertEquals(player.propertiesByColour.get(Colour.BLACK).size(),2);
}

/** 
* 
* Method: getColour() 
* 
*/ 
@Test
public void testGetColour() throws Exception {
    PropertyCard propertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLACK);
    Assert.assertEquals(propertyCard.getColour(),Colour.BLACK);
} 

/** 
* 
* Method: getAddHouse() 
* 
*/ 
@Test
public void testGetAddHouse() throws Exception {
    PropertyCard propertyCard = new PropertyCard(0,"",null,new int[4], Colour.BLACK);
    Assert.assertEquals(propertyCard.getAddHouse(),false);
} 


} 
