package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ChessBoard extends JFrame implements MouseListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int MARGIN = 30;
	public static final int GRID_SPAN = 35; //网格间距
	public static final int ROWS = 15;
	public static final int COLS = 15;
	
	Chess[] chessList = new Chess[(ROWS+1)*(COLS+1)];
	
	
	boolean isGameOver = false;
	
	boolean isBlackStart = true;
	
	int cheesCount = 0;
	
	int xIndex, yIndex;
	
	Image img;
	Color cheesColorTemp;
	
	public ChessBoard()
	{
		this.img= Toolkit.getDefaultToolkit().getImage("image.jpg");
		//鼠标监听事件
		addMouseListener(this);
		addMouseMotionListener(new MouseMotionListener() 
		{	
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) 
			{
				// TODO Auto-generated method stub
				int x1 = (arg0.getX() - MARGIN + GRID_SPAN / 2) / (GRID_SPAN);
				//将鼠标变成网格索引
				int y1 = (arg0.getY() - MARGIN + GRID_SPAN / 2) / (GRID_SPAN);
				//什么情况下不能下
				if(x1 < 0 || x1 > ROWS || y1 < 0 || y1 > COLS || isGameOver || findChess(x1, y1))
				{
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				else
				{
					setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			}
		});
		
		
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		
		int imgWidth = img.getWidth(this);
		int imgHeight = img.getWidth(this);
		int FWidth = getWidth();
		int FHeight = getHeight();
		
		int x = (FWidth - imgWidth) / 2;
		
		int y = (FHeight - imgHeight) / 2;
		g.drawImage(img, x, y, null);
		
		for(int i = 0; i <= ROWS; i++)
		{
			g.drawLine(MARGIN, MARGIN + i * GRID_SPAN, MARGIN + COLS * GRID_SPAN, MARGIN + i * GRID_SPAN);
		}
		
		for(int i = 0; i < COLS; i++)
		{
			g.drawLine(MARGIN + i * GRID_SPAN, MARGIN, MARGIN + i * GRID_SPAN, MARGIN + ROWS * GRID_SPAN);
		}
		
		for(int i = 0; i < cheesCount; i++)
		{
			int xPos = chessList[i].getX() * GRID_SPAN + MARGIN;
			int yPos = chessList[i].getY() * GRID_SPAN + MARGIN;
			g.setColor(chessList[i].getChessColor());
			
			cheesColorTemp = chessList[i].getChessColor();
			
			if(cheesColorTemp == Color.black)
			{
				RadialGradientPaint paint = new RadialGradientPaint(xPos - Chess.RADIUS / 2 + 25, yPos - Chess.RADIUS / 2 + 10, 20, new float[]{0f, 1f}, new Color[]{Color.white, Color.black});
				((Graphics2D)g).setPaint(paint);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);
				
			}
			else if(cheesColorTemp == Color.white)
			{
				RadialGradientPaint paint = new RadialGradientPaint(xPos - Chess.RADIUS / 2 + 25, yPos - Chess.RADIUS / 2 + 10, 70, new float[]{0f, 1f}, new Color[]{Color.white, Color.black});
				((Graphics2D)g).setPaint(paint);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_DEFAULT);
			}
			else
			{
				
			}
			
			Ellipse2D e = new Ellipse2D.Float(xPos - Chess.RADIUS / 2, yPos - Chess.RADIUS / 2, 34, 35);
			((Graphics2D)g).fill(e);
			
			if(i == cheesCount - 1)
			{
				g.setColor(Color.red);
				g.drawRect(xPos - Chess.RADIUS /2, yPos - Chess.RADIUS /2, 34, 35);
				
			}
			
		}
	}
	
	public void mousePress(MouseEvent e)
	{
		if(isGameOver)
		{
			return;
		}
		
		String colorName = isBlackStart? "黑棋" : "白棋";
		
		xIndex = (e.getX() - MARGIN + GRID_SPAN /2) / GRID_SPAN;
		
		yIndex = (e.getY() - MARGIN + GRID_SPAN /2) / GRID_SPAN;
		
		if(xIndex < 0 || xIndex >ROWS ||yIndex < 0 || yIndex > COLS)
		{
			return;
		}
		
		if(findChess(xIndex, yIndex))
		{
			//已经存在
			return;
		}

		Chess ch = new Chess(xIndex, yIndex, isBlackStart ? Color.black : Color.white);	
		chessList[cheesCount++] = ch;
		repaint();
		
		if(isWin())
		{
			String mas = String.format("恭喜， %s赢了！", colorName);
			JOptionPane.showMessageDialog(this, mas);
			isGameOver = true;
		}
		
		isBlackStart = !isBlackStart;
		
		
		
	}
	
	private boolean findChess(int x, int y)
	{
		// x y 坐标上发现棋子
		for(Chess c : chessList)
		{
			if(c != null && c.getX() == x && c.getY() == y)
			{
				return true;
			}
		}
		return false;
	}

	private boolean isWin()
	{//是否胜利
		int countContine = 1; //连续棋子的个数
		//八个方向
		//横左
		for(int x = xIndex - 1; x >= 0 ;x--)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, yIndex, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}
		}
		//横右
		for(int x = xIndex - 1; x <= COLS; x++)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, yIndex, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}			
		}
		
		if(countContine >= 5)
		{
			return true;
		}
		else
		{
			countContine = 1;
		}
		//上
		for(int x = yIndex - 1; x >= 0; x--)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, yIndex, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}			
		}
		
		//下
		for(int x = yIndex - 1; x <= ROWS; x++)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, yIndex, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}			
		}
		
		if(countContine >= 5)
		{
			return true;
		}
		else
		{
			countContine = 1;
		}
		
		
		//左上
		for(int x = xIndex - 1, y = yIndex - 1; x >= 0 && y >= 0; x--, y--)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, y, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}			
		}
		
		//左下
		for(int x = xIndex - 1, y = yIndex - 1; y >= 0 && x <= COLS; x++, y--)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, y, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}				
		}
		
		if(countContine >= 5)
		{
			return true;
		}
		else
		{
			countContine = 1;
		}
		
		//右上
		for(int x = xIndex - 1, y = yIndex - 1; y <= ROWS && x >= 0; x--, y++)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, y, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}				
		}	
		
		//右下
		for(int x = xIndex - 1, y = yIndex - 1; y <= ROWS && x <= COLS; x++, y++)
		{
			Color cTemp = isBlackStart ? Color.black : Color.white;
			if(GetChess(x, y, cTemp) != null)
			{
				countContine++;
			}
			else
			{
				break;
			}				
		}
		
		if(countContine >= 5)
		{
			return true;
		}
		else
		{
			countContine = 1;
		}
		
		return false;
	}
	
	private Chess GetChess(int xInd, int yInd, Color colorT)
	{
		for(Chess p : chessList)
		{
			if(p != null && p.getX() == xInd && p.getY() == yInd && p.getChessColor() == colorT)
			{
				return p;
			}
		}
		return null;
	}

	public void getRestart()
	{
		for(int i = 0; i < chessList.length; i++)
		{
			chessList[i] = null;
		}
		
		isBlackStart = true;
		
		isGameOver = false;
		
		cheesCount = 0;
		
		repaint();
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(MARGIN * 2 + GRID_SPAN * COLS, MARGIN * 2 + GRID_SPAN * ROWS);
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void goBack()
	{
		if(cheesCount == 0)
		{
			return;
		}
		
		chessList[cheesCount - 1] = null;
		cheesCount--;
		
		if(cheesCount > 0)
		{
			xIndex = chessList[cheesCount - 1].getX();
			yIndex = chessList[cheesCount - 1].getY();
		}
		
		isBlackStart = !isBlackStart;
		repaint();
	}
}
