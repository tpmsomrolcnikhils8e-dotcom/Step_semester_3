package main.java.problem1.class_problems.Assignment_problems;

import java.util.Scanner;

public class votingage {
    static void checkVotingEligibilty(int age){
        boolean eligible=age>18;
        if(eligible){
            System.out.println("Eligible to vote");
        }
        else{
            System.out.println("Not Eligible to vote");
        }
    
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your Age:");
        int age=sc.nextInt();

        checkVotingEligibilty(age); 

    }
    
}
    
}
