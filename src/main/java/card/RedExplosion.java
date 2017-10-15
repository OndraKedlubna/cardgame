package card;

import gameEntity.Player;

import java.util.List;

public class RedExplosion implements ICard {

    @Override
    public String doEffect(Player player, List<Player> players) {
        players.stream()
                .forEach(i -> i.getRedMana().decrease(20));
        StringBuilder s = new StringBuilder();
        players.stream()
                .forEach(i -> s.append("Player " + player.getName() + " has now " + player.getRedMana() + " red mana\r\n"));
        return s.toString();
    }

    @Override
    public String showDescription() {
        return "Every Player - 20 red mana";
    }

    @Override
    public String showName() {
        return "Red Explosion";
    }

    @Override
    public int goldCost() {
        return 0;
    }

    @Override
    public int redCost() {
        return 5;
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
