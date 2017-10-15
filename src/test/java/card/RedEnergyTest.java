package card;

import static org.junit.Assert.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class RedEnergyTest extends AbstractCardTest {
	
	@InjectMocks
	private RedEnergy testInstance;
	
	@Override
	protected ICard getTestInstance() {
		return testInstance;
	}
	
	

	@Override
	protected void verifyEfect() {
		Mockito.verify(redMana1).increase(5);
	}



	@Override
	protected void verifyMessage(String result) {
		assertEquals(result, "Red Mana of Alex increased + 5 to 0");		
	}

	

}
