import java.util.Arrays;

public class bracket_problem {
    public static char findClosing(char open)
    {
        if(open == '(')
            return ')';
        if(open == '[')
            return ']';
        if(open == '{')
            return '}';
        return Character.MIN_VALUE;
    }
    public static boolean check(char exp[], int n)
    {
        if(n == 0)
            return true;
        if(n == 1)
            return false;
        if(exp[0] == ')' || exp[0] == '}' || exp[0] == ']')
            return false;

        char close_check= findClosing(exp[0]);

        int index, count= 0;
        for(index= 0; index < n;index++)
        {
            if(exp[index] == exp[0])
                count++;
            if(exp[index] == close_check)
            {
                if(count == 0)
                    break;
                count--;
            }

        }
        if(index == n)
            return false;
        if( index == 1)
            return  check(Arrays.copyOfRange(exp, index+1, n), n-2);
        return check(Arrays.copyOfRange(exp, 1, n), index-1) && check(Arrays.copyOfRange(exp, (index+1 ), n), n-index-1);
    }

    public static void main(String args[])
    {
            char expr[] = "()".toCharArray();
            int n = expr.length;
            if (check(expr, n))
                System.out.println("Balanced");
            else
                System.out.println("Not Balanced");
    }
}
