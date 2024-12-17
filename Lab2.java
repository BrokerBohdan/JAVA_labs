import static java.lang.Math.*;

public class Lab2 {


    public static void main(String[] args) {
        Lab2 obgMain = new Lab2();
        obgMain.task1();
        obgMain.task2();
        obgMain.task3();

    }
    void task1() {
        double a = 0.345;
        double b = -2.25;
        double c = 2.65;
        double d = 3.99;
        double o = abs(b);
        double u = tanh(o);
        double p = sqrt((tan(abs(b) * c) / log(d)));
        double y = ((5 * a) / sin(a)) + sqrt((u * c) / (log(d)));
        System.out.println(y);
    }

    void task2()
    {
        double a =2.34;
        double b = 0.756;
        double c = 2.23;
        double d =-0.653;
        double y = ((exp(c) + 2 * log10(a)) / (sqrt(pow(c, b)))) * abs(asin(d));
        System.out.println(y);
    }

    void task3() {

        double a = 0.58;
        double b = -0.34;
        double c = 1.25;
        double d = 1.89;
        double y;
        y = 2*(log(abs(b/a))+sqrt(sinh(c)+exp(d)));
        System.out.println(y);
 
   }

}
