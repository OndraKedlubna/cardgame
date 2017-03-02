package gameEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import card.ICard;

public class Player {
	
	private String name;
    private RawMaterial gold;
    private RawMaterial blueMana;
    private RawMaterial greenMana;
    private RawMaterial redMana;
    
    private boolean starter;
    private boolean winCondition = false;
    private Player nextPlayer;
    private List<ICard> hand;
    private List<ICard> pack;
    private List<ICard> deletePack;
    private int action;
    
    public void nextRound(){
        gold.increase();
        blueMana.increase();
        greenMana.increase();
        redMana.increase();       
    }
    
    //Metody manipulujici s balickem
    
    public void throwCard(ICard card){
        hand.remove(card);
        deletePack.add(card);
    }
    
    public void fillHand(){
        //TODO while
    }
    
    public boolean gainCard(){
        ICard card = pickCard();
        if(card== null){
            return false;
        }
        hand.add(card);
        return true;
    }
    
    public ICard pickCard(){
        if(pack.isEmpty()){
            refillPack();
        }
        if(pack.isEmpty()){
            return null;
        }
        ICard choosen = pack.get(new Random().nextInt(pack.size()));
        pack.remove(choosen);
        return choosen;
    }
    
    public void refillPack(){
        if(deletePack.size()>0){
            deletePack.stream()
                    .forEach(i->pack.add(i));
            deletePack = new ArrayList<>();
        }
    }

    //SET+ GET

    public RawMaterial getGold() {
        return gold;
    }

    public void setGold(RawMaterial gold) {
        this.gold = gold;
    }

    public RawMaterial getBlueMana() {
        return blueMana;
    }

    public void setBlueMana(RawMaterial blueMana) {
        this.blueMana = blueMana;
    }

    public RawMaterial getGreenMana() {
        return greenMana;
    }

    public void setGreenMana(RawMaterial greenMana) {
        this.greenMana = greenMana;
    }

    public RawMaterial getRedMana() {
        return redMana;
    }

    public void setRedMana(RawMaterial redMana) {
        this.redMana = redMana;
    }

    public boolean isStarter() {
        return starter;
    }

    public void setStarter(boolean starter) {
        this.starter = starter;
    }

    public Player getNextPlayer() {
        return nextPlayer;
    }

    public void setNextPlayer(Player nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWinCondition() {
        return winCondition;
    }

    public void setWinCondition(boolean winCondition) {
        this.winCondition = winCondition;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public List<ICard> getHand() {
        return hand;
    }

    public void setHand(List<ICard> hand) {
        this.hand = hand;
    }

    public List<ICard> getPack() {
        return pack;
    }

    public void setPack(List<ICard> pack) {
        this.pack = pack;
    }

    public List<ICard> getDeletePack() {
        return deletePack;
    }

    public void setDeletePack(List<ICard> deletePack) {
        this.deletePack = deletePack;
    }  

    @Override
    public String toString() {
        String s = " Name: " + name+ "\n"
                + "  Gold: " + gold.toString() + "\n"
                + "  BM: " + blueMana.toString() + "\n"
                + "  GM: " + greenMana.toString() + "\n"
                + "  RM: " + redMana.toString() + "\n";
        return s;
    }

}
