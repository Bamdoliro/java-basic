import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Attacker {
    private static Scanner n = new Scanner(System.in);
    public String name;
    int count = 5;
    String[] ball = new String[5];
    public Attacker(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void scanBall() {
        String balls = n.nextLine();
        ball = balls.split(",");
    }
}

class Goalkeeper {
    private static Scanner n = new Scanner(System.in);
    public String name;
    String[] ball = new String[4];

    public Goalkeeper(String name) {
        this.name = name;
    }

    public void scanBall() {
        String balls = n.nextLine();
        ball = balls.split(",");
    }
}

public class Main {
    public static void main(String[] args) {
        Attacker[] attackerArray = {new Attacker("attacker1"), new Attacker("attacker2")};
        int flag = 0;
        ArrayList<Attacker> attackers = Arrays.stream(attackerArray)
                .collect(Collectors.toCollection(ArrayList::new));

        Goalkeeper[] goalkeeperArray = {new Goalkeeper("goalkeeper")};

        ArrayList<Goalkeeper> goalkeepers = Arrays.stream(goalkeeperArray)
                .collect(Collectors.toCollection(ArrayList::new));

        for (Attacker attacker : attackers) {
            attacker.scanBall();
        }

        for (Goalkeeper goalkeeper : goalkeepers) {
            goalkeeper.scanBall();
        }

        for(int i = 0; i < 5; i++) {
            flag=0;
            for(int j=0; j<4; j++){
                if(attackerArray[0].ball[i].equals(goalkeeperArray[0].ball[j])){
                    flag = 1;
                    break;
                }
            }
            if(flag==1){
                attackerArray[0].count--;
            }
        }
        for(int i = 0; i < 5; i++) {
            flag=0;
            for(int j=0; j<4; j++){
                if(attackerArray[1].ball[i].equals(goalkeeperArray[0].ball[j])){
                    flag = 1;
                    break;
                }
            }
            if(flag==1){
                attackerArray[1].count--;
            }
        }
        if(attackerArray[0].count>attackerArray[1].count){
            System.out.println(attackerArray[0].getName() + "님이 승리");
        }else if(attackerArray[1].count>attackerArray[0].count){
            System.out.println(attackerArray[1].getName() + "님이 승리");
        }else{
            System.out.println("무승부");
        }

    }

}

