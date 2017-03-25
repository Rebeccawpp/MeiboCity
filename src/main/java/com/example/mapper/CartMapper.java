package com.example.mapper;

import com.example.model.Cart;
import com.example.model.CartExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface CartMapper {
    @Select({
        "select * from cart where userid=#{userid,jdbcType=INTEGER}"
    })
    List<Cart> queryAll(int userid);

    @SelectProvider(type=CartSqlProvider.class, method="countByExample")
    long countByExample(CartExample example);

    @DeleteProvider(type=CartSqlProvider.class, method="deleteByExample")
    int deleteByExample(CartExample example);

    @Insert({
        "insert into cart (userid, productid, ",
        "shopid, num, time)",
        "values (#{userid,jdbcType=INTEGER}, #{productid,jdbcType=INTEGER}, ",
        "#{shopid,jdbcType=INTEGER}, #{num,jdbcType=INTEGER}, #{time,jdbcType=DATE})"
    })
    int insert(Cart record);

    @InsertProvider(type=CartSqlProvider.class, method="insertSelective")
    int insertSelective(Cart record);

    @SelectProvider(type=CartSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="productid", property="productid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
        @Result(column="num", property="num", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.DATE)
    })
    List<Cart> selectByExample(CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Cart record, @Param("example") CartExample example);

    @UpdateProvider(type=CartSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Cart record, @Param("example") CartExample example);
}