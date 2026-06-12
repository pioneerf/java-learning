package lol;

public class ADC extends hero {
    private double ASB;//射手拥有额外攻速
    private double RangeChance;//射手拥有额外攻击距离
    


public ADC(double hp,double mp,double AD,double AP,int Range,int AH,double critChance,int AR,int MR, double ASB,double RangeChance,String name){
        super(hp, mp, AD, AP, Range, AH, critChance, AR, MR, name);
        this.ASB = ASB;
        this.RangeChance = RangeChance;
}
}
