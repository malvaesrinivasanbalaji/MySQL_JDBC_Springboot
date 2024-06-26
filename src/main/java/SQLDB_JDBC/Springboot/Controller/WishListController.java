package SQLDB_JDBC.Springboot.Controller;

import SQLDB_JDBC.Springboot.Model.WishListModel;
import SQLDB_JDBC.Springboot.Service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishListController {

       WishListService wishListService;

       @Autowired
    WishListController(WishListService wishListService){
           this.wishListService = wishListService;
       }

       @GetMapping("/Wishlists")
    public List<WishListModel.Wishlist> getWishlist(){
         return wishListService.getWishlist();
       }

       @PostMapping("/Wishlist")
    public Integer CreateWishList(@RequestBody WishListModel.Wishlist Wishlist){
           return wishListService.createWishlist(Wishlist);
       }
}
