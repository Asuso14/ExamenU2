package org.example;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Examen {
    public void ex1(){
        //Aquí definimos las variables
        Scanner entry = new Scanner(System.in);
        Random random = new Random();
        String user_election;
        int user_points=0,rounds = 3, machine_points=0 ,random_election;
        //Indicamos los valores que hay
        System.out.println("p: Piedra");
        System.out.println("a: Papel");
        System.out.println("t: Tijera");

        for (int i=1;i<=rounds;i++)//mientras la i no llegue a las rondas no acaba el juego
        {
            System.out.println("¿Cual es tu opción? (p/a/t)");
            user_election = entry.next();
            random_election = random.nextInt(3) + 1;
            switch (user_election){//En este switch basicamente comprobamos segun lo que el usuario haya ingresado
                //y con la informacion que tenemos guardada de el random del pc quien a ganado/perdido. Y si hay un
                //empate se agrega una ronda mas y nadie gana. Cada una tiene su respectivo mensaje
                case "p":
                    if (random_election == 3){
                        System.out.println("El ordenador a elegido Tijera");
                        System.out.println("¡Has ganado!");
                        user_points++;
                    } else if (random_election == 2) {
                        System.out.println("El ordenador a elegido Papel");
                        System.out.println("¡Has Perdido!");
                        machine_points++;
                    }else{
                        System.out.println("Ha habido un empate!");
                        rounds++;
                    }
                    break;
                case "a":
                    if (random_election == 3){
                        System.out.println("El ordenador a elegido Tijera");
                        System.out.println("¡Has perdido!");
                        machine_points++;
                    } else if (random_election == 1) {
                        System.out.println("El ordenador a elegido Piedra");
                        System.out.println("¡Has ganado!");
                        user_points++;
                    }else{
                        System.out.println("Ha habido un empate!");
                        rounds++;
                    }
                    break;
                case "t":
                    if (random_election == 2){
                        System.out.println("El ordenador a elegido Papel");
                        System.out.println("¡Has ganado!");
                        user_points++;
                    } else if (random_election == 1) {
                        System.out.println("El ordenador a elegido Piedra");
                        System.out.println("¡Has perdido!");
                        machine_points++;
                    }else{
                        System.out.println("Ha habido un empate!");
                        rounds++;
                    }
                    break;
                default:
                    System.out.println("Has introducido un parametro incorrecto");
                    rounds++;
            }
            //Si no habian jugado aun ninguna ronda imprime las normas de juego
            if (i == 1){
                System.out.println("Papel (a) gana a priedra (p)");
                System.out.println("Piedra (p) gana a Tijera (t)");
                System.out.println("Tijera (t) gana a papel (a)");
            } //Si uno de los dos gana la mayoria el bucle se cierra
            if (machine_points == 2 || user_points == 2){
                break;
            }//va imprimiendo los puntos actuales
            System.out.println("Marcador actual (PC - Usuario) " + machine_points + " " + user_points);
        }//Indica el ganador
        if (machine_points == 2){
            System.out.println("¡Fin del juego,.Has perdido contra la IA!");
        }else {
            System.out.println("¡Fin del juego. HAS GANADO!");
        }
    }
    public void ex2(){
        //Aqui vamos a crear las variables que usaremos
        Scanner entry = new Scanner(System.in);
        int birth_year = 0, years = 0, actual_year = 2024;
        boolean value = true;

        try {//Este try sirve para que cuando el usuario ingrese texto, no se rompa
            System.out.println("Introduce el año en el que naciste");
            birth_year = entry.nextInt();
        }catch (InputMismatchException error){
            System.out.println(error.getMessage());
            value = false;
        }

        if (value){//Este if comprueba si la edad ingresada es menor de 1900 o mayor que la actual
            if (birth_year < 1900 || birth_year > actual_year){
                System.out.println("Has introducido una fecha no válida / formato incorrecto");
                value = false;
            }
        }
        if (value){//Si todo va como se espera este for imprime cada año desde el que nacio el usuario hasta
            //el actual con su respectiva edad
            for(int i = birth_year;i <= actual_year;i++){
                System.out.println(i + "--edad:" + years);
                years++;
            }
        }
    }
}
