package com.example.mapper;

import com.example.model.User;
import com.example.model.UserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {

    @Update({
            "update user",
            "set ",
            "address = #{address,jdbcType=VARCHAR} ,",
            "realname = #{realname,jdbcType=VARCHAR},",
            "phone = #{phone,jdbcType=VARCHAR},",
            "email = #{email,jdbcType=VARCHAR} ",
            "where id = #{id,jdbcType=INTEGER}"})
    int saveinfo(User record);


    @Select("call p_login (" +
            " #{username,mode=IN,jdbcType=VARCHAR}  ," +
            " #{password,mode=IN,jdbcType=VARCHAR}  )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
            @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
            @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
            @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
            @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
            @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
            @Result(column="info_num", property="infoNum", jdbcType=JdbcType.INTEGER),
            @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
            @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR)
    })
    User login(Map map);
    @Insert({
            "insert into user (username, ",
            "password)",
            "values (#{username,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR})"
    })
    int register(User record);

    @Update({
            "update user",
            "set phone = #{phone,jdbcType=VARCHAR} and",
            "email = #{email,jdbcType=VARCHAR} ",
//            "address = #{address,jdbcType=VARCHAR},",
//            "realname = #{realname,jdbcType=VARCHAR},",
//            "card_id = #{cardId,jdbcType=VARCHAR},",
//            "sex = #{sex,jdbcType=INTEGER},",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updatefile(User record);

    @Insert({
        "insert into user (id, username, ",
        "password, phone, ",
        "email, address, ",
        "realname, card_id, ",
        "flag, level, credit, ",
        "info_num, sex, avatar)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{realname,jdbcType=VARCHAR}, #{cardId,jdbcType=VARCHAR}, ",
        "#{flag,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, #{credit,jdbcType=INTEGER}, ",
        "#{infoNum,jdbcType=INTEGER}, #{sex,jdbcType=INTEGER}, #{avatar,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="info_num", property="infoNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExampleWithBLOBs(UserExample example);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="info_num", property="infoNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, username, password, phone, email, address, realname, card_id, flag, level, ",
        "credit, info_num, sex, avatar",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="realname", property="realname", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="credit", property="credit", jdbcType=JdbcType.INTEGER),
        @Result(column="info_num", property="infoNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "card_id = #{cardId,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "credit = #{credit,jdbcType=INTEGER},",
          "info_num = #{infoNum,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=INTEGER},",
          "avatar = #{avatar,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(User record);

    @Update({
        "update user",
        "set username = #{username,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "realname = #{realname,jdbcType=VARCHAR},",
          "card_id = #{cardId,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=INTEGER},",
          "level = #{level,jdbcType=INTEGER},",
          "credit = #{credit,jdbcType=INTEGER},",
          "info_num = #{infoNum,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}