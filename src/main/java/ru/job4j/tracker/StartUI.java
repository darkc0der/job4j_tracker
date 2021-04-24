package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                int id = input.askInt("Enter id: ");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                System.out.println(tracker.replace(id, item) ? "Item is replace" : "Item isn't replace");
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = input.askInt("Enter id: ");
                System.out.println(tracker.delete(id) ? "Item deleted" : "Item isn't deleted");
            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                int id = input.askInt("Enter id: ");
                Item item = tracker.findById(id);
                System.out.println(item != null ? item : "Request with id not found");
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                String name = input.askStr("Enter name: ");
                Item[] items = tracker.findByName(name);
                if (items.length != 0) {
                    for (Item item : items)
                        System.out.println(item);
                } else {
                    System.out.println("No tickets with this name were found");}
            } else if (select == 6) {
                System.out.println("=== Exit Program ===");
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        String[] menu = {
                "0. Add new Item",
                "1. Show all items",
                "2. Edit item",
                "3. Delete item",
                "4. Find item by Id",
                "5. Find items by name",
                "6. Exit Program",
        };
        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
