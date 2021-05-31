import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class castle_on_grid {
    static final int[][] MOVES = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public void minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY )
    {
        int n= grid.size();
        char [][]p= new char[n+2][n+2];
        char [][]color= new char[n+2][n+2];
        Move [][]prev= new Move[n+2][n+2];
        Queue<Move> pqeue= new LinkedList<Move>();

        //filling color matrix with white color
        for(int index= 0; index<(n+2); index++)
        {
            for(int index2= 0; index2<(n+2); index2++)
            {
                color[index][index2]= 'w';
            }
        }

        // filling p array using grid elements
        for(int index= 0; index<grid.size();index++)
        {
            for(int j= 0; j<grid.get(index).length();j++)
            {
                p[index][j]=grid.get(index).charAt(j);
            }
        }

        pqeue.add(new Move(startX,startY));
        color[startX][startY]= 'G';

        while(!pqeue.isEmpty())
        {
            Move temp= pqeue.poll();
            color[temp.x][temp.y]= 'R';
            for(int[] delta: MOVES)
            {
                int x= temp.x + delta[0];
                int y= temp.y + delta[1];
                while(x>=0 && x < n && y >= 0 && y < n&&p[x][y] != 'X' && color[x][y] == 'w')
                {
                    pqeue.add(new Move(x, y));
                    color[x][y]= 'G';
                    prev[x][y]= temp;
                    x+= delta[0];
                    y+= delta[1];
                }
            }



//
//
//            color[temp.x][temp.y]= 'R';
//            for(int j= 0; j<n;j++)
//            {
//                if(p[temp.x][j] != 'X' && color[temp.x][j] == 'w')
//                {
//                    pqeue.add(new Move(temp.x, j));
//                    color[temp.x][j]= 'G';
//                    prev[temp.x][j]= temp;
//                }
//                if(p[temp.x][j] == 'X')
//                {
//                    break;
//                }
//            }
//            for(int j= 0; j<n;j++)
//            {
//                if(p[j][temp.y] != 'X' && color[j][temp.y] == 'w')
//                {
//                    pqeue.add(new Move(j, temp.y));
//                    color[j][temp.y]= 'G';
//                    prev[j][temp.y]= temp;
//                }
//                if(p[j][temp.y] == 'X')
//                {
//                    break;
//                }
//            }
//
//            for(int j= n-1; j>0;j--)
//            {
//                if(p[temp.x][j] != 'X' && color[temp.x][j] == 'w')
//                {
//                    pqeue.add(new Move(temp.x, j));
//                    color[temp.x][j]= 'G';
//                    prev[temp.x][j]= temp;
//                }
//                if(p[temp.x][j] == 'X')
//                {
//                    break;
//                }
//            }
//
//            for(int j= n-1; j>0;j--)
//            {
//                if(p[j][temp.y] != 'X' && color[j][temp.y] == 'w')
//                {
//                    pqeue.add(new Move(j, temp.y));
//                    color[j][temp.y]= 'G';
//                    prev[j][temp.y]= temp;
//                }
//                if(p[j][temp.y] == 'X')
//                {
//                    break;
//                }
//            }

        }
        Stack<Move> st= new Stack<Move>();
        int w=goalX;
        int z=goalY;
        while(prev[w][z] != null)
        {
            st.push(new Move(w,z));
            Move temp= prev[w][z];
            w= temp.x;
            z= temp.y;
        }
        System.out.print("("+startX+","+startY+") ");
        int count= 0;
        while(!st.isEmpty())
        {
            ++count;
            Move temp= st.pop();
            System.out.print("("+temp.x+","+temp.y+") ");
        }
        System.out.print(count);
        // display of grid which form recently
//        for(int index= 0; index < n+2;index++)
//        {
//            for(int j= 0; j < n+2;j++)
//            {
//                if(prev[index][j] != null)
//                    System.out.print("("+prev[index][j].x+","+prev[index][j].y+")");
//                else
//                    System.out.print("-1");
//            }
//            System.out.println();
//        }
    }

    public static void main(String args[])
    {
        castle_on_grid obj= new castle_on_grid();
        List<String> arr= new LinkedList<String>() ;
        arr.add("...");
        arr.add(".X.");
        arr.add(".X.");
        obj.minimumMoves(arr, 2,0,0,2);
    }
}
