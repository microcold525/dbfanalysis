package com.microcold.demo.controller;

import com.microcold.demo.dao.ProvinceMapper;
import com.microcold.demo.entity.Province;
import com.microcold.demo.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.microcold.demo.util.read;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.microcold.demo.util.read.listarray;

@RestController
@RequestMapping("/map")
public class ProvinceContoller
{
    @Autowired
    ProvinceService provinceService;
    @GetMapping(value = "first")
    public String addProvince()throws IOException
    {
        String path = "C:\\Users\\micro\\Desktop\\china region\\省界_region.dbf";
        String charset = "GB2312";
        List<Map<String,String >> result = read.readDbf(path, charset);
        String[][] one=listarray(result);
        //String[][] one=list2array(result,11);
        for(int i=0;i<one.length;i++)
        {
            for (int j = 0; j < 10; j++)
            {
                provinceService.add(one[i][0],one[i][1],one[i][2],one[i][3],one[i][4],one[i][5],one[i][6],one[i][7],one[i][8],one[i][9]);
            }

        }

    }
    @GetMapping(value="/list")
    public List<Province> getProvince(){
        return provinceService.findProvinceList();
    }
    @GetMapping(value="/{id}")
    public Province getProvinceById(@PathVariable("id") int id){
        return provinceService.findProvince(id);
    }

    @PutMapping(value="/id")
    public String updateProvince(@PathVariable("id") int id,
                                 @RequestParam(value="name") String name,@RequestParam(value="popname") String popname,
                                 @PathVariable(value = "code") String code,@PathVariable(value="type") int type,
                                 @PathVariable(value="display") long display,@PathVariable(value="extention") boolean extention,
                                 @PathVariable(value="update_province",required = false) String update_province ,
                                 @PathVariable(value="x") double x,@PathVariable(value="y") double y,
                                 @PathVariable(value="id_provicne") String id_provicne){
        int t=provinceService.update(id,name,popname,code,type,display,extention,update_province,x,y,id_provicne);
        if(t==1){
            return "success";
        }else{
            return "failed";
        }
    }
    @PostMapping(value="")
    public String postProvince( @RequestParam(value="name") String name,@RequestParam(value="popname") String popname,
                                @PathVariable(value = "code") String code,@PathVariable(value="type") int type,
                                @PathVariable(value="display") long display,@PathVariable(value="extention") boolean extention,
                                @PathVariable(value="update_province",required = false) String update_province ,
                                @PathVariable(value="x") double x,@PathVariable(value="y") double y,
                                @PathVariable(value="id_provicne") String id_provicne)
    {
        int t = provinceService.add(name, popname, code, type, display, extention, update_province, x, y, id_provicne);
        if(t==1){
            return "success";
        }else{
            return "failed";
        }
    }
}
