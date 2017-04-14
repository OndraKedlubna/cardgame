package game;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import gameEntity.Player;
import gameEntity.Turn;

@RunWith(MockitoJUnitRunner.class)
public class GameTest {

	@InjectMocks
	private Game testInstance;
	
	@Mock
	private Player player1;
	
	@Mock
	private Player player2;
	
	@Mock
	private Player player3;
	
	@Mock
	private Player player4;
	
	@Before
    public void setUp() {
		testInstance.setPlayers(Arrays.asList(player1, player2, player3, player4));
		testInstance.setPlayerOnTurn(player1);
		Mockito.when(player1.isStarter()).thenReturn(true);
		Mockito.when(player2.isStarter()).thenReturn(false);
		Mockito.when(player3.isStarter()).thenReturn(false);
		Mockito.when(player4.isStarter()).thenReturn(false);
    }
	
	@Test
	public void testStartPlay(){
		Turn turn = testInstance.startPlay();
		Mockito.verify(player1).setAction(1);
		assertEquals(null, turn.getAction());
		assertEquals(null, turn.getAnswer());
		assertEquals(0, turn.getIdCard());
		
	}
	
}
