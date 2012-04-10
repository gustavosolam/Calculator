/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author corganiza2
 */
public class CalculatorOneTest {

    CalculatorOne instance = new CalculatorOne();
    String cadena[] = {"", "1", "1,2", "1,2,3,4,5",
        "1331,9938,8800,8081,5349,2850,9080,2140,7801,6852,7558,"
        + "1773,745,436,5195,3416,2380,6887,5075,8460,5963,6429,"
        + "2589,4725,8769", "1\n2", "1\n2,3", "//;\n1;2", "//;\n1;2;10",
        "//,\n1,2,10", "//.\n1.2.10"};
    String cadenaConNegativos[] = {"-1", "-1,-2", "1,-2", "-20,-30,-40", "-40\n50"};
    String cadenaNoValida[] = {"- 1", "m1, -2", "1m,2", "*96", "-40\nn50", "//.\n1;2;3",
        "1,2,", "1,2.3", ",1,", "//;\n10,20,30"};

    public CalculatorOneTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class CalculatorOne.
     */
    @Test//(expected=ExcepcionNumerosNegativos.class)
    public void testAdd() throws Exception {

        System.out.println("CalculatorOneTest: testAdd");        
        
        //Cadena de entrada -> ""
        int expResult = 0;
        int result = instance.add(cadena[0]);
        assertEquals(expResult, result);
        
        //Cadena de entrada -> "1"
        expResult = 1;
        result = instance.add(cadena[1]);
        assertEquals(expResult, result);
        
        //Cadena de entrada -> "1,2"
        expResult = 3;
        result = instance.add(cadena[2]);
        assertEquals(expResult, result);

        //Cadena de entrada -> "1,2,3,4,5"   
        expResult = 15;
        result = instance.add(cadena[3]);
        assertEquals(expResult, result);
        
        //Cadena de entrada -> "1331,9938,8800,8081,5349,2850,9080,2140,7801,6852,7558,1773,745,436,5195,3416,2380,6887,5075,8460,5963,6429,2589,4725,8769"
        expResult = 132622;
        result = instance.add(cadena[4]);
        assertEquals(expResult, result);
        
        //Cadena de entrada -> "1\n2"
        expResult = 3;
        result = instance.add(cadena[5]);
        assertEquals(expResult, result);
        
        //Cadena de entrada -> "1\n2,3"
        expResult = 6;
        result = instance.add(cadena[6]);
        assertEquals(expResult, result);

        //Cadena de entrada -> "//;\n1;2"
        expResult = 3;
        result = instance.add(cadena[7]);
        assertEquals(expResult, result);

        //Cadena de entrada -> "//;\n1;2;10"
        expResult = 13;
        result = instance.add(cadena[8]);
        assertEquals(expResult, result);

        //Cadena de entrada -> "//,\n1,2,10"
        expResult = 13;
        result = instance.add(cadena[9]);
        assertEquals(expResult, result);

        //Cadena de entrada -> "//.\n1.2.10"
        expResult = 13;
        result = instance.add(cadena[10]);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class CalculatorOne, a la excepcion
     * ExcepcionNumerosNegativos.
     */
    @Test(expected = ExcepcionNumerosNegativos.class)
    public void testAddExcepcionNumerosNegativos() throws Exception {

        System.out.println("CalculatorOneTest: testAdd - ExcepcionNumerosNegativos");
        
        //Cadena de entrada -> "-1"
        instance.add(cadenaConNegativos[0]);
        
        //Cadena de entrada -> "-1,-2"
        instance.add(cadenaConNegativos[1]);
        
        //Cadena de entrada -> "1,-2"
        instance.add(cadenaConNegativos[2]);
        
        //Cadena de entrada -> "-20,-30,-40"
        instance.add(cadenaConNegativos[3]);       
        
        //Cadena de entrada -> "-40\n50"
        instance.add(cadenaConNegativos[4]);  
    }

    /**
     * Test of add method, of class CalculatorOne, a la excepcion
     * ExcepcionNumerosNegativos.
     */
    @Test(expected = ExcepcionCadenaNoValida.class)
    public void testAddExcepcionCadenaNoValida() throws Exception {

        System.out.println("CalculatorOneTest: testAdd - ExcepcionCadenaNoValida");
        instance.add(cadenaNoValida[0]);
        instance.add(cadenaNoValida[1]);
        instance.add(cadenaNoValida[2]);
        instance.add(cadenaNoValida[3]);
        instance.add(cadenaNoValida[4]);
        instance.add(cadenaNoValida[5]);
        instance.add(cadenaNoValida[6]);
        instance.add(cadenaNoValida[7]);
        instance.add(cadenaNoValida[8]);
        instance.add(cadenaNoValida[9]);
    }

    /**
     * Test of setCadenaEntrada method, of class CalculatorOne.
     */
    @Test
    public void testSetCadenaEntrada() {
        System.out.println("setCadenaEntrada");
        String cadenaEntrada = "";
        instance.setCadenaEntrada(cadena[0]);
        instance.setCadenaEntrada(cadena[1]);
        instance.setCadenaEntrada(cadena[2]);
        instance.setCadenaEntrada(cadena[3]);
        instance.setCadenaEntrada(cadena[4]);
        instance.setCadenaEntrada(cadena[5]);
        instance.setCadenaEntrada(cadena[6]);
        instance.setCadenaEntrada(cadena[7]);
        instance.setCadenaEntrada(cadena[8]);
        instance.setCadenaEntrada(cadena[9]);
        instance.setCadenaEntrada(cadena[10]);

        instance.setCadenaEntrada(cadenaNoValida[0]);
        instance.setCadenaEntrada(cadenaNoValida[1]);
        instance.setCadenaEntrada(cadenaNoValida[2]);
        instance.setCadenaEntrada(cadenaNoValida[3]);
        instance.setCadenaEntrada(cadenaNoValida[4]);
        instance.setCadenaEntrada(cadenaNoValida[5]);
        instance.setCadenaEntrada(cadenaNoValida[6]);
        instance.setCadenaEntrada(cadenaNoValida[7]);
        instance.setCadenaEntrada(cadenaNoValida[8]);
        instance.setCadenaEntrada(cadenaNoValida[9]);

        instance.setCadenaEntrada(cadenaConNegativos[0]);
        instance.setCadenaEntrada(cadenaConNegativos[1]);
        instance.setCadenaEntrada(cadenaConNegativos[2]);
        instance.setCadenaEntrada(cadenaConNegativos[3]);

    }

    /**
     * Test of stringIsCorrect method, of class CalculatorOne.
     */
    @Test
    public void testStringIsCorrect() {
        System.out.println("stringIsCorrect");

        instance.setCadenaEntrada(cadenaNoValida[0]);
        boolean expResult = false;
        boolean result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[1]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[2]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[3]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[4]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[5]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[6]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[7]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[8]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[9]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[0]);
        expResult = false;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[1]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[2]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[3]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[4]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[5]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[6]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[7]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[8]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[9]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[10]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);


        instance.setCadenaEntrada(cadenaConNegativos[0]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[1]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[2]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[3]);
        expResult = true;
        result = instance.stringIsCorrect();
        assertEquals(expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeros method, of class CalculatorOne.
     */
    @Test
    public void testSetNumeros() {
        System.out.println("setNumeros");
        //String regex = "";
        //CalculatorOne instance = new CalculatorOne();

        instance.setCadenaEntrada(cadena[2]);
        instance.setNumeros("\\,");
        List<Integer> expResult = new ArrayList<Integer>();
        expResult.add(1);
        expResult.add(2);
        List<Integer> result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[3]);
        instance.setNumeros("\\,");
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);
        expResult.add(4);
        expResult.add(5);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[5]);
        instance.setNumeros("\\n");
        expResult.add(1);
        expResult.add(2);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[6]);
        instance.setNumeros("\\n|\\,");
        expResult.add(1);
        expResult.add(2);
        expResult.add(3);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[7]);
        instance.setNumeros("\\//|\\n|\\,|\\;");
        expResult.add(1);
        expResult.add(2);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[8]);
        instance.setNumeros("\\//|\\n|\\,|\\;");
        expResult.add(1);
        expResult.add(2);
        expResult.add(10);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[9]);
        instance.setNumeros("\\//|\\n|\\,|\\,");
        expResult.add(1);
        expResult.add(2);
        expResult.add(10);
        result = instance.getNumeros();
        assertEquals(expResult, result);

        instance.getNumeros().clear();
        expResult.clear();
        instance.setCadenaEntrada(cadena[10]);
        instance.setNumeros("\\//|\\n|\\,|\\.");
        expResult.add(1);
        expResult.add(2);
        expResult.add(10);
        result = instance.getNumeros();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCadenaEntrada method, of class CalculatorOne.
     */
    @Test
    public void testGetCadenaEntrada() {
        System.out.println("getCadenaEntrada");

        instance.setCadenaEntrada(cadena[0]);
        String expResult = "";
        String result = instance.getCadenaEntrada();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[1]);
        expResult = "1";
        result = instance.getCadenaEntrada();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[2]);
        expResult = "1,2";
        result = instance.getCadenaEntrada();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[3]);
        expResult = "1,2,3,4,5";
        result = instance.getCadenaEntrada();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[0]);
        expResult = "-1";
        result = instance.getCadenaEntrada();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[1]);
        expResult = "-1,-2";
        result = instance.getCadenaEntrada();
        assertEquals(expResult, result);




    }

    /**
     * Test of contieneNegativos method, of class CalculatorOne.
     */
    @Test
    public void testContieneNegativos() {
        System.out.println("contieneNegativos");
        //CalculatorOne instance = new CalculatorOne();

        //for (int i = 0 ; i < cadenaConNegativos.length ; i++){
        instance.setCadenaEntrada(cadenaConNegativos[0]);
        boolean expResult = true;
        boolean result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[1]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[2]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[3]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaConNegativos[4]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[0]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[1]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[2]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[3]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[4]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[5]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[6]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[7]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[8]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[9]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadena[10]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[0]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[1]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[2]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[3]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[4]);
        expResult = true;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);

        instance.setCadenaEntrada(cadenaNoValida[5]);
        expResult = false;
        result = instance.contieneNegativos();
        assertEquals(expResult, result);


    }
}
