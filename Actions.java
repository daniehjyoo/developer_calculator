import java.awt.*;
import java.awt.event.*;

public class Actions implements ActionListener{
	
	Calculator Calc;
	BinaryOperations binOp;
	HexaOperations hexOp;
	DeciOperations decOp;
	OctalOperations octOp;
	Eval_uation eval;
	
	Actions()
	{
		
	}
	Actions(Calculator c)
	{
		Calc = c;
		binOp = new BinaryOperations(c);
		hexOp = new HexaOperations(c);
		decOp = new DeciOperations(c);
		octOp = new OctalOperations(c);
		eval = new Eval_uation(c);
	}
	
	@Override
	/* Performs actions based on events received
	 *  @param e the event received by the ActionListener
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// Checks to see if it's undefined and removes if it is (no ops allowed with undefined)
		if (Calc.getText().getText().equals("Undefined"))
		{
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
			Calc.getText().setText("0");
		}
		// All the bases are checked to see which is selected
		if (e.getSource().equals(Calc.getChange()[0]))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (k != 28)
				{
					Calc.getBotP()[k].setEnabled(true);
				}
			}
			Calc.getText().setText(Calc.getBaseText()[0].getText());
			Calc.getChange()[0].setForeground(new Color(0, 128, 255));
			Calc.getDisplay()[0].setForeground(new Color(0, 128, 255));
			for (int k = 0; k < 4; k++)
			{
				if (k != 0)
				{
					Calc.getChange()[k].setForeground(new Color(0, 0, 0));
					Calc.getDisplay()[k].setForeground(new Color(0, 0, 0));
				}
			}
			Calc.getEquation().setText(Calc.gethEquation());
		}
		else if (e.getSource().equals(Calc.getChange()[1]))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if (k == 6 || k == 7 || k == 12 || k == 13 || k == 18 || k == 19 || k == 28)
				{
					Calc.getBotP()[k].setEnabled(false);
				}
				else
				{
					Calc.getBotP()[k].setEnabled(true);
				}
			}
			Calc.getChange()[1].setForeground(new Color(0, 128, 255));
			Calc.getDisplay()[1].setForeground(new Color(0, 128, 255));
			for (int k = 0; k < 4; k++)
			{
				if (k != 1)
				{
					Calc.getChange()[k].setForeground(new Color(0, 0, 0));
					Calc.getDisplay()[k].setForeground(new Color(0, 0, 0));
				}
			}
			Calc.getText().setText(Calc.getBaseText()[1].getText());
			Calc.getEquation().setText(Calc.getdEquation());
		}
		else if (e.getSource().equals(Calc.getChange()[2]))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if ((k >= 6 && k <= 10 && k != 8) || k == 12 || k == 13 || k == 18 || k == 19 || k == 28)
				{
					Calc.getBotP()[k].setEnabled(false);
				}
				else
				{
					Calc.getBotP()[k].setEnabled(true);
				}
			}
			Calc.getChange()[2].setForeground(new Color(0, 128, 255));
			Calc.getDisplay()[2].setForeground(new Color(0, 128, 255));
			for (int k = 0; k < 4; k++)
			{
				if (k != 2)
				{
					Calc.getChange()[k].setForeground(new Color(0, 0, 0));
					Calc.getDisplay()[k].setForeground(new Color(0, 0, 0));
				}
			}
			Calc.getText().setText(Calc.getBaseText()[2].getText());
			Calc.getEquation().setText(Calc.getoEquation());
		}
		else if (e.getSource().equals(Calc.getChange()[3]))
		{
			for (int k = 0; k < Calc.getBotP().length; k++)
			{
				if ((k >= 6 && k <= 10) || (k >= 12 && k <= 16) ||
						(k >= 18 && k <= 22 && k != 20) || k == 28)
				{
					Calc.getBotP()[k].setEnabled(false);
				}
				else
				{
					Calc.getBotP()[k].setEnabled(true);
				}
			}
			Calc.getChange()[3].setForeground(new Color(0, 128, 255));
			Calc.getDisplay()[3].setForeground(new Color(0, 128, 255));
			for (int k = 0; k < 4; k++)
			{
				if (k != 3)
				{
					Calc.getChange()[k].setForeground(new Color(0, 0, 0));
					Calc.getDisplay()[k].setForeground(new Color(0, 0, 0));
				}
			}
			Calc.getText().setText(Calc.getBaseText()[3].getText());
			Calc.getEquation().setText(Calc.getbEquation());
		}

		// Now to check the bottom half of the Calc.getDisplay() to see if it's selected (text buttons only)
		else if (e.getSource().equals(Calc.getBotP()[6]) || e.getSource().equals(Calc.getBotP()[7]) || e.getSource().equals(Calc.getBotP()[8])
				|| e.getSource().equals(Calc.getBotP()[9]) || e.getSource().equals(Calc.getBotP()[10]) || e.getSource().equals(Calc.getBotP()[12])
				|| e.getSource().equals(Calc.getBotP()[13]) || e.getSource().equals(Calc.getBotP()[14]) || e.getSource().equals(Calc.getBotP()[15])
				|| e.getSource().equals(Calc.getBotP()[16]) || e.getSource().equals(Calc.getBotP()[18]) || e.getSource().equals(Calc.getBotP()[19])
				|| e.getSource().equals(Calc.getBotP()[20]) || e.getSource().equals(Calc.getBotP()[21]) || e.getSource().equals(Calc.getBotP()[22])
				|| e.getSource().equals(Calc.getBotP()[27]))
		{
			if (Calc.getChange()[0].isSelected())
			{
				if (Calc.isEqualsLast())
				{
					Calc.getText().setText("0");
					Calc.getBaseText()[0].setText("0");
					Calc.getBaseText()[1].setText("0");
					Calc.getBaseText()[2].setText("0");
					Calc.getBaseText()[3].setText("0");
					Calc.setEqualsLast(false); // Removes padded 0s
				}
				hexOp.hexOperations(e);
			}
			else if (Calc.getChange()[1].isSelected())
			{
				if (Calc.isEqualsLast())
				{
					Calc.getText().setText("0");
					Calc.getBaseText()[0].setText("0");
					Calc.getBaseText()[1].setText("0");
					Calc.getBaseText()[2].setText("0");
					Calc.getBaseText()[3].setText("0");
					Calc.setEqualsLast(false); // Removes padded 0s
				}
				decOp.decimalOperations(e);
			}
			else if (Calc.getChange()[2].isSelected())
			{
				if (Calc.isEqualsLast())
				{
					Calc.getText().setText("0");
					Calc.getBaseText()[0].setText("0");
					Calc.getBaseText()[1].setText("0");
					Calc.getBaseText()[2].setText("0");
					Calc.getBaseText()[3].setText("0");
					Calc.setEqualsLast(false); // Removes padded 0s
				}
				octOp.octOperations(e);
			}
			else
			{
				if (Calc.isEqualsLast())
				{
					Calc.getText().setText("0");
					Calc.getBaseText()[0].setText("0");
					Calc.getBaseText()[1].setText("0");
					Calc.getBaseText()[2].setText("0");
					Calc.getBaseText()[3].setText("0");
					Calc.setEqualsLast(false); // Removes padded 0s
				}
				binOp.binOperations(e);
			}
		}
		// Start of operations (Clearing)
		else if (e.getSource().equals(Calc.getBotP()[2]) || e.getSource().equals(Calc.getBotP()[3]))
		{
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
			if (e.getSource().equals(Calc.getBotP()[3]))
			{
				Calc.getEquation().setText("");
				Calc.sethEquation("");
				Calc.setdEquation("");
				Calc.setoEquation("");
				Calc.setbEquation("");
				Calc.setEval("  ");
			}
		}
		// Negations
		else if (e.getSource().equals(Calc.getBotP()[26]))
		{
			if (Calc.getBaseText()[1].getText().contains("-"))
			{
				Calc.getBaseText()[1].setText(Calc.getBaseText()[1].getText().replace("-", ""));
				Long y = Long.parseLong(Calc.getBaseText()[1].getText());
				Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
				Calc.getBaseText()[2].setText(Long.toOctalString(y));
				Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				if (Calc.getChange()[0].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[0].getText());
				}
				else if (Calc.getChange()[1].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[1].getText());
				}
				else if (Calc.getChange()[2].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[2].getText());
				}
				else if (Calc.getChange()[3].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[3].getText());
				}
			}
			else
			{
				if (Calc.getBaseText()[1].getText().equals("0") || Calc.getBaseText()[1].getText().equals(""))
				{
					
				}
				else
				{
					Calc.getBaseText()[1].setText("-" + Calc.getBaseText()[1].getText());
					Long y = Long.parseLong(Calc.getBaseText()[1].getText());
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}

				if (Calc.getChange()[0].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[0].getText());
				}
				else if (Calc.getChange()[1].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[1].getText());
				}
				else if (Calc.getChange()[2].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[2].getText());
				}
				else if (Calc.getChange()[3].isSelected())
				{
					Calc.getText().setText(Calc.getBaseText()[3].getText());
				}
			}
			

		}
		// Back Space and erasure 
		else if (e.getSource().equals(Calc.getBotP()[4]))
		{
			if (Calc.getText().getText().length() == 1 || (Calc.getText().getText().length() == 2 && Calc.getText().getText().contains("-")))
			{
				Calc.getText().setText("0");
				Calc.getBaseText()[0].setText("0");
				Calc.getBaseText()[1].setText("0");
				Calc.getBaseText()[2].setText("0");
				Calc.getBaseText()[3].setText("0");
			}
			else
			{
				Calc.getText().setText(Calc.getText().getText().substring(0, Calc.getText().getText().length() - 1));
				if (Calc.getChange()[0].isSelected())
				{
					Calc.getBaseText()[1].setText(hexOp.hexConverter(Calc.getText().getText(), 10));
					Long y = Long.parseLong(Calc.getBaseText()[1].getText());
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}
				else if (Calc.getChange()[1].isSelected())
				{
					Calc.getBaseText()[1].setText(Calc.getText().getText());
					Long y = Long.parseLong(Calc.getBaseText()[1].getText());
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}
				else if (Calc.getChange()[2].isSelected())
				{
					Calc.getBaseText()[1].setText(octOp.octConverter(Calc.getText().getText()));
					Long y = Long.parseLong(Calc.getBaseText()[1].getText());
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}
				else if (Calc.getChange()[3].isSelected())
				{
					Calc.getBaseText()[1].setText(binOp.binConverter(Calc.getText().getText()));
					Long y = Long.parseLong(Calc.getBaseText()[1].getText());
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}
			}
		}
		// Shift Button
		else if (e.getSource().equals(Calc.getBotP()[0]))
		{
			if (Calc.getTopP()[0].getText().equals("Lsh"))
			{
				Calc.getTopP()[0].setText("RoL");
				Calc.getTopP()[1].setText("RoR");
			}
			else
			{
				Calc.getTopP()[0].setText("Lsh");
				Calc.getTopP()[1].setText("Rsh");
			}
			
		}
		// Modular arithmatic
		else if (e.getSource().equals(Calc.getBotP()[1]))
		{
			Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " " + Calc.getBotP()[1].getText() + " ");
			Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " " + Calc.getBotP()[1].getText() + " ");
			Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " " + Calc.getBotP()[1].getText() + " ");
			Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " " + Calc.getBotP()[1].getText() + " ");
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getEquation().setText(Calc.gethEquation());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getEquation().setText(Calc.getdEquation());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getEquation().setText(Calc.getoEquation());
			}
			else
			{
				Calc.getEquation().setText(Calc.getbEquation());
			}
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " " + Calc.getBotP()[1].getText());
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
		}
		// Division
		else if (e.getSource().equals(Calc.getBotP()[5]))
		{
			Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " "  + "/ ");
			Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " "  + "/ ");
			Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " "  + "/ ");
			Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " "  + "/ ");
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getEquation().setText(Calc.gethEquation());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getEquation().setText(Calc.getdEquation());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getEquation().setText(Calc.getoEquation());
			}
			else
			{
				Calc.getEquation().setText(Calc.getbEquation());
			}
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " / ");
			
			
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
		}
		// Multiplication
		else if (e.getSource().equals(Calc.getBotP()[11]))
		{
			Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " " + Calc.getBotP()[11].getText() + " ");
			Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " " + Calc.getBotP()[11].getText() + " ");
			Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " " + Calc.getBotP()[11].getText() + " ");
			Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " " + Calc.getBotP()[11].getText() + " ");
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getEquation().setText(Calc.gethEquation());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getEquation().setText(Calc.getdEquation());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getEquation().setText(Calc.getoEquation());
			}
			else
			{
				Calc.getEquation().setText(Calc.getbEquation());
			}
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " " + Calc.getBotP()[11].getText());
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
		}
		// Subtraction
		else if (e.getSource().equals(Calc.getBotP()[17]))
		{
			Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " " + Calc.getBotP()[17].getText() + " ");
			Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " " + Calc.getBotP()[17].getText() + " ");
			Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " " + Calc.getBotP()[17].getText() + " ");
			Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " " + Calc.getBotP()[17].getText() + " ");
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getEquation().setText(Calc.gethEquation());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getEquation().setText(Calc.getdEquation());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getEquation().setText(Calc.getoEquation());
			}
			else
			{
				Calc.getEquation().setText(Calc.getbEquation());
			}
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " " + Calc.getBotP()[17].getText());
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
		}
		// Addition
		else if (e.getSource().equals(Calc.getBotP()[23]))
		{
			Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " " + Calc.getBotP()[23].getText() + " ");
			Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " " + Calc.getBotP()[23].getText() + " ");
			Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " " + Calc.getBotP()[23].getText() + " ");
			Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " " + Calc.getBotP()[23].getText() + " ");
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getEquation().setText(Calc.gethEquation());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getEquation().setText(Calc.getdEquation());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getEquation().setText(Calc.getoEquation());
			}
			else
			{
				Calc.getEquation().setText(Calc.getbEquation());
			}
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " " + Calc.getBotP()[23].getText());
			Calc.getText().setText("0");
			Calc.getBaseText()[0].setText("0");
			Calc.getBaseText()[1].setText("0");
			Calc.getBaseText()[2].setText("0");
			Calc.getBaseText()[3].setText("0");
		}
		// Left Parenthesis
		else if (e.getSource().equals(Calc.getBotP()[24]))
		{
			String eq = Calc.getEquation().getText();
			if (eq.equals("") || eq.charAt(eq.length() - 2) == 'x' || eq.charAt(eq.length() - 2) == '-'
					|| eq.charAt(eq.length() - 2) == '+' || eq.charAt(eq.length() - 2) == '/' || eq.charAt(eq.length() - 2) == 'd'
					|| eq.charAt(eq.length() - 2) == '(')
			{
				Calc.sethEquation(Calc.gethEquation()  + " " + Calc.getBotP()[24].getText() + " ");
				Calc.setdEquation(Calc.getdEquation()  + " " + Calc.getBotP()[24].getText() + " ");
				Calc.setoEquation(Calc.getoEquation()  + " " + Calc.getBotP()[24].getText() + " ");
				Calc.setbEquation(Calc.getbEquation()  + " " + Calc.getBotP()[24].getText() + " ");
				if (Calc.getChange()[0].isSelected())
				{
					Calc.getEquation().setText(Calc.gethEquation());
				}
				else if (Calc.getChange()[1].isSelected())
				{
					Calc.getEquation().setText(Calc.getdEquation());
				}
				else if (Calc.getChange()[2].isSelected())
				{
					Calc.getEquation().setText(Calc.getoEquation());
				}
				else
				{
					Calc.getEquation().setText(Calc.getbEquation());
				}
				Calc.setEval(Calc.getEval() +  " " + Calc.getBotP()[24].getText());
				Calc.getText().setText("0");
				Calc.getBaseText()[0].setText("0");
				Calc.getBaseText()[1].setText("0");
				Calc.getBaseText()[2].setText("0");
				Calc.getBaseText()[3].setText("0");
			}
		}
		// Right Parenthesis
		else if (e.getSource().equals(Calc.getBotP()[25]))
		{
			String eq = Calc.getEquation().getText();
			int lPCount = pCounter(eq, '(');
			int rPCount = pCounter(eq, ')');
			if (lPCount > rPCount && !(eq.equals("")) && (eq.charAt(eq.length() - 2) != 'x' | eq.charAt(eq.length() - 2) != '-'
					|| eq.charAt(eq.length() - 2) != '+' || eq.charAt(eq.length() - 2) != '/' 
					|| eq.charAt(eq.length() - 2) != 'd'))
			{
				Calc.sethEquation(Calc.gethEquation() + Calc.getDisplay()[0].getText() + " " + Calc.getBotP()[25].getText() + " ");
				Calc.setdEquation(Calc.getdEquation() + Calc.getDisplay()[1].getText() + " " + Calc.getBotP()[25].getText() + " ");
				Calc.setoEquation(Calc.getoEquation() + Calc.getDisplay()[2].getText() + " " + Calc.getBotP()[25].getText() + " ");
				Calc.setbEquation(Calc.getbEquation() + Calc.getDisplay()[3].getText() + " " + Calc.getBotP()[25].getText() + " ");
				if (Calc.getChange()[0].isSelected())
				{
					Calc.getEquation().setText(Calc.gethEquation());
				}
				else if (Calc.getChange()[1].isSelected())
				{
					Calc.getEquation().setText(Calc.getdEquation());
				}
				else if (Calc.getChange()[2].isSelected())
				{
					Calc.getEquation().setText(Calc.getoEquation());
				}
				else
				{
					Calc.getEquation().setText(Calc.getbEquation());
				}
				Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText() + " " + Calc.getBotP()[25].getText());
				Calc.getText().setText("");
				Calc.getBaseText()[0].setText("");
				Calc.getBaseText()[1].setText("");
				Calc.getBaseText()[2].setText("");
				Calc.getBaseText()[3].setText("");
			}
		}
		// Equals
		else if (e.getSource().equals(Calc.getBotP()[29]))
		{
			if (Calc.getEval().charAt(0) == '0')
			{
				Calc.setEval(Calc.getEval().substring(1));
			}
			String check = "";
			
			int lP = pCounter(Calc.getEval(), '('); // count left parenthesis
			int rP = pCounter(Calc.getEval(), ')'); // count right
			
			// If the number is uneven, balance it out
			while (lP > rP)
			{
				//Calc.getEval() += " ) ";
				Calc.setEval(Calc.getEval() + " ) ");
				rP++;
			}
			// Evaluate all parenthesis one at a time
			while (lP > 0)
			{
				if (Calc.getEval().contains("("))
				{
					check = Calc.getEval().substring(Calc.getEval().lastIndexOf('('), (Calc.getEval().indexOf(')', Calc.getEval().lastIndexOf('(')) + 1));
					check = eval.evaluate(check);
					Calc.setEval(Calc.getEval().substring(0, Calc.getEval().lastIndexOf('(')) + " " + check + " " + 
					Calc.getEval().substring(Calc.getEval().indexOf(')', Calc.getEval().lastIndexOf('(') + 1)));
					lP--;
				}
			}
			// Remove all parenthesis remaining
			while (Calc.getEval().contains(")"))
			{
				Calc.setEval(Calc.getEval().substring(0, Calc.getEval().indexOf(")")) + Calc.getEval().substring(Calc.getEval().indexOf(")") + 1));
			}
			
			// Check undefined
			Calc.setEval(Calc.getEval() + " " + Calc.getBaseText()[1].getText()); // Add on the final operand
			if (Calc.getEval().contains("Undefined"))
			{
				Calc.setResult("Undefined");
			}
			else
			{
				Calc.setResult(eval.evaluate(Calc.getEval())); // Evaluate fully
			}
			Calc.getEquation().setText("  ");
			Calc.sethEquation("");
			Calc.setdEquation("");
			Calc.setoEquation("");
			Calc.setbEquation("");
			
			// Check again for undefined
			if (Calc.getResult().contains("Infinity"))
			{
				Calc.setResult("Undefined");
			}
			
			Calc.setEval("  "); // Reset the evaluation
			Calc.getBaseText()[1].setText(Calc.getResult());
			// No parsing if it is undefined
			if (Calc.getResult().contains("Undefined"))
			{
				Calc.getBaseText()[0].setText("Undefined");
				Calc.getBaseText()[2].setText("Undefined");
				Calc.getBaseText()[3].setText("Undefined");
			}
			else
			{
				Long y = Long.parseLong(Calc.getResult());
				Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
				Calc.getBaseText()[2].setText(Long.toOctalString(y));
				Calc.getBaseText()[3].setText(Long.toBinaryString(y));
			}
			if (Calc.getChange()[0].isSelected())
			{
				Calc.getText().setText(Calc.getBaseText()[0].getText());
			}
			else if (Calc.getChange()[1].isSelected())
			{
				Calc.getText().setText(Calc.getBaseText()[1].getText());
			}
			else if (Calc.getChange()[2].isSelected())
			{
				Calc.getText().setText(Calc.getBaseText()[2].getText());
			}
			else if (Calc.getChange()[3].isSelected())
			{
				Calc.getText().setText(Calc.getBaseText()[3].getText());
			}
			Calc.setEqualsLast(true);
				
		}
		// Mode Calc.getChange()r (Essentially just caps off expressions at certain marks)
		else if (e.getSource().equals(Calc.getModes()[2]))
		{
			//Calc.getCounter()++;
			Calc.setCounter(Calc.getCounter() + 1);
			if (Calc.getCounter() == 4)
			{
				Calc.setCounter(0);
			}
			if (Calc.getCounter() == 0)
			{
				Calc.getModes()[2].setText("QWORD");
			}
			else if (Calc.getCounter() == 1)
			{
				Calc.getModes()[2].setText("DWORD");
			}
			else if (Calc.getCounter() == 2)
			{
				Calc.getModes()[2].setText("WORD");
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 65535)
				{
					Calc.getBaseText()[1].setText("65535");
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
				}
			}
			else
			{
				Calc.getModes()[2].setText("BYTE");
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 255)
				{
					Calc.getBaseText()[1].setText("255");
					Calc.getBaseText()[0].setText(Long.toHexString(y).toUpperCase());
					Calc.getBaseText()[2].setText(Long.toOctalString(y));
					Calc.getBaseText()[3].setText(Long.toBinaryString(y));
					if (Calc.getChange()[0].isSelected())
					{
						Calc.getDisplayText().setText(Calc.getDisplay()[0].getText());
					}
					else if (Calc.getChange()[1].isSelected())
					{
						Calc.getDisplayText().setText(Calc.getDisplay()[1].getText());
					}
					else if (Calc.getChange()[2].isSelected())
					{
						Calc.getDisplayText().setText(Calc.getDisplay()[2].getText());
					}
					else
					{
						Calc.getDisplayText().setText(Calc.getDisplay()[2].getText());
					}
				}
			}
		}
		// Format it to look nicer 
		StringBuilder hex = new StringBuilder(Calc.getBaseText()[0].getText());
		StringBuilder dec = new StringBuilder(Calc.getBaseText()[1].getText());
		StringBuilder oct = new StringBuilder(Calc.getBaseText()[2].getText());
		StringBuilder bin = new StringBuilder(Calc.getBaseText()[3].getText());
		
		for (int k = hex.length() - 4; k > 0; k-= 4)
		{
			hex.insert(k, " ");
		}
		
		for (int k = dec.length() - 3; k > 0; k-= 3)
		{
			dec.insert(k, ",");
		}
		
		for (int k = oct.length() - 3; k > 0; k-= 3)
		{
			oct.insert(k, " ");
		}
		
		for (int k = bin.length() - 4; k > 0; k-= 4)
		{
			bin.insert(k, " ");
		}
		
		String h = hex.toString();
		String d = dec.toString();
		String o = oct.toString();
		String b = bin.toString();
		
		Calc.getDisplay()[0].setText(h);
		Calc.getDisplay()[1].setText(d);
		Calc.getDisplay()[2].setText(o);
		Calc.getDisplay()[3].setText(b);
		// Setting the final box
		if (Calc.getChange()[0].isSelected())
		{
			Calc.getDisplayText().setText(Calc.getDisplay()[0].getText());
			if (Calc.getModes()[2].getText().equalsIgnoreCase("WORD") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 65535)
				{
					Calc.getDisplayText().setText("FFFF");
					Calc.getDisplay()[0].setText("FFFF");
					Calc.getDisplay()[1].setText("65535");
					Calc.getDisplay()[2].setText("177 513");
					Calc.getDisplay()[3].setText("1111 1111 1111 1111");
				}
			}
			else if (Calc.getModes()[2].getText().equalsIgnoreCase("BYTE") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 255)
				{
					Calc.getDisplayText().setText("FF");
					Calc.getDisplay()[0].setText("FF");
					Calc.getDisplay()[1].setText("255");
					Calc.getDisplay()[2].setText("377");
					Calc.getDisplay()[3].setText("1111 1111");
				}
			}
		}
		else if (Calc.getChange()[1].isSelected())
		{
			Calc.getDisplayText().setText(Calc.getDisplay()[1].getText());
			if (Calc.getModes()[2].getText().equalsIgnoreCase("WORD") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 65535)
				{
					Calc.getDisplayText().setText("65535");
					Calc.getDisplay()[0].setText("FFFF");
					Calc.getDisplay()[1].setText("65535");
					Calc.getDisplay()[2].setText("177 513");
					Calc.getDisplay()[3].setText("1111 1111 1111 1111");
				}
			}
			else if (Calc.getModes()[2].getText().equalsIgnoreCase("BYTE") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 255)
				{
					Calc.getDisplayText().setText("255");
					Calc.getDisplay()[0].setText("FF");
					Calc.getDisplay()[1].setText("255");
					Calc.getDisplay()[2].setText("377");
					Calc.getDisplay()[3].setText("1111 1111");
				}
			}
		}
		else if (Calc.getChange()[2].isSelected())
		{
			Calc.getDisplayText().setText(Calc.getDisplay()[2].getText());
			if (Calc.getModes()[2].getText().equalsIgnoreCase("WORD") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 65535)
				{
					Calc.getDisplayText().setText("177 513");
					Calc.getDisplay()[0].setText("FFFF");
					Calc.getDisplay()[1].setText("65535");
					Calc.getDisplay()[2].setText("177 513");
					Calc.getDisplay()[3].setText("1111 1111 1111 1111");
				}
			}
			else if (Calc.getModes()[2].getText().equalsIgnoreCase("BYTE") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 255)
				{
					Calc.getDisplayText().setText("371");
					Calc.getDisplay()[0].setText("FF");
					Calc.getDisplay()[1].setText("255");
					Calc.getDisplay()[2].setText("377");
					Calc.getDisplay()[3].setText("1111 1111");
				}
			}
		}
		else if (Calc.getChange()[3].isSelected())
		{
			Calc.getDisplayText().setText(Calc.getDisplay()[3].getText());
			if (Calc.getModes()[2].getText().equalsIgnoreCase("WORD") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 65535)
				{
					Calc.getDisplayText().setText("1111 1111 1111 1111");
					Calc.getDisplay()[0].setText("FFFF");
					Calc.getDisplay()[1].setText("65535");
					Calc.getDisplay()[2].setText("177 513");
					Calc.getDisplay()[3].setText("1111 1111 1111 1111");
				}
			}
			else if (Calc.getModes()[2].getText().equalsIgnoreCase("BYTE") && !(Calc.getText().equals("")))
			{
				long y = Long.parseLong(Calc.getBaseText()[1].getText());
				if (y > 255)
				{
					Calc.getDisplayText().setText("1111 1111");
					Calc.getDisplay()[0].setText("FF");
					Calc.getDisplay()[1].setText("255");
					Calc.getDisplay()[2].setText("377");
					Calc.getDisplay()[3].setText("1111 1111");
				}
			}
		}

		
	}
	
	/* Used to count parenthesis (but can count other characters as well)
	 * @param count String to count
	 * @param c the character to look at
	 * @return character count in String
	 */
	private int pCounter(String count, char c)
	{
		int counter = 0;
		for (int k = 0; k < count.length(); k++)
		{
			if (count.charAt(k) == c)
			{
				counter++;
			}
		}
		return counter;
	}
}
