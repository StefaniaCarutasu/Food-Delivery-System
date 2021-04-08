package restaurant;

import java.util.*;

public class Menu {
    private static int idGenerator = 0;
    protected String Id;
    protected TreeMap<String, List<MenuItem>> menuList = new TreeMap<String, List<MenuItem>>();

    public Menu(){
        this.Id = Integer.toString(idGenerator);
        idGenerator++;
        menuList.put("Food", new ArrayList<>());
        menuList.put("Drinks", new ArrayList<>());
    }

    public Menu(List<MenuItem> menuFood, List<MenuItem> menuDrink) {
        this.Id = Integer.toString(idGenerator);
        idGenerator++;
        menuList.put("Food", new ArrayList<>());
        menuList.put("Drinks", new ArrayList<>());
        menuList.get("Food").addAll(menuFood);
        menuList.get("Drinks").addAll(menuDrink);
    }


    public TreeMap<String, List<MenuItem>> getMenuList() {
        return menuList;
    }

    public void setMenuList(TreeMap<String, List<MenuItem>> menu) {
        this.menuList = menu;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menu=" + menuList +
                '}';
    }

    public Integer findItemById(String id){
        for (int i = 0; i < menuList.get("Food").size(); i++){
            if(menuList.get("Food").get(i).getId().equals(id)){
                return i;
            }
        }
        for (int i = 0; i < menuList.get("Drinks").size(); i++){
            if(menuList.get("Drinks").get(i).getId().equals(id)){
                return i;
            }
        }
        return null;
    }
    public void addItem(MenuItem item){
        String type = item.getClass().getName();
        switch (type) {
            case "FoodItem" -> menuList.get("Food").add(item);
            case "DrinkItem" -> menuList.get("Drinks").add(item);
        }
    }

    public void removeItem(MenuItem item){
        int pozition = findItemById(item.getId());
        String type = item.getClass().getName();
        switch (type) {
            case "FoodItem" -> menuList.get("Food").remove(pozition);
            case "DrinkItem" -> menuList.get("Drinks").remove(pozition);
        }
    }

}
