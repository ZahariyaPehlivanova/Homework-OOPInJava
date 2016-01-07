import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class _06UserLogs {
    public static void main(String[] args) {


    Scanner Console = new Scanner(System.in);

    TreeMap<String,LinkedHashMap<String,Integer>> result = new TreeMap<>();

    String command = Console.nextLine();
    while (!command.equals("end")){

        String[] text = command.split(" ");

        String[] ipElement = text[0].split("=");
        String ip = ipElement[1];

        String[] userElement = text[2].split("=");
        String user = userElement[1];

        if(!result.containsKey(user)){
            result.put(user,new LinkedHashMap<>());

            result.get(user).put(ip,1);
        }else{
            int count = 0;
            if(result.get(user).containsKey(ip)){
                count = result.get(user).get(ip);
            }
            result.get(user).put(ip,count+1);
        }

        command = Console.nextLine();
    }
    for(Map.Entry<String,LinkedHashMap<String,Integer>> res : result.entrySet()){
        String user = res.getKey();

        LinkedHashMap<String, Integer> ipCount = res.getValue();

        System.out.println(user + ": ");

        for(Map.Entry<String,Integer> res2 : ipCount.entrySet()) {
            String ip = res2.getKey();
            Integer count = res2.getValue();

            System.out.print(ip + " => " + count);
            String lastKey = getLastKey(ipCount);

            if (ip.equals(lastKey)) {
                System.out.printf(".");
            }
            else {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
    public static String getLastKey(LinkedHashMap<String, Integer> hashMap) {
        String out = "";
        for (String key : hashMap.keySet()) {
            out = key;
        }
        return out;
    }
}
