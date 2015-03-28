/*Copyright (c) 2004,University of Illinois at Urbana-Champaign.  All rights reserved.
 * 
 * Created on Jun 14, 2006
 * 
 * Developed by: CCT, Center for Computation and Technology, 
 * 				NCSA, University of Illinois at Urbana-Champaign
 * 				OSC, Ohio Supercomputing Center
 * 				TACC, Texas Advanced Computing Center
 * 				UKy, University of Kentucky
 * 
 * https://www.gridchem.org/
 * 
 * Permission is hereby granted, free of charge, to any person 
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal with the Software without 
 * restriction, including without limitation the rights to use, 
 * copy, modify, merge, publish, distribute, sublicense, and/or 
 * sell copies of the Software, and to permit persons to whom 
 * the Software is furnished to do so, subject to the following conditions:
 * 1. Redistributions of source code must retain the above copyright notice, 
 *    this list of conditions and the following disclaimers.
 * 2. Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimers in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the names of Chemistry and Computational Biology Group , NCSA, 
 *    University of Illinois at Urbana-Champaign, nor the names of its contributors 
 *    may be used to endorse or promote products derived from this Software without 
 *    specific prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  
 * IN NO EVENT SHALL THE CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS WITH THE SOFTWARE.
*/

package org.gridchem.client.common;

import java.awt.Window;
import java.lang.reflect.Constructor;
import java.net.URI;
import java.util.Hashtable;

import javax.imageio.ImageIO;

//import org.globus.cog.gridface.interfaces.GridCommandManager;

/**
 * Mapping class for determining what applications should be used to open
 * files of different types.  The types are currently hard coded, but 
 * extensions are pretty easy.
 * 
// ----------------------------------------------------------------------
// This code is developed as part of the Java CoG Kit project
// The terms of the license can be found at http://www.cogkit.org/license
// This message may not be removed or altered.
// ----------------------------------------------------------------------
 * 
 * @author Rion Dooley < dooley [at] tacc [dot] utexas [dot] edu >
 *
 */
public class MimeHandler {
    private Hashtable mimeTable;
    private URI lookupURI;
    private Window parentWindow;
    //private GridCommandManager gcm;

 // gvl: I should have the ability to also define the mime handlers
 // as part of the desktop configuration file in XML
    
    /**
     * Create the MimeHandler.  At some point we'd probably be
     * loading up the keys from a file that the user saved
     * somewhere.
     */
    public MimeHandler(/*GridCommandManager gcm*/) {
        //this.gcm = gcm;
        mimeTable = new Hashtable(10);
        
        this.addType("fchk", "org.gridchem.client.plugins.TextEditor");
        this.addType("hist", "org.gridchem.client.plugins.TextEditor");
        this.addType("txt", "org.gridchem.client.plugins.TextEditor");
        this.addType("default", "org.gridchem.client.plugins.TextEditor");
        
        //Add types for all images the JVM is capable of reading
//        String[] array = ImageIO.getReaderFormatNames();
//        for(int i =0; i<array.length;i++){
//            if (!mimeTable.containsKey(array[i].toLowerCase())) {
//                this.addType(array[i], "org.globus.cog.gridface.impl.imageviewer.ImageViewerImplToolBar");
//            }
//        }
//        
        
    }
    
    /**
     * Given a URI, get the type and instantiate the appropriate object, passing the provided URI to the constructor.
     * @param lookupURI The URI passed to the constructor of the object that will be instantiated.
     * @return The instantiated object.
     */
    public Object lookup(URI lookupURI) {
        this.lookupURI = lookupURI;
        String uriType = getType(lookupURI);
        
        System.out.println("File Type is: " + uriType);
        
        Class handlingClass = this.getHandlingClass(uriType);
        return this.createObject(handlingClass);
    }
    
    
    /**
     * Add a type and a handling class to the hashtable.
     * @param type
     * @param handlingClassName
     */
    public void addType(String type, String handlingClassName) {
        mimeTable.put(type.toLowerCase(), handlingClassName);       
    }
    
    public Hashtable getHash() {
        return mimeTable;
    }
    

    /**
     * Get they type of a file, probably by looking at the extension, and return the type
     * as a String.
     * @param uriToGetTypeOf The URI to get the type of.
     * @return The type of a file.
     */
    private String getType(URI uriToGetTypeOf){
        String uriPath = uriToGetTypeOf.getPath();
        String returnExtension = uriPath.substring(uriPath.lastIndexOf(".")+1);
        String returnExtensionFixed = returnExtension.replaceAll("/", "");
        return returnExtensionFixed;
    }   

    
    /**
     * Get the class that handles the provided type.
     * @param type They type (given by <code>getType</code> that determines what class we get.
     * @return The class that handles the given type.
     */
    private Class getHandlingClass(String type) {
        String handlingClassName = (String) mimeTable.get(type.toLowerCase());
        if(handlingClassName == null) {
            handlingClassName = (String) mimeTable.get("default");
        }
        Class handlingClass = null;
        try {           
            handlingClass = Class.forName(handlingClassName);
        } catch (Exception e) {
        }
        return handlingClass;
    }
    
    
    /**
     * Given a class, return the appropriate object, passing <code>lookupURI</code> into the constructor.
     * @param handlingClass The class that we're instantiating with <code>lookupURI</code> pased to the constructor.
     * @return The instantianted object.
     */
    private Object createObject(Class handlingClass) {
        Class[] constructorClassArray = {/*GridCommandManager.class,*/ URI.class};
        Object[] constructorParamArray = {/*gcm, */lookupURI}; 
        
        Constructor handlingClassConstructor;   
        try {
            handlingClassConstructor = handlingClass.getConstructor(constructorClassArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        Object returnObject = null;
        try {
            returnObject = handlingClassConstructor.newInstance(constructorParamArray);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return returnObject;
    }


    
}

