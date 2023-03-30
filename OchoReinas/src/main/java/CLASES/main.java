package CLASES;

//RESOLVER PORBLEMA DE LAS 8 REINAS CON RECURSIVIDAD
public class main {
    
    //---------------------------------VARIABLES---------------------------------
    private static final int numReinas = 8;
    private static final int filas = numReinas;
    private static final int columnas = numReinas;
    private static int[][] tablero;
    
    
    //----------------------------------MÉTODOS----------------------------------
    //MÉTODO MAIN
    public static void main(String[] args) {
        //INVOCACIÓN DE LOS MÉTODOS DESARROLLADOS A LO LARGO DE LA CLASE
        
        //Tablero inicial
        tablero = new int[filas][columnas];
        System.out.println("\n\tEL TABLERO ANTES DE EJECUTAR EL ALGORITO ES:\n");
        inicializarTablero();
        mostrarTablero();
        
        //COLOCAR LA PRIMERA FICHA
        System.out.println("\n\tCOLOCAMOS LA PRIMERA FICHA EN LA ESQUINA SUPERIOR IZQUIERDA:\n");
        tablero[0][0] = 1;
        mostrarTablero();
        
        //Ejecución del algoritmo recursivo
        System.out.println("\n\n\tEJECUTAMOS EL ALGORITMO RECURSIVO Y LA PRIMERA SOLUCIÓN ENCONTRADA ES LA SIGUIENTE:\n");
        
    }
    
    //CREAR Y MOSTRAR EL TABLERO INICIAL
    private static void inicializarTablero() {
        //Iterar filas
        for (int i = 0; i < filas; i++) {
            //Iterar columnas
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = 0;
            }
        }
    }
    
    //MÉTODO PARA MOSTRAR EL TABLERO EN SU ESTADO ACTUAL
    public static void mostrarTablero() {
        //ITERAR Y MOSTRAR TODAS LAS CASILLAS DEL TABLERO
        for (int i = 0; i < filas; i++) {
            //Iterar columnas
            for (int j = 0; j < columnas; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println("");
        }
    }
    
    //DEVUELVE TRUE SI SE LLEGA A UNA SOLUCIÓN
    public static boolean solucion(int[][] tablero, int f, int reinasColocadas) {
        //Comprobar si ya se han colocado todas las reinas
        if (reinasColocadas == numReinas) {
            return true;
        }
        
        //ITERACIÓN SOBRE LAS FILAS
        for (int i = 0; i < filas; i++) {
            //ITERACIÓN SOBRE LAS COLUMNAS
            for (int j = 0; j < columnas; j++) {
                
                //COMPROBAR SI SE PUEDE PONER LA FICHA
                if (sePuedeReina(tablero,filas,columnas,reinasColocadas) == true) {
                    tablero[i][j] = 1;  //SE PUEDE, PONER UN 1
                    reinasColocadas++;  //AUMENTAR EL nº DE REINAS COLOCADAS
                    
                    //COMPROBAR SI SE HAN COLOCADO TODAS LAS REINAS O HAY QUE SEGUIR ITERANDO
                    if (reinasColocadas == numReinas) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    //MÉTODO QUE COMPRUEBA SI SE PUEDE PONER UNA FICHA
    public static boolean sePuedeReina(int[][] tablero, int filas, int columnas, int reinasColocadas) {
        
        //COMPROBAR LAS FILAS
        if (filas < 0 || filas >= reinasColocadas) {
            return false;   //No se puede
        }
        //COMPROBAR LAS COLUMNAS
        if (columnas < 0 || columnas >= reinasColocadas) {
            return false;   //No se puede
        }
        
        //
        
        return false;
    }
    
}
