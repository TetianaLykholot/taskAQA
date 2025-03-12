package common.automation.module.taskSeleniumTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        while (a < 10) {
            int b = 0;
            if (a == 0 || a == 9) {
                while (b < 20) {
                    System.out.print("0");
                    b++;
                }
            }
                while (b < 20) {
                    if (b == 0 || b == 19) {
                        while (b < 20) {
                            System.out.print("4");
                            b++;
                        }
                    }
                    System.out.println(" ");

                }

                System.out.println(" ");
                a++;
            }


//
//        String enter = s.nextLine();
//        while (!result) {
//            if (enter.equals("ENTER")) {
//                System.out.println(sum + "wwwww");
//
//            }
//            a = s.nextInt();
//            sum = ++a;
//            System.out.println(sum + "aaaaa");
//
//        }
        }
    }
