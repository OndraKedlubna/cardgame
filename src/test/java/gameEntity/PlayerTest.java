package gameEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import card.ICard;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

	@InjectMocks
	private static Player testInstance;
	
	@Mock
	private ICard card1;
	
	@Mock
	private ICard card2;
	
	@Mock
	private ICard card3;
	
	@Mock
	private ICard card4;
	
	@Mock
	private ICard card5;
	
	@Mock
	private ICard card6;
	
	@Mock
	private ICard card7;
	
	@Mock
	private RawMaterial gold;
	
	@Mock
	private RawMaterial blueMana;
	
	@Mock
	private RawMaterial greenMana;
	
	@Mock
	private RawMaterial redMana;

	@Before
	public void setUp() {
		testInstance.setName("Alex");
		testInstance.setGold(gold);
		testInstance.setBlueMana(blueMana);
		testInstance.setGreenMana(greenMana);
		testInstance.setRedMana(redMana);
		testInstance.setTower(0);
		List<ICard> hand = new ArrayList<>();
		hand.add(card1);
		hand.add(card2);
		testInstance.setHand(hand);
		List<ICard> deletePack = new ArrayList<>();
		deletePack.add(card3);
		deletePack.add(card4);
		testInstance.setDeletePack(deletePack);
		List<ICard> pack = new ArrayList<>();
		pack.add(card5);
		pack.add(card6);
		testInstance.setPack(pack);
	}

	@Test
	public void checkNextRound() {
		testInstance.nextRound();
		Mockito.verify(gold).increase();
		Mockito.verify(blueMana).increase();
		Mockito.verify(greenMana).increase();
		Mockito.verify(redMana).increase();
	}

	@Test
	public void checkThrowCard() {
		assertEquals(2, testInstance.getHand().size());
		assertEquals(2, testInstance.getDeletePack().size());
		testInstance.throwCard(testInstance.getHand().get(0));
		assertEquals(1, testInstance.getHand().size());
		assertEquals(3, testInstance.getDeletePack().size());
	}

	@Test
	public void testRefillPack() {
		testInstance.setPack(new ArrayList<>());
		assertEquals(2, testInstance.getDeletePack().size());
		assertEquals(0, testInstance.getPack().size());
		testInstance.refillPack();
		assertEquals(0, testInstance.getDeletePack().size());
		assertEquals(2, testInstance.getPack().size());
	}

	@Test
	public void testPickCard() {
		testInstance.getHand().add(testInstance.pickCard());
		testInstance.getHand().add(testInstance.pickCard());
		assertEquals(4, testInstance.getHand().size());
		assertEquals(0, testInstance.getPack().size());
	}

	@Test
	public void testPickCardReffil() {
		testInstance.getDeletePack().add(card7);
		testInstance.setPack(new ArrayList<>());
		assertEquals(3, testInstance.getDeletePack().size());
		assertEquals(0, testInstance.getPack().size());
		testInstance.getHand().add(testInstance.pickCard());
		assertEquals(3, testInstance.getHand().size());
		assertEquals(0, testInstance.getDeletePack().size());
		assertEquals(2, testInstance.getPack().size());
	}

	@Test
	public void testPickCardNull() {
		testInstance.setPack(new ArrayList<>());
		testInstance.setDeletePack(new ArrayList<>());
		assertNull(testInstance.pickCard());
	}

	@Test
	public void testGainCard() {
		assertEquals(2, testInstance.getHand().size());
		assertTrue(testInstance.gainCard());
		assertEquals(3, testInstance.getHand().size());
	}

	@Test
	public void testGainCardNull() {
		testInstance.setPack(new ArrayList<>());
		testInstance.setDeletePack(new ArrayList<>());
		assertEquals(2, testInstance.getHand().size());
		assertFalse(testInstance.gainCard());
		assertEquals(2, testInstance.getHand().size());
	}
	
	@Test
	public void testFillHand(){
		testInstance.fillHand();
		assertEquals(5, testInstance.getHand().size());
	}
	
	@Test
	public void testFillHandWithEmptyPack(){
		testInstance.setPack(new ArrayList<>());
		testInstance.fillHand();
		assertEquals(4, testInstance.getHand().size());
	}
	
	@Test
	public void testIncreaseTower(){
		testInstance.increaseTower();
		assertEquals(1, testInstance.getTower());
	}
	

}
