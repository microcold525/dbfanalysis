package com.microcold.demo.service;

import com.microcold.demo.dao.ProvinceMapper;
import com.microcold.demo.entity.Province;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService
{
    @Autowired
    private ProvinceMapper provinceMapper;

    public int add(String name,String popname,String code,int type,long display,boolean extention,
                   String update_province,double x,double y,String id_province){
        return provinceMapper.add(name,popname,code,type,display,extention,update_province,x,y,id_province);
    }

    public int update(int id,String name,String popname,String code,int type,long display,boolean extention,
                      String update_province,double x,double y,String id_province){
        return provinceMapper.update(id,name,popname,code,type,display,extention,update_province,x,y,id_province);
    }

    public int delete(int id){
        return provinceMapper.delete(id);
    }

    public Province findProvince(int id){
        return provinceMapper.findProvince(id);
    }

    public List<Province> findProvinceList(){
        return provinceMapper.findProvinceList();
    }
}
