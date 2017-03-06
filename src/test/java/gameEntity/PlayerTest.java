package gameEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

	@Before
	public void setUp() {
		testInstance.setName("Alex");
		testInstance.setGold(createRawMaterial("gold", 5, 15, 1));
		testInstance.setBlueMana(createRawMaterial("BM", 6, 15, 2));
		testInstance.setGreenMana(createRawMaterial("GM", 7, 15, 3));
		testInstance.setRedMana(createRawMaterial("RM", 8, 15, 4));
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

	private RawMaterial createRawMaterial(String name, int amount, int max, int grow) {
		RawMaterial r = new RawMaterial();
		r.setName(name);
		r.setAmount(amount);
		r.setGrow(grow);
		r.setMaxAmount(max);
		return r;
	}

	//TODO Later
	@Test
	public void checkNextRound() {
		testInstance.nextRound();
		assertEquals(testInstance.getGold().getAmount(), 6);
		assertEquals(testInstance.getBlueMana().getAmount(), 8);
		assertEquals(testInstance.getGreenMana().getAmount(), 10);
		assertEquals(testInstance.getRedMana().getAmount(), 12);
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

}
