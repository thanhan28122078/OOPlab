public class Store {
    public DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    public void addDVD(DigitalVideoDisc item){
        if (item == null) {
            System.out.println("Cannot add null disc");
            return;
        }
        if(qtyInStore == 100){
            System.out.println("The store is full");
        }else{
            itemsInStore[qtyInStore] = item;
            qtyInStore++;
            System.out.println("The dvd with title " + item.getTitle() + " has been added to the store");
        }
    }

    public void addDVD(DigitalVideoDisc [] dvdList){
        if (dvdList == null) {
            System.out.println("Cannot add null disc");
            return;
        }
        if(qtyInStore == 100){
            System.out.println("The store is full");
        }else{
            for (DigitalVideoDisc item: dvdList){
                itemsInStore[qtyInStore] = item;
                qtyInStore++;
                System.out.println("The dvd with title " + item.getTitle() + " has been added to the store");
            }
        }
    }

    public void removeDVD(DigitalVideoDisc item) {
        boolean found = false;
        if (qtyInStore == 0) {
            System.out.println("The store has no DVD");
        } else {
            //search the disc
            for (int i = 0; i < qtyInStore; i++) {
                if (itemsInStore[i].equals(item)) {
                    found = true;
                    for (int j = i; j < qtyInStore - 1; j++) {
                        itemsInStore[j] = itemsInStore[j + 1];
                    }
                    itemsInStore[qtyInStore - 1] = null;
                    qtyInStore--;
                    System.out.println("The DVD with title " + item.getTitle() + " has been removed from the store");
                }
            }
            if (!found) {
                System.out.println("The DVD is not match with any DVD in the store");
            }
        }
    }
}
