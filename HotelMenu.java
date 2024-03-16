import java.util.*;
class HotelMenu {
    private ArrayList<FoodItem> menu;

    public HotelMenu() {
        menu = new ArrayList<>();
    }

    public void addItem(String name, double price) {
        menu.add(new FoodItem(name, price));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            FoodItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - Rs" + item.getPrice());
        }
    }

    public Order placeOrder(int itemIndex, int quantity) {
        if (itemIndex >= 0 && itemIndex < menu.size() && quantity > 0) {
            FoodItem item = menu.get(itemIndex);
            return new Order(item, quantity);
        } else {
            return null;
        }
    }
    
    public int getSize() {
        return menu.size();
    }
}
