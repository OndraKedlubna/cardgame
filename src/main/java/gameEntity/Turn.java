package gameEntity;

import java.util.List;

import card.ICard;
import constant.Constant;
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
		//TODO testBuildmethods
		if (action.equals(Action.BUILD)) {
			buildTower(player);
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
				//ODECITAJI SE ZDROJE
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
	
	private void buildTower(Player player){
		if(compareTowerValue(player)){
			player.getGold().decrease(Constant.GOLD_COST_TOWER);
			player.getBlueMana().decrease(Constant.BLUE_COST_TOWER);
			player.getRedMana().decrease(Constant.RED_COST_TOWER);
			player.getGreenMana().decrease(Constant.GREEN_COST_TOWER);
			player.increaseTower();
			answer = new Answer(AnswerType.ACCEPT, "Patro veze postaveno");
		} else {
			answer = new Answer(AnswerType.REJECT, "Na stavbu veze neni dost penez");
		}
	}
	
	/**
	 * Overuje, zda ma hrac dost surovin na stavbu patra.
	 * @return true, pokud hrac na stavbu ma
	 */
	public boolean compareTowerValue(Player player){
		if (player.getGold().getAmount() < Constant.GOLD_COST_TOWER) {
			return false;
		}
		if (player.getBlueMana().getAmount() < Constant.BLUE_COST_TOWER) {
			return false;
		}
		if (player.getGreenMana().getAmount() < Constant.GREEN_COST_TOWER) {
			return false;
		}
		if (player.getRedMana().getAmount() < Constant.RED_COST_TOWER) {
			return false;
		}
		return true;
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
