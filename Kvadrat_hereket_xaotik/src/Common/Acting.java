package Common;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Acting extends JPanel implements ActionListener, MouseListener{

	ArrayList<Kvadrat> kvlar = new ArrayList<Kvadrat>();
	int index = 0;
	boolean b;
	Timer t;
	Random rm;
	public Acting()
	{
		t = new Timer(10, this);
		t.start();
		this.addMouseListener(this);
		rm = new Random();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		for(int i = 0; i < kvlar.size(); i++)
			kvlar.get(i).Paint(g);
	}
		
	boolean goUpEnable(Kvadrat k)
	{
		b = true;
		if(k.locY <= 0) b = false;
		else
		for(int i = 0; i < kvlar.size(); i++)
		{
			if(((k.locX >= kvlar.get(i).locX && k.locX <= kvlar.get(i).locX+ kvlar.get(i).uz)
					||(k.locX + k.uz >= kvlar.get(i).locX && k.locX + k.uz <= kvlar.get(i).locX + kvlar.get(i).uz))
					&&( k.locY == kvlar.get(i).locY + kvlar.get(i).en))
			{
				b = false;
				break;
			}
		}
		return b;
	}
	
	boolean goDownEnable(Kvadrat k)
	{
		b = true;
		if(k.locY + k.en >= this.getHeight()) b = false;
		else
		for(int i = 0; i < kvlar.size(); i++)
		{
			if(((k.locX >= kvlar.get(i).locX && k.locX <= kvlar.get(i).locX+ kvlar.get(i).uz)
					||(k.locX + k.uz >= kvlar.get(i).locX && k.locX + k.uz <= kvlar.get(i).locX + kvlar.get(i).uz))
					&&( k.locY + k.en == kvlar.get(i).locY))
			{
				b = false;
				break;
			}
		}
		return b;
	}
	
	boolean goLeftEnable(Kvadrat k)
	{
		b = true;
		if(k.locX <= 0) b = false;
		else
		for(int i = 0; i < kvlar.size(); i++)
		{
			if(((k.locY >= kvlar.get(i).locY && k.locY <= kvlar.get(i).locY + kvlar.get(i).en)
					||(k.locY + k.en >= kvlar.get(i).locY && k.locY + k.en <= kvlar.get(i).locY + kvlar.get(i).en))
					&&( k.locX == kvlar.get(i).locX + kvlar.get(i).uz))
			{
				b = false;
				break;
			}
		}
		return b;
	}
	
	boolean goRightEnable(Kvadrat k)
	{
		b = true;
		if(k.locX + k.uz >= this.getWidth()) b = false;
		else
		for(int i = 0; i < kvlar.size(); i++)
		{
			if(((k.locY >= kvlar.get(i).locY && k.locY <= kvlar.get(i).locY + kvlar.get(i).en)
					||(k.locY + k.en >= kvlar.get(i).locY && k.locY + k.en <= kvlar.get(i).locY + kvlar.get(i).en))
					&&( k.locX + k.en == kvlar.get(i).locX))
			{
				b = false;
				break;
			}
		}
		return b;
	}
	
	boolean t1 = false, t2 = false;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		for(int i = 0; i < kvlar.size(); ++i)
		{
			
			if(kvlar.get(i).WhereGo == 1 && kvlar.get(i).GoEnable1)
			{
				if(!goUpEnable(kvlar.get(i))) {
					kvlar.get(i).GoEnable1 = false;
					kvlar.get(i).GoEnable2 = true;
				}
			}
			else if(kvlar.get(i).GoEnable2)
			{
				if(!goDownEnable(kvlar.get(i))) {
					kvlar.get(i).GoEnable2 = false;
					kvlar.get(i).GoEnable1 = true;
				}
			}
			
			if(kvlar.get(i).WhereGo == 2 && kvlar.get(i).GoEnable1)
			{
				if(!goRightEnable(kvlar.get(i))) {
					kvlar.get(i).GoEnable1 = false;
					kvlar.get(i).GoEnable2 = true;
				}
			}
			else if(kvlar.get(i).GoEnable2)
			{
				if(!goLeftEnable(kvlar.get(i))) {
					kvlar.get(i).GoEnable2 = false;
					kvlar.get(i).GoEnable1 = true;
				}
			}
			
			
		}
		
		for(int i = 0; i < kvlar.size(); ++i)
		{
			if(kvlar.get(i).WhereGo == 1)
			{
				if(kvlar.get(i).GoEnable1) kvlar.get(i).locY--;
				if(kvlar.get(i).GoEnable2) kvlar.get(i).locY++;
			}
			else{
				if(kvlar.get(i).GoEnable1) kvlar.get(i).locX++;
				if(kvlar.get(i).GoEnable2) kvlar.get(i).locX--;
			}
		}
		
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	int i;
	boolean bh;
	
	@Override
	public void mousePressed(MouseEvent e) {
		bh = rm.nextBoolean();
		i = rm.nextInt(2) + 1;
		Kvadrat newkv = new Kvadrat(e.getX(), e.getY(), 20, 20, i, bh);
		kvlar.add(newkv);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

