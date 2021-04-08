package restaurant;

import java.util.Set;
import java.util.TreeSet;

public class FoodItem extends MenuItem {
    public boolean isSpicy;
    public boolean isVegetarian;

    public FoodItem(String name, int price){
        super(name, price);
    }

    public FoodItem(String name, int price, TreeSet<String> ingredients, TreeSet<String> allergens, boolean isSpicy, boolean isVegetarian) {
        super(name, price, ingredients, allergens);
        this.isSpicy = isSpicy;
        this.isVegetarian = isVegetarian;
    }

    public boolean isSpicy() {
        return isSpicy;
    }

    public void setSpicy(boolean spicy) {
        isSpicy = spicy;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }
}
