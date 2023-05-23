/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package group_q_bse203179_bse203041_a3;

/**
 *
 * @author Eisha Tariq
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

 public interface Viewuser {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl(); 
        
        // Create a JFrame to hold the components
        JFrame frame = new JFrame("Users List");

        // Create a table to display user data
        JTable userTable = new JTable(new UserTableModel(userDao.getAllUsers()));

        // Create a scroll pane to hold the table
        JScrollPane scrollPane = new JScrollPane(userTable);

        // Create a button to view users
        JButton viewUsersButton = new JButton("View Users");
        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display the user table in a message dialog
                JOptionPane.showMessageDialog(frame, scrollPane);
            }
        });

        // Add the button to the JFrame
        frame.getContentPane().add(viewUsersButton);

        // Set the JFrame size and make it visible
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class User {
    private int uid;
    private String username;
    private String password;
    private boolean isAdmin;

    public User(int uid, String username, String password, boolean isAdmin) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}

interface UserDao {
    List<User> getAllUsers();
}

class UserDaoImpl implements UserDao {
    // Implement the UserDao interface methods
    // Example implementation for getAllUsers()
    @Override
    public List<User> getAllUsers() {
        // Simulate retrieving users from the database using the DAO pattern
        // Replace this with your actual implementation
        List<User> users = new ArrayList<>();
        users.add(new User(1, "admin", "admin123", true));
        return users;
    }
}

class UserTableModel extends javax.swing.table.AbstractTableModel {
    private List<User> users;
    private String[] columnNames = {"UID", "USERNAME", "PASSWORD", "ADMIN"};

    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getUid();
            case 1:
                return user.getUsername();
            case 2:
                return user.getPassword();
            case 3:
                return user.isAdmin();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
