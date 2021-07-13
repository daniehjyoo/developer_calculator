import java.awt.event.*;

public class DeciOperations {
	
	Calculator Calc;
	
	DeciOperations()
	{
		
	}
	DeciOperations(Calculator c)
	{
		Calc = c;
	}
	
	
	/* Creates a decimal representation of a number
	 * @param e the action received
	 */
	public void decimalOperations(ActionEvent e)
	{
		if (Calc.getText().getText().length() < 19 && Calc.getModes()[2].getText().equalsIgnoreCase("QWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Integer.toHexString((y.intValue())).toUpperCase());
							Calc.getBaseText()[1].setText(Integer.toString((y.intValue())));
							Calc.getBaseText()[2].setText(Integer.toOctalString((y.intValue())));
							Calc.getBaseText()[3].setText(Integer.toBinaryString((y.intValue())));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
					}
					else
					{
						try
						{
							Calc.getText().setText(Calc.getText().getText() + Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getText().getText());
							Calc.getBaseText()[0].setText(Long.toHexString((y)));
							Calc.getBaseText()[0].setText(Calc.getBaseText()[0].getText().toUpperCase());
							Calc.getBaseText()[1].setText(Long.toString((y)));
							Calc.getBaseText()[2].setText(Long.toOctalString((y)));
							Calc.getBaseText()[3].setText(Long.toBinaryString((y)));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 9 && Calc.getModes()[2].getText().equalsIgnoreCase("DWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Integer.toHexString((y.intValue())).toUpperCase());
							Calc.getBaseText()[1].setText(Integer.toString((y.intValue())));
							Calc.getBaseText()[2].setText(Integer.toOctalString((y.intValue())));
							Calc.getBaseText()[3].setText(Integer.toBinaryString((y.intValue())));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
					}
					else
					{
						try
						{
							Calc.getText().setText(Calc.getText().getText() + Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getText().getText());
							Calc.getBaseText()[0].setText(Long.toHexString((y)));
							Calc.getBaseText()[0].setText(Calc.getBaseText()[0].getText().toUpperCase());
							Calc.getBaseText()[1].setText(Long.toString((y)));
							Calc.getBaseText()[2].setText(Long.toOctalString((y)));
							Calc.getBaseText()[3].setText(Long.toBinaryString((y)));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 5 && Calc.getModes()[2].getText().equalsIgnoreCase("WORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Integer.toHexString((y.intValue())).toUpperCase());
							Calc.getBaseText()[1].setText(Integer.toString((y.intValue())));
							Calc.getBaseText()[2].setText(Integer.toOctalString((y.intValue())));
							Calc.getBaseText()[3].setText(Integer.toBinaryString((y.intValue())));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
					}
					else
					{
						try
						{
							Calc.getText().setText(Calc.getText().getText() + Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getText().getText());
							Calc.getBaseText()[0].setText(Long.toHexString((y)));
							Calc.getBaseText()[0].setText(Calc.getBaseText()[0].getText().toUpperCase());
							Calc.getBaseText()[1].setText(Long.toString((y)));
							Calc.getBaseText()[2].setText(Long.toOctalString((y)));
							Calc.getBaseText()[3].setText(Long.toBinaryString((y)));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 3 && Calc.getModes()[2].getText().equalsIgnoreCase("BYTE"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Integer.toHexString((y.intValue())).toUpperCase());
							Calc.getBaseText()[1].setText(Integer.toString((y.intValue())));
							Calc.getBaseText()[2].setText(Integer.toOctalString((y.intValue())));
							Calc.getBaseText()[3].setText(Integer.toBinaryString((y.intValue())));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
					}
					else
					{
						try
						{
							Calc.getText().setText(Calc.getText().getText() + Calc.getBotP()[k].getText());
							Long y = Long.parseLong(Calc.getText().getText());
							Calc.getBaseText()[0].setText(Long.toHexString((y)));
							Calc.getBaseText()[0].setText(Calc.getBaseText()[0].getText().toUpperCase());
							Calc.getBaseText()[1].setText(Long.toString((y)));
							Calc.getBaseText()[2].setText(Long.toOctalString((y)));
							Calc.getBaseText()[3].setText(Long.toBinaryString((y)));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}


	}
}
