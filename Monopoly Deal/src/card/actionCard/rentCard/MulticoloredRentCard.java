package card.actionCard.rentCard;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;

import java.awt.*;

public class MulticoloredRentCard extends ActionCard implements Rent{
    private Color color_primary;
    private Color color_secondary;

    public MulticoloredRentCard(int value, String name, CardKind kind, Color pri, Color sec) {
        super(value,name,kind);
        this.color_primary = pri;
        this.color_secondary = sec;
    }

    public Color getPrimaryColor() {
        return this.color_primary;
    }

    public Color getSecondaryColor() {
        return this.color_secondary;
    };



    /*public void use(Player user, Player target, Deck d) {
        d.addUsed(this);
        int total = 0;

        for(CardStack cs: user.getProperties()) {
            String[] prices = cs.getPrices();
            if(cs.getColor().equals(this.getPrimaryColor())) {
                if(prices[cs.getCards().size()-1].equals("n/a")) {
                    total += 0;
                } else {
                    total += Integer.parseInt(prices[cs.getCards().size() - 1]);
                }
            }
        }

        for(CardStack cs: user.getProperties()) {
            String[] prices = cs.getPrices();
            if(cs.getColor().equals(this.getSecondaryColor())) {
                if(prices[cs.getCards().size()-1].equals("n/a")) {
                    total += 0;
                } else {
                    total += Integer.parseInt(prices[cs.getCards().size() - 1]);
                }
            }
        }

        if(user.isDoubleRent()) {
            total += total;
            user.setDoubleRent(false);
        }

        //System.out.println("Charging player " + total);


        if(!target.isBlocking()) {
            if(target.getTreasury() >= total) {
                target.subTreasury(total);
                user.addTreasury(total);
            } else {
                user.addTreasury(target.getTreasury());
                total -= target.getTreasury();
                target.subTreasury(target.getTreasury());

                while(total > 0) {
                    propertyCard c = target.findCheapest();

                    if(c != null) {
                        user.addProperty(c);
                        target.removeProperty(c);
                        total -= c.getValue();
                    } else {
                        break;
                    }
                }
            }
        }

        user.removeHand(this);
    }

    public void bank(Player user) {
        user.addTreasury(this.value);
        user.removeHand(this);
    }





}
