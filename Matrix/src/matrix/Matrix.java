/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;
import java.io.*;
import java.util.*;

/**
 *
 * @author ���������
 */
public class Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int a,m1,n1,m,n,ch,kol;
        long x1,x2,x3,y1,y2,y3,z1,z2,z3,c1,c2,c3;
        double det,dx,dy,dz,x,y,z;
        long [][] mat1 = new long[3][3];
        long [][] mat2 = new long[3][3];
        long [][] mat3 = new long[3][3];
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out, "Cp866"), true);
        Scanner s = new Scanner(System.in);
         do
        {
        pw.println("��������� ��� �������� ������. Alpha version 1");
        pw.println("�������� �����: ");
        pw.println("1.��������� ������������ �������.");
        pw.println("2.�������� ������.");
        pw.println("3.��������� ������.");
        pw.println("4.��������� ������� ���������.");
        pw.println("5.��������� ������� �� �����.");
        pw.println("6.���������������� �������.");
        pw.println("0.�����.");
        System.out.println();
        a = s.nextInt();
        switch(a)
        {
            case 1:
                pw.println("������� ������� �������(2/3): ");
                pw.println("������� m: ");
                m = s.nextInt();
                pw.println("������� n: ");
                n = s.nextInt();
                if(m != n)
                {
                    pw.println("���������� ��������� ������������! ������������ �������!");
                }
                else
                {
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=s.nextLong();
                        }
                    }
                    if(m==2 && n==2)
                    {
                        det = mat1[0][0]*mat1[1][1]-mat1[0][1]*mat1[1][0];
                    }
                    else
                    {
                        det = mat1[0][0]*(mat1[1][1]*mat1[2][2]-mat1[1][2]*mat1[2][1])-
                                mat1[0][1]*(mat1[1][0]*mat1[2][2]-mat1[1][2]*mat1[2][0])+
                                mat1[0][2]*(mat1[1][0]*mat1[2][1]-mat1[1][1]*mat1[2][0]);
                    }
                    pw.println("������������ �����: ");
                    System.out.println(det);
                    System.out.println();
                }
                break;
            case 2:
                pw.println("������� ������� ������ �������(2/3): ");
                pw.println("������� m: ");
                m = s.nextInt();
                pw.println("������� n: ");
                n = s.nextInt();
                pw.println("������� ������� ������ ������� �������(2/3): ");
                pw.println("������� m1: ");
                m1 = s.nextInt();
                pw.println("������� n1: ");
                n1 = s.nextInt();
                if(n!=n1 && m!=m1)
                {
                    pw.println("���������� ������� �������! �� ������� �� ���������!");
                }
                else
                {
                    pw.println("������� ������ �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=s.nextLong();
                        }
                    }
                    pw.println("������� ������ �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat2[i][j]=s.nextLong();
                        }
                    }
                    pw.println("���������� �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat3[i][j]=mat1[i][j]+mat2[i][j];
                            System.out.print(mat3[i][j]+" ");
                            if(j== n-1)
                            {
                                System.out.println();
                            }
                        }
                    }
                }
                break;
            case 3:
                pw.println("������� ������� ������ �������(2/3): ");
                pw.println("������� m: ");
                m = s.nextInt();
                pw.println("������� n: ");
                n = s.nextInt();
                pw.println("������� ������� ������ ������� �������(2/3): ");
                pw.println("������� m1: ");
                m1 = s.nextInt();
                pw.println("������� n1: ");
                n1 = s.nextInt();
                if(n!=n1)
                {
                    pw.println("���������� ����������� �������! ������������ �������!");
                    System.out.println();
                }
                else
                {
                    pw.println("������� ������ �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=s.nextLong();
                        }
                    }
                    pw.println("������� ������ �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat2[i][j]=s.nextLong();
                        }
                    }
                    for (int i = 0; i < m; i++) 
                    {
                        for (int j = 0; j < n; j++) 
                        {
                            for (int k = 0; k < mat1[0].length; k++) 
                            {
                                mat3[i][j] += mat1[i][k] * mat2[k][j];
                            }
                        }
                    }
                    pw.println("���������� �������: ");
                    for(int i = 0; i<mat3.length; i++)
                    {
                        for(int j = 0; j<mat3[0].length; j++)
                        {
                            System.out.print(mat3[i][j]+" ");
                            if(j==mat3[0].length-1)
                            {
                                System.out.println();
                            }
                        }
                    }
                }
                break;
            case 4: 
                pw.println("������� ���������� ����������(2/3): ");
                kol = s.nextInt();
                if(kol == 2)
                {
                    pw.println("������� x1: ");
                    x1 = s.nextLong();
                    pw.println("������� y1: ");
                    y1 = s.nextLong();
                    pw.println("������� ����� ������� ���������: ");
                    c1 = s.nextLong();
                    pw.println("������� x2: ");
                    x2 = s.nextLong();
                    pw.println("������� y2: ");
                    y2 = s.nextLong();
                    pw.println("������� ����� ������� ���������: ");
                    c2 = s.nextLong();
                    det = x1*y2-x2*y1;
                    dx = c1*y2-c2*y1;
                    dy = x1*c2-x2*c1;
                    if(det == 0)
                    {
                       pw.println("������������ ����� ����! ������ ���!"); 
                    }
                    else
                    {
                    x= dx/det;
                    y= dy/det;
                    pw.println("x �����: ");
                    System.out.println(x);
                    pw.println("y �����: ");
                    System.out.println(y);
                    }
                }
                else
                {
                    pw.println("������� x1: ");
                    x1 = s.nextLong();
                    pw.println("������� y1: ");
                    y1 = s.nextLong();
                    pw.println("������� z1: ");
                    z1 = s.nextLong();
                    pw.println("������� ����� ������� ���������: ");
                    c1 = s.nextLong();
                    pw.println("������� x2: ");
                    x2 = s.nextLong();
                    pw.println("������� y2: ");
                    y2 = s.nextLong();
                    pw.println("������� z2: ");
                    z2 = s.nextLong();
                    pw.println("������� ����� ������� ���������: ");
                    c2 = s.nextLong();
                    pw.println("������� x3: ");
                    x3 = s.nextLong();
                    pw.println("������� y3: ");
                    y3 = s.nextLong();
                    pw.println("������� z3: ");
                    z3 = s.nextLong();
                    pw.println("������� ����� �������� ���������: ");
                    c3 = s.nextLong();
                    det = x1*(y2*z3-z2*y3)-y1*(x2*z3-z2*x3)+z1*(x2*y3-y2*x3);
                    dx = c1*(y2*z3-z2*y3)-y1*(c2*z3-z2*c3)+z1*(c2*y3-y2*c3);
                    dy = x1*(c2*z3-z2*c3)-c1*(x2*z3-z2*x3)+z1*(x2*c3-c2*x3);
                    dz = x1*(y2*c3-c2*y3)-y1*(x2*c3-c2*x3)+c1*(x2*y3-y2*x3);
                    if(det == 0)
                    {
                        pw.println("������������ ����� ����! ������ ���!");
                    }
                    else
                    {
                    x= dx/det;
                    y= dy/det;
                    z=dz/det;
                    pw.println("x �����: ");
                    System.out.println(x);
                    pw.println("y �����: ");
                    System.out.println(y);
                    pw.println("z �����: ");
                    System.out.println(z);
                    }
                }
                break;
            case 5: 
                pw.println("������� ������� �������(2/3): ");
                pw.println("������� m: ");
                m = s.nextInt();
                pw.println("������� n: ");
                n = s.nextInt();
                pw.println("������� �����: ");
                ch = s.nextInt();
                pw.println("������� �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=s.nextLong();
                        }
                    }
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=mat1[i][j] * ch;
                        }
                    }
                    pw.println("���������� �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            System.out.print(mat1[i][j]+" ");
                            if(j==n-1)
                            {
                                System.out.println();
                            }
                        }
                    }
                    
                break;
            case 6: 
                pw.println("������� ������� �������(2/3): ");
                pw.println("������� m: ");
                m = s.nextInt();
                pw.println("������� n: ");
                n = s.nextInt();
                pw.println("������� �������: ");
                    for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            mat1[i][j]=s.nextLong();
                        }
                    }
                  pw.println("���������� �������: ");
                  for(int i = 0; i<m; i++)
                    {
                        for(int j = 0; j<n; j++)
                        {
                            System.out.print(mat1[j][i]+" ");
                            if(j==n-1)
                            {
                                System.out.println();
                            }
                        }
                    }  
                break;
        }
        }
        while(a !=0);
    }
}
