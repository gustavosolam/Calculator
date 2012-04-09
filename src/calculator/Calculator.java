/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import modelo.CalculatorOne;
import vista.Ventana;
import controlador.EventosAction;

/**
 *
 * @author Gustavo
 */
public class Calculator {
    
    public static void main(String[] args) {
        // TODO code application logic here       
        Ventana ventana = new Ventana();//vista
        CalculatorOne calculadora1 = new CalculatorOne();
        EventosAction controlador = new EventosAction(ventana, calculadora1);
        ventana.crearVentana();
    }    
}
