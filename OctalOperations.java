import java.awt.event.*;

public class OctalOperations {
	
	Calculator Calc;
	
	OctalOperations()
	{
		
	}
	OctalOperations(Calculator c)
	{
		Calc = c;
	}
	
	/* Creates an octal numerical display
	 * @param e the input received
	 */
	public void octOperations(ActionEvent e) 
	{
		if (Calc.getText().getText().length() < 22 && Calc.getModes()[2].getText().equalsIgnoreCase("QWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && (k == 8 ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal here
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
							break;
						}
						catch (NumberFormatException ex)
						{
							
						}
				}
				}
			}
		}		
		else if (Calc.getText().getText().length() < 10 && Calc.getModes()[2].getText().equalsIgnoreCase("DWORD"))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (e.getSource().equals(Calc.getBotP()[k]) && (k == 8 ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal here
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
				if (e.getSource().equals(Calc.getBotP()[k]) && (k == 8 ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal here
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
				if (e.getSource().equals(Calc.getBotP()[k]) && (k == 8 ||
						(k >= 14 && k <= 16) || (k >= 20 && k <= 22)|| k == 27))
				{
					if (Calc.getText().getText().equals("0"))
					{
						try 
						{
							Calc.getText().setText(Calc.getBotP()[k].getText());
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal here
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
							Calc.getBaseText()[2].setText(Calc.getText().getText());
							// Convert to Decimal
							Calc.getBaseText()[1].setText(octConverter(Calc.getText().getText()));
							Long y = Long.parseLong(Calc.getBaseText()[1].getText());
							Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
							Calc.getBaseText()[3].setText(Long.toBinaryString(y));
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
	
	/* Creates a octal String
	 * @param oct the string to convert
	 * @return an octal string
	 */
	public String octConverter(String oct)
	{
		int sum = 0; 
		int toAdd; 
		int mult = 0;
		for (int k = oct.length() - 1; k >= 0; k--)
		{
			int parse = Integer.parseInt(oct.substring(k, k + 1));
			toAdd = (int) (parse * Math.pow(8, mult));
			mult++;
			sum += toAdd;
		}
		String toSend = Long.toString(sum);
		return toSend;
	}
}
