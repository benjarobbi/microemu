/**
 *  MicroEmulator
 *  Copyright (C) 2008 Bartek Teodorczyk <barteo@barteo.net>
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
 *
 *  @version $Id$
 */

package org.microemu.device.j2se.ui;

import javax.microedition.lcdui.TextBox;

import org.microemu.device.impl.ui.DisplayableImplUI;
import org.microemu.device.ui.TextBoxUI;

public class J2SETextBoxUI extends DisplayableImplUI implements TextBoxUI {

	private String text;

	public J2SETextBoxUI(TextBox textBox) {
	}

	public int getCaretPosition() {
		// TODO not yet used
		return -1;
	}

	public String getString() {
		// TODO not yet used
		return text;
	}

	public void setString(String text) {
		// TODO not yet used
		this.text = text;
	}

}