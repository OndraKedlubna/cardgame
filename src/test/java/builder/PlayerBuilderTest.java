package builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import gameEntity.Player;

@RunWith(MockitoJUnitRunner.class)
public class PlayerBuilderTest {

	@InjectMocks
	private static PlayerBuilder testInstance;

	@Test
	public void buildPlayerTest() {
		Player p = testInstance.buildPlayer("alex", null, true);
		Player p2 = testInstance.buildPlayer("franta", p, false);
		assertEquals(p.getName(), "alex");
		assertEquals(p.isStarter(), true);
		assertEquals(p2.getNextPlayer(), p);
		assertEquals(p.getHand().size(), 0);
		assertFalse(p.isPlayerWon());

		assertEquals(p.getGold().getName(), "gold");
		assertEquals(p.getGold().getMaxAmount(), 50);
		assertEquals(p.getGold().getAmount(), 5);
		assertEquals(p.getGold().getGrow(), 1);

		assertEquals(p.getBlueMana().getName(), "BM");
		assertEquals(p.getBlueMana().getMaxAmount(), 50);
		assertEquals(p.getBlueMana().getAmount(), 5);
		assertEquals(p.getBlueMana().getGrow(), 1);

		assertEquals(p.getRedMana().getName(), "RM");
		assertEquals(p.getRedMana().getMaxAmount(), 50);
		assertEquals(p.getRedMana().getAmount(), 5);
		assertEquals(p.getRedMana().getGrow(), 1);

		assertEquals(p.getGreenMana().getName(), "GM");
		assertEquals(p.getGreenMana().getMaxAmount(), 50);
		assertEquals(p.getGreenMana().getAmount(), 5);
		assertEquals(p.getGreenMana().getGrow(), 1);
	}

}
