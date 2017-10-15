package card;

import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class GreenEnergyTest extends AbstractCardTest {
	
	@InjectMocks
	private GreenEnergy greenEnergy;

	@Override
	protected ICard getTestInstance() {
		return greenEnergy;
	}

	@Override
	protected void verifyEfect() {
		Mockito.verify(greenMana1).increase(5);
	}

	@Override
	protected void verifyMessage(String result) {
		assertEquals(result, "Green Mana of Alex increased + 5 to 0");
		
	}

}
