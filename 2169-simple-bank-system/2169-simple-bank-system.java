class Bank {
    long[] B;

    public Bank(long[] balance) {
        B = balance;

    }

    private boolean isInvalid(int a, long[] B) {
        if (a > B.length) {
            return true;
        }
        return false;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (isInvalid(account1, B) || isInvalid(account2, B) || B[account1 - 1] < money) {
            return false;
        }
        B[account1 - 1] -= money;
        B[account2 - 1] += money;
        return true;

    }

    public boolean deposit(int account, long money) {
        if (isInvalid(account, B)) {
            return false;
        }
        B[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (isInvalid(account, B) || B[account - 1] < money ) {
            return false;
        }
        B[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */