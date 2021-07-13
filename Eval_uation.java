import java.util.Scanner;

public class Eval_uation {
	
	Calculator Calc;
	
	Eval_uation()
	{
		
	}
	Eval_uation(Calculator c)
	{
		Calc = c;
	}
	
	/* Evaluates an expression via Shunting Yard and Reverse Polish Algorithms
	 * @param input the expression received
	 * @return the result of the expression
	 */
	public String evaluate(String input)
	{
		// No undefined allowed
		if (input.contains("/ 0") || input.contains("Mod 0"))
		{
			return "Undefined";
		}
		Scanner scan = new Scanner(input); // Scans the tokens
		// Pushes tokens to appropriate Stack
		while (scan.hasNext())
		{
			String token = scan.next();
			if (!(operatorCheck(token)))
			{
				if (token.equals("("))
				{
					Calc.getOperators().push(token);
				}
				else if (token.equals(")"))
				{
					if (operatorCheck(Calc.getOperators().peek()))
					{
						//Calc.getPost() += Calc.getOperators().pop() + " ";
						Calc.setPost(Calc.getPost() + Calc.getOperators().pop() + " ");
					}
					else
					{
						Calc.getOperators().pop();
					}
				}
				else
				{
					Calc.setPost(Calc.getPost() + token + " ");
				}
			}
			else
			{
				boolean again = true;
				while (again)
				{
					if (Calc.getOperators().isEmpty())
					{
						Calc.getOperators().push(token);
						again = false;
					}
					else if (Calc.getOperators().equals("("))
					{
						Calc.getOperators().push(token);
						again = false;
					}
					else if (precedence(token) > precedence(Calc.getOperators().peek()))
					{
						Calc.getOperators().push(token);
						again = false;
					}
					else
					{
						String pop = Calc.getOperators().pop();
						Calc.setPost(Calc.getPost() + pop + " ");
					}
				}
			}
		}
		// Pops and empties the operator Stack and builds a String with it
		while (!(Calc.getOperators().isEmpty()))
		{
			if (operatorCheck(Calc.getOperators().peek()))
			{
				Calc.setPost(Calc.getPost() + Calc.getOperators().pop() + " ");
			}
			else
			{
				Calc.getOperators().pop();
			}
		}
		
		Scanner look = new Scanner(Calc.getPost());
		
		for (int k = 0; k < Calc.getPost().length(); k++)
		{
			if (Calc.getPost().charAt(k) == '(')
			{
				int y = Calc.getPost().indexOf("(");
				Calc.setPost(Calc.getPost().substring(0, y) + Calc.getPost().substring(y + 1));
			}
		}
		
		look.close();
		scan.close();
		// Reverse Polish part
		Scanner scan2 = new Scanner(Calc.getPost());
		while (scan2.hasNext())
		{
			// Evaluate here
			String token = scan2.next();
			if (!(operatorCheck(token)))
			{
				Integer toAdd = Integer.parseInt(token);
				Calc.getOperands().push(toAdd);
			}
			else
			{
				int op1 = Calc.getOperands().pop().intValue();
				int op2 = Calc.getOperands().pop().intValue();
				Integer toAdd;
				// Various cases to consider
				switch (token)
				{
					case "+": 
						toAdd = op1 + op2;
						Calc.getOperands().push(toAdd);
						break;
					case "-":
						toAdd = op2 - op1;
						Calc.getOperands().push(toAdd);
						break;
					case "x":
						toAdd = op1 * op2;
						Calc.getOperands().push(toAdd);
						break;
					case "/":
						if (op1 == 0)
						{
							return "Infinity";
						}
						else
						{
							toAdd = op2 / op1;
							Calc.getOperands().push(toAdd);
							break;
						}
					case "Mod":
						if (op1 == 0)
						{
							return "Infinity";
						}
						else
						{
							toAdd = op2 % op1;
							Calc.getOperands().push(toAdd);
							break;
						}
					default:
						break;
				}
			}
		}
		scan2.close();
		Integer toSend = Calc.getOperands().pop();
		return Integer.toString(toSend);
	}
	
	/* Checks if some token is an operator
	 * @param token the token to check
	 * @return if it is an operator
	 */
	private boolean operatorCheck(String token)
	{
		if (token.equals("Mod") || token.equals("x") || token.equals("/") ||
				token.equals("+") || token.equals("-"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/* Checks precedence of operators
	 * @param token the token to check
	 * @return precedence level of operator
	 */
	private int precedence(String token)
	{
		if (token.equals("Mod") || token.equals("x") || token.equals("/"))
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
