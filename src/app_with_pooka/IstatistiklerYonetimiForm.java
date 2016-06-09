/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_with_pooka;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import javax.swing.table.*;

/**
 *
 * @author Kenan Savas
 */
public class IstatistiklerYonetimiForm extends javax.swing.JFrame {

    ResultSet rs;
    public static java.sql.Connection con;
    Statement statement;
    String sql;

    ArrayList<ArrayList<String>> allRecords=null;
    ArrayList<String> subRecords=null;
    
    int accountID=-1;

    /**
     * Creates new form IstatistiklerYonetimiForm
     */
    public IstatistiklerYonetimiForm(int accountID) {
        
        initComponents();
        
        this.accountID=accountID;
        
        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://db/akilli_eposta_db.mdb");
            con.setAutoCommit(false);
        }catch(Exception exp){
            exp.printStackTrace();
        }
        
        int selectedIndex=jComboBox_Istatistik_Secimi.getSelectedIndex();

        switch (selectedIndex){
            case 0:allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);break;
            case 1:allRecords=getFieldsFromTable("[istatistikler_baslik]", 4);break;
            case 2:allRecords=getFieldsFromTable("[istatistikler_ekler_kelime]", 4);break;
            case 3:allRecords=getFieldsFromTable("[istatistikler_icerik]", 4);break;
            case 4:allRecords=getFieldsFromTable("[istatistikler_kelimeler]", 3);break;
            case 5:allRecords=getFieldsFromTable("[istatistikler_kimden]", 4);break;
            case 6:allRecords=getFieldsFromTable("[istatistikler_kime]", 4);break;
            case 7:allRecords=getFieldsFromTable("[istatistikler_epostalaregitim]", 24);break;
            case 8:allRecords=getFieldsFromTable("[istatistikler_epostalartest]", 24);break;
        }
        
        String[] tableHeaderArray=null;

        switch (selectedIndex){
            case 0:tableHeaderArray=new String[]{"istatistikler_baglantilar_id","istatistikler_baglantilar_epostaid","istatistikler_baglantilar_urltipi","istatistikler_baglantilar_kelimeid","istatistikler_baglantilar_kelimefrekansi","istatistikler_baglantilar_kelimeagirlik","istatistikler_baglantilar_kelimetfidf"};break;
            case 1:tableHeaderArray=new String[]{"istatistikler_baslik_id","istatistikler_baslik_epostaid","istatistikler_baslik_kelimeid","istatistikler_baslik_kelimefrekansi","istatistikler_baslik_kelimeagirlik","istatistikler_baslik_kelimetfidf"};break;
            case 2:tableHeaderArray=new String[]{"istatistikler_ekler_kelime_id","istatistikler_ekler_kelime_epostaid","istatistikler_ekler_kelime_kelimeid","istatistikler_ekler_kelime_kelimefrekansi","istatistikler_ekler_kelime_kelimeagirlik","istatistikler_ekler_kelime_kelimetfidf"};break;
            case 3:tableHeaderArray=new String[]{"istatistikler_icerik_id","istatistikler_icerik_epostaid","istatistikler_icerik_kelimeid","istatistikler_icerik_kelimefrekansi","istatistikler_icerik_kelimeagirlik","istatistikler_icerik_kelimetfidf"};break;
            case 4:tableHeaderArray=new String[]{"istatistikler_kelimeler_id","istatistikler_kelimeler_kelimeid","istatistikler_kelimeler_kelimefrekansi","istatistikler_kelimeler_kelimeagirlik","istatistikler_kelimeler_kelimetfidf"};break;
            case 5:tableHeaderArray=new String[]{"istatistikler_kimden_id","istatistikler_kimden_epostaid","istatistikler_kimden_kelimeid","istatistikler_kimden_kelimefrekansi","istatistikler_kimden_kelimeagirlik","istatistikler_kimden_kelimetfidf"};break;
            case 6:tableHeaderArray=new String[]{"istatistikler_kime_id","istatistikler_kime_epostaid","istatistikler_kime_kelimeid","istatistikler_kime_kelimefrekansi","istatistikler_kime_kelimeagirlik","istatistikler_kime_kelimetfidf"};break;
            case 7:tableHeaderArray=new String[]{"istatistikler_id","istatistikler_dizinid","istatistikler_epostaid","istatistikler_kelimeid","istatistikler_kelimefrekansi_baglantilar","istatistikler_kelimefrekansi_baslik","istatistikler_kelimefrekansi_ekler_kelime","istatistikler_kelimefrekansi_icerik","istatistikler_kelimefrekansi_kimden","istatistikler_kelimefrekansi_kime","istatistikler_kelimebayesolasiligi_tumu","istatistikler_kelimebayesolasiligi_baglantilar","istatistikler_kelimebayesolasiligi_baslik","istatistikler_kelimebayesolasiligi_ekler_kelime","istatistikler_kelimebayesolasiligi_icerik","istatistikler_kelimebayesolasiligi_kimden","istatistikler_kelimebayesolasiligi_kime","istatistikler_kelimetfidf_tumu","istatistikler_kelimetfidf_baglantilar","istatistikler_kelimetfidf_baslik","istatistikler_kelimetfidf_ekler_kelime","istatistikler_kelimetfidf_icerik","istatistikler_kelimetfidf_kimden","istatistikler_kelimetfidf_kime"};break;
            case 8:tableHeaderArray=new String[]{"istatistikler_id","istatistikler_dizinid","istatistikler_epostaid","istatistikler_kelimeid","istatistikler_kelimefrekansi_baglantilar","istatistikler_kelimefrekansi_baslik","istatistikler_kelimefrekansi_ekler_kelime","istatistikler_kelimefrekansi_icerik","istatistikler_kelimefrekansi_kimden","istatistikler_kelimefrekansi_kime","istatistikler_kelimebayesolasiligi_tumu","istatistikler_kelimebayesolasiligi_baglantilar","istatistikler_kelimebayesolasiligi_baslik","istatistikler_kelimebayesolasiligi_ekler_kelime","istatistikler_kelimebayesolasiligi_icerik","istatistikler_kelimebayesolasiligi_kimden","istatistikler_kelimebayesolasiligi_kime","istatistikler_kelimetfidf_tumu","istatistikler_kelimetfidf_baglantilar","istatistikler_kelimetfidf_baslik","istatistikler_kelimetfidf_ekler_kelime","istatistikler_kelimetfidf_icerik","istatistikler_kelimetfidf_kimden","istatistikler_kelimetfidf_kime"};break;
        }
        
        String[][] tableRowArray=new String[allRecords.size()][]; 
        for(int i=0; i<allRecords.size(); i++){
            subRecords=allRecords.get(i);
            tableRowArray[i]=new String[subRecords.size()];
            for(int j=0; j<subRecords.size(); j++)
                tableRowArray[i][j]=subRecords.get(j);
        }
        TableModel tableModel=new DefaultTableModel(tableRowArray,tableHeaderArray);
        jTable.setModel(tableModel);

    }    
    
    /**
     * Creates new form IstatistiklerYonetimiForm
     */
    public IstatistiklerYonetimiForm() {
        
        initComponents();
        
        accountID=1;
        
        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://db/akilli_eposta_db.mdb");
            con.setAutoCommit(false);
        }catch(Exception exp){
            exp.printStackTrace();
        }
        
        int selectedIndex=jComboBox_Istatistik_Secimi.getSelectedIndex();

        switch (selectedIndex){
            case 0:allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);break;
            case 1:allRecords=getFieldsFromTable("[istatistikler_baslik]", 4);break;
            case 2:allRecords=getFieldsFromTable("[istatistikler_ekler_kelime]", 4);break;
            case 3:allRecords=getFieldsFromTable("[istatistikler_icerik]", 4);break;
            case 4:allRecords=getFieldsFromTable("[istatistikler_kelimeler]", 3);break;
            case 5:allRecords=getFieldsFromTable("[istatistikler_kimden]", 4);break;
            case 6:allRecords=getFieldsFromTable("[istatistikler_kime]", 4);break;
        }
        
        String[] tableHeaderArray=null;

        switch (selectedIndex){
            case 0:tableHeaderArray=new String[]{"istatistikler_baglantilar_id","istatistikler_baglantilar_epostaid","istatistikler_baglantilar_urltipi","istatistikler_baglantilar_kelimeid","istatistikler_baglantilar_kelimefrekansi","istatistikler_baglantilar_kelimeagirlik","istatistikler_baglantilar_kelimetfidf"};break;
            case 1:tableHeaderArray=new String[]{"istatistikler_baslik_id","istatistikler_baslik_epostaid","istatistikler_baslik_kelimeid","istatistikler_baslik_kelimefrekansi","istatistikler_baslik_kelimeagirlik","istatistikler_baslik_kelimetfidf"};break;
            case 2:tableHeaderArray=new String[]{"istatistikler_ekler_kelime_id","istatistikler_ekler_kelime_epostaid","istatistikler_ekler_kelime_kelimeid","istatistikler_ekler_kelime_kelimefrekansi","istatistikler_ekler_kelime_kelimeagirlik","istatistikler_ekler_kelime_kelimetfidf"};break;
            case 3:tableHeaderArray=new String[]{"istatistikler_icerik_id","istatistikler_icerik_epostaid","istatistikler_icerik_kelimeid","istatistikler_icerik_kelimefrekansi","istatistikler_icerik_kelimeagirlik","istatistikler_icerik_kelimetfidf"};break;
            case 4:tableHeaderArray=new String[]{"istatistikler_kelimeler_id","istatistikler_kelimeler_kelimeid","istatistikler_kelimeler_kelimefrekansi","istatistikler_kelimeler_kelimeagirlik","istatistikler_kelimeler_kelimetfidf"};break;
            case 5:tableHeaderArray=new String[]{"istatistikler_kimden_id","istatistikler_kimden_epostaid","istatistikler_kimden_kelimeid","istatistikler_kimden_kelimefrekansi","istatistikler_kimden_kelimeagirlik","istatistikler_kimden_kelimetfidf"};break;
            case 6:tableHeaderArray=new String[]{"istatistikler_kime_id","istatistikler_kime_epostaid","istatistikler_kime_kelimeid","istatistikler_kime_kelimefrekansi","istatistikler_kime_kelimeagirlik","istatistikler_kime_kelimetfidf"};break;
        }
        
        String[][] tableRowArray=new String[allRecords.size()][]; 
        for(int i=0; i<allRecords.size(); i++){
            subRecords=allRecords.get(i);
            tableRowArray[i]=new String[subRecords.size()];
            for(int j=0; j<subRecords.size(); j++)
                tableRowArray[i][j]=subRecords.get(j);
        }
        TableModel tableModel=new DefaultTableModel(tableRowArray,tableHeaderArray);
        jTable.setModel(tableModel);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jComboBox_Istatistik_Secimi = new javax.swing.JComboBox<>();
        jButton_Istatistikleri_Guncelle = new javax.swing.JButton();
        jButton_Tum_Istatistikleri_Guncelle = new javax.swing.JButton();

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablePropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        jComboBox_Istatistik_Secimi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bağlantı İstatistikleri", "Başlık İstatistikleri", "Ekler Kelime İstatistikleri", "İçerik İstatistikleri", "Kelimeler İstatistikleri", "Kimden İstatistikleri", "Kime İstatistikleri", "Eğitim Eposta Analiz İstatistikleri", "Test Eposta Analiz İstatistikleri" }));
        jComboBox_Istatistik_Secimi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Istatistik_SecimiActionPerformed(evt);
            }
        });

        jButton_Istatistikleri_Guncelle.setText("TFIDF ve Olasilik Degerlerini Bul");
        jButton_Istatistikleri_Guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Istatistikleri_GuncelleActionPerformed(evt);
            }
        });

        jButton_Tum_Istatistikleri_Guncelle.setText("Tüm İstatistikleri Güncelle");
        jButton_Tum_Istatistikleri_Guncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tum_Istatistikleri_GuncelleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox_Istatistik_Secimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Istatistikleri_Guncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton_Tum_Istatistikleri_Guncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_Istatistik_Secimi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Istatistikleri_Guncelle)
                    .addComponent(jButton_Tum_Istatistikleri_Guncelle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablePropertyChange
        int tablePosition;
        tablePosition=jTable.getSelectedRow();
        System.out.println("tablePosition: "+tablePosition);
    }//GEN-LAST:event_jTablePropertyChange

    private void jComboBox_Istatistik_SecimiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Istatistik_SecimiActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
    
        int selectedIndex=jComboBox_Istatistik_Secimi.getSelectedIndex();
        
        switch (selectedIndex){
            case 0:allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);break;
            case 1:allRecords=getFieldsFromTable("[istatistikler_baslik]", 4);break;
            case 2:allRecords=getFieldsFromTable("[istatistikler_ekler_kelime]", 4);break;
            case 3:allRecords=getFieldsFromTable("[istatistikler_icerik]", 4);break;
            case 4:allRecords=getFieldsFromTable("[istatistikler_kelimeler]", 3);break;
            case 5:allRecords=getFieldsFromTable("[istatistikler_kimden]", 4);break;
            case 6:allRecords=getFieldsFromTable("[istatistikler_kime]", 4);break;
            case 7:allRecords=getFieldsFromTable("[istatistikler_epostalaregitim]", 24);break;
            case 8:allRecords=getFieldsFromTable("[istatistikler_epostalartest]", 24);break;
        }
        
        String[] tableHeaderArray=null;

        switch (selectedIndex){
            case 0:tableHeaderArray=new String[]{"istatistikler_baglantilar_id","istatistikler_baglantilar_epostaid","istatistikler_baglantilar_urltipi","istatistikler_baglantilar_kelimeid","istatistikler_baglantilar_kelimefrekansi","istatistikler_baglantilar_kelimeagirlik","istatistikler_baglantilar_kelimetfidf"};break;
            case 1:tableHeaderArray=new String[]{"istatistikler_baslik_id","istatistikler_baslik_epostaid","istatistikler_baslik_kelimeid","istatistikler_baslik_kelimefrekansi","istatistikler_baslik_kelimeagirlik","istatistikler_baslik_kelimetfidf"};break;
            case 2:tableHeaderArray=new String[]{"istatistikler_ekler_kelime_id","istatistikler_ekler_kelime_epostaid","istatistikler_ekler_kelime_kelimeid","istatistikler_ekler_kelime_kelimefrekansi","istatistikler_ekler_kelime_kelimeagirlik","istatistikler_ekler_kelime_kelimetfidf"};break;
            case 3:tableHeaderArray=new String[]{"istatistikler_icerik_id","istatistikler_icerik_epostaid","istatistikler_icerik_kelimeid","istatistikler_icerik_kelimefrekansi","istatistikler_icerik_kelimeagirlik","istatistikler_icerik_kelimetfidf"};break;
            case 4:tableHeaderArray=new String[]{"istatistikler_kelimeler_id","istatistikler_kelimeler_kelimeid","istatistikler_kelimeler_kelimefrekansi","istatistikler_kelimeler_kelimeagirlik","istatistikler_kelimeler_kelimetfidf"};break;
            case 5:tableHeaderArray=new String[]{"istatistikler_kimden_id","istatistikler_kimden_epostaid","istatistikler_kimden_kelimeid","istatistikler_kimden_kelimefrekansi","istatistikler_kimden_kelimeagirlik","istatistikler_kimden_kelimetfidf"};break;
            case 6:tableHeaderArray=new String[]{"istatistikler_kime_id","istatistikler_kime_epostaid","istatistikler_kime_kelimeid","istatistikler_kime_kelimefrekansi","istatistikler_kime_kelimeagirlik","istatistikler_kime_kelimetfidf"};break;
            case 7:tableHeaderArray=new String[]{"istatistikler_id","istatistikler_dizinid","istatistikler_epostaid","istatistikler_kelimeid","istatistikler_kelimefrekansi_baglantilar","istatistikler_kelimefrekansi_baslik","istatistikler_kelimefrekansi_ekler_kelime","istatistikler_kelimefrekansi_icerik","istatistikler_kelimefrekansi_kimden","istatistikler_kelimefrekansi_kime","istatistikler_kelimebayesolasiligi_tumu","istatistikler_kelimebayesolasiligi_baglantilar","istatistikler_kelimebayesolasiligi_baslik","istatistikler_kelimebayesolasiligi_ekler_kelime","istatistikler_kelimebayesolasiligi_icerik","istatistikler_kelimebayesolasiligi_kimden","istatistikler_kelimebayesolasiligi_kime","istatistikler_kelimetfidf_tumu","istatistikler_kelimetfidf_baglantilar","istatistikler_kelimetfidf_baslik","istatistikler_kelimetfidf_ekler_kelime","istatistikler_kelimetfidf_icerik","istatistikler_kelimetfidf_kimden","istatistikler_kelimetfidf_kime"};break;
            case 8:tableHeaderArray=new String[]{"istatistikler_id","istatistikler_dizinid","istatistikler_epostaid","istatistikler_kelimeid","istatistikler_kelimefrekansi_baglantilar","istatistikler_kelimefrekansi_baslik","istatistikler_kelimefrekansi_ekler_kelime","istatistikler_kelimefrekansi_icerik","istatistikler_kelimefrekansi_kimden","istatistikler_kelimefrekansi_kime","istatistikler_kelimebayesolasiligi_tumu","istatistikler_kelimebayesolasiligi_baglantilar","istatistikler_kelimebayesolasiligi_baslik","istatistikler_kelimebayesolasiligi_ekler_kelime","istatistikler_kelimebayesolasiligi_icerik","istatistikler_kelimebayesolasiligi_kimden","istatistikler_kelimebayesolasiligi_kime","istatistikler_kelimetfidf_tumu","istatistikler_kelimetfidf_baglantilar","istatistikler_kelimetfidf_baslik","istatistikler_kelimetfidf_ekler_kelime","istatistikler_kelimetfidf_icerik","istatistikler_kelimetfidf_kimden","istatistikler_kelimetfidf_kime"};break;
        }
        
        if (allRecords!=null){
            String[][] tableRowArray=new String[allRecords.size()][]; 
            for(int i=0; i<allRecords.size(); i++){
                subRecords=allRecords.get(i);
                tableRowArray[i]=new String[subRecords.size()];
                for(int j=0; j<subRecords.size(); j++)
                    tableRowArray[i][j]=subRecords.get(j);
            }
            TableModel tableModel=new DefaultTableModel(tableRowArray,tableHeaderArray);
            jTable.setModel(tableModel);
        }
    }//GEN-LAST:event_jComboBox_Istatistik_SecimiActionPerformed

    private void jButton_Istatistikleri_GuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Istatistikleri_GuncelleActionPerformed
        double egitimTumVeriOrani=0.8;
        //double testTumVeriOrani=1-egitimTumVeriOrani; 
        int epostaID=-1;
        String sql=new String("");
        ArrayList<String> subItem=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecordsAllMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsEducationMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsTestMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsNormalMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsSpamMails=new ArrayList<ArrayList<String>>();
        
        System.out.println("this.accountID: "+this.accountID);
        
        HashMap<Integer,String> categoryMap=new HashMap<Integer,String>();
        allRecords=getFieldsFromTable("[hesapdizinleri]", 3);
        int hesapID;
        System.out.println("allRecords: "+allRecords);
        for(ArrayList<String> item:allRecords){
            hesapID=Integer.valueOf(item.get(1));
            if (hesapID==this.accountID)
                categoryMap.put(Integer.valueOf(item.get(0)), item.get(2));
        }
        System.out.println("categoryMap.size(): "+categoryMap.size());
        allRecordsAllMails=getFieldsFromTable("[epostalar]", 13);
        CategorizedEmails [] categorizedAllMails;
        CategorizedEmails [] categorizedEducationMails;
        CategorizedEmails [] categorizedTestMails;
        categorizedAllMails = new CategorizedEmails[categoryMap.size()+1];
        categorizedEducationMails = new CategorizedEmails[categoryMap.size()+1];
        categorizedTestMails = new CategorizedEmails[categoryMap.size()+1];
        /*for (int i=0; i<categoryMap.size(); i++){
            categorizedAllMails[i]=new CategorizedEmails();
        }*/
        int [] eachCategoryTotalMailCount=new int[categoryMap.size()+1];
        for(int i=0; i<(categoryMap.size()+1); i++){
            categorizedAllMails[i]=new CategorizedEmails();
            categorizedEducationMails[i]=new CategorizedEmails();
            categorizedTestMails[i]=new CategorizedEmails();
        }
        int categoryID;
        for(ArrayList<String> item:allRecordsAllMails){
            categoryID=Integer.valueOf(item.get(3));
            eachCategoryTotalMailCount[categoryID]=eachCategoryTotalMailCount[categoryID]+1;
            System.out.println("item.size(): "+item.size());
            System.out.println("categoryID: "+categoryID);
            System.out.println("categorizedAllMails["+categoryID+"].size() "+categorizedAllMails[categoryID].size());
            categorizedAllMails[categoryID].add(item);
            if (item.get(12).equals("1")) //if email is a spam mail
               allRecordsSpamMails.add(item);
            else
               allRecordsNormalMails.add(item);
        }
        
        for (int i=0; i<categorizedAllMails.length; i++){
            Iterator<ArrayList<String>> iteratorOfCategorizedAllMails=categorizedAllMails[i].iterator();
            ArrayList<String> item=null;
            int mailCount=0;
            while(iteratorOfCategorizedAllMails.hasNext()){
                mailCount++;
                item=iteratorOfCategorizedAllMails.next();
                if (mailCount<=eachCategoryTotalMailCount[i]*egitimTumVeriOrani)
                   categorizedEducationMails[i].add(item);
                else
                   categorizedTestMails[i].add(item);
            }
        }

        int wordID;
        int wordFrequency; // to calculate total word count
        int vocabularyFrequency; // to calculate total email count
        String tableName;
        //HashMap<Integer, Integer> wordTotalFrequencyMap=new HashMap<Integer, Integer>();
        //HashMap<Integer, Integer> vocabularyTotalFrequencyMap=new HashMap<Integer, Integer>();
        CategorizedMap [] wordTotalFrequencyCategorizedMap;
        CategorizedMap [] vocabularyTotalFrequencyCategorizedMap;
        wordTotalFrequencyCategorizedMap=new CategorizedMap[categoryMap.size()+1];
        vocabularyTotalFrequencyCategorizedMap=new CategorizedMap[categoryMap.size()+1];
        CategorizedWordFrequency wordFrequencyForEachWord;
        HashMap<Integer, CategorizedWordFrequency> wordFrequencyForEachWordMap=new HashMap<Integer, CategorizedWordFrequency>();
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i]=new CategorizedMap();
            vocabularyTotalFrequencyCategorizedMap[i]=new CategorizedMap();
        }

        double wordFrequencyOfBaglantilar, wordFrequencyOfBaslik;
        double wordFrequencyOfEklerKelime, wordFrequencyOfIcerik;
        double wordFrequencyOfKimden, wordFrequencyOfKime;
        double ilgiliKategoridekiToplamDocSayisi = 0;
        double ilgiliKategoridekiKelimeninOlduguDocSayisi = 0;
        double wordTFIDFOfTotal, wordTFOfTotal, wordIDFOfTotal;
        double wordTFIDFOfBaglantilar, wordTFOfBaglantilar, wordIDFOfBaglantilar;
        double wordTFIDFOfBaslik, wordTFOfBaslik, wordIDFOfBaslik;
        double wordTFIDFOfEklerKelime, wordTFOfEklerKelime, wordIDFOfEklerKelime;
        double wordTFIDFOfIcerik, wordTFOfIcerik, wordIDFOfIcerik;
        double wordTFIDFOfKimden, wordTFOfKimden, wordIDFOfKimden;
        double wordTFIDFOfKime, wordTFOfKime, wordIDFOfKime;
        double ilgiliKategoridekiKelimeninToplamSayisi = 0;
        double ilgiliKategoridekiToplamKelimeSayisi = 0;
        double ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi = 0;
        double wordBayesianProbabilityOfTotal;
        double wordBayesianProbabilityOfBaglantilar;
        double wordBayesianProbabilityOfBaslik;
        double wordBayesianProbabilityOfEklerKelime;
        double wordBayesianProbabilityOfIcerik;
        double wordBayesianProbabilityOfKimden;
        double wordBayesianProbabilityOfKime;

        ArrayList<String> item=null;

        ArrayList<ArrayList<String>> listOfKelimeninOlduguDocSayisi;
        ArrayList<ArrayList<String>> listOfKelimeninHerKategoridekiToplamSayisi;

        Iterator<ArrayList<String>> iteratorOfAllRecords;

        ArrayList<ArrayList<String>> listOfKategoridekiToplamDokumanSayisi;
        ArrayList<ArrayList<String>> listOfKategoridekiToplamKelimeSayisi;
        ArrayList<ArrayList<String>> listOfKategoridekiToplamKelimeCesitVocabularySayisi;

        tableName=new String("[istatistikler_epostalaregitim]");

        sql = "UPDATE "+tableName+" SET [istatistikler_kelimebayesolasiligi_tumu]="+0+", [istatistikler_kelimebayesolasiligi_baglantilar]="+0+", [istatistikler_kelimebayesolasiligi_baslik]="+0+", [istatistikler_kelimebayesolasiligi_ekler_kelime]="+0+", [istatistikler_kelimebayesolasiligi_icerik]="+0+", [istatistikler_kelimebayesolasiligi_kimden]="+0+", [istatistikler_kelimebayesolasiligi_kime]="+0+", [istatistikler_kelimetfidf_tumu]="+0+", [istatistikler_kelimetfidf_baglantilar]="+0+", [istatistikler_kelimetfidf_baslik]="+0+", [istatistikler_kelimetfidf_ekler_kelime]="+0+", [istatistikler_kelimetfidf_icerik]="+0+", [istatistikler_kelimetfidf_kimden]="+0+", [istatistikler_kelimetfidf_kime]="+0+";";
        System.out.println("sql: "+sql);
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        
        sql="SELECT [CategoryID], COUNT([EmailID]) AS [DocCount] \n" +
        "FROM (SELECT [istatistikler_dizinid] AS [CategoryID], [istatistikler_epostaid] AS [EmailID], COUNT([istatistikler_epostaid]) \n" +
        "FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid], [istatistikler_epostaid]) \n" +
        "GROUP BY [CategoryID];";
        listOfKategoridekiToplamDokumanSayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamDokumanSayisi=getFieldsFromSelectSQL(sql, 2);
        
        sql="SELECT DISTINCT [istatistikler_dizinid], COUNT([istatistikler_kelimeid]) AS [WordFrequency] \n" +
        "FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid];";
        listOfKategoridekiToplamKelimeSayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamKelimeSayisi=getFieldsFromSelectSQL(sql, 2);
        
        sql="SELECT [CategoryID], COUNT([KelimeID]) AS [VocabularyFrequency] \n" +
        "FROM (SELECT [istatistikler_dizinid] AS [CategoryID], [istatistikler_kelimeid] AS [KelimeID], \n" +
        "COUNT([istatistikler_kelimeid]) FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid]) \n" +
        "GROUP BY [CategoryID];";
        listOfKategoridekiToplamKelimeCesitVocabularySayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamKelimeCesitVocabularySayisi=getFieldsFromSelectSQL(sql, 2);

        allRecords=getFieldsFromTable(tableName, 10);
        Iterator<ArrayList<String>> iteratorOfEpostalarEgitim=allRecords.iterator();
        while(iteratorOfEpostalarEgitim.hasNext()){
            item=iteratorOfEpostalarEgitim.next();
            System.out.println("item: "+item);
            categoryID=Integer.valueOf(item.get(1));
            epostaID=Integer.valueOf(item.get(2));
            wordID=Integer.valueOf(item.get(3));
            if (item.get(4)!=null)
                wordFrequencyOfBaglantilar=Integer.valueOf(item.get(4));
            else
                wordFrequencyOfBaglantilar=0;
            if (item.get(5)!=null)
                wordFrequencyOfBaslik=Integer.valueOf(item.get(5));
            else
                wordFrequencyOfBaslik=0;
            if (item.get(6)!=null)
                wordFrequencyOfEklerKelime=Integer.valueOf(item.get(6));
            else
                wordFrequencyOfEklerKelime=0;
            if (item.get(7)!=null)
                wordFrequencyOfIcerik=Integer.valueOf(item.get(7));
            else
                wordFrequencyOfIcerik=0;
            if (item.get(8)!=null)
                wordFrequencyOfKimden=Integer.valueOf(item.get(8));
            else
                wordFrequencyOfKimden=0;
            if (item.get(9)!=null)
                wordFrequencyOfKime=Integer.valueOf(item.get(9));
            else
                wordFrequencyOfKime=0;

            iteratorOfAllRecords=listOfKategoridekiToplamDokumanSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamDocSayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            iteratorOfAllRecords=listOfKategoridekiToplamKelimeSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamKelimeSayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            iteratorOfAllRecords=listOfKategoridekiToplamKelimeCesitVocabularySayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            sql="SELECT [istatistikler_dizinid], [istatistikler_kelimeid], \n" +
            "COUNT([istatistikler_epostaid]) AS [DocCount] \n" +
            "FROM "+tableName+" \n" +
            "WHERE [istatistikler_kelimeid]="+wordID+" \n" +
            "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid];";
            listOfKelimeninOlduguDocSayisi=new ArrayList<ArrayList<String>>();
            listOfKelimeninOlduguDocSayisi=getFieldsFromSelectSQL(sql, 3);
            iteratorOfAllRecords=listOfKelimeninOlduguDocSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiKelimeninOlduguDocSayisi=Integer.valueOf(item.get(2));
                    break;
                }                    
            }

            sql="SELECT [istatistikler_dizinid], [istatistikler_kelimeid], \n" +
            "COUNT([istatistikler_kelimeid]) AS [WordFrequency] \n" +
            "FROM "+tableName+" WHERE [istatistikler_kelimeid]="+wordID+" \n" +
            "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid];";
            listOfKelimeninHerKategoridekiToplamSayisi=new ArrayList<ArrayList<String>>();
            listOfKelimeninHerKategoridekiToplamSayisi=getFieldsFromSelectSQL(sql, 3);
            iteratorOfAllRecords=listOfKelimeninHerKategoridekiToplamSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiKelimeninToplamSayisi=Integer.valueOf(item.get(2));
                    break;
                }                    
            }
            
            wordTFOfTotal=ilgiliKategoridekiKelimeninToplamSayisi;
            wordIDFOfTotal=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfTotal=wordTFOfTotal*wordIDFOfTotal;
            
            wordTFOfBaglantilar=wordFrequencyOfBaglantilar;
            wordIDFOfBaglantilar=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfBaglantilar=wordTFOfBaglantilar*wordIDFOfBaglantilar;
            
            wordTFOfBaslik=wordFrequencyOfBaslik;
            wordIDFOfBaslik=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfBaslik=wordTFOfBaslik*wordIDFOfBaslik;

            wordTFOfEklerKelime=wordFrequencyOfEklerKelime;
            wordIDFOfEklerKelime=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfEklerKelime=wordTFOfEklerKelime*wordIDFOfEklerKelime;

            wordTFOfIcerik=wordFrequencyOfIcerik;
            wordIDFOfIcerik=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfIcerik=wordTFOfIcerik*wordIDFOfIcerik;

            wordTFOfKimden=wordFrequencyOfKimden;
            wordIDFOfKimden=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfKimden=wordTFOfKimden*wordIDFOfKimden;

            wordTFOfKime=wordFrequencyOfKime;
            wordIDFOfKime=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfKime=wordTFOfKime*wordIDFOfKime;
            
            wordBayesianProbabilityOfTotal=(ilgiliKategoridekiKelimeninToplamSayisi+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfBaglantilar=(wordFrequencyOfBaglantilar+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfBaslik=(wordFrequencyOfBaslik+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfEklerKelime=(wordFrequencyOfEklerKelime+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfIcerik=(wordFrequencyOfIcerik+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfKimden=(wordFrequencyOfKimden+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfKime=(wordFrequencyOfKime+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
                                
            sql = "UPDATE "+tableName+" SET [istatistikler_kelimebayesolasiligi_tumu]="+wordBayesianProbabilityOfTotal+", [istatistikler_kelimebayesolasiligi_baglantilar]="+wordBayesianProbabilityOfBaglantilar+", [istatistikler_kelimebayesolasiligi_baslik]="+wordBayesianProbabilityOfBaslik+", [istatistikler_kelimebayesolasiligi_ekler_kelime]="+wordBayesianProbabilityOfEklerKelime+", [istatistikler_kelimebayesolasiligi_icerik]="+wordBayesianProbabilityOfIcerik+", [istatistikler_kelimebayesolasiligi_kimden]="+wordBayesianProbabilityOfKimden+", [istatistikler_kelimebayesolasiligi_kime]="+wordBayesianProbabilityOfKime+", [istatistikler_kelimetfidf_tumu]="+wordTFIDFOfTotal+", [istatistikler_kelimetfidf_baglantilar]="+wordTFIDFOfBaglantilar+", [istatistikler_kelimetfidf_baslik]="+wordTFIDFOfBaslik+", [istatistikler_kelimetfidf_ekler_kelime]="+wordTFIDFOfEklerKelime+", [istatistikler_kelimetfidf_icerik]="+wordTFIDFOfIcerik+", [istatistikler_kelimetfidf_kimden]="+wordTFIDFOfKimden+", [istatistikler_kelimetfidf_kime]="+wordTFIDFOfKime+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
            //sql=sql.replace('.', ',');
            System.out.println("sql: "+sql);
            executeInsertUpdateDeleteSQL(sql);
            System.out.println(sql+" query has been executed.");


        }
        
        tableName=new String("[istatistikler_epostalartest]");

        sql = "UPDATE "+tableName+" SET [istatistikler_kelimebayesolasiligi_tumu]="+0+", [istatistikler_kelimebayesolasiligi_baglantilar]="+0+", [istatistikler_kelimebayesolasiligi_baslik]="+0+", [istatistikler_kelimebayesolasiligi_ekler_kelime]="+0+", [istatistikler_kelimebayesolasiligi_icerik]="+0+", [istatistikler_kelimebayesolasiligi_kimden]="+0+", [istatistikler_kelimebayesolasiligi_kime]="+0+", [istatistikler_kelimetfidf_tumu]="+0+", [istatistikler_kelimetfidf_baglantilar]="+0+", [istatistikler_kelimetfidf_baslik]="+0+", [istatistikler_kelimetfidf_ekler_kelime]="+0+", [istatistikler_kelimetfidf_icerik]="+0+", [istatistikler_kelimetfidf_kimden]="+0+", [istatistikler_kelimetfidf_kime]="+0+";";
        System.out.println("sql: "+sql);
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        
        sql="SELECT [CategoryID], COUNT([EmailID]) AS [DocCount] \n" +
        "FROM (SELECT [istatistikler_dizinid] AS [CategoryID], [istatistikler_epostaid] AS [EmailID], COUNT([istatistikler_epostaid]) \n" +
        "FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid], [istatistikler_epostaid]) \n" +
        "GROUP BY [CategoryID];";
        listOfKategoridekiToplamDokumanSayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamDokumanSayisi=getFieldsFromSelectSQL(sql, 2);
        
        sql="SELECT DISTINCT [istatistikler_dizinid], COUNT([istatistikler_kelimeid]) AS [WordFrequency] \n" +
        "FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid];";
        listOfKategoridekiToplamKelimeSayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamKelimeSayisi=getFieldsFromSelectSQL(sql, 2);
        
        sql="SELECT [CategoryID], COUNT([KelimeID]) AS [VocabularyFrequency] \n" +
        "FROM (SELECT [istatistikler_dizinid] AS [CategoryID], [istatistikler_kelimeid] AS [KelimeID], \n" +
        "COUNT([istatistikler_kelimeid]) FROM "+tableName+" \n" +
        "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid]) \n" +
        "GROUP BY [CategoryID];";
        listOfKategoridekiToplamKelimeCesitVocabularySayisi=new ArrayList<ArrayList<String>>();
        listOfKategoridekiToplamKelimeCesitVocabularySayisi=getFieldsFromSelectSQL(sql, 2);

        allRecords=getFieldsFromTable(tableName, 10);
        Iterator<ArrayList<String>> iteratorOfEpostalarTest=allRecords.iterator();
        while(iteratorOfEpostalarTest.hasNext()){
            item=iteratorOfEpostalarTest.next();
            System.out.println("item: "+item);
            categoryID=Integer.valueOf(item.get(1));
            epostaID=Integer.valueOf(item.get(2));
            wordID=Integer.valueOf(item.get(3));
            if (item.get(4)!=null)
                wordFrequencyOfBaglantilar=Integer.valueOf(item.get(4));
            else
                wordFrequencyOfBaglantilar=0;
            if (item.get(5)!=null)
                wordFrequencyOfBaslik=Integer.valueOf(item.get(5));
            else
                wordFrequencyOfBaslik=0;
            if (item.get(6)!=null)
                wordFrequencyOfEklerKelime=Integer.valueOf(item.get(6));
            else
                wordFrequencyOfEklerKelime=0;
            if (item.get(7)!=null)
                wordFrequencyOfIcerik=Integer.valueOf(item.get(7));
            else
                wordFrequencyOfIcerik=0;
            if (item.get(8)!=null)
                wordFrequencyOfKimden=Integer.valueOf(item.get(8));
            else
                wordFrequencyOfKimden=0;
            if (item.get(9)!=null)
                wordFrequencyOfKime=Integer.valueOf(item.get(9));
            else
                wordFrequencyOfKime=0;

            iteratorOfAllRecords=listOfKategoridekiToplamDokumanSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamDocSayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            iteratorOfAllRecords=listOfKategoridekiToplamKelimeSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamKelimeSayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            iteratorOfAllRecords=listOfKategoridekiToplamKelimeCesitVocabularySayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi=Integer.valueOf(item.get(1));
                    break;
                }                    
            }
            
            sql="SELECT [istatistikler_dizinid], [istatistikler_kelimeid], \n" +
            "COUNT([istatistikler_epostaid]) AS [DocCount] \n" +
            "FROM "+tableName+" \n" +
            "WHERE [istatistikler_kelimeid]="+wordID+" \n" +
            "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid];";
            listOfKelimeninOlduguDocSayisi=new ArrayList<ArrayList<String>>();
            listOfKelimeninOlduguDocSayisi=getFieldsFromSelectSQL(sql, 3);
            iteratorOfAllRecords=listOfKelimeninOlduguDocSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiKelimeninOlduguDocSayisi=Integer.valueOf(item.get(2));
                    break;
                }                    
            }

            sql="SELECT [istatistikler_dizinid], [istatistikler_kelimeid], \n" +
            "COUNT([istatistikler_kelimeid]) AS [WordFrequency] \n" +
            "FROM "+tableName+" WHERE [istatistikler_kelimeid]="+wordID+" \n" +
            "GROUP BY [istatistikler_dizinid], [istatistikler_kelimeid];";
            listOfKelimeninHerKategoridekiToplamSayisi=new ArrayList<ArrayList<String>>();
            listOfKelimeninHerKategoridekiToplamSayisi=getFieldsFromSelectSQL(sql, 3);
            iteratorOfAllRecords=listOfKelimeninHerKategoridekiToplamSayisi.iterator();
            while(iteratorOfAllRecords.hasNext()){
                item=iteratorOfAllRecords.next();
                int tempCategoryID=Integer.valueOf(item.get(0));
                if (tempCategoryID==categoryID){
                    ilgiliKategoridekiKelimeninToplamSayisi=Integer.valueOf(item.get(2));
                    break;
                }                    
            }
            
            wordTFOfTotal=ilgiliKategoridekiKelimeninToplamSayisi;
            wordIDFOfTotal=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfTotal=wordTFOfTotal*wordIDFOfTotal;
            
            wordTFOfBaglantilar=wordFrequencyOfBaglantilar;
            wordIDFOfBaglantilar=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfBaglantilar=wordTFOfBaglantilar*wordIDFOfBaglantilar;
            
            wordTFOfBaslik=wordFrequencyOfBaslik;
            wordIDFOfBaslik=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfBaslik=wordTFOfBaslik*wordIDFOfBaslik;

            wordTFOfEklerKelime=wordFrequencyOfEklerKelime;
            wordIDFOfEklerKelime=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfEklerKelime=wordTFOfEklerKelime*wordIDFOfEklerKelime;

            wordTFOfIcerik=wordFrequencyOfIcerik;
            wordIDFOfIcerik=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfIcerik=wordTFOfIcerik*wordIDFOfIcerik;

            wordTFOfKimden=wordFrequencyOfKimden;
            wordIDFOfKimden=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfKimden=wordTFOfKimden*wordIDFOfKimden;

            wordTFOfKime=wordFrequencyOfKime;
            wordIDFOfKime=Math.log(ilgiliKategoridekiToplamDocSayisi/ilgiliKategoridekiKelimeninOlduguDocSayisi);
            wordTFIDFOfKime=wordTFOfKime*wordIDFOfKime;
            
            wordBayesianProbabilityOfTotal=(ilgiliKategoridekiKelimeninToplamSayisi+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfBaglantilar=(wordFrequencyOfBaglantilar+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfBaslik=(wordFrequencyOfBaslik+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfEklerKelime=(wordFrequencyOfEklerKelime+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfIcerik=(wordFrequencyOfIcerik+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfKimden=(wordFrequencyOfKimden+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
            wordBayesianProbabilityOfKime=(wordFrequencyOfKime+1)/(ilgiliKategoridekiToplamKelimeSayisi+ilgiliKategoridekiToplamKelimeCesidiVocabularySayisi);
                                
            sql = "UPDATE "+tableName+" SET [istatistikler_kelimebayesolasiligi_tumu]="+wordBayesianProbabilityOfTotal+", [istatistikler_kelimebayesolasiligi_baglantilar]="+wordBayesianProbabilityOfBaglantilar+", [istatistikler_kelimebayesolasiligi_baslik]="+wordBayesianProbabilityOfBaslik+", [istatistikler_kelimebayesolasiligi_ekler_kelime]="+wordBayesianProbabilityOfEklerKelime+", [istatistikler_kelimebayesolasiligi_icerik]="+wordBayesianProbabilityOfIcerik+", [istatistikler_kelimebayesolasiligi_kimden]="+wordBayesianProbabilityOfKimden+", [istatistikler_kelimebayesolasiligi_kime]="+wordBayesianProbabilityOfKime+", [istatistikler_kelimetfidf_tumu]="+wordTFIDFOfTotal+", [istatistikler_kelimetfidf_baglantilar]="+wordTFIDFOfBaglantilar+", [istatistikler_kelimetfidf_baslik]="+wordTFIDFOfBaslik+", [istatistikler_kelimetfidf_ekler_kelime]="+wordTFIDFOfEklerKelime+", [istatistikler_kelimetfidf_icerik]="+wordTFIDFOfIcerik+", [istatistikler_kelimetfidf_kimden]="+wordTFIDFOfKimden+", [istatistikler_kelimetfidf_kime]="+wordTFIDFOfKime+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
            //sql=sql.replace('.', ',');
            System.out.println("sql: "+sql);
            executeInsertUpdateDeleteSQL(sql);
            System.out.println(sql+" query has been executed.");


        }

    }//GEN-LAST:event_jButton_Istatistikleri_GuncelleActionPerformed

    /**
     * Bu sınıfın olusturulma sebebi dizi yapısında her bir kategoriye 
     * (yani diziye) ait olan epostaların ayrı dizinler icin ayrı dizi indeksinde 
     * tutulmasını saglamak icin kullanılmıstır. 
     */
    public class CategorizedEmails{
        private int categoryID=-1;
        
        private ArrayList<ArrayList<String>> dataList=null;

        /**
         * no parameter constructor
         */
        public CategorizedEmails() {
            dataList=new ArrayList<ArrayList<String>>();
        }

        /**
         * categoryID verilerek kullanılan constructor
         * @param categoryID 
         */
        public CategorizedEmails(int categoryID) {
            this.categoryID=categoryID;
            dataList=new ArrayList<ArrayList<String>>();
        }

        /**
         * CategoryID yi geri dondurur.
         * @return int tipinde geri donus degeri
         */
        public int getCategoryID() {
            return categoryID;
        }

        /**
         * getCategoryID yi set eder.
         * @param categoryID int tipinde parametre degeri
         */
        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
        }

        /**
         * data listesinin boyutunu geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int size() {
            return dataList.size();
        }
       
        /**
         * index nolu kayda ait verileri geri dondurur
         * @param index int tipinde parametre degeri
         * @return ArrayList<String> tipinde geri donus degeri
         */
        public ArrayList<String> get(int index) {
            return dataList.get(index);
        }
       
        /**
         * liste tipinde bir kaydi bu sınıf nesnesinin veri listesine ekler. 
         * @param data ArrayList<String> tipinde parametre degeri
         * @return boolean tipinde geri donus degeri, ekleme dusgun ise true doner
         */
        public boolean add(ArrayList<String> data) {
            dataList.add(data);
            return true;
        }
        
        /**
         * sınıfa ait nesnenin veri listesinde ilgili nesne var ise true aksi halde false degeri geri doner.
         * @param o Object tipinde parametre degeri
         * @return boolean tipinde geri donus degeri
         */
        public boolean contains(Object o) {
            return dataList.contains(o);
        }
        
        /**
         * veri listesinin index nolu alanınabir veriyi set eder.
         * @param index int tipinde parametre degeri
         * @param data ArrayList<String> tipinde parametre degeri
         * @return boolean tipinde geri donus degeri
         */
        public boolean set(int index, ArrayList<String> data) {
            dataList.set(index, data);
            return true;
        }
        
        /**
         * bu sınıfa ait nesnenin veri listesi icn bir iterator dondurur
         * @return Iterator<ArrayList<String>> tipinde geri donus degeri
         */
        public Iterator<ArrayList<String>> iterator(){
            return dataList.iterator();
        }

        /**
         * String tipinde nesne icerigini geri dondurur 
         * @return String tipinde geri donus degeri
         */
        @Override
        public String toString() {
            return "CategorizedEmails{" + "categoryID=" + categoryID + ", dataList=" + dataList + '}';
        }
        
    }
    
    /**
     * map veri listesini Integer, Integer cifti ile tutmak icin kullanilir.
     */
    public class CategorizedMap{
        private int categoryID=-1;
        
        private HashMap<Integer, Integer> dataList=null;

        /**
         * no parameter constructor veri listesini hafizada ilk duruma hazirlar
         */
        public CategorizedMap() {
            dataList=new HashMap<Integer, Integer>();
        }

        /**
         * categoryID degerinin set ederek calisan constructor veri listesini hafizada ilk duruma hazirlar 
         * @param categoryID 
         */
        public CategorizedMap(int categoryID) {
            this.categoryID=categoryID;
            dataList=new HashMap<Integer, Integer>();
        }

        /**
         * categoryID ozelligini set eder
         * @return int tipinde geri donus degeri
         */
        public int getCategoryID() {
            return categoryID;
        }

        /**
         * categoryID degerini set eder
         * @param categoryID int tipinde parametre degeri
         */
        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
        }

        /**
         * veri listesinin boyutunu geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int size() {
            return dataList.size();
        }
       
        /**
         * veri listesini temizler
         */
        public void clear() {
            dataList.clear();
        }
       
        /**
         * veri listesi icin entrySet i geri dondurur 
         * @return Set<Map.Entry<Integer,Integer>>  tipinde geri donus degeri
         */
        public Set<Map.Entry<Integer,Integer>> entrySet() {
            return dataList.entrySet();
        }
       
        /**
         * veri listesinde key var mi diye bakar ve var ise true geri dondurur
         * @param key Object tipinde parametre degeri
         * @return boolean tipinde geri donus degeri
         */
        public boolean containsKey(Object key) {
            return dataList.containsKey(key);
        }
       
        /**
         * veri listesinde value var mi diye bakar ve var ise true geri dondurur
         * @param value Object tipinde parametre degeri
         * @return boolean tipinde geri donus degeri
         */
        public boolean containsValue(Object value) {
            return dataList.containsValue(value);
        }
       
        /**
         * verilen keye karsilik value map degerini geri dondurur
         * @param key Object tipinde
         * @return Integer tipinde 
         */
        public Integer get(Object key) {
            return dataList.get(key);
        }
       
        /**
         * key-value ciftini map veri listesine ekler.
         * @param key Integer tipinde parametre degeri
         * @param value Integer tipinde parametre degeri
         * @return Integer tipinde geri donus degeri
         */
        public Integer put(Integer key, Integer value) {
            Integer tempValue=null;
            if (dataList.containsKey(key))
                tempValue=dataList.get(key);
            dataList.put(key,value);
            return tempValue;
        }
        
    }
    
    /**
     * word ve word tekrar sayısını bir arada ve ilgili epostaid ve categoryid 
     * ye gore tutmak icin kullanilir.
     */
    public class CategorizedWordFrequency{
        private int categoryID=-1;
        private int emailID=-1;
        private int wordID=-1;
        private int wordFrequency=0;
        
        /**
         * no parameter constructor, degerleri varsayilan -1 e ve frequency yi de 0'a set eder.
         */
        public CategorizedWordFrequency() {
        }

        /**
         * categoryID, emailID, wordID, wordFrequency degerleri ile nesneyi hazirlayan constructor
         * @param categoryID
         * @param emailID
         * @param wordID
         * @param wordFrequency 
         */
        public CategorizedWordFrequency(int categoryID, int emailID, int wordID, int wordFrequency) {
            this.categoryID=categoryID;
            this.emailID=emailID;
            this.wordID=wordID;
            this.wordFrequency=wordFrequency;
        }

        /**
         * categoryID ozelligini geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int getCategoryID() {
            return categoryID;
        }

        /**
         * emailID ozelligini geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int getEmailID() {
            return emailID;
        }

        /**
         * wordID ozelligini geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int getWordID() {
            return wordID;
        }

        /**
         * wordFrequency ozelligini geri dondurur
         * @return int tipinde geri donus degeri
         */
        public int getWordFrequency() {
            return wordFrequency;
        }

        /**
         * categoryID ozelligini set eder.
         * @param categoryID 
         */
        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
        }

        /**
         * categoryID ozelligini set eder.
         * @param categoryID 
         */
        public void setEmailID(int emailID) {
            this.emailID = emailID;
        }

        /**
         * categoryID ozelligini set eder.
         * @param categoryID 
         */
        public void setWordID(int wordID) {
            this.wordID = wordID;
        }

        /**
         * categoryID ozelligini set eder.
         * @param categoryID 
         */
        public void setWordFrequency(int wordFrequency) {
            this.wordFrequency = wordFrequency;
        }

        /**
         * String tipinde nesne ozelliklerini geri dondurur
         * @return String tipinde geri donus degeri
         */
        @Override
        public String toString() {
            return "CategorizedWordFrequency{" + "categoryID=" + categoryID + ", emailID=" + emailID + ", wordID=" + wordID + ", wordFrequency=" + wordFrequency + '}';
        }
        
    }
    
    private void jButton_Tum_Istatistikleri_GuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tum_Istatistikleri_GuncelleActionPerformed
        double egitimTumVeriOrani=0.8;
        //double testTumVeriOrani=1-egitimTumVeriOrani; 
        int epostaID=-1;
        String sql=new String("");
        ArrayList<String> subItem=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecordsAllMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsEducationMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsTestMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsNormalMails=new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> allRecordsSpamMails=new ArrayList<ArrayList<String>>();
        
        System.out.println("this.accountID: "+this.accountID);
        
        HashMap<Integer,String> categoryMap=new HashMap<Integer,String>();
        allRecords=getFieldsFromTable("[hesapdizinleri]", 3);
        int hesapID;
        System.out.println("allRecords: "+allRecords);
        for(ArrayList<String> item:allRecords){
            hesapID=Integer.valueOf(item.get(1));
            if (hesapID==this.accountID)
                categoryMap.put(Integer.valueOf(item.get(0)), item.get(2));
        }
        System.out.println("categoryMap.size(): "+categoryMap.size());
        allRecordsAllMails=getFieldsFromTable("[epostalar]", 13);
        CategorizedEmails [] categorizedAllMails;
        CategorizedEmails [] categorizedEducationMails;
        CategorizedEmails [] categorizedTestMails;
        categorizedAllMails = new CategorizedEmails[categoryMap.size()+1];
        categorizedEducationMails = new CategorizedEmails[categoryMap.size()+1];
        categorizedTestMails = new CategorizedEmails[categoryMap.size()+1];
        /*for (int i=0; i<categoryMap.size(); i++){
            categorizedAllMails[i]=new CategorizedEmails();
        }*/
        int [] eachCategoryTotalMailCount=new int[categoryMap.size()+1];
        for(int i=0; i<(categoryMap.size()+1); i++){
            categorizedAllMails[i]=new CategorizedEmails();
            categorizedEducationMails[i]=new CategorizedEmails();
            categorizedTestMails[i]=new CategorizedEmails();
        }
        int categoryID;
        for(ArrayList<String> item:allRecordsAllMails){
            categoryID=Integer.valueOf(item.get(3));
            eachCategoryTotalMailCount[categoryID]=eachCategoryTotalMailCount[categoryID]+1;
            System.out.println("item.size(): "+item.size());
            System.out.println("categoryID: "+categoryID);
            System.out.println("categorizedAllMails["+categoryID+"].size() "+categorizedAllMails[categoryID].size());
            categorizedAllMails[categoryID].add(item);
            if (item.get(12).equals("1")) //if email is a spam mail
               allRecordsSpamMails.add(item);
            else
               allRecordsNormalMails.add(item);
        }
        
        for (int i=0; i<categorizedAllMails.length; i++){
            Iterator<ArrayList<String>> iteratorOfCategorizedAllMails=categorizedAllMails[i].iterator();
            ArrayList<String> item=null;
            int mailCount=0;
            while(iteratorOfCategorizedAllMails.hasNext()){
                mailCount++;
                item=iteratorOfCategorizedAllMails.next();
                if (mailCount<=eachCategoryTotalMailCount[i]*egitimTumVeriOrani)
                   categorizedEducationMails[i].add(item);
                else
                   categorizedTestMails[i].add(item);
            }
        }

        int wordID;
        int wordFrequency; // to calculate total word count
        int vocabularyFrequency; // to calculate total email count
        String tableName;
        //HashMap<Integer, Integer> wordTotalFrequencyMap=new HashMap<Integer, Integer>();
        //HashMap<Integer, Integer> vocabularyTotalFrequencyMap=new HashMap<Integer, Integer>();
        CategorizedMap [] wordTotalFrequencyCategorizedMap;
        CategorizedMap [] vocabularyTotalFrequencyCategorizedMap;
        wordTotalFrequencyCategorizedMap=new CategorizedMap[categoryMap.size()+1];
        vocabularyTotalFrequencyCategorizedMap=new CategorizedMap[categoryMap.size()+1];
        CategorizedWordFrequency wordFrequencyForEachWord;
        HashMap<Integer, CategorizedWordFrequency> wordFrequencyForEachWordMap=new HashMap<Integer, CategorizedWordFrequency>();
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i]=new CategorizedMap();
            vocabularyTotalFrequencyCategorizedMap[i]=new CategorizedMap();
        }
        
        tableName=new String("[istatistikler_baglantilar]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_baglantilar_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_baglantilar_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 6);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordID=Integer.valueOf(item.get(3));
            wordFrequency=Integer.valueOf(item.get(4));
            categoryID=Integer.valueOf(item.get(5));
            wordFrequencyForEachWord=new CategorizedWordFrequency(categoryID, epostaID, wordID, wordFrequency);
            if (wordID==261)
                System.out.println("wordFrequencyForEachWord: "+wordFrequencyForEachWord);
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
            if (wordFrequencyForEachWordMap.containsKey(wordID)){
                wordFrequencyForEachWord.setWordFrequency(wordFrequencyForEachWordMap.get(wordID).getWordFrequency()+wordFrequency);
            }
            wordFrequencyForEachWordMap.put(wordID, wordFrequencyForEachWord);
        }
        tableName=new String("[istatistikler_baglantilar_tumu]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        Set<Map.Entry<Integer,CategorizedWordFrequency>> setOfMapEntry=wordFrequencyForEachWordMap.entrySet();
        Iterator<Map.Entry<Integer,CategorizedWordFrequency>> iterator=setOfMapEntry.iterator();
        Map.Entry<Integer,CategorizedWordFrequency> mapEntry=null;
        while(iterator.hasNext()){
            mapEntry=iterator.next();
            wordFrequencyForEachWord=mapEntry.getValue();
            categoryID=wordFrequencyForEachWord.getCategoryID();
            epostaID=wordFrequencyForEachWord.getEmailID();
            wordID=wordFrequencyForEachWord.getWordID();
            wordFrequency=wordFrequencyForEachWord.getWordFrequency();
            sql = "INSERT INTO "+tableName+" ([istatistikler_baglantilar_tumu_dizinid],[istatistikler_baglantilar_tumu_epostaid],[istatistikler_baglantilar_tumu_kelimeid],[istatistikler_baglantilar_tumu_kelimefrekansi]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
            executeInsertUpdateDeleteSQL(sql);
            System.out.println(sql+" query has been executed.");
        }
        }

        tableName=new String("[istatistikler_baslik]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_baslik_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_baslik_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 5);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordFrequency=Integer.valueOf(item.get(3));
            categoryID=Integer.valueOf(item.get(4));
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
        }
        tableName=new String("[istatistikler_baslik2]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=1; i<(categoryMap.size()+1); i++){
            Set<Map.Entry<Integer,Integer>> setOfMapEntry=wordTotalFrequencyCategorizedMap[i].entrySet();
            Iterator<Map.Entry<Integer,Integer>> iterator=setOfMapEntry.iterator();
            Map.Entry<Integer,Integer> mapEntry=null;
            while(iterator.hasNext()){
                mapEntry=iterator.next();
                epostaID=mapEntry.getKey();
                wordFrequency=mapEntry.getValue();
                vocabularyFrequency=vocabularyTotalFrequencyCategorizedMap[i].get(epostaID);
                sql = "INSERT INTO "+tableName+" ([istatistikler_baslik_dizinid],[istatistikler_baslik_epostaid],[istatistikler_baslik_kelimefrekansi],[istatistikler_baslik_kelimecesitadedi]) VALUES ("+i+","+epostaID+","+wordFrequency+","+vocabularyFrequency+");";
                executeInsertUpdateDeleteSQL(sql);
                System.out.println(sql+" query has been executed.");
            }
        }
        }

        tableName=new String("[istatistikler_ekler_kelime]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_ekler_kelime_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_ekler_kelime_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 5);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordFrequency=Integer.valueOf(item.get(3));
            categoryID=Integer.valueOf(item.get(4));
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
        }
        tableName=new String("[istatistikler_ekler_kelime2]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=1; i<(categoryMap.size()+1); i++){
            Set<Map.Entry<Integer,Integer>> setOfMapEntry=wordTotalFrequencyCategorizedMap[i].entrySet();
            Iterator<Map.Entry<Integer,Integer>> iterator=setOfMapEntry.iterator();
            Map.Entry<Integer,Integer> mapEntry=null;
            while(iterator.hasNext()){
                mapEntry=iterator.next();
                epostaID=mapEntry.getKey();
                wordFrequency=mapEntry.getValue();
                vocabularyFrequency=vocabularyTotalFrequencyCategorizedMap[i].get(epostaID);
                sql = "INSERT INTO "+tableName+" ([istatistikler_ekler_kelime_dizinid],[istatistikler_ekler_kelime_epostaid],[istatistikler_ekler_kelime_kelimefrekansi],[istatistikler_ekler_kelime_kelimecesitadedi]) VALUES ("+i+","+epostaID+","+wordFrequency+","+vocabularyFrequency+");";
                executeInsertUpdateDeleteSQL(sql);
                System.out.println(sql+" query has been executed.");
            }
        }
        }

        tableName=new String("[istatistikler_icerik]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_icerik_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_icerik_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 5);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordFrequency=Integer.valueOf(item.get(3));
            categoryID=Integer.valueOf(item.get(4));
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
        }
        tableName=new String("[istatistikler_icerik2]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=1; i<(categoryMap.size()+1); i++){
            Set<Map.Entry<Integer,Integer>> setOfMapEntry=wordTotalFrequencyCategorizedMap[i].entrySet();
            Iterator<Map.Entry<Integer,Integer>> iterator=setOfMapEntry.iterator();
            Map.Entry<Integer,Integer> mapEntry=null;
            while(iterator.hasNext()){
                mapEntry=iterator.next();
                epostaID=mapEntry.getKey();
                wordFrequency=mapEntry.getValue();
                vocabularyFrequency=vocabularyTotalFrequencyCategorizedMap[i].get(epostaID);
                sql = "INSERT INTO "+tableName+" ([istatistikler_icerik_dizinid],[istatistikler_icerik_epostaid],[istatistikler_icerik_kelimefrekansi],[istatistikler_icerik_kelimecesitadedi]) VALUES ("+i+","+epostaID+","+wordFrequency+","+vocabularyFrequency+");";
                executeInsertUpdateDeleteSQL(sql);
                System.out.println(sql+" query has been executed.");
            }
        }
        }

        tableName=new String("[istatistikler_kimden]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_kimden_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_kimden_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 5);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordFrequency=Integer.valueOf(item.get(3));
            categoryID=Integer.valueOf(item.get(4));
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
        }
        tableName=new String("[istatistikler_kimden2]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=1; i<(categoryMap.size()+1); i++){
            Set<Map.Entry<Integer,Integer>> setOfMapEntry=wordTotalFrequencyCategorizedMap[i].entrySet();
            Iterator<Map.Entry<Integer,Integer>> iterator=setOfMapEntry.iterator();
            Map.Entry<Integer,Integer> mapEntry=null;
            while(iterator.hasNext()){
                mapEntry=iterator.next();
                epostaID=mapEntry.getKey();
                wordFrequency=mapEntry.getValue();
                vocabularyFrequency=vocabularyTotalFrequencyCategorizedMap[i].get(epostaID);
                sql = "INSERT INTO "+tableName+" ([istatistikler_kimden_dizinid],[istatistikler_kimden_epostaid],[istatistikler_kimden_kelimefrekansi],[istatistikler_kimden_kelimecesitadedi]) VALUES ("+i+","+epostaID+","+wordFrequency+","+vocabularyFrequency+");";
                executeInsertUpdateDeleteSQL(sql);
                System.out.println(sql+" query has been executed.");
            }
        }
        }

        tableName=new String("[istatistikler_kime]");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_kime_epostaid]=-1;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        sql = "DELETE FROM "+tableName+" WHERE [istatistikler_kime_dizinid] IS NULL;"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        allRecords=getFieldsFromTable(tableName, 5);
        for(int i=0; i<(categoryMap.size()+1); i++){
            wordTotalFrequencyCategorizedMap[i].clear();
            vocabularyTotalFrequencyCategorizedMap[i].clear();
        }
        if (allRecords!=null){
        for(ArrayList<String> item:allRecords){
            //System.out.println("item: "+item);
            epostaID=Integer.valueOf(item.get(1));
            wordFrequency=Integer.valueOf(item.get(3));
            categoryID=Integer.valueOf(item.get(4));
            //System.out.println("epostaID: "+epostaID);
            //System.out.println("wordFrequency: "+wordFrequency);
            //System.out.println("categoryID: "+categoryID);
            if (wordTotalFrequencyCategorizedMap[categoryID].containsKey(epostaID)){
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordTotalFrequencyCategorizedMap[categoryID].get(epostaID)+wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, vocabularyTotalFrequencyCategorizedMap[categoryID].get(epostaID)+1);
            }
            else{
                wordTotalFrequencyCategorizedMap[categoryID].put(epostaID, wordFrequency);
                vocabularyTotalFrequencyCategorizedMap[categoryID].put(epostaID, 1);
            }
        }
        tableName=new String("[istatistikler_kime2]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=1; i<(categoryMap.size()+1); i++){
            Set<Map.Entry<Integer,Integer>> setOfMapEntry=wordTotalFrequencyCategorizedMap[i].entrySet();
            Iterator<Map.Entry<Integer,Integer>> iterator=setOfMapEntry.iterator();
            Map.Entry<Integer,Integer> mapEntry=null;
            while(iterator.hasNext()){
                mapEntry=iterator.next();
                epostaID=mapEntry.getKey();
                wordFrequency=mapEntry.getValue();
                vocabularyFrequency=vocabularyTotalFrequencyCategorizedMap[i].get(epostaID);
                sql = "INSERT INTO "+tableName+" ([istatistikler_kime_dizinid],[istatistikler_kime_epostaid],[istatistikler_kime_kelimefrekansi],[istatistikler_kime_kelimecesitadedi]) VALUES ("+i+","+epostaID+","+wordFrequency+","+vocabularyFrequency+");";
                executeInsertUpdateDeleteSQL(sql);
                System.out.println(sql+" query has been executed.");
            }
        }
        }

        //categorizedAllMails[i]=new CategorizedEmails();
        //categorizedEducationMails[i]=new CategorizedEmails();
        //categorizedTestMails[i]=new CategorizedEmails();
        tableName=new String("[istatistikler_epostalaregitim]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=0; i<(categoryMap.size()+1); i++){
            Iterator<ArrayList<String>> iteratorOfCategorizedEducationMails=categorizedEducationMails[i].iterator();
            ArrayList<String> item=null;
            while(iteratorOfCategorizedEducationMails.hasNext()){
                item=iteratorOfCategorizedEducationMails.next();
                int tempAccountID=Integer.valueOf(item.get(2));
                if (tempAccountID==accountID){
                    epostaID=Integer.valueOf(item.get(0));
                    categoryID=Integer.valueOf(item.get(3));
                    tableName=new String("[istatistikler_baglantilar_tumu]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_baglantilar_tumu_epostaid]="+epostaID+" AND [istatistikler_baglantilar_tumu_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_baglantilar]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_baglantilar]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_baslik]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_baslik_epostaid]="+epostaID+" AND [istatistikler_baslik_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_baslik]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_baslik]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_ekler_kelime]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_ekler_kelime_epostaid]="+epostaID+" AND [istatistikler_ekler_kelime_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_ekler_kelime]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_ekler_kelime]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_icerik]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_icerik_epostaid]="+epostaID+" AND [istatistikler_icerik_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_icerik]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_icerik]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_kimden]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_kimden_epostaid]="+epostaID+" AND [istatistikler_kimden_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_kimden]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_kimden]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_kime]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_kime_epostaid]="+epostaID+" AND [istatistikler_kime_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalaregitim]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_kime]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_kime]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                }
            }
        }
        
        
        tableName=new String("[istatistikler_epostalartest]");
        sql = "DELETE FROM "+tableName+";"; // all records deleted from the table to update all statistics data
        executeInsertUpdateDeleteSQL(sql);
        System.out.println(sql+" query has been executed.");
        for(int i=0; i<(categoryMap.size()+1); i++){
            Iterator<ArrayList<String>> iteratorOfCategorizedTestMails=categorizedTestMails[i].iterator();
            ArrayList<String> item=null;
            while(iteratorOfCategorizedTestMails.hasNext()){
                item=iteratorOfCategorizedTestMails.next();
                int tempAccountID=Integer.valueOf(item.get(2));
                if (tempAccountID==accountID){
                    epostaID=Integer.valueOf(item.get(0));
                    categoryID=Integer.valueOf(item.get(3));
                    tableName=new String("[istatistikler_baglantilar_tumu]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_baglantilar_tumu_epostaid]="+epostaID+" AND [istatistikler_baglantilar_tumu_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_baglantilar]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_baglantilar]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_baslik]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_baslik_epostaid]="+epostaID+" AND [istatistikler_baslik_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_baslik]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_baslik]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_ekler_kelime]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_ekler_kelime_epostaid]="+epostaID+" AND [istatistikler_ekler_kelime_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_ekler_kelime]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_ekler_kelime]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_icerik]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_icerik_epostaid]="+epostaID+" AND [istatistikler_icerik_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_icerik]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_icerik]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_kimden]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_kimden_epostaid]="+epostaID+" AND [istatistikler_kimden_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_kimden]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_kimden]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                    tableName=new String("[istatistikler_kime]");
                    sql="SELECT * FROM "+tableName+" WHERE [istatistikler_kime_epostaid]="+epostaID+" AND [istatistikler_kime_dizinid]="+categoryID;
                    allRecords=getFieldsFromSelectSQL(sql, 5);
                    if (allRecords!=null){
                        Iterator<ArrayList<String>> iteratorOfAllRecords=allRecords.iterator();
                        while(iteratorOfAllRecords.hasNext()){
                            item=iteratorOfAllRecords.next();
                            wordID=Integer.valueOf(item.get(2));
                            wordFrequency=Integer.valueOf(item.get(3));
                            tableName=new String("[istatistikler_epostalartest]");
                            sql="SELECT * FROM "+tableName+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                            allRecords=getFieldsFromSelectSQL(sql, 5);
                            if (allRecords==null){
                                sql = "INSERT INTO "+tableName+" ([istatistikler_dizinid],[istatistikler_epostaid],[istatistikler_kelimeid],[istatistikler_kelimefrekansi_kime]) VALUES ("+categoryID+","+epostaID+","+wordID+","+wordFrequency+");";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }else{
                                sql = "UPDATE "+tableName+" SET [istatistikler_kelimefrekansi_kime]="+wordFrequency+" WHERE [istatistikler_dizinid]="+categoryID+" AND [istatistikler_epostaid]="+epostaID+" AND [istatistikler_kelimeid]="+wordID+";";
                                System.out.println("sql: "+sql);
                                executeInsertUpdateDeleteSQL(sql);
                                System.out.println(sql+" query has been executed.");
                            }
                        }
                    }
                }
            }
        }
        
        
    }//GEN-LAST:event_jButton_Tum_Istatistikleri_GuncelleActionPerformed

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
            java.util.logging.Logger.getLogger(IstatistiklerYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IstatistiklerYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IstatistiklerYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IstatistiklerYonetimiForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IstatistiklerYonetimiForm().setVisible(true);
            }
        });
    }

    /**
     * bir tabloya SELECT sorgusu ceker ve sonuclari ArrayList<ArrayList<String>>
     * yapısında geriye dondurur.
     * @param tableName veritabanindaki tablo ismi
     * @param totalFieldCount alan adedi,  kac tane alan getirilmesi gerektigini belirtir
     * @return ArrayList<ArrayList<String>> yapisinda geriye veriler doner veya bos ise null dondurulur.
     */
    public ArrayList<ArrayList<String>> getFieldsFromTable(String tableName, int totalFieldCount){
        ArrayList<ArrayList<String>> allRecords=new ArrayList<ArrayList<String>>();
        ArrayList<String> rowFields=null;
        try{
            sql = "SELECT * FROM "+tableName;
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);				
            con.commit();
            statement.close();
            rs.first();
            if (rs.wasNull())
                return null;
            try{
                while(!rs.isAfterLast()){
                    rowFields=new ArrayList<String>();
                    for(int i=1; i<=totalFieldCount; i++){
                        rowFields.add(rs.getString(i));
                        //System.out.println("veritabani degeri: "+rs.getString(i));
                    }
                    allRecords.add(rowFields);
                    rs.next();
                }
            }catch(Exception exp){
                return null;
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }
        //allRecords.remove(allRecords.size()-1);
        if (allRecords.size()==0)
            return null;
        else
            return allRecords;
    }

    public boolean valueIsExistInList(ArrayList<ArrayList<String>> dataList, String value){
        if (dataList==null)
                return false;
        for(int i=0; i<dataList.size(); i++)
            if (dataList.get(i).contains(value))
                return true;
        return false;
    }
    
    public boolean valueIsExistInList(ArrayList<ArrayList<String>> dataList, String category, String value){
        if (dataList==null)
                return false;
        ArrayList<String> tempSubItems=new ArrayList<String>();
        for(int i=0; i<dataList.size(); i++){
            tempSubItems=dataList.get(i);
            if (tempSubItems.get(1).equals(category) && tempSubItems.get(2).equals(value))
                return true;
        }
        return false;
    }
    
    public boolean valueIsExistInList(ArrayList<ArrayList<String>> dataList, String orderedValue1, String orderedValue2, String orderedValue3){
        if (dataList==null)
                return false;
        ArrayList<String> tempSubItems=new ArrayList<String>();
        for(int i=0; i<dataList.size(); i++){
            tempSubItems=dataList.get(i);
            if (tempSubItems.get(1).equals(orderedValue1) && tempSubItems.get(2).equals(orderedValue2) && tempSubItems.get(3).equals(orderedValue3))
                return true;
        }
        return false;
    }
    
    public String getValueFromSettings(ArrayList<ArrayList<String>> dataList, String settingName){
        ArrayList<String> subDataList=new ArrayList<String>();
        String settingItem=null;
        if (dataList==null)
            return null;
        for(int i=0; i<dataList.size(); i++){
            subDataList=dataList.get(i);
            for(int j=0; j<subDataList.size(); j++){
                settingItem=subDataList.get(j);
                if (settingItem.equals(settingName))
                     return subDataList.get(j+1);   
            }
        }
        return null;
    }
    
    public ArrayList<String> getRecordFromIDNo(ArrayList<ArrayList<String>> dataList, int indexNo){
        ArrayList<String> recordItem=new ArrayList<String>();
        String fieldIDNoStr=new String("");
        String indexNoStr=new String(String.valueOf(indexNo));
        if (dataList==null)
            return null;
        for(int i=0; i<dataList.size(); i++){
            recordItem=dataList.get(i);            
            fieldIDNoStr=recordItem.get(0);            
            if (indexNoStr.equals(fieldIDNoStr)){
                return recordItem;
            }
        }
        return null;
    }
    
    /**
     * verilen ArrayList<ArrayList<String>> yapisindaki veri listesi
     * icerisinde recordValue String bilgisini bulursa herhangi bir alan icinde 
     * o bulunan ilk kaydin ilk alan bilgisi ki tabloda her verinin ilk alani
     * o kayit icin ID bilgisini icerir, iste bu ID degeri int tipinde geriye doner.
     * @param dataList ArrayList<ArrayList<String>> yapisindaki icinde aranilacak veri listesi
     * @param recordValue aranilacak kayit degeri bilgisi String tipinde
     * @return bulunulan kaydin kayit Id nosu geri, int tipinde, bulunamazsa -1 dondurulur
     */
    public int getIDNoOfRecord(ArrayList<ArrayList<String>> dataList, String recordValue){
        ArrayList<String> subDataList;
        String settingItem=null;
        //System.out.println("dataList in getIDNoOfRecord(tekli value icin): "+dataList);
        //System.out.println("recordValue in getIDNoOfRecord(tekli value icin): "+recordValue);
        if (dataList==null)
            return -1;
        for(int i=0; i<dataList.size(); i++){
            subDataList=new ArrayList<String>();
            subDataList=dataList.get(i);
            //System.out.println("subDataList in getIDNoOfRecord(tekli value icin): "+subDataList);
            for(int j=0; j<subDataList.size(); j++){
                settingItem=new String(subDataList.get(j));
                //System.out.println("settingItem: "+settingItem);
                //System.out.println("subDataList.get(0): "+subDataList.get(0));
                //System.out.println("subDataList.get(1): "+subDataList.get(1));
                if (settingItem.equals(recordValue)){
                    Integer tempInteger=new Integer(subDataList.get(0));
                    return tempInteger.intValue();
                }
            }
        }
        return -1;
    }
    
    /**
     * verilen ArrayList<ArrayList<String>> yapisindaki veri listesi
     * icerisinde recordValue1 ve recordValue2 String degerlerini ardisil olarak 
     * bulursa herhangi iki ardisil alan icerisinde
     * o bulunan ilk kaydin ilk alan bilgisi ki tabloda her verinin ilk alani
     * o kayit icin ID bilgisini icerir, iste bu ID degeri int tipinde geriye doner.
     * @param dataList ArrayList<ArrayList<String>> yapisindaki icinde aranilacak veri listesi
     * @param recordValue aranilacak kayit degeri bilgisi String tipinde
     * @return bulunulan kaydin kayit Id nosu geri, int tipinde, bulunamazsa -1 dondurulur
     */
    public int getIDNoOfRecord(ArrayList<ArrayList<String>> dataList, String recordValue1, String recordValue2){
        ArrayList<String> subDataList=new ArrayList<String>();
        String settingItem1=null;
        String settingItem2=null;
        //System.out.println("dataList in getIDNoOfRecord(ciftli value icin): "+dataList);
        if (dataList==null)
            return -1;
        for(int i=0; i<dataList.size(); i++){
            subDataList=dataList.get(i);
            //System.out.println("subDataList in getIDNoOfRecord(ciftli value icin): "+subDataList);
            for(int j=0; j<subDataList.size()-1; j++){
                settingItem1=subDataList.get(j);
                settingItem2=subDataList.get(j+1);
                if (settingItem1.equals(recordValue1) && settingItem2.equals(recordValue2)){
                    Integer tempInteger=new Integer(subDataList.get(0));
                    return tempInteger.intValue();
                }
            }
        }
        return -1;
    }
    
    /**
     * verilen ArrayList<ArrayList<String>> yapisindaki veri listesi
     * icerisinde recordValue1, recordValue2 ve recordValue3 String degerlerini 
     * ardisil olarak bulursa herhangi uc ardisil alan icerisinde
     * o bulunan ilk kaydin ilk alan bilgisi ki tabloda her verinin ilk alani
     * o kayit icin ID bilgisini icerir, iste bu ID degeri int tipinde geriye doner.
     * @param dataList ArrayList<ArrayList<String>> yapisindaki icinde aranilacak veri listesi
     * @param recordValue aranilacak kayit degeri bilgisi String tipinde
     * @return bulunulan kaydin kayit Id nosu geri, int tipinde, bulunamazsa -1 dondurulur
     */
    public int getIDNoOfRecord(ArrayList<ArrayList<String>> dataList, String recordValue1, String recordValue2, String recordValue3){
        ArrayList<String> subDataList=new ArrayList<String>();
        String settingItem1=null;
        String settingItem2=null;
        String settingItem3=null;
        //System.out.println("dataList in getIDNoOfRecord(ciftli value icin): "+dataList);
        if (dataList==null)
            return -1;
        for(int i=0; i<(dataList.size()); i++){
            subDataList=dataList.get(i);
            //System.out.println("subDataList in getIDNoOfRecord(ciftli value icin): "+subDataList);
            for(int j=0; j<subDataList.size()-2; j++){
                settingItem1=subDataList.get(j);
                settingItem2=subDataList.get(j+1);
                settingItem3=subDataList.get(j+2);
                if (settingItem1.equals(recordValue1) && settingItem2.equals(recordValue2) && settingItem3.equals(recordValue3)){
                    Integer tempInteger=new Integer(subDataList.get(0));
                    return tempInteger.intValue();
                }
            }
        }
        return -1;
    }    

    /**
     * verilen bir SELECTicerikli SQL surgusunu calistirir ve
     * ceker ve sonuclari ArrayList<ArrayList<String>> yapısında geriye dondurur.
     * @param sql sorgusu String tipinde
     * @param totalFieldCount alan adedi,  kac tane alan getirilmesi gerektigini belirtir
     * @return ArrayList<ArrayList<String>> yapisinda geriye veriler doner veya bos ise null dondurulur.
     */
    public ArrayList<ArrayList<String>> getFieldsFromSelectSQL(String sqlQuery, int totalFieldCount){
        ArrayList<ArrayList<String>> allRecords=new ArrayList<ArrayList<String>>();
        ArrayList<String> rowFields=null;
        try{
            sql = sqlQuery;
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = statement.executeQuery(sql);				
            con.commit();
            statement.close();
            rs.first();
            if (rs.wasNull())
                return null;
            try{
                while(!rs.isAfterLast()){
                    rowFields=new ArrayList<String>();
                    for(int i=1; i<=totalFieldCount; i++){
                        rowFields.add(rs.getString(i));
                        //System.out.println("veritabani degeri: "+rs.getString(i));
                    }
                    allRecords.add(rowFields);
                    rs.next();
                }
            }catch(Exception exp){
                return null;
            }
        }catch(Exception exp){
            exp.printStackTrace();
        }
        //allRecords.remove(allRecords.size()-1);
        if (allRecords.size()==0)
            return null;
        else
            return allRecords;
    }

    /**
     * parametre olarak verilen INSERT,UPDATE,DELETE sorgularindan birini iceren 
     * sql sorgusunu calistirir.
     * @param sqlQuery Strin tipinde sql sorgusu
     * @return hata olusmazsa geriye true doner, aksi halde false return edilir.
     */
    public boolean executeInsertUpdateDeleteSQL(String sqlQuery){
        try{
            sql = sqlQuery;
            statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
            statement.execute(sql);				
            con.commit();
            statement.close();
        }catch(Exception exp){
            exp.printStackTrace();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Istatistikleri_Guncelle;
    private javax.swing.JButton jButton_Tum_Istatistikleri_Guncelle;
    private javax.swing.JComboBox<String> jComboBox_Istatistik_Secimi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    // End of variables declaration//GEN-END:variables
}
