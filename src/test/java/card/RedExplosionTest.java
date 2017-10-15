package card;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class RedExplosionTest extends AbstractCardTest {

    @Override
    @Before
    public void setUp() {
        super.setUp();
        Mockito.when(redMana1.getAmount()).thenReturn(5);
        Mockito.when(redMana2.getAmount()).thenReturn(10);
        Mockito.when(redMana3.getAmount()).thenReturn(15);
        Mockito.when(redMana4.getAmount()).thenReturn(20);
    }

    @InjectMocks
    private RedExplosion testInstance;

    @Override
    protected ICard getTestInstance() {
        return testInstance;
    }

    @Override
    protected void verifyEfect() {
        Mockito.verify(redMana1).decrease(20);
        Mockito.verify(redMana2).decrease(20);
        Mockito.verify(redMana3).decrease(20);
        Mockito.verify(redMana4).decrease(20);
    }

    @Override
    protected void verifyMessage(String result) {
        assertEquals(result, "Player Alex has now 5 red mana\r\n" +
                "Player Bert has now 10 red mana\r\n" +
                "Player Cyril has now 15 red mana\r\n" +
                "Player Dave has now 20 red mana\r\n");
    }
}
