package com.example.mapper;

import com.example.model.Orders;
import com.example.model.OrdersExample;
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

public interface OrdersMapper {
    @Select({
        "select id from orders where userid=#{userid,jdbcType=INTEGER}"
    })
    int queryId(int userid);

    @SelectProvider(type=OrdersSqlProvider.class, method="countByExample")
    long countByExample(OrdersExample example);

    @DeleteProvider(type=OrdersSqlProvider.class, method="deleteByExample")
    int deleteByExample(OrdersExample example);

    @Delete({
        "delete from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Select({
            "select",
            "id",
            "from shop",
            "order by id desc limit 1"
    })
    int selectId();


    @Insert({
        "insert into orders (id, userid, ",
        "order_date, total)",
        "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
        "#{orderDate,jdbcType=DATE}, #{total,jdbcType=DECIMAL})"
    })
    int insert(Orders record);

    @InsertProvider(type=OrdersSqlProvider.class, method="insertSelective")
    int insertSelective(Orders record);

    @SelectProvider(type=OrdersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="order_date", property="orderDate", jdbcType=JdbcType.DATE),
        @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL)
    })
    List<Orders> selectByExample(OrdersExample example);

    @Select({
        "select",
        "id, userid, order_date, total",
        "from orders",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="order_date", property="orderDate", jdbcType=JdbcType.DATE),
        @Result(column="total", property="total", jdbcType=JdbcType.DECIMAL)
    })
    Orders selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    @UpdateProvider(type=OrdersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Orders record);

    @Update({
        "update orders",
        "set userid = #{userid,jdbcType=INTEGER},",
          "order_date = #{orderDate,jdbcType=DATE},",
          "total = #{total,jdbcType=DECIMAL}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Orders record);
}