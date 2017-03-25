package com.example.mapper;

import com.example.model.Item;
import com.example.model.ItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ItemMapper {
    @Select({
            "select",
            "id, proid, shopname, num, price",
            "from item",
            "where orderid = #{orderid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="proid", property="proid", jdbcType=JdbcType.INTEGER),
            @Result(column="shopname", property="shopname", jdbcType=JdbcType.VARCHAR),
            @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<Item> queryAll(Integer orderid);



    @SelectProvider(type=ItemSqlProvider.class, method="countByExample")
    long countByExample(ItemExample example);

    @DeleteProvider(type=ItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(ItemExample example);

    @Delete({
        "delete from item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into item (id, orderid, ",
        "proid, shopname, ",
        "num, price)",
        "values (#{id,jdbcType=INTEGER}, #{orderid,jdbcType=INTEGER}, ",
        "#{proid,jdbcType=INTEGER}, #{shopname,jdbcType=VARCHAR}, ",
        "#{num,jdbcType=INTEGER}, #{price,jdbcType=DECIMAL})"
    })
    int insert(Item record);

    @InsertProvider(type=ItemSqlProvider.class, method="insertSelective")
    int insertSelective(Item record);

    @SelectProvider(type=ItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="proid", property="proid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopname", property="shopname", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<Item> selectByExample(ItemExample example);

    @Select({
        "select",
        "id, orderid, proid, shopname, num, price",
        "from item",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderid", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="proid", property="proid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopname", property="shopname", jdbcType=JdbcType.VARCHAR),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    Item selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Item record, @Param("example") ItemExample example);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Item record, @Param("example") ItemExample example);

    @UpdateProvider(type=ItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Item record);

    @Update({
        "update item",
        "set orderid = #{orderid,jdbcType=INTEGER},",
          "proid = #{proid,jdbcType=INTEGER},",
          "shopname = #{shopname,jdbcType=VARCHAR},",
          "num = #{num,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Item record);
}