import java.awt.event.*;

public class HexaOperations {
	
	Calculator Calc;
	
	HexaOperations()
	{
		
	}
	HexaOperations(Calculator c)
	{
		Calc = c;
	}
	
	/* Creates a hex numerical input
	 * @param e the input received
	 */
	public void hexOperations(ActionEvent e)
	{
		if (Calc.getText().getText().length() < 16 && Calc.getModes()[2].getText().equalsIgnoreCase("QWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 6 && k <= 10) ||
			(k >= 12 && k <= 16) || (k >= 18 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 8 && Calc.getModes()[2].getText().equalsIgnoreCase("DWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 6 && k <= 10) ||
			(k >= 12 && k <= 16) || (k >= 18 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 4 && Calc.getModes()[2].getText().equalsIgnoreCase("WORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 6 && k <= 10) ||
			(k >= 12 && k <= 16) || (k >= 18 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 2 && Calc.getModes()[2].getText().equalsIgnoreCase("BYTE"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 6 && k <= 10) ||
			(k >= 12 && k <= 16) || (k >= 18 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[0].setText(Calc.getText().getText().toUpperCase());
							Calc.getBaseText()[1].setText(hexConverter(Calc.getText().getText(), 10));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
	}
	
	/* Turns a number into it's hex counterpart
	 * @param hex the string to convert
	 * @param radix the base to convert to
	 * @return the hex string
	 */
	public String hexConverter(String hex, int radix)
	{
		int sum = 0;
		int toAdd;
		char at = ' ';
		int mult = 0;
		for (int k = hex.length() - 1; k >= 0; k--)
		{
			if (radix == 10)
			{
				at = hex.charAt(k);
				switch (at)
				{
					case 'A': 
					toAdd  = (int) (10 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					case 'B': 
					toAdd  = (int) (11 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					case 'C': 
					toAdd  = (int) (12 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					case 'D': 
					toAdd  = (int) (13 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					case 'E': 
					toAdd  = (int) (14 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					case 'F': 
					toAdd  = (int) (15 * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
					default:
					int parse = Integer.parseInt(hex.substring(k, k + 1));
					toAdd = (int) (parse * Math.pow(16, mult));
					mult++;
					sum += toAdd;
					break;
				}
			}
		}
		String toSend = Long.toString(sum);
		return toSend;
	}
	
}
