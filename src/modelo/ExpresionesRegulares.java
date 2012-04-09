/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Gustavo Soto
 */
public class ExpresionesRegulares {

    /**
     * Expresion regular que permite identificar las cadenas de entrada que
     * contienen uno o dos numeros separados por ','.
     */
    public static final String PRIMERA_EXP = "((-?\\d+\\,){0,1}-?\\d+{0,1})";
    /**
     * Expresion regular que permite identificar las cadenas de entrada que
     * contienen una cantidad desconocida de numeros separados por ','.
     */
    public static final String SEGUNDA_EXP = "(-?\\d+\\,)+-?\\d+";
    /**
     * Expresion regular que permite identificar las cadenas de entrada que
     * contienen una cantidad desconocida de numeros separados por ',' o por
     * '\n'.
     */
    public static final String TERCERA_EXP = "((-?\\d+\\,)|(-?\\d+\\n))+-?\\d+";
    /**
     * Expresion regular <p>Permite identificar las cadenas de entrada que
     * comienzan por '//' seguido de un posible delimitador cualquiera, un '\n'
     * y por ultimo cualquier contenido.
     */
    public static final String CUARTA_EXP = "((\\//\\w)|(\\//\\W))\\n(-?\\d+\\W)+-?\\d+"; //"((\\//\\w)|(\\//\\W))\\n([0-9]+\\W)+\\d+"
    /**
     * Expresion regular cuyo valor dependera del delimitador ingresado por el
     * usuario
     */
    public static String expresionRegular;

    /**
     * Retorna una expresion regular dependiendo del delimitador que se le pase
     * como parametro. <p> La expresion regular que se retorna empieza con '//'
     * seguido de un digito, letra o cualquier otro caracter. Posteriormente un
     * '\n', luego uno o mas digitos de 0 a 9 separados por el delimitaddor que
     * se pasa como parametro para terminar en un numero de uno o mas digitos.
     *
     * @param delimiter Parametro tipo Caracter que permite identificar cual va
     * a ser el delimitador de los numeros ingresador en la cadena de
     * caracteres, para asi poder armar la expresion regular.
     * 
     * @return  La expresion regular con el delimitador propuesto.
     */    
    public static String getExpresionRegular(char delimiter) {
        //ExpresionesRegulares.expresionRegular = "((\\//\\w)|(\\//\\W))\\n([0-9]+\\" + delimiter + ")*\\d+";
        ExpresionesRegulares.expresionRegular = "((\\//\\W))\\n(-?\\d+\\" + delimiter + ")*-?\\d+"; //"((\\//\\W))\\n([0-9]+\\" + delimiter + ")*\\d+"
        
        return ExpresionesRegulares.expresionRegular;
    }
}
