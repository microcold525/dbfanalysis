package com.microcold.demo.util;

import com.linuxense.javadbf.DBFReader;
import com.microcold.demo.entity.Province;
import com.microcold.demo.service.ProvinceService;
import com.zaxxer.hikari.util.UtilityElf;
import com.linuxense.javadbf.*;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.sql.ClientInfoStatus;
import java.util.*;

public class read
{


    public static List<Map<String, String>> readDbf(String path, String charsetName) throws IOException {
        List<Map<String, String>> rowList = new ArrayList<>();
        InputStream fis = new FileInputStream(path);
        DBFReader dbfReader = new DBFReader(new FileInputStream(path), Charset.forName(charsetName));

        Object[] rowValues;
        while ((rowValues = dbfReader.nextRecord()) != null) {
            Map<String, String> rowMap = new HashMap<String, String>();
            for (int i = 0; i < rowValues.length; i++) {
                rowMap.put(dbfReader.getField(i).getName(), String.valueOf(rowValues[i]).trim());
            }
            //System.out.println(rowMap);
            rowList.add(rowMap);

        }
        dbfReader.close();
        fis.close();
        return rowList;

    }
    //将List转换为二维数组String[][]
    public static String[][] listarray(List<Map<String,String>> result){
    String[][] z = new String[result.size()][];

                 for(int i=0;i<z.length;i++)
                 {

                     Map m = (Map) result.get(i);
                     Set set = m.keySet();
                     z[i] = new String[m.size()];
                     Iterator it = set.iterator();

                     for (int j = 0; it.hasNext(); j++)
                     {
                         String s = (String) it.next();
                         if (m.get(s) != null)
                         {
                             z[i][j] = m.get(s).toString();
                         }
                     }
                 }
                 return z;
}

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\micro\\Desktop\\china region\\省界_region.dbf";
        String charset = "GB2312";
        List<Map<String,String >> result = read.readDbf(path, charset);
        String[][] one=listarray(result);
        //String[][] one=list2array(result,11);
        for(int i=0;i<one.length;i++)
        {
            for (int j = 0; j < 10; j++)
            {
                System.out.println(one[i][j]);
            }

        }

        /*for(Map<String,String> m: result){
           for(String k:m.keySet())
            {
                System.out.println(m.get(k));
            }
        }*/

    }

}
