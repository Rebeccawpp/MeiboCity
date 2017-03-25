package com.example.mapper;

import com.example.model.Type1;
import com.example.model.Type1Example;
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

public interface Type1Mapper {
    @Select({
        "select * from type1"
    })
    List<Type1> query();

    @SelectProvider(type=Type1SqlProvider.class, method="countByExample")
    long countByExample(Type1Example example);

    @DeleteProvider(type=Type1SqlProvider.class, method="deleteByExample")
    int deleteByExample(Type1Example example);

    @Delete({
        "delete from type1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into type1 (id, first)",
        "values (#{id,jdbcType=INTEGER}, #{first,jdbcType=VARCHAR})"
    })
    int insert(Type1 record);

    @InsertProvider(type=Type1SqlProvider.class, method="insertSelective")
    int insertSelective(Type1 record);

    @SelectProvider(type=Type1SqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first", property="first", jdbcType=JdbcType.VARCHAR)
    })
    List<Type1> selectByExample(Type1Example example);

    @Select({
        "select",
        "id, first",
        "from type1",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first", property="first", jdbcType=JdbcType.VARCHAR)
    })
    Type1 selectByPrimaryKey(Integer id);

    @UpdateProvider(type=Type1SqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Type1 record, @Param("example") Type1Example example);

    @UpdateProvider(type=Type1SqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Type1 record, @Param("example") Type1Example example);

    @UpdateProvider(type=Type1SqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Type1 record);

    @Update({
        "update type1",
        "set first = #{first,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Type1 record);
}