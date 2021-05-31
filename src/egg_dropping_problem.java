public class egg_dropping_problem {

    public int calculate(int eggs, int floor)
    {
        int T[][]= new int[eggs+1][floor+1];
        int c= 0;
        for(int index= 0; index<=floor; index++)
        {
            T[1][index]= index;
        }
        for(int e= 2; e<=eggs; e++)
        {
            for(int f= 1; f<=floor;f++)
            {
                T[e][f]= Integer.MAX_VALUE;
                for(int k= 1; k<=f; k++)
                {
                    c= 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if(c < T[e][f])
                    {
                        T[e][f]= c;
                    }
                }
            }
        }
        return T[eggs][floor];
    }

    public static void main(String args[]){
        egg_dropping_problem ed = new egg_dropping_problem();
        int r = ed.calculate(3,100);
        System.out.println(r);
    }

}
