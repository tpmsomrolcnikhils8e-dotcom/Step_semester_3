package Step_semester_3;

import java.util.Scanner;

public class pattern {
    static void printNumberPyramid(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
            
        }
        

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the rows");
        int n=sc.nextInt();
        printNumberPyramid(n);

    }
}
    
}
