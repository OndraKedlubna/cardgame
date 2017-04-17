package card;

import java.util.List;

import gameEntity.Player;

public class BlueEnergy implements ICard {

	@Override
	public String doEffect(Player player, List<Player> players) {
		player.getBlueMana().increase(5);
        return "Blue Mana of " + player.getName() + " increased + 5 to " + player.getBlueMana().getAmount();
	}

	@Override
	public String showDescription() {
		return "Add 5 BlueMana";
	}

	@Override
	public String showName() {
		return "Blue Energy";
	}

	@Override
    public int goldCost() {
        return 1;
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
