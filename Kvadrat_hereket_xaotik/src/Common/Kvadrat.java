package Common;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat{
	
	int en, uz, locX, locY, WhereGo;
	boolean GoEnable1, GoEnable2;
	public Kvadrat(int x, int y, int s, int h, int go, boolean enable)
	{
		en = s;
		uz = h;
		locX = x;
		locY = y;
		WhereGo = go;
		GoEnable1 = enable;
		GoEnable2 = !enable;
	}
	
	public void Paint(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect(locX, locY, uz, en);
	}
	
}
