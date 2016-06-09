/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_with_pooka;

import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import net.suberic.pooka.*;
import net.suberic.util.*;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Alfabe;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

import javax.swing.text.html.parser.ParserDelegator;
import javax.swing.text.html.HTMLEditorKit.Parser;
import javax.swing.text.html.HTMLEditorKit.*;
import javax.swing.text.html.parser.*;
import javax.swing.text.html.*;
import javax.swing.text.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.*;
import org.jsoup.nodes.*;

import java.nio.charset.Charset;
import com.healthmarketscience.jackcess.Database;
import com.healthmarketscience.jackcess.DatabaseBuilder;

import net.ucanaccess.jdbc.JackcessOpenerInterface;

import com.joestelmach.natty.*;

/**
 *
 * @author Kenan Savas
 */
public class MainForm extends javax.swing.JFrame {

    private String pookaLocalRootPath=null;
    
    private ArrayList<String> sharedItemsFromEmail;
    private ArrayList<String> sharedWordsFromItem;

    int accountID=-1;
    
    ResultSet rs;
    public static java.sql.Connection con;
    Statement statement;
    String sql;
    
    ArrayList<ArrayList<String>> allRecords=null;
    
    /**
     * Creates new form MainJFrame
     */
    public MainForm() {
        allRecords=new ArrayList<ArrayList<String>>();
        sharedItemsFromEmail=new ArrayList<String>();
        sharedWordsFromItem=new ArrayList<String>();
        this.pookaLocalRootPath=new String("");
        initComponents();
        jTextField_emailPookaHomePath.setText(pookaLocalRootPath);
        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://db/akilli_eposta_db.mdb");
            con.setAutoCommit(false);
        }catch(Exception exp){
            exp.printStackTrace();
        }
        this.accountID=1;
    }

    public MainForm(String pookaLocalRootPath) {
        sharedItemsFromEmail=new ArrayList<String>();
        sharedWordsFromItem=new ArrayList<String>();
        String emailAccountName=new String("");
        String emailDirName=new String("");
        ArrayList<String> dirList=new ArrayList<String>();
        this.pookaLocalRootPath=new String(pookaLocalRootPath);
        initComponents();
        jTextField_emailPookaHomePath.setText(pookaLocalRootPath);
        String accountDirPath=new String(getPookaLocalRootPath());
        accountDirPath=accountDirPath.concat("\\cache");
        //accountDirPath=accountDirPath.replace("\\", "\\\\");
        //dirList=util.getAllFiles("C:\\Users\\Xpology\\.pooka\\cache", true, false);
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailAccountList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailAccountList.addItem(directoryName);
        }
        //jComboBox_emailAccountList.setSelectedIndex(0);
        emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        //emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
        //emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());

        /*
        emailAccountName=jComboBox_emailAccountList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailAccountName);
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emaiDirlList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emaiDirlList.addItem(directoryName);
        }
        //jComboBox_emailAccountList.setSelectedIndex(3);
        emailDirName=jComboBox_emaiDirlList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailDirName);
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailList.addItem(directoryName);
        }
        */
        try{
            con = DriverManager.getConnection("jdbc:ucanaccess://db/akilli_eposta_db.mdb");
            con.setAutoCommit(false);
        }catch(Exception exp){
            exp.printStackTrace();
        }
        //allRecords=getFieldsFromTable("[hesaplar]", 2);
        //this.accountID=getIDNoOfRecord(allRecords, emailAccountName);
    }

    public String getPookaLocalRootPath() {
        return pookaLocalRootPath;
    }

    public void setPookaLocalRootPath(String pookaLocalRootPath) {
        this.pookaLocalRootPath = pookaLocalRootPath;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField_emailPookaHomePath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton_emailYukle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton_Kelimeleri_Bul = new javax.swing.JButton();
        jButton_Kelimeleri_Cozumle = new javax.swing.JButton();
        jButton_Epostayi_Kaydet = new javax.swing.JButton();
        jButton_linkleriGetir = new javax.swing.JButton();
        jComboBox_emailList = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_emailFieldList = new javax.swing.JComboBox<>();
        jButton_Email_Alan_Bilgisini_Getir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_emailBilgisi = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_emailBilgisiCozumlenmis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_emailAccountList = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_emailDirList = new javax.swing.JComboBox<>();
        jButton_Tum_Dizinlerdeki_Epostalari_Kaydet = new javax.swing.JButton();
        jButton_DB_Yonetim_Panelini_Ac = new javax.swing.JButton();
        jButton_Program_Hakkinda = new javax.swing.JButton();
        jButton_Bu_Dizindeki_Epostalari_Kaydet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Akıllı E-Posta Asistanı - Başlangıç Ekranı");

        jTextField_emailPookaHomePath.setEditable(false);
        jTextField_emailPookaHomePath.setText("C:\\Users\\Xpology\\.pooka\\cache\\kenan.savas@posta.marmara.edu.tr");
        jTextField_emailPookaHomePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_emailPookaHomePathActionPerformed(evt);
            }
        });

        jLabel1.setText("E-Mail Diretory Path: ");

        jButton_emailYukle.setText("Pooka Yolunu Yükle");
        jButton_emailYukle.setEnabled(false);
        jButton_emailYukle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_emailYukleActionPerformed(evt);
            }
        });

        jLabel2.setText("E-Mail Posta Listesi");

        jButton_Kelimeleri_Bul.setText("Kelimeleri Bul");
        jButton_Kelimeleri_Bul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Kelimeleri_BulActionPerformed(evt);
            }
        });

        jButton_Kelimeleri_Cozumle.setText("Çözümle");
        jButton_Kelimeleri_Cozumle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Kelimeleri_CozumleActionPerformed(evt);
            }
        });

        jButton_Epostayi_Kaydet.setText("Bu E-Postayi DB'e Kaydet");
        jButton_Epostayi_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Epostayi_KaydetActionPerformed(evt);
            }
        });

        jButton_linkleriGetir.setText("Linkleri Getir");
        jButton_linkleriGetir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_linkleriGetirActionPerformed(evt);
            }
        });

        jComboBox_emailList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_emailListActionPerformed(evt);
            }
        });

        jLabel3.setText("E-Mail İçerik Bilgisi");

        jComboBox_emailFieldList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "E-Posta İçerik Metni", "E-Posta Başlık Bilgisi", "Kimden E-Posta Adresi", "Kime E-Posta Adresi", "E-Posta Zaman Bilgisi", "E-Posta Ekler Bilgisi", "E-Posta Tüm Başlık Bilgileri" }));
        jComboBox_emailFieldList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_emailFieldListActionPerformed(evt);
            }
        });

        jButton_Email_Alan_Bilgisini_Getir.setText("E-mail Alan Bilgisini Getir");
        jButton_Email_Alan_Bilgisini_Getir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Email_Alan_Bilgisini_GetirActionPerformed(evt);
            }
        });

        jTextArea_emailBilgisi.setColumns(20);
        jTextArea_emailBilgisi.setRows(5);
        jScrollPane1.setViewportView(jTextArea_emailBilgisi);

        jTextArea_emailBilgisiCozumlenmis.setColumns(20);
        jTextArea_emailBilgisiCozumlenmis.setRows(5);
        jScrollPane2.setViewportView(jTextArea_emailBilgisiCozumlenmis);

        jLabel4.setText("E-Mail Hesap Listesi");

        jComboBox_emailAccountList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_emailAccountListActionPerformed(evt);
            }
        });

        jLabel5.setText("E-Mail Dizin Listesi");

        jComboBox_emailDirList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_emailDirListActionPerformed(evt);
            }
        });

        jButton_Tum_Dizinlerdeki_Epostalari_Kaydet.setText("Tüm Dizinlerdeki Tüm E-Postalari Kaydet");
        jButton_Tum_Dizinlerdeki_Epostalari_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Tum_Dizinlerdeki_Epostalari_KaydetActionPerformed(evt);
            }
        });

        jButton_DB_Yonetim_Panelini_Ac.setText("Database Yönetim Panelini Aç");
        jButton_DB_Yonetim_Panelini_Ac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DB_Yonetim_Panelini_AcActionPerformed(evt);
            }
        });

        jButton_Program_Hakkinda.setText("Program Hakkında");
        jButton_Program_Hakkinda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Program_HakkindaActionPerformed(evt);
            }
        });

        jButton_Bu_Dizindeki_Epostalari_Kaydet.setText("Sadece Bu Dizindeki Tüm E-Postalari Kaydet");
        jButton_Bu_Dizindeki_Epostalari_Kaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Bu_Dizindeki_Epostalari_KaydetActionPerformed(evt);
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
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton_Kelimeleri_Bul, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Kelimeleri_Cozumle, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_linkleriGetir, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Program_Hakkinda, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_emailDirList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox_emailFieldList, 0, 289, Short.MAX_VALUE)
                            .addComponent(jComboBox_emailList, 0, 289, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_DB_Yonetim_Panelini_Ac, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(jButton_Tum_Dizinlerdeki_Epostalari_Kaydet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                            .addComponent(jButton_Email_Alan_Bilgisini_Getir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Epostayi_Kaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_Bu_Dizindeki_Epostalari_Kaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_emailPookaHomePath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_emailYukle))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jComboBox_emailAccountList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(373, 373, 373)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3, jLabel4, jLabel5});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_emailPookaHomePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton_emailYukle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox_emailAccountList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_Email_Alan_Bilgisini_Getir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox_emailDirList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Epostayi_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton_Bu_Dizindeki_Epostalari_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox_emailList, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton_Tum_Dizinlerdeki_Epostalari_Kaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox_emailFieldList, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                            .addComponent(jButton_DB_Yonetim_Panelini_Ac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_linkleriGetir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Kelimeleri_Bul)
                    .addComponent(jButton_Kelimeleri_Cozumle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Program_Hakkinda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBox_emailAccountList, jComboBox_emailDirList, jComboBox_emailFieldList, jComboBox_emailList});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton_Bu_Dizindeki_Epostalari_Kaydet, jButton_DB_Yonetim_Panelini_Ac, jButton_Email_Alan_Bilgisini_Getir, jButton_Epostayi_Kaydet, jButton_Tum_Dizinlerdeki_Epostalari_Kaydet});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static String removeHtml(String s) throws IOException {
        final StringBuilder b = new StringBuilder();
        ParserDelegator delegator = new ParserDelegator();
        // the third parameter is TRUE to ignore charset directive
        if (s==null)
            return b.toString();
        delegator.parse(new StringReader(s), new ParserCallback() {
            public void handleText(char[] data, int pos) {
                b.append(data);
            };

        }, true);
        return b.toString();
    }

    /**
     * parametre olarak verilen Date tipindeki bir tarih zaman bilgisini
     * String tipinde ve dd/MMM/yyyy formatında geriye dondurur.
     * @param indate date tipinde cevrilecek tarih zaman bilgisi
     * @return String tipinde geri donus degeri
     */
    public String convertDateToString(Date indate)
    {
       String dateString = null;
       SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
       /*you can also use DateFormat reference instead of SimpleDateFormat 
        * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
       Date todaysDate = new Date();
       DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
       DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
       DateFormat df3 = new SimpleDateFormat("dd-MMM-yyyy");
       DateFormat df4 = new SimpleDateFormat("MM dd, yyyy");
       DateFormat df5 = new SimpleDateFormat("E, MMM dd yyyy");
       DateFormat df6 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");      
       */
       try{
            dateString = sdfr.format( indate );
       }catch (Exception ex ){
            System.out.println(ex);
       }
       System.out.println(dateString);
       return dateString;
    }

    /**
     * bir e-posta bilgisinin iceriginin txt, html ya da multipart yapida 
     * olmasina gore icerik metin bilgisini alarak String tipinde geriye dondurur.
     * @param p e-posta bilgisinin Part tipinde parametre olarak verilmesi
     * @return String tipinde geri donus degeri
     * @throws MessagingException
     * @throws IOException 
     */
    private static String getText(Part p) 
        throws MessagingException, IOException {
        boolean textIsHtml = false;
        if (p.isMimeType("text/*")) {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return s;
        }
        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            String text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    String s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                String s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }

        return null;
    }

    /**
     * bir e-posta bilgisi iceren eml tipindeki dosya iceriginin txt, html ya da multipart yapida 
     * olmasina gore icerik metin bilgisini alarak String tipinde geriye dondurur.
     * @param emlFile e-posta bilgisini iceren File tipinde dosyanin parametre olarak verilmesi
     * @return String tipinde geri donus degeri
     * @throws Exception
     */    
    public static String displayBodyOfMessage(File emlFile) throws Exception{
        Properties props = System.getProperties();
        props.put("mail.host", "smtp.dummydomain.com");
        props.put("mail.transport.protocol", "smtp");

        Session mailSession = Session.getDefaultInstance(props, null);
        InputStream source = new FileInputStream(emlFile);
        MimeMessage message = new MimeMessage(mailSession, source);
        /*
        System.out.println("Subject : " + message.getSubject());
        System.out.println("From : " + message.getFrom()[0]);
        System.out.println("--------------");
        System.out.println("Body : " +  message.getContent());
        */
        javax.mail.internet.MimeBodyPart messageContent=new MimeBodyPart(source);
        Object msgContent = message.getContent();
        String content = new String("");             
        /* Check if content is pure text/html or in parts */                     
        if (msgContent instanceof Multipart) {
            Multipart multipart = (Multipart) msgContent;
            System.out.println("MultiPartCount: "+multipart.getCount());
            for (int j = 0; j < multipart.getCount(); j++) {
               BodyPart bodyPart = multipart.getBodyPart(j);
                String disposition = bodyPart.getDisposition();
                if (disposition != null && (disposition.equalsIgnoreCase("ATTACHMENT"))) { 
                    System.out.println("Mail have some attachments.");
                    //DataHandler handler = bodyPart.getDataHandler();
                    //System.out.println("file name : " + handler.getName());                                 
                } else { 
                    content = getText(bodyPart);  // the changed code         
                }
            }
        } else                
            content= message.getContent().toString();
        content=removeHtml(content);
        //System.out.println("Body2 : " +  content);
        return content;
    }
       
    private void jTextField_emailPookaHomePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_emailPookaHomePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_emailPookaHomePathActionPerformed

    private void jButton_emailYukleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_emailYukleActionPerformed
        /*
        try {
            String filePathOfValidity=new String("");
            String filePathOfMessageList=new String("");
            filePathOfValidity=jTextField_emailPookaHomePath.getText()+"\\INBOX\\validity";
            filePathOfMessageList=jTextField_emailPookaHomePath.getText()+"\\INBOX\\messageList";
            File fileOfValidity = new File(filePathOfValidity);
            File fileOfMessageList = new File(filePathOfMessageList);
            if (!fileOfValidity.exists() || !fileOfMessageList.exists()) {
                JOptionPane.showMessageDialog(null, "Bu dizin yolu eposta listesi ile ilgili gerekli dosyalari içermemektedir.", "DİKKAT", JOptionPane.WARNING_MESSAGE);
                return;
            }     
            FileReader fileReader = new FileReader(fileOfMessageList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            ArrayList<String> comboBoxItems=new ArrayList<String>();
            jComboBox_emailList.removeAllItems();
            while ((line = bufferedReader.readLine()) != null) {
                comboBoxItems.add(line);
                stringBuffer.append(line);
                stringBuffer.append("\n");
                //jComboBox_emailList.addItem(line);
            }
            bufferedReader.close();
            Collections.sort(comboBoxItems);
            Iterator<String> iterator=comboBoxItems.iterator();
            while(iterator.hasNext()){
                jComboBox_emailList.addItem(iterator.next());
            }
            //System.out.println("Contents of file:");
            //System.out.println(stringBuffer.toString());
        } catch (IOException e) {
                e.printStackTrace();
        } 
        */
    }//GEN-LAST:event_jButton_emailYukleActionPerformed

    private void jButton_Email_Alan_Bilgisini_GetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Email_Alan_Bilgisini_GetirActionPerformed
        try {
            String pookaHomePath=new String("");
            String emailAccountName=new String("");
            String emailDirName=new String("");
            String emailName=new String("");
            String filePathOfHeader=new String("");
            String filePathOfMessage=new String("");
            pookaHomePath=jTextField_emailPookaHomePath.getText();
            emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
            emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
            emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());
            filePathOfHeader=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_hdr";
            filePathOfMessage=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_msg";
            //System.out.println("filePathOfHeader: "+filePathOfHeader);
            //System.out.println("filePathOfMessage: "+filePathOfMessage);
            File fileOfHeader = new File(filePathOfHeader);
            File fileOfMessage = new File(filePathOfMessage);
            if (!fileOfHeader.exists() || !fileOfMessage.exists()) {
                JOptionPane.showMessageDialog(null, "Bu dizin seçilen eposta ile ilgili dosyalari içermemektedir.", "DİKKAT", JOptionPane.WARNING_MESSAGE);
                return;
            } 
            FileReader fileReaderOfHeader = new FileReader(fileOfHeader);
            FileReader fileReaderOfMessage = new FileReader(fileOfMessage);
            BufferedReader bufferedReaderOfHeader = new BufferedReader(fileReaderOfHeader);
            BufferedReader bufferedReaderOfMessage = new BufferedReader(fileReaderOfMessage);
            //StringBuilder stringBuilder = new StringBuilder();
            String line;
            //ArrayList<String> comboBoxItems=new ArrayList<String>();
            String bodyOfMessage=new String("");
            bodyOfMessage=displayBodyOfMessage(fileOfMessage);

            Properties props = System.getProperties();
            props.put("mail.host", "smtp.dummydomain.com");
            props.put("mail.transport.protocol", "smtp");

            Session mailSession = Session.getDefaultInstance(props, null);
            InputStream sourceOfHeader = new FileInputStream(fileOfHeader);
            InputStream sourceOfMessage = new FileInputStream(fileOfMessage);
            MimeMessage header = new MimeMessage(mailSession, sourceOfHeader);
            MimeMessage message = new MimeMessage(mailSession, sourceOfMessage);

            //System.out.println("jComboBox_emailAlani.getSelectedIndex():\n" + jComboBox_emailFieldList.getSelectedIndex());
            
            jTextArea_emailBilgisi.removeAll();
            jTextArea_emailBilgisi.setText("");
            /*
            Enumeration<String> enumerationOfAllHeaderLines=new Enumeration<String>();
            enumerationOfAllHeaderLines=message.getAllHeaderLines();
            HashMap<String,String> allHeaderLines=new HashMap<String, String>();
            while (enumerationOfAllHeaderLines.hasMoreElements()){
                System.out.println(enumerationOfAllHeaderLines.nextElement()+"\n");
            }
            */  
            StringTokenizer stringTokenizer=null;
            String emailAddress=null;
            switch (jComboBox_emailFieldList.getSelectedIndex()){
                case 0: // icerik metni
                    jTextArea_emailBilgisi.append(util.getTextFromMessage(message));
                    sharedItemsFromEmail.clear();
                    sharedItemsFromEmail.add(util.getTextFromMessage(message));
                    break;
                case 1: // baslik metni
                    jTextArea_emailBilgisi.append(message.getSubject());
                    sharedItemsFromEmail.clear();
                    sharedItemsFromEmail.add(message.getSubject());
                    break;
                case 2: // kimden eposta adresi
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("From", ", "));
                    sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("From", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            jTextArea_emailBilgisi.append(emailAddress+"\n");  
                            sharedItemsFromEmail.add(emailAddress);
                        }
                    }
                    break;
                case 3: // kime eposta adresi
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("To", ", "));
                    sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("To", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            jTextArea_emailBilgisi.append(emailAddress+"\n");
                            sharedItemsFromEmail.add(emailAddress);
                            //for(int i=0; i<emailAddress.length(); i++)
                            //    jTextArea_emailBilgisi.append((i+1)+". char code: "+(int)emailAddress.charAt(i)+"\n");
                        }
                    }
                    break;
                case 4: // eposta zaman bilgisi
                    //jTextArea_emailBilgisi.append(convertDateToString(message.getReceivedDate()));
                    jTextArea_emailBilgisi.append(message.getHeader("Date", ", "));
                    sharedItemsFromEmail.clear();
                    sharedItemsFromEmail.add(message.getHeader("Date", ", "));
                    break;
                case 5: // eposta ekler bilgisi
                    String contentType = message.getContentType(); 
                    String contentTypeOnly = new String(""); 
                    stringTokenizer=new StringTokenizer(contentType, ";");
                    String attachedFileName=new String("");
                    StringBuilder attachedFileNameNew=new StringBuilder();
                    sharedItemsFromEmail.clear();
                    if (contentType.contains("multipart")) {
                        // this message may contain attachment
                        contentTypeOnly=stringTokenizer.nextToken();
                        System.out.println("contentType: "+contentTypeOnly);
                        jTextArea_emailBilgisi.append("contentType: "+contentTypeOnly);
                        jTextArea_emailBilgisi.append("\n");
                        Multipart multiPart = (Multipart) message.getContent();
                        for (int i = 0; i < multiPart.getCount(); i++) {
                            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                                // this part is attachment
                                // save an attachment from a MimeBodyPart to a file
                                //System.out.println("attachment name: "+part.getFileName());
                                jTextArea_emailBilgisi.append(part.getFileName());
                                jTextArea_emailBilgisi.append("\n");
                                attachedFileName=part.getFileName();
                                char tempChar;
                                for(int j=0; j<attachedFileName.length(); j++){
                                    tempChar=attachedFileName.charAt(j);
                                    if (tempChar==32)
                                        tempChar='_';
                                    else if (tempChar>57 && tempChar<65)
                                        tempChar='_';
                                    if (!(tempChar>122) && !(tempChar<46))
                                        attachedFileNameNew.append(tempChar);
                                }
                                attachedFileName=attachedFileNameNew.toString();
                                sharedItemsFromEmail.add(attachedFileName);
                                //gerekli olursa attachmentlari asagidaki routinler ile diske kaydetmek mumkun oabilir.
                                // //String destFilePath = pookaHomePath+"\\attachments\\"+emailAccountName+"\\"+part.getFileName().hashCode()+".tmp";
                                // //System.out.println("destFilePath: "+destFilePath);
                                // //part.saveFile(destFilePath);
                                /*FileOutputStream output = new FileOutputStream(destFilePath);
                                InputStream input = part.getInputStream();
                                byte[] buffer = new byte[4096];
                                int byteRead;
                                while ((byteRead = input.read(buffer)) != -1) {
                                    output.write(buffer, 0, byteRead);
                                }
                                output.close();*/
                            }
                        }
                    }
                    break;
                case 6: // eposta tum icerikler
                    sharedItemsFromEmail.clear();
                    while ((line = bufferedReaderOfMessage.readLine()) != null) {
                        //comboBoxItems.add(line);
                        //stringBuilder.append(line);
                        //stringBuilder.append("\n");
                        jTextArea_emailBilgisi.append(line);
                        jTextArea_emailBilgisi.append("\n");
                        sharedItemsFromEmail.add(line);
                    }
                    bufferedReaderOfMessage.close();
                    break;
            }
        } catch (IOException e) {
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        } 
    }//GEN-LAST:event_jButton_Email_Alan_Bilgisini_GetirActionPerformed

    /**
     * satir nosu verilen JTextArea tipinde bir swing nesnesinino satir bilgisi
     * String tipinde geriye dondurulur.
     * @param jtextArea JTextArea tipinde swing nesnesinin parametre olarak verilmesi
     * @param lineNumber istenilen satirin numarasinin int tipinde parametre olarak verilmei
     * @return String tipinde geri donus degeri
     */
    public static String getLine(JTextArea jtextArea, int lineNumber){
        int startOffset, endOffset, totalLength;
        try{
            startOffset=jtextArea.getLineStartOffset(lineNumber);
            endOffset=jtextArea.getLineEndOffset(lineNumber);
            totalLength=endOffset-startOffset;
            return jtextArea.getText(startOffset, totalLength-1);
        }
        catch(Exception exp){
            exp.printStackTrace();
        }
        return null;
    }
    
    private void jButton_Kelimeleri_CozumleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Kelimeleri_CozumleActionPerformed
        
        Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
        
        String kelime=new String("");
        String cumle=new String(jTextArea_emailBilgisiCozumlenmis.getText());
        String ayrac=" ,;:.?_!/*-+()=[]{}&%'\"><@\n"; // " " gördükçe cümlemi kelimelere ayırsın istedigim için ayrac tanımladım

        StringTokenizer s=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
        //otomatik olarak java.util.StringTokenizer geldi bende,sizlerde import ediniz
        //System.out.println(s.countTokens()); //kaçkelimeden ,parcadan olustugunu verir bize*** 4
        jTextArea_emailBilgisiCozumlenmis.removeAll();
        jTextArea_emailBilgisiCozumlenmis.setText("");
        sharedWordsFromItem.clear();
        while(s.hasMoreTokens()){
                kelime=s.nextToken();
                kelime=kelime.trim();
                if (!kelime.equals("")){
                    if (zemberek.kelimeDenetle(kelime)){
                        Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                        //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                        Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                        System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                        jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                        jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");
                        jTextArea_emailBilgisiCozumlenmis.append("\n");
                        sharedWordsFromItem.add(cozumlenmisKok.icerik());
                        for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                            Kok kok = cozumlenmisKelime.kok();
                            System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                            List<Ek> ekler = cozumlenmisKelime.ekler();
                            if (ekler != null) {
                                System.out.println("Ekler:");
                                for (int j = 0; j < ekler.size(); j++) {
                                    Ek ek = ekler.get(j);
                                    System.out.println("Ek-" + j + " : " + ek.ad());
                                }
                            }
                        }
                        /*
                        String[] oneriler = zemberek.oner(kelime);
                        if (oneriler.length!=0) {
                            System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                            for (int i = 0; i < oneriler.length; i++) {
                                System.out.println("Öneri-" + " : " + oneriler[i]);
                            }
                            System.out.println();
                        }
                        */
                    }else{
                        jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                        jTextArea_emailBilgisiCozumlenmis.append("\n");
                    }
                }
        }
    }//GEN-LAST:event_jButton_Kelimeleri_CozumleActionPerformed

    private void jButton_Kelimeleri_BulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Kelimeleri_BulActionPerformed
        //StringTokenizer kullanımı
        //bir metnimiz olsun bunu belirlieğimiz parametreye göre kelimelere,parçalara ayırmak istiyorsak
        //kullanırız
        String kelime=new String("");
        String cumle=new String(jTextArea_emailBilgisi.getText());
        String ayrac=" ,;:.?_!/*-+()=[]{}&%'\"><@\n"; // " " gördükçe cümlemi kelimelere ayırsın istedigim için ayrac tanımladım

        StringTokenizer s=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
        //otomatik olarak java.util.StringTokenizer geldi bende,sizlerde import ediniz
        System.out.println(s.countTokens()); //kaçkelimeden ,parcadan olustugunu verir bize*** 4
        jTextArea_emailBilgisiCozumlenmis.removeAll();
        jTextArea_emailBilgisiCozumlenmis.setText("");

        while(s.hasMoreTokens()){
                kelime=s.nextToken();
                kelime=kelime.trim();
                if (!kelime.equals("")){
                    jTextArea_emailBilgisiCozumlenmis.append(kelime);
                    jTextArea_emailBilgisiCozumlenmis.append("\n");
                }
        }
        
    }//GEN-LAST:event_jButton_Kelimeleri_BulActionPerformed

    private void jButton_linkleriGetirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_linkleriGetirActionPerformed
        String cumle=new String(jTextArea_emailBilgisi.getText());
        cumle=cumle.replaceAll("=\n", "");
        cumle=cumle.replaceAll("=0A", "");
        cumle=cumle.replaceAll("<br>", "");
        cumle=cumle.replaceAll("</br>", "");
        /*
        //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        String html = new String(cumle);
        org.jsoup.nodes.Document doc = Jsoup.parse(html);
        org.jsoup.nodes.Element link = doc.select("a").first();

        //org.jsoup.nodes.Document doc = Jsoup.connect("http://jsoup.org").get();
        //org.jsoup.nodes.Element link = doc.select("a").first();
        String relHref = link.attr("href"); // == "/"
        String absHref = link.attr("abs:href"); // "http://jsoup.org/"

        String text = doc.body().text(); // "An example link"
        String linkHref = link.attr("href"); // "http://example.com/"
        String linkText = link.text(); // "example""

        String linkOuterH = link.outerHtml(); 
            // "<a href="http://example.com"><b>example</b></a>"
        String linkInnerH = link.html(); // "<b>example</b>"

        jTextArea_emailBilgisiCozumlenmis.append("linkHref: "+linkHref);
        jTextArea_emailBilgisiCozumlenmis.append("\n");
        */

        jTextArea_emailBilgisiCozumlenmis.removeAll();
        jTextArea_emailBilgisiCozumlenmis.setText("");
        
        List<String> extractedUrls = util.extractUrls(cumle);
        for (String url : extractedUrls)
        {
            jTextArea_emailBilgisiCozumlenmis.append("url: "+url);
            jTextArea_emailBilgisiCozumlenmis.append("\n");        
        }        

        List<String> extractedEmails = util.extractEmails(cumle);
        for (String email : extractedEmails)
        {
            jTextArea_emailBilgisiCozumlenmis.append("email: "+email);
            jTextArea_emailBilgisiCozumlenmis.append("\n");        
        }       
        // Parse your HTML:
        org.jsoup.nodes.Document doc = Jsoup.parse(cumle);

        // 1. From string:
        //org.jsoup.nodes.Document doc = JSoup.parse(htmlAsString);

        // 2. Or from an URL:
        //org.jsoup.nodes.Document doc = JSoup.connect("http://my.awesome.site.com/").get();

        // Then select images inside it:
        org.jsoup.select.Elements images = doc.select("img");

        // Then iterate
        //String tempStr=null;
        StringTokenizer stringTokenizer=null;
        for (org.jsoup.nodes.Element element : images) {
            String imageUrl = element.attr("src");
            //imageUrl=imageUrl.replaceAll("\"", "");
            //imageUrl=imageUrl.replaceAll("'\n", "");
            if (imageUrl.indexOf("'")!=-1 || imageUrl.indexOf("\"")!=-1){
                stringTokenizer=new StringTokenizer(imageUrl, "<> '\"");
                stringTokenizer.nextToken();
                imageUrl=new String(stringTokenizer.nextToken());
            }
            jTextArea_emailBilgisiCozumlenmis.append("image: "+imageUrl);
            jTextArea_emailBilgisiCozumlenmis.append("\n");        
        }
        // Then iterate
        /*org.jsoup.select.Elements images = doc.select("a");
        for (org.jsoup.nodes.Element element : images) {
            String Url = element.attr("href");
            jTextArea_emailBilgisiCozumlenmis.append("new URL: "+Url);
            jTextArea_emailBilgisiCozumlenmis.append("\n");        
            // TODO: Do something with the URL
        }
        String fileUrl = null;
        StringTokenizer stringTokenizer=new StringTokenizer(cumle, "<> '\"");
        while(stringTokenizer.hasMoreTokens()){
            fileUrl=new String(stringTokenizer.nextToken());
            //imageUrl=imageUrl.replaceAll("\"", "");
            //imageUrl=imageUrl.replaceAll("'\n", "");
            if (fileUrl.indexOf(".png")!=-1 || fileUrl.indexOf(".jpg")!=-1 || fileUrl.indexOf(".jpeg")!=-1 || fileUrl.indexOf(".gif")!=-1 || fileUrl.indexOf(".tif")!=-1 || fileUrl.indexOf(".bmp")!=-1){
                jTextArea_emailBilgisiCozumlenmis.append("image: "+fileUrl);
                jTextArea_emailBilgisiCozumlenmis.append("\n");        
            }
        }
        stringTokenizer=new StringTokenizer(cumle, "'\"");
        while(stringTokenizer.hasMoreTokens()){
            fileUrl=new String(stringTokenizer.nextToken());
            //imageUrl=imageUrl.replaceAll("\"", "");
            //imageUrl=imageUrl.replaceAll("'\n", "");
            if (fileUrl.indexOf(".php")!=-1 || fileUrl.indexOf(".asp")!=-1 || fileUrl.indexOf(".htm")!=-1 || fileUrl.indexOf(".jsp")!=-1 || fileUrl.indexOf(".doc")!=-1 || fileUrl.indexOf(".xls")!=-1 || fileUrl.indexOf(".pdf")!=-1 || fileUrl.indexOf(".rar")!=-1 || fileUrl.indexOf(".zip")!=-1){
                jTextArea_emailBilgisiCozumlenmis.append("file: "+fileUrl);
                jTextArea_emailBilgisiCozumlenmis.append("\n");        
            }
        }*/
    }//GEN-LAST:event_jButton_linkleriGetirActionPerformed

    /**
     * standart boyutlarda ve Result isminde tek tip baslik bilgisi iceren
     * bir mesaj kutusu penceresi olusturur ve ekrana gosterir.
     * @param msg String tipinde pencere icerigindeki mesaj 
     */
    private void createMessageBox(String msg)
    {
        createMessageBox(msg, "Result", 300, 200);
    }
    
    /**
     * standart boyutlarda bir mesaj kutusu penceresi olusturur ve ekrana gosterir.
     * @param msg String tipinde pencere icerigindeki mesaj 
     * @param title String tipinde pencere baslik bilgisi
     */
    private void createMessageBox(String msg, String title)
    {
        createMessageBox(msg, title, 300, 200);
    }
    
    /**
     * bir mesaj kutusu penceresi olusturur ve ekrana gosterir.
     * @param msg String tipinde pencere icerigindeki mesaj 
     * @param title String tipinde pencere baslik bilgisi
     * @param width int tipinde pencere genislik bilgisi
     * @param height int tipinde pencere yukseklik bilgisi 
     */
    private void createMessageBox(String msg, String title, int width, int height)
    {
            JFrame frame = new JFrame(title);
            JLabel lbl = new JLabel(msg);
            frame.add(lbl);
            frame.setSize(width, height);
            frame.setVisible(true);
    }

    /**
     * bu inner class her ne kadar projede kullanilmasa da dikkat edilmesi 
     * gereken sudur ki eger veritabaninda ucanaccess sınıfı ile ms access baglantida
     * eger veri formati uyumsuzlugu yasanirsa ucanaccess nesnesinin constructorında
     * bu classin instancei parametre olarak verilebilir.
     */
    public class JackcessWithCharsetW1254Opener implements JackcessOpenerInterface {
        public Database open(File f, String pwd) throws IOException {
            DatabaseBuilder db = new DatabaseBuilder(f);
            db.setCharset(Charset.forName("windows-1254"));
            try {
                db.setReadOnly(false);
                return db.open();
            } catch (IOException e) {
                db.setReadOnly(true);
                return db.open();
            }
       }
    }

    /**
     * cok ayrintili ve pek cok isi bir arada yapan bir metot olup, 
     * Pooka sistemine kayitli bir eposta hesap adi, eposta klasor bilgisi 
     * ve eposta dosya iism bilgileri verilerek bu eposta verisi iceren dosyanin
     * yani bu epostanin veritabanina kaydedilmesini gerceklestirir. bunu yaparken 
     * metot cok yonlu calisir ki tum parcalari ayri ayri ve Turkce kelime koklerini
     * de bularak veritabanina kayit islemi gerceklesir.
     * @param argEmailAccountName String tipinde email adresini iceren eposta hesap bilgisi
     * @param argEmailDirName String tipinde eposta hesabinin ilgili klasor bilgisi
     * @param argEmailFileName String tipinde epostayi iceren dosya ismi (dosya ismi _hdr veya _msg ile bitmelidir)
     * @return eger hata olusmaz ise true, aksi halde false bilgisi geriye dondurulur.
     */
    public boolean saveEmailToDB(String argEmailAccountName, String argEmailDirName, String argEmailFileName){
        String pookaHomePath=new String("");
        String emailAccountName=new String("");
        int emailAccountNameIdNo;
        String emailDirName=new String("");
        int emailDirNameIdNo;
        String emailName=new String("");
        String emailAccountNameTemp=new String("");
        String emailDirNameTemp=new String("");
        String emailNameTemp=new String("");
        String filePathOfHeader=new String("");
        String filePathOfMessage=new String("");
        ArrayList<String> itemList=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecords=null;
        String allToEmailAddressesIDNos=new String("");
        String allFromEmailAddressesIDNos=new String("");
        int emailAddressIDNo;
        String emailDateTime=new String("");
        String emailContentType=new String("");
        String allAttachedFileIDNos=new String("");
        int attachedFileIDNo;
        String urlIDNos=new String("");
        int urlIDNo;
        String emailIDNos=new String("");
        int emailIDNo=-1;
        String imageIDNos=new String("");
        int imageIDNo;
        HashSet<String> baglantilarIDNosSet=new HashSet<String>();
        String baglantilarIDNos=new String("");
        int wordIDNo=-1;
        int wordFrequency=0;
        HashMap<Integer,Integer> wordIDNosMap=new HashMap<Integer,Integer>();

        pookaHomePath=jTextField_emailPookaHomePath.getText();
        //emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        emailAccountName=argEmailAccountName;
        //emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
        emailDirName=argEmailDirName;
        //emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());
        emailName=argEmailFileName;
        filePathOfHeader=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_hdr";
        filePathOfMessage=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_msg";
        //System.out.println("filePathOfHeader: "+filePathOfHeader);
        //System.out.println("filePathOfMessage: "+filePathOfMessage);

        allRecords=getFieldsFromTable("[hesaplar]", 2);
        emailAccountNameIdNo=getIDNoOfRecord(allRecords, emailAccountName);
        System.out.println("emailAccountName: "+emailAccountName);
        System.out.println("emailAccountNameIdNo: "+emailAccountNameIdNo);
        allRecords=getFieldsFromTable("[hesapdizinleri]", 3);
        emailDirNameIdNo=getIDNoOfRecord(allRecords, String.valueOf(emailAccountNameIdNo), emailDirName);
        System.out.println("emailDirName: "+emailDirName);
        System.out.println("emailDirNameIdNo: "+emailDirNameIdNo);
        itemList.clear();
        try {
            File fileOfHeader = new File(filePathOfHeader);
            File fileOfMessage = new File(filePathOfMessage);
            if (fileOfHeader.exists() && !fileOfMessage.exists())
                fileOfMessage = new File(filePathOfHeader);
            else if (!fileOfHeader.exists() && fileOfMessage.exists())
                fileOfHeader = new File(filePathOfMessage);
            else if (!fileOfHeader.exists() && !fileOfMessage.exists()) {
                //JOptionPane.showMessageDialog(null, "Bu dizin seçilen eposta ile ilgili dosyalari içermemektedir.", "DİKKAT", JOptionPane.WARNING_MESSAGE);
                System.out.println("Hata!!! Hem header, hem mesaj dosyaalrı sistemde mevcut değldir.");
                return false;
            } 
            FileReader fileReaderOfHeader = new FileReader(fileOfHeader);
            FileReader fileReaderOfMessage = new FileReader(fileOfMessage);
            BufferedReader bufferedReaderOfHeader = new BufferedReader(fileReaderOfHeader);
            BufferedReader bufferedReaderOfMessage = new BufferedReader(fileReaderOfMessage);
            //StringBuilder stringBuilder = new StringBuilder();
            String line;
            //ArrayList<String> comboBoxItems=new ArrayList<String>();
            String bodyOfMessage=new String("");
            bodyOfMessage=displayBodyOfMessage(fileOfMessage);

            Properties props = System.getProperties();
            props.put("mail.host", "smtp.dummydomain.com");
            props.put("mail.transport.protocol", "smtp");

            Session mailSession = Session.getDefaultInstance(props, null);
            InputStream sourceOfHeader = new FileInputStream(fileOfHeader);
            InputStream sourceOfMessage = new FileInputStream(fileOfMessage);
            MimeMessage header = new MimeMessage(mailSession, sourceOfHeader);
            MimeMessage message = new MimeMessage(mailSession, sourceOfMessage);

            //System.out.println("jComboBox_emailAlani.getSelectedIndex():\n" + jComboBox_emailFieldList.getSelectedIndex());            
            
            StringTokenizer stringTokenizer=null;
            String emailAddress=null;
            allRecords=getFieldsFromTable("[epostalar]", 4);
            if (valueIsExistInList(allRecords, emailName, String.valueOf(emailAccountNameIdNo), String.valueOf(emailDirNameIdNo)))
                return false;
            //if (!valueIsExistInList(allRecords, emailName, String.valueOf(emailAccountNameIdNo), String.valueOf(emailDirNameIdNo)))
            else
            {
            // icerik metni
                    //jTextArea_emailBilgisi.append(util.getTextFromMessage(message));
                    //sharedItemsFromEmail.clear();
                    //sharedItemsFromEmail.add(util.getTextFromMessage(message));
                    String emailContent=util.getTextFromMessage(message);
                    emailContent=emailContent.trim();
            // baslik metni
                    //jTextArea_emailBilgisi.append(message.getSubject());
                    //sharedItemsFromEmail.clear();
                    //sharedItemsFromEmail.add(message.getSubject());
                    String emailTitle=header.getSubject();
                    emailTitle=emailTitle.trim();
            // kimden eposta adresi
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("From", ", "));
                    //sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("From", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            emailAddress=emailAddress.trim();
                            emailAddress=emailAddress.toLowerCase();
                            //jTextArea_emailBilgisi.append(emailAddress+"\n");  
                            //sharedItemsFromEmail.add(emailAddress);
                            allRecords=getFieldsFromTable("[epostaadresleri]", 2);
                            //System.out.println("allRecords: "+allRecords);
                            if (!valueIsExistInList(allRecords, emailAddress)){
                                try{
                                    sql = "INSERT INTO [epostaadresleri] ([adresler_eposta]) VALUES ('"+emailAddress+"');";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql3: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }
                            }
                            allRecords=getFieldsFromTable("[epostaadresleri]", 2);
                            emailAddressIDNo=getIDNoOfRecord(allRecords, String.valueOf(emailAccountNameIdNo));
                            if (emailAddressIDNo!=-1)
                                allFromEmailAddressesIDNos+=emailAddressIDNo+",";
                            System.out.println("allFromEmailAddressesIDNos: "+allFromEmailAddressesIDNos);
                        }
                    }
            // kime eposta adresi
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("To", ", "));
                    //sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("To", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            emailAddress=emailAddress.trim();
                            emailAddress=emailAddress.toLowerCase();
                            //jTextArea_emailBilgisi.append(emailAddress+"\n");
                            //sharedItemsFromEmail.add(emailAddress);
                            allRecords=getFieldsFromTable("[epostaadresleri]", 2);
                            //System.out.println("allRecords: "+allRecords);
                            if (!valueIsExistInList(allRecords, emailAddress)){
                                try{
                                    sql = "INSERT INTO [epostaadresleri] ([adresler_eposta]) VALUES ('"+emailAddress+"');";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql4: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }
                            }
                            allRecords=getFieldsFromTable("[epostaadresleri]", 2);
                            //System.out.println("allRecords: "+allRecords);
                            emailAddressIDNo=getIDNoOfRecord(allRecords, String.valueOf(emailAddress));
                            if (emailAddressIDNo!=-1)
                                allToEmailAddressesIDNos+=emailAddressIDNo+",";
                            System.out.println("allToEmailAddressIDNo: "+allToEmailAddressesIDNos);
                            //for(int i=0; i<emailAddress.length(); i++)
                            //    jTextArea_emailBilgisi.append((i+1)+". char code: "+(int)emailAddress.charAt(i)+"\n");
                        }
                    }
                    // eposta zaman bilgisi
                    //jTextArea_emailBilgisi.append(convertDateToString(message.getReceivedDate()));
                    //jTextArea_emailBilgisi.append(message.getHeader("Date", ", "));
                    //sharedItemsFromEmail.clear();
                    //sharedItemsFromEmail.add(message.getHeader("Date", ", "));
                    emailDateTime=message.getHeader("Date", ", ");
            // eposta ekler bilgisi
                    String attachedFileName;
                    StringBuilder attachedFileNameNew;
                    attachedFileNameNew=new StringBuilder();
                    String contentType = message.getContentType(); 
                    String contentTypeOnly = new String(""); 
                    stringTokenizer=new StringTokenizer(contentType, ";");
                    //sharedItemsFromEmail.clear();
                    if (contentType.contains("multipart")) {
                        // this message may contain attachment
                        contentTypeOnly=stringTokenizer.nextToken();
                        System.out.println("contentType: "+contentTypeOnly);
                        emailContentType=contentTypeOnly;
                        emailContentType=emailContentType.toLowerCase();
                        emailContentType=emailContentType.trim();
                        //jTextArea_emailBilgisi.append("contentType: "+contentTypeOnly);
                        //jTextArea_emailBilgisi.append("\n");
                        Multipart multiPart = (Multipart) message.getContent();
                        for (int i = 0; i < multiPart.getCount(); i++) {
                            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                                // this part is attachment
                                // save an attachment from a MimeBodyPart to a file
                                //System.out.println("attachment name: "+part.getFileName());
                                //jTextArea_emailBilgisi.append(part.getFileName());
                                //jTextArea_emailBilgisi.append("\n");
                                //sharedItemsFromEmail.add(part.getFileName());
                                attachedFileName=new String(part.getFileName());
                                attachedFileName=attachedFileName.toLowerCase();
                                attachedFileName=attachedFileName.trim();
                                char tempChar;
                                for(int j=0; j<attachedFileName.length(); j++){
                                    tempChar=attachedFileName.charAt(j);
                                    if (tempChar==32)
                                        tempChar='_';
                                    else if (tempChar>57 && tempChar<65)
                                        tempChar='_';
                                    if (!(tempChar>122) && !(tempChar<46))
                                        attachedFileNameNew.append(tempChar);
                                }
                                attachedFileName=attachedFileNameNew.toString();
                                //System.out.println("attachedFileName: "+attachedFileName);
                                allRecords=getFieldsFromTable("[ekler]", 2);
                                //System.out.println("allRecords: "+allRecords);
                                if (!valueIsExistInList(allRecords, attachedFileName)){
                                    try{
                                        sql = "INSERT INTO [ekler] ([ekler_dosyaadi]) VALUES ('"+attachedFileName+"');";
                                        statement = con.createStatement();
                                        statement.execute(sql);
                                        con.commit();
                                        statement.close();
                                        System.out.println("sql5: "+sql);
                                    }catch(Exception exp){
                                        exp.printStackTrace();
                                    }
                                }
                                allRecords=getFieldsFromTable("[ekler]", 2);
                                attachedFileIDNo=getIDNoOfRecord(allRecords, String.valueOf(attachedFileName));
                                if (attachedFileIDNo!=-1)
                                    allAttachedFileIDNos+=attachedFileIDNo+",";
                                System.out.println("allAttachedFileIDNos: "+allAttachedFileIDNos);
                                //gerekli olursa attachmentlari asagidaki routinler ile diske kaydetmek mumkun oabilir.
                                // //String destFilePath = pookaHomePath+"\\attachments\\"+emailAccountName+"\\"+part.getFileName().hashCode()+".tmp";
                                // //System.out.println("destFilePath: "+destFilePath);
                                // //part.saveFile(destFilePath);
                                /*FileOutputStream output = new FileOutputStream(destFilePath);
                                InputStream input = part.getInputStream();
                                byte[] buffer = new byte[4096];
                                int byteRead;
                                while ((byteRead = input.read(buffer)) != -1) {
                                    output.write(buffer, 0, byteRead);
                                }
                                output.close();*/
                            }
                        }
                    }
