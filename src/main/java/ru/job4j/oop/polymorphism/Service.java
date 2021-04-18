package ru.job4j.oop.polymorphism;

public class Service {
    private Store store;

    public Service(Store store) {
        this.store = store;
    }

    public void extract() {
        store.save("Pavel Ivanov");
    }

    public static void main(String[] args) {
        Store storeFile = new FileStore();
        Store storeDb = new DbStore();
        Service service = new Service(storeDb);
        service.extract(); // show Db Store
        service = new Service(storeFile);
        service.extract(); // show File Store
    }
}
