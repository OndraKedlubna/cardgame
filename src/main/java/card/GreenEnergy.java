package card;

import java.util.List;

import gameEntity.Player;

public class GreenEnergy implements ICard {

	@Override
	public String doEffect(Player player, List<Player> players) {
		player.getGreenMana().increase(5);
        return "Green Mana of " + player.getName() + " increased + 5 to " + player.getGreenMana().getAmount();
	}

	@Override
	public String showDescription() {
		return "Add 5 Green Mana";
	}

	@Override
	public String showName() {
		return "Green Energy";
	}

	@Override
	public int goldCost() {
		return 2;
	}

	@Override
	public int redCost() {
		return 0;
	}

	@Override
	public int blueCost() {
		return 0;
	}

	@Override
	public int greenCost() {
		return 0;
	}

}
