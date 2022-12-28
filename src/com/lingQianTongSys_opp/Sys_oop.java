package com.lingQianTongSys_opp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Sys_oop {
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";
    Date date = null;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String detail = "------------零钱通收支明细------------";
    double balance = 0;  //余额
    double money = 0;  //收益
    String note;

    public void mainMenu() {
        do {
            //初始化界面
            System.out.println("\n--------------零钱通---------------");
            System.out.println("        1 收支明细");
            System.out.println("        2 收益入账");
            System.out.println("        3 消   费");
            System.out.println("        4 退   出");
            System.out.println("请选择(1-4)");

            key = scanner.next();

            switch (key){
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.quit();
                    break;
                default:
                    System.out.println("选择有误，请重新选择");
                    break;
            }
        }while(loop);
    }

    public void detail(){
        System.out.println(detail);
    }

    public void income(){
        System.out.println("收益入账金额：");
        money = scanner.nextDouble();

        // 不正常的入账金额
        if(money<=0){
            System.out.println("收益入账金额应大于0");
            return;
        }
        balance += money;
        date = new Date();
        detail += "\n收益入账\t+" + money + "\t" + sdf.format(date) +"\t" + balance;
    }

    public void pay(){
        System.out.println("消费金额：");
        money = scanner.nextDouble();

        //输入不正常的消费金额
        if(money<=0||money>balance){
            System.out.println("消费金额范围应该在(0,"+balance+")");
            return;
        }
        System.out.println("消费说明：");
        note = scanner.next();
        date = new Date();
        balance -= money;
        detail += "\n消费金额\t-" + money + "\t" + sdf.format(date)+"\t" + balance;
    }

    public void quit(){
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
    }
}
