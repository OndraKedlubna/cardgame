package card;

import org.mockito.InjectMocks;

import static org.junit.Assert.assertEquals;

public class RedExplosionTest extends AbstractCardTest {

    @InjectMocks
    private RedExplosion testInstance;

    @Override
    protected ICard getTestInstance() {
        return testInstance;
    }

    @Override
    protected void verifyEfect() {

    }

    @Override
    protected void verifyMessage(String result) {
        assertEquals(result, "aaa");
    }
}
