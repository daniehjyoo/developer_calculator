import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// public class Calculator_ extends JFrame implements ActionListener, ComponentListener
public class Calculator extends JFrame implements ComponentListener, ActionListener
{	
	/**
	 * compiler asked to add this
	 */
	private static final long serialVersionUID = 1L;

	// Added
	Actions actionP = new Actions(this);
	
	// Stuff to be used
	private Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // Screen dimensions
	private double width = size.getWidth();
	private double height = size.getHeight();
		
	private GridLayout grid = new GridLayout(5, 6, 5, 5); // Button grid
		
	private JPanel bottom; // bottom component
	private JPanel buttons; 
	private JPanel binOps; 
	
	private JPanel top; // top component
	private JPanel bases;

	private JPanel word;
	private JPanel high;
	
	private JTextField equation; // To display what has been input already
	
	// Essentially to track the same as above, but in various formatting
	private String hEquation = "";
	private String dEquation = "";
	private String oEquation = "";
	private String bEquation = "";

	// Text fields to hold user input
	private JTextField text;
	private JTextField displayText;
	private JTextField fullTop; // Giant PROGRAMMER text at the top of the screen
	
	// Various fonts used
	private  Font other = new Font("Segoe UI", Font.BOLD, 14);
	private  Font f = new Font("Segoe UI", Font.BOLD, 20);
	private  Font but = new Font("Arial", Font.BOLD, 20);
	private Font gray = new Font("Segoe UI", Font.PLAIN, 12);

	// Control the 4 inputs that can be used for bases
	private JTextField[] baseText = new JTextField[4];
	private JTextField[] display = new JTextField[4];
	
	private ButtonGroup holder; // holds the bases and ensures only one is selected
	
	// Arrays of buttons used (text)
	private String[] vals = {"", "Mod", "CE", "C", "", "", "A", "B",
			"7", "8", "9", "x", "C", "D", "4", "5", "6", "-",
			"E", "F", "1", "2", "3", "+", "(", ")", "",
			"0", ".", "="};
	private String[] binVals = {"Lsh", "Rsh", "Or", "Xor", "Not", "And"};
	
	private String[] changeVals = {"HEX", "DEC", "OCT", "BIN"};
		
	// Trigram text at the top left corner
	private JButton topLeft;
	
	// Arrays for the buttons themselves
	private JButton[] botP =  new JButton[30];
	private JButton[] topP = new JButton[6];
	private JButton[] modes = new JButton[5];
	
	// Counts the usage of the BYTE, DWORD, QWORD, and WORD
	private int counter = 0;
	
	// Actually changes the bases
	private JToggleButton[] change = new JToggleButton[4];
	
	// Used to run expression evaluations 
	private String eval = "  ";
	private String post = "";
	private String result;
	private Stack<String> operators = new Stack<String>();
	private Stack<Integer> operands = new Stack<Integer>();
	
	private boolean equalsLast = false; // Tracks if equals was the last pressed button
	
	// Constructor
	Calculator()
	{
		
	}
	
	public void setActions()
	{
		actionP = new Actions(this);	
	}
	
