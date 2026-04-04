public class Cart {
    private int qtyOrdered =0;
    public static final int MAX = 20;
    private DigitalVideoDisc itemOrdered[] =
            new DigitalVideoDisc[MAX];

    public void addDigitalVideoDisc(DigitalVideoDisc item){
        if(qtyOrdered == MAX){
            System.out.println("The cart is almnost full");
        }else{
            itemOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The dvd with title " + item.getTitle() + " has been added to the cart");
        }
    }
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered == MAX){
            System.out.println("Do not have enough space to add both DVD");
        }else{
            if(qtyOrdered == MAX - 1){
                itemOrdered[qtyOrdered++]=dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the cart");
                System.out.println("After add dvd1,the cart is full, cant not add dvd2");
            }else {
                itemOrdered[qtyOrdered++] = dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the cart");
                itemOrdered[qtyOrdered++] = dvd2;
                System.out.println("The dvd with title " + dvd2.getTitle() + " has been added to the cart");
            }

        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc item) {
        boolean found = false;
        if (qtyOrdered == 0) {
            System.out.println("The cart has no DVD");
        } else {
            //search the disc
            for (int i = 0; i < qtyOrdered; i++) {
                if (itemOrdered[i].equals(item)) {
                    found = true;
                    for (int j = i; j < qtyOrdered - 1; j++) {
                        itemOrdered[j] = itemOrdered[j + 1];
                    }
                    itemOrdered[qtyOrdered - 1] = null;
                    qtyOrdered--;
                    System.out.println("The DVD with title " + item.getTitle() + " has been removed from the cart");
                }
            }
            if (!found) {
                System.out.println("The DVD is not match with any DVD in the cart");
            }
        }
    }

    public float totalCost(){
        float total =0;
        for (int i=0; i< qtyOrdered;i++){
            total+=itemOrdered[i].getCost();
        }
        return total;
    }

    public void display() {
        System.out.println("The cart has " + qtyOrdered + " DVDs:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemOrdered[i].getTitle() + " - " + itemOrdered[i].getCost());
        }
        System.out.println("Total Cost: " + totalCost());
    }
}
