package card;

import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class BlueEnergyTest extends AbstractCardTest {
	
	@InjectMocks
	private BlueEnergy testInstance;

	@Override
	protected ICard getTestInstance() {
		return testInstance;
	}

	@Override
	protected void verifyEfect() {
		Mockito.verify(blueMana1).increase(5);

	}

	@Override
	protected void verifyMessage(String result) {
		assertEquals(result, "Blue Mana of Alex increased + 5 to 0");

	}

}
