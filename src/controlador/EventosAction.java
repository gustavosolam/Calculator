/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.CalculatorOne;
import modelo.ExcepcionCadenaNoValida;
import modelo.ExcepcionNumerosNegativos;
import vista.Ventana;

/**
 * Clase controladora de todos los eventos que se producen en el programa.
 * Básicamente se manejan los eventos de los botones 'Sumar' y 'Limpiar'.
 *
 * @author Gustavo Soto
 */
public class EventosAction implements ActionListener {

    private Ventana frame = new Ventana();
    private CalculatorOne calculadora = new CalculatorOne();
    private int cantidadSumas = 0;

    public EventosAction(Ventana frame, CalculatorOne calculadora) {
        this.calculadora = calculadora;
        this.frame = frame;
        this.frame.getBtnSumar().addActionListener(this);
        this.frame.getBtnBorrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*
         * Se verifica si el objeto que causa el evento es el boton 'Sumar'.
         */
        if (e.getSource() == this.frame.getBtnSumar()) {
            try {
                String resultadoParaMostrar = "";
                calculadora.add(this.frame.getTxtCadena().getText());
                resultadoParaMostrar = calculadora.getNumeros().toString() + " = "
                        + calculadora.getSuma();
                this.cantidadSumas = this.cantidadSumas + 1;
                this.frame.getTxtResultados().append(this.cantidadSumas + ").   " + resultadoParaMostrar + "\n");
            } catch (ExcepcionNumerosNegativos ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
            } catch (ExcepcionCadenaNoValida ex1) {
                JOptionPane.showMessageDialog(frame, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        /*
         * Se verifica si el objeto que causa el evento es el boton 'Limpiar'.
         */
        if (e.getSource() == this.frame.getBtnBorrar()) {
            this.frame.getTxtCadena().setText("");
        }
    }
}
