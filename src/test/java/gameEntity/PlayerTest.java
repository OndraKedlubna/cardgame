package gameEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Before
	public void setUp() {
		testInstance.setName("Alex");
		testInstance.setGold(createRawMaterial("gold", 5, 15, 1));
		testInstance.setBlueMana(createRawMaterial("BM", 6, 15, 2));
		testInstance.setGreenMana(createRawMaterial("GM", 7, 15, 3));
		testInstance.setRedMana(createRawMaterial("RM", 8, 15, 4));
		testInstance.setHand(Arrays.asList(card1, card2));
		testInstance.setDeletePack(Arrays.asList(card3, card4));
		testInstance.setPack(Arrays.asList(card5, card6));
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

	//TODO
	@Test
	public void checkThrowCard() {
		assertEquals(2, testInstance.getHand().size());
		assertEquals(2, testInstance.getDeletePack().size());
		testInstance.throwCard(testInstance.getHand().get(0));
		assertEquals(1, testInstance.getHand().size());
		assertEquals(3, testInstance.getDeletePack().size());
	}

	//?
	@Test
	public void testRefillPack() {
		testInstance.setPack(new ArrayList<>());
		assertEquals(2, testInstance.getDeletePack().size());
		assertEquals(0, testInstance.getPack().size());
		testInstance.refillPack();
		assertEquals(0, testInstance.getDeletePack().size());
		assertEquals(2, testInstance.getPack().size());
	}

	//TODO
	@Test
	public void testPickCard() {
		testInstance.getHand().add(testInstance.pickCard());
		testInstance.getHand().add(testInstance.pickCard());
		assertEquals(4, testInstance.getHand().size());
		assertEquals(0, testInstance.getPack().size());
	}

	//TODO
	@Test
	public void testPickCardReffil() {
		//testInstance.getDeletePack().add(new RedEnergy());
		testInstance.setPack(new ArrayList<>());
		assertEquals(3, testInstance.getDeletePack().size());
		assertEquals(0, testInstance.getPack().size());
		testInstance.getHand().add(testInstance.pickCard());
		assertEquals(3, testInstance.getHand().size());
		assertEquals(0, testInstance.getDeletePack().size());
		assertEquals(2, testInstance.getPack().size());
	}

	//OK
	@Test
	public void testPickCardNull() {
		testInstance.setPack(new ArrayList<>());
		testInstance.setDeletePack(new ArrayList<>());
		assertNull(testInstance.pickCard());
	}

	//TODO
	@Test
	public void testGainCard() {
		assertEquals(2, testInstance.getHand().size());
		assertTrue(testInstance.gainCard());
		assertEquals(3, testInstance.getHand().size());
	}

	//OK
	@Test
	public void testGainCardNull() {
		testInstance.setPack(new ArrayList<>());
		testInstance.setDeletePack(new ArrayList<>());
		assertEquals(2, testInstance.getHand().size());
		assertFalse(testInstance.gainCard());
		assertEquals(2, testInstance.getHand().size());
	}

}
