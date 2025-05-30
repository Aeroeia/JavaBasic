package com.itheima;

import java.util.Random;

public class Role {
    private String name;
    private int blood;

    public Role() {
    }

    public Role(String name, int blood) {
        this.name = name;
        this.blood = blood;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return blood
     */
    public int getBlood() {
        return blood;
    }

    /**
     * 设置
     * @param blood
     */
    public void setBlood(int blood) {
        this.blood = blood;
    }
    public void attack(Role role)
    {
        Random r = new Random();
        int hurt = r.nextInt(20)+1;
        System.out.println(this.name+"对"+role.getName()+"进行攻击");
        System.out.println();
        int remainBlood = role.getBlood()-hurt;
        remainBlood = remainBlood>0?remainBlood:0;
        role.setBlood(remainBlood);
        System.out.println(role.getName()+"剩余"+role.getBlood()+"血量");
        System.out.println();
    }


}
