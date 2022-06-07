package com.joe.sync;

//模拟不安全银行取钱
public class UnsafeBank {

    public static void main(String[] args) {
        //初始化账户金额
        Account account = new Account(100,"项目奖金");

        new DrawMoney(account,50,"张三").start();
        new DrawMoney(account,50,"李四").start();
    }

}

//账户
class Account{
    //金额
    int money;
    //卡名
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

//模拟取钱
class DrawMoney extends Thread{

    //账户
    private Account account;
    //取钱金额
    int drawMoney;
    //现在手里金额
    int nowMoney;

    public DrawMoney(Account account, int drawMoney,String name) {
        super(name);
        this.account = account;
        this.drawMoney = drawMoney;
    }

    @Override
    public void run() {
        //synchronized块
        synchronized (account){
            if (account.money-drawMoney<=0){
                System.out.println(this.getName()+"账户余额不足，取不了");
                return;
            }
            try {
                //模拟延时
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡里余额 = 账户金额-取出金额
            account.money=account.money-drawMoney;
            //现在手里金额 = 现在手里金额+取出金额追加
            nowMoney=nowMoney+drawMoney;
            System.out.println(account.name+"余额为："+account.money);
            System.out.println(this.getName()+"现在手机金额为："+nowMoney);
        }


    }
}
