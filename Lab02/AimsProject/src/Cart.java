public class Cart {
    private int qtyOrdered =0;
    public static final int MAX = 20;
    private DigitalVideoDisc itemOrdered[] =
            new DigitalVideoDisc[MAX];

    public void addDigitalVideoDisc(DigitalVideoDisc item){
        if (item == null) {
            System.out.println("Cannot add null disc");
            return;
        }
        if(qtyOrdered == MAX){
            System.out.println("The cart is full");
        }else{
            itemOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The dvd with title " + item.getTitle() + " has been added to the cart");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList){
        if (dvdList == null) {
            System.out.println("Cannot add null disc");
            return;
        }
        if(qtyOrdered == MAX){
            System.out.println("The cart is full");
        }else{
            for (DigitalVideoDisc item: dvdList){
                itemOrdered[qtyOrdered] = item;
                qtyOrdered++;
                System.out.println("The dvd with title " + item.getTitle() + " has been added to the cart");
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        if(qtyOrdered == MAX){
            System.out.println("The cart is full");
        }else{
                itemOrdered[qtyOrdered] = dvd1;
                qtyOrdered++;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the cart");
            itemOrdered[qtyOrdered] = dvd2;
            qtyOrdered++;
            System.out.println("The dvd with title " + dvd2.getTitle() + " has been added to the cart");
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

    public void print(){
        System.out.println("**********CART**********");
        System.out.println("Ordered Items:");
        int count =1;
        for (DigitalVideoDisc item: itemOrdered){
            System.out.println(count+". DVD - "+item.getTitle()+" - "+item.getCategory()+" - "+item.getDirector()+" - "+item.getLength()+": "+item.getCost()+"$");
            count++;
        }
        System.out.println("Total cost:" + totalCost());
        System.out.println("************************");
    }
}
