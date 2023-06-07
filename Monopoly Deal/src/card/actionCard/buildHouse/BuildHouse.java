package card.actionCard.buildHouse;

import card.CardKind;
import card.actionCard.ActionCard;
import card.propertyCard.PropertyCard;
import general.Colour;
import general.Player;

import java.util.ArrayList;

public class BuildHouse extends ActionCard {
    public BuildHouse() {
        super(4, "BuildHouse", CardKind.BuildHouse);
    }


    public void use(Player player) {

        ArrayList<PropertyCard> playerProperties = player.getAllProperties();
        // 检查玩家是否拥有完整的房产集合，如果有，则添加房屋并更新租金
        if (player.completeSet(playerProperties)) {
            // 遍历玩家的所有房产卡片
            for (PropertyCard property : playerProperties) {
                if (property.getAddHouse()) {
                    property.addHouse();
                    property.updateRent(); // 更新租金
                }
            }
        }
    }
}
