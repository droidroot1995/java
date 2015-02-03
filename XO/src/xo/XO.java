/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xo;
import java.util.*;

/**
 *
 * @author Александр
 */
public class XO {

    /**
     * @param args the command line arguments
     */
    static char matrix[][] = new char [3][3];
    
    public static char check()
    {
        int i;
        for(i =0; i<3; i++)
            if(matrix[i][0] == matrix[i][1] 
                    && matrix[i][0] == matrix[i][2]) return matrix[i][0];
        for(i =0; i<3; i++)
            if(matrix[0][i] == matrix[1][i] 
                    && matrix[0][i] == matrix[2][i]) return matrix[0][i];
        if(matrix[0][0] == matrix[1][1] 
                && matrix[1][1] == matrix[2][2])
            return matrix[0][0];
        if(matrix[0][2] == matrix[1][1] 
                && matrix[1][1] == matrix[2][0])
            return matrix[0][2];
        return ' ';
    }
     public static void init_matrix()
    {
        int i,j;
        for(i =0; i< 3; i++)
        {
            for(j =0; j<3; j++)
            {
                matrix[i][j] = ' ';
            }
        }
    }
    public static void get_player_move()
    {
        int x,y;
        Scanner sr = new Scanner(System.in);
        System.out.println("Введите координаты x,y: ");
        x = sr.nextInt();
        y = sr.nextInt();
        x--; y--;
        if(matrix[x][y] != ' ')
        {
            System.out.println("Неверный ход, попытайтесь ещё.");
            get_player_move();
        }
        else matrix[x][y] = 'X';
    }
    public static void get_computer_move()
    {
        int i=0;
        int j=0;
        for(i=0; i<3; i++)
        {
            for(j=0; j<3; j++)
            {
                if(matrix[i][j] == ' ') break;
            }
            if(matrix[i][j] == ' ') break;
        }
        if((i*j) == 9)
        {
            System.out.println("Ничья.");
            System.exit(0);
        }
        else
            matrix[i][j] = 'O';
    }
    public static void disp_matrix()
    {
        int t;
        for(t=0; t<3; t++)
        {
            System.out.println(matrix[t][0] + " | " + matrix[t][1] + " | " + matrix[t][2]);
            if(t!=2) System.out.println("\n---|---|---\n");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        char done;
        System.out.println("Крестики нолики.\n");
        done = ' ';
        init_matrix();
        do
        {
            disp_matrix();
            get_player_move();
            done = check();
            if(done != ' ') break;
            get_computer_move();
            done = check();
        }
        while(done == ' ');
        if(done == 'X') System.out.println("Вы победили.");
        else System.out.println("Я выиграл!!!");
        disp_matrix();
    }
}
