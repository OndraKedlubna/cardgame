package gameEntity;

/**
 * Trida pro surovinu a operace s mnozstvim teto suroviny
 * @author Ondra
 *
 */
public class RawMaterial {
	
	private String name;
    private int maxAmount;
    private int amount;
    private int grow;

    public void increase(){
        amount = amount + grow;
        checkAmount();
    }
    
    public void increase(int i){
        amount = amount + i;
        checkAmount();
    }
    
    public void decrease(int i){
        amount = amount - i;
    }
    
    public void increaseMax(int i){
        maxAmount = maxAmount + i;
    }
    
    public void increaseGrow(int i){
        grow = grow + i;
    }
    
    public void decreaseGrow(int i){
        grow = grow - i;
        grow = grow >= 1 ? grow : 1;
    }
    
    private void checkAmount(){
        amount = amount > maxAmount ? maxAmount : amount;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(int maxAmount) {
        this.maxAmount = maxAmount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getGrow() {
        return grow;
    }

    public void setGrow(int grow) {
        this.grow = grow;
    }

    @Override
    public String toString() {
        return "RawMaterial{" + "name=" + name + ", maxAmount=" + maxAmount + ", amount=" + amount + ", grow=" + grow + '}';
    } 

}
