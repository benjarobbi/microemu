package com.barteo.emulator.device;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.lcdui.Command;

import com.barteo.emulator.Button;
import com.barteo.emulator.SoftButton;
import nanoxml.XMLElement;


public class Device {

  static Device instance = new Device();

  Vector deviceButtons = new Vector();

  public static Color backgroundColor;
  public static Color foregroundColor;

  public static Rectangle screenRectangle;
  public static Rectangle screenPaintable;

  public static Rectangle keyboardRectangle;
    
  
  public static Device getInstance()
  {
    return instance;
  }


  public boolean init()
  {
    String xml = "";
    DataInputStream dis = new DataInputStream(
        instance.getClass().getResourceAsStream("/com/barteo/emulator/device/device.xml"));
    try {
      while (dis.available() > 0) {
        byte[] b = new byte[dis.available()];
        dis.read(b);
        xml += new String(b);
      }
    } catch (Exception ex) {
      System.out.println("Cannot find com.barteo.emulator.device.device.xml definition file");
      return false;
    }

    XMLElement doc = new XMLElement();
    doc.parseString(xml);

    for (Enumeration e = doc.enumerateChildren(); e.hasMoreElements(); ) {
      XMLElement tmp = (XMLElement) e.nextElement();
      if (tmp.getName().equals("screen")) {
        for (Enumeration e_screen = tmp.enumerateChildren(); e_screen.hasMoreElements(); ) {
          XMLElement tmp_screen = (XMLElement) e_screen.nextElement();
          if (tmp_screen.getName().equals("background")) {
            backgroundColor = new Color(Integer.parseInt(tmp_screen.getContent(), 16));
          }
          if (tmp_screen.getName().equals("foreground")) {
            foregroundColor = new Color(Integer.parseInt(tmp_screen.getContent(), 16));
          }
          if (tmp_screen.getName().equals("rectangle")) {
            screenRectangle = getRectangle(tmp_screen);
          }
          if (tmp_screen.getName().equals("paintable")) {
            screenPaintable = getRectangle(tmp_screen);
          }
        }
      }
      if (tmp.getName().equals("keyboard")) {
        for (Enumeration e_keyboard = tmp.enumerateChildren(); e_keyboard.hasMoreElements(); ) {
          XMLElement tmp_keyboard = (XMLElement) e_keyboard.nextElement();
          if (tmp_keyboard.getName().equals("rectangle")) {
            keyboardRectangle = getRectangle(tmp_keyboard);
          }
          if (tmp_keyboard.getName().equals("button")) {
            for (Enumeration e_button = tmp_keyboard.enumerateChildren(); e_button.hasMoreElements(); ) {
              XMLElement tmp_button = (XMLElement) e_button.nextElement();
              if (tmp_button.getName().equals("rectangle")) {
                deviceButtons.addElement(new Button(tmp_keyboard.getProperty("name"), 
                    getRectangle(tmp_button), tmp_keyboard.getProperty("key")));
              }
            }
          }
          if (tmp_keyboard.getName().equals("softbutton")) {
            Vector commands = new Vector();
            Rectangle rectangle = null, paintable = null;
            for (Enumeration e_button = tmp_keyboard.enumerateChildren(); e_button.hasMoreElements(); ) {
              XMLElement tmp_button = (XMLElement) e_button.nextElement();
              if (tmp_button.getName().equals("rectangle")) {
                rectangle = getRectangle(tmp_button);
              }
              if (tmp_button.getName().equals("paintable")) {
                paintable = getRectangle(tmp_button);
              }
              if (tmp_button.getName().equals("command")) {
                commands.addElement(tmp_button.getContent());
              }
            }
            deviceButtons.addElement(new SoftButton(tmp_keyboard.getProperty("name"),
                rectangle, tmp_keyboard.getProperty("key"), paintable, 
                tmp_keyboard.getProperty("alignment"), commands));
          }
        }
      }
    }
    
    return true;
  }


  public static Vector getDeviceButtons() 
  {
    return instance.deviceButtons;
  }
  
  
  Rectangle getRectangle(XMLElement source)
  {
    Rectangle rect = new Rectangle();
    
    for (Enumeration e_rectangle = source.enumerateChildren(); e_rectangle.hasMoreElements(); ) {
      XMLElement tmp_rectangle = (XMLElement) e_rectangle.nextElement();
      if (tmp_rectangle.getName().equals("x")) {
        rect.x = Integer.parseInt(tmp_rectangle.getContent());
      }
      if (tmp_rectangle.getName().equals("y")) {
        rect.y = Integer.parseInt(tmp_rectangle.getContent());
      }
      if (tmp_rectangle.getName().equals("width")) {
        rect.width = Integer.parseInt(tmp_rectangle.getContent());
      }
      if (tmp_rectangle.getName().equals("height")) {
        rect.height = Integer.parseInt(tmp_rectangle.getContent());
      }
    }
    
    return rect;
  }

}
