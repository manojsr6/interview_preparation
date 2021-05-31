import java.util.HashMap;

public class mobile_numeric_keypad_problem {

    HashMap<Character, Integer> xmap= new HashMap<>();
    final static int row[]= {0, 0, -1, 0, 1};
    final static int col[]= {0, -1, 0, 1, 0};
    public int getCount(int n)
    {
        int [][]phone_key= new int[10][];

        phone_key[0]= new int[]{0,8};
        phone_key[1]= new int[]{1, 2, 4};
        phone_key[2]= new int[]{1,2,3,5};
        phone_key[3]= new int[]{2, 3, 6};
        phone_key[4]= new int[]{1, 4, 5, 7};
        phone_key[5]= new int[]{2,4,5,6,8};
        phone_key[6]= new int[]{3, 9, 6, 5};
        phone_key[7]= new int[]{7, 4, 8};
        phone_key[8]= new int[]{8, 5, 7, 9,0};
        phone_key[9]= new int[]{9,6, 8};

        int arr[]= new int[]{1,1,1,1,1,1,1,1,1,1};

        for(int i= 2; i<=n;i++)
        {
            int Arr2[]= new int[10];

            for(int j= 0; j<10; j++)
            {
                for(int x= 0; x< phone_key[j].length;x++)
                Arr2[phone_key[j][x]] += arr[j];
            }

            for(int k= 0; k<10;k++)
            {
                arr[k]= Arr2[k];
            }
        }

        int sum= 0;
        for(int i= 0; i<10;i++)
        {
            sum+= arr[i];
        }
        return sum;

    }

    public int getCount_recursive_util(char phoneKey[][], int i, int j, int n)
    {
        if(phoneKey == null || n<=0)
            return 0;
        if(n == 1)
            return 1;
        int totalcount= 0, ro= 0, co= 0, move= 0;
        for(move= 0;move<5;move++)
        {
            ro= i+ row[move];
            co= j+ col[move];
            if(ro>= 0 && ro <= 3 && co >= 0 && co <= 2 && phoneKey[ro][co] != '*' && phoneKey[ro][co] !='#')
            {
                totalcount += getCount_recursive_util(phoneKey, ro, co, n-1);
            }
        }
        return totalcount;
    }
    public int getCount_recursive(int n)
    {
        char keypad[][] = {{'1','2','3'},
                {'4','5','6'},
                {'7','8','9'},
                {'*','0','#'}};
        if (n == 1)
            return 10;
        int totalCount=0;
        for (int i= 0; i<4; i++)
        {
            for(int j=0 ; j<3; j++)
            {
                if(keypad[i][j] != '*' && keypad[i][j] !='#')
                {
                    if(!xmap.isEmpty() && xmap.containsKey(keypad[i][j]))
                    {
                        totalCount +=xmap.get(keypad[i][j]);
                    }
                    else
                    {
                        totalCount += getCount_recursive_util(keypad, i, j, n);
                        xmap.put(keypad[i][j], totalCount);
                    }
                }
            }
        }
        return totalCount;
    }



    public static void main (String[] args)
    {

        mobile_numeric_keypad_problem obj= new mobile_numeric_keypad_problem();
        int n = 2;

        System.out.println(obj.getCount_recursive(n));
    }
}
