package com.example.mapper;

import com.example.model.Visitor;
import com.example.model.VisitorExample;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface VisitorMapper {
    @Select({
        "select number from visitor"
    })
    int number();

    @Update({
        "update visitor set number=#{number,jdbcType=INTEGER}"
    })
    int new_num(Integer number);

    @SelectProvider(type=VisitorSqlProvider.class, method="countByExample")
    long countByExample(VisitorExample example);

    @DeleteProvider(type=VisitorSqlProvider.class, method="deleteByExample")
    int deleteByExample(VisitorExample example);

    @Delete({
        "delete from visitor",
        "where number = #{number,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer number);

    @Insert({
        "insert into visitor (number)",
        "values (#{number,jdbcType=INTEGER})"
    })
    int insert(Visitor record);

    @InsertProvider(type=VisitorSqlProvider.class, method="insertSelective")
    int insertSelective(Visitor record);

    @SelectProvider(type=VisitorSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="number", property="number", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<Visitor> selectByExample(VisitorExample example);

    @UpdateProvider(type=VisitorSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Visitor record, @Param("example") VisitorExample example);

    @UpdateProvider(type=VisitorSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Visitor record, @Param("example") VisitorExample example);
}