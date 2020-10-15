package com.example.spingboottext.model;

public class Address {

    long id;
    String name;
    String des;//描述
    int eco;//经济
    //int traffic;//交通
    int tec;//科技
    int rel;//宗教

    String createTime;
    String updateTime;
    long createBy;
    long updateBy;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getEco() {
        return eco;
    }

    public void setEco(int eco) {
        this.eco = eco;
    }

    public int getTec() {
        return tec;
    }

    public void setTec(int technology) {
        this.tec = technology;
    }

    public int getRel() {
        return rel;
    }

    public void setRel(int religion) {
        this.rel = religion;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(long createBy) {
        this.createBy = createBy;
    }

    public long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(long updateBy) {
        this.updateBy = updateBy;
    }


}
