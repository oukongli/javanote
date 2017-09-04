package com.shdev.note.thread.concurrency.Simulation.v2;

import com.shdev.note.thread.concurrency.Simulation.Course;
import com.shdev.note.thread.concurrency.Simulation.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by ouyangkongli on 2017/9/5.
 */

class Order {
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final WaitPerson waitPerson;
    private final Food food;

    public Order(Customer customer, WaitPerson waitPerson, Food food) {
        this.customer = customer;
        this.waitPerson = waitPerson;
        this.food = food;
    }

    public Food item() {
        return food;
    }

    public Customer getCustomer() {
        return customer;
    }

    public WaitPerson getWaitPerson() {
        return waitPerson;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", waitPerson=" + waitPerson +
                ", food=" + food +
                '}';
    }
}

class Plate {
    private final Order order;
    private final Food food;

    public Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    public Order getOrder() {
        return order;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "order=" + order +
                ", food=" + food +
                '}';
    }
}

class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate p) throws InterruptedException {
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            try {
                waitPerson.placeOrder(this, food);
                System.out.println(this + "eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + "waiting for " + course + " interrupted");
                break;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                '}';
    }
}

class WaitPerson implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingDeque<>();

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void placeOrder(Customer customer, Food food) {
        try {
            restaurant.orders.put(new Order(customer, this, food));
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Plate plate = filledOrders.take();
                System.out.println(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson{" +
                "id=" + id +
                '}';
    }
}

class Chef implements Runnable {

    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random random = new Random(47);

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Order order = restaurant.orders.take();
                Food item = order.item();
                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                Plate plate = new Plate(order, item);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "Chef{" +
                "id=" + id +
                '}';
    }
}

class Restaurant implements Runnable {
    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService executorService;
    private static Random random = new Random(47);
    BlockingQueue<Order> orders = new LinkedBlockingDeque<>();

    public Restaurant(ExecutorService executorService, int nWaitPersons, int nChefs) {
        this.executorService = executorService;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            executorService.execute(waitPerson);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            executorService.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WaitPerson person = waitPersons.get(random.nextInt(waitPersons.size()));
                Customer customer = new Customer(person);
                executorService.execute(customer);
                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
        System.out.println("Restaurant closing");
    }
}


public class RestaurantWithQueues {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(executorService, 5, 2);
        executorService.execute(restaurant);
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
