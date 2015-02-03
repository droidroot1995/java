/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg114;

/**
 *
 * @author Александр
 */
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.util.*;
import java.*;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new FileInputStream("in.txt"), "Windows-1251");
        Scanner m = new Scanner(System.in);
        PrintStream ps = new PrintStream(System.out, true, "cp866");
        double [] value20 = new double [200];
        double [] value40 = new double [100];
        double sigma1,sigma2,n1,n2,sqn1,sqn2,s1n1,s2n2,sign1,sign2,en11,en12,en21,en22;
        int tmp,c;
        sigma1 = sigma2 = 0;
        double max20 = 0;
        double max40 = 0;
        int i = 0;
        int j;
        n1 = n2 = 0;
        while(s.hasNextDouble())
        {
            value20[i] = s.nextDouble();
            if(value20[i] > max20)
            {
                max20 = value20[i];
            }
            n1 += value20[i];
            i++;
        }
        n1 /= 200;
        sqn1 = Math.sqrt(n1);
        for(i = 0, j = 0; i<200; i+=2, j++)
        {
            value40[j] = value20[i]+value20[i+1];
            if(value40[j]>max40)
            {
                max40 = value40[j];
            }
            n2 += value40[j];
        }
        n2 /= 100;
        sqn2 = Math.sqrt(n2);
        double [] val20 = new double[(int)max20];
        double [] val40 = new double[(int)max40];
        for(i=0; i<(int)max20; i++)
        {
            val20[i] = 0;
        }
        for(i=0; i<(int)max40; i++)
        {
            val40[i] = 0;
        }
        for(i = 0; i<200; i++)
        {
            sigma1 += (value20[i]-n1)*(value20[i]-n1);
        }
        sigma1 = Math.sqrt(sigma1/200);
        for(j = 0; j<100; j++)
        {
            sigma2 += (value40[j]-n2)*(value40[j]-n2);
        }
        sigma2 = Math.sqrt(sigma2/100);
        for(j = 0; j<100; j++)
        {
            tmp = (int)(value40[j]-1);
            val40[tmp]++;
        }
        for(i = 0; i<200; i++)
        {
            val20[(int)value20[i]-1]++;
        }
        sign1 = sigma1/Math.sqrt(200);
        sign2 = sigma2/Math.sqrt(100);
        en11 = sign1*100/n1;
        en12 = 100/Math.sqrt(n1*200);
        en21 = sign2*100/n2;
        en22 = 100/Math.sqrt(n2*100);
        s1n1 = sigma1*100/n1;
        s2n2 = sigma2*100/n2;
        ps.println("20 измерений: \n");
        for(i=0; i<200; i++)
        {
            if((i+1)%10 == 0)
            {
               ps.println(value20[i]);
            }
            else
            {
                ps.print(value20[i]+"\t");
            }
        }
        ps.println();
        ps.println("n1 = "+n1+"\n");
        ps.println("sigma1 = "+ sigma1+"\n");
        ps.println("sqrt(n1) = " + sqn1+"\n");
        ps.println("sigma1/n1 = "+ s1n1+"%\n");
        ps.println("sign1 = "+ sign1+"\n");
        ps.println("en11 = " + en11+"%\n");
        ps.println("en12 = " + en12+"%\n");
        ps.println("Число\tКоличество\tЧастота");
        for(i=0; i<(int)max20; i++)
        {
            if(val20[i] != 0)
                ps.println((i+1)+"\t"+val20[i]+"\t\t"+(val20[i]/200));
        }
        ps.println("\n");
        ps.println("40 измерений: \n");
        for(i=0; i<100; i++)
        {
            if((i+1)%10 == 0)
            {
                ps.println(value40[i]);
            }
            else
            {
                ps.print(value40[i]+"\t");
            }
        }
        ps.println();
        ps.println("n2 = "+n2+"\n");
        ps.println("sigma2 = "+ sigma2+"\n");
        ps.println("sqrt(n2) = " + sqn2+"\n");
        ps.println("sigma2/n2 = "+ s2n2+"%\n");
        ps.println("sign2 = "+ sign2+"\n");
        ps.println("en21 = " + en21+"%\n");
        ps.println("en22 = " + en22+"%\n");
        ps.println("Число\tКоличество\tЧастота");
        for(i=0; i<(int)max40; i++)
        {
            if(val40[i] != 0)
                ps.println((i+1)+"\t"+val40[i]+"\t\t"+(val40[i]/100));
        }
        ps.println();
        ps.println("Измерения окончены.");
        c = m.nextInt();
    }
}
