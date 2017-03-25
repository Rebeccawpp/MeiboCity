package com.example.mapper;

import com.example.model.Emall;
import com.example.model.EmallExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmallMapper {
    @SelectProvider(type=EmallSqlProvider.class, method="countByExample")
    long countByExample(EmallExample example);

    @DeleteProvider(type=EmallSqlProvider.class, method="deleteByExample")
    int deleteByExample(EmallExample example);

    @Insert({
        "insert into emall (click, shopid)",
        "values (#{click,jdbcType=INTEGER}, #{shopid,jdbcType=INTEGER})"
    })
    int insert(Emall record);

    @InsertProvider(type=EmallSqlProvider.class, method="insertSelective")
    int insertSelective(Emall record);

    @SelectProvider(type=EmallSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="click", property="click", jdbcType=JdbcType.INTEGER),
        @Result(column="shopid", property="shopid", jdbcType=JdbcType.INTEGER)
    })
    List<Emall> selectByExample(EmallExample example);

    @UpdateProvider(type=EmallSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Emall record, @Param("example") EmallExample example);

    @UpdateProvider(type=EmallSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Emall record, @Param("example") EmallExample example);
}