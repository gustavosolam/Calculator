/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Gustavo Soto
 */
public class CalculatorOne {

    /**
     * String que almacena la cadena de caracteres ingresada por el usuario. 
     */
    private String cadenaEntrada;
    
    /**
     * Lista de objetos tipo Integer donde se almacena los numeros que ingreso
     * el usuario.
     */
    private List<Integer> numeros = new ArrayList<Integer>();
    
    /**
     * Lista de onjetos de tipo Integer donde se almacena los numeros negativos
     * que ingreso el usuario.
     */
    private List<Integer> numerosNegativos = new ArrayList<Integer>();
    
    /**
     * Entero que almacena el resultado de la suma.
     */
    private int suma = 0;
    
    /**
     * Char que almacena el delimitador que establece e usuario, segun la cadena
     * de caracteres que ingresa en el formato "//[delimiter]\n[numbers...]".
     */
    private char delimiter;
    
    /**
     * Constructor
     */
    public CalculatorOne() {
    }

    /**
     * Metodo que permite sumar los numeros ingresados en la cadena de
     * caracteres, si esta cumple con el formato establecido.
     *
     * @param cadena Cadena de caracteres que contendran los numeros para sumar.
     * @return Retorna la suma de los numeros ingresados en la cadena de
     * caractres.
     * @throws ExcepcionNumerosNegativos. Excepcion que permite verificar si la
     * cadena de entrada contiene numeros negativos.
     *
     */
    public int add(String cadena) throws ExcepcionNumerosNegativos, ExcepcionCadenaNoValida {
        
         //Si las Listas de numeros no son vacias se borran.
        if (!this.numeros.isEmpty()){
            this.numeros.clear();
            this.numerosNegativos.clear();
            this.suma = 0;
        }

        //Inicializamos la variable 'cadenaEntrada'
        setCadenaEntrada(cadena);

        //Si la cadena esta vacia se da el valor de '0' a la suma.
        if (cadena.isEmpty()) {
            this.suma = 0;
        }     

        //Se verifica que la cadena de entrada tenga un formato adecuado.
        if (stringIsCorrect() && !contieneNegativos()) {

            /*
             * Se convierten los numeros que estan como cadenas de caracteres a
             * numeros. El criterio para partir la cadena son los caracteres
             * '//', \n', ',', o delimitador propuesto por el usuario.
             */
            setNumeros("\\//|\\n|\\,|\\" + this.delimiter);

            //Almacena en variable la longitud de la lista de numeros.
            int longitudLista = this.numeros.size();

            /*
             * Ciclo que recorre toda la lista y va almacenando en la variable
             * 'suma' la suma acumulada.
             */
            for (int i = 0; i < longitudLista; i++) {
                this.suma = this.suma + this.numeros.get(i);
            }
            
        }
                
        /*
         * Si la cadena de entrada es correcta y ademas contiene algun signo
         * negativo, se produce la excepcion 'ExcepcionNumerosNegativos'.
         */
        if (stringIsCorrect() && contieneNegativos()) {
            setNumeros("\\//|\\n|\\,|\\" + this.delimiter);
            String mensaje = "Los siguientes numeros no son permitidos "
                    + "ya que son negativos.\n"
                    + this.numerosNegativos.toString() + "\n" + 
                    "\nSolo debe ingresar numeros positivos.";
            throw new ExcepcionNumerosNegativos(mensaje);
        }
        
        /*
         * Si la cadena de entrada no es correcta se genera la excepcion de tipo
         * 'ExcepcionCadenaNoValida'
         */
        if (!stringIsCorrect() && !cadena.isEmpty()){
            String mensaje = "Entrada de texto no válida";
            throw new ExcepcionCadenaNoValida(mensaje + "\n" +
                    "Las entradas de texto validas son:\n" + 
                    "1. Entrada vacia, uno o dos numeros separados por ','.\n" + 
                    "2. Cualquier cantidad de numeros enteros separados por ','.\n" + 
                    "3. Cualquier cantidad de numeros enteros separados por ',' o por salto de linea.\n"+
                    "4. Cualquier cantidad de numeros enteros separados por el caracter que usted defina\n"+
                    "    teniendo en cuenta el formato '//[delimiter]\\n[numbers...]'" + 
                    "donde '\\n' es un salto de linea.");
        }
        return this.suma;
    }

    /**
     *
     * @param cadenaEntrada Cadena de caracteres que contendran los numeros para
     * sumar.
     */
    public void setCadenaEntrada(String cadenaEntrada) {
        this.cadenaEntrada = cadenaEntrada;
    }

    /**
     * Se verifica que la cadena ingresada por el usuario tenga un formato
     * adecuado para poder realizar la operaci{on.
     *
     * @return Si la cadena ingresada es correcta devuelve true de lo contrario
     * devolvera false.
     */
    public boolean stringIsCorrect() {
        int cont = 0;

        /*
         * Se crea un Array de objetos de la clase Pattern los cuales contienen
         * la posibles cadenas que podria ingresar el usuario.
         */
        Pattern p[] = new Pattern[4];
        boolean b = false;

        /*
         * Se inicializan los objetos Pattern teniendo en cuenta las diferentes
         * expresiones regulares que se encuentran en la clae
         * ExpresionesRegulares
         */
        p[0] = Pattern.compile(ExpresionesRegulares.PRIMERA_EXP);
        p[1] = Pattern.compile(ExpresionesRegulares.SEGUNDA_EXP);
        p[2] = Pattern.compile(ExpresionesRegulares.TERCERA_EXP);
        p[3] = Pattern.compile(ExpresionesRegulares.CUARTA_EXP);

        /*
         * Este ciclo permite identificar si la cadena ingresada por el usuario
         * cumple con los patrones creados segun el Array de objetos Pattern,
         * esto con la ayuda de un objeto de la clase Matcher. Si se identifica
         * en cualquier momento del ciclo que el patron coincide se sale del
         * ciclo quedando la variable 'b' en true.
         */
        while (cont < p.length) {
            Matcher m = p[cont].matcher(this.cadenaEntrada);
            b = m.matches();
            if (b) {
                break;
            }
            cont = cont + 1;
        }

        /*
         * Este condicional permite identificar que la cadena ingresada por el
         * usuario coincide con el formato "//[delimiter]\n[numbers...]
         * representada por la expresion regular que esta almacenada en la
         * varialble 'CUARTA_EXP' de la clase 'ExpresionesRegulares'
         */
        if (b && cont == 3) {
            /*
             * Se supone que el delimitador es el caracter numero 3 de la cadena
             * ingresada con formato "//[delimiter]\n[numbers...]"
             */
            this.delimiter = this.cadenaEntrada.charAt(2);

            /*
             * Se crea un objeto de la clase Pattern construyendo una expresion
             * regular de acuerdo al delimitador propuesto por el usuario.
             * Posteriormente con el objeto Matcher se verifica si el resto de
             * la cadena ingresada por el usuario esta delimitado por el
             * caracter que el propuso. Si no es asi deja el valor de la
             * variable 'b' en false. Ej: Si el usuario ingresa '//;\n1,2,3...',
             * sera una cadena no valida puesto que se esta diciendo que el
             * delimitador es ';' y los numeros se estan separando por ','. Los
             * delimitadores puden ser cualuiqer caracter que no alfanumerico.
             */
            Pattern p1 = Pattern.compile(ExpresionesRegulares.getExpresionRegular(delimiter));
            Matcher m = p1.matcher(this.cadenaEntrada);
            b = m.matches();
        }

        return b;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Metodo que permite convertir los numeros ingresados como cadena de
     * caractres a numeros de tipo int.
     *
     * @param regex String de expresion regular que indica cuales van a ser los
     * caracteres por los cuales se va a partir la cadena ingresada por el
     * usuario, para almacenar exclusivamente los numeros.
     */
    public void setNumeros(String regex) {
        /*
         * Se crea Array tipo String que contiene exclusivamente numeros
         * partiendo la cadena de entrada por el usuario segun la expresion
         * regular recibida como parametro.
         */
        String arrayNumeros[] = this.cadenaEntrada.split(regex);

        //Se llena arrayNumeros.
        for (int i = 0; i < arrayNumeros.length; i++) {
            /*
             * Si el valor del Array en la posicion que estamos iterando no es
             * vacio insertamos dicho valor en la Lista de enteros, realizando
             * un cast a dicho valor para dejarlo de tipo int.
             */
            if (!arrayNumeros[i].isEmpty()) {
                this.numeros.add(Integer.parseInt(arrayNumeros[i]));

                /*
                 * Si el numero en el que estamos en la iteracion es menor que
                 * '0' lo agregamos tambien en la Lista 'numerosNegativos'.
                 */
                if (Integer.parseInt(arrayNumeros[i]) < 0) {
                    this.numerosNegativos.add(Integer.parseInt(arrayNumeros[i]));
                }
            }
        }
    }

    /**
     *
     * @return Los numeros ingresados en la cadena de entrada. Se retorna en un
     * objeto tipo List.
     */
    public List getNumeros() {
        return this.numeros;
    }

    /**
     * Retorna el valor de la suma almacenada en la variable 'suma'.
     *
     * @return La suma de los numeros.
     */
    public int getSuma() {
        return suma;
    }

    /**
     *
     * @return Retorna objeto String con la cadena de entrada.
     */
    public String getCadenaEntrada() {
        return cadenaEntrada;
    }

    /**
     *
     * @return Retorna el delimitador de la cadena cuando esta es ingresada en
     * el formato "//[delimiter]\n[numbers...]
     */
    public char getDelimiter() {
        return delimiter;
    }

    /**
     * Verifica si la cadena contiene algun signo '-' lo cual supondria que hay
     * por lo menos un numero negativo.
     *
     * @return true si hay al menos un signo '-' de lo contrario false.
     */
    public boolean contieneNegativos() {
        boolean retorno = false;
        if (this.cadenaEntrada.contains("-")) {
            retorno = true;
        }
        return retorno;
    }
}
