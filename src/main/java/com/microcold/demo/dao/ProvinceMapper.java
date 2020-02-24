package com.microcold.demo.dao;

import com.microcold.demo.entity.Province;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public interface ProvinceMapper
{
    @Insert("insert into province(name,popname,code,type,display,extention,update,x,y,id_province)values(#{name},#{popname},#{code},#{type},#{display},#{extention},#{update_province},#{x},#{y},#{id_province})")
    int add(@Param("name") String name,@Param("popname") String popname,@Param("code") String code,
            @Param("type") int type, @Param("display") long display,@Param("extention") boolean extention,
            @Param("update_province")String update_province,@Param("x") double x, @Param("y") double y,
            @Param("id_province") String id_province);

    @Update("update province set name=#{name},popname=#{popname},code=#{code},type=#{type},display=#{display},extention=#{extention},update_provicne=#{update_province},x=#{X},y=#{y},id_province=#{id_province} where id=#{id}")
    int update(@Param("id") int id, @Param("name") String name, @Param("popname") String popname, @Param("code") String code,
               @Param("type") int type, @Param("display") long display, @Param("extention") boolean extention,
               @Param("update_province")String update_province, @Param("x") double x, @Param("y") double y,
               @Param("id_province") String id_province);

    @Delete("delete from province where id=#{id}")
    int delete(int id);

    @Select("select id,name as name,popname as popname,code as code ,type as type,display as display,extention as extention,update_province as update_province,x as x ,y as y,id_province as id_province from province")
    Province findProvince(@Param("id") int id);

    @Select("select from province")
    List<Province> findProvinceList();


}
