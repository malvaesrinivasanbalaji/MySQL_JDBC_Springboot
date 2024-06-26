package SQLDB_JDBC.Springboot.Repository;

import SQLDB_JDBC.Springboot.Model.WishListModel;

import java.util.List;

public interface WishListRepository {


    List<WishListModel.Wishlist> getWishlist();

    Integer createWishlist(WishListModel.Wishlist wishlist);
}
