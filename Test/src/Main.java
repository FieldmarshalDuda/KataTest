import java.util.*;
import java.io.*;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws CalcException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ввод требуемой строки");
        String input = scanner.nextLine();
        System.out.println(Calc.calc(input));
    }
}



