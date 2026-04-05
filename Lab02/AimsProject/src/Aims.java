public class Aims {
    static void main() {
        Cart Order = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        Order.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        Order.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", "John Musker",90,18.99f);

        System.out.println("Total Cost is: ");
        System.out.println(Order.totalCost());

        Order.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removing is: " + Order.totalCost());
        Order.removeDigitalVideoDisc(dvd2);
    }
}
