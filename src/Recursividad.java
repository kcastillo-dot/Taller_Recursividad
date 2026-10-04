import java.util.Scanner;

public class Recursividad {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n === TALLER DE RECURSIVIDAD ===");
            System.out.println(" 1. Factorial");
            System.out.println(" 2. Invertir numero");
            System.out.println(" 3. Sumatoria 1 + 1/2 + ... + 1/n");
            System.out.println(" 4. Suma de digitos");
            System.out.println(" 5. Sumatoria hasta n");
            System.out.println(" 6. Potencia");
            System.out.println(" 7. MCD (Euclides)");
            System.out.println(" 8. Copiar cadena");
            System.out.println(" 9. Cociente (restas sucesivas)");
            System.out.println("10. Multiplicación (sumas sucesivas)");
            System.out.println("11. Suma de un arreglo");
            System.out.println("12. Suma de una matriz"); 
            System.out.println("13. Serie de Fibonacci");
            System.out.println("14. Función de Ackermann");
            System.out.println(" 0. Salir");

            try {   
                opcion = leerEntero(sc, "\nIngresa una opción: ");
                switch (opcion) {
                    case 0:  System.out.println("Hasta luego."); break;
                    case 1:  ejercicio1(sc); break;
                    case 2:  ejercicio2(sc); break;
                    case 3:  ejercicio3(sc); break;
                    case 4:  ejercicio4(sc); break;
                    case 5:  ejercicio5(sc); break;
                    case 6:  ejercicio6(sc); break;
                    case 7:  ejercicio7(sc); break;
                    case 8:  ejercicio8(sc); break;
                    case 9:  ejercicio9(sc); break;
                    case 10: ejercicio10(sc); break;
                    case 11: ejercicio11(sc); break;
                    case 12: ejercicio12(sc); break;
                    case 13: ejercicio13(sc); break;
                    case 14: ejercicio14(sc); break;
                    default: System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                opcion = -1;
            } catch (StackOverflowError e) {
                System.out.println("Error: Recursión demasiado profunda para esa entrada.");
            }
        }
        sc.close();
    }

    public static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(sc.nextLine());
    }

    public static void ejercicio1(Scanner sc) {
        int n = leerEntero(sc, "Ingrese un número entero: ");
        System.out.println("El factorial de " + n + " es: " + factorial(n));
    }
    public static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void ejercicio2(Scanner sc) {
        int n = leerEntero(sc, "Ingrese el número a invertir: ");
        System.out.println("Número invertido: " + invertirNumero(n, 0));
    }
    public static int invertirNumero(int n, int invertido) {
        if (n == 0) return invertido;
        return invertirNumero(n / 10, invertido * 10 + (n % 10));
    }

    public static void ejercicio3(Scanner sc) {
        int n = leerEntero(sc, "Ingrese el valor de n: ");
        System.out.println("La sumatoria de fracciones es: " + sumaFracciones(n));
    }
    public static double sumaFracciones(int n) {
        if (n == 1) return 1.0;
        return (1.0 / n) + sumaFracciones(n - 1);
    }

    public static void ejercicio4(Scanner sc) {
        int n = leerEntero(sc, "Ingrese un número: ");
        System.out.println("La suma de los dígitos es: " + sumaDigitos(Math.abs(n)));
    }
    public static int sumaDigitos(int n) {
        if (n == 0) return 0;
        return (n % 10) + sumaDigitos(n / 10);
    }

    public static void ejercicio5(Scanner sc) {
        int n = leerEntero(sc, "Ingrese un número límite: ");
        System.out.println("La sumatoria hasta " + n + " es: " + sumatoriaN(n));
    }
    public static int sumatoriaN(int n) {
        if (n <= 0) return 0;
        return n + sumatoriaN(n - 1);
    }

    public static void ejercicio6(Scanner sc) {
        int base = leerEntero(sc, "Ingrese la base: ");
        int exp = leerEntero(sc, "Ingrese el exponente: ");
        System.out.println(base + "^" + exp + " = " + potencia(base, exp));
    }
    public static int potencia(int base, int exp) {
        if (exp == 0) return 1;
        return base * potencia(base, exp - 1);
    }

    public static void ejercicio7(Scanner sc) {
        int m = leerEntero(sc, "Ingrese el número M: ");
        int n = leerEntero(sc, "Ingrese el número N: ");
        System.out.println("El MCD es: " + mcd(m, n));
    }
    public static int mcd(int m, int n) {
        if (n == 0) return m;
        return mcd(n, m % n);
    }

    public static void ejercicio8(Scanner sc) {
        System.out.print("Ingrese la cadena original: ");
        String original = sc.nextLine();
        String copia = copiarCadena(original, 0);
        System.out.println("Cadena copiada recursivamente: " + copia);
    }
    public static String copiarCadena(String str, int indice) {
        if (indice == str.length()) return ""; 
        return str.charAt(indice) + copiarCadena(str, indice + 1);
    }

    public static void ejercicio9(Scanner sc) {
        int a = leerEntero(sc, "Ingrese el dividendo: ");
        int b = leerEntero(sc, "Ingrese el divisor: ");
        if (b == 0) {
            System.out.println("No se puede dividir por cero.");
        } else {
            System.out.println("El cociente es: " + divisionRestas(a, b));
        }
    }
    public static int divisionRestas(int a, int b) {
        if (a < b) return 0;
        return 1 + divisionRestas(a - b, b);
    }

    public static void ejercicio10(Scanner sc) {
        int a = leerEntero(sc, "Ingrese el primer número: ");
        int b = leerEntero(sc, "Ingrese el segundo número: ");
        System.out.println("El producto es: " + multiplicacionSumas(a, b));
    }
    public static int multiplicacionSumas(int a, int b) {
        if (b == 0) return 0;
        return a + multiplicacionSumas(a, b - 1);
    }

    public static void ejercicio11(Scanner sc) {
        int n = leerEntero(sc, "Ingrese la cantidad de elementos del arreglo: ");
        int[] arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            arreglo[i] = leerEntero(sc, "Elemento [" + i + "]: ");
        }
        System.out.println("La suma del arreglo es: " + sumaArreglo(arreglo, n));
    }
    public static int sumaArreglo(int[] arr, int n) {
        if (n <= 0) return 0;
        return arr[n - 1] + sumaArreglo(arr, n - 1);
    }

    public static void ejercicio12(Scanner sc) {
        int m = leerEntero(sc, "Filas (m): ");
        int n = leerEntero(sc, "Columnas (n): ");
        int[][] matriz = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = leerEntero(sc, "Elemento [" + i + "][" + j + "]: ");
            }
        }
        System.out.println("La suma de la matriz es: " + sumaMatriz(matriz, 0, 0, m, n));
    }
    public static int sumaMatriz(int[][] mat, int i, int j, int m, int n) {
        if (i == m) return 0; 
        if (j == n) return sumaMatriz(mat, i + 1, 0, m, n); 
        return mat[i][j] + sumaMatriz(mat, i, j + 1, m, n);
    }

    public static void ejercicio13(Scanner sc) {
        int limite = leerEntero(sc, "Ingrese hasta qué término desea ver la serie: ");
        System.out.print("Serie de Fibonacci: ");
        imprimirFibonacciRecursivo(0, limite);
        System.out.println();
    }
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void imprimirFibonacciRecursivo(int actual, int limite) {
        if (actual <= limite) {
            System.out.print(fibonacci(actual) + " ");
            imprimirFibonacciRecursivo(actual + 1, limite);
        }
    }

    public static void ejercicio14(Scanner sc) {
        int m = leerEntero(sc, "Ingrese el valor de m: ");
        int n = leerEntero(sc, "Ingrese el valor de n: ");
        System.out.println("Ackermann(" + m + ", " + n + ") = " + ackermann(m, n));
    }
    public static int ackermann(int m, int n) {
        if (m == 0) return n + 1;
        if (m > 0 && n == 0) return ackermann(m - 1, 1);
        return ackermann(m - 1, ackermann(m, n - 1));
    }
}