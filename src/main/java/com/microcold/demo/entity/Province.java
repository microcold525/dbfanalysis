package com.microcold.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Province implements Serializable
{
    private int id;
    private String name;
    private String popname;
    private String code;
    private int type;
    private long display;
    private boolean extention;
    private String update_province;
    private double x;
    private double y;
    private String id_province;
}
