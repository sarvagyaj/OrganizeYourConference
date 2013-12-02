package edu.sjsu.conference.uploadfiles;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.springframework.web.servlet.ModelAndView;

import java.awt.BorderLayout;
import java.io.File;


public class FileDialog{
    
	File selectedFile= null;
    JFrame guiFrame;
    JTextArea tracker; 
    JPanel optPanel;
    JFileChooser fileDialog;
   
    
    public FileDialog()
    { 
        guiFrame = new JFrame();
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("Select File");
        guiFrame.setSize(500,300);
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setLayout(new BorderLayout());
        fileDialog = new JFileChooser();
    }
    
    //Show a open file dialog box
    public File openDialog()
    {
    	 	guiFrame.setVisible(true);
        	fileDialog.showOpenDialog(guiFrame);
        	selectedFile = fileDialog.getSelectedFile();
            //System.out.println("Selected file:: " +selectedFile.getName());
            guiFrame.setVisible(false);
            if(selectedFile != null)
            	
            	return selectedFile;
           
            return null;
		
       
    }
        
 }