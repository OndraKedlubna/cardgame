package game;

import java.util.List;
import java.util.stream.Collectors;

import enums.AnswerType;
import gameEntity.Player;
import gameEntity.Turn;

/**
 * Hlavni trida hry
 */
public class Game {

	private List<Player> players;
    private Player playerOnTurn;
    private boolean gameEnded;
    
    //TODO initGameMethod

    /**
     * Spusti hru. Predpoklada, ze hraci jsou nastaveni
     * @return Prazdny tah
     */
    public Turn startPlay() {
        playerOnTurn = findStarter();
        playerOnTurn.setAction(1);
        return new Turn();
    }

    /**
     * Zahraje tah, pokud poté hráč nemá akci, začne hrát další hráč
     *
     * @param turn
     * @return player on turn
     */
    public Turn doPlay(Turn turn) {
        doTurn(turn);
        if (playerOnTurn.getAction() < 1) {
        	if(playerWon(playerOnTurn)){
        		playerOnTurn.setPlayerWon(true);
        		gameEnded = true;
        	}
            playerOnTurn = playerOnTurn.getNextPlayer();
            playerOnTurn.setAction(1);
            playerOnTurn.fillHand();
            return turn;
        }
        return turn;
    }
    
    private boolean playerWon(Player player){
    	return player.getGold().getAmount() > 100;
    }

    /**
     * Zahraje tah. 
     * @param turn tah, ktery ma byt zahran
     */
    private void doTurn(Turn turn) {
        turn.doAction(playerOnTurn, players);
        if (turn.getAnswer().getType() == AnswerType.ACCEPT) {
            playerOnTurn.setAction(playerOnTurn.getAction() - 1);
        }
    }

    /**
     * Find starter. If exists only one starter, starter is return. Else return
     * null.
     *
     * @return start player
     */
    private Player findStarter() {
        List<Player> p = players.stream()
                .filter(i -> i.isStarter() == true)
                .collect(Collectors.toList());
        return p.size() == 1 ? p.get(0) : null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getPlayerOnTurn() {
        return playerOnTurn;
    }

    public void setPlayerOnTurn(Player playerOnTurn) {
        this.playerOnTurn = playerOnTurn;
    }

	public boolean isGameEnded() {
		return gameEnded;
	}

	public void setGameEnded(boolean gameEnded) {
		this.gameEnded = gameEnded;
	}
}
