package com.Swiggy.MagicalArena;

import java.util.Random;

public class Game {
private Player PlayerA;
private Player PlayerB;
private Random random;

    public Game(Player playerA, Player playerB) {
        PlayerA = playerA;
        PlayerB = playerB;
        this.random = new Random();
    }
    public int rolldice(){
        return random.nextInt(6)+1;
    }
    public void performAttack(Player attacker,Player defender){
        int attackvalue = rolldice();
        int defendvalue = rolldice();

        int attackdamage = attacker.getAttack() * attackvalue;
        int defendstrength = defender.getStrength() * defendvalue;

        int damage = attackdamage - defendstrength;
        if (damage > 0) {
            defender.reduceHealth(damage);
        }
    }
    public void start(){
        while(PlayerA.isAlive()&&PlayerB.isAlive()){
            if(PlayerA.getHealth()<= PlayerB.getHealth()) {
                performAttack(PlayerA, PlayerB);
                if(PlayerB.isAlive())
                    performAttack(PlayerB,PlayerA);
            }
            else{
                performAttack(PlayerB, PlayerA);
                if(PlayerA.isAlive())
                    performAttack(PlayerA,PlayerB);
            }
        }
    }
public String getResult(){
        if(!PlayerA.isAlive())
            return "Player B wins";
        else
            return "Player A wins";

}


}
