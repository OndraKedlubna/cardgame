package card;

import java.util.List;

import gameEntity.Player;

public class RedEnergy implements ICard{
	
	@Override
    public String doEffect(Player player, List<Player> players) {
        player.getRedMana().increase(5);
        return "RedMana of " + player.getName() + " increased + 5 to " + player.getRedMana().getAmount();
    }

    @Override
    public String showDescription() {
        return "Add 5 RedMana";
    }

    @Override
    public String showName() {
        return "redEnergy";
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
