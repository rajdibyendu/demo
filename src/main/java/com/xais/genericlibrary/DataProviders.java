/**
 * 
 */
package com.xais.genericlibrary;

import org.testng.annotations.DataProvider;

/**
 * @author Dibyendu.raj
 *
 */
public class DataProviders {
	
	FileLibrary fLib = new FileLibrary();
	
	@DataProvider(name = "IneternalFootprint")
	public Object[][] getInternalFootprint() {
		return fLib.dataProvider("Internal Footprint");
	}

}
