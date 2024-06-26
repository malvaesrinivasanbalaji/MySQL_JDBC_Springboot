package SQLDB_JDBC.Springboot.Model;

import lombok.*;

public class WishListModel {

    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class Wishlist {

        private Integer Item_Id;
        private String Item_Name;
        private Integer Priority;
        private String Item_Link;
        private String Date_Entered;
        private Integer Estimated_Amount;
        private String Date_Purchased;
        private Integer Actual_Amount;

    }

}
