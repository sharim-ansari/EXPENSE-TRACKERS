package service;

import dao.TransactionDAO;
import model.Transaction;

import java.util.List;
import java.util.stream.Collectors;

public class ReportService {

    private TransactionDAO transactionDAO;

    public ReportService() {
        this.transactionDAO = new TransactionDAO();
    }

    public List<Transaction> getMonthlySpendingReport(int userId, int month, int year) {
        List<Transaction> transactions = transactionDAO.getTransactionsByUserId(userId);
        return transactions.stream()
                .filter(transaction -> transaction.getDate().getMonthValue() == month && transaction.getDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public double getTotalSpending(int userId, int month, int year) {
        List<Transaction> monthlyTransactions = getMonthlySpendingReport(userId, month, year);
        return monthlyTransactions.stream()
                .filter(transaction -> transaction.getType().equals("expense"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }

    public double getTotalIncome(int userId, int month, int year) {
        List<Transaction> monthlyTransactions = getMonthlySpendingReport(userId, month, year);
        return monthlyTransactions.stream()
                .filter(transaction -> transaction.getType().equals("income"))
                .mapToDouble(Transaction::getAmount)
                .sum();
    }
}