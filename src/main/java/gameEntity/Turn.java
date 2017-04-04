package gameEntity;

import java.util.List;

import card.ICard;
import enums.Action;
import enums.AnswerType;
import simpleEntity.Answer;

/**
 * Tah ve hre. Nastavi se akce a karta a pote je vracena odpoved.
 *
 */
public class Turn {
	private Action action;
	private int idCard;
	private Answer answer;

	/**
	 * 
	 * @param player hrac, ktery je na tahu
	 * @param players ostatni hraci
	 */
	public void doAction(Player player, List<Player> players) {
		if (action.equals(Action.PLAY)) {
			play(player, players);
		}
		if (action.equals(Action.THROW)) {
			throwCard(player);
		}
	}

	/**
	 * Zahraje vybranou kartu
	 * @param player hrac, ktery ma kartu hrat
	 * @param players ostatni hraci
	 */
	private void play(Player player, List<Player> players) {
		int i = player.getHand().size();
		if (idCard > i) {
			answer = new Answer(AnswerType.REJECT, "Chybně zadaný index karty");
		} else {
			if (compareValue(player, player.getHand().get(idCard - 1)) == false) {
				answer = new Answer(AnswerType.REJECT, "Na tuto kartu hráč nemá dostatek zdrojů");
			} else {
				answer = new Answer(AnswerType.ACCEPT, "Karta zahrána");
				answer.setCardAnswer(player.getHand().get(idCard - 1).doEffect(player, players));
			}
		}
	}

	/**
	 * Zahodi vybranou kartu
	 */
	private void throwCard(Player player) {
		int i = player.getHand().size();
		if (idCard > i) {
			answer = new Answer(AnswerType.REJECT, "Chybně zadaný index karty");
		} else {
			answer = new Answer(AnswerType.ACCEPT, "Karta zahozena");
			player.throwCard(player.getHand().get(idCard - 1));
		}
	}

	/**
	 * Vraci, zda ma hrac na zahrani dane karty dost surovin
	 * @param player hrac ktereho suroviny jsou porovnavany
	 * @param card carta, u ktere porovnavam cenu
	 * @return true, pokud si hrac kartu muze dovolit, jinak false
	 */
	public boolean compareValue(Player player, ICard card) {
		if (player.getGold().getAmount() < card.goldCost()) {
			return false;
		}
		if (player.getBlueMana().getAmount() < card.blueCost()) {
			return false;
		}
		if (player.getGreenMana().getAmount() < card.greenCost()) {
			return false;
		}
		if (player.getRedMana().getAmount() < card.redCost()) {
			return false;
		}
		return true;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer Answer) {
		this.answer = Answer;
	}
}
