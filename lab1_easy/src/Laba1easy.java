import java.util.Scanner;

public class Laba1easy {
    public static void main(String[] args){
        float count = 0;
        float count2 = 0;
        float srednee;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите вашу фразу: ");
        String s1 = in.nextLine();
        count = s1.length();


        System.out.println("Скажите еще что-то умное: ");
        String s2 = in.nextLine();
        count2=s2.length();

        srednee = (count + count2)/2;
        System.out.println(srednee);

        if (count<srednee){
            System.out.println("В фразе " + s1 + " " + count + " символ(ов)");

        } else if(count2<srednee){
            System.out.println("В фразе " + s2 + " " + count2 + " символ(ов)");
        } else if(count == count2) {
            System.out.println("В ваших фразах одинаковое число символов, наслаждайтесь!\n" + s1 + " " + s2);

        }





    }

}
