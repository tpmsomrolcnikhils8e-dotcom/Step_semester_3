package Step_semester_3;

import java.util.Scanner;

public class prime {
    static void checkPrime(int number){
        boolean isprime=true;
        for(int i=2;i<number/2;i++){
            if(number%i==0){
                isprime=false;
                break;
            }
        }
        if(isprime){
            System.out.println("Prime");
        }
        else{
            System.out.println("Not Prime");
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int number=sc.nextInt();
        checkPrime(number);

    }

}
    
}
