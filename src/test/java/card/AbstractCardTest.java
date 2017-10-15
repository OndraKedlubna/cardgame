package card;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import gameEntity.Player;
import gameEntity.RawMaterial;

@RunWith(MockitoJUnitRunner.Silent.class)
public abstract class AbstractCardTest {
	
	@Mock
	protected Player player1;
	
	@Mock
	protected Player player2;
	
	@Mock
	protected Player player3;
	
	@Mock
	protected Player player4;
	
	@Mock
	protected RawMaterial redMana1;
	
	@Mock
	protected RawMaterial greenMana1;
	
	@Mock
	protected RawMaterial blueMana1;

	@Mock
	protected RawMaterial redMana2;

	@Mock
	protected RawMaterial greenMana2;

	@Mock
	protected RawMaterial blueMana2;

    @Mock
    protected RawMaterial redMana3;

    @Mock
    protected RawMaterial greenMana3;

    @Mock
    protected RawMaterial blueMana3;

    @Mock
    protected RawMaterial redMana4;

    @Mock
    protected RawMaterial greenMana4;

    @Mock
    protected RawMaterial blueMana4;
	
	@Mock
	protected RawMaterial gold;
	
	protected List<Player> players;
	
	protected abstract ICard getTestInstance();
	
	protected abstract void verifyEfect();
	
	protected abstract void verifyMessage(String result);
	
	@Before
	public void setUp(){
		Mockito.when(player1.getRedMana()).thenReturn(redMana1);
		Mockito.when(player1.getBlueMana()).thenReturn(blueMana1);
		Mockito.when(player1.getGreenMana()).thenReturn(greenMana1);
		Mockito.when(player1.getBlueMana()).thenReturn(blueMana1);
		Mockito.when(player1.getName()).thenReturn("Alex");
        Mockito.when(player2.getRedMana()).thenReturn(redMana2);
        Mockito.when(player2.getBlueMana()).thenReturn(blueMana2);
        Mockito.when(player2.getGreenMana()).thenReturn(greenMana2);
        Mockito.when(player2.getBlueMana()).thenReturn(blueMana2);
        Mockito.when(player2.getName()).thenReturn("Bert");
        Mockito.when(player3.getRedMana()).thenReturn(redMana3);
        Mockito.when(player3.getBlueMana()).thenReturn(blueMana3);
        Mockito.when(player3.getGreenMana()).thenReturn(greenMana3);
        Mockito.when(player3.getBlueMana()).thenReturn(blueMana3);
        Mockito.when(player3.getName()).thenReturn("Cyril");
        Mockito.when(player4.getRedMana()).thenReturn(redMana4);
        Mockito.when(player4.getBlueMana()).thenReturn(blueMana4);
        Mockito.when(player4.getGreenMana()).thenReturn(greenMana4);
        Mockito.when(player4.getBlueMana()).thenReturn(blueMana4);
        Mockito.when(player4.getName()).thenReturn("Dave");
		players = Arrays.asList(player1, player2, player3, player4);
	}
	
	@Test
	public void testEfect(){
		getTestInstance().doEffect(player1, players);
		verifyEfect();
	}
	
	@Test
	public void testMessage(){
		String result = getTestInstance().doEffect(player1, players);
		verifyMessage(result);
	}

}
