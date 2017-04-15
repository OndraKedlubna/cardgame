package game;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import enums.AnswerType;
import gameEntity.Player;
import gameEntity.Turn;
import simpleEntity.Answer;

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
	
	@Mock
	private Turn turn;
	
	@Mock
	private Answer answer;
	
	private List<Player> players;
	
	@Before
    public void setUp() {
		players = Arrays.asList(player1, player2, player3, player4);
		testInstance.setPlayers(players);
		testInstance.setPlayerOnTurn(player1);
		Mockito.when(player1.isStarter()).thenReturn(true);
		Mockito.when(player2.isStarter()).thenReturn(false);
		Mockito.when(player3.isStarter()).thenReturn(false);
		Mockito.when(player4.isStarter()).thenReturn(false);
		Mockito.when(turn.getAnswer()).thenReturn(answer);
		Mockito.when(player1.getNextPlayer()).thenReturn(player2);
    }
	
	@Test
	public void testStartPlay(){
		Turn turn = testInstance.startPlay();
		Mockito.verify(player1).setAction(1);
		assertEquals(null, turn.getAction());
		assertEquals(null, turn.getAnswer());
		assertEquals(0, turn.getIdCard());		
	}
	
	@Test
	public void testDoTurn(){
		Mockito.when(answer.getType()).thenReturn(AnswerType.REJECT);
		testInstance.doPlay(turn);
		Mockito.verify(turn).doAction(player1, players);
	}
	
	@Test
	public void testDoTurnSetAction(){
		Mockito.when(player1.getAction()).thenReturn(4);
		Mockito.when(answer.getType()).thenReturn(AnswerType.ACCEPT);
		testInstance.doPlay(turn);
		Mockito.verify(player1).setAction(3);
	}
	
	
}
