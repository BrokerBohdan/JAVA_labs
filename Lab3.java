import static java.lang.Math.*;
import java.util.Scanner;

public class Lab3 {
    public static void main(String[] args) {
        decision();
        again();
    }

    public static void decision(){
        Scanner scanner =new Scanner(System.in);
        int taskNumb ;

        do {
            System.out.println("Введiть номер завдання для виконання (1, 2, 3) ");
            taskNumb = scanner.nextInt();

            switch (taskNumb) {
                case 1:
                    task1.tasks();
                    break;
                case 2:
                    task2.tasks();
                    break;
                case 3:
                    task3.tasks();
                    break;
                default:
                    System.out.println("Невiрний номер завдання. Спробуйте ще раз.");
            }
        } while (taskNumb < 1 || taskNumb > 3);
    }
    public static void again()
    {
        Scanner scanner = new Scanner(System.in);
      int i;
        do {
            System.out.println("Чи хочете ви вибрате ще якесь завдання? 1 - так , 2 - нi");
             i = scanner.nextInt();
            switch (i){
                case 1 :
                    decision();
                    break;
                case 2 :
                    System.out.println("bye");
                    break;
                default:
                    do {
                        System.out.println("Спробуйте ще раз");
                        i = scanner.nextInt();
                    }while(i==3);
            }
        }while (i==1);
    }
}
class task1 {
    public static void tasks() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введiть z");
        double z = in.nextDouble();
        double k = 15;
        if (z < 0) {
            throw new IllegalArgumentException("z має бути бiльше за нуль");
        }
        else {
            double sum = 0;
            for (int i = 1; i<k; i++) {
                sum += Func(z, i ,k);
            }
            System.out.println("Результат: " + sum);
        }
    }

    public static double Func(double z,int i , double k) {
        return ((1/(sqrt(z*i))) + tan(k/i));
    }
}

    class task2 {
        public static void tasks() {
            Scanner in = new Scanner(System.in);
            System.out.println("Введiть t");
            double t = in.nextDouble();
            System.out.println("Введiть i");
            double i = in.nextDouble();
            double x = 0;
            if (i == 1) {
                if (t < 0) {
                    throw new IllegalArgumentException("корiнь із вiд'ємного числа в данiй програмi не вираховується");
                }
                x = sqrt(t);
                System.out.println(x);
            }
            if (i == 2) {
                if (t < 0) {
                    throw new IllegalArgumentException("корiнь iз вiд'ємного числа в данiй програмi не вираховується");
                }
                x = 1 / (sqrt(t));
                System.out.println(x);
            }
            if (i != 1 && i != 2) {
                double k;
                for (k = 1; k <= i; k++) {
                    x += k * t;
                }
                System.out.println(x);
            }


        }
    }

class task3 {
    public static void tasks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введiть значення e (e > 0):");
        double epsilon = scanner.nextDouble();

        if (epsilon <= 0) {
            throw new IllegalArgumentException("ε should be greater than 0");
        }

        double sum = calculateInfiniteSum(epsilon);
        System.out.println("Результат: " + sum);
    }

    public static double calculateInfiniteSum(double epsilon) {
        double sum = 0;
        double term;
        int i = 0;

        do {
            term = pow(-2, i) / (factorial(i) * (i + 1.0));
            sum += term;
            i++;
        } while (abs(term) >= epsilon);
        return sum;
    }

    public static double factorial(int n) {
        double result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}