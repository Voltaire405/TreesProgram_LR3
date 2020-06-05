package co.edu.udea.logica;

import co.edu.udea.logica.Model.Tree;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Tree tree;
        int[] vector;
        List<Integer> inputs = new ArrayList<>();
        String input = "";


        input = JOptionPane.showInputDialog("Por favor ingrese a continuación números enteros de forma sucesiva separados" +
                " por comas y presione aceptar para continuar... ej. 1,2,3,4,...");
        try {
            String[] inputArray = input.split(",");
            for (String inputData :
                    inputArray) {
                Integer inputNumber = Integer.parseInt(inputData);
                inputs.add(inputNumber);
            }
        } catch (Exception n) {
            if (Optional.ofNullable(input).isPresent()) {
                JOptionPane.showMessageDialog(null, "Ingrese valores numéricos enteros por favor!");
            }
            System.exit(1);
        }

        vector = new int[inputs.size() + 1];
        vector[0] = inputs.size();
        int count = 1;
        for (int integer :
                inputs) {
            vector[count] = integer;
            count++;
        }
        tree = new Tree(vector);
        //Imprimir resultados
        System.out.println("Recorrido en preorden:");
        tree.printPreorder(tree.getLinkedList());
        System.out.println("\nRecorrido en posorden:");
        tree.printPostoder(tree.getLinkedList());

        tree.printInorder(tree.getLinkedList());
        printArray(tree.getInorderArray(), "Recorrido en Inorden");

        for (String distance :
                tree.getDistances()) {
            System.out.println(distance);
        }
    }

    public static void printArray(List<Integer> array, String way) {
        String completeMsg = "";
        for (Integer msg :
                array) {
            completeMsg += String.format("%s ", msg);
        }
        System.out.println(
                String.format("%s \n %s", way, completeMsg)
        );
    }
}


