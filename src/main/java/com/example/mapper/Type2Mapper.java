package com.example.mapper;

import com.example.model.Type2;
import com.example.model.Type2Example;
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

public interface Type2Mapper {

    @Select({
            "select",
            "id, second",
            "from type2",
            "where firstid = #{firstid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="second", property="second", jdbcType=JdbcType.VARCHAR)
    })
    List<Type2> selectByKey(Integer firstid);


    @SelectProvider(type=Type2SqlProvider.class, method="countByExample")
    long countByExample(Type2Example example);

    @DeleteProvider(type=Type2SqlProvider.class, method="deleteByExample")
    int deleteByExample(Type2Example example);

    @Delete({
        "delete from type2",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Select({
        "select second",
        "from type2"
    })
    List<String> queryType();

    @Insert({
        "insert into type2 (id, second, ",
        "firstid)",
        "values (#{id,jdbcType=INTEGER}, #{second,jdbcType=VARCHAR}, ",
        "#{firstid,jdbcType=INTEGER})"
    })
    int insert(Type2 record);

    @InsertProvider(type=Type2SqlProvider.class, method="insertSelective")
    int insertSelective(Type2 record);

    @SelectProvider(type=Type2SqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="second", property="second", jdbcType=JdbcType.VARCHAR),
        @Result(column="firstid", property="firstid", jdbcType=JdbcType.INTEGER)
    })
    List<Type2> selectByExample(Type2Example example);

    @Select({
        "select",
        "id, second, firstid",
        "from type2",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="second", property="second", jdbcType=JdbcType.VARCHAR),
        @Result(column="firstid", property="firstid", jdbcType=JdbcType.INTEGER)
    })
    Type2 selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Type2SqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Type2 record, @Param("example") Type2Example example);

    @UpdateProvider(type=Type2SqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Type2 record, @Param("example") Type2Example example);

    @UpdateProvider(type=Type2SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Type2 record);

    @Update({
        "update type2",
        "set second = #{second,jdbcType=VARCHAR},",
          "firstid = #{firstid,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Type2 record);
}