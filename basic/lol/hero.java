package lol;

public class hero {
    protected double hp;//血量
    private double mp;//蓝量
    public double AD;//攻击力
    private double AP;//法强
    private int Range;//攻击距离
    private int AH;//技能急速
    private double critChance;//暴击率
    private int AR;//护甲
    private int MR;//魔抗
    private String name;//英雄名字

public hero(double hp,double mp,double AD,double AP,int Range,int AH,double critChance,int AR,int MR,String name){
    this.hp = hp;
    this.mp = mp;
    this.AD = AD;
    this.AP = AP;
    this.Range = Range;
    this.AH = AH;
    this.critChance = critChance;
    this.AR = AR;
    this.MR = MR;
    this.name = name;
}


public double getHp(){
    return hp;
}

public void setHp(double hp){
    this.hp = hp;
}


//@return
public double getAD(){
    return AD;
}

public void setAD(double AD){
    this.AD = AD;
}


public double getcritChance(){
    return critChance;
}

public void setcritChance(double critChance){
    this.critChance = critChance;
}

public void basicAttack(hero target){
    double damage = this.AD;
    double critChance = this.critChance;
    if (Math.random() < critChance) {
        damage *= 2; // 假设暴击造成双倍伤害
        System.out.println(this.name + " 触发暴击！");
    }
    target.hp -= damage;
    System.out.println(this.name + " 普通攻击造成 " + damage + " 物理伤害");
}

}