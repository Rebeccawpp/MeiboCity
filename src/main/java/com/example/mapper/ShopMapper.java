package com.example.mapper;

import com.example.model.Shop;
import com.example.model.ShopExample;
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

public interface ShopMapper {

    @Select({
            "select",
            "id, name, userid, intro, type, pic",
            "from shop",
            "where userid = #{userid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
            @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
            @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR)
    })
    Shop selectByUserId(Integer userid);


    @Select({
        "select * from shop"
    })
    List<Shop> selectAll();

    @Select({
        "select id from shop where userid=" +
                "#{userid,jdbcType=INTEGER}"
    })
    int selectId(Integer userid);

    @SelectProvider(type=ShopSqlProvider.class, method="countByExample")
    long countByExample(ShopExample example);

    @DeleteProvider(type=ShopSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopExample example);

    @Delete({
        "delete from shop",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into shop (id, name, ",
        "userid, intro, type, ",
        "pic)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{userid,jdbcType=INTEGER}, #{intro,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{pic,jdbcType=VARCHAR})"
    })
    int insert(Shop record);

    @InsertProvider(type=ShopSqlProvider.class, method="insertSelective")
    int insertSelective(Shop record);

    @SelectProvider(type=ShopSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR)
    })
    List<Shop> selectByExampleWithBLOBs(ShopExample example);

    @SelectProvider(type=ShopSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER)
    })
    List<Shop> selectByExample(ShopExample example);

    @Select({
        "select",
        "id, name, userid, intro, type, pic",
        "from shop",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="intro", property="intro", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="pic", property="pic", jdbcType=JdbcType.VARCHAR)
    })
    Shop selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Shop record, @Param("example") ShopExample example);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

    @UpdateProvider(type=ShopSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Shop record);

    @Update({
        "update shop",
        "set name = #{name,jdbcType=VARCHAR},",
          "userid = #{userid,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER},",
          "pic = #{pic,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(Shop record);

    @Update({
        "update shop",
        "set name = #{name,jdbcType=VARCHAR},",
          "userid = #{userid,jdbcType=INTEGER},",
          "intro = #{intro,jdbcType=VARCHAR},",
          "type = #{type,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Shop record);
}