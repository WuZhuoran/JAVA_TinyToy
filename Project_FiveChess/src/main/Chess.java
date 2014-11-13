package main;

import java.awt.Color;

public class Chess 
{
	private int x;
	private int y;
	private Color ChessColor;
	public static int RADIUS = 40;
	
	public Chess(int x, int y, Color chessColor) 
	{
		super();
		this.x = x;
		this.y = y;
		ChessColor = chessColor;
	}

	public int getX() 
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public Color getChessColor() 
	{
		return ChessColor;
	}

}
