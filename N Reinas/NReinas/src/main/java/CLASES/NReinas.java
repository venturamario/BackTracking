/*
AUTORES:        Mario Ventura, Luis Miguel Vargas, Felip Toni Font
ASIGNATURA:     Algoritmia y Estructuras de Datos 1
TRABAJO:        Práctica Final: Backtracking
FECHA:          Enero de 2022
PROFESOR:       Gabriel Fiol Roig
*/


package CLASES;
//-----------------------------------------IMPORTS-----------------------------------------
import javax.swing.JFrame;
import javax.swing.JOptionPane;


//CLASE QUE SOLUCIONA EL PROBLEMA DE LAS n REINAS EN UN TABLERO DE AJEDREZ DE 2 FORMAS DISTINTAS
public class NReinas extends JFrame {
    
    //--------------------------------------ATRIBUTOS--------------------------------------
    static Tablero tab;           //Tablero gráfico
    static String[][] tablero;    //Tablero de Strings para la consola
    static int tamaño;            //Tamaño del tablero (será igual a filas y columnas)
    static int filas,columnas;    //Filas y columnas del tablero
    static boolean solucionado;   //Booleano que muestra si se ha encontrado una solucion
    static int numSoluciones = 0; //Número de soluciones encontradas
    static int f;                 //Fila inicial en la que se encuentra la 1ª reina
    static int c;                 //Columna inicial en la que se encuentra la 1ª reina
    static Tablero[] soluciones;  //Lista donde se almacenarán todas las soluciones
    static Tablero[] auxiliar;    //Lista de soluciones auxiliar
    static int iterar;            //Para saber si se quiere seguir iterando
    static int ejercicio;         //Ejercicio que se va a hacer
    
    
    //--------------------------------------MÉTODOS----------------------------------------
    
    //------------------< ÚTILES >---------------------
    
    //MÉTODO MAIN
    public static void main(String[] args) {
        
        //VARIABLES        
        boolean ward;        //Booleano 1
        boolean correcto;    //Booleano 2
        ejercicio = 0;       //Ejercicio que se hará       
        
        //PREGUNTAR AL USUARIO QUÉ EJERCICIO QUIERE HACER
        ejercicio = preguntarEjercicio();
        
        //PREGUNTAR AL USUARIO POR EL TAMAÑO DEL TABLERO
        tamaño = darTamaño();
        
        //PARA ITERAR SIN SALIR DEL PROGRAMA
        iterar = 1;
        
        //ITERACIÓN
        while (iterar == 1) {
            
            //HACERE JERCICIO 1
            if (ejercicio == 1) {
                //EJECUTAR ALGORITMO QUE SOLUCIONE EL EJERCICIO 1
                ejercicio1(tamaño);
                //PREGUNTAR SI SE QUIERE SEGUIR ITERANDO
                iterar();
            }
            //HACER EJERCICIO 2
            if (ejercicio == 2) {
               //EJECUTAR ALGORITMO QUE SOLUCIONA EL EJERCICIO 2
                ejercicio2(tamaño);
                //PREGUNTAR SI SE QUIERE SEGUIR ITERANDO
                iterar();
            }
        }
        
        //NOS DESPEDIMOS CORDIALMENTE DE NUESTRO ESTIMADO USUARIO
        tab.setVisible(false);
        aviso("ADIÓS","     ¡¡GRACIAS!!");
        
        //CERRAMOS EL PROGRAMA
        System.exit(0);
    }
    //MÉTODO PARA VOLVER A HACER LOS EJERCICIOS SI EL USUARIO QUIERE SEGUIR ITERANDO
    private static void iterar() {
        
        //PREGUNTAR SI SE QUIERE SEGUIR ITERANDO (1 = SI, 2 = NO)
        iterar = seguirIterando("¿QUIERES HACER ALGO MÁS?");
        
        //EN CASO DE QUE SE QUIERA, VOLVER A DAR VALOR A LAS VARIABLES QUE NECESITAMOS
        //PARA LA RESOLUCIÓN DE CUALQUIERA DE LOS EJERCICIOS
        if (iterar == 1) {
            //SI EL USUARIO DICE QUE SI, PREGUNTAR QUÉ EJERCICIO QUIERE HACER
            ejercicio = preguntarEjercicio();
            //PREGUNTAR EL TAMAÑO DEL NUEVO TABLERO
            tamaño = darTamaño();
        }
        //CERRAR EL TABLERO
        tab.setVisible(false);
    }
    //MÉTODO PARA VER SI EL USUARIO QUIERE SEGUIR ITERANDO
    private static int seguirIterando(String s) {
        
        //BOOLEANO QUE SE DEVOLVERÁ TRAS DARLE VALOR
        int iteracion;
        
        //PREGUNTAR SI SE QUIERE SEGUIR ITERANDO
        iteracion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{"SI", "NO"}, "opcion 1");
        
