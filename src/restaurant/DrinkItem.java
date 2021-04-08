package restaurant;

import java.util.TreeSet;

public class DrinkItem extends MenuItem {
    public boolean isAlcoholic;

    public DrinkItem(String name, int price){
        super(name, price);
    }

    public DrinkItem(String name, int price, TreeSet<String> ingredients, TreeSet<String> allergens, boolean isAlcoholic) {
        super(name, price, ingredients, allergens);
        this.isAlcoholic = isAlcoholic;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }
}
