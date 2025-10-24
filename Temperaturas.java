package tema2_debug;

import java.util.Scanner;

/**
 * Programa con errores para practicar la depuración.
 * El programa pide una temperatura y muestra si hace frío, calor o temperatura templada.
 * Después, repite mientras el usuario quiera continuar.
 */
public class Temperaturas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mostrarMensajeBienvenida();//JCL20252410: No estaba el ;

        boolean continuar = true;

        while (continuar == true){//JCL20252410: tenía un false, que hacia que nunca se pudiera ejecutar
            double temperatura = pedirTemperatura(sc);//JCL20252410: No estaba el ;
            mostrarResultado(temperatura);//JCL20252410: No estaba el ;

            System.out.print("¿Desea introducir otra temperatura? (s/n): ");
            String respuesta = sc.next();

            if (respuesta == "n" || respuesta == "N");{
                continuar = false;
        	}

         }

        sc.close();//JCL20252410: No estaba el ;
        System.out.println("Programa finalizado.");//JCL20252410: no estaba el ;
    }

    public static void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido al analizador de temperaturas.");//JCL20252410: No estaba el ;
        System.out.println("Este programa indica si hace frío, calor o está templado.");//JCL20252410: No estaba el ;
    }

    public static double pedirTemperatura(Scanner sc) {
        double t;
        do {
            System.out.print("Introduce la temperatura en grados: ");
            t = sc.nextDouble();
            if (t < -10 || t > 50) {//JCL20252410:no podia ser un número mayor que 50 y menor que -10 a la vez
                System.out.println("Temperatura fuera del rango permitido (-10 a 50).");//JCL20252410: No estaba el ;
            } 
        } while (t < -10 || t > 50);//JCL20252410:no podia ser un número mayor que 50 y menor que -10 a la vez
        return t;
    }

    public static void mostrarResultado(double temperatura) {
        if (temperatura < 15)
            System.out.println("Hace frío.");
        else if (temperatura >= 15 && temperatura < 30)
            System.out.println("Temperatura templada.");//JCL20252410: No estaba el ;
        else if (temperatura >= 30)
            System.out.println("¡Hace mucho calor!");//JCL20252410: No estaba el ;
        else
            System.out.println("Valor no reconocido.");//JCL20252410: No estaba el ;
    }
}