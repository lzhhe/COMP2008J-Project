/*
package test.card.actionCard.aoe;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import card.actionCard.aoe.RentCard;
import general.Player;
import general.Colour;

*/
/**
 * test for RentCards
 *
 * @author tianj
 *//*

public class RentCardTest {
    @Before
    public void before() throws Exception {
    }
    @After
    public void after() throws Exception {
    }

    @Test
    public void testUse() throws Exception {
        Player user = new Player("Tom", LocalDate.of(2001, 9, 10));
        Player target = new Player("Jerry",LocalDate.of(2002, 9, 10));
        ArrayList<Player>  playerList = new ArrayList<>();

        // 创建测试卡牌对象
        RentCard rentCard = new RentCard("Test Rent Card", Colour.BLUE, Colour.GREEN);

        // 添加玩家到玩家列表中
        playerList.add(user);
        playerList.add(target);

        // 在用户的卡牌列表中添加测试卡牌
        user.decks.add(rentCard);

        // 设置用户的属性和其他必要信息，例如 user.propertiesByColour 等

        // 调用 use 方法进行测试
        rentCard.use(playerList, user);

        // 验证测试结果
        // 例如，可以验证玩家列表中的玩家是否符合预期状态
        Assert.assertEquals(2, playerList.size()); // 玩家列表应该还有两个玩家

        // 可以继续添加其他的验证逻辑

        // 打印玩家列表和用户对象的信息
        System.out.println("玩家列表信息：");
        for (Player player : playerList) {
            System.out.println(player.toString());
        }

        System.out.println("用户信息：");
        System.out.println(user.toString());
    }
}
*/
