import java.awt.event.*;

public class BinaryOperations 
{
	Calculator Calc;
	
	BinaryOperations()
	{
		
	}
	BinaryOperations(Calculator c)
	{
		Calc = c;
	}
	
	
	/* Creates a binary numerical input 
	 * @param e the input received
	 */
	public void binOperations(ActionEvent e) {
		// TODO Auto-generated method stub
		if (Calc.getText().getText().length() < 32 && (Calc.getModes()[2].getText().equalsIgnoreCase("QWORD") || Calc.getModes()[2].getText().equalsIgnoreCase("DWORD")))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22) || k == 27))
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
							Calc.getBaseText()[3].setText(Calc.getText().getText());
							Calc.getBaseText()[1].setText(binConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 16 && Calc.getModes()[2].getText().equalsIgnoreCase("WORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22) || k == 27))
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
							Calc.getBaseText()[3].setText(Calc.getText().getText());
							Calc.getBaseText()[1].setText(binConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
		else if (Calc.getText().getText().length() < 8 && Calc.getModes()[2].getText().equalsIgnoreCase("BYTE"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && ((k >= 8 && k <= 10) ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22) || k == 27))
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
							Calc.getBaseText()[3].setText(Calc.getText().getText());
							Calc.getBaseText()[1].setText(binConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[2].setText(Long.toOctalString(y));
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}
	}
	
	/* Creates a binary String 
	 * @param bin the String to convert
	 * @return the binary String
	 */
	public String binConverter(String bin)
	{
		int sum = 0; 
		int toAdd; 
		int mult = 0;
		for (int k = bin.length() - 1; k >= 0; k--)
		{
			int parse = Integer.parseInt(bin.substring(k, k + 1));
			toAdd = (int) (parse * Math.pow(2, mult));
			mult++;
			sum += toAdd;
		}
		String toSend = Long.toString(sum);
		return toSend;
	}
	
}
