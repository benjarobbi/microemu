/**
 *  MicroEmulator
 *  Copyright (C) 2006-2007 Bartek Teodorczyk <barteo@barteo.net>
 *  Copyright (C) 2006-2007 Vlad Skarzhevskyy
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
package org.microemu.cldc.file;

import java.util.Map;

import org.microemu.app.util.MIDletSystemProperties;
import org.microemu.microedition.ImplFactory;
import org.microemu.microedition.ImplementationInitialization;

/**
 * @author vlads
 * 
 * config2.xml example
 * 
 * <pre>
 *  &lt;extensions&gt;
 *  &lt;extension&gt;
 *  &lt;className&gt;org.microemu.cldc.file.FileSystem&lt;/className&gt;
 *  &lt;properties&gt;
 *  &lt;property NAME=&quot;fsRoot&quot; VALUE=&quot;C:&quot;/&gt;
 *  &lt;/properties&gt;
 *  &lt;/extension&gt;
 *  &lt;/extensions&gt;
 * </pre>
 * 
 */

public class FileSystem implements ImplementationInitialization {

	public static final String detectionProperty = "microedition.io.file.FileConnection.version";

	public static final String fsRootConfigProperty = "fsRoot";

	private FileSystemConnectorImpl impl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.microemu.microedition.ImplementationInitialization#registerImplementation()
	 */
	public void registerImplementation(Map parameters) {
		String fsRoot = (String) parameters.get(fsRootConfigProperty);
		this.impl = new FileSystemConnectorImpl(fsRoot);
		ImplFactory.registerGCF("file", this.impl);
		ImplFactory.register(FileSystemRegistryDelegate.class, new FileSystemRegistryImpl(fsRoot));
		MIDletSystemProperties.setProperty(detectionProperty, "1.0");
	}

	protected static void unregisterImplementation(FileSystemConnectorImpl impl) {
		MIDletSystemProperties.clearProperty(detectionProperty);
		ImplFactory.unregistedGCF("file", impl);
		ImplFactory.unregister(FileSystemRegistryDelegate.class, FileSystemRegistryImpl.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.microemu.microedition.ImplementationInitialization#notifyMIDletStart()
	 */
	public void notifyMIDletStart() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.microemu.microedition.ImplementationInitialization#notifyMIDletDestroyed()
	 */
	public void notifyMIDletDestroyed() {
		this.impl.notifyMIDletDestroyed();
	}

}
