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
        // 检查玩家是否拥有完整的房产集合，如果有，则添加房屋并更新租金
        if (player.hasCompletePropertySet()) {
            // 获取玩家所有完整房产集合的颜色
            ArrayList<Colour> completeSetsColours = player.getCompleteSetsColours();

            // 遍历每个完整房产集合的颜色
            for (Colour colour : completeSetsColours) {
                // 获取该颜色的房产集合
                ArrayList<PropertyCard> targetProperties = player.propertiesByColour.get(colour);

                // 添加房屋到房产集合中的每张卡片
                for (PropertyCard property : targetProperties) {
                    if (property.getAddHouse()) {
                        property.addHouse();
                        property.updateRent(); // 更新租金
                    }
                }
            }
        }
    }
}
