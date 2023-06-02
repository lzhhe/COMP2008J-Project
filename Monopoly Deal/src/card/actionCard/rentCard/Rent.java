package card.actionCard.rentCard;

import general.Player;

import java.awt.*;

public interface Rent {
    public Color getPrimaryColor();
    public void use(Player p1,Player p2);

    public void bank(Player p1);
}