// tum email bilgisini veritabanina kaydetme
                    try{
                        emailTitle=emailTitle.replace("'", "\"");
                        emailContent=emailContent.replace("'", "\"");
                        emailContentType=emailContentType.replace("'", "\"");
                        //DateFormat emailDateTime = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
                        
                        //SimpleDateFormat dateFormat = new SimpleDateFormat("E, d M Y H:m:s Z");
                        //String stringDate = "12/2/2014 9:00 PM";
                        //bizde gelen zaman bilgisi emaillerden, "Thu, 24 Apr 2014 18:28:56 +0300"
                        //java.util.Date dateTime = dateFormat.parse(emailDateTime);
                        //System.out.println(dateFormat.format(cal.getTime()));
                        //System.out.println("dateFormat.parseObject(emailDateTime): "+dateFormat.parseObject(emailDateTime));
                        
                        com.joestelmach.natty.Parser parser = new com.joestelmach.natty.Parser();
                        List<DateGroup> groups = parser.parse(emailDateTime);
                        DateGroup dateGroupList=groups.get(0);
                        List<Date> dateList=dateGroupList.getDates();
                        Date emailDateTimeNew=dateList.get(0);
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        //String myString = DateFormat.getDateInstance().format(emailDateTimeNew, );
                        String emailDateTimeFormatted=new String("");
                        emailDateTimeFormatted=dateFormat.format(emailDateTimeNew);
                        System.out.println("emailDateTimeFormatted: "+emailDateTimeFormatted);

                        sql = "INSERT INTO [epostalar] ([epostalar_dosyano],"
                                + "[epostalar_hesapid],[epostalar_dizinid],[epostalar_baslik],[epostalar_iceriktipi],"
                                + "[epostalar_icerik],[epostalar_kimdenepostaid],[epostalar_kimeepostaid],[epostalar_zaman],"
                                + "[epostalar_eklerid],[epostalar_baglantilarid],[epostalar_spammi]) VALUES ('"
                                +emailName+"','"+emailAccountNameIdNo+"','"+emailDirNameIdNo+"','"+emailTitle+"','"+emailContentType+"','"+emailContent+"','"+allFromEmailAddressesIDNos+"','"+allToEmailAddressesIDNos
                                +"','"+emailDateTimeFormatted+"','"+allAttachedFileIDNos+"','"+baglantilarIDNos+"','0');";
                        
                        //java.sql.PreparedStatement ps  = con.prepareStatement(sql);
                        //ps.setTimestamp(1,new java.sql.Timestamp(date.getTime()));
                        System.out.println("sql9: "+sql);
                        statement = con.createStatement();
                        statement.execute(sql);
                        con.commit();
                        statement.close();
                    }catch(Exception exp){
                        exp.printStackTrace();
                    }                    
                    allRecords=getFieldsFromTable("[epostalar]", 4);
                    emailIDNo=getIDNoOfRecord(allRecords, emailName, String.valueOf(emailAccountNameIdNo), String.valueOf(emailDirNameIdNo));

// eposta icerik bilgisini tokenlerine ayirma, turkce olan kelime koklerini bulma ve veritabanina insert etme
                    Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());

                    Iterator iteratorWordIdNo;
                    Map.Entry entryOfWordIdNo;
                    String bulunanKokKelime=new String("");
                    String kelime=new String("");
                    String cumle;
                    StringTokenizer zemberekStringTokenizer;
                    String ayrac=" ,;:.?_!/*-+()=[]{}&%'\"><@\n"; // " " gördükçe cümlemi kelimelere ayırsın istedigim için ayrac tanımladım

                    cumle=new String(emailContent);
                    zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                    //otomatik olarak java.util.StringTokenizer geldi bende,sizlerde import ediniz
                    System.out.println(zemberekStringTokenizer.countTokens()); //kaçkelimeden ,parcadan olustugunu verir bize*** 4
                    //jTextArea_emailBilgisiCozumlenmis.removeAll();
                    //jTextArea_emailBilgisiCozumlenmis.setText("");
                    
                    //sharedWordsFromItem.clear();
                    wordIDNosMap.clear();
                    while(zemberekStringTokenizer.hasMoreTokens()){
                            kelime=zemberekStringTokenizer.nextToken();
                            kelime=kelime.trim();
                            if (!kelime.equals("")){
                                //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                if (zemberek.kelimeDenetle(kelime)){
                                    Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                    //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                    Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                    System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                    //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                    bulunanKokKelime=cozumlenmisKok.icerik();
                                    allRecords=getFieldsFromTable("[kelimeler]", 2);
                                    //System.out.println("allRecords: "+allRecords);
                                    if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                        try{
                                            sql = "INSERT INTO [kelimeler] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                            statement = con.createStatement();
                                            statement.execute(sql);
                                            con.commit();
                                            statement.close();
                                            System.out.println("sql5b: "+sql);
                                        }catch(Exception exp){
                                            exp.printStackTrace();
                                        }
                                    }
                                    allRecords=getFieldsFromTable("[kelimeler]", 2);
                                    wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                    if (wordIDNo!=-1){
                                        if (wordIDNosMap.containsKey(wordIDNo))
                                            wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                        else
                                            wordIDNosMap.put(wordIDNo,1);
                                    }
                                    
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                    //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                    for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                        Kok kok = cozumlenmisKelime.kok();
                                        System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                        List<Ek> ekler = cozumlenmisKelime.ekler();
                                        if (ekler != null) {
                                            System.out.println("Ekler:");
                                            for (int j = 0; j < ekler.size(); j++) {
                                                Ek ek = ekler.get(j);
                                                System.out.println("Ek-" + j + " : " + ek.ad());
                                            }
                                        }
                                    }
                                    /*
                                    String[] oneriler = zemberek.oner(kelime);
                                    if (oneriler.length!=0) {
                                        System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                        for (int i = 0; i < oneriler.length; i++) {
                                            System.out.println("Öneri-" + " : " + oneriler[i]);
                                        }
                                        System.out.println();
                                    }
                                    */
                                }else{
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                }

                            }
                    }
                    iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                    while(iteratorWordIdNo.hasNext()){
                    entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                    wordIDNo=(Integer)entryOfWordIdNo.getKey();
                    wordFrequency=(Integer)entryOfWordIdNo.getKey();
                    allRecords=getFieldsFromTable("[istatistikler_icerik]", 4);
                    //System.out.println("allRecords: "+allRecords);
                    if (!valueIsExistInList(allRecords, emailName, String.valueOf(wordIDNo))){
                        try{
                            sql = "INSERT INTO [istatistikler_icerik] ([istatistikler_icerik_dizinid], [istatistikler_icerik_epostaid], [istatistikler_icerik_kelimeid], [istatistikler_icerik_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql6: "+sql);
                        }catch(Exception exp){
                            exp.printStackTrace();
                        }
                    }else{
                        try{
                            sql = "DELETE FROM [istatistikler_icerik] WHERE [istatistikler_icerik_epostaid]="+String.valueOf(emailIDNo)+"[istatistikler_icerik_kelimeid]="+String.valueOf(wordIDNo)+";";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql5c: "+sql);
                            sql = "INSERT INTO [istatistikler_icerik] ([istatistikler_icerik_dizinid], [istatistikler_icerik_epostaid], [istatistikler_icerik_kelimeid], [istatistikler_icerik_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql5d: "+sql);
                        }catch(Exception exp){
                            exp.printStackTrace();
                        }                                        
                    }
                    }

