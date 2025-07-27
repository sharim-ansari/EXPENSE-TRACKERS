package dao;

import model.Transaction;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {

    private Connection connection;

    public TransactionDAO() {
        connection = DBConnection.getConnection();
    }

    public void addTransaction(Transaction transaction) {
        String sql = "INSERT INTO transactions (amount, date, category, description, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setDate(2, java.sql.Date.valueOf(transaction.getDate()));
            pstmt.setString(3, transaction.getCategory());
            pstmt.setString(4, transaction.getDescription());
            pstmt.setString(5, transaction.getType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaction(Transaction transaction) {
        String sql = "UPDATE transactions SET amount = ?, date = ?, category = ?, description = ?, type = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDouble(1, transaction.getAmount());
            pstmt.setDate(2, java.sql.Date.valueOf(transaction.getDate()));
            pstmt.setString(3, transaction.getCategory());
            pstmt.setString(4, transaction.getDescription());
            pstmt.setString(5, transaction.getType());
            pstmt.setInt(6, transaction.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaction(int transactionId) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, transactionId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setId(rs.getInt("id"));
                transaction.setAmount(rs.getDouble("amount"));
                transaction.setDate(rs.getDate("date").toLocalDate());
                transaction.setCategory(rs.getString("category"));
                transaction.setDescription(rs.getString("description"));
                transaction.setType(rs.getString("type"));
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}