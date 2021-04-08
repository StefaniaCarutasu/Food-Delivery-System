package restaurant;

import java.util.TreeSet;

public class MenuItem {
    private static int idGenerator = 0;
    private String Id;
    protected String name;
    protected int price;
    protected TreeSet<String> ingredients;
    protected TreeSet<String> allergens;

    public MenuItem(){
        this.Id = Integer.toString(idGenerator);
        idGenerator++;
    }
    public MenuItem(String name, int price){
        this.Id = Integer.toString(idGenerator);
        idGenerator++;
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, int price, TreeSet<String> ingredients, TreeSet<String> allergens) {
        this.Id = Integer.toString(idGenerator);
        idGenerator++;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.allergens = allergens;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public TreeSet<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(TreeSet<String> ingredients) {
        this.ingredients = ingredients;
    }

    public TreeSet<String> getAllergens() {
        return allergens;
    }

    public void setAllergens(TreeSet<String> allergens) {
        this.allergens = allergens;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                ", allergens=" + allergens +
                '}' + '\n';
    }
}
