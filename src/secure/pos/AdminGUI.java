/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package secure.pos;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import products.*;
import users.*;
import transactions.*;

/**
 *
 * @author fernandoenad
 */
public class AdminGUI extends javax.swing.JFrame {
    private TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
    private ProductDAOImpl productDAOImpl = new ProductDAOImpl();
    private UserDAOImpl userDAOImpl = new UserDAOImpl();
    private User user = null;
    private Product product = null;

    public AdminGUI() {
        initComponents();
        refreshTables();
        login_admin();
    }
    
    public void login_admin(){
        AdminLoginGUI adminloginGUI = new AdminLoginGUI(this, true);
        
        adminloginGUI.show(true);
        
        this.user = adminloginGUI.getUser();
        userGreetingLBL.setText("Hi, " + adminloginGUI.getUser().getUsername() + "!");
    }
    
    public void refreshTransactionsTBL(){
        DefaultTableModel model = (DefaultTableModel) transactionsTBL.getModel();
        model.setRowCount(0);
        
        for(Transaction transaction : transactionDAOImpl.read_all()){
            Product product = productDAOImpl.read_one(transaction.getProduct_id());
            User user = userDAOImpl.read_one(transaction.getUser_id());
            model.addRow(new Object[]{
                transaction.getTransaction_id(), 
                product.getName(),
                transaction.getQuantity(),
                String.format("%.2f", transaction.getTotal_price()),
                user.getUsername(),
                transaction.getDate()
            });
        }
        
        refreshTransactionsUserCB();
    }
    
    public void refreshTransactionsUserCB(){
        transactionsUsersCB.removeAllItems();
        
        for(User user : userDAOImpl.search("Cashier")){
            transactionsUsersCB.addItem(user.getUsername());
        }
    }
    
    public void refreshProductsTBL(){
        DefaultTableModel model = (DefaultTableModel) productsTBL.getModel();
        model.setRowCount(0);
        
        for(Product product : productDAOImpl.read_all()){
            model.addRow(new Object[]{
                product.getProduct_id(), 
                product.getName(),
                String.format("%.2f", product.getPrice()),
                product.getStock()
            });
        }
        
    }
    
    public void refreshUsersTBL(){
        DefaultTableModel model = (DefaultTableModel) usersTBL.getModel();
        model.setRowCount(0);
        usersRoleCashierRB.setSelected(true);
        usersUsernameTF.setEditable(true);
        
        for(User user : userDAOImpl.read_all()){
            model.addRow(new Object[]{
                user.getUser_id(), 
                user.getUsername(),
                user.getRole()
            });
        }
    }
    
    public void refreshTables(){
        refreshTransactionsTBL();
        refreshProductsTBL();
        refreshUsersTBL();
    }
    
    public void searchTransactionsTable(int user_id){
        DefaultTableModel model = (DefaultTableModel) transactionsTBL.getModel();
        model.setRowCount(0);
        
        for(Transaction transaction : transactionDAOImpl.readTransactionsByUser(user_id)){
            model.addRow(new Object[]{
                transaction.getTransaction_id(), 
                productDAOImpl.read_one(transaction.getProduct_id()).getName(),
                transaction.getQuantity(),
                transaction.getTotal_price(),
                userDAOImpl.read_one(transaction.getUser_id()).getUsername(),
                transaction.getDate()
            });
        }
    }
    
    public void searchProductsTable(String str){
        DefaultTableModel model = (DefaultTableModel) productsTBL.getModel();
        model.setRowCount(0);
        
        for(Product product : productDAOImpl.search(str)){
            model.addRow(new Object[]{
                product.getProduct_id(), 
                product.getName(),
                String.format("%.2f", product.getPrice()),
                product.getStock()
            });
        }
        
    }
    
    public void resetTransactionsTab(){
        refreshTransactionsTBL();
    }
    
    public void resetProductsTab(){
        refreshProductsTBL();
        productsNameTF.setText("");
        productsPriceTF.setText("");
        productsStockTF.setText("");
        productsSaveBTN.setText("Save");
    }
    
    public void resetUsersTab(){
        refreshUsersTBL();
        usersUsernameTF.setText("");
        usersPasswordTF.setText("");
        usersSaveBTN.setText("Save");
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usersRoleBG = new javax.swing.ButtonGroup();
        usersPUM = new javax.swing.JPopupMenu();
        usersEditMI = new javax.swing.JMenuItem();
        usersDeleteMI = new javax.swing.JMenuItem();
        productsPUM = new javax.swing.JPopupMenu();
        productsEditMI = new javax.swing.JMenuItem();
        productsDeleteMI = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        homeRefreshBTN = new javax.swing.JButton();
        userGreetingLBL = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        transactionsTBL = new javax.swing.JTable();
        transactionsSearchBTN = new javax.swing.JButton();
        transactionsUsersCB = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        productsSearchTF = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        productsTBL = new javax.swing.JTable();
        productsSearchBTN = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        productsNameTF = new javax.swing.JTextField();
        productsPriceTF = new javax.swing.JTextField();
        productsStockTF = new javax.swing.JTextField();
        productsSaveBTN = new javax.swing.JButton();
        productsCancelBTN = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTBL = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        usersSearchTF = new javax.swing.JTextField();
        usersSearchBTN = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        usersUsernameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usersRoleCashierRB = new javax.swing.JRadioButton();
        usersRoleAdminRB = new javax.swing.JRadioButton();
        usersSaveBTN = new javax.swing.JButton();
        usersCancelBTN = new javax.swing.JButton();
        usersPasswordTF = new javax.swing.JPasswordField();

        usersEditMI.setText("Edit");
        usersEditMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersEditMIActionPerformed(evt);
            }
        });
        usersPUM.add(usersEditMI);

        usersDeleteMI.setText("Delete");
        usersDeleteMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersDeleteMIActionPerformed(evt);
            }
        });
        usersPUM.add(usersDeleteMI);

        productsEditMI.setText("Edit");
        productsEditMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsEditMIActionPerformed(evt);
            }
        });
        productsPUM.add(productsEditMI);

        productsDeleteMI.setText("Delete");
        productsDeleteMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsDeleteMIActionPerformed(evt);
            }
        });
        productsPUM.add(productsDeleteMI);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FBE POS v1.0 - Administration");

        homeRefreshBTN.setText("Refresh");
        homeRefreshBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeRefreshBTNActionPerformed(evt);
            }
        });

        userGreetingLBL.setText("Hi, xxxx!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(userGreetingLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 813, Short.MAX_VALUE)
                .addComponent(homeRefreshBTN)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homeRefreshBTN)
                    .addComponent(userGreetingLBL))
                .addContainerGap(646, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Home", jPanel1);

        jLabel3.setText("Search by user:");

        transactionsTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Product", "Quantity", "Total Price", "User", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(transactionsTBL);

        transactionsSearchBTN.setText("Search");
        transactionsSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsSearchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 947, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transactionsUsersCB, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(transactionsSearchBTN)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(transactionsSearchBTN)
                    .addComponent(transactionsUsersCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transactions", jPanel2);

        jLabel2.setText("Search product:");

        productsTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Price", "Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                productsTBLMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productsTBLMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(productsTBL);

        productsSearchBTN.setText("Search");
        productsSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsSearchBTNActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Products Entry/Update Form"));

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel8.setText("Fill out the fields below...");

        jLabel9.setText("Name:");

        jLabel10.setText("Price:");

        jLabel11.setText("Stock:");

        productsPriceTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        productsStockTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        productsSaveBTN.setText("Save");
        productsSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsSaveBTNActionPerformed(evt);
            }
        });

        productsCancelBTN.setText("Cancel");
        productsCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productsCancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(productsSaveBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(productsCancelBTN)
                                .addGap(0, 67, Short.MAX_VALUE))
                            .addComponent(productsStockTF)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(productsNameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                            .addComponent(productsPriceTF))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(productsNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(productsPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(productsStockTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsSaveBTN)
                    .addComponent(productsCancelBTN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productsSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productsSearchBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(productsSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productsSearchBTN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Products", jPanel3);

        usersTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User ID", "Username", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTBL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usersTBLMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usersTBLMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(usersTBL);

        jLabel1.setText("Search user:");

        usersSearchBTN.setText("Search");
        usersSearchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersSearchBTNActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "User Entry/Update Form"));

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 2, 13)); // NOI18N
        jLabel4.setText("Fill out the fields below...");

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        jLabel7.setText("Role:");

        usersRoleBG.add(usersRoleCashierRB);
        usersRoleCashierRB.setText("Cashier");

        usersRoleBG.add(usersRoleAdminRB);
        usersRoleAdminRB.setText("Admin");

        usersSaveBTN.setText("Save");
        usersSaveBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersSaveBTNActionPerformed(evt);
            }
        });

        usersCancelBTN.setText("Cancel");
        usersCancelBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersCancelBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(122, 122, 122))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(usersSaveBTN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(usersCancelBTN)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usersUsernameTF)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(usersRoleCashierRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usersRoleAdminRB)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(usersPasswordTF, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersUsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usersPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(usersRoleCashierRB)
                    .addComponent(usersRoleAdminRB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usersSaveBTN)
                    .addComponent(usersCancelBTN))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(usersSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usersSearchBTN)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(usersSearchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usersSearchBTN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Users", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void transactionsSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsSearchBTNActionPerformed
        // TODO add your handling code here:
        String username = transactionsUsersCB.getSelectedItem().toString();
        //ArrayList<User> users = new ArrayList<User>();
        //users = userDAOImpl.search(username);
        //User user = users.get(0);
        //int user_id = user.getUser_id();
        
        int user_id = userDAOImpl.search(username).get(0).getUser_id();
        
        searchTransactionsTable(user_id);
    }//GEN-LAST:event_transactionsSearchBTNActionPerformed

    private void productsSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsSearchBTNActionPerformed
        // TODO add your handling code here:
        String str = productsSearchTF.getText();
        
        searchProductsTable(str);
    }//GEN-LAST:event_productsSearchBTNActionPerformed

    private void usersSearchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSearchBTNActionPerformed
        // TODO add your handling code here:
        String str = usersSearchTF.getText();
        
        DefaultTableModel model = (DefaultTableModel) usersTBL.getModel();
        model.setRowCount(0);
        
        for(User user : userDAOImpl.search(str)){
            model.addRow(new Object[]{
                user.getUser_id(), 
                user.getUsername(),
                user.getRole()
            });
        }
    }//GEN-LAST:event_usersSearchBTNActionPerformed

    private void usersCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersCancelBTNActionPerformed
        // TODO add your handling code here:
        resetUsersTab();
    }//GEN-LAST:event_usersCancelBTNActionPerformed

    private void usersSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSaveBTNActionPerformed
        // TODO add your handling code here:
        String username = usersUsernameTF.getText();
        String password = usersPasswordTF.getText();
        String role = usersRoleCashierRB.isSelected() ? "Cashier" : "Admin";
        System.out.println(role);
        
        if(username.equals("") || password.equals("") || role.equals("")){
            JOptionPane.showMessageDialog(null, 
                        "All fields are required!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            
            return;
        } 
        
        if(usersSaveBTN.getText().equals("Save")){
            int option = JOptionPane.showConfirmDialog(null, 
                    "This will save the entries currently on the form. Are you sure?", 
                    "Confirmation",
                    JOptionPane.OK_CANCEL_OPTION);

            if(option == JOptionPane.OK_OPTION){
                User user = new User(0, username, password, role);
                if(userDAOImpl.create(user) == true){
                    JOptionPane.showMessageDialog(null, 
                            "New user has been saved!", 
                            "Message", 
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "User was not saved!", 
                            "Message", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            int option = JOptionPane.showConfirmDialog(null, 
                    "This will update the entries currently on the form. Are you sure?", 
                    "Confirmation",
                    JOptionPane.OK_CANCEL_OPTION);

            if(option == JOptionPane.OK_OPTION){
                this.user.setUsername(username);
                this.user.setPassword(password);
                this.user.setRole(role);
                
                if(userDAOImpl.update(this.user) == true){
                    JOptionPane.showMessageDialog(null, 
                            "User has been updated!", 
                            "Message", 
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "User was not updated!", 
                            "Message", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        resetUsersTab();
        resetTransactionsTab();
    }//GEN-LAST:event_usersSaveBTNActionPerformed

    private void usersTBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTBLMousePressed
       //TODO add your handling code here:
       if (evt.isPopupTrigger()) { 
            int row = usersTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                usersTBL.setRowSelectionInterval(row, row); 
            }

            usersPUM.show(usersTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_usersTBLMousePressed

    private void usersEditMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersEditMIActionPerformed
        // TODO add your handling code here:
        usersSaveBTN.setText("Update");
        usersUsernameTF.setEditable(false);
        DefaultTableModel model = (DefaultTableModel) usersTBL.getModel();
        int user_id = Integer.parseInt(model.getValueAt(usersTBL.getSelectedRow(), 0).toString());
        this.user = userDAOImpl.read_one(user_id);
        
        usersUsernameTF.setText(user.getUsername());
        usersPasswordTF.setText(user.getPassword());
        if(user.getRole().equals("Cashier")){
            usersRoleCashierRB.setSelected(true);
        } else {
            usersRoleAdminRB.setSelected(true);
        }
    }//GEN-LAST:event_usersEditMIActionPerformed

    private void usersDeleteMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersDeleteMIActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) usersTBL.getModel();
        int user_id = Integer.parseInt(model.getValueAt(usersTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(userDAOImpl.delete(user_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "User was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "User was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetUsersTab();
    }//GEN-LAST:event_usersDeleteMIActionPerformed

    private void usersTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTBLMouseReleased
        // TODO add your handling code here:
         // TODO add your handling code here:
        // Use MouseRelease event for Windows OS, MousePressed is only for MAC
        // for Right-Click options
        if (evt.isPopupTrigger()) { 
            int row = usersTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                usersTBL.setRowSelectionInterval(row, row); 
            }

            usersPUM.show(usersTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_usersTBLMouseReleased

    private void productsSaveBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsSaveBTNActionPerformed
        // TODO add your handling code here:
        String name = productsNameTF.getText();
       double price = Double.parseDouble(productsPriceTF.getText());
       int stock = Integer.parseInt(productsStockTF.getText());
       
        if(name.equals("") || price == 0 || stock == 0){
            JOptionPane.showMessageDialog(null, 
                        "All fields are required!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            
            return;
        }
        
            if(productsSaveBTN.getText().equals("Save")){
                int option = JOptionPane.showConfirmDialog(null, 
                        "This will save the entries currently on the form. Are you sure?", 
                        "Confirmation",
                        JOptionPane.OK_CANCEL_OPTION);

                if(option == JOptionPane.OK_OPTION){
                    Product product = new Product(0, name, price, stock);
                    if(productDAOImpl.create(product) == true){
                        JOptionPane.showMessageDialog(null, 
                                "New product has been saved!", 
                                "Message", 
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, 
                                "Product was not saved!", 
                                "Message", 
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else{
                int option = JOptionPane.showConfirmDialog(null, 
                    "This will update the entries currently on the form. Are you sure?", 
                    "Confirmation",
                    JOptionPane.OK_CANCEL_OPTION);

            if(option == JOptionPane.OK_OPTION){
                this.product.setName(name);
                this.product.setPrice(price);
                this.product.setStock(stock);
                
                if(productDAOImpl.update(this.product.getProduct_id(), this.product) == true){
                    JOptionPane.showMessageDialog(null, 
                            "Product has been updated!", 
                            "Message", 
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Product was not updated!", 
                            "Message", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        resetProductsTab();
    }//GEN-LAST:event_productsSaveBTNActionPerformed

    private void productsCancelBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsCancelBTNActionPerformed
        // TODO add your handling code here:
        resetProductsTab();
    }//GEN-LAST:event_productsCancelBTNActionPerformed

    private void productsTBLMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTBLMousePressed
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = productsTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                productsTBL.setRowSelectionInterval(row, row); 
            }

            productsPUM.show(productsTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_productsTBLMousePressed

    private void productsTBLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTBLMouseReleased
        // TODO add your handling code here:
        if (evt.isPopupTrigger()) { 
            int row = productsTBL.rowAtPoint(evt.getPoint());
        
            if (row >= 0) {
                productsTBL.setRowSelectionInterval(row, row); 
            }

            productsPUM.show(productsTBL, evt.getX(), evt.getY()); 
        } else {
            System.out.println("Nothing happened!");
        }
    }//GEN-LAST:event_productsTBLMouseReleased

    private void productsEditMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsEditMIActionPerformed
        // TODO add your handling code here:
        productsSaveBTN.setText("Update");
        DefaultTableModel model = (DefaultTableModel) productsTBL.getModel();
        int product_id = Integer.parseInt(model.getValueAt(productsTBL.getSelectedRow(), 0).toString());
        this.product = productDAOImpl.read_one(product_id);
        
        productsNameTF.setText(product.getName());
        productsPriceTF.setText(String.format("%.2f", product.getPrice()));
        productsStockTF.setText(product.getStock() + "");
    }//GEN-LAST:event_productsEditMIActionPerformed

    private void productsDeleteMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productsDeleteMIActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) productsTBL.getModel();
        int product_id = Integer.parseInt(model.getValueAt(productsTBL.getSelectedRow(), 0).toString());
        
        int option = JOptionPane.showConfirmDialog(null, 
                "This will delete the record permanently. Are you sure?", 
                "Confirmation", 
                JOptionPane.OK_CANCEL_OPTION);
        
        if(option == JOptionPane.OK_OPTION){
            if(productDAOImpl.delete(product_id) == true){
                JOptionPane.showMessageDialog(null, 
                        "Product was deleted!", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, 
                        "Product was not deleted!", 
                        "Message", 
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        
        resetProductsTab();
    }//GEN-LAST:event_productsDeleteMIActionPerformed

    private void usersSearchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersSearchTFActionPerformed
    }//GEN-LAST:event_usersSearchTFActionPerformed

    private void transactionsUsersCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsUsersCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionsUsersCBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        refreshTables();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void homeRefreshBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeRefreshBTNActionPerformed
        // TODO add your handling code here:
        refreshTables();
    }//GEN-LAST:event_homeRefreshBTNActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton homeRefreshBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton productsCancelBTN;
    private javax.swing.JMenuItem productsDeleteMI;
    private javax.swing.JMenuItem productsEditMI;
    private javax.swing.JTextField productsNameTF;
    private javax.swing.JPopupMenu productsPUM;
    private javax.swing.JTextField productsPriceTF;
    private javax.swing.JButton productsSaveBTN;
    private javax.swing.JButton productsSearchBTN;
    private javax.swing.JTextField productsSearchTF;
    private javax.swing.JTextField productsStockTF;
    private javax.swing.JTable productsTBL;
    private javax.swing.JButton transactionsSearchBTN;
    private javax.swing.JTable transactionsTBL;
    private javax.swing.JComboBox<String> transactionsUsersCB;
    private javax.swing.JLabel userGreetingLBL;
    private javax.swing.JButton usersCancelBTN;
    private javax.swing.JMenuItem usersDeleteMI;
    private javax.swing.JMenuItem usersEditMI;
    private javax.swing.JPopupMenu usersPUM;
    private javax.swing.JPasswordField usersPasswordTF;
    private javax.swing.JRadioButton usersRoleAdminRB;
    private javax.swing.ButtonGroup usersRoleBG;
    private javax.swing.JRadioButton usersRoleCashierRB;
    private javax.swing.JButton usersSaveBTN;
    private javax.swing.JButton usersSearchBTN;
    private javax.swing.JTextField usersSearchTF;
    private javax.swing.JTable usersTBL;
    private javax.swing.JTextField usersUsernameTF;
    // End of variables declaration//GEN-END:variables
}
