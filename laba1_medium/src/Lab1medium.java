import java.util.Scanner;

public class Lab1medium {
    public static void main(String[] args ){
        int num;
        int choice;
        Scanner in = new Scanner(System.in);

        System.out.print("Введите целое положительное число: ");
        num = in.nextInt();
        if(num<=0){
            System.out.print("Введите ПОЛОЖИТЕЛЬНОЕ число: ");
            num = in.nextInt();
        } else if(num%1 != 0){
            System.out.print("Введите ЦЕЛОЕ число: ");

        }

        System.out.print("Выбирите систему исчисления (1 - двоичная, 2 - восьмиричная, 3 - шестнадцатиричная): ");
        choice = in.nextInt();
        if (choice != 1 && choice != 2 && choice != 3){
            System.out.print("Сделайте правильный выбор(1,2,3): ");
            choice = in.nextInt();


        } else if(choice == 1){
            System.out.println("Ваше число в двоичной системе исчисления: " + Integer.toBinaryString(num));

        }else if(choice == 2){
            System.out.println("Ваше число в восьмиричной системе исчисления: " + Integer.toOctalString(num));

        } else if ( choice == 3){
            System.out.println("Ваше число в шестнадцатиричной системе исчисления: " + Integer.toHexString(num));

        }

        
    }
}
