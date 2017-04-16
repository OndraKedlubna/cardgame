package card;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import gameEntity.Player;
import gameEntity.RawMaterial;

@RunWith(MockitoJUnitRunner.class)
public class RedEnergyTest {
	
	@InjectMocks
	private RedEnergy testInstance;
	
	@Mock
	private Player player1;
	
	@Mock
	private Player player2;
	
	@Mock
	private Player player3;
	
	@Mock
	private Player player4;
	
	@Mock
	private RawMaterial redMana;
	
	private List<Player> players;
	
	@Before
	public void setUp(){
		Mockito.when(player1.getName()).thenReturn("Alex");
		players = Arrays.asList(player1, player2, player3, player4);
	}
	
	@Test
	public void testEfect(){
		Mockito.when(player1.getRedMana()).thenReturn(redMana);
		String result = testInstance.doEffect(player1, players);
		Mockito.verify(redMana).increase(5);
		System.out.println(result);
	}

}