	public void ConstructCalc()
	{
		// constructor.constructCalc();
	
		
		// Builds the JFrame portion
				this.setTitle("Windows 10 Calculator Recreation");
				this.setLayout(new GridBagLayout());
				GridBagConstraints main = new GridBagConstraints();
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Make this false
				// this.setResizable(true);
				this.setResizable(false);
				this.addComponentListener(this);
				
				// Top half of the calculator (with 5 components that contain more components)
				top = new JPanel();
				top.setLayout(new GridBagLayout());
				
				// Creates the top portion of the calculator (the button and Programmer text)
				high = new JPanel(new GridBagLayout());
				high.setBackground(new Color(242, 242, 242));
				topLeft = new JButton(new ImageIcon("TopRightTrigram.png")); // Image used over text
				topLeft.setPreferredSize(new Dimension((int) (width / 40) + 10, (int) (width / 40 + 10)));
				topLeft.setBackground(new Color(242, 242, 242));
				topLeft.setBorder(BorderFactory.createEmptyBorder());
				fullTop = new JTextField("  PROGRAMMER");
				fullTop.setBackground(new Color(242, 242, 242));
				fullTop.setBorder(BorderFactory.createEmptyBorder());
				fullTop.setPreferredSize(new Dimension(200 , (int) (width / 40 + 10)));
				fullTop.setEditable(false);
				fullTop.setFont(new Font("Segoe UI", Font.BOLD, 23));
				GridBagConstraints highGbc = new GridBagConstraints();
				highGbc.gridx = 0;
				highGbc.gridy = 0;
				highGbc.weighty = 1.0;
				highGbc.weightx = .0;
				highGbc.anchor = GridBagConstraints.NORTHWEST;
				highGbc.fill = GridBagConstraints.NONE;
				high.add(topLeft, highGbc);
				highGbc.gridx = 1;
				highGbc.weightx = .02;
				high.add(fullTop, highGbc);
				
				// Creates a constraints to add the panel
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.weightx = 1.0;
				gbc.weighty = .2;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				gbc.fill = GridBagConstraints.BOTH;
				top.add(high, gbc);
				
				// Creates the actual display to work with
				word = new JPanel(new GridBagLayout());
				GridBagConstraints characters = new GridBagConstraints();
				text = new JTextField("0");
				// text.setBackground(new Color(242, 242, 242));
				displayText = new JTextField("0");
				displayText.setBackground(new Color(242, 242, 242));
				
				// Second part that keeps track of the expression
				equation = new JTextField();
				
				equation.setEditable(false);
				equation.setHorizontalAlignment(SwingConstants.RIGHT);
				equation.setBorder(BorderFactory.createEmptyBorder());
				equation.setBackground(new Color(242, 242, 242));
				equation.setFont(gray);
				characters.gridx = 0;
				characters.gridy = 0;
				characters.weightx = 1;
				characters.weighty = .2;
				characters.fill = GridBagConstraints.BOTH;
				word.add(equation, characters);
				
				/*text.setFont(f);
				text.setEditable(false);
				text.setHorizontalAlignment(SwingConstants.RIGHT);
				text.setBorder(BorderFactory.createEmptyBorder());
				characters.gridy = 1;
				characters.weighty = .8;*/ // No longer used as it is part of background operations now
				displayText.setFont(f);
				displayText.setEditable(false);
				displayText.setHorizontalAlignment(SwingConstants.RIGHT);
				displayText.setBorder(BorderFactory.createEmptyBorder());
				characters.gridy = 1;
				characters.weighty = .8;
				word.add(displayText, characters);
				
				// Adds it on to main panel
				gbc.gridx = 0;
				gbc.gridy = 1;
				gbc.weightx = 1.0;
				gbc.weighty = .9;
				gbc.anchor = GridBagConstraints.NORTHWEST;
				gbc.fill = GridBagConstraints.BOTH;
				top.add(word, gbc);
				
				// Holds the bases and the toggles
				bases = new JPanel(new GridBagLayout());
				GridBagConstraints edit = new GridBagConstraints();
				edit.gridx = 0;
				edit.gridy = 0;
				edit.weightx = .025;
				edit.weighty = .25;
				edit.insets = new Insets(0,0,0,0);
				edit.anchor = GridBagConstraints.WEST;
				holder = new ButtonGroup();
				
				UIManager.put("ToggleButton.select", new Color(242, 242, 242)); // changes the selection color of the toggle buttons
				
				// Adds all buttons w. attributes via a loop
				for (int k = 0; k < change.length; k++)
				{
					JToggleButton x = new JToggleButton(changeVals[k]);
					x.setBackground(new Color(230, 230, 230));
					x.setBorder(BorderFactory.createEmptyBorder());
					x.setMargin(new Insets(0, 0, 0, 0));
					x.setFont(new Font("Segoe UI", Font.BOLD, 15));
					holder.add(x);
					change[k] = x;
					if (k == 1)
					{
						x.setForeground(new Color(0, 128, 255));
						x.setSelected(true);
					}
					x.setBackground(new Color(242, 242, 242));
					x.addActionListener(this);
					bases.add(x, edit);
					edit.gridy = edit.gridy + 1;
				}
				
				edit.gridx = 1;
				edit.gridy = 0;
				edit.weightx = .975;
				edit.fill = GridBagConstraints.HORIZONTAL;
				
				// Adds a corresponding text field to the toggle buttons
				for (int k = 0; k < display.length; k++)
				{
					JTextField toAdd = new JTextField("0");
					toAdd.setBackground(new Color(242, 242, 242));
					toAdd.setEditable(false);
					toAdd.setBorder(BorderFactory.createEmptyBorder());
					toAdd.setFont(other);
					display[k] = toAdd;
					if (k == 1)
					{
						toAdd.setForeground(new Color(0, 128, 255));
					}
					bases.add(toAdd, edit);
					edit.gridy = edit.gridy + 1;
				}
				
				// Adds the textfields that are not formatted, but used for operational purposes
				for (int k = 0; k < baseText.length; k++)
				{
					JTextField toAdd = new JTextField("0");
					toAdd.setEditable(false);
					baseText[k] = toAdd;
				}
				 
				// Add to main
				gbc.insets = new Insets(0, 15, 0, 5);
				gbc.gridy = 2;
				gbc.weighty = .3;
				bases.setBackground(new Color(242, 242, 242));
				top.add(bases, gbc);
				
				// Adds the row of buttons at the top that use images, such as the binary toggle
				gbc.fill = GridBagConstraints.BOTH;
				bottom = new JPanel(new GridBagLayout());
				GridBagConstraints stuff = new GridBagConstraints();
				stuff.gridx = 0;
				stuff.gridy = 0;
				stuff.weightx = 0;
				stuff.weighty = .1;
				stuff.insets = new Insets(5, 3, 0, 0);
				// Assigns properties to the buttons, such as text and images
				for (int k = 0; k < modes.length; k++)
				{
					JButton x;
					if (k == 0)
					{
						ImageIcon cMode = new ImageIcon("CalcMode.png");
						x = new JButton(cMode);
					}
					else if (k == 1)
					{
						ImageIcon bMode = new ImageIcon("BinaryMode.png");
						x = new JButton(bMode);
					}
					else if (k == 2)
					{
						stuff.weightx = 0;
						x = new JButton("QWORD");
						modes[2] = x;
						x.addActionListener(this);
						x.setFont(new Font("Segoe UI", Font.BOLD, 15));
						x.setForeground(new Color(0, 128, 255));
					}
					else if (k == 3)
					{
						stuff.weightx = 0;
						x = new JButton("MS");
					}
					else
					{
						ImageIcon Ms = new ImageIcon("Ms.png");
						x = new JButton(Ms);
					}
					x.setBackground(new Color(242, 242, 242));
					x.setPreferredSize(new Dimension(60, 30));
					x.setMaximumSize(new Dimension(60, 60));
					x.setMinimumSize(new Dimension(60, 30));
					if (k == 2)
					{
						stuff.weightx = .1;
						x.setPreferredSize(new Dimension(100, 30));
						x.setMaximumSize(new Dimension(100, 60));
						x.setMinimumSize(new Dimension(100, 30));
					}
					x.setBorder(BorderFactory.createEmptyBorder());
					bottom.add(x, stuff);
					if (k == 0)
					{
						stuff.gridy = 1;
						stuff.fill = GridBagConstraints.HORIZONTAL;
						stuff.insets = new Insets(0, 5, 0, 0);
						stuff.weighty = .000001;
						JPanel blue = new JPanel();
						blue.setPreferredSize(new Dimension(60, 2));
						blue.setMaximumSize(new Dimension(60, 2));
						blue.setMinimumSize(new Dimension(60, 2));
						blue.setBackground(new Color(16, 125, 213));
						bottom.add(blue, stuff);
						stuff.gridy = 0; 
						stuff.weighty = .1;
					}
					stuff.gridx++;
					stuff.weightx = 0;
				}
						
				// Adds on the first set of buttons
				gbc.gridy = 3;
				gbc.weighty = .1;
				gbc.insets =  new Insets(0, 0, 0, 0);
				bottom.setMaximumSize(new Dimension(bottom.getWidth(), 35));
				bottom.setBackground(new Color(242, 242, 242));
				bottom.setBorder(BorderFactory.createLineBorder(new Color(228, 228, 228)));
				top.add(bottom, gbc);
				
				// Adds on binary operators (and, or, xor, etc.)
				binOps = new JPanel(new GridLayout(1, 6, 5, 10));
				binOps.setBackground(new Color(242, 242, 242));
				for (int k = 0; k < binVals.length; k++)
				{
					JButton x = new JButton(binVals[k]);
					x.setFont(f);
					x.setBackground(new Color(242, 242, 242));
					x.setBorder(BorderFactory.createEmptyBorder());
					binOps.add(x);
					topP[k] = x;
				}
				
				// Adds binary operators on
				gbc.insets = new Insets(0, 0, 0, 0);
				binOps.setBorder(BorderFactory.createLineBorder(new Color(228, 228, 228)));
				gbc.gridy = 4;
				gbc.weighty = .7;
				top.add(binOps, gbc);
				
				// Adds 1st main panel onto the frame
				main.gridx = 0;
				main.gridy = 0;
				main.fill = GridBagConstraints.BOTH;
				main.weightx = 1;
				main.weighty = .32;
				
				this.add(top, main);
				
				//Buttons on bottom half of calculator
				
				buttons = new JPanel(grid);
				buttons.setBackground(new Color(230, 230, 230));
				for (int k = 0; k < botP.length; k++)
				{
					JButton x;
					if (k == 4)
					{
						ImageIcon del = new ImageIcon("Delete.png");
						x = new JButton(del);
					}
					else if (k == 5)
					{
						ImageIcon div = new ImageIcon("Divide.png");
						x = new JButton(div);
					}
					else if (k == 26)
					{
						ImageIcon pm = new ImageIcon("PlusMinus.png");
						x = new JButton(pm);
					}
					else if (k == 0)
					{
						ImageIcon arrow = new ImageIcon("UpArrow.png");
						x = new JButton(arrow);
					}
					else
					{
						x = new JButton(vals[k]);
					}
					x.setFont(but);
					x.addActionListener(this);
					if (k == 6 || k == 7 || k == 12 || k == 13 || k == 18 || k == 19 || k == 28)
					{
						x.setEnabled(false);
					}
					if (k > 5 && k < 11 || k > 11 && k < 17 || k > 17 && k < 23
							|| k == 27)
					{
						x.setBackground(new Color(250, 250, 250));// 12 - 16, 18 - 22, 24 - 28, 33 
					}
					else
					{
						x.setBackground(new Color(240, 240, 240));
					}
					x.setBackground(new Color(230, 230, 230));
					x.setBorder(BorderFactory.createEmptyBorder());
					botP[k] = x;
					buttons.add(x);
				}
						
				
				buttons.setVisible(true);
				
				// Final addition of buttons
				main.gridy = 1;
				main.weighty = .2;
				main.insets = new Insets(0, 5, 0, 5);
				this.add(buttons, main);
				this.setMinimumSize(new Dimension((int) (width * .2175), (int) (height * .5875)));
				this.setSize((int) (width * .2175), (int) height * 2 / 3);
				
				this.setVisible(true);
			
	}
	
