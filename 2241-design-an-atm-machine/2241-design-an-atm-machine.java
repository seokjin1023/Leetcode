class ATM {
    private final int[] banknotes = {20, 50, 100, 200, 500};
    private int[] numOfBanknotes;

    public ATM() {
        numOfBanknotes = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++) 
            numOfBanknotes[i] += banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        boolean canWithdraw = true;
        int[] withdrawedBanknotes = new int[5];
        for(int i = 4; i >= 0; i--) {
            int maxNotes = Math.min(numOfBanknotes[i], amount / banknotes[i]);
            amount -= maxNotes * banknotes[i];
            withdrawedBanknotes[i] = maxNotes;
        }
        if(amount != 0) 
            return new int[]{-1};
        for(int i = 0; i < 5; i++) {
            numOfBanknotes[i] -= withdrawedBanknotes[i];
        }
        return withdrawedBanknotes;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */