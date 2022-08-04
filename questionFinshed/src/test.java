import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        while (sc.hasNext()){
            i = sc.nextInt();
            if (i == 200)
                System.out.println("OK\n");
            if (i == 202)
                System.out.println("Accepted\n");
            if (i == 400)
                System.out.println("Bad Request\n");
            if (i == 403)
                System.out.println("Forbidden\n");
            if (i == 404)
                System.out.println("Not Found\n");
            if (i == 500)
                System.out.println("Internal Server Error\n");
            else if (i == 502)
                System.out.println("Bad Gateway\n");
        }
    }
}
