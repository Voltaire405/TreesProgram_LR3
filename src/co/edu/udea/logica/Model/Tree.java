package co.edu.udea.logica.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Tree {
    private int[] vector;
    private List<Integer> inorderArray;
    private List<String> distances;
    private NodoDoble linkedList;
    Integer firstNodeInorder, distanceCount, secondNodeInorder;
    int rootDistance;
    private boolean rightSide;

    public Tree(int[] vector) {
        setVector(vector);
        setLinkedList(getTreeAsLikedList(getVector(), 1));
        inorderArray = new ArrayList();
        distances = new ArrayList();
        firstNodeInorder = null;
        distanceCount = 0;
        rightSide = false;
        rootDistance = 0;
        secondNodeInorder = null;
    }

    public List<String> getDistances() {
        return distances;
    }

    public void setDistances(List<String> distances) {
        this.distances = distances;
    }

    public int[] getVector() {
        return vector;
    }

    public void setVector(int[] vector) {
        this.vector = vector;
    }

    public NodoDoble getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(NodoDoble linkedList) {
        this.linkedList = linkedList;
    }

    public List<Integer> getInorderArray() {
        return inorderArray;
    }

    public void setInorderArray(List<Integer> inorderArray) {
        this.inorderArray = inorderArray;
    }

    /**
     * Retorna representación de árbol a partir de un vector cómo lista ligada.
     *
     * @param vector De entradas númericos enteros.
     * @param index  Con la posición del dato a agregar en el árbol.
     * @return Lista ligada que representa el árbol.(NodoDoble vinculado)
     */
    public NodoDoble getTreeAsLikedList(int[] vector, int index) {
        NodoDoble node = null;
        if (index <= vector[0]) {
            node = new NodoDoble(vector[index]);
            node.setLi(getTreeAsLikedList(vector, 2 * index));
            node.setLd(getTreeAsLikedList(vector, 2 * index + 1));
        }
        return node;
    }

    public void printInorder(NodoDoble node) {
        if (Optional.ofNullable(node).isPresent()) {
            if (rightSide ? !Optional.ofNullable(secondNodeInorder).isPresent() : !Optional.ofNullable(firstNodeInorder).isPresent())
                rootDistance++;
            printInorder(node.getLi());
            inorderArray.add(node.getDato());

            //Instrucciones para calcular la distancia de la primer hoja al resto.
            if (node.getDato() == vector[1]) {
                rightSide = true;
                rootDistance--;
            } else {
                if (Optional.ofNullable(firstNodeInorder).isPresent()) distanceCount++;//suma distancia
                if (!Optional.ofNullable(node.getLd()).isPresent() &&
                        !Optional.ofNullable(node.getLi()).isPresent()) {
                    if (rightSide ? Optional.ofNullable(secondNodeInorder).isPresent() : Optional.ofNullable(firstNodeInorder).isPresent()) {
                        String msg = String.format("La distancia desde %s hasta %s es: %s", firstNodeInorder, node.getDato(),
                                distanceCount);
                        distances.add(msg);//almacena resultado de cálculo de distancias.
                        distanceCount--;//se devuelve
                    } else {
                        if (rightSide) {
                            secondNodeInorder = node.getDato();
                            distanceCount = rootDistance;
                            String msg = String.format("La distancia desde %s hasta %s es: %s", firstNodeInorder, node.getDato(),
                                    distanceCount);
                            distances.add(msg);//almacena resultado de cálculo de distancias.
                            distanceCount--;
                        } else {
                            firstNodeInorder = node.getDato();
                        }
                    }
                }//fin instrucciones cálculo de distancia.
            }

            printInorder(node.getLd());
        }
    }

    public void printPostoder(NodoDoble node) {
        if (Optional.ofNullable(node).isPresent()) {
            printPostoder(node.getLi());
            printPostoder(node.getLd());
            System.out.println(node.getDato());
        }
    }

    public void printPreorder(NodoDoble node) {
        if (Optional.ofNullable(node).isPresent()) {
            System.out.println(node.getDato());
            printPreorder(node.getLi());
            printPreorder(node.getLd());
        }
    }


}
