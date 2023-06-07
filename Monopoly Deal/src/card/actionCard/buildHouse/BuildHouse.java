package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import general.Player;
import general.Colour;
import card.propertyCard.PropertyCard;

import java.util.ArrayList;

public class BuildHouse extends ActionCard implements Build {

    public BuildHouse() {
        super(3, "BuildHouse", CardKind.BuildHouse);
    }

    public void use(Player user, Colour colour) {
        // 获取玩家拥有的指定颜色的房产卡
        ArrayList<PropertyCard> properties = user.propertiesByColour.get(colour);


        // 检查是否集齐一套房产
        if (user.completeSet(properties)) {
            // 检查是否还有可以添加房屋的房产卡
            for (PropertyCard property : properties) {
                if (property.getAddHouse()) {
                    // 添加房屋数量，并更新租金
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
