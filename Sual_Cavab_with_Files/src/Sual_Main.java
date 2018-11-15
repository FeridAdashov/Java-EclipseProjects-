/*
 * 1. C:\\Users\\FERID\\Desktop\\sual.txt FAYLININ DOGRULUGUNU YOXLAYIN
 * 2. FAYLIN YARADILMA QAYDASI:
 * 		1. UMUMI SUAL SAYININI YAZIN
 * 		2. ALT SETRDEN (BOS SETR BURAXMAQ OLMAZ) SUALI YAZIN
 * 		3. ALT ALTA CAVABLARI YAZIN(ILK ONCE DOGRU CAVABI YAZIN)
 * 		4. CAVABLARI NOMRELEYIN(ALT ALTA: MES:   4 
 * 												 1
 * 											     2
 * 												 3
 * 		5.DIGER SUALLARI EYNI QAYDADA EVVELKI SUALDAN SONRA BOS SETR BURAXMADAN ALTDAN DAVAM EDIN
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Sual_Main extends JFrame implements ActionListener{

	JPanel panel;
	JButton next, previous, A, B, C, D;
	Q[] questions; int index = 0, questionnom = -1;
	JLabel Basliq, Question, lA, lB, lC, lD, Seciminiz, Cavab;
	int SualSayi;
	FileReader fr;
	BufferedReader br;
	public Sual_Main()
	{
		super("QA_Project");		
		panel = new JPanel();
		this.add(panel);
		
		try {
			fr = new FileReader("C:\\Users\\Ferid\\Desktop\\sual.txt");
			br = new BufferedReader(fr);
			SualSayi = br.read() - '0';
		} catch (Exception e) {
			System.out.println("Error happened in opening the file -- C:\\Users\\Ferid\\Desktop\\sual.txt");
			try {
				fr.close();
				br.close();
			} catch (Exception e1) {
				this.setEnabled(false);
				this.setVisible(false);
				System.out.println("Error happened in the file");
			}
			
			e.printStackTrace();
		}
		
		questions = new Q[SualSayi];
		
		Basliq = new JLabel("QUESTIONS");
		Basliq.setSize(100, 10);
		Basliq.setLocation(250, 0);
		Basliq.setForeground(Color.white);
		
		Question = new JLabel("Sual");
		Question.setSize(600, 20);
		Question.setLocation(0, 15);
		Question.setForeground(Color.white);
		
		Seciminiz = new JLabel("");
		Seciminiz.setSize(100, 20);
		Seciminiz.setLocation(0, 210);
		Seciminiz.setForeground(Color.white);
		
		Cavab = new JLabel("");
		Cavab.setSize(600, 20);
		Cavab.setLocation(0, 240);
		Cavab.setForeground(Color.white);
		
		A = new JButton("A)");
		A.setSize(50, 30);
		A.setLocation(0, 50);
		A.setForeground(Color.RED);
		A.addActionListener(this);
		
		B = new JButton("B)");
		B.setSize(50, 30);
		B.setLocation(0, 90);
		B.setForeground(Color.RED);
		B.addActionListener(this);
		
		C = new JButton("C)");
		C.setSize(50, 30);
		C.setLocation(0, 130);
		C.setForeground(Color.RED);
		C.addActionListener(this);
		
		D = new JButton("D)");
		D.setSize(50, 30);
		D.setLocation(0, 170);
		D.setForeground(Color.RED);
		D.addActionListener(this);
		
		A.setEnabled(false);
		B.setEnabled(false);
		C.setEnabled(false);
		D.setEnabled(false);
		
		lA = new JLabel("");
		lA.setSize(600, 50);
		lA.setLocation(60, 40);
		lA.setForeground(Color.RED);
		
		lB = new JLabel("");
		lB.setSize(600, 50);
		lB.setLocation(60, 80);
		lB.setForeground(Color.RED);
		
		lC = new JLabel("");
		lC.setSize(600, 50);
		lC.setLocation(60, 120);
		lC.setForeground(Color.RED);
		
		lD = new JLabel("");
		lD.setSize(600, 50);
		lD.setLocation(60, 160);
		lD.setForeground(Color.RED);
		
		next = new JButton("NEXT");
		next.setSize(100, 50);
		next.setBackground(Color.CYAN);
		next.setLocation(493, 320);
		next.addActionListener(this);
		
		previous = new JButton("PREVIOUS");
		previous.setSize(100, 50);
		previous.setBackground(Color.CYAN);
		previous.setLocation(0, 320);
		previous.addActionListener(this);
		
		panel.add(Seciminiz);
		panel.add(Cavab);
		panel.add(lA);
		panel.add(lB);
		panel.add(lC);
		panel.add(lD);
		panel.add(A);
		panel.add(B);
		panel.add(C);
		panel.add(D);
		panel.add(next);
		panel.add(previous);
		panel.add(Basliq);
		panel.add(Question);
		panel.setBackground(Color.darkGray);
		panel.setLayout(null);
		
	}
	
	public static class Q{
		String QuestionString,
		TrueAnswer, 
		FalseAnswer1, 
		FalseAnswer2, 
		FalseAnswer3;
		
		int TButtonNom, FButtonNom1, FButtonNom2, FButtonNom3;

		public Q(String questionString, String trueAnswer, String falseAnswer1, String falseAnswer2,
				String falseAnswer3, int tButtonNom, int fButtonNom1, int fButtonNom2, int fButtonNom3) {
			super();
			QuestionString = questionString;
			TrueAnswer = trueAnswer;
			FalseAnswer1 = falseAnswer1;
			FalseAnswer2 = falseAnswer2;
			FalseAnswer3 = falseAnswer3;
			TButtonNom = tButtonNom;
			FButtonNom1 = fButtonNom1;
			FButtonNom2 = fButtonNom2;
			FButtonNom3 = fButtonNom3;
		}
		
		
	}
	
	public void addQuestion(int n)
	{
		Q newquestion;
		try {
			fr = new FileReader("C:\\Users\\Ferid\\Desktop\\sual.txt");
			br = new BufferedReader(fr);
			br.readLine();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		for(int i = 0; i < n; ++i)
		try{
			newquestion = new Q(
					br.readLine(),
					br.readLine(),
					br.readLine(), 
					br.readLine(), 
					br.readLine(),
					Integer.parseInt(br.readLine()), 
					Integer.parseInt(br.readLine()),  
					Integer.parseInt(br.readLine()), 
					Integer.parseInt(br.readLine()));
			questions[index] = newquestion;
			++index;
		}catch(Exception e)
		{
			System.out.println(e.toString());
			try {
				fr.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Sual_Main ob = new Sual_Main();
		ob.setSize(600, 400);
		ob.setLocation(100, 100);
		ob.setVisible(true);
		ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ob.setResizable(false);
		
		
		ob.addQuestion(ob.SualSayi);
		
	}

	public void showQuestion(int nom)
	{
		Question.setText(questions[nom].QuestionString);
		
		switch (questions[nom].TButtonNom) {
		case 1:
			lA.setText(questions[nom].TrueAnswer);
			break;
		case 2:
			lB.setText(questions[nom].TrueAnswer);
			break;
		case 3:
			lC.setText(questions[nom].TrueAnswer);
			break;
		case 4:
			lD.setText(questions[nom].TrueAnswer);
			break;
		}
		
		switch (questions[nom].FButtonNom1) {
		case 1:
			lA.setText(questions[nom].FalseAnswer1);
			break;
		case 2:
			lB.setText(questions[nom].FalseAnswer1);
			break;
		case 3:
			lC.setText(questions[nom].FalseAnswer1);
			break;
		case 4:
			lD.setText(questions[nom].FalseAnswer1);
			break;
		}
		
		switch (questions[nom].FButtonNom2) {
		case 1:
			lA.setText(questions[nom].FalseAnswer2);
			break;
		case 2:
			lB.setText(questions[nom].FalseAnswer2);
			break;
		case 3:
			lC.setText(questions[nom].FalseAnswer2);
			break;
		case 4:
			lD.setText(questions[nom].FalseAnswer2);
			break;
		}
		
		switch (questions[nom].FButtonNom3) {
		case 1:
			lA.setText(questions[nom].FalseAnswer3);
			break;
		case 2:
			lB.setText(questions[nom].FalseAnswer3);
			break;
		case 3:
			lC.setText(questions[nom].FalseAnswer3);
			break;
		case 4:
			lD.setText(questions[nom].FalseAnswer3);
			break;
		}
	}
	
	public String showTrueButton(int i)
	{
		if(i == 1)
			return "A)";
		else if(i == 2)
			return "B)";
		else if(i == 1)
			return "C)";
		else
			return "D)";
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals(next.getText()))
		{
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			
			lA.setText("");
			lB.setText("");
			lC.setText("");
			lD.setText("");
			Seciminiz.setText("");
			Cavab.setText("");
			if(questionnom == questions.length - 1 || questionnom == questions.length)
			{
				Question.setText("Sual Bitdi");
				questionnom = questions.length;
				A.setEnabled(false);
				B.setEnabled(false);
				C.setEnabled(false);
				D.setEnabled(false);
			}
			else{
				questionnom++;
				showQuestion(questionnom);
			}
		}
		
		if(e.getActionCommand().equals(previous.getText()))
		{
			A.setEnabled(true);
			B.setEnabled(true);
			C.setEnabled(true);
			D.setEnabled(true);
			
			lA.setText("");
			lB.setText("");
			lC.setText("");
			lD.setText("");
			Seciminiz.setText("");
			Cavab.setText("");
			if(questionnom == -1 || questionnom == 0)
			{
				Question.setText("Siyahi Basdadir!!! Next Duymesine Basin");
				questionnom = -1;
				A.setEnabled(false);
				B.setEnabled(false);
				C.setEnabled(false);
				D.setEnabled(false);
			}
			else{
				questionnom -= 1;
				showQuestion(questionnom);
			}
		}
		if(e.getActionCommand().equals(A.getText()))
		{
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			
			if(!Question.getText().equals("Sual Bitdi") && 
					!Question.getText().equals("Siyahi Basdadir!!! Next Duymesine Basin") &&
					!Question.getText().equals("Sual"))
			{
				Seciminiz.setText("Seciminiz: " + A.getText());
				if(questions[questionnom].TButtonNom == 1)
				Cavab.setText("Dogrudur");
				else Cavab.setText("Dogru Cavab: " + showTrueButton(questions[questionnom].TButtonNom));
			}
		}
		
		if(e.getActionCommand().equals(B.getText()))
		{
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			
			if(!Question.getText().equals("Sual Bitdi") && 
					!Question.getText().equals("Siyahi Basdadir!!! Next Duymesine Basin") &&
					!Question.getText().equals("Sual"))
			{
				Seciminiz.setText("Seciminiz: " + B.getText());
				if(questions[questionnom].TButtonNom == 2)
				Cavab.setText("Dogrudur");
				else Cavab.setText("Dogru Cavab: " + showTrueButton(questions[questionnom].TButtonNom));
			}
		}
		
		if(e.getActionCommand().equals(C.getText()))
		{
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			
			if(!Question.getText().equals("Sual Bitdi") && 
					!Question.getText().equals("Siyahi Basdadir!!! Next Duymesine Basin") &&
					!Question.getText().equals("Sual"))
			{
				Seciminiz.setText("Seciminiz: " + C.getText());
				if(questions[questionnom].TButtonNom == 3)
				Cavab.setText("Dogrudur");
				else Cavab.setText("Dogru Cavab: " + showTrueButton(questions[questionnom].TButtonNom));
			}
		}
		
		
		if(e.getActionCommand().equals(D.getText()))
		{
			A.setEnabled(false);
			B.setEnabled(false);
			C.setEnabled(false);
			D.setEnabled(false);
			
			if(!Question.getText().equals("Sual Bitdi") && 
					!Question.getText().equals("Siyahi Basdadir!!! Next Duymesine Basin") &&
					!Question.getText().equals("Sual"))
			{
				Seciminiz.setText("Seciminiz: " + D.getText());
				if(questions[questionnom].TButtonNom == 4)
				Cavab.setText("Dogrudur");
				else Cavab.setText("Dogru Cavab: " + showTrueButton(questions[questionnom].TButtonNom));
			}
		}
		
	}
}