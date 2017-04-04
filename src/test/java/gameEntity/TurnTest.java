package gameEntity;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enums.Action;
import enums.AnswerType;

public class TurnTest {
	
	private Turn testInstance;
    private Player player;
    private List<Player> players;

    public TurnTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testInstance = new Turn();
        //player = new PlayerBuilder().buildPlayer("Alex", null, true);
        players = Arrays.asList(player);
        //player.getHand().add(new RedEnergy());
    }

    @Test
    public void testPlayAction() {
        testInstance.setIdCard(1);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(10, player.getRedMana().getAmount());
        assertEquals(AnswerType.ACCEPT, testInstance.getAnswer().getType());
    }

    @Test
    public void testPlayActionReject() {
        testInstance.setIdCard(2);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Chybně zadaný index karty",
                testInstance.getAnswer().getText());
    }
    
    @Test
    public void testPlayNotResourceReject() {
        player.getGold().setAmount(0);
        testInstance.setIdCard(1);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Na tuto kartu hráč nemá dostatek zdrojů",
                testInstance.getAnswer().getText());
    }

    @Test
    public void testThrowActionReject() {
        testInstance.setIdCard(2);
        testInstance.setAction(Action.THROW);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Chybně zadaný index karty",
                testInstance.getAnswer().getText());
    }

    @Test
    public void testCost() {
        //assertEquals(true, testInstance.compareValue(player, new RedEnergy()));
        player.getGold().setAmount(0);
        //assertEquals(false, testInstance.compareValue(player, new RedEnergy()));
    }

}
