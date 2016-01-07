import java.util.Scanner;

public class _01GandalfStash {
    public static void main(String[] args) {


    Scanner Console = new Scanner(System.in);

    int firstMood = Integer.parseInt(Console.nextLine());
    String finalMood = "";
    String[] input = Console.nextLine().toLowerCase().split("\\W+");


    for (int i = 0; i < input.length; i++) {
        String food = input[i];

        switch (food) {
            case "cram": firstMood += 2;break;
            case "lembas": firstMood += 3;break;
            case "apple": firstMood += 1;break;
            case "melon": firstMood += 1;break;
            case "honeycake": firstMood += 5;break;
            case "mushrooms": firstMood -=10;break;
            default:firstMood -= 1;break;

        }
    }
    finalMood = Mood(firstMood);

    System.out.printf("%d\n%s",firstMood,finalMood);
}

    private static String Mood(int firstMood) {
        String finalMood;
        if(firstMood < -5){
            finalMood="Angry";
        }
        else if(firstMood >= -5 && firstMood < 0){
            finalMood="Sad";
        }
        else if(firstMood >= 0 && firstMood < 15){
            finalMood="Happy";
        }
        else{
            finalMood="Special JavaScript mood";
        }
        return finalMood;
    }
}
