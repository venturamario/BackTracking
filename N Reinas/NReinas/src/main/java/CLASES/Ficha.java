/*
AUTORES:        Mario Ventura, Luis Miguel Vargas, Felip Toni Font
ASIGNATURA:     Algoritmia y Estructuras de Datos 1
TRABAJO:        Práctica Final: Backtracking
FECHA:          Enero de 2022
PROFESOR:       Gabriel Fiol Roig
*/

package CLASES;

//CLASE CASILLA (REINA)
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Ficha {
    
    //--------------------------------ATRIBUTOS---------------------------------
    private BufferedImage ficha;
    
    //---------------------------------MÉTODOS----------------------------------
    
    //CONSTRUCTOR DE OBJETO FICHA
    public Ficha(String imagen) {
        
        //LEER LA IMAGEN QUE HARÁ DE FICHA (reina.png)
        try {
            ficha = ImageIO.read(new File(imagen));
        } catch (Exception ex) {
            
        }  
    }
    
    //MÉTODO GETTER
    public BufferedImage getImagen() {
        return ficha;
    } 
    
    //PARA DIBUJAR LA FICHA SOBRE EL TABLERO
    public void dibujarEnTablero(Graphics g, float x, float y) {
        
        //USAR EL MÉTODO DE java 'drawImage', QUE REQUIERE LOS SIGUIENTES PARÁMETROS:
        //drawImage(BufferedImage imagen, int coordenadaX, int coordenadaY, ImageObserver observer)
        
        g.drawImage(ficha, (int) x + 10, (int) y + 10, null); //Image observer a null
    }
    
}
