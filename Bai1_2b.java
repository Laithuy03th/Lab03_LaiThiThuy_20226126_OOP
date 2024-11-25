
class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

}

class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public Cart() {

    }

    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvd) {
        for (int i = 0; i < dvd.length; i++) {
            if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is full");
                break;
            } else {
                itemsOrdered[qtyOrdered] = dvd[i];
                qtyOrdered++;
                System.out.println("The disc " + dvd[i].getTitle() + "has been added");
            }
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart");
        }
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

}

public class Bai1_2b {
    public static void main(String[] args) {

        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc[] dvdList = { dvd2, dvd3 };

        // anOrder.addDigitalVideoDisc(dvdList);
        anOrder.addDigitalVideoDisc(dvd1, dvd2, dvd3);

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.removeDigitalVideoDisc(dvd2);
    }
}
