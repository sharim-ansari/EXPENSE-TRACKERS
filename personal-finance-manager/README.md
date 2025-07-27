# Personal Finance Manager

## Overview
The Personal Finance Manager is a full-stack desktop application designed to help users manage their personal finances effectively. It allows users to track their income and expenses, categorize transactions, and generate reports for better financial insights.

## Features
- **User Registration and Login**: Secure user authentication to manage personal finance data.
- **Dashboard**: A comprehensive view of user balance, recent transactions, and analytics.
- **Transaction Management**: Add, edit, and delete transactions with categorization.
- **Categorization**: Create and manage categories for better organization of transactions.
- **Reports and Analytics**: Generate monthly spending reports and visualize financial data.

## Technologies Used
- **Backend**: Java with JDBC for MySQL database integration.
- **Frontend**: HTML and CSS for the user interface.
- **Database**: MySQL for data storage.

## Project Structure
```
personal-finance-manager
├── backend
│   ├── src
│   │   ├── controller
│   │   ├── model
│   │   ├── dao
│   │   ├── service
│   │   ├── util
│   │   └── Main.java
│   └── resources
├── frontend
│   ├── html
│   └── css
├── sql
└── README.md
```

## Setup Instructions
1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd personal-finance-manager
   ```

2. **Set up the database**:
   - Create a MySQL database and run the SQL schema located in `sql/schema.sql` to set up the necessary tables.

3. **Configure the application**:
   - Update the database connection details in `backend/resources/application.properties`.

4. **Run the backend**:
   - Compile and run the Java application from the `backend/src` directory.

5. **Access the frontend**:
   - Open `frontend/html/index.html` in a web browser to start using the application.

## Sample Data
- Users can register with their email and password.
- Sample categories include "Food", "Transport", "Utilities", etc.
- Transactions can be added with details such as amount, date, category, and description.

## Screenshots
- [Include screenshots of the application here]

## License
This project is licensed under the MIT License - see the LICENSE file for details.