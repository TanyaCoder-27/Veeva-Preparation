package OrderProcessingSystem;

import java.util.*;

class Item {
    String name;
    double price;
    int quantity;
    int reorderLevel;

    Item(String name, double price, int quantity, int reorderLevel) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
    }
}

class Customer {
    String name, address, phone, email;

    Customer(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

class Order {
    int orderId;
    Customer customer;
    Map<Item, Integer> items = new HashMap<>();
    Date date;
    double totalAmount = 0;

    Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.date = new Date();
    }

    void addItem(Item item, int qty) {
        items.put(item, qty);
        totalAmount += item.price * qty;
    }
}

public class OrderProcessingSystem {

    static Scanner sc = new Scanner(System.in);
    static List<Item> itemList = new ArrayList<>();
    static List<Customer> customerList = new ArrayList<>();
    static List<Order> orderList = new ArrayList<>();

    public static void main(String[] args) {

        itemList.add(new Item("Pen", 10, 50, 5));
        itemList.add(new Item("Book", 100, 20, 5));
        itemList.add(new Item("Pencil", 5, 2, 5));

        customerList.add(new Customer("Tanya", "AP", "1234567890", "tanya@gmail.com"));

        int choice;

        do {
            System.out.println("\n1.Place Order 2.Search Name 3.Search Price");
            System.out.println("4.Get Order 5.Customer Orders 6.Highest 7.Lowest");
            System.out.println("8.Last Week 9.Last Month 10.Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1: placeOrder(); break;
                case 2: findItemByName(); break;
                case 3: findItemsByPrice(); break;
                case 4: getOrderById(); break;
                case 5: getOrdersByCustomer(); break;
                case 6: highestOrder(); break;
                case 7: lowestOrder(); break;
                case 8: lastWeekOrders(); break;
                case 9: lastMonthOrders(); break;
                case 10:return;
            }

        } while (true);
    }

    static void placeOrder() {
        System.out.print("Order ID: ");
        int id = sc.nextInt();

        Customer c = customerList.get(0);
        Order order = new Order(id, c);

        while (true) {
            System.out.print("Enter item name (or 'done' if items entering is over): ");
            String name = sc.next();

            if (name.equalsIgnoreCase("done")) break;

            Item selected = null;

            for (Item i : itemList) {
                if (i.name.equalsIgnoreCase(name)) {
                    selected = i;
                    break;
                }
            }

            if (selected == null) {
                System.out.println("Item not found");
                continue;
            }

            if (selected.quantity <= selected.reorderLevel) {
                System.out.println("Stock low");
                continue;
            }

            System.out.print("Quantity: ");
            int qty = sc.nextInt();

            if (qty > selected.quantity) {
                System.out.println("Not enouh stock");
                continue;
            }

            order.addItem(selected, qty);
            selected.quantity -= qty;
        }

        orderList.add(order);
        System.out.println("Order placed");
    }

    static void findItemByName() {
        String name = sc.next();
        for (Item i : itemList) {
            if (i.name.equalsIgnoreCase(name)) {
                System.out.println(i.name + " " + i.price);
            }
        }
    }

    static void findItemsByPrice() {
        double price = sc.nextDouble();
        for (Item i : itemList) {
            if (i.price == price) {
                System.out.println(i.name);
            }
        }
    }

    static void getOrderById() {
        int id = sc.nextInt();
        for (Order o : orderList) {
            if (o.orderId == id) {
                System.out.println("Order " + o.orderId + " Amount " + o.totalAmount);
            }
        }
    }

    static void getOrdersByCustomer() {
        String name = sc.next();
        for (Order o : orderList) {
            if (o.customer.name.equalsIgnoreCase(name)) {
                System.out.println("Order ID " + o.orderId);
            }
        }
    }

    static void highestOrder() {
        if (orderList.isEmpty()) return;
        Order max = orderList.get(0);
        for (Order o : orderList) {
            if (o.totalAmount > max.totalAmount) max = o;
        }
        System.out.println("Highest: " + max.orderId);
    }

    static void lowestOrder() {
        if (orderList.isEmpty()) return;
        Order min = orderList.get(0);
        for (Order o : orderList) {
            if (o.totalAmount < min.totalAmount) min = o;
        }
        System.out.println("Lowest: " + min.orderId);
    }

    static void lastWeekOrders() {
        Date now = new Date();
        for (Order o : orderList) {
            long days = (now.getTime() - o.date.getTime()) / (1000 * 60 * 60 * 24);
            if (days <= 7) {
                System.out.println("Order: " + o.orderId);
            }
        }
    }

    static void lastMonthOrders() {
        Date now = new Date();
        for (Order o : orderList) {
            long days = (now.getTime() - o.date.getTime()) / (1000 * 60 * 60 * 24);
            if (days <= 30) {
                System.out.println("Order: " + o.orderId);
            }
        }
    }
}



/*

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
1
Order ID: 101
Enter item name (or 'done' if items entering is over): Pen
Quantity: 2
Enter item name (or 'done' if items entering is over): Book
Quantity: 1
Enter item name (or 'done' if items entering is over): done
Order placed

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
2
Pen
Pen 10.0

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
3
100
Book

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
4
101
Order 101 Amount 120.0

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
5
Tanya
Order ID 101

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
6
Highest: 101

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
7
Lowest: 101

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
8
Order: 101

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
9
Order: 101

1.Place Order 2.Search Name 3.Search Price
4.Get Order 5.Customer Orders 6.Highest 7.Lowest
8.Last Week 9.Last Month 10.Exit
10
*/