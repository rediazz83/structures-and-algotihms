package edu.udemy.algorithms.arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayTest {

    private int [] intArray;

    @BeforeEach
    public void setUp() {
        intArray = new int[]{20, 35, -15, 7, 55, 1, -22};
    }

    /*Un ejemplo de algoritmo de complejidad tiempo constante: No importa el tamaño del arreglo, al
    conocer el índice del valor a recuperar siempre repetiremos la misma cantidad de pasos*/
    @Test
    public void testBigOConstantTime() {
        int result = intArray[3];
        assertEquals(7, result);
    }

    /*Un ejemplo de algoritmo de complejidad tiempo lineal: Al desconocer el indice del elemento a recuperar,
    nos lleva recorrer el arreglo, por lo tanto la complejidad aumentará en base al tamaño del mismo y la posicion
    en que se ecuentre el valor a recuperar. Con esto podemos concluír que no es una estructura recomendable para
    este propósito*/

    @Test
    public void testBigOLinealTime() {
        int idx = -1;
        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] == 7) {
                idx = i;
                break;
            }
        }

        int result = intArray[idx];
        assertEquals(7, result);
    }

    /*Un ejemplo de algoritmo de complejidad tiempo cuadratica: Usando el metodo de la burbuja para ordenar este
    arreglo de menor a mayor, podemos observar que la complejidad de tiempo está determiada por la cantidad de bucles
    existentes y al estar contenido el uno dentro del otro, lo cual eleva la complejidad al cuadrado*/
    @Test
    public void testBigOCuadraticTime() {
        for(int lastUnsortIndex = intArray.length -1; lastUnsortIndex > 0; lastUnsortIndex--) {
            for(int index = 0; index < lastUnsortIndex; index++) {
                int nextIndex = index + 1;
                if(intArray[index] > intArray[nextIndex]) {
                    swapOrBomb(intArray, index, nextIndex);
                }
            }
        }

        assertEquals(-22, intArray[0]);
        assertEquals(-15, intArray[1]);
        assertEquals(1, intArray[2]);
        assertEquals(7, intArray[3]);
        assertEquals(20, intArray[4]);
        assertEquals(35, intArray[5]);
        assertEquals(55, intArray[6]);
    }

    private void swapOrBomb(int [] array, int i, int j) throws UnsupportedOperationException {
        if(i == j) {
            throw new UnsupportedOperationException("Nothing for sort");
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
