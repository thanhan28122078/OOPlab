public class Cart {
    private int qtyOrdered =0;
    public static final int MAX_NUMBERS_ORDERED = 20;
    private  DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    //add DVD to the hust.soict.hedspi.test1.cart
    public void addDigitalVideoDisc(DigitalVideoDisc item){
        if(qtyOrdered == MAX_NUMBERS_ORDERED ){
            System.out.println("The hust.soict.hedspi.test1.cart is almnost full");
        }else{
            itemOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The dvd with title " + item.getTitle() + " has been added to the hust.soict.hedspi.test1.cart");
        }
    }


   //Overloading by differing types of parameter
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(DigitalVideoDisc dvd : dvdList){
            if(qtyOrdered == MAX_NUMBERS_ORDERED){
                System.out.println("The hust.soict.hedspi.test1.cart is almnost full");
                break;
            }
            itemOrdered[qtyOrdered] = dvd;
            qtyOrdered++;
            System.out.println("The dvd with title " + dvd.getTitle() + " has been added to the hust.soict.hedspi.test1.cart");
        }
    }


    //Overloading by differing the number of parameters
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        if (qtyOrdered == MAX_NUMBERS_ORDERED){
            System.out.println("Do not have enough space to add both DVD");
        }else{
            if(qtyOrdered == MAX_NUMBERS_ORDERED - 1){
                itemOrdered[qtyOrdered++]=dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the hust.soict.hedspi.test1.cart");
                System.out.println("After add dvd1,the hust.soict.hedspi.test1.cart is full, cant not add dvd2");
            }else {
                itemOrdered[qtyOrdered++] = dvd1;
                System.out.println("The dvd with title " + dvd1.getTitle() + " has been added to the hust.soict.hedspi.test1.cart");
                itemOrdered[qtyOrdered++] = dvd2;
                System.out.println("The dvd with title " + dvd2.getTitle() + " has been added to the hust.soict.hedspi.test1.cart");
            }

        }
    }



    //remove DVD to hust.soict.hedspi.test1.cart
    public void removeDigitalVideoDisc(DigitalVideoDisc item){
        boolean found =false;
        if ( qtyOrdered ==0){
            System.out.println("The hust.soict.hedspi.test1.cart has no DVD");
        }else{
            //search the hust.soict.hedspi.test1.disc
            for (int i=0; i<qtyOrdered;i++){
                if(itemOrdered[i].equals(item)){
                    found =true;
                    //If DVD match, take all the dvd right of itemOrder[i] to the left
                    for(int j=i; j< qtyOrdered -1; j++){
                        itemOrdered[j] = itemOrdered[j+1];
                    }
                    itemOrdered[qtyOrdered-1] = null;
                    qtyOrdered--;
                    System.out.println("The DVD with title " + item.getTitle() + " has been removed from the hust.soict.hedspi.test1.cart");
                }
            }
            if(!found){
                System.out.println("The DVD is not match with any DVD in the hust.soict.hedspi.test1.cart");
            }
        }


    }

    //total Cost
    public float totalCost(){
        float total =0;
        for (int i=0; i< qtyOrdered;i++){
            total+=itemOrdered[i].getCost();
        }
        return total;
    }

    //display
    public void display() {
        System.out.println("The hust.soict.hedspi.test1.cart has " + qtyOrdered + " DVDs:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemOrdered[i].getTitle() + " - " + itemOrdered[i].getCost());
        }
        System.out.println("Total Cost: " + totalCost());
    }
}
