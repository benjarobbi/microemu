/*
 *  MicroEmulator
 *  Copyright (C) 2001 Bartek Teodorczyk <barteo@it.pl>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
 
package javax.microedition.lcdui;


public class Graphics
{
	public static final int SOLID = 0;
	public static final int DOTTED = 1;

	public static final int LEFT = 4;
	public static final int RIGHT = 8;
	public static final int TOP = 16;
	public static final int BASELINE = 64;
	public static final int BOTTOM = 32;
  public static final int HCENTER = 1;
  public static final int VCENTER = 2;

	int translateX = 0;
	int translateY = 0;


	public void clipRect(int x, int y, int width, int height)
	{
	}


	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)
	{
	}


  public void drawChar(char character, int x, int y, int anchor)
  {
  }


  public void drawChars(char[] data, int offset, int length, int x, int y, int anchor)
  {
  }


	public void drawImage(Image img, int x, int y, int anchor)
	{
	}


	public void drawLine(int x1, int y1, int x2, int y2)
	{
	}


	public void drawRect(int x, int y, int width, int height)
	{
	}


	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
	{
	}


	public void drawString(String str, int x, int y, int anchor)
	{
	}


	public void drawSubstring(String str, int offset, int len, int x, int y, int anchor)
	{
    drawString(str.substring(offset, offset + len), x, y, anchor);
	}


	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
	{
	}


	public void fillRect(int x, int y, int width, int height)
	{
	}


	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
	{
	}


  public int getBlueComponent()
  {
    return (getColor() >> 16) & 255;
  }


  public int getClipHeight()
  {
    throw new IllegalStateException();
  }


  public int getClipWidth()
  {
    throw new IllegalStateException();
  }


  public int getClipX()
  {
    throw new IllegalStateException();
  }


  public int getClipY()
  {
    throw new IllegalStateException();
  }


  public int getColor()
  {
    throw new IllegalStateException();
  }


	public Font getFont()
	{
    throw new IllegalStateException();
	}


  public int getGrayScale()
  {
    throw new IllegalStateException();
  }


  public int getGreenComponent()
  {
    return (getColor() >> 8) & 255;
  }


  public int getRedComponent()
  {
    return getColor() & 255;
  }


  public int getStrokeStyle()
  {
//System.out.println("Graphics::getStrokeStyle() not implemented");
    return 0;
  }


	public int getTranslateX()
	{
		return translateX;
	}


	public int getTranslateY()
	{
		return translateY;
	}


	public void setClip(int x, int y, int width, int height)
	{
	}


	public void setColor(int RGB)
	{
	}


	public void setColor(int red, int green, int blue)
	{
    int rgb = red;
    rgb += green << 8;
    rgb += red << 16;
    setColor(rgb);
	}


	public void setFont(Font font)
	{
	}


	public void setGrayScale(int grey)
	{
	}


	public void setStrokeStyle(int style)
	{
//System.out.println("Graphics::setStrokeStyle(...) not implemented");
	}


  public void translate(int x, int y)
  {
		translateX += x;
		translateY += y;
  }

}