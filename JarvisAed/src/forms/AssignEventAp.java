/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package forms;

import bean.Events;
import bean.PropertyEnlist;
import dao.IQueryMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DbUtil;

/**
 *
 * @author aakashsangani
 */
public class AssignEventAp extends javax.swing.JPanel {

    /**
     * Creates new form AssignPropertyAp
     */
    public String FName = null;
    ArrayList<Events> list;
    String comboSelected;
    ArrayList<String> rType;
    Events evnt;

    public AssignEventAp(String FirstName) {
        initComponents();
        FName = FirstName;
        jScrollPane1.setVisible(false);
        jButton1.setVisible(false);
    }

    public ArrayList<Events> eventsList() {
        ArrayList<Events> eventsList = new ArrayList<>();
        try {
            Connection conn = DbUtil.getConnection();

            if ("Corporate Client".equals(comboSelected)) {
                PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.SELECT_EVENTS_2);
                prep1.setString(1, "Corporate Client");
                ResultSet rs = null;
                rs = prep1.executeQuery();
                Events events;
                while (rs.next()) {
                    events = new Events(
                            rs.getString(1), rs.getString(5),
                            rs.getString(4), rs.getString(7), rs.getString(3),
                            rs.getString(14), rs.getString(15), rs.getString(6),
                            rs.getString(8), rs.getString(9), rs.getString(10),
                            rs.getString(13), rs.getString(2), rs.getString(16)
                    );
                    events.setImg_1(rs.getBytes(11));
                    eventsList.add(events);        
    //                events = new Events(rs.getString(14), rs.getString(4),
    //                        rs.getString(3), rs.getString(6), rs.getString(2),
    //                        rs.getString(13), rs.getString(15), rs.getString(5),
    //                        rs.getString(7), rs.getString(8), rs.getString(9),
    //                        rs.getString(12), rs.getString(1), rs.getString(16));
    //                events.setImg_1(rs.getBytes(10));             
                }
            }
            else{
                PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.SELECT_EVENTS_3);
                prep1.setString(1, "Personal Client");
                ResultSet rs = null;
                rs = prep1.executeQuery();
                Events events;
//                (String eventId,1
//            String eventName,2
//            String capacity,""
//            String eventType,5
//            String location,3
//            String eventStatus,9
//            String contact,""
//            String eventDescription,4
//            String fromDate,6
//            String hostedBy,""
//            String eventTiming,""
//            String eventAdmin,8
//            String propertyName,2
//            String requestType)10
                while (rs.next()) {
                    events = new Events(
                            rs.getString(1), rs.getString(2),
                            "5-10", rs.getString(5), rs.getString(3),
                            rs.getString(9), "", rs.getString(4),
                            rs.getString(6),"", "",
                            rs.getString(8), rs.getString(2), rs.getString(10)
                    );
                    events.setImg_1(rs.getBytes(7));
                    eventsList.add(events);                     
                }
            }
//            PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.SELECT_EVENTS_2);
//            prep1.setString(1, comboSelected);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return eventsList;
    }

    public void populaterequestType() {
        try ( Connection conn = DbUtil.getConnection();  PreparedStatement prep = conn.prepareStatement(IQueryMapper.FETCH_LOCATIONS);) {

            rType = new ArrayList<>();
            rType.add("--SELECT--");
            ResultSet rs = prep.executeQuery();

            while (rs.next()) {
                rType.add(rs.getString(1));
            }
            System.out.println(rType);
            DefaultComboBoxModel model = new DefaultComboBoxModel(rType.toArray());
            jComboBox1.setModel(model);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void show_events() {
        list = eventsList();
        DefaultTableModel model = (DefaultTableModel) jTableApprove1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (Events e : eventsList()) {
            row[0] = e;
//            row[0] = e.getEventName();
            row[1] = e.getCapacity();
            row[2] = e.getEventType();
            row[3] = e.getLocation();
            row[4] = e.getEventStatus();

            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableApprove1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(54, 72, 79));
        setLayout(new java.awt.GridLayout());

        jPanel1.setBackground(new java.awt.Color(54, 72, 79));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(54, 72, 79));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jPanel3.setBackground(new java.awt.Color(54, 72, 79));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setBackground(new java.awt.Color(54, 72, 79));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3), "Assign Handler", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel5.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setText("  Assign Event Approver");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createEtchedBorder()));

        jTableApprove1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Event Name", "Capacity", "Type", "Location", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableApprove1);

        jButton1.setBackground(new java.awt.Color(54, 72, 79));
        jButton1.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(242, 242, 242));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/forms/icons/add-contact.png"))); // NOI18N
        jButton1.setText("Assign to me");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(242, 242, 242));

        jLabel5.setForeground(new java.awt.Color(242, 242, 242));

        jLabel6.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REQUEST TYPE");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corporate Client", "Personal Client" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 916, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(175, 175, 175))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4);

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2);

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:

        int row = jTableApprove1.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to view");
        }
       

        evnt = (Events) (jTableApprove1.getModel().getValueAt(row, 0));
        System.out.println(evnt.getEventId() + ", " + evnt);

        //DefaultTableModel model = (DefaultTableModel) jTableApprove1.getModel();
        try ( Connection conn = DbUtil.getConnection();  PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.UPDATE_EVENT_STATUS);) {

            prep1.setString(1, "Assigned");
            prep1.setString(2, evnt.getEventId());
            prep1.executeUpdate();

            DefaultTableModel model = (DefaultTableModel) jTableApprove1.getModel();
            model.setRowCount(0);
            show_events();

            PreparedStatement prep = conn.prepareStatement(IQueryMapper.INSERT_EVENT_REVIEW);
            //PreparedStatement prep1 = conn.prepareStatement(IQueryMapper.INSERT_PROPERTY_REVIEW);

            prep.setString(1, evnt.getPropertyName());
            prep.setString(2, evnt.getLocation());
            prep.setString(3, evnt.getCapacity());
            prep.setString(4, evnt.getEventName());
            prep.setString(5, evnt.getEventDescription());
            prep.setString(6, evnt.getEventType());
            prep.setString(7, evnt.getFromDate());
            prep.setString(8, evnt.getHostedBy());
            prep.setString(9, evnt.getEventTiming());
            prep.setString(10, evnt.getContact());
            prep.setBytes(11, evnt.getImg_1());
            prep.setString(12, evnt.getEventAdmin());
            prep.setString(13, this.FName);
            prep.setString(14, evnt.getEventId());
            prep.setString(15, evnt.getEventStatus());
            prep.setString(16, evnt.getRequestType());

            prep.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        comboSelected = jComboBox1.getSelectedItem().toString();
        jScrollPane1.setVisible(true);
        jButton1.setVisible(true);
//        jLabel2.setVisible(true);
//        jLabel3.setVisible(true);
        show_events();
        
    }//GEN-LAST:event_jComboBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableApprove1;
    // End of variables declaration//GEN-END:variables
}
