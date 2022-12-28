package com.lingQianTongSys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class lingQianTongSys {
    public static void main(String[] args) {

        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String detail = "------------零钱通收支明细------------";
        double balance = 0;  //余额
        double money = 0;  //收益
        String note;

        do{
            //初始化界面
            System.out.println("\n--------------零钱通---------------");
            System.out.println("        1 收支明细");
            System.out.println("        2 收益入账");
            System.out.println("        3 消   费");
            System.out.println("        4 退   出");
            System.out.println("请选择(1-4)");

            key = scanner.next();

            //选择
            switch (key){
                case "1"://收支明细
                    System.out.println(detail);
                    break;

                case "2"://收益入账
                    System.out.println("收益入账金额：");
                    money = scanner.nextDouble();

                    // 不正常的入账金额
                    if(money<=0){
                        System.out.println("收益入账金额应大于0");
                        break;
                    }
                    balance += money;
                    date = new Date();
                    detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) +"\t" + balance;
                    break;

                case "3"://消费
                    System.out.println("消费金额：");
                    money = scanner.nextDouble();

                    //输入不正常的消费金额
                    if(money<=0||money>balance){
                        System.out.println("消费金额范围应该在(0,"+balance+")");
                        break;
                    }
                    System.out.println("消费说明：");
                    note = scanner.next();
                    date = new Date();
                    balance -= money;
                    detail += "\n消费金额\t-" + money + "\t" + sdf.format(date)+"\t" + balance;
                    break;

                case "4":  //退出
                    String choice;

                    while(true)
                    {
                        System.out.println("你确定退出吗？y/n");
                        choice = scanner.next();
                        if("y".equals(choice)||"n".equals(choice))
                            break;
                    }

                    if(choice.equals("y")){
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("输入范围不在1-4之内");
                    break;
            }
        }while(loop);

        System.out.println("您已退出零钱通系统");
    }
}
