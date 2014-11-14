package main;

import java.awt.FileDialog;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;

public class FileOpen 
{
	private FileDialog fileDialog_open;
	private String fileopen = null;
	private String filename = null;
	private File file;
	private FileReader fileReader;
	private FileWriter fileWriter;
	private BufferedReader bufferedReader; //行读取
	private StringBuffer stringBuffer = new StringBuffer();
	
	NotePad editPad = null;
	
	public void openFile(NotePad notePad)
	{
		editPad = notePad;
		fileDialog_open = new FileDialog(notePad.getFrame(), "打开文件对话框", FileDialog.LOAD);
	
		fileDialog_open.addWindowListener(new WindowListener() 
		{
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				fileDialog_open.setVisible(false);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	public void open()
	{
		String s = "";
		fileDialog_open.setVisible(true);
		fileopen = fileDialog_open.getDirectory();
		filename = fileDialog_open.getFile();
		
		if(filename != null)
		{
			try
			{
				file = new File(fileopen, filename);
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				
				while((s = bufferedReader.readLine()) != null)
				{
					stringBuffer.append(s + "\n");
				}
				bufferedReader.close();
				fileReader.close();
			}
			catch(IOException e)
			{
				System.out.println("无法打开文件");
				e.printStackTrace();
			}
		}
	}

	public String getText()
	{
		return new String(stringBuffer);
	}
	
	public void save(JTextArea jTextArea, NotePad notePad)
	{
		char[] charbuf = jTextArea.getText().toCharArray();
		try 
		{
			if((fileopen != null) && (filename != null))
			{
				file = new File(fileopen, filename);
				fileWriter = new FileWriter(file);
				fileWriter.write(charbuf);
				fileWriter.close();
				//System.exit(0);
				
			}
			else
			{
				saveAs(jTextArea, notePad);
			}
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void saveAs(JTextArea jTextArea, NotePad notePad)
	{
		try 
		{
			editPad = notePad;
			char[] charbuf = jTextArea.getText().toCharArray();
			FileDialog f = new FileDialog(editPad.getFrame(), "另存为", FileDialog.SAVE);
			f.setVisible(true);
			filename = f.getDirectory() + f.getFile();
			fileWriter = new FileWriter(filename + ".txt");
			fileWriter.write(charbuf);
			fileWriter.close();
			//System.exit(0);
		} 
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
