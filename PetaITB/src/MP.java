
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamalia
 */
public class MP extends javax.swing.JFrame {
    int loc;
    boolean jarak, fasilitas, zona;
    private javax.swing.JLabel Hasil[];
    
    /**
     * Creates new form MP
     */
    public MP() {
        initComponents();
        Hasil = new javax.swing.JLabel[15];
        for (int i = 0; i<15; i++){
            Hasil[i] = new javax.swing.JLabel();
            Hasil[i].setVisible(false);
            Hasil[i].setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            Hasil[i].setText("");
            Hasil[i].setBounds(610 , 90 + i*25, 200, 30);
            getContentPane().add(Hasil[i]);
        }
        Hasil[0].setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        EnableZona(false);
        jarak = false;
        fasilitas = false;
        zona = false;
        Write.setEnabled(false);
        loc = 0;
        getContentPane().add(Background);
        setSize(820, 636);
        setVisible(true);
        Back.setVisible(false);
        Jarak_Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               Hasil[0].setText("Silahkan pilih dua buah gedung");
               Hasil[0].setVisible(true);
               loc = 0;
               Tebak.setVisible(false);
               Jarak_Button.setVisible(false);
               Zona_Button.setVisible(false);
               Fasilitas_Button.setVisible(false);
               Back.setVisible(true);
               jarak = true;
            }
        });
        Zona_Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               loc = 0;
               Tebak.setVisible(false);
               Jarak_Button.setVisible(false);
               Zona_Button.setVisible(false);
               Fasilitas_Button.setVisible(false);
               Back.setVisible(true);
               zona = true;
               EnableZona(true);
            }
        });
        Fasilitas_Button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               loc = 0;
               Tebak.setVisible(false);
               Jarak_Button.setVisible(false);
               Zona_Button.setVisible(false);
               Fasilitas_Button.setVisible(false);
               Back.setVisible(true);
               fasilitas = true;
            }
        });
        Tebak.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               dispose();
               setVisible(false);
               new Question();
            }
        });
        Back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
               loc = 0;
               Tebak.setVisible(true);
               Jarak_Button.setVisible(true);
               Zona_Button.setVisible(true);
               Fasilitas_Button.setVisible(true);
               Back.setVisible(false);
               jarak = false;
               fasilitas = false;
               zona = false;
               EnableZona(false);
               EnableHasil(false);
            }
        });
        
        Labtek_Biru.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                ZonaSQL("Zona Labtek Biru");
            }
        });
        Timur.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                ZonaSQL("Zona Timur");
            }
        });
        Timur_Jauh.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                ZonaSQL("Zona Timur Jauh");
            }
        });
        Tengah.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                ZonaSQL("Zona Tengah");
            }
        });
        Barat.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                ZonaSQL("Zona Barat");
            }
        });
        
        b1.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(1);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 1;
                    }
                    else{
                        JarakSQL(loc, 1);
                        loc = 0;
                    }
                }
            }
        });
        b2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(2);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 2;
                    }
                    else{
                        JarakSQL(loc, 2);
                        loc = 0;
                    }
                }
            }
        });
        b3.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(3);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 3;
                    }
                    else{
                        JarakSQL(loc, 3);
                        loc = 0;
                    }
                }
            }
        });
        b4.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(4);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 4;
                    }
                    else{
                        JarakSQL(loc, 4);
                        loc = 0;
                    }
                }
            }
        });
        b5.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(5);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 5;
                    }
                    else{
                        JarakSQL(loc, 5);
                        loc = 0;
                    }
                }
            }
        });
        b6.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(6);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 6;
                    }
                    else{
                        JarakSQL(loc, 6);
                        loc = 0;
                    }
                }
            }
        });
        b7.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(7);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 7;
                    }
                    else{
                        JarakSQL(loc, 7);
                        loc = 0;
                    }
                }
            }
        });
        b8.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(8);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 8;
                    }
                    else{
                        JarakSQL(loc, 8);
                        loc = 0;
                    }
                }
            }
        });
        b9.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(9);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 9;
                    }
                    else{
                        JarakSQL(loc, 9);
                        loc = 0;
                    }
                }
            }
        });
        b10.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(10);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 10;
                    }
                    else{
                        JarakSQL(loc, 10);
                        loc = 0;
                    }
                }
            }
        });
        b11.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(11);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 11;
                    }
                    else{
                        JarakSQL(loc, 11);
                        loc = 0;
                    }
                }
            }
        });
        b12.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(12);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 12;
                    }
                    else{
                        JarakSQL(loc, 12);
                        loc = 0;
                    }
                }
            }
        });
        b13.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(13);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 13;
                    }
                    else{
                        JarakSQL(loc, 13);
                        loc = 0;
                    }
                }
            }
        });
        b14.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(14);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 14;
                    }
                    else{
                        JarakSQL(loc, 14);
                        loc = 0;
                    }
                }
            }
        });
        b15.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(15);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 15;
                    }
                    else{
                        JarakSQL(loc, 15);
                        loc = 0;
                    }
                }
            }
        });
        b16.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(16);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 16;
                    }
                    else{
                        JarakSQL(loc, 16);
                        loc = 0;
                    }
                }
            }
        });
        b17.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(17);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 17;
                    }
                    else{
                        JarakSQL(loc, 17);
                        loc = 0;
                    }
                }
            }
        });
        b18.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(18);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 18;
                    }
                    else{
                        JarakSQL(loc, 18);
                        loc = 0;
                    }
                }
            }
        });
        b19.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(19);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 19;
                    }
                    else{
                        JarakSQL(loc, 19);
                        loc = 0;
                    }
                }
            }
        });
        b20.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(20);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 20;
                    }
                    else{
                        JarakSQL(loc, 20);
                        loc = 0;
                    }
                }
            }
        });
        b21.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(21);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 21;
                    }
                    else{
                        JarakSQL(loc, 21);
                        loc = 0;
                    }
                }
            }
        });
        b22.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(22);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 22;
                    }
                    else{
                        JarakSQL(loc, 22);
                        loc = 0;
                    }
                }
            }
        });
        b23.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(23);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 23;
                    }
                    else{
                        JarakSQL(loc, 23);
                        loc = 0;
                    }
                }
            }
        });
        b24.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(24);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 24;
                    }
                    else{
                        JarakSQL(loc, 24);
                        loc = 0;
                    }
                }
            }
        });
        b25.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(25);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 25;
                    }
                    else{
                        JarakSQL(loc, 25);
                        loc = 0;
                    }
                }
            }
        });
        b26.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(26);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 26;
                    }
                    else{
                        JarakSQL(loc, 26);
                        loc = 0;
                    }
                }
            }
        });
        b27.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(27);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 27;
                    }
                    else{
                        JarakSQL(loc, 27);
                        loc = 0;
                    }
                }
            }
        });
        b28.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(28);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 28;
                    }
                    else{
                        JarakSQL(loc, 28);
                        loc = 0;
                    }
                }
            }
        });
        b29.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(29);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 29;
                    }
                    else{
                        JarakSQL(loc, 29);
                        loc = 0;
                    }
                }
            }
        });
        b30.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(30);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 30;
                    }
                    else{
                        JarakSQL(loc, 30);
                        loc = 0;
                    }
                }
            }
        });
        b31.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(31);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 31;
                    }
                    else{
                        JarakSQL(loc, 31);
                        loc = 0;
                    }
                }
            }
        });
        b32.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(32);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 32;
                    }
                    else{
                        JarakSQL(loc, 32);
                        loc = 0;
                    }
                }
            }
        });
        b33.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(33);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 33;
                    }
                    else{
                        JarakSQL(loc, 33);
                        loc = 0;
                    }
                }
            }
        });
        b34.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(34);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 34;
                    }
                    else{
                        JarakSQL(loc, 34);
                        loc = 0;
                    }
                }
            }
        });
        b35.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(35);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 35;
                    }
                    else{
                        JarakSQL(loc, 35);
                        loc = 0;
                    }
                }
            }
        });
        b36.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(36);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 36;
                    }
                    else{
                        JarakSQL(loc, 36);
                        loc = 0;
                    }
                }
            }
        });
        b37.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(37);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 37;
                    }
                    else{
                        JarakSQL(loc, 37);
                        loc = 0;
                    }
                }
            }
        });
        b38.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(38);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 38;
                    }
                    else{
                        JarakSQL(loc, 38);
                        loc = 0;
                    }
                }
            }
        });
        b39.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(39);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 39;
                    }
                    else{
                        JarakSQL(loc, 39);
                        loc = 0;
                    }
                }
            }
        });
        b40.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(40);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 40;
                    }
                    else{
                        JarakSQL(loc, 40);
                        loc = 0;
                    }
                }
            }
        });
        b41.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(41);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 41;
                    }
                    else{
                        JarakSQL(loc, 41);
                        loc = 0;
                    }
                }
            }
        });
        b42.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(42);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 42;
                    }
                    else{
                        JarakSQL(loc, 42);
                        loc = 0;
                    }
                }
            }
        });
        b43.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if(fasilitas){
                    FasilitasSQL(43);
                }
                else if(jarak){
                    if(loc == 0){
                        loc = 43;
                    }
                    else{
                        JarakSQL(loc, 43);
                        loc = 0;
                    }
                }
            }
        });
    }
    
    public void EnableZona(boolean B){
        Barat.setVisible(B);
        Timur.setVisible(B);
        Timur_Jauh.setVisible(B);
        Tengah.setVisible(B);
        Labtek_Biru.setVisible(B);
    }

    public void EnableHasil(boolean B){
        for (int i = 0; i<15; i++){
            Hasil[i].setVisible(B);
        }
    }
    public void ClearHasil(){
        for (int i = 0; i<15; i++){
            Hasil[i].setText("");
        }
    }
    public void JarakSQL(int titik1, int titik2){
        ClearHasil();
        java.sql.Connection conn; 
        try { 
            String loc1 = "";
            String loc2 = "";
            Class.forName("org.postgresql.Driver"); 
            String url = "jdbc:postgresql://localhost:5432/Peta_ITB"; 
            conn = DriverManager.getConnection(url, "postgres", "basdat"); 
            try (Statement s = conn.createStatement()) {
                ResultSet r = s.executeQuery("SELECT nama, ST_AsText(geom) FROM gedung WHERE id = " + titik1);
                while( r.next() ) {
                    Hasil[1].setText(r.getString("nama") + " - ");
                    loc1 = r.getString("st_astext");
                }
                r = s.executeQuery("SELECT nama, ST_AsText(geom) FROM gedung WHERE id = " + titik2);
                while( r.next() ) {
                    Hasil[2].setText(r.getString("nama"));
                    loc2 = r.getString("st_astext");
                }
                r = s.executeQuery( "SELECT ST_Distance(ST_GeometryFromText('" + loc1 + "'),ST_GeometryFromText('" + loc2 + "'))");
                while( r.next() ) {
                     Hasil[3].setText("Jarak = " + r.getString("st_distance"));
                 }
            }
            EnableHasil(true);
            conn.close(); 
        } 
        catch( ClassNotFoundException | SQLException e ) { 
        }
    }
    
    public void FasilitasSQL (int titik1){
        ClearHasil();
        ClearHasil();
        java.sql.Connection conn; 
        try { 
            int i = 1;
            Class.forName("org.postgresql.Driver"); 
            String url = "jdbc:postgresql://localhost:5432/Peta_ITB"; 
            conn = DriverManager.getConnection(url, "postgres", "basdat"); 
            try (Statement s = conn.createStatement()) {
                ResultSet r = s.executeQuery("SELECT DISTINCT nama, nama_fasilitas " +
                                            "FROM fasilitas, gedung " +
                                            "WHERE ST_Within " +
                                            "(fasilitas.geom, (SELECT DISTINCT gedung.geom FROM gedung WHERE id = " + 
                                            titik1 +")) AND gedung.id = " + titik1);
                while( r.next() ) {
                    Hasil[0].setText(r.getString("nama"));
                    Hasil[i].setText(r.getString("nama_fasilitas"));
                    i++;
                }
                
            }
            EnableHasil(true);
            conn.close(); 
        } 
        catch( ClassNotFoundException | SQLException e ) { 
        }
    }
       
    
    public void ZonaSQL (String Z){
        EnableZona(false);
        ClearHasil();
        java.sql.Connection conn; 
        try { 
            Hasil[0].setText(Z);
            int i = 1;
            Class.forName("org.postgresql.Driver"); 
            String url = "jdbc:postgresql://localhost:5432/Peta_ITB"; 
            conn = DriverManager.getConnection(url, "postgres", "basdat"); 
            try (Statement s = conn.createStatement()) {
                ResultSet r = s.executeQuery("SELECT DISTINCT nama " +
                                            "FROM gedung, zona " +
                                            "WHERE ST_Within(geom, (SELECT geom_zona FROM zona WHERE nama_zona = '" +
                                            Z + "'))");
                while( r.next() ) {
                    Hasil[i].setText(r.getString("nama"));
                    i++;
                }
                
            }
            EnableHasil(true);
            conn.close(); 
        } 
        catch( ClassNotFoundException | SQLException e ) { 
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

        Background = new javax.swing.JLabel();
        Judul = new javax.swing.JLabel();
        Fasilitas_Button = new javax.swing.JButton();
        Jarak_Button = new javax.swing.JButton();
        Zona_Button = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b22 = new javax.swing.JButton();
        b23 = new javax.swing.JButton();
        b24 = new javax.swing.JButton();
        b25 = new javax.swing.JButton();
        b26 = new javax.swing.JButton();
        b27 = new javax.swing.JButton();
        b28 = new javax.swing.JButton();
        b29 = new javax.swing.JButton();
        b30 = new javax.swing.JButton();
        b31 = new javax.swing.JButton();
        b32 = new javax.swing.JButton();
        b33 = new javax.swing.JButton();
        b34 = new javax.swing.JButton();
        b35 = new javax.swing.JButton();
        b36 = new javax.swing.JButton();
        b37 = new javax.swing.JButton();
        b38 = new javax.swing.JButton();
        b39 = new javax.swing.JButton();
        b40 = new javax.swing.JButton();
        b41 = new javax.swing.JButton();
        b42 = new javax.swing.JButton();
        b43 = new javax.swing.JButton();
        Barat = new javax.swing.JButton();
        Timur_Jauh = new javax.swing.JButton();
        Timur = new javax.swing.JButton();
        Tengah = new javax.swing.JButton();
        Labtek_Biru = new javax.swing.JButton();
        Write = new javax.swing.JLabel();
        Tebak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Peta ITB");
        getContentPane().setLayout(null);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/peta.jpg"))); // NOI18N
        getContentPane().add(Background);
        Background.setBounds(0, 0, 600, 640);

        Judul.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        Judul.setText("Peta ITB");
        getContentPane().add(Judul);
        Judul.setBounds(640, 20, 136, 44);

        Fasilitas_Button.setText("Fasilitas");
        getContentPane().add(Fasilitas_Button);
        Fasilitas_Button.setBounds(630, 240, 150, 40);

        Jarak_Button.setText("Mencari Jarak");
        getContentPane().add(Jarak_Button);
        Jarak_Button.setBounds(630, 120, 150, 40);

        Zona_Button.setText("Zona Kampus");
        getContentPane().add(Zona_Button);
        Zona_Button.setBounds(630, 180, 150, 40);

        Back.setText("Back");
        getContentPane().add(Back);
        Back.setBounds(670, 500, 73, 23);
        getContentPane().add(b1);
        b1.setBounds(90, 50, 20, 20);
        getContentPane().add(b2);
        b2.setBounds(330, 270, 20, 20);
        getContentPane().add(b3);
        b3.setBounds(270, 260, 20, 20);
        getContentPane().add(b4);
        b4.setBounds(260, 310, 20, 20);
        getContentPane().add(b5);
        b5.setBounds(330, 310, 20, 20);
        getContentPane().add(b6);
        b6.setBounds(120, 70, 20, 20);
        getContentPane().add(b7);
        b7.setBounds(100, 140, 20, 20);
        getContentPane().add(b8);
        b8.setBounds(120, 180, 20, 20);
        getContentPane().add(b9);
        b9.setBounds(90, 220, 20, 20);
        getContentPane().add(b10);
        b10.setBounds(70, 300, 20, 20);
        getContentPane().add(b11);
        b11.setBounds(150, 330, 20, 20);
        getContentPane().add(b12);
        b12.setBounds(170, 420, 20, 20);
        getContentPane().add(b13);
        b13.setBounds(170, 450, 20, 20);
        getContentPane().add(b14);
        b14.setBounds(80, 420, 20, 20);
        getContentPane().add(b15);
        b15.setBounds(120, 290, 20, 20);
        getContentPane().add(b16);
        b16.setBounds(110, 110, 20, 20);
        getContentPane().add(b17);
        b17.setBounds(170, 380, 20, 20);
        getContentPane().add(b18);
        b18.setBounds(210, 80, 20, 20);
        getContentPane().add(b19);
        b19.setBounds(260, 70, 20, 20);
        getContentPane().add(b20);
        b20.setBounds(350, 70, 20, 20);
        getContentPane().add(b21);
        b21.setBounds(200, 150, 20, 20);
        getContentPane().add(b22);
        b22.setBounds(190, 190, 20, 20);
        getContentPane().add(b23);
        b23.setBounds(340, 190, 20, 20);
        getContentPane().add(b24);
        b24.setBounds(340, 150, 20, 20);
        getContentPane().add(b25);
        b25.setBounds(260, 140, 20, 20);
        getContentPane().add(b26);
        b26.setBounds(270, 190, 20, 20);
        getContentPane().add(b27);
        b27.setBounds(390, 180, 20, 20);
        getContentPane().add(b28);
        b28.setBounds(270, 370, 20, 20);
        getContentPane().add(b29);
        b29.setBounds(340, 370, 20, 20);
        getContentPane().add(b30);
        b30.setBounds(240, 400, 20, 20);
        getContentPane().add(b31);
        b31.setBounds(300, 390, 20, 20);
        getContentPane().add(b32);
        b32.setBounds(230, 490, 20, 20);
        getContentPane().add(b33);
        b33.setBounds(330, 460, 20, 20);
        getContentPane().add(b34);
        b34.setBounds(370, 460, 20, 20);
        getContentPane().add(b35);
        b35.setBounds(370, 490, 20, 20);
        getContentPane().add(b36);
        b36.setBounds(420, 460, 20, 20);
        getContentPane().add(b37);
        b37.setBounds(410, 400, 20, 20);
        getContentPane().add(b38);
        b38.setBounds(480, 400, 20, 20);
        getContentPane().add(b39);
        b39.setBounds(470, 440, 20, 20);
        getContentPane().add(b40);
        b40.setBounds(460, 420, 20, 20);
        getContentPane().add(b41);
        b41.setBounds(450, 380, 20, 20);
        getContentPane().add(b42);
        b42.setBounds(480, 280, 20, 20);
        getContentPane().add(b43);
        b43.setBounds(460, 320, 20, 20);

        Barat.setText("Barat");
        getContentPane().add(Barat);
        Barat.setBounds(630, 180, 150, 40);

        Timur_Jauh.setText("Timur Jauh");
        getContentPane().add(Timur_Jauh);
        Timur_Jauh.setBounds(630, 230, 150, 40);

        Timur.setText("Timur");
        getContentPane().add(Timur);
        Timur.setBounds(630, 280, 150, 40);

        Tengah.setText("Tengah");
        getContentPane().add(Tengah);
        Tengah.setBounds(630, 330, 150, 40);

        Labtek_Biru.setText("Labtek Biru");
        getContentPane().add(Labtek_Biru);
        Labtek_Biru.setBounds(630, 130, 150, 40);

        Write.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(Write);
        Write.setBounds(610, 90, 200, 30);

        Tebak.setText("Tebak-Tebakan!!!");
        getContentPane().add(Tebak);
        Tebak.setBounds(630, 300, 150, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel Background;
    private javax.swing.JButton Barat;
    private javax.swing.JButton Fasilitas_Button;
    private javax.swing.JButton Jarak_Button;
    private javax.swing.JLabel Judul;
    private javax.swing.JButton Labtek_Biru;
    private javax.swing.JButton Tebak;
    private javax.swing.JButton Tengah;
    private javax.swing.JButton Timur;
    private javax.swing.JButton Timur_Jauh;
    private javax.swing.JLabel Write;
    private javax.swing.JButton Zona_Button;
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b13;
    private javax.swing.JButton b14;
    private javax.swing.JButton b15;
    private javax.swing.JButton b16;
    private javax.swing.JButton b17;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b2;
    private javax.swing.JButton b20;
    private javax.swing.JButton b21;
    private javax.swing.JButton b22;
    private javax.swing.JButton b23;
    private javax.swing.JButton b24;
    private javax.swing.JButton b25;
    private javax.swing.JButton b26;
    private javax.swing.JButton b27;
    private javax.swing.JButton b28;
    private javax.swing.JButton b29;
    private javax.swing.JButton b3;
    private javax.swing.JButton b30;
    private javax.swing.JButton b31;
    private javax.swing.JButton b32;
    private javax.swing.JButton b33;
    private javax.swing.JButton b34;
    private javax.swing.JButton b35;
    private javax.swing.JButton b36;
    private javax.swing.JButton b37;
    private javax.swing.JButton b38;
    private javax.swing.JButton b39;
    private javax.swing.JButton b4;
    private javax.swing.JButton b40;
    private javax.swing.JButton b41;
    private javax.swing.JButton b42;
    private javax.swing.JButton b43;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    // End of variables declaration//GEN-END:variables
}
