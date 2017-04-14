package gameEntity;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import card.ICard;
import enums.Action;
import enums.AnswerType;

@RunWith(MockitoJUnitRunner.class)
public class TurnTest {
	
	@InjectMocks
	private Turn testInstance;
	
	@Mock
    private Player player;
	
	@Mock
    private Player player1;
	
	@Mock
    private Player player2;
	
	@Mock
    private Player player3;
    
    private List<Player> players;
    
    @Mock
    private ICard card;
    
    @Mock
    private ICard card2;
    
    @Mock
    private RawMaterial universalTestMaterial;
    
    @Mock
    private RawMaterial universalTestMaterial2;

    @Before
    public void setUp() {
        testInstance = new Turn();
        players = Arrays.asList(player1, player2, player3);
        Mockito.when(player.getHand()).thenReturn(Arrays.asList(card, card2));
    }

    @Test
    public void testPlayAction() {
    	initMaterials();
        testInstance.setIdCard(1);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.ACCEPT, testInstance.getAnswer().getType());
        assertEquals("Karta zahrána", testInstance.getAnswer().getText());
    }

    @Test
    public void testPlayActionReject() {
    	initMaterials();
        testInstance.setIdCard(3);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Chybně zadaný index karty",
                testInstance.getAnswer().getText());
    }
    
    @Test
    public void testPlayNotResourceReject() {
    	initMaterials();
        testInstance.setIdCard(1);
        Mockito.when(player.getGold()).thenReturn(universalTestMaterial2);
        testInstance.setAction(Action.PLAY);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Na tuto kartu hráč nemá dostatek zdrojů",
                testInstance.getAnswer().getText());
    }

    @Test
    public void testThrowActionReject() {
        testInstance.setIdCard(4);
        testInstance.setAction(Action.THROW);
        testInstance.doAction(player, players);
        assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
        assertEquals("Chybně zadaný index karty",
                testInstance.getAnswer().getText());
    }

    @Test
    public void testCost() {
    	initMaterials();
        assertEquals(true, testInstance.compareValue(player, card));
    }
    
    @Test
    public void testCostFailRed() {
    	initMaterials();
    	Mockito.when(player.getRedMana()).thenReturn(universalTestMaterial2);
        assertEquals(false, testInstance.compareValue(player, card));
    }
    
    @Test
    public void testCostFailBlue() {
    	initMaterials();
    	Mockito.when(player.getBlueMana()).thenReturn(universalTestMaterial2);
        assertEquals(false, testInstance.compareValue(player, card));
    }
    
    @Test
    public void testCostFailGreen() {
    	initMaterials();
    	Mockito.when(player.getGreenMana()).thenReturn(universalTestMaterial2);
        assertEquals(false, testInstance.compareValue(player, card));
    }
    
    @Test
    public void testCostFailGold() {
    	initMaterials();
    	Mockito.when(player.getGold()).thenReturn(universalTestMaterial2);
        assertEquals(false, testInstance.compareValue(player, card));
    }
    
    private void initMaterials(){
    	Mockito.when(player.getGold()).thenReturn(universalTestMaterial);
    	Mockito.when(player.getBlueMana()).thenReturn(universalTestMaterial);
    	Mockito.when(player.getRedMana()).thenReturn(universalTestMaterial);
    	Mockito.when(player.getGreenMana()).thenReturn(universalTestMaterial);
    	Mockito.when(card.blueCost()).thenReturn(2);
    	Mockito.when(card.redCost()).thenReturn(2);
    	Mockito.when(card.greenCost()).thenReturn(2);
    	Mockito.when(card.goldCost()).thenReturn(2);
    	Mockito.when(universalTestMaterial.getAmount()).thenReturn(3);
    	Mockito.when(universalTestMaterial2.getAmount()).thenReturn(1);
    }

}
