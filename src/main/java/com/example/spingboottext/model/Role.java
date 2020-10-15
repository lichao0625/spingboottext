package com.example.spingboottext.model;

public class Role  {
    long id;
    String name;
    int age;
    int gender;
    int str;
    int spd;
    int act;
    int def;
    int hp;
    int mp;

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

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public int getStr() {
        return str;
    }
    public void setStr(int str) {
        this.str = str;
        if(age<35) {
            hp=str -18 + age/2;
            mp=100-str-20+age/2;
            act=str+age/5;
            def=str+age/5;
            spd = str / 2 - 18 + age / 2;
        }else {
            act=str+7-age/5;
            mp=100-str-20+age/2;
            def=str+7-age/5;
            spd = str / 2 + 18 - age / 2;
            hp=str+18-age/2;
        }
        hp = hp > 1 ? hp : 1;
        mp = mp > 1 ? mp : 1;
        def = def >1 ? def : 1;
        act = act > 1 ? act : 1;
        spd = spd > 1 ? spd : 1;
    }

    public int getSpd() {
        return spd;
    }

    public void setSpd(int spd) {
        this.spd = spd;
    }

    public int getAct() {
        return act;
    }

    public void setAct(int act) {
        this.act = act;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
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

    String createTime;
    String updateTime;
    long createBy;
    long updateBy;
}
