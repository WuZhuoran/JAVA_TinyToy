package main;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class SwingTest
{
	private static JTextField textFieldMain;
	
	static double operator1 = 0.0;
	
	static double operator2 = 0.0;
	
	static double result = 0.0;
	
	static Operator4Types operatorType = Operator4Types.UNDEFINED;
	
	public static void main(String[] args) 
	{

		// TODO Auto-generated method stub
		Helloworld hello = new Helloworld();
		
		textFieldMain = new JTextField();
		textFieldMain.setBounds(54, 63, 305, 30);
		hello.getContentPane().add(textFieldMain);
		textFieldMain.setColumns(10);
		
		JButton buttonOne = new JButton("1");
		buttonOne.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("1");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "1";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonOne.setBounds(51, 134, 45, 30);
		hello.getContentPane().add(buttonOne);
		
		JButton buttonTwo = new JButton("2");
		buttonTwo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("2");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "2";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonTwo.setBounds(97, 134, 45, 30);
		hello.getContentPane().add(buttonTwo);
		
		JButton buttonThree = new JButton("3");
		buttonThree.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("3");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "3";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonThree.setBounds(146, 134, 45, 30);
		hello.getContentPane().add(buttonThree);
		
		JButton buttonFour = new JButton("4");
		buttonFour.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("4");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "4";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonFour.setBounds(51, 170, 45, 30);
		hello.getContentPane().add(buttonFour);
		
		JButton buttonFive = new JButton("5");
		buttonFive.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("5");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "5";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonFive.setBounds(97, 170, 45, 30);
		hello.getContentPane().add(buttonFive);
		
		JButton buttonSix = new JButton("6");
		buttonSix.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("6");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "6";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonSix.setBounds(146, 170, 45, 30);
		hello.getContentPane().add(buttonSix);
		
		JButton buttonSeven = new JButton("7");
		buttonSeven.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("7");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "7";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonSeven.setBounds(51, 203, 45, 30);
		hello.getContentPane().add(buttonSeven);
		
		JButton buttonEight = new JButton("8");
		buttonEight.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("8");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "8";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonEight.setBounds(97, 203, 45, 30);
		hello.getContentPane().add(buttonEight);
		
		JButton buttonNine = new JButton("9");
		buttonNine.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					textFieldMain.setText("9");
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "9";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonNine.setBounds(146, 203, 45, 30);
		hello.getContentPane().add(buttonNine);
		
		JButton buttonZero = new JButton("0");
		buttonZero.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//TextField是空的
					//由于是0所以不做操作
				}
				else
				{
					if(operatorType != Operator4Types.EQUAL)
					{
						String temp = textFieldMain.getText();
						temp = temp + "0";
						textFieldMain.setText(temp);
					}
				}
			}
		});
		buttonZero.setBounds(195, 170, 45, 30);
		hello.getContentPane().add(buttonZero);
		
		JButton buttonPlus = new JButton("+");
		buttonPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//空则不做事
				}
				else
				{
					operator1 = Double.valueOf(textFieldMain.getText());
					textFieldMain.setText("");	
					operatorType = Operator4Types.PLUS;
				}

			}
		});
		buttonPlus.setBounds(51, 259, 45, 30);
		hello.getContentPane().add(buttonPlus);
		
		JButton buttonSub = new JButton("-");
		buttonSub.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//空则不做事
				}
				else
				{
					operator1 = Double.valueOf(textFieldMain.getText());
					textFieldMain.setText("");	
					operatorType = Operator4Types.SUB;
				}
			}
		});
		buttonSub.setBounds(97, 259, 45, 30);
		hello.getContentPane().add(buttonSub);
		
		JButton buttonMuli = new JButton("*");
		buttonMuli.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//空则不做事
				}
				else
				{
					operator1 = Double.valueOf(textFieldMain.getText());
					textFieldMain.setText("");
					operatorType = Operator4Types.MULT;
				}
			}
		});
		buttonMuli.setBounds(146, 259, 45, 30);
		hello.getContentPane().add(buttonMuli);
		
		JButton buttonDiv = new JButton("/");
		buttonDiv.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					//空则不做事
				}
				else
				{
					operator1 = Double.valueOf(textFieldMain.getText());
					textFieldMain.setText("");	
					operatorType = Operator4Types.DIV;
				}
			}
		});
		buttonDiv.setBounds(195, 259, 45, 30);
		hello.getContentPane().add(buttonDiv);
		
		JButton buttonGetResult = new JButton("=");
		buttonGetResult.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(textFieldMain.getText().isEmpty() || operatorType == Operator4Types.UNDEFINED)
				{
					//不做事
				}
				else
				{
					operator2 = Double.valueOf(textFieldMain.getText());
					switch(operatorType)
					{
					case PLUS:
						result = operator1 + operator2;
						textFieldMain.setText(String.valueOf(result));
						break;
					case SUB:
						result = operator1 - operator2;
						textFieldMain.setText(String.valueOf(result));						
						break;
					case MULT:
						result = operator1 * operator2;
						textFieldMain.setText(String.valueOf(result));						
						break;
					case DIV:
						result = operator1 / operator2;
						textFieldMain.setText(String.valueOf(result));						
						break;
					default:
						break;
					}
					
					operatorType = Operator4Types.EQUAL;
					operator1 = 0.0;
					operator2 = 0.0;
				}
			}
		});
		buttonGetResult.setBounds(51, 292, 45, 30);
		hello.getContentPane().add(buttonGetResult);
		
		JButton buttonRefresh = new JButton("C");
		buttonRefresh.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				textFieldMain.setText("");
				operator1 = 0.0;
				operator2 = 0.0;
				operatorType = Operator4Types.UNDEFINED;
				result = 0.0;
			}
		});
		buttonRefresh.setBounds(97, 292, 45, 30);
		hello.getContentPane().add(buttonRefresh);
		hello.setVisible(true);
		
		textFieldMain.setEnabled(false);
		
		JLabel LabelForTips = new JLabel("Tips");
		LabelForTips.setBounds(54, 21, 54, 15);
		hello.getContentPane().add(LabelForTips);
		
		JButton buttonSqrt = new JButton("Sqrt");
		buttonSqrt.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(textFieldMain.getText().isEmpty())
				{
					return;
				}
				else if(Double.valueOf(textFieldMain.getText()) < 0)
				{
					LabelForTips.setText("");
					LabelForTips.setText("不能为负数！");
					return;
				}
				else
				{
					LabelForTips.setText("");
					textFieldMain.setText(Double.toString(Math.sqrt(Double.valueOf(textFieldMain.getText()))));
				}
			}
		});
		buttonSqrt.setBounds(251, 259, 71, 30);
		hello.getContentPane().add(buttonSqrt);
		
		JButton buttonSin = new JButton("Sin");
		buttonSin.setBounds(330, 259, 71, 30);
		hello.getContentPane().add(buttonSin);
	}
}
