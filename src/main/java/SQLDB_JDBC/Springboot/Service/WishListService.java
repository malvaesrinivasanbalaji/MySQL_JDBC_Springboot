package SQLDB_JDBC.Springboot.Service;

import SQLDB_JDBC.Springboot.Model.WishListModel;
import SQLDB_JDBC.Springboot.Repository.WishListRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    WishListRepositoryJDBC WishListRepositoryJDBC;

    @Autowired
    WishListService(WishListRepositoryJDBC WishListRepositoryJDBC){
        this.WishListRepositoryJDBC = WishListRepositoryJDBC;
    }

    public List<WishListModel.Wishlist> getWishlist() {
        return WishListRepositoryJDBC.getWishlist();
    }

    public Integer createWishlist(WishListModel.Wishlist wishlist){
        return WishListRepositoryJDBC.createWishlist(wishlist);
    }
}

