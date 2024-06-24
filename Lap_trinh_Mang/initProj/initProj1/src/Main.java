import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String res = "", inp = sc.nextLine();
        for (int i = 0; i < inp.length(); i++) {
            char c = inp.charAt(i);
            if (c == '"' || c == ' ') {
                continue;
            }
            if (c == ':') {
                res += '@';
            } else if (c == ',') {
                res += ' ';
            } else {
                res += c;
            }
        }
        System.out.println(res);
    }
}
