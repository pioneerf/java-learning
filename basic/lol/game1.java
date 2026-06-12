package lol;

public class game1 {
    public static void main(String[] args) {
        ADC player1 = new ADC(1000, 500, 150, 50, 550, 0, 0.5, 30, 20, 0.2, 100, "寒冰射手");
        hero target = new hero(1200, 300, 100, 30, 200, 0, 0.1, 50, 30, "敌方英雄");
        
        player1.basicAttack(target);
        System.out.println("目标剩余血量: " + target.getHp());
    }
}
