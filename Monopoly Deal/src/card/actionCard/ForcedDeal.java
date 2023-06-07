package card.actionCard;

import card.CardKind;

public class ForcedDeal extends ActionCard{
    public ForcedDeal(int value, String name, CardKind cardkind) {
        super(3, "ForcedDeal" , CardKind.ForceDeal);
    }

    @Override
    public void use() {

    }
}
