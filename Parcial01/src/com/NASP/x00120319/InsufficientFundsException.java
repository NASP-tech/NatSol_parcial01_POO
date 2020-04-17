package com.NASP.x00120319;

    public class InsufficientFundsException extends Exception {
        private double amount;

        public InsufficientFundsException(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }
}
