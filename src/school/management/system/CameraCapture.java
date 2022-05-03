/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package school.management.system;

import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author Brian_Gicharu
 */
public class CameraCapture extends JFrame {

    // My vars
    private static VideoCapture capture;
    private static Mat image;
    
    static ImageIcon icon;
    
    static boolean clicked = false;
    static boolean recording= true;
    static boolean reset = false;
    
    static Thread thread;
    
    public static String name = "";
       
    /**
     * Creates new form CameraCapture
     */
    public CameraCapture(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boardJPanel = new javax.swing.JPanel();
        saveImage = new javax.swing.JButton();
        captureImage = new javax.swing.JButton();
        cameraScreen = new javax.swing.JLabel();
        resetBtn = new javax.swing.JButton();
        imgNameLabel = new javax.swing.JLabel();
        saveToFile = new javax.swing.JRadioButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Capture Photo");
        setResizable(false);

        boardJPanel.setBackground(new java.awt.Color(204, 102, 0));

        saveImage.setText("SAVE");
        saveImage.setMaximumSize(new java.awt.Dimension(70, 20));
        saveImage.setMinimumSize(new java.awt.Dimension(70, 20));
        saveImage.setPreferredSize(new java.awt.Dimension(70, 20));
        saveImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageActionPerformed(evt);
            }
        });

        captureImage.setText("CAPTURE");
        captureImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureImageActionPerformed(evt);
            }
        });

        cameraScreen.setOpaque(true);

        resetBtn.setText("RESET");
        resetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetBtnActionPerformed(evt);
            }
        });

        saveToFile.setText("Save to file.");
        saveToFile.setOpaque(false);

        javax.swing.GroupLayout boardJPanelLayout = new javax.swing.GroupLayout(boardJPanel);
        boardJPanel.setLayout(boardJPanelLayout);
        boardJPanelLayout.setHorizontalGroup(
            boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardJPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(boardJPanelLayout.createSequentialGroup()
                        .addComponent(captureImage)
                        .addGap(28, 28, 28)
                        .addComponent(resetBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(imgNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addGroup(boardJPanelLayout.createSequentialGroup()
                                .addComponent(saveToFile)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(saveImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cameraScreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        boardJPanelLayout.setVerticalGroup(
            boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cameraScreen, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(boardJPanelLayout.createSequentialGroup()
                        .addGroup(boardJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(captureImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boardJPanelLayout.createSequentialGroup()
                        .addComponent(imgNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveToFile)
                        .addGap(14, 14, 14))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(boardJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boardJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void saveImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageActionPerformed
        try{
            if(clicked){
                name = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss")
                        .format(new Date());
                // Writing image to file
                if(saveToFile.isSelected()){
                    Imgcodecs.imwrite("src/school/management/captured_photos/"+"PlancksCodeLab_capture_"+
                        (new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss")
                                .format(new Date()))+".jpg",image);
                }
                
                MainClass.sign.photoImageView.setIcon(new ImageIcon(icon.getImage().getScaledInstance(
                        MainClass.sign.photoImageView.getWidth(),
                        MainClass.sign.photoImageView.getHeight(), Image.SCALE_SMOOTH)));
                dispose();
                capture.release();
                recording = true;
            }            
        }catch(Exception ex){System.err.println(ex);}
    }//GEN-LAST:event_saveImageActionPerformed

    private void captureImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureImageActionPerformed
        imgNameLabel.setText("Save Image: "+
                ((name.isEmpty() || name == null)?
                        new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss")
                                .format(new Date()):name)+".jpg?");
        clicked = true;
        recording = false;
    }//GEN-LAST:event_captureImageActionPerformed

    private void resetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetBtnActionPerformed
        recording = true;
        imgNameLabel.setText(null);
        captureThread();
    }//GEN-LAST:event_resetBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardJPanel;
    public static javax.swing.JLabel cameraScreen;
    private javax.swing.JButton captureImage;
    public javax.swing.JLabel imgNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton resetBtn;
    private javax.swing.JButton saveImage;
    private javax.swing.JRadioButton saveToFile;
    // End of variables declaration//GEN-END:variables
    
    // Creates a JFrame of the Class instance
    public void start(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        captureThread();
    }
    
    // Launches a new thread that operates the startCamera method
    public void captureThread(){
        thread = new Thread(() -> {
            CameraCapture.startCamera();
        });
        thread.start();
    }
    
    // Gets H/W access to the default camera (0), takes image frames in the while loop
    // and paints them on the 'cameraScreen JLabel' to visualize a live feed
    public static void startCamera(){
        capture = new VideoCapture(0);
        image = new Mat();        
        byte[] imageData;
        while(recording){
            capture.read(image);
            final MatOfByte IMAGE_BUFF = new MatOfByte();
            Imgcodecs.imencode(".jpg",image,IMAGE_BUFF);
            imageData = IMAGE_BUFF.toArray();
            icon = new ImageIcon(imageData);
            cameraScreen.setIcon(new ImageIcon(icon.getImage()
                    .getScaledInstance(cameraScreen.getWidth(),
                            cameraScreen.getHeight(),Image.SCALE_SMOOTH)));
        }        
    }
}