// eposta baslik bilgisini tokenlerine ayirma, turkce olan kelime koklerini bulma ve veritabanina insert etme
                    cumle=new String(emailTitle);
                    zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                    //otomatik olarak java.util.StringTokenizer geldi bende,sizlerde import ediniz
                    System.out.println(zemberekStringTokenizer.countTokens()); //kaçkelimeden ,parcadan olustugunu verir bize*** 4
                    //jTextArea_emailBilgisiCozumlenmis.removeAll();
                    //jTextArea_emailBilgisiCozumlenmis.setText("");
                    
                    //sharedWordsFromItem.clear();
                    wordIDNosMap.clear();
                    while(zemberekStringTokenizer.hasMoreTokens()){
                            kelime=zemberekStringTokenizer.nextToken();
                            kelime=kelime.trim();
                            if (!kelime.equals("")){
                                //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                if (zemberek.kelimeDenetle(kelime)){
                                    Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                    //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                    Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                    System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                    //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                    bulunanKokKelime=cozumlenmisKok.icerik();
                                    allRecords=getFieldsFromTable("[kelimeler]", 2);
                                    //System.out.println("allRecords: "+allRecords);
                                    if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                        try{
                                            sql = "INSERT INTO [kelimeler] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                            statement = con.createStatement();
                                            statement.execute(sql);
                                            con.commit();
                                            statement.close();
                                            System.out.println("sql5b: "+sql);
                                        }catch(Exception exp){
                                            exp.printStackTrace();
                                        }
                                    }
                                    allRecords=getFieldsFromTable("[kelimeler]", 2);
                                    wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                    if (wordIDNo!=-1){
                                        if (wordIDNosMap.containsKey(wordIDNo))
                                            wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                        else
                                            wordIDNosMap.put(wordIDNo,1);
                                    }
                                    
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                    //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                    for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                        Kok kok = cozumlenmisKelime.kok();
                                        System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                        List<Ek> ekler = cozumlenmisKelime.ekler();
                                        if (ekler != null) {
                                            System.out.println("Ekler:");
                                            for (int j = 0; j < ekler.size(); j++) {
                                                Ek ek = ekler.get(j);
                                                System.out.println("Ek-" + j + " : " + ek.ad());
                                            }
                                        }
                                    }
                                    /*
                                    String[] oneriler = zemberek.oner(kelime);
                                    if (oneriler.length!=0) {
                                        System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                        for (int i = 0; i < oneriler.length; i++) {
                                            System.out.println("Öneri-" + " : " + oneriler[i]);
                                        }
                                        System.out.println();
                                    }
                                    */
                                }else{
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                }

                            }
                    }
                    iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                    while(iteratorWordIdNo.hasNext()){
                    entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                    wordIDNo=(Integer)entryOfWordIdNo.getKey();
                    wordFrequency=(Integer)entryOfWordIdNo.getKey();
                    allRecords=getFieldsFromTable("[istatistikler_baslik]", 4);
                    //System.out.println("allRecords: "+allRecords);
                    if (!valueIsExistInList(allRecords, emailName, String.valueOf(wordIDNo))){
                        try{
                            sql = "INSERT INTO [istatistikler_baslik] ([istatistikler_baslik_dizinid], [istatistikler_baslik_epostaid], [istatistikler_baslik_kelimeid], [istatistikler_baslik_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql6: "+sql);
                        }catch(Exception exp){
                            exp.printStackTrace();
                        }
                    }else{
                        try{
                            sql = "DELETE FROM [istatistikler_baslik] WHERE [istatistikler_baslik_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_icerik_kelimeid]="+String.valueOf(wordIDNo)+";";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql5c: "+sql);
                            sql = "INSERT INTO [istatistikler_baslik] ([istatistikler_baslik_dizinid], [istatistikler_baslik_epostaid], [istatistikler_baslik_kelimeid], [istatistikler_baslik_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                            statement = con.createStatement();
                            statement.execute(sql);
                            con.commit();
                            statement.close();
                            System.out.println("sql5d: "+sql);
                        }catch(Exception exp){
                            exp.printStackTrace();
                        }                                        
                    }
                    }
                    
