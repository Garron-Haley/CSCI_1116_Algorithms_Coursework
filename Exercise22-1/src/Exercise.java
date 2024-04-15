import java.util.Scanner;

public class Exercise {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = input.nextLine();

        int j = 0;
        System.out.println(s.substring(j, 3));
        String max = "";
        for(int i = 1; i < s.length(); i++){
            String test = s.substring(j, i + 1);
            if(Substring(test)){
                if(test.length() > max.length()){
                    max = test;
                }
            } else{
                j++;
            }
        }
        System.out.println(max);
        input.close();
    }
    static boolean Substring(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) > s.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
