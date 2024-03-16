import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelMenuDriver {

    public static void main(String[] args) {
        HotelMenu menu = new HotelMenu();

        // Adding items to the menu
        menu.addItem("Burger", 150.0);
        menu.addItem("Pizza", 200.0);
        menu.addItem("Salad", 100.0);
        menu.addItem("Fries", 50.0);

        // Displaying the menu
        menu.displayMenu();

        // Placing orders
        Scanner scanner = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>();
        while (true) {
            try {
                System.out.println("Enter item number to order (0 to finish): ");
                int itemNumber = scanner.nextInt();
                if (itemNumber == 0) {
                    break;
                } else if (itemNumber < 0 || itemNumber > menu.getSize()) {
                    throw new IllegalArgumentException("Invalid item number.");
                }
                
                System.out.println("Enter quantity: ");
                int quantity = scanner.nextInt();
                if (quantity <= 0) {
                    throw new IllegalArgumentException("Quantity must be greater than 0.");
                }
                
                Order order = menu.placeOrder(itemNumber - 1, quantity);
                if (order != null) {
                    orders.add(order);
                } else {
                    System.out.println("Invalid item or quantity, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Displaying the orders and total price
        System.out.println("Your Orders:");
        double totalPrice = 0;
        for (Order order : orders) {
            System.out.println(order.getQuantity() + "x " + order.getItem().getName() + " - Rs" + order.getTotalPrice());
            totalPrice += order.getTotalPrice();
        }
        System.out.println("Total Price: Rs" + totalPrice);
    }
}

    