        //DEVOLVER BOOLEANO CON EL VALOR DADO
        return (iteracion+1);
    } 
    //MENSAJE A LOS USUARIOS
    private static void aviso(String s, String titulo) {
        JOptionPane.showMessageDialog(null, s, titulo,JOptionPane.WARNING_MESSAGE);
    }
    //MÉTODO PARA PREGUNTAR QUÉ EJERCICIO SE QUIERE HACER
    private static int preguntarEjercicio() {
        //VARIABLES
        int ejercicio = 0;
        boolean correcto;
        
        //DAR VALOR A LA VARIABLE e
        do {
            correcto = false;
            try {
                //MIRAR QUE EJERCICIO QUIERE HACER EL USUARIO
                ejercicio = Integer.parseInt(JOptionPane.showInputDialog("¿QUÉ EJERCICIO QUIERES HACER? (1 o 2)"));
                //CONTEMPLAR QUE NO SE PONGA 1 O 2
                if (ejercicio == 1 || ejercicio == 2) {
                    correcto = true;
                } else {
                    aviso("INTRODUCE UN NÚMERO VÁLIDO","\tEJERCICIO INEXISTENTE");
                }
            } catch (NumberFormatException e) {
                //NÚMERO DE EJERCICIO NO VÁLIDO
                JOptionPane.showMessageDialog(null, "ERROR, DATO INVÁLIDO", "ERROR",JOptionPane.WARNING_MESSAGE);
                correcto = false;
            }
        } while (correcto == false);
                
        return ejercicio;
    } 
    //MÉTODO PARA COGER EL TAMAÑO DEL TABLERO
    private static int darTamaño() {
        //VARIABLES
        int t = 0;
        boolean ward;
        
        //DAR VALOR A LA VARIABLE t
        do {
            ward = true;
            try {
                t = Integer.parseInt(JOptionPane.showInputDialog("INTRODUCE EL TAMAÑO DEL TABLERO"));
            } catch (NumberFormatException e) {
                // TODO: handle exception
                JOptionPane.showMessageDialog(null, "ERROR, DATO INVÁLIDO", "ERROR",JOptionPane.WARNING_MESSAGE);
                ward = false;
            }
        } while (ward == false);
        
        //RETORNAR EL VALOR LEÍDO
        return t;
    }
    //MÉTODO PARA PREGUNTAR AL USUARIO SI QUIERE VER OTRA SOLUCIÓN AL EJERCICIO 1
    private static int escogerOpcion(String s, String op1, String op2) {
        int seleccion = JOptionPane.showOptionDialog(null, s, "Selector de opciones",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new Object[]{op1, op2}, "opcion 1");
        
        return (seleccion+1);
    } 
    
    //------------------< EJERCICIO 1 >---------------------

    //MÉTODO QUE HAYA UNA SOLUCIÓN PARA EL EJERCICIO 1
    private static void ejercicio1(int tamaño) {
        
        //RESTAURAR Nº DE SOLUCIONES
        numSoluciones = 0;
        //ENTERO QUE SE USARÁ LUEGO
        int seguir;
        //PARA SABER SI SE HA ENCONTRADO UNA SOLUCIÓN
        solucionado = false;
        
        //GENERAMOS LOS TABLEROS
        tablero = generarTablero(tamaño);
        
        //INICIALIZAR LAS LISTAS DE SOLUCIONES
        soluciones = new Tablero[1];
        
        //ALGORITMO CON BACKTRACKING
        ubicarReina(tablero, 0);
        
        //MIRAR SI SE HA ENCONTRADO ALGUNA SOLUCIÓN
        if (numSoluciones > 0) {
            solucionado = true;
        }
        
        //SI NO SE ENCUENTRA NINGUNA SOLUCIÓN, AVISAR AL USUARIO
        if (solucionado == false) {
            aviso("------< NO SE HA ENCONTRADO SOLUCIÓN AL PROBLEMA >------","AVISO");
        } else {
            //PREGUNTAR AL USUARIO CUÁL DE LAS SOLUCIONES QUIERE VER
            int eleccion = leerNum("SE HAN ENCONTRADO "+numSoluciones+" SOLUCIONES. ¿CUÁL QUIERES VER?",numSoluciones);
            
            //MOSTRAR LA SOLUCIÓN QUE SE HA PEDIDO
            soluciones[eleccion-1].paint();
            //PREGUNTAR QUE SOLUCIÓN QUIERE VER, SI ES QUE QUIERE VER OTRA
            seguir = escogerOpcion("¿QUIERES VER OTRA SOLUCIÓN?","SI","NO");
            
            //MOSTRAR SOLUCIONES HASTA QUE EL USUARIO QUIERA SALIR
            while(seguir==1) {
                //PREGUNTAR QUÉ SOLUCIÓN QUIERE VER
                eleccion = leerNum("SE HAN ENCONTRADO "+numSoluciones+" SOLUCIONES. ¿CUÁL QUIERES VER?",numSoluciones);
                //MOSTRAR SOLUCIÓN ESCOGIDA
                soluciones[eleccion-1].paint();
                //PREGUNTAR SI QUIERE VER OTRA SOLUCIÓN
                seguir = escogerOpcion("¿QUIERES VER OTRA SOLUCIÓN?","SI","NO");
            }
        }
    }
    //MÉTODO PARA COLOCAR LA FICHA
    public static void ubicarReina(String[][] tablero, int etapa) {

        for (int i = 0; i < tablero.length; i++) {
            if (isValido(tablero, i, etapa)) {
                tablero[i][etapa] = "D";
                
                if (etapa < tablero.length - 1) {
                    ubicarReina(tablero, etapa + 1);
                } else {
                    //Crear tablero grafico
                    tab = new Tablero(tamaño);
                    
                    //Aumenta el número de soluciones
                    numSoluciones++;
                    
                    //La lista de soluciones auxiliar aumenta
                    auxiliar = new Tablero[numSoluciones];
                    
                    //Copiamos las soluciones a la nueva lista auxiliar
                    for (int idx=0; idx<soluciones.length; idx++) {
                        auxiliar[idx] = soluciones[idx];
                    }
                    
                    tab = copiarTablero(tablero, tab);
                    auxiliar[numSoluciones-1] = tab;
                    
                    //Aumentamos el tamaño de la lista de soluciones
                    soluciones = new Tablero[numSoluciones];
                    
                    //Copiamos las soluciones a la nueva lista auxiliar
                    for (int idx=0; idx<soluciones.length; idx++) {
                        soluciones[idx] = auxiliar[idx];
                    }
                }
                tablero[i][etapa] = " ";
            }
        }
    }
    //MÉTODO PARA VER SI SE PUEDE COLOCAR UNA FICHA
    public static boolean isValido(String[][] tablero, int i, int etapa) {
        for (int x = 0; x < etapa; x++) {
            if (tablero[i][x].equals("D")) {
                return false;
            }
        }
        for (int j = 0; j < tablero.length && (i - j) >= 0 && (etapa - j) >= 0; j++) {
            if (tablero[i - j][etapa - j].equals("D")) {
                return false;
            }
        }
        for (int j = 0; j < tablero.length && (i + j) < tablero.length && etapa - j >= 0; j++) {
            if (tablero[i + j][etapa - j].equals("D")) {
                return false;
            }
        }
        return true;
    }
    //MÉTODO PARA GENERAR EL TABLERO QUE SE MUESTRA POR CONSOLA
    public static String[][] generarTablero(int length) {
        String[][] res = new String[length][length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = " ";
            }
        }
        return res;
    } 
    //MÉTODO PARA GENERAR UN TABLERO CON UNA REINA YA COLOCADA
    public static String[][] generarTablero2(int length, int f, int c) {
        String[][] res = new String[length][length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                    res[i][j] = " ";
            }
        }
        res[f-1][c-1] = "D";
        return res;
    }
    //MÉTODO PARA MOSTRAR EL TABLERO POR CONSOLA
    public static void imprimirMatriz(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("|");
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + "|");
            }
            System.out.println();
        }
    }
    
    
    //------------------< EJERCICIO 2 >---------------------
    
    //MÉTODO QUE RESUELVE EL EJERCICIO 2
    private static void ejercicio2(int tamaño) {
        
        //RESTAURAR NUMERO DE SOLUCIONES
        numSoluciones = 0;
        
        //PARA SABER SI SE ENCUENTRA SOLUCIÓN AL PROBLEMA
        solucionado = false;
        
        //PREGUNTAR POR LA POSICIÓN INICIAL DE LA PRIMERA REINA
        f = leerNum("FILA INICIAL DE LA PRIMERA REINA",tamaño);
        c = leerNum("COLUMNA INICIAL DE LA PRIMERA REINA",tamaño);
        
        //INICIALIZAR LOS TABLEROS CON EL TAMAÑO DADO
        tablero = generarTablero(tamaño);
        
        //DAR VALOR A LAS VARIABLES QUE CUENTAN FILAS Y COLUMNAS
        filas = tamaño;
        columnas = tamaño;
        
        //ALGORITMO CON BACKTRACKING
        colocarReina(tablero,0);
        
        //SI NO SE HA ENCONTRADO NINGUNA SOLUCIÓN, AVISAR AL USARIO
        if (solucionado == false) {
            aviso("NO SE HA ENCONTRADO NINGUNA SOLUCION AL PROBLEMA","\t---< AVISO >---");
        } else {
            //SI HAY SOLUCIÓN, MOSTRARLA GRÁFICAMENTE
            tab.paint();
        }
    }
    //MÉTODO PARA LEER UN NÚMERO
    private static int leerNum(String s, int maximo) {
        //VARIABLE QUE SE DEVOLVERÁ
        int valor = 0;
        boolean b;
        
        //ITERAR HASTA LEER CORRECTAMENTE EL NÚMERO
        do {
            b = false;
            try {
                //MIRAR QUE EJERCICIO QUIERE HACER EL USUARIO
                valor = Integer.parseInt(JOptionPane.showInputDialog(s));
                //CONTEMPLAR QUE SE PONGA UN NÚMERO NO VÁLIDO
                if (valor > 0 || valor <= maximo) {
                   b = true; 
                } else {
                    aviso("EL NÚMERO INTRODUCIDO NO ES VÁLIDO","AVISO");
                }
                
            } catch (NumberFormatException e) {
                //NÚMERO DE EJERCICIO NO VÁLIDO
                JOptionPane.showMessageDialog(null, "ERROR, DATO INVÁLIDO", "ERROR",JOptionPane.WARNING_MESSAGE);
                b = false;
            }
        } while (b == false);
        
        return valor;
    }
    //MÉTODO PARA COLOCAR REINA EN EL TABLERO
    public static void colocarReina(String[][] tablero, int etapa) {
        
        //ALGORITMO CON BACKTRACKING
        for (int i = 0; i<tablero.length && solucionado==false; i++) {
            if (isValido(tablero, i, etapa)) {
                
                tablero[i][etapa] = "D";
                
                if (etapa < tablero.length - 1) {
                    colocarReina(tablero, etapa + 1);
                } else {
                    //Mirar si hay solución dada la casilla inicial
                    if (tablero[c-1][f-1].equals("D")) {
                        //Copiar la solución encontrada en un tablero gráfico
                        tab = new Tablero(tamaño);
                        tab = copiarTablero(tablero, tab);
                        //Para salir de la iteración
                        solucionado = true;
                    }
                }
                tablero[i][etapa] = " ";
            }
        }
    }
    //MÉTODO PARA CONVERTIR UN TABLERO DE String[][] A TABLERO GRÁFICO
    private static Tablero copiarTablero(String[][] tablero, Tablero tab) {
        
        /*
        LA IDEA ES LA SIGUIENTE:
        SE RECORRE TODAS LAS POSICIONES DEL TABLERO/MATRIZ DE STRINGS, Y SI SE
        ENCUENTRA QUE ESTA POSICIÓN TIENE EL VALOR 'D', SIGNIFICA QUE AHÍ DEBE
        IR UNA REINA, POR LO TANTO, SE ESTABLECE QUE LA CASILLA DEL TABLERO
        GRÁFICO QUE SE ENCUENTRA EN LA MISMA POSICIÓN, ESTARÁ OCUPADA TAMBIÉN
        (Casilla.setOcupada(true)).
        UNA VEZ SE HA ACABADO DE RECORRER TODAS LAS CASILLAS DEL TABLERO, YA
        SABEMOS DONDE HAY QUE AÑADIR UN OBJETO FICHA, POR TANTO, LO HACEMOS
        Y MOSTRAMOS EL RESULTADO FINAL EN UN TABLERO GRÁFICO
        */
        
        //ITERAR CADA FILA DEL TABLERO
        for (int i = 0; i < tablero.length; i++) {
            //ITERAR CADA CASILLA DE LA FILA
            for (int j = 0; j < tablero.length; j++) {
                //COMPROBAR SI ESTÁ OCUPADA
                if (tablero[i][j].equals("D")) {
                    tab.getCasillaActual(i, j).setOcupada(true);
                }
            }
        }
        
        //DEVOLVER EL TABLERO A CUYAS CASILLAS HEMOS DADO VALOR
        return tab;
    }
}