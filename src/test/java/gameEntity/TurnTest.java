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
    private RawMaterial testedGold;
    
    @Mock
    private RawMaterial testedBlue;
    
    @Mock
    private RawMaterial testedRed;
    
    @Mock
    private RawMaterial testedGreen;
    
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
    public void testBuildActionAccept(){
    	initMaterialsForBuild();
    	testInstance.setAction(Action.BUILD);
        testInstance.doAction(player, players);
    	assertEquals(AnswerType.ACCEPT, testInstance.getAnswer().getType());
    	assertEquals("Patro veze postaveno",
                testInstance.getAnswer().getText());  
    	Mockito.verify(testedGold).decrease(20);
    	Mockito.verify(testedBlue).decrease(5);
    	Mockito.verify(testedRed).decrease(5);
    	Mockito.verify(testedGreen).decrease(5);
    }
    
    @Test
    public void testBuildActionReject(){
    	initMaterials();
    	testInstance.setAction(Action.BUILD);
        testInstance.doAction(player, players);
    	assertEquals(AnswerType.REJECT, testInstance.getAnswer().getType());
    	assertEquals("Na stavbu veze neni dost penez",
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
    
    private void initMaterialsForBuild(){
    	Mockito.when(player.getGold()).thenReturn(testedGold);
    	Mockito.when(player.getBlueMana()).thenReturn(testedBlue);
    	Mockito.when(player.getRedMana()).thenReturn(testedRed);
    	Mockito.when(player.getGreenMana()).thenReturn(testedGreen);
    	Mockito.when(testedGold.getAmount()).thenReturn(20);
    	Mockito.when(testedBlue.getAmount()).thenReturn(5);
    	Mockito.when(testedRed.getAmount()).thenReturn(5);
    	Mockito.when(testedGreen.getAmount()).thenReturn(5);
    }

}