// eposta kimden bilgisini tokenlerine ayirma, turkce olan kelime koklerini bulma ve veritabanina insert etme
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("From", ", "));
                    //sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("From", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            emailAddress=emailAddress.trim();
                            emailAddress=emailAddress.toLowerCase();

                            //sharedWordsFromItem.clear();
                            wordIDNosMap.clear();
                            cumle=new String(emailAddress);
                            zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                            while(zemberekStringTokenizer.hasMoreTokens()){
                                    kelime=zemberekStringTokenizer.nextToken();
                                    kelime=kelime.trim();
                                    if (!kelime.equals("")){
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                        if (zemberek.kelimeDenetle(kelime)){
                                            Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                            //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                            Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                            System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                            //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                            //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                            bulunanKokKelime=cozumlenmisKok.icerik();
                                            allRecords=getFieldsFromTable("[kelimeler]", 2);
                                            //System.out.println("allRecords: "+allRecords);
                                            if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                                try{
                                                    sql = "INSERT INTO [kelimeler] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                    statement = con.createStatement();
                                                    statement.execute(sql);
                                                    con.commit();
                                                    statement.close();
                                                    System.out.println("sql5b: "+sql);
                                                }catch(Exception exp){
                                                    exp.printStackTrace();
                                                }
                                            }
                                            allRecords=getFieldsFromTable("[kelimeler]", 2);
                                            wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                            if (wordIDNo!=-1){
                                                if (wordIDNosMap.containsKey(wordIDNo))
                                                    wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                                else
                                                    wordIDNosMap.put(wordIDNo,1);
                                            }

                                            //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                            //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                            for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                                Kok kok = cozumlenmisKelime.kok();
                                                System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                                List<Ek> ekler = cozumlenmisKelime.ekler();
                                                if (ekler != null) {
                                                    System.out.println("Ekler:");
                                                    for (int j = 0; j < ekler.size(); j++) {
                                                        Ek ek = ekler.get(j);
                                                        System.out.println("Ek-" + j + " : " + ek.ad());
                                                    }
                                                }
                                            }
                                            /*
                                            String[] oneriler = zemberek.oner(kelime);
                                            if (oneriler.length!=0) {
                                                System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                                for (int i = 0; i < oneriler.length; i++) {
                                                    System.out.println("Öneri-" + " : " + oneriler[i]);
                                                }
                                                System.out.println();
                                            }
                                            */
                                        }else{
                                            //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                            //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                        }

                                    }
                            }
                            iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                            while(iteratorWordIdNo.hasNext()){
                            entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                            wordIDNo=(Integer)entryOfWordIdNo.getKey();
                            wordFrequency=(Integer)entryOfWordIdNo.getKey();
                            allRecords=getFieldsFromTable("[istatistikler_kimden]", 4);
                            //System.out.println("allRecords: "+allRecords);
                            if (!valueIsExistInList(allRecords, emailName, String.valueOf(wordIDNo))){
                                try{
                                    sql = "INSERT INTO [istatistikler_kimden] ([istatistikler_kimden_dizinid], [istatistikler_kimden_epostaid], [istatistikler_kimden_kelimeid], [istatistikler_kimden_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql6: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }
                            }else{
                                try{
                                    sql = "DELETE FROM [istatistikler_kimden] WHERE [istatistikler_kimden_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_kimden_kelimeid]="+String.valueOf(wordIDNo)+";";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql5c: "+sql);
                                    sql = "INSERT INTO [istatistikler_kimden] ([istatistikler_kimden_dizinid], [istatistikler_kimden_epostaid], [istatistikler_kimden_kelimeid], [istatistikler_kimden_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql5d: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }                                        
                            }
                            }
                            
                        }
                    }

// eposta kime bilgisini tokenlerine ayirma, turkce olan kelime koklerini bulma ve veritabanina insert etme
                    //jTextArea_emailBilgisi.append(message.getFrom().toString());
                    //jTextArea_emailBilgisi.append(message.getHeader("From", ", "));
                    //sharedItemsFromEmail.clear();
                    stringTokenizer=new StringTokenizer(message.getHeader("To", ", "),"<> ,;");
                    while(stringTokenizer.hasMoreTokens()){
                        emailAddress=new String(stringTokenizer.nextToken());
                        emailAddress=emailAddress.replaceAll("\"", "");
                        emailAddress=emailAddress.replaceAll("'\n", "");
                        if (emailAddress.indexOf("@")!=-1){
                            emailAddress=emailAddress.trim();
                            emailAddress=emailAddress.toLowerCase();

                            //sharedWordsFromItem.clear();
                            wordIDNosMap.clear();
                            cumle=new String(emailAddress);
                            zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                            while(zemberekStringTokenizer.hasMoreTokens()){
                                    kelime=zemberekStringTokenizer.nextToken();
                                    kelime=kelime.trim();
                                    if (!kelime.equals("")){
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                        if (zemberek.kelimeDenetle(kelime)){
                                            Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                            //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                            Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                            System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                            //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                            //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                            bulunanKokKelime=cozumlenmisKok.icerik();
                                            allRecords=getFieldsFromTable("[kelimeler]", 2);
                                            //System.out.println("allRecords: "+allRecords);
                                            if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                                try{
                                                    sql = "INSERT INTO [kelimeler] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                    statement = con.createStatement();
                                                    statement.execute(sql);
                                                    con.commit();
                                                    statement.close();
                                                    System.out.println("sql5e2: "+sql);
                                                }catch(Exception exp){
                                                    exp.printStackTrace();
                                                }
                                            }
                                            allRecords=getFieldsFromTable("[kelimeler]", 2);
                                            wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                            if (wordIDNo!=-1){
                                                if (wordIDNosMap.containsKey(wordIDNo))
                                                    wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                                else
                                                    wordIDNosMap.put(wordIDNo,1);
                                            }

                                            //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                            //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                            for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                                Kok kok = cozumlenmisKelime.kok();
                                                System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                                List<Ek> ekler = cozumlenmisKelime.ekler();
                                                if (ekler != null) {
                                                    System.out.println("Ekler:");
                                                    for (int j = 0; j < ekler.size(); j++) {
                                                        Ek ek = ekler.get(j);
                                                        System.out.println("Ek-" + j + " : " + ek.ad());
                                                    }
                                                }
                                            }
                                            /*
                                            String[] oneriler = zemberek.oner(kelime);
                                            if (oneriler.length!=0) {
                                                System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                                for (int i = 0; i < oneriler.length; i++) {
                                                    System.out.println("Öneri-" + " : " + oneriler[i]);
                                                }
                                                System.out.println();
                                            }
                                            */
                                        }else{
                                            //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                            //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                        }

                                    }
                            }
                            iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                            while(iteratorWordIdNo.hasNext()){
                            entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                            wordIDNo=(Integer)entryOfWordIdNo.getKey();
                            wordFrequency=(Integer)entryOfWordIdNo.getKey();
                            allRecords=getFieldsFromTable("[istatistikler_ekler_kelime]", 4);
                            //System.out.println("allRecords: "+allRecords);
                            if (!valueIsExistInList(allRecords, emailName, String.valueOf(wordIDNo))){
                                try{
                                    sql = "INSERT INTO [istatistikler_ekler_kelime] ([istatistikler_ekler_kelime_dizinid], [istatistikler_ekler_kelime_epostaid], [istatistikler_ekler_kelime_kelimeid], [istatistikler_ekler_kelime_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql5f2: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }
                            }else{
                                try{
                                    sql = "DELETE FROM [istatistikler_ekler_kelime] WHERE [istatistikler_ekler_kelime_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_ekler_kelime_kelimeid]="+String.valueOf(wordIDNo)+";";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql5g2: "+sql);
                                    sql = "INSERT INTO [istatistikler_ekler_kelime] ([istatistikler_ekler_kelime_dizinid], [istatistikler_ekler_kelime_epostaid], [istatistikler_ekler_kelime_kelimeid], [istatistikler_ekler_kelime_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+","+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                    statement = con.createStatement();
                                    statement.execute(sql);
                                    con.commit();
                                    statement.close();
                                    System.out.println("sql5h2: "+sql);
                                }catch(Exception exp){
                                    exp.printStackTrace();
                                }                                        
                            }
                            }
                            
                        }
                    }

