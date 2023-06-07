package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class BuildHotel extends ActionCard implements Build{

    public BuildHotel() {
        super(4, "BuildHotel", CardKind.BuildHotel);
    }

    public void use(Player user, Colour colour) {
        // 获取玩家拥有的指定颜色的房产卡
        ArrayList<PropertyCard> properties = user.propertiesByColour.get(colour);

        // 检查是否集齐一套房产
        if (user.completeSet(properties)) {
            // 检查是否已经拥有一个房屋
            boolean hasHouse = false;
            for (PropertyCard property : properties) {
                if (property.getHouseCount() > 0) {
                    hasHouse = true;
                    break;
                }
            }

            if (hasHouse) {
                // 添加酒店，并更新租金
                for (PropertyCard property : properties) {
                    property.addHouses();
                    ArrayList newList = user.propertiesByColour.get(colour);
                    newList.add(this);
                    property.updateRent();
                }
            }
        }
        user.decks.remove(this);
    }

}
