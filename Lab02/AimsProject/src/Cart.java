import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public Cart() {
    }

    public void addMedia(Media media) {
        if (media == null) {
            System.out.println("Không thể thêm đối tượng rỗng (null)!");
            return;
        }

        if (itemsOrdered.contains(media)) {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã có sẵn trong giỏ hàng.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Đã thêm sản phẩm '" + media.getTitle() + "' vào giỏ hàng.");
        }
    }

    public void removeMedia(Media media) {
        if (media == null) return;

        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Đã xóa sản phẩm '" + media.getTitle() + "' khỏi giỏ hàng.");
        } else {
            System.out.println("Không tìm thấy sản phẩm '" + media.getTitle() + "' trong giỏ hàng.");
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media media : itemsOrdered) {
            total += media.getCost(); // Duyệt qua từng Media và lấy giá tiền của nó
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            System.out.println((i + 1) + ". Media - [" + media.getTitle() + "] - ["
                    + media.getCategory() + "]: " + media.getCost() + " $");
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }
}