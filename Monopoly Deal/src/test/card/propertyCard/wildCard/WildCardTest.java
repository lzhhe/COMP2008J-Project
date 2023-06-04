package test.card.propertyCard.wildCard; 

import card.propertyCard.wildCard.WildCard;
import general.Colour;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* WildCard Tester. 
* 
* @author tianj
*/ 
public class WildCardTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: flip() 
* 
*/ 
@Test
public void testFlip() throws Exception {
    WildCard wildCard = new WildCard(0,"",new int[4], Colour.BLACK,new int[5], Colour.LIGHT_GREEN);
    Assert.assertEquals(wildCard.otherColour,Colour.LIGHT_GREEN);
    wildCard.flip();
    Assert.assertEquals(wildCard.otherColour,Colour.BLACK);

} 


} 
