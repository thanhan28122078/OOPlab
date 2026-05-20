import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Store() {
    }

    public void addMedia(Media media) {
        if (media == null) return;

        if (itemsInStore.contains(media)) {
            System.out.println("Sản phẩm '" + media.getTitle() + "' đã tồn tại trong cửa hàng.");
        } else {
            itemsInStore.add(media);
            System.out.println("Đã thêm sản phẩm '" + media.getTitle() + "' vào cửa hàng thành công.");
        }
    }

    public void removeMedia(Media media) {
        if (media == null) return;

        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Đã xóa sản phẩm '" + media.getTitle() + "' khỏi cửa hàng.");
        } else {
            System.out.println("Sản phẩm '" + media.getTitle() + "' không tồn tại trong cửa hàng.");
        }
    }
    public Media searchByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title.trim())) {
                return media;
            }
        }
        return null;
    }

    public void printStore() {
        System.out.println("==================== STORE STOCKS ====================");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng hiện tại đang trống.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                Media media = itemsInStore.get(i);
                System.out.println((i + 1) + ". [" + media.getTitle() + "] - Giá: " + media.getCost() + " $");
            }
        }
        System.out.println("======================================================");
    }
}