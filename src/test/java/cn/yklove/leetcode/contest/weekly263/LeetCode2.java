package cn.yklove.leetcode.contest.weekly263;

import org.junit.Test;

/**
 * @author beamjl
 */
public class LeetCode2 {

    class Bank {

        private long[] balance;

        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if(checkAccount(account1) || checkAccount(account2)){
                return false;
            }
            if (!withdraw(account1, money)) {
                return false;
            }
            deposit(account2, money);
            return true;
        }

        public boolean deposit(int account, long money) {
            if (checkAccount(account)) {
                return false;
            }
            balance[account - 1] += money;
            return true;
        }



        public boolean withdraw(int account, long money) {
            if (checkAccount(account)) {
                return false;
            }
            if (balance[account - 1] < money) {
                return false;
            }
            balance[account - 1] -= money;
            return true;
        }

        private boolean checkAccount(int account) {
            return account <= 0 || account > balance.length;
        }
    }

    @Test
    public void test(){
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        bank.withdraw(3,10);
        bank.transfer(5,1,20);
        bank.deposit(5,20);
        bank.transfer(3,4,15);
        bank.withdraw(10,50);
        System.out.println("x");
    }

}
