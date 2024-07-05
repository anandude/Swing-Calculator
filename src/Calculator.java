import java.awt.font.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener{
	
	JFrame Frame;
	JLabel Label;
	
	JButton sevenButton,eightButton,nineButton,fourButton,fiveButton,sixButton,oneButton,twoButton,threeButton,dotButton,zeroButton,equalButton,divButton,mulButton,minusButton,plusButton,clearButton;
	
	String currentOperator;
	double firstOperand;
	boolean isOperatorClicked= false;
	Calculator(){
		Frame=new JFrame();
		Frame.setTitle("Calculator");
		Frame.setLayout(null);
		Frame.setSize(600,700);
		Frame.setLocation(200, 200);
		Frame.setVisible(true);
		Frame.setBackground(Color.gray);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font buttonFont = new Font("Arial", Font.BOLD, 30);
		
		Label=new JLabel("0");
		Label.setBounds(50, 50, 500, 40);
		Label.setBackground(Color.white);
		Label.setOpaque(true);
		Label.setForeground(Color.black);
		Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Label.setFont(buttonFont);
		Frame.add(Label);
		
		sevenButton =new JButton("7");
		sevenButton.setBounds(110, 130, 80, 80);
		sevenButton.addActionListener(this);
		sevenButton.setFont(buttonFont);
		Frame.add(sevenButton);
		
		eightButton =new JButton("8");
		eightButton.setBounds(210, 130, 80, 80);
		eightButton.addActionListener(this);
		eightButton.setFont(buttonFont);
		Frame.add(eightButton);
		
		nineButton =new JButton("9");
		nineButton.setBounds(310, 130, 80, 80);
		nineButton.addActionListener(this);
		nineButton.setFont(buttonFont);
		Frame.add(nineButton);
		
		fourButton =new JButton("4");
		fourButton.setBounds(110, 230, 80, 80);
		fourButton.addActionListener(this);
		fourButton.setFont(buttonFont);
		Frame.add(fourButton);
		
		fiveButton =new JButton("5");
		fiveButton.setBounds(210, 230, 80, 80);
		fiveButton.addActionListener(this);
		fiveButton.setFont(buttonFont);
		Frame.add(fiveButton);
		
		sixButton =new JButton("6");
		sixButton.setBounds(310, 230, 80, 80);
		sixButton.addActionListener(this);
		sixButton.setFont(buttonFont);
		Frame.add(sixButton);
		
		oneButton =new JButton("1");
		oneButton.setBounds(110, 330, 80, 80);
		oneButton.addActionListener(this);
		oneButton.setFont(buttonFont);
		Frame.add(oneButton);
		
		twoButton =new JButton("2");
		twoButton.setBounds(210, 330, 80, 80);
		twoButton.addActionListener(this);
		twoButton.setFont(buttonFont);
		Frame.add(twoButton);
		
		threeButton =new JButton("3");
		threeButton.setBounds(310, 330, 80, 80);
		threeButton.addActionListener(this);
		threeButton.setFont(buttonFont);
		Frame.add(threeButton);
		
		dotButton =new JButton(".");
		dotButton.setBounds(110, 430, 80, 80);
		dotButton.addActionListener(this);
		Frame.add(dotButton);
		
		zeroButton =new JButton("0");
		zeroButton.setBounds(210, 430, 80, 80);
		zeroButton.addActionListener(this);
		zeroButton.setFont(buttonFont);
		Frame.add(zeroButton);
		
		equalButton =new JButton("=");
		equalButton.setBounds(310, 430, 80, 80);
		equalButton.setBackground(Color.decode("#FF6347"));
		equalButton.setForeground(Color.white);
		equalButton.addActionListener(this);
		Frame.add(equalButton);
		
		divButton =new JButton("/");
		divButton.setBounds(410, 130, 80, 80);
		divButton.setBackground(Color.decode("#00cc99"));
		divButton.addActionListener(this);
		Frame.add(divButton);
		
		mulButton =new JButton("X");
		mulButton.setBounds(410, 230, 80, 80);
		mulButton.setBackground(Color.decode("#00cc99"));
		mulButton.addActionListener(this);
		Frame.add(mulButton);
		
		minusButton =new JButton("-");
		minusButton.setBounds(410, 330, 80, 80);
		minusButton.setBackground(Color.decode("#00cc99"));
		minusButton.addActionListener(this);
		Frame.add(minusButton);
		
		plusButton =new JButton("+");
		plusButton.setBounds(410, 430, 80, 80);
		plusButton.setBackground(Color.decode("#00cc99"));
		plusButton.addActionListener(this);
		Frame.add(plusButton);
		
		clearButton =new JButton("Clear");
		clearButton.setBounds(210, 530, 180, 80);
		clearButton.setBackground(Color.decode("#1168a4"));
		clearButton.setForeground(Color.white);
		clearButton.addActionListener(this);
		Frame.add(clearButton);
		
	}
	
	public static void main(String[] args) {
		new Calculator();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String action =e.getActionCommand();
		
		if(action.charAt(0) >='0' && action.charAt(0) <= '9' || action.equals(".")) {
			
			if(isOperatorClicked) {
				Label.setText(action);
				isOperatorClicked=false;
			}else {
				Label.setText(Label.getText().equals("0")?action:Label.getText()+action);
			}
			
		}else if(action.equals("Clear")){
			Label.setText("0");
			firstOperand=0;
			currentOperator="";	
			
		}else if(action.equals("=")) {
			double secondOperand = Double.parseDouble(Label.getText());
			double result=0;
			
			switch(currentOperator) {
			case "+":
				result=firstOperand+secondOperand;
				break;
			case "-":
				result=firstOperand-secondOperand;
				break;
			case "X":
				result=firstOperand*secondOperand;
				break;
			case "/":
				result=firstOperand/secondOperand;
				break;				
			}
			
		Label.setText(String.valueOf(result));
		currentOperator="";
		
		}else {
			firstOperand=Double.parseDouble(Label.getText());
			currentOperator=action;
			isOperatorClicked=true;
		}
		
		
		
	}

}