// eposta ekler bilgisini tokenlerine ayirma, turkce olan kelime koklerini bulma ve veritabanina insert etme
                    contentType = message.getContentType(); 
                    stringTokenizer=new StringTokenizer(contentType, ";");
                    //sharedItemsFromEmail.clear();
                    if (contentType.contains("multipart")) {
                        // this message may contain attachment
                        contentTypeOnly=stringTokenizer.nextToken();
                        System.out.println("contentType: "+contentTypeOnly);
                        emailContentType=contentTypeOnly;
                        emailContentType=emailContentType.toLowerCase();
                        emailContentType=emailContentType.trim();
                        //jTextArea_emailBilgisi.append("contentType: "+contentTypeOnly);
                        //jTextArea_emailBilgisi.append("\n");
                        Multipart multiPart = (Multipart) message.getContent();
                        for (int i = 0; i < multiPart.getCount(); i++) {
                            MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
                            if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
                                // this part is attachment
                                // save an attachment from a MimeBodyPart to a file
                                //System.out.println("attachment name: "+part.getFileName());
                                //jTextArea_emailBilgisi.append(part.getFileName());
                                //jTextArea_emailBilgisi.append("\n");
                                //sharedItemsFromEmail.add(part.getFileName());
                                attachedFileName=new String(part.getFileName());
                                attachedFileName=attachedFileName.toLowerCase();
                                attachedFileName=attachedFileName.trim();
                                char tempChar;
                                for(int j=0; j<attachedFileName.length(); j++){
                                    tempChar=attachedFileName.charAt(j);
                                    if (tempChar==32)
                                        tempChar='_';
                                    else if (tempChar>57 && tempChar<65)
                                        tempChar='_';
                                    if (!(tempChar>122) && !(tempChar<46))
                                        attachedFileNameNew.append(tempChar);
                                }
                                attachedFileName=attachedFileNameNew.toString();
                                //System.out.println("attachedFileName: "+attachedFileName);
                                allRecords=getFieldsFromTable("[ekler]", 2);
                                //System.out.println("allRecords: "+allRecords);
                                if (!valueIsExistInList(allRecords, attachedFileName)){
                                    try{
                                        sql = "INSERT INTO [ekler] ([ekler_dosyaadi]) VALUES ('"+attachedFileName+"');";
                                        statement = con.createStatement();
                                        statement.execute(sql);
                                        con.commit();
                                        statement.close();
                                        System.out.println("sql5: "+sql);
                                    }catch(Exception exp){
                                        exp.printStackTrace();
                                    }
                                }
                                allRecords=getFieldsFromTable("[ekler]", 2);
                                attachedFileIDNo=getIDNoOfRecord(allRecords, String.valueOf(attachedFileName));
                                if (attachedFileIDNo!=-1)
                                    allAttachedFileIDNos+=attachedFileIDNo+",";
                                System.out.println("allAttachedFileIDNos: "+allAttachedFileIDNos);
                                allRecords=getFieldsFromTable("[istatistikler_ekler]", 3);
                                //System.out.println("allRecords: "+allRecords);
                                if (!valueIsExistInList(allRecords, String.valueOf(attachedFileIDNo))){
                                    try{
                                        sql = "INSERT INTO [istatistikler_ekler] ([istatistikler_ekler_epostaid], [istatistikler_ekler_eklerid]) VALUES ("+String.valueOf(emailIDNo)+","+String.valueOf(attachedFileIDNo)+");";
                                        statement = con.createStatement();
                                        statement.execute(sql);
                                        con.commit();
                                        statement.close();
                                        System.out.println("sql5: "+sql);
                                    }catch(Exception exp){
                                        exp.printStackTrace();
                                    }
                                }
                                allRecords=getFieldsFromTable("[istatistikler_ekler]", 3);
                                attachedFileIDNo=getIDNoOfRecord(allRecords, String.valueOf(attachedFileName));
                                //gerekli olursa attachmentlari asagidaki routinler ile diske kaydetmek mumkun oabilir.
                                // //String destFilePath = pookaHomePath+"\\attachments\\"+emailAccountName+"\\"+part.getFileName().hashCode()+".tmp";
                                // //System.out.println("destFilePath: "+destFilePath);
                                // //part.saveFile(destFilePath);
                                /*FileOutputStream output = new FileOutputStream(destFilePath);
                                InputStream input = part.getInputStream();
                                byte[] buffer = new byte[4096];
                                int byteRead;
                                while ((byteRead = input.read(buffer)) != -1) {
                                    output.write(buffer, 0, byteRead);
                                }
                                output.close();*/

                                //sharedWordsFromItem.clear();
                                wordIDNosMap.clear();
                                cumle=new String(attachedFileName);
                                zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                                while(zemberekStringTokenizer.hasMoreTokens()){
                                        kelime=zemberekStringTokenizer.nextToken();
                                        kelime=kelime.trim();
                                        if (!kelime.equals("")){
                                            //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                            //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                            if (zemberek.kelimeDenetle(kelime)){
                                                Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                                //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                                Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                                System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                                //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                                //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                                bulunanKokKelime=cozumlenmisKok.icerik();
                                                allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                                //System.out.println("allRecords: "+allRecords);
                                                if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                                    try{
                                                        sql = "INSERT INTO [kelimeler_ekler_ve_baglantilar] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                        statement = con.createStatement();
                                                        statement.execute(sql);
                                                        con.commit();
                                                        statement.close();
                                                        System.out.println("sql5e1: "+sql);
                                                    }catch(Exception exp){
                                                        exp.printStackTrace();
                                                    }
                                                }
                                                allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                                wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                                if (wordIDNo!=-1){
                                                    if (wordIDNosMap.containsKey(wordIDNo))
                                                        wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                                    else
                                                        wordIDNosMap.put(wordIDNo,1);
                                                }

                                                //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                                //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                                for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                                    Kok kok = cozumlenmisKelime.kok();
                                                    System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                                    List<Ek> ekler = cozumlenmisKelime.ekler();
                                                    if (ekler != null) {
                                                        System.out.println("Ekler:");
                                                        for (int j = 0; j < ekler.size(); j++) {
                                                            Ek ek = ekler.get(j);
                                                            System.out.println("Ek-" + j + " : " + ek.ad());
                                                        }
                                                    }
                                                }
                                                /*
                                                String[] oneriler = zemberek.oner(kelime);
                                                if (oneriler.length!=0) {
                                                    System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                                    for (int i = 0; i < oneriler.length; i++) {
                                                        System.out.println("Öneri-" + " : " + oneriler[i]);
                                                    }
                                                    System.out.println();
                                                }
                                                */
                                            }else{
                                                //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                                //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                            }

                                        }
                                }

                            }
                        }
                    }
                    
                // eposta tum icerikler
                    cumle=new String(emailContent);
                    //sharedItemsFromEmail.clear();
                    /*while ((line = bufferedReaderOfMessage.readLine()) != null) {
                        //comboBoxItems.add(line);
                        //stringBuilder.append(line);
                        //stringBuilder.append("\n");
                        jTextArea_emailBilgisi.append(line);
                        jTextArea_emailBilgisi.append("\n");
                        sharedItemsFromEmail.add(line);
                        cumle=cumle+line;
                    }
                    bufferedReaderOfMessage.close();*/
                // eposta icerilen tum linkler (url, email, image)
                    //String cumle=new String(jTextArea_emailBilgisi.getText());
                    //String cumle=new String(emailContent);
                    cumle=cumle.replaceAll("=\n", "");
                    cumle=cumle.replaceAll("=0A", "");
                    cumle=cumle.replaceAll("<br>", "");
                    cumle=cumle.replaceAll("</br>", "");
                    /*
                    //String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
                    String html = new String(cumle);
                    org.jsoup.nodes.Document doc = Jsoup.parse(html);
                    org.jsoup.nodes.Element link = doc.select("a").first();

                    //org.jsoup.nodes.Document doc = Jsoup.connect("http://jsoup.org").get();
                    //org.jsoup.nodes.Element link = doc.select("a").first();
                    String relHref = link.attr("href"); // == "/"
                    String absHref = link.attr("abs:href"); // "http://jsoup.org/"

                    String text = doc.body().text(); // "An example link"
                    String linkHref = link.attr("href"); // "http://example.com/"
                    String linkText = link.text(); // "example""

                    String linkOuterH = link.outerHtml(); 
                        // "<a href="http://example.com"><b>example</b></a>"
                    String linkInnerH = link.html(); // "<b>example</b>"

                    jTextArea_emailBilgisiCozumlenmis.append("linkHref: "+linkHref);
                    jTextArea_emailBilgisiCozumlenmis.append("\n");
                    */

                    //jTextArea_emailBilgisiCozumlenmis.removeAll();
                    //jTextArea_emailBilgisiCozumlenmis.setText("");

                    List<String> extractedUrls = util.extractUrls(cumle);
                    for (String url : extractedUrls)
                    {
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, "url", url)){
                            try{
                                sql = "INSERT INTO [baglantilar] ([baglantilar_urltipi], [baglantilar_url]) VALUES ('url','"+url+"');";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql6: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        urlIDNo=getIDNoOfRecord(allRecords, "url", url);
                        if (urlIDNo!=-1){
                            urlIDNos+=urlIDNo+",";
                            baglantilarIDNosSet.add(String.valueOf(urlIDNo));
                        }
                        System.out.println("urlIDNos: "+urlIDNos);
                        //jTextArea_emailBilgisiCozumlenmis.append("url: "+url);
                        //jTextArea_emailBilgisiCozumlenmis.append("\n");        

                        sharedWordsFromItem.clear();
                        wordIDNosMap.clear();
                        cumle=new String(url);
                        zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                        while(zemberekStringTokenizer.hasMoreTokens()){
                                kelime=zemberekStringTokenizer.nextToken();
                                kelime=kelime.trim();
                                if (!kelime.equals("")){
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                    if (zemberek.kelimeDenetle(kelime)){
                                        Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                        //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                        Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                        System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                        //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                        bulunanKokKelime=cozumlenmisKok.icerik();
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        //System.out.println("allRecords: "+allRecords);
                                        if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                            try{
                                                sql = "INSERT INTO [kelimeler_ekler_ve_baglantilar] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                statement = con.createStatement();
                                                statement.execute(sql);
                                                con.commit();
                                                statement.close();
                                                System.out.println("sql5e: "+sql);
                                            }catch(Exception exp){
                                                exp.printStackTrace();
                                            }
                                        }
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                        if (wordIDNo!=-1){
                                            if (wordIDNosMap.containsKey(wordIDNo))
                                                wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                            else
                                                wordIDNosMap.put(wordIDNo,1);
                                        }

                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                        //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                        for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                            Kok kok = cozumlenmisKelime.kok();
                                            System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                            List<Ek> ekler = cozumlenmisKelime.ekler();
                                            if (ekler != null) {
                                                System.out.println("Ekler:");
                                                for (int j = 0; j < ekler.size(); j++) {
                                                    Ek ek = ekler.get(j);
                                                    System.out.println("Ek-" + j + " : " + ek.ad());
                                                }
                                            }
                                        }
                                        /*
                                        String[] oneriler = zemberek.oner(kelime);
                                        if (oneriler.length!=0) {
                                            System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                            for (int i = 0; i < oneriler.length; i++) {
                                                System.out.println("Öneri-" + " : " + oneriler[i]);
                                            }
                                            System.out.println();
                                        }
                                        */
                                    }else{
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                    }

                                }
                        }
                        iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                        while(iteratorWordIdNo.hasNext()){
                        entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                        wordIDNo=(Integer)entryOfWordIdNo.getKey();
                        wordFrequency=(Integer)entryOfWordIdNo.getKey();
                        allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, emailName, "url", String.valueOf(wordIDNo))){
                            try{
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_dizinid], istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_baglantilar_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+",'url',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5i: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }else{
                            try{
                                sql = "DELETE FROM [istatistikler_baglantilar] WHERE [istatistikler_baglantilar_urltipi]='url' AND [istatistikler_baglantilar_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_baglantilar_kelimeid]="+String.valueOf(wordIDNo)+";";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5j: "+sql);
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_dizinid], istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_baglantilar_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+",'url',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5k: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }                                        
                        }
                        }

                    }        
                    List<String> extractedEmails = util.extractEmails(cumle);
                    for (String email : extractedEmails)
                    {
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, "email", email)){
                            try{
                                sql = "INSERT INTO [baglantilar] ([baglantilar_urltipi], [baglantilar_url]) VALUES ('email','"+email+"');";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql7: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        emailIDNo=getIDNoOfRecord(allRecords, "email", email);
                        if (emailIDNo!=-1){
                            emailIDNos+=emailIDNo+",";
                            baglantilarIDNosSet.add(String.valueOf(emailIDNo));
                        }
                        System.out.println("emailIDNos: "+emailIDNos);
                        //jTextArea_emailBilgisiCozumlenmis.append("email: "+email);
                        //jTextArea_emailBilgisiCozumlenmis.append("\n");        

                        //sharedWordsFromItem.clear();
                        wordIDNosMap.clear();
                        cumle=new String(email);
                        zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                        while(zemberekStringTokenizer.hasMoreTokens()){
                                kelime=zemberekStringTokenizer.nextToken();
                                kelime=kelime.trim();
                                if (!kelime.equals("")){
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                    if (zemberek.kelimeDenetle(kelime)){
                                        Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                        //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                        Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                        System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                        //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                        bulunanKokKelime=cozumlenmisKok.icerik();
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        //System.out.println("allRecords: "+allRecords);
                                        if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                            try{
                                                sql = "INSERT INTO [kelimeler_ekler_ve_baglantilar] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                statement = con.createStatement();
                                                statement.execute(sql);
                                                con.commit();
                                                statement.close();
                                                System.out.println("sql5e: "+sql);
                                            }catch(Exception exp){
                                                exp.printStackTrace();
                                            }
                                        }
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                        if (wordIDNo!=-1){
                                            if (wordIDNosMap.containsKey(wordIDNo))
                                                wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                            else
                                                wordIDNosMap.put(wordIDNo,1);
                                        }

                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                        //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                        for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                            Kok kok = cozumlenmisKelime.kok();
                                            System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                            List<Ek> ekler = cozumlenmisKelime.ekler();
                                            if (ekler != null) {
                                                System.out.println("Ekler:");
                                                for (int j = 0; j < ekler.size(); j++) {
                                                    Ek ek = ekler.get(j);
                                                    System.out.println("Ek-" + j + " : " + ek.ad());
                                                }
                                            }
                                        }
                                        /*
                                        String[] oneriler = zemberek.oner(kelime);
                                        if (oneriler.length!=0) {
                                            System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                            for (int i = 0; i < oneriler.length; i++) {
                                                System.out.println("Öneri-" + " : " + oneriler[i]);
                                            }
                                            System.out.println();
                                        }
                                        */
                                    }else{
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                    }

                                }
                        }
                        iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                        while(iteratorWordIdNo.hasNext()){
                        entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                        wordIDNo=(Integer)entryOfWordIdNo.getKey();
                        wordFrequency=(Integer)entryOfWordIdNo.getKey();
                        allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, emailName, "email", String.valueOf(wordIDNo))){
                            try{
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_dizinid], istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_kime_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+",'email',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5i: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }else{
                            try{
                                sql = "DELETE FROM [istatistikler_baglantilar] WHERE [istatistikler_baglantilar_urltipi]='email' AND [istatistikler_baglantilar_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_baglantilar_kelimeid]="+String.valueOf(wordIDNo)+";";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5j: "+sql);
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_dizinid], istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_kime_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+",'email',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5k: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }                                        
                        }
                        }

                    }       
                    // Parse your HTML:
                    org.jsoup.nodes.Document doc = Jsoup.parse(cumle);

                    // 1. From string:
                    //org.jsoup.nodes.Document doc = JSoup.parse(htmlAsString);

                    // 2. Or from an URL:
                    //org.jsoup.nodes.Document doc = JSoup.connect("http://my.awesome.site.com/").get();

                    // Then select images inside it:
                    org.jsoup.select.Elements images = doc.select("img");

                    // Then iterate
                    //String tempStr=null;
                    //StringTokenizer stringTokenizer=null;
                    for (org.jsoup.nodes.Element element : images) {
                        String imageUrl = element.attr("src");
                        //imageUrl=imageUrl.replaceAll("\"", "");
                        //imageUrl=imageUrl.replaceAll("'\n", "");
                        if (imageUrl.indexOf("'")!=-1 || imageUrl.indexOf("\"")!=-1){
                            stringTokenizer=new StringTokenizer(imageUrl, "<> '\"");
                            stringTokenizer.nextToken();
                            imageUrl=new String(stringTokenizer.nextToken());
                        }
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, "image", imageUrl)){
                            try{
                                sql = "INSERT INTO [baglantilar] ([baglantilar_urltipi], [baglantilar_url]) VALUES ('image','"+imageUrl+"');";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql8: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }
                        allRecords=getFieldsFromTable("[baglantilar]", 3);
                        imageIDNo=getIDNoOfRecord(allRecords, "image", imageUrl);
                        if (imageIDNo!=-1){
                            imageIDNos+=imageIDNo+",";
                            baglantilarIDNosSet.add(String.valueOf(imageIDNo));
                        }
                        System.out.println("imageIDNos: "+imageIDNos);
                        //jTextArea_emailBilgisiCozumlenmis.append("image: "+imageUrl);
                        //jTextArea_emailBilgisiCozumlenmis.append("\n");        

                        //sharedWordsFromItem.clear();
                        wordIDNosMap.clear();
                        cumle=new String(imageUrl);
                        zemberekStringTokenizer=new StringTokenizer(cumle,ayrac);//parametre olarak cümle ve ayracımızı verdik
                        while(zemberekStringTokenizer.hasMoreTokens()){
                                kelime=zemberekStringTokenizer.nextToken();
                                kelime=kelime.trim();
                                if (!kelime.equals("")){
                                    //jTextArea_emailBilgisiCozumlenmis.append(kelime);
                                    //jTextArea_emailBilgisiCozumlenmis.append("\n");

                                    if (zemberek.kelimeDenetle(kelime)){
                                        Kelime[] cozumlenmisSonuc = zemberek.kelimeCozumle(kelime);
                                        //Kok cozumlenmisKok = (Kok) zemberek.dilBilgisi().kokler().kokBul(kelime).get(0);
                                        Kok cozumlenmisKok = cozumlenmisSonuc[0].kok();
                                        System.out.println("Oluşan çözümleme sayisi: " + cozumlenmisSonuc.length);
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçedir. ");
                                        //jTextArea_emailBilgisiCozumlenmis.append("Bu kelimenin kökü '"+cozumlenmisKok.icerik()+"' dir.");

                                        bulunanKokKelime=cozumlenmisKok.icerik();
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        //System.out.println("allRecords: "+allRecords);
                                        if (!valueIsExistInList(allRecords, bulunanKokKelime)){
                                            try{
                                                sql = "INSERT INTO [kelimeler_ekler_ve_baglantilar] ([kelimeler_kelime]) VALUES ('"+bulunanKokKelime+"');";
                                                statement = con.createStatement();
                                                statement.execute(sql);
                                                con.commit();
                                                statement.close();
                                                System.out.println("sql5l: "+sql);
                                            }catch(Exception exp){
                                                exp.printStackTrace();
                                            }
                                        }
                                        allRecords=getFieldsFromTable("[kelimeler_ekler_ve_baglantilar]", 2);
                                        wordIDNo=getIDNoOfRecord(allRecords, bulunanKokKelime);
                                        if (wordIDNo!=-1){
                                            if (wordIDNosMap.containsKey(wordIDNo))
                                                wordIDNosMap.put(wordIDNo,wordIDNosMap.get(wordIDNo)+1);
                                            else
                                                wordIDNosMap.put(wordIDNo,1);
                                        }

                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                        //sharedWordsFromItem.add(cozumlenmisKok.icerik());
                                        for (Kelime cozumlenmisKelime : cozumlenmisSonuc) {
                                            Kok kok = cozumlenmisKelime.kok();
                                            System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                                            List<Ek> ekler = cozumlenmisKelime.ekler();
                                            if (ekler != null) {
                                                System.out.println("Ekler:");
                                                for (int j = 0; j < ekler.size(); j++) {
                                                    Ek ek = ekler.get(j);
                                                    System.out.println("Ek-" + j + " : " + ek.ad());
                                                }
                                            }
                                        }
                                        /*
                                        String[] oneriler = zemberek.oner(kelime);
                                        if (oneriler.length!=0) {
                                            System.out.println(kelime + " Türkçe değil, öneri üretiliyor:");
                                            for (int i = 0; i < oneriler.length; i++) {
                                                System.out.println("Öneri-" + " : " + oneriler[i]);
                                            }
                                            System.out.println();
                                        }
                                        */
                                    }else{
                                        //jTextArea_emailBilgisiCozumlenmis.append(kelime+" kelimesi Türkçe değildir.");
                                        //jTextArea_emailBilgisiCozumlenmis.append("\n");
                                    }

                                }
                        }
                        iteratorWordIdNo=wordIDNosMap.entrySet().iterator();
                        while(iteratorWordIdNo.hasNext()){
                        entryOfWordIdNo=(Map.Entry)iteratorWordIdNo.next();
                        wordIDNo=(Integer)entryOfWordIdNo.getKey();
                        wordFrequency=(Integer)entryOfWordIdNo.getKey();
                        allRecords=getFieldsFromTable("[istatistikler_baglantilar]", 5);
                        //System.out.println("allRecords: "+allRecords);
                        if (!valueIsExistInList(allRecords, emailName, "image", String.valueOf(wordIDNo))){
                            try{
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_dizinid], [istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_kime_kelimefrekansi]) VALUES ("+String.valueOf(emailDirNameIdNo)+","+String.valueOf(emailIDNo)+",'image',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5m: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }
                        }else{
                            try{
                                sql = "DELETE FROM [istatistikler_baglantilar] WHERE [istatistikler_baglantilar_urltipi]='image' AND [istatistikler_baglantilar_epostaid]="+String.valueOf(emailIDNo)+" AND [istatistikler_baglantilar_kelimeid]="+String.valueOf(wordIDNo)+";";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5n: "+sql);
                                sql = "INSERT INTO [istatistikler_baglantilar] ([istatistikler_baglantilar_epostaid], [istatistikler_baglantilar_urltipi], [istatistikler_baglantilar_kelimeid], [istatistikler_kime_kelimefrekansi]) VALUES ("+String.valueOf(emailIDNo)+",'image',"+String.valueOf(wordIDNo)+","+String.valueOf(wordIDNosMap.get(wordIDNo))+");";
                                statement = con.createStatement();
                                statement.execute(sql);
                                con.commit();
                                statement.close();
                                System.out.println("sql5o: "+sql);
                            }catch(Exception exp){
                                exp.printStackTrace();
                            }                                        
                        }
                        }

                    }
                    Iterator<String> iterator=baglantilarIDNosSet.iterator();
                    while(iterator.hasNext()){
                        baglantilarIDNos+=iterator.next()+",";
                    }
                    System.out.println("baglantilarIDNos: "+baglantilarIDNos);
                    // Then iterate
                    /*org.jsoup.select.Elements images = doc.select("a");
                    for (org.jsoup.nodes.Element element : images) {
                        String Url = element.attr("href");
                        jTextArea_emailBilgisiCozumlenmis.append("new URL: "+Url);
                        jTextArea_emailBilgisiCozumlenmis.append("\n");        
                        // TODO: Do something with the URL
                    }
                    String fileUrl = null;
                    StringTokenizer stringTokenizer=new StringTokenizer(cumle, "<> '\"");
                    while(stringTokenizer.hasMoreTokens()){
                        fileUrl=new String(stringTokenizer.nextToken());
                        //imageUrl=imageUrl.replaceAll("\"", "");
                        //imageUrl=imageUrl.replaceAll("'\n", "");
                        if (fileUrl.indexOf(".png")!=-1 || fileUrl.indexOf(".jpg")!=-1 || fileUrl.indexOf(".jpeg")!=-1 || fileUrl.indexOf(".gif")!=-1 || fileUrl.indexOf(".tif")!=-1 || fileUrl.indexOf(".bmp")!=-1){
                            jTextArea_emailBilgisiCozumlenmis.append("image: "+fileUrl);
                            jTextArea_emailBilgisiCozumlenmis.append("\n");        
                        }
                    }
                    stringTokenizer=new StringTokenizer(cumle, "'\"");
                    while(stringTokenizer.hasMoreTokens()){
                        fileUrl=new String(stringTokenizer.nextToken());
                        //imageUrl=imageUrl.replaceAll("\"", "");
                        //imageUrl=imageUrl.replaceAll("'\n", "");
                        if (fileUrl.indexOf(".php")!=-1 || fileUrl.indexOf(".asp")!=-1 || fileUrl.indexOf(".htm")!=-1 || fileUrl.indexOf(".jsp")!=-1 || fileUrl.indexOf(".doc")!=-1 || fileUrl.indexOf(".xls")!=-1 || fileUrl.indexOf(".pdf")!=-1 || fileUrl.indexOf(".rar")!=-1 || fileUrl.indexOf(".zip")!=-1){
                            jTextArea_emailBilgisiCozumlenmis.append("file: "+fileUrl);
                            jTextArea_emailBilgisiCozumlenmis.append("\n");        
                        }
                    }*/
            }
        } catch (IOException e) {
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        } 
        //createMessageBox("Inserted Successfully");
        return true;
    }
    
    private void jButton_Epostayi_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Epostayi_KaydetActionPerformed
        String pookaHomePath=new String("");
        String emailAccountName=new String("");
        int emailAccountNameIdNo;
        String emailDirName=new String("");
        int emailDirNameIdNo;
        String emailName=new String("");
        String emailAccountNameTemp=new String("");
        String emailDirNameTemp=new String("");
        String emailNameTemp=new String("");
        String filePathOfHeader=new String("");
        String filePathOfMessage=new String("");
        ArrayList<String> itemList=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecords=null;
        String allToEmailAddressesIDNos=new String("");
        String allFromEmailAddressesIDNos=new String("");
        int emailAddressIDNo;
        String emailDateTime=new String("");
        String emailContentType=new String("");
        String allAttachedFileIDNos=new String("");
        int attachedFileIDNo;
        String urlIDNos=new String("");
        int urlIDNo;
        String emailIDNos=new String("");
        int emailIDNo=-1;
        String imageIDNos=new String("");
        int imageIDNo;
        HashSet<String> baglantilarIDNosSet=new HashSet<String>();
        String baglantilarIDNos=new String("");
        int wordIDNo=-1;
        int wordFrequency=0;
        HashMap<Integer,Integer> wordIDNosMap=new HashMap<Integer,Integer>();

        pookaHomePath=jTextField_emailPookaHomePath.getText();
        emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
        emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());
        filePathOfHeader=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_hdr";
        filePathOfMessage=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_msg";
        //System.out.println("filePathOfHeader: "+filePathOfHeader);
        //System.out.println("filePathOfMessage: "+filePathOfMessage);

        allRecords=getFieldsFromTable("[hesaplar]", 2);
        itemList.clear();
        for(int i=0; i<jComboBox_emailAccountList.getItemCount(); i++){
            emailAccountNameTemp=jComboBox_emailAccountList.getItemAt(i);
            itemList.add(emailAccountNameTemp);
            if (!valueIsExistInList(allRecords, emailAccountNameTemp)){
                try{
                    sql = "INSERT INTO [hesaplar] ([hesaplar_ad]) VALUES ('"+emailAccountName+"');";
                    statement = con.createStatement();
                    statement.execute(sql);
                    con.commit();
                    statement.close();
                    System.out.println("sql1: "+sql);
                }catch(Exception exp){
                    exp.printStackTrace();
                }
            }
        }
        emailAccountNameIdNo=getIDNoOfRecord(allRecords, emailAccountName);
        System.out.println("emailAccountNameIdNo: "+emailAccountNameIdNo);
        allRecords=getFieldsFromTable("[hesapdizinleri]", 3);
        itemList.clear();
        for(int i=0; i<jComboBox_emailDirList.getItemCount(); i++){
            emailDirNameTemp=jComboBox_emailDirList.getItemAt(i);
            itemList.add(emailDirNameTemp);
            if (!valueIsExistInList(allRecords, emailDirNameTemp)){
                try{
                    sql = "INSERT INTO [hesapdizinleri] ([hesapdizinleri_hesapid],[hesapdizinleri_dizinadi]) VALUES ('"+String.valueOf(emailAccountNameIdNo)+"','"+emailDirNameTemp+"');";
                    statement = con.createStatement();
                    statement.execute(sql);
                    con.commit();
                    statement.close();
                    System.out.println("sql2: "+sql);
                }catch(Exception exp){
                    exp.printStackTrace();
                }
            }
        }
        emailDirNameIdNo=getIDNoOfRecord(allRecords, String.valueOf(emailAccountNameIdNo), emailDirName);
        System.out.println("emailDirNameIdNo: "+emailDirNameIdNo);
        //allRecords=getFieldsFromTable("HESAPDIZINLERI", 2);
        itemList.clear();
        /*
        System.out.println("itemList: "+itemList.toString());
        for (ArrayList<String> item:allRecords)
            System.out.println("allRecords==> "+item);
        System.out.println("valueIsExistInList(spam_aktif_mi_baslik_icin)==> "+valueIsExistInList(allRecords, "spam_aktif_mi_baslik_icin"));
        System.out.println("valueIsExistInList(deneme)==> "+valueIsExistInList(allRecords, "deneme"));
        System.out.println("spam_aktif_mi_ekler_kelime_icin ayari = "+getValueFromSettings(allRecords, "spam_aktif_mi_ekler_kelime_icin"));
        System.out.println("spam_aktif_zamanlama_ile ayari = "+getValueFromSettings(allRecords, "spam_aktif_zamanlama_ile"));
        System.out.println("spam_aktif_zamanlama_araligi ayari = "+getValueFromSettings(allRecords, "spam_aktif_zamanlama_araligi"));
        */
        jTextArea_emailBilgisi.removeAll();
        jTextArea_emailBilgisi.setText("");
        if (saveEmailToDB(emailAccountName,emailDirName, emailName)){
            jTextArea_emailBilgisi.append(emailAccountName+" hesabının "+emailDirName+" dizinindeki "+emailName+" dosya nolu e-posta veritabanina basariyla kaydedildi.\n");
        } else{
            jTextArea_emailBilgisi.append(emailName+" dosyası bulunanamış veya bu dosya nolu e-posta daha once kayıtlı oldugundan ya da oluşan bir hatadan dolayı kaydetme işlemi gerçekleştirilememiştir.\n");
            
        }
    }//GEN-LAST:event_jButton_Epostayi_KaydetActionPerformed

    /**
     * ArrayList<ArrayList<String>> yapisinda bulunan tum veriler icerisinde 
     * bir deger var ise true yok ise false dondurulur.
     * @param dataList ArrayList<ArrayList<String>> tipinde veri listesini iceren parametre bilgisi
     * @param value String tipinde aranilacak deger parametre bilgisi
     * @return eger deger listede mevcut ise true aksi halde false dondurulur.
     */
    public boolean valueIsExistInList(ArrayList<ArrayList<String>> dataList, String value){
        if (dataList==null)
                return false;
        for(int i=0; i<dataList.size(); i++)
            if (dataList.get(i).contains(value))
                return true;
        return false;
    }

    /**
     * ArrayList<ArrayList<String>> yapisinda bulunan tum veriler icerisinde 
     * category ve value parametre bilgisi degerleri ikilisi ardisil olarak 
     * listede arar ve var ise true yok ise false dondurulur.
     * @param dataList ArrayList<ArrayList<String>> tipinde veri listesini iceren parametre bilgisi
     * @param category String tipinde ardisil aranilacak ilk deger parametre bilgisi
     * @param value String tipinde ardisil aranilacak son deger parametre bilgisi
     * @return eger deger listede mevcut ise true aksi halde false dondurulur.
     */    
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
    
    /**
     * ArrayList<ArrayList<String>> yapisinda bulunan tum veriler icerisinde 
     * orderedValue1,orderedValue2,orderedValue3 parametre bilgisi degerleri 
     * uclusunu ardisil olarak listede arar ve var ise true yok ise false dondurulur.
     * @param dataList ArrayList<ArrayList<String>> tipinde veri listesini iceren parametre bilgisi
     * @param orderedValue1 String tipinde ardisil aranilacak 1. deger parametre bilgisi
     * @param orderedValue2 String tipinde ardisil aranilacak 2. deger parametre bilgisi
     * @param orderedValue3 String tipinde ardisil aranilacak 3. deger parametre bilgisi
     * @return eger deger listede mevcut ise true aksi halde false dondurulur.
     */    
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
    
    /**
     * ArrayList<ArrayList<String>> tipinde verilen bir listedebir ayar bilgisini
     * geri dondurur ki veritabaninda yarlar ayar adi ve degeri seklinde ardisil
     * olarak bulundugundan eger aranilan deger bulunursa geriye bir sonraki 
     * alana ait bilgi String tipinde geri dondurulur. kullaniminda dikkat edilmeli
     * ki eger ayar metni iceren bir tabloda eger bir sonraki alan mevcut degil
     * ise fatal bir exception olusacagi bellidir.
     * @param dataList ArrayList<ArrayList<String>> tipinde giris parametre bilgisi
     * @param settingName String tipinde veritabanindaki tablosa yer alan ayar parametre bilgisi 
     * @return String tipinde geri donus bilgisi
     */
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
    
    /**
     * ArrayList<ArrayList<String>> tipinde verilen liste icerisinde ilk alan
     * bilgisi ki bu veritabanindaki tum tablolar icin gecerli olup bu alan o 
     * kayda ait ID degeri icerir, iste bu degeri verilerek o kaydin tum alanlarinin
     * ArrayList<String> tipinde bir liste seklinde geriye dondururulmesini saglar.
     * @param dataList ArrayList<ArrayList<String>> tipinde liste seklinde verileri iceren parametre bilgisi
     * @param IDNo getirilcek kayda ait olan ID no bilgisi
     * @return ArrayList<String> tipinde o bulunan kayda ait verileri iceren liste seklinde geri donus bilgisi, bulunamazsa null degeri geri dondururulur
     */
    public ArrayList<String> getRecordFromIDNo(ArrayList<ArrayList<String>> dataList, int IDNo){
        ArrayList<String> recordItem=new ArrayList<String>();
        String fieldIDNoStr=new String("");
        String IDNoStr=new String(String.valueOf(IDNo));
        if (dataList==null)
            return null;
        for(int i=0; i<dataList.size(); i++){
            recordItem=dataList.get(i);            
            fieldIDNoStr=recordItem.get(0);            
            if (IDNoStr.equals(fieldIDNoStr)){
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
            //System.out.println("sql: "+sql);
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
            //exp.printStackTrace();
            return null;
        }
        //allRecords.remove(allRecords.size()-1);
        if (allRecords.size()==0)
            return null;
        else
            return allRecords;
    }
    
    private void jComboBox_emailAccountListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_emailAccountListActionPerformed
        String emailAccountName=new String("");
        String emailDirName=new String("");
        ArrayList<String> dirList=new ArrayList<String>();
        String accountDirPath=new String(getPookaLocalRootPath());
        accountDirPath=accountDirPath.concat("\\cache");
        //accountDirPath=accountDirPath.replace("\\", "\\\\");
        //dirList=util.getAllFiles("C:\\Users\\Xpology\\.pooka\\cache", true, false);
        /*dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailAccountList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailAccountList.addItem(directoryName);
        }
        */

        if (jComboBox_emailAccountList.getItemCount()==0)
            return;

        jComboBox_emailDirList.removeAllItems();
        jComboBox_emailList.removeAllItems();
        emailAccountName=jComboBox_emailAccountList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailAccountName);
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailDirList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailDirList.addItem(directoryName);
        }
        //jComboBox_emailAccountList.setSelectedIndex(3);
        emailDirName=jComboBox_emailDirList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailDirName);
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailList.addItem(directoryName);
        }
        allRecords=getFieldsFromTable("[hesaplar]", 2);
        this.accountID=getIDNoOfRecord(allRecords, emailAccountName);
    }//GEN-LAST:event_jComboBox_emailAccountListActionPerformed

    private void jComboBox_emailDirListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_emailDirListActionPerformed
        String emailAccountName=new String("");
        String emailDirName=new String("");
        ArrayList<String> dirList=new ArrayList<String>();
        String accountDirPath=new String(getPookaLocalRootPath());
        accountDirPath=accountDirPath.concat("\\cache");
        //accountDirPath=accountDirPath.replace("\\", "\\\\");
        //dirList=util.getAllFiles("C:\\Users\\Xpology\\.pooka\\cache", true, false);
        /*dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emailAccountList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emailAccountList.addItem(directoryName);
        }
        */
        
        if (jComboBox_emailAccountList.getItemCount()==0)
            return;
        
        emailAccountName=jComboBox_emailAccountList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailAccountName);
        /*
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), true, false);
        jComboBox_emaiDirlList.removeAllItems();
        for (String directoryName : dirList){
            jComboBox_emaiDirlList.addItem(directoryName);
        }
        //jComboBox_emailAccountList.setSelectedIndex(3);
        */
        
        if (jComboBox_emailDirList.getItemCount()==0)
            return;

        emailDirName=jComboBox_emailDirList.getSelectedItem().toString();
        accountDirPath=accountDirPath.concat("\\"+emailDirName);
        dirList.clear();
        dirList=util.getAllFiles(accountDirPath.toString(), false, true);
        jComboBox_emailList.removeAllItems();
        for (String fileName : dirList){
            if (fileName.indexOf("_hdr")!=-1){
                fileName=fileName.replaceAll("_hdr", "");
                jComboBox_emailList.addItem(fileName);
            }
        }
    }//GEN-LAST:event_jComboBox_emailDirListActionPerformed

    private void jComboBox_emailFieldListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_emailFieldListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_emailFieldListActionPerformed

    private void jComboBox_emailListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_emailListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_emailListActionPerformed

    private void jButton_Tum_Dizinlerdeki_Epostalari_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Tum_Dizinlerdeki_Epostalari_KaydetActionPerformed
        String pookaHomePath=new String("");
        String emailAccountName=new String("");
        int emailAccountNameIdNo;
        String emailDirName=new String("");
        int emailDirNameIdNo;
        String emailName=new String("");
        String emailAccountNameTemp=new String("");
        String emailDirNameTemp=new String("");
        String emailNameTemp=new String("");
        String emailNamePreviousTemp=new String("");
        String filePathOfHeader=new String("");
        String filePathOfMessage=new String("");
        ArrayList<String> itemList=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecords=null;
        String allToEmailAddressesIDNos=new String("");
        String allFromEmailAddressesIDNos=new String("");
        int emailAddressIDNo;
        String emailDateTime=new String("");
        String emailContentType=new String("");
        String allAttachedFileIDNos=new String("");
        int attachedFileIDNo;
        String urlIDNos=new String("");
        int urlIDNo;
        String emailIDNos=new String("");
        int emailIDNo=-1;
        String imageIDNos=new String("");
        int imageIDNo;
        HashSet<String> baglantilarIDNosSet=new HashSet<String>();
        String baglantilarIDNos=new String("");
        int wordIDNo=-1;
        int wordFrequency=0;
        HashMap<Integer,Integer> wordIDNosMap=new HashMap<Integer,Integer>();

        pookaHomePath=jTextField_emailPookaHomePath.getText();
        emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
        emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());
        filePathOfHeader=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_hdr";
        filePathOfMessage=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_msg";
        //System.out.println("filePathOfHeader: "+filePathOfHeader);
        //System.out.println("filePathOfMessage: "+filePathOfMessage);

        jTextArea_emailBilgisi.removeAll();
        jTextArea_emailBilgisi.setText("");
        jTextArea_emailBilgisi.append("Tüm hesaplara ve tüm dizinlere ait e-postalar veritabanına kaydetme işlemi başlatılmıştır.\n\nİşlem devam etmektedir...\n\n");

        
        String accountDirPath=new String("");
        
        String accountHomeDirPath=new String(getPookaLocalRootPath());
        accountHomeDirPath=accountHomeDirPath.concat("\\cache");
        
        ArrayList<String> dirAccountList=new ArrayList<String>();
        dirAccountList=util.getAllFiles(accountHomeDirPath.toString(), true, false);

        ArrayList<String> dirAccountDirList=new ArrayList<String>();

        ArrayList<String> dirEmailList=new ArrayList<String>();
        
        //for(int i=0; i<jComboBox_emailAccountList.getItemCount(); i++)
        for(int i=0; i<dirAccountList.size(); i++)
        //int i=0;
        {
            //emailAccountNameTemp=jComboBox_emailAccountList.getItemAt(i);
            emailAccountNameTemp=dirAccountList.get(i);
            dirAccountDirList=util.getAllFiles(accountHomeDirPath+"\\"+emailAccountNameTemp, true, false);
            System.out.println(emailAccountNameTemp+" isimli hesap seçilmiştir.");
            for(int j=0; j<dirAccountDirList.size(); j++){
                //emailDirNameTemp=jComboBox_emailDirList.getItemAt(j);
                emailDirNameTemp=dirAccountDirList.get(j);
                dirEmailList=util.getAllFiles(accountHomeDirPath+"\\"+emailAccountNameTemp+"\\"+emailDirNameTemp, false, true);
                System.out.println(emailDirNameTemp+" isimli dizin seçilmiştir.");
                for(int k=0; k<dirEmailList.size(); k++){
                    //emailNameTemp=jComboBox_emailList.getItemAt(k);
                    emailNameTemp=dirEmailList.get(k);
                    if (!(emailNameTemp.indexOf("_msg")>=0 || emailNameTemp.indexOf("_hdr")>=0))
                        continue;
                    emailNameTemp=emailNameTemp.replaceAll("_hdr", "");
                    emailNameTemp=emailNameTemp.replaceAll("_msg", "");
                    if (emailNameTemp.equals(emailNamePreviousTemp))
                        continue;
                    System.out.println(emailAccountNameTemp+" hesabının "+emailDirNameTemp+" dizinindeki "+emailNameTemp+" dosya nolu e-posta isleme alinmistir.");
                    if (saveEmailToDB(emailAccountNameTemp,emailDirNameTemp, emailNameTemp)){
                        jTextArea_emailBilgisi.append(emailAccountNameTemp+" hesabının "+emailDirNameTemp+" dizinindeki "+emailNameTemp+" dosya nolu e-posta veritabanina basariyla kaydedildi.\n");
                    } else{
                        jTextArea_emailBilgisi.append(emailNameTemp+" dosyası bulunanamış veya bu dosya nolu e-posta daha once kayıtlı oldugundan ya da oluşan bir hatadan dolayı kaydetme işlemi gerçekleştirilememiştir.\n");
                    }
                    emailNamePreviousTemp=emailNameTemp;
                }
            }
        }
        jTextArea_emailBilgisi.append("\n\nTüm hesaplara ve tüm dizinlere ait işlemlerin tümü tamamlanmıştır.\n\n");
    }//GEN-LAST:event_jButton_Tum_Dizinlerdeki_Epostalari_KaydetActionPerformed

    private void jButton_DB_Yonetim_Panelini_AcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DB_Yonetim_Panelini_AcActionPerformed
        String emailAccountName=new String("");
        emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        allRecords=getFieldsFromTable("[hesaplar]", 2);
        this.accountID=getIDNoOfRecord(allRecords, emailAccountName);
        MainFormOfDBManagement MainFormOfDBManagement=new MainFormOfDBManagement(this.accountID);
        MainFormOfDBManagement.setVisible(true);
    }//GEN-LAST:event_jButton_DB_Yonetim_Panelini_AcActionPerformed

    private void jButton_Program_HakkindaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Program_HakkindaActionPerformed
        createMessageBox("      Akıllı E-Posta Asistanı (GYTE Bitirme Projesi, BIL495 Dersi)"
                + "Geliştiren: Kenan SAVAŞ Versiyon: 1.0.0.201605232015",
                "Hakkında", 700, 200);
    }//GEN-LAST:event_jButton_Program_HakkindaActionPerformed

    private void jButton_Bu_Dizindeki_Epostalari_KaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Bu_Dizindeki_Epostalari_KaydetActionPerformed
        String pookaHomePath=new String("");
        String emailAccountName=new String("");
        int emailAccountNameIdNo;
        String emailDirName=new String("");
        int emailDirNameIdNo;
        String emailName=new String("");
        String emailAccountNameTemp=new String("");
        String emailDirNameTemp=new String("");
        String emailNameTemp=new String("");
        String emailNamePreviousTemp=new String("");
        String filePathOfHeader=new String("");
        String filePathOfMessage=new String("");
        ArrayList<String> itemList=new ArrayList<String>();
        ArrayList<ArrayList<String>> allRecords=null;
        String allToEmailAddressesIDNos=new String("");
        String allFromEmailAddressesIDNos=new String("");
        int emailAddressIDNo;
        String emailDateTime=new String("");
        String emailContentType=new String("");
        String allAttachedFileIDNos=new String("");
        int attachedFileIDNo;
        String urlIDNos=new String("");
        int urlIDNo;
        String emailIDNos=new String("");
        int emailIDNo=-1;
        String imageIDNos=new String("");
        int imageIDNo;
        HashSet<String> baglantilarIDNosSet=new HashSet<String>();
        String baglantilarIDNos=new String("");
        int wordIDNo=-1;
        int wordFrequency=0;
        HashMap<Integer,Integer> wordIDNosMap=new HashMap<Integer,Integer>();

        pookaHomePath=jTextField_emailPookaHomePath.getText();
        emailAccountName=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
        emailDirName=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
        emailName=jComboBox_emailList.getItemAt(jComboBox_emailList.getSelectedIndex());
        filePathOfHeader=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_hdr";
        filePathOfMessage=pookaHomePath+"\\cache\\"+emailAccountName+"\\"+emailDirName+"\\"+emailName+"_msg";
        //System.out.println("filePathOfHeader: "+filePathOfHeader);
        //System.out.println("filePathOfMessage: "+filePathOfMessage);

        jTextArea_emailBilgisi.removeAll();
        jTextArea_emailBilgisi.setText("");
        jTextArea_emailBilgisi.append("Bu dizine ait e-postaları veritabanına kaydetme işlemi başlatılmıştır.\n\nİşlem devam etmektedir...\n\n");

        
        String accountDirPath=new String("");
        
        String accountHomeDirPath=new String(getPookaLocalRootPath());
        accountHomeDirPath=accountHomeDirPath.concat("\\cache");
        
        ArrayList<String> dirAccountList=new ArrayList<String>();
        dirAccountList=util.getAllFiles(accountHomeDirPath.toString(), true, false);

        ArrayList<String> dirAccountDirList=new ArrayList<String>();

        ArrayList<String> dirEmailList=new ArrayList<String>();
        
        //for(int i=0; i<jComboBox_emailAccountList.getItemCount(); i++)
        //for(int i=0; i<dirAccountList.size(); i++)
        int i=0;
        {
            emailAccountNameTemp=jComboBox_emailAccountList.getItemAt(jComboBox_emailAccountList.getSelectedIndex());
            //emailAccountNameTemp=dirAccountList.get(i);
            dirAccountDirList=util.getAllFiles(accountHomeDirPath+"\\"+emailAccountNameTemp, true, false);
            System.out.println(emailAccountNameTemp+" isimli hesap seçilmiştir.");
            //for(int j=0; j<dirAccountDirList.size(); j++)
            int j=0;
            {
                emailDirNameTemp=jComboBox_emailDirList.getItemAt(jComboBox_emailDirList.getSelectedIndex());
                //emailDirNameTemp=dirAccountDirList.get(j);
                dirEmailList=util.getAllFiles(accountHomeDirPath+"\\"+emailAccountNameTemp+"\\"+emailDirNameTemp, false, true);
                System.out.println(emailDirNameTemp+" isimli dizin seçilmiştir.");
                for(int k=0; k<dirEmailList.size(); k++){
                    //emailNameTemp=jComboBox_emailList.getItemAt(k);
                    emailNameTemp=dirEmailList.get(k);
                    if (!(emailNameTemp.indexOf("_msg")>=0 || emailNameTemp.indexOf("_hdr")>=0))
                        continue;
                    emailNameTemp=emailNameTemp.replaceAll("_hdr", "");
                    emailNameTemp=emailNameTemp.replaceAll("_msg", "");
                    if (emailNameTemp.equals(emailNamePreviousTemp))
                        continue;
                    System.out.println(emailAccountNameTemp+" hesabının "+emailDirNameTemp+" dizinindeki "+emailNameTemp+" dosya nolu e-posta isleme alinmistir.");
                    if (saveEmailToDB(emailAccountNameTemp,emailDirNameTemp, emailNameTemp)){
                        jTextArea_emailBilgisi.append(emailAccountNameTemp+" hesabının "+emailDirNameTemp+" dizinindeki "+emailNameTemp+" dosya nolu e-posta veritabanina basariyla kaydedildi.\n");
                    } else{
                        jTextArea_emailBilgisi.append(emailNameTemp+" dosyası bulunanamış veya bu dosya nolu e-posta daha once kayıtlı oldugundan ya da oluşan bir hatadan dolayı kaydetme işlemi gerçekleştirilememiştir.\n");
                    }
                    emailNamePreviousTemp=emailNameTemp;
                }
            }
        }
        jTextArea_emailBilgisi.append("\n\nTüm hesaplara ve tüm dizinlere ait işlemlerin tümü tamamlanmıştır.\n\n");
    }//GEN-LAST:event_jButton_Bu_Dizindeki_Epostalari_KaydetActionPerformed

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Bu_Dizindeki_Epostalari_Kaydet;
    private javax.swing.JButton jButton_DB_Yonetim_Panelini_Ac;
    private javax.swing.JButton jButton_Email_Alan_Bilgisini_Getir;
    private javax.swing.JButton jButton_Epostayi_Kaydet;
    private javax.swing.JButton jButton_Kelimeleri_Bul;
    private javax.swing.JButton jButton_Kelimeleri_Cozumle;
    private javax.swing.JButton jButton_Program_Hakkinda;
    private javax.swing.JButton jButton_Tum_Dizinlerdeki_Epostalari_Kaydet;
    private javax.swing.JButton jButton_emailYukle;
    private javax.swing.JButton jButton_linkleriGetir;
    private javax.swing.JComboBox<String> jComboBox_emailAccountList;
    private javax.swing.JComboBox<String> jComboBox_emailDirList;
    private javax.swing.JComboBox<String> jComboBox_emailFieldList;
    private javax.swing.JComboBox<String> jComboBox_emailList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_emailBilgisi;
    private javax.swing.JTextArea jTextArea_emailBilgisiCozumlenmis;
    private javax.swing.JTextField jTextField_emailPookaHomePath;
    // End of variables declaration//GEN-END:variables
}
