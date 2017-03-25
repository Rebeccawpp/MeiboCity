package com.example.mapper;

import com.example.model.Info;
import com.example.model.InfoExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

public interface InfoMapper {
    @Select("call p_info (" +
            " #{curpage,mode=IN,jdbcType=VARCHAR}  ," +
            " #{userid,mode=IN,jdbcType=VARCHAR}  ," +
            " #{flag,mode=IN,jdbcType=VARCHAR} )")
    @Options(statementType = StatementType.CALLABLE)
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="info_date", property="infoDate", jdbcType=JdbcType.DATE),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="stick", property="stick", jdbcType=JdbcType.INTEGER),
            @Result(column="stick_time", property="stickTime", jdbcType=JdbcType.TIMESTAMP)//,
//            @Result(column="userid", property="shop",
//                    one = @One(select = "com.example.mapper.ShopMapper.selectByUserId")),
//            @Result(column="userid", property="user",
//                    one = @One(select = "com.example.mapper.UserMapper.selectByPrimaryKey"))
    })
    List<Info> select(Map map);

    @Select({
            "select",
            "id, userid, title, content, info_date",
            "from info",
            "where flag=#{flag,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="info_date", property="infoDate", jdbcType=JdbcType.DATE),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="stick", property="stick", jdbcType=JdbcType.INTEGER),
            @Result(column="stick_time", property="stickTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="userid", property="shop",
                    one = @One(select = "com.example.mapper.ShopMapper.selectByUserId")),
            @Result(column="userid", property="user",
                    one = @One(select = "com.example.mapper.UserMapper.selectByPrimaryKey"))
    })
    List<Info> selectAll(Integer flag);


    @SelectProvider(type=InfoSqlProvider.class, method="countByExample")
    int countByExample(InfoExample example);

    @DeleteProvider(type=InfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(InfoExample example);

    @Delete({
        "delete from info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

//    @Select({
//            "select",
//            "title",
//            "from info",
//            "where title like '%#{val,jdbcType=VARCHAR}%'"
//    })
//    List<String> testselect(String val);

    @Insert({
            "insert into info (id, userid, ",
            "title, content, ",
            "info_date, flag)",
            "values (#{id,jdbcType=INTEGER}, #{userid,jdbcType=INTEGER}, ",
            "#{title,jdbcType=VARCHAR}, #{content,jdbcType=VARCHAR}, ",
            "#{infoDate,jdbcType=DATE}, #{flag,jdbcType=INTEGER})"
    })
    int insert(Info record);

    @InsertProvider(type=InfoSqlProvider.class, method="insertSelective")
    int insertSelective(Info record);

    @SelectProvider(type=InfoSqlProvider.class, method="selectByExample")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
            @Result(column="info_date", property="infoDate", jdbcType=JdbcType.DATE),
            @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
            @Result(column="stick", property="stick", jdbcType=JdbcType.INTEGER),
            @Result(column="stick_time", property="stickTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="userid", property="shop",
                    one = @One(select = "com.example.mapper.ShopMapper.selectByUserId")),
            @Result(column="userid", property="user",
                    one = @One(select = "com.example.mapper.UserMapper.selectByPrimaryKey"))
    })
    List<Info> selectByExample(InfoExample example);

    @Select({
        "select",
        "id, userid, title, content, info_date, flag, stick, stick_time",
        "from info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="userid", property="userid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="info_date", property="infoDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER),
        @Result(column="stick", property="stick", jdbcType=JdbcType.INTEGER),
        @Result(column="stick_time", property="stickTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="userid", property="shop",
                    one = @One(select = "com.example.mapper.ShopMapper.selectByUserId"))

    })
    Info selectByPrimaryKey(Integer id);

    @UpdateProvider(type=InfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Info record, @Param("example") InfoExample example);

    @UpdateProvider(type=InfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Info record, @Param("example") InfoExample example);

    @UpdateProvider(type=InfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Info record);

    @Update({
        "update info",
        "set userid = #{userid,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "info_date = #{infoDate,jdbcType=TIMESTAMP},",
          "flag = #{flag,jdbcType=INTEGER},",
          "stick = #{stick,jdbcType=INTEGER},",
          "stick_time = #{stickTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Info record);
}