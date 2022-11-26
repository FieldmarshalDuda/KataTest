import java.util.ArrayList;
import java.util.List;

public class Calc {
    private static boolean IsRoman(char input, List RomanList) {

        return RomanList.contains(input);
    }
private static String ToRoman(int digit, String result) throws CalcException {
    int [] num = {100,90,50,40,10,9,5,4,1};
    String [] litra = {"C","XC","L","XL","X","IX","V","IV","I"};
    if (digit<=0)
    {
        throw new CalcException("Результат операции с римскими цифрами - неположительное число");
    }
    for (int i=0;i<num.length;i++){
        while (digit / num[i]>0)
        {
            result+= litra[i];
            digit-=num[i];
        }
    }


    return result;
}

    private static int ToArab(char romandigit)
    {
        return switch (romandigit) {
            case ('I') -> 1;
            case ('V') -> 5;
            case ('X') -> 10;
            default -> (0);
        };

    }

    public static String calc (String input) throws CalcException {
        char doing = ' ';
        if (input.contains("+")) {
            doing = '+';
        }
        if (input.contains("-")) {
            doing = '-';
        }
        if (input.contains("*")) {
            doing = '*';
        }
        if (input.contains("/")) {
            doing = '/';
        }
        if (doing == ' ') {
            throw new CalcException("Требуется ввести оператор из числа: + , - , *, /");
        }
        if (!input.contains(" ")){
            throw new CalcException("Символы должны быть разделены пробелом");
        }
        List RomanList = new ArrayList();
        RomanList.add('I');
        RomanList.add('V');
        RomanList.add('X');
        boolean roman = false;
        int a = 0;
        int b = 0;
        int i = 0;
        int c = 0;
        char[] array = input.toCharArray();

        if (IsRoman(array[0], RomanList))
        {
            roman = true;
        }
        if (roman)
        {

            while (array[i] != ' ')
            {
                if (!IsRoman(array[i], RomanList))
                {
                    throw new CalcException("Неверный формат ввода - арабские и римские цифры");
                } else
                {
                    if (array[i] == 'I' && array[i + 1] != 'I' && array[i + 1] != ' ')
                    {
                        a += ToArab(array[i + 1]) - ToArab(array[i]);
                        i++;
                    }
                    else
                    {

                        a += ToArab(array[i]);

                    }
                }
                i++;
            }

            for (int y = array.length-1; y > i; y--) {
                if (array[y] != doing && array[y] != ' ') {
                    if (!IsRoman(array[y], RomanList)) {

                        throw new CalcException("Неверный формат ввода - арабские и римские цифры");

                    }
                    if (array[y] != 'I' && (array[y - 1] == 'I')) {
                        b += ToArab(array[y]) - ToArab(array[y-1]);
                        y--;
                    }
                    else
                    {

                        b += ToArab(array[y]);

                    }
                }
            }
        }
        if (!roman)
        {

            while (array[i] != ' ')
            {
                if (!IsRoman(array[i], RomanList))
                {
                    throw new CalcException("Неверный формат ввода - арабские и римские цифры");
                }
                else
               a+= array[i];
                i++;
            }
            a= Character.getNumericValue(a);

            for (int y = i+1; y < array.length; y++)
            {
                if (!IsRoman(array[i], RomanList))
                {
                    throw new CalcException("Неверный формат ввода - арабские и римские цифры");
                }
                else
                if (array[y] != doing && array[y] != ' ') {
                    b += array[y];
                }
            }
            b= Character.getNumericValue(b);

        }

        switch (doing) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            case '/':
                c = a / b;
                break;
            case '*':
                c = a * b;
        }
        if (roman)
        {String result ="";
            return(ToRoman(c,result));
        }

        return (Integer.toString(c));
    }
}
