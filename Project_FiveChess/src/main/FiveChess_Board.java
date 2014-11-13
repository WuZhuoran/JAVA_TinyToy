package main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FiveChess_Board extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private ChessBoard chessBoard;
	private JMenuBar menuBar;
	private JMenu sysMenu;	
	private JMenuItem startMenuItem;
	private JMenuItem exitMenuItem;
	private JMenuItem backMenuItem;
	
	private JButton startButton;
	private JButton exitButton;
	private JButton backButton;
	
	private JPanel toolbar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					FiveChess_Board frame = new FiveChess_Board();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public FiveChess_Board() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("五子棋");
		
		chessBoard = new ChessBoard();
		Container contentPane = getContentPane();
		contentPane.add(chessBoard);
		
		menuBar = new JMenuBar();
		sysMenu = new JMenu();
		
		startMenuItem = new JMenuItem("开始");
		exitMenuItem = new JMenuItem("退出");
		backMenuItem = new JMenuItem("悔棋");
		
		sysMenu.add(startMenuItem);
		sysMenu.add(backMenuItem);
		sysMenu.add(exitMenuItem);
		
		MyItemLister lis = new MyItemLister();
		
		this.startMenuItem.addActionListener(lis);
		this.backMenuItem.addActionListener(lis);
		this.exitMenuItem.addActionListener(lis);
		
		menuBar.add(sysMenu);
		setJMenuBar(menuBar);
		
		toolbar = new JPanel();
		
		startButton = new JButton("重新开始");
		exitButton = new JButton("退出");
		backButton = new JButton("悔棋");
		
		toolbar.setLayout(new FlowLayout(FlowLayout.LEFT));
		toolbar.add(startButton);
		toolbar.add(exitButton);
		toolbar.add(backButton);
		
		startButton.addActionListener(lis);
		exitButton.addActionListener(lis);
		backButton.addActionListener(lis);
		
		add(toolbar, BorderLayout.SOUTH);
		add(chessBoard);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
	
	}

	private class MyItemLister implements ActionListener
	{
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Object obj = e.getSource();
			// TODO Auto-generated method stub
			if(obj == FiveChess_Board.this.startMenuItem || obj == FiveChess_Board.this.startButton)
			{
				System.out.println("重新开始！");
				chessBoard.getRestart();
			}
			else if(obj == exitMenuItem || obj == FiveChess_Board.this.exitButton)
			{
				System.exit(0);
			}
			else if(obj == backMenuItem || obj == FiveChess_Board.this.backButton)
			{
				System.out.println("悔棋");
				chessBoard.goBack();
			}
		}
		
	}
}
