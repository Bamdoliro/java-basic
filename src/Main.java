import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array1 = sc.nextLine().split(",");
        String[] array2 = sc.nextLine().split(",");
        String[] array3 = sc.nextLine().split(",");


        ArrayList<Integer> attacker1 = Arrays.stream(array1).
                map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> attacker2 = Arrays.stream(array2)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> goalkeeper = Arrays.stream(array3)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        int attacker1Score;
        int attacker2Score;

        attacker1Score = attacker1.stream()
                .mapToInt(i -> i)
                .map(i -> goalkeeper.contains(i) ? 0 : 1)
                .sum();
        attacker2Score = attacker2.stream()
                .mapToInt(i -> i)
                .map(i -> goalkeeper.contains(i) ? 0 : 1).sum();

        if(attacker1Score > attacker2Score) {
            System.out.println("attacker1이 승리하였습니다");
        } else if(attacker1Score < attacker2Score) {
            System.out.println("attacker2이 승리하였습니다");
        } else {
            System.out.println("무승부입니다");
        }

        sc.close();
    }
}