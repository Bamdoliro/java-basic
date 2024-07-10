import java.util.Scanner;

class Attacker {
    private static Scanner n = new Scanner(System.in);
    public String name;
    String[] ball = new String[5];

    int total=5;

    public Attacker(String name) {
        this.name = name;
    }

    public void scanBall() {
        String balls = n.nextLine();

        String[] number = balls.split(",");

        for (int i = 0; i < number.length; i++) {
            ball[i] = number[i];
        }
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

        String[] number = balls.split(",");

        for (int i = 0; i < number.length; i++) {
            ball[i] = number[i];
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Attacker attacker1 = new Attacker("attacker1");
        Attacker attacker2 = new Attacker("attacker2");
        Goalkeeper goalkeeper = new Goalkeeper("goalkeeper");

        attacker1.scanBall();
        attacker2.scanBall();
        goalkeeper.scanBall();

        for(int i=0; i<attacker1.ball.length; i++) {
            for(int j=0; j<goalkeeper.ball.length; j++) {
                if(attacker1.ball[i].equals(goalkeeper.ball[j])) {
                    attacker1.total --;
                }
            }
        }
        for(int i=0; i<attacker2.ball.length; i++) {
            for(int j=0; j<goalkeeper.ball.length; j++) {
                if(attacker2.ball[i].equals(goalkeeper.ball[j])) {
                    attacker2.total --;
                }
            }
        }
        if(attacker1.total>attacker2.total){
            System.out.println("1번 승리");
        } else if (attacker1.total<attacker2.total) {
            System.out.println("2번 승리");
        }else{
            System.out.println("무승부");
        }
    }
}


