package com.example.mapper;

import com.example.model.Product;
import com.example.model.ProductExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

public interface ProductMapper {

//    @Select({
//        "select count(*) from product where shopid=#{shopid,jdbcType=INTEGER}"
//    })
//    int total(int shopid);

    @Select({
        "select id from product where name=#{name,jdbcType=VARCHAR}"
    })
    Integer queryId(String name);

    @Select(
        "call p_product(" +
        " #{curpage,mode=IN,jdbcType=INTEGER} ," +
        " #{typeid,mode=IN,jdbcType=INTEGER } )")
    @Options(statementType = StatementType.CALLABLE)
    List<Product> all_pro(Map map);

    @Select(
            "call p_all(" +
                    " #{ typeid,mode=IN,jdbcType=INTEGER })"
    )
    @Options(statementType = StatementType.CALLABLE)
    int quantity(int typeid);


    @Select({
        "select * from product order by click desc limit 6"
    })
    List<Product> hotShop();

    @Select({
        "select * from product where typeid=#{typeid,jdbcType=INTEGER}"
    })
    List<Product> more(Integer typeid);

    @Select({
            "select",
            "id, name, price, stock, intro, typeid, shopid, flag, click, attr, pib",
            "from product",
            "where attr = #{attr,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
            @Result(column="typeid", property="typeid", jdbcType=JdbcType.INTEGER),
            @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
            @Result(column="attr", property="attr", jdbcType=JdbcType.INTEGER),
            @Result(column="pib", property="pib", jdbcType=JdbcType.VARCHAR)
    })
    List<Product> init(Integer attr);


    @SelectProvider(type=ProductSqlProvider.class, method="countByExample")
    long countByExample(ProductExample example);

    @DeleteProvider(type=ProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductExample example);

    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product (id, name, ",
        "price, stock, intro, ",
        "typeid, shopid, ",
        "flag, click, attr, ",
        "pib)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DECIMAL}, #{stock,jdbcType=INTEGER}, #{intro,jdbcType=VARCHAR}, ",
        "#{typeid,jdbcType=INTEGER}, #{shopid,jdbcType=INTEGER}, ",
        "#{flag,jdbcType=INTEGER}, #{click,jdbcType=INTEGER}, #{attr,jdbcType=INTEGER}, ",
        "#{pib,jdbcType=VARCHAR})"
    })
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    int insertSelective(Product record);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="typeid", property="typeid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
        @Result(column="attr", property="attr", jdbcType=JdbcType.INTEGER),
        @Result(column="pib", property="pib", jdbcType=JdbcType.VARCHAR)
    })
    List<Product> selectByExampleWithBLOBs(ProductExample example);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="typeid", property="typeid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
        @Result(column="attr", property="attr", jdbcType=JdbcType.INTEGER)
    })
    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "id, name, price, stock, intro, typeid, shopid, flag, click, attr, pib",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
        @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="typeid", property="typeid", jdbcType=JdbcType.INTEGER),
        @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
        @Result(column="attr", property="attr", jdbcType=JdbcType.INTEGER),
        @Result(column="pib", property="pib", jdbcType=JdbcType.VARCHAR)
    })
    Product selectByPrimaryKey(Integer id);


    @Select({
            "select",
            "id, name, price, stock, intro, typeid, shopid, flag, click, attr, pib",
            "from product",
            "where shopid = #{shopid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL),
            @Result(column="stock", property="stock", jdbcType=JdbcType.INTEGER),
            @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
            @Result(column="typeid", property="typeid", jdbcType=JdbcType.INTEGER),
            @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
            @Result(column="attr", property="attr", jdbcType=JdbcType.INTEGER),
            @Result(column="pib", property="pib", jdbcType=JdbcType.VARCHAR)
    })
    List<Product> selectByShopid(Integer shopid);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "stock = #{stock,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "typeid = #{typeid,jdbcType=INTEGER},",
          "shopid = #{shopid,jdbcType=INTEGER},",
          "flag = #{flag,jdbcType=INTEGER},",
          "click = #{click,jdbcType=INTEGER},",
          "attr = #{attr,jdbcType=INTEGER},",
          "pib = #{pib,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Product record);

    @Update({
        "update product",
        "set name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DECIMAL},",
          "stock = #{stock,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "typeid = #{typeid,jdbcType=INTEGER},",
          "shopid = #{shopid,jdbcType=INTEGER},",
          "flag = #{flag,jdbcType=INTEGER},",
          "click = #{click,jdbcType=INTEGER},",
          "attr = #{attr,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}