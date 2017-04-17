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
	protected RawMaterial redMana;
	
	@Mock
	protected RawMaterial greenMana;
	
	@Mock
	protected RawMaterial blueMana;
	
	@Mock
	protected RawMaterial gold;
	
	protected List<Player> players;
	
	protected abstract ICard getTestInstance();
	
	protected abstract void verifyEfect();
	
	protected abstract void verifyMessage(String result);
	
	@Before
	public void setUp(){
		Mockito.when(player1.getRedMana()).thenReturn(redMana);
		Mockito.when(player1.getBlueMana()).thenReturn(blueMana);
		Mockito.when(player1.getGreenMana()).thenReturn(greenMana);
		Mockito.when(player1.getBlueMana()).thenReturn(blueMana);
		Mockito.when(player1.getName()).thenReturn("Alex");
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