	@Override
	/* Performs actions based on events received
	 *  @param e the event received by the ActionListener
	 */
	public void actionPerformed(ActionEvent e) 
	{
		actionP.actionPerformed(e);
	}
	
	// Not Needed
	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	// Not Needed
	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/* Resizes the font if over a certain size (75 %)
	 * @param arg0 the shifting frame 
	 */
	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource().equals(this))
		{
			if (this.getHeight() > height * .75)
			{
				displayText.setFont(new Font("Segoe UI", Font.BOLD, 35));
			}
			else
			{
				displayText.setFont(f);
			}
		}
	}
	
	// Not Needed
	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}
/*
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
*/
	public GridLayout getGrid() {
		return grid;
	}

	public void setGrid(GridLayout grid) {
		this.grid = grid;
	}

	public JPanel getBottom() {
		return bottom;
	}

	public void setBottom(JPanel bottom) {
		this.bottom = bottom;
	}

	public JPanel getButtons() {
		return buttons;
	}

	public void setButtons(JPanel buttons) {
		this.buttons = buttons;
	}

	public JPanel getBinOps() {
		return binOps;
	}

	public void setBinOps(JPanel binOps) {
		this.binOps = binOps;
	}

	public JPanel getTop() {
		return top;
	}

	public void setTop(JPanel top) {
		this.top = top;
	}

	public JPanel getBases() {
		return bases;
	}

	public void setBases(JPanel bases) {
		this.bases = bases;
	}

	public JPanel getWord() {
		return word;
	}

	public void setWord(JPanel word) {
		this.word = word;
	}

	public JPanel getHigh() {
		return high;
	}

	public void setHigh(JPanel high) {
		this.high = high;
	}

	public JTextField getEquation() {
		return equation;
	}

	public void setEquation(JTextField equation) {
		this.equation = equation;
	}

	public String gethEquation() {
		return hEquation;
	}

	public void sethEquation(String hEquation) {
		this.hEquation = hEquation;
	}

	public String getdEquation() {
		return dEquation;
	}

	public void setdEquation(String dEquation) {
		this.dEquation = dEquation;
	}

	public String getoEquation() {
		return oEquation;
	}

	public void setoEquation(String oEquation) {
		this.oEquation = oEquation;
	}

	public String getbEquation() {
		return bEquation;
	}

	public void setbEquation(String bEquation) {
		this.bEquation = bEquation;
	}

	public JTextField getText() {
		return text;
	}

	public void setText(JTextField text) {
		this.text = text;
	}

	public JTextField getDisplayText() {
		return displayText;
	}

	public void setDisplayText(JTextField displayText) {
		this.displayText = displayText;
	}

	public JTextField getFullTop() {
		return fullTop;
	}

	public void setFullTop(JTextField fullTop) {
		this.fullTop = fullTop;
	}

	public Font getOther() {
		return other;
	}

	public void setOther(Font other) {
		this.other = other;
	}

	public Font getF() {
		return f;
	}

	public void setF(Font f) {
		this.f = f;
	}

	public Font getBut() {
		return but;
	}

	public void setBut(Font but) {
		this.but = but;
	}

	public Font getGray() {
		return gray;
	}

	public void setGray(Font gray) {
		this.gray = gray;
	}

	public JTextField[] getBaseText() {
		return baseText;
	}

	public void setBaseText(JTextField[] baseText) {
		this.baseText = baseText;
	}

	public JTextField[] getDisplay() {
		return display;
	}

	public void setDisplay(JTextField[] display) {
		this.display = display;
	}

	public ButtonGroup getHolder() {
		return holder;
	}

	public void setHolder(ButtonGroup holder) {
		this.holder = holder;
	}

	public String[] getVals() {
		return vals;
	}

	public void setVals(String[] vals) {
		this.vals = vals;
	}

	public String[] getBinVals() {
		return binVals;
	}

	public void setBinVals(String[] binVals) {
		this.binVals = binVals;
	}

	public String[] getChangeVals() {
		return changeVals;
	}

	public void setChangeVals(String[] changeVals) {
		this.changeVals = changeVals;
	}

	public JButton getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(JButton topLeft) {
		this.topLeft = topLeft;
	}

	public JButton[] getBotP() {
		return botP;
	}

	public void setBotP(JButton[] botP) {
		this.botP = botP;
	}

	public JButton[] getTopP() {
		return topP;
	}

	public void setTopP(JButton[] topP) {
		this.topP = topP;
	}

	public JButton[] getModes() {
		return modes;
	}

	public void setModes(JButton[] modes) {
		this.modes = modes;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public JToggleButton[] getChange() {
		return change;
	}

	public void setChange(JToggleButton[] change) {
		this.change = change;
	}

	public String getEval() {
		return eval;
	}

	public void setEval(String eval) {
		this.eval = eval;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Stack<String> getOperators() {
		return operators;
	}

	public void setOperators(Stack<String> operators) {
		this.operators = operators;
	}

	public Stack<Integer> getOperands() {
		return operands;
	}

	public void setOperands(Stack<Integer> operands) {
		this.operands = operands;
	}

	public boolean isEqualsLast() {
		return equalsLast;
	}

	public void setEqualsLast(boolean equalsLast) {
		this.equalsLast = equalsLast;
	}
	
}