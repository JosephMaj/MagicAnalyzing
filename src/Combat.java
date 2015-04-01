import java.util.Scanner;

/**
 * Created by Joseph on 3/31/2015.
 */
public class Combat {
    BoardState boardState;
    public Combat(BoardState boardState){this.boardState=boardState;}


    public void combatHandler(Creature attacker, Creature[] blockers){
        int power=attacker.power;
        Scanner scanner= new Scanner(System.in);
        int i=0;
        while(power>0){
            System.out.println("How much damage would you like to deal to blocker:" +blockers[i].name);
            damgedealt=scanner.nextInt();
            blockers[i].toughness-=damagedealt;
            power-=damagedealt;
            attacker.toughness-=blockers[i].power;
            if(blockers[i].toughness<1){
                boardState.
            }
        }


    }





}
