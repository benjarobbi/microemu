/*
 *  MicroEmulator
 *  Copyright (C) 2002 Bartek Teodorczyk <barteo@it.pl>
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

package com.barteo.emulator.device.applet;

import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;


public class PositionedImage 
{
  private Image image;
  private Rectangle rectangle;
  
  
  public PositionedImage(Image img, Rectangle arectangle) 
  {
    image = img;
    rectangle = arectangle;
  }
  
  
  public Image getImage()
  {
    return image;
  }
  
  
  public Rectangle getRectangle()
  {
    return rectangle;
  }
  
}
