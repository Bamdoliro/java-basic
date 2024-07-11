import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] miss = new int[]{0,0};
        ArrayList<String> goalkeeper = new ArrayList<String>();
        ArrayList<String> attacker1 = new ArrayList<String>();
        ArrayList<String> attacker2 = new ArrayList<String>();

        System.out.print("attacker1이 찰 공을 입력해주세요 : ");
        attacker1.add(sc.nextLine());
        System.out.print("attacker2가 찰 공을 입력해주세요 : ");
        attacker2.add(sc.nextLine());
        System.out.print("goalkeeper가 막을 공을 입력해주세요 : ");
        goalkeeper.add(sc.nextLine());
        for(String goal : goalkeeper.get(0).split(",")) {
            for(String shoot : attacker1.get(0).split(",")) {
                if(shoot.contains(goal)) miss[0] +=1;
            }
            for(String shoot : attacker2.get(0).split(",")) {
                if(shoot.contains(goal)) miss[1] +=1;
            }
        }
        if(miss[0]<miss[1]) System.out.println("attacker1 님이 승리하셨습니다.");
        else if (miss[0]>miss[1]) System.out.println("attacker2 님이 승리하셨습니다.");
        else System.out.println("무승부입니다.");
    }
}