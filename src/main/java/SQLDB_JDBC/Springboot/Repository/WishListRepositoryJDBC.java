package SQLDB_JDBC.Springboot.Repository;

import SQLDB_JDBC.Springboot.Model.WishListModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.ParametersSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Slf4j
public class WishListRepositoryJDBC implements WishListRepository{
    static JdbcTemplate jdbcTemplate;

    @Autowired
    WishListRepositoryJDBC(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<WishListModel.Wishlist> getWishlist(){
        log.info("get info from table in database");
        return jdbcTemplate.query("select * from Wishlists",
                new RowMapper<WishListModel.Wishlist>() {
            @Override
                    public WishListModel.Wishlist mapRow(ResultSet rs, int rownum)throws SQLException{
                return new WishListModel.Wishlist(rs.getInt("Item_Id"),rs.getString("Item_Name"),rs.getInt("Priority"),    rs.getString("Item_Link"),rs.getString("Date_Entered"),rs.getInt("Estimated_Amount"),    rs.getString("Date_Purchased"),rs.getInt("Actual_Amount"));
            }
                });
    }
    @Override
    public Integer createWishlist(WishListModel.Wishlist wishlist){
        log.info("Insert values in database.table");
        MapSqlParameterSource wishlistSource = new MapSqlParameterSource();
        wishlistSource.addValue("Item_Id" , wishlist.getItem_Id());
        wishlistSource.addValue("Item_Name" , wishlist.getItem_Name());
        wishlistSource.addValue("Item_Link" , wishlist.getItem_Link());
        wishlistSource.addValue("Priority" , wishlist.getPriority());
        wishlistSource.addValue("Date_Entered" , wishlist.getDate_Entered());
        wishlistSource.addValue("Estimated_Amount" , wishlist.getEstimated_Amount());
        wishlistSource.addValue("Date_Purchased" , wishlist.getDate_Purchased());
        wishlistSource.addValue("Actual_Amount" , wishlist.getActual_Amount());
        return jdbcTemplate.update("insert into Wishlists (Item_Id, Item_Name, Priority, Item_Link, Date_Entered, Estimated_Amount, Date_Purchased, Actual_Amount) values (:Item_Id, :Item_Name, :Priority, :Item_Link, :Date_Entered, :Estimated_Amount, :Date_Purchased, :Actual_Amount)", wishlistSource);

    }
}



