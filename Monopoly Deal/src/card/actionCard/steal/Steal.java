package card.actionCard.steal;

import general.Colour;
import general.Player;

public interface Steal {

    public void use (Player user, Player target, Colour colour);
}
