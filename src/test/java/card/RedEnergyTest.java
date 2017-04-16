package card;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import gameEntity.Player;

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
	
	private List<Player> players;
	
	@Before
	public void setUp(){
		players = Arrays.asList(player1, player2, player3, player4);
	}

}
