/**
 * 
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * @author ameliecourtin
 *
 */
public class CaseModelTest {
	
	static CaseModel caseDeTest ;

	protected int coordonneeY ;
	protected int coordonneeX ;
	protected boolean estUtilisee = false;
	protected boolean estVide =  false;
	
	
    @BeforeClass
    public static void setUpClass() {
        caseDeTest = new CaseModel(13,14,false, false);
    }
    
    @AfterClass
    public static void tearDownClass() {
        caseDeTest = null;
    }
    

	@Test
    public void testGetCoordonneeX () {
        assertEquals(14, caseDeTest.getCoordonneeX());
    }
	
    @Test
    public void testGetCoordonneeY(){
        assertEquals(13, caseDeTest.getCoordonneeY());
    }
    @Test
    public void testEstUtilisée(){
        assertEquals(false, caseDeTest.getEstUtilisee());
    }
    @Test
    public void testEstVide(){
        assertEquals(false, caseDeTest.getEstVide());
    }
	
}


