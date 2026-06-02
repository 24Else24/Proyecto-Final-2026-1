import java.util.Scanner;

public class Validaciones {
    public boolean leerBooleano(Scanner sc) {
        if (sc.hasNextInt()) {
            int valor = sc.nextInt();
            if (valor == 0 || valor == 1) {
                return valor == 1; // Caso base válido
            }
        } else {
            sc.next(); // Descarta la entrada inválida de texto
        }
        System.out.println("Valor invalido, ingrese solo 1 o 0.");
        return leerBooleano(sc); // Llamada recursiva
    }

    public String leerNombre(Scanner sc) {
        String nombre = sc.nextLine().trim();

        if (nombre.isEmpty()) {
            System.out.println("Error: el campo no puede estar vacio.");
            return leerNombre(sc); // Llamada recursiva
        }
        if (nombre.length() < 2 || nombre.length() > 50) {
            System.out.println("Error: debe tener entre 2 y 50 caracteres.");
            return leerNombre(sc); // Llamada recursiva
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ ]+")) {
            System.out.println("Error: use solo letras.");
            return leerNombre(sc); // Llamada recursiva
        }

        return nombre; // Caso base válido
    }

    public String leerCedula(Scanner sc) {
        String cedula = sc.nextLine().trim();

        if (cedula.isEmpty()) {
            System.out.println("Error: la cedula no puede estar vacia.");
            return leerCedula(sc);
        }
        if (!cedula.matches("[0-9]+")) {
            System.out.println("Error: la cedula debe contener solo numeros.");
            return leerCedula(sc);
        }
        if (cedula.length() < 6 || cedula.length() > 12) {
            System.out.println("Error: longitud de cedula invalida (6-12 digitos).");
            return leerCedula(sc);
        }

        return cedula;
    }

    public String leerTelefono(Scanner sc) {
        String telefono = "";
        boolean valido = false;

        while (!valido) {
            System.out.println("Ingrese el telefono: ");
            telefono = sc.nextLine().trim();

            if (telefono.isEmpty()) {
                System.out.println("Error: el telefono no puede estar vacio.");
            } else if (!telefono.matches("[0-9]+")) {
                System.out.println("Error: el telefono solo puede contener numeros.");
            } else if (telefono.length() != 10) {
                System.out.println("Error: el telefono debe tener exactamente 10 digitos.");
            } else if (!telefono.startsWith("3") && !telefono.startsWith("60")
                    && !telefono.startsWith("61") && !telefono.startsWith("62")
                    && !telefono.startsWith("63") && !telefono.startsWith("64")) {
                System.out.println("Error: el telefono debe iniciar con 3 (celular) o 6X (fijo).");
            } else if (telefono.matches("(\\d)\\1{9}")) {
                System.out.println("Error: el telefono no puede ser un numero repetido.");
            } else {
                valido = true;
            }
        }

        return telefono;
    }

    public String leerDireccion(Scanner sc) {
        String direccion = "";
        boolean valido = false;

        while (!valido) {
            System.out.println("Ingrese la direccion (Ej: Calle 10 # 20-30): ");
            direccion = sc.nextLine().trim();

            if (direccion.isEmpty()) {
                System.out.println("Error: la direccion no puede estar vacia.");
            } else if (direccion.length() < 5) {
                System.out.println("Error: la direccion debe tener al menos 5 caracteres.");
            } else if (direccion.length() > 100) {
                System.out.println("Error: la direccion no puede superar los 100 caracteres.");
            } else if (!direccion.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9\\s#\\-\\.]+")) {
                System.out.println("Error: la direccion solo puede contener letras, numeros, #, - y puntos.");
            } else if (direccion.matches(".*\\s{2,}.*")) {
                System.out.println("Error: la direccion no puede tener espacios dobles.");
            } else if (!direccion.matches(".*[0-9].*")) {
                System.out.println("Error: la direccion debe contener al menos un numero.");
            } else {
                valido = true;
            }
        }

        return direccion;
    }

    public String leerLicencia(Scanner sc) {
        String licencia = "";
        boolean valido = false;

        while (!valido) {
            System.out.println("Ingrese la licencia de conduccion (Ej: 12345678): ");
            licencia = sc.nextLine().trim().toUpperCase();

            if (licencia.isEmpty()) {
                System.out.println("Error: la licencia no puede estar vacia.");
            } else if (!licencia.matches("[0-9]{8,10}")) {
                System.out.println("Error: la licencia debe contener entre 8 y 10 digitos numericos.");
            } else if (licencia.matches("0+")) {
                System.out.println("Error: la licencia no puede ser todos ceros.");
            } else if (licencia.charAt(0) == '0') {
                System.out.println("Error: la licencia no puede empezar con cero.");
            } else if (licencia.matches("(\\d)\\1+")) {
                System.out.println("Error: la licencia no puede ser un numero repetido.");
            } else {
                valido = true;
            }
        }

        return licencia;
    }

    public String leerPlaca(Scanner sc) {
        String placa = sc.nextLine().trim().toUpperCase();

        if (placa.isEmpty()) {
            System.out.println("Error: la placa no puede estar vacia.");
            return leerPlaca(sc);
        }
        // Valida formato estándar de placas (letras y números sin caracteres raros)
        if (!placa.matches("[A-Z0-9]+")) {
            System.out.println("Error: la placa solo puede contener letras y numeros.");
            return leerPlaca(sc);
        }

        return placa;
    }

    public int leerAnio(Scanner sc) {
        int anio = 0;
        boolean valido = false;
        int anioActual = 2026;

        while (!valido) {
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: el año no puede estar vacio.");
            } else if (!entrada.matches("[0-9]{4}")) {
                System.out.println("Error: el año debe contener exactamente 4 digitos.");
            } else {
                anio = Integer.parseInt(entrada);
                if (anio < 1886) {
                    System.out.println("Error: el año no puede ser menor a 1886 (primer auto de la historia).");
                } else if (anio > anioActual) {
                    System.out.println("Error: el año no puede ser mayor a " + anioActual + ".");
                } else {
                    valido = true;
                }
            }
        }

        return anio;
    }

    public int leerOpcionMenu(Scanner sc) {
    try {
        if (sc.hasNextInt()) {
            int opcion = sc.nextInt();
            sc.nextLine();
            return opcion;
        } else {
            System.out.println("Error: Debe ingresar un numero entero.");
            sc.next();
            return leerOpcionMenu(sc);
        }
    } catch (Exception e) {
        System.out.println("Error en la entrada. Intente nuevamente.");
        return leerOpcionMenu(sc);
    }
}

    public String leerTraccion(Scanner sc) {
        String traccion = "";
        boolean valido = false;

        while (!valido) {
            System.out.println("Ingrese la traccion (1. 4x2  /  2. 4x4): ");
            String entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1":
                    traccion = "4x2";
                    valido = true;
                    break;
                case "2":
                    traccion = "4x4";
                    valido = true;
                    break;
                case "4x2":
                    traccion = "4x2";
                    valido = true;
                    break;
                case "4x4":
                    traccion = "4x4";
                    valido = true;
                    break;
                default:
                    System.out.println("Error: ingrese 1 (4x2) o 2 (4x4).");
            }
        }

        return traccion;
    }

    public String leerCombustible(Scanner sc) {
        String combustible = "";
        boolean valido = false;

        while (!valido) {
            String entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1":
                case "gasolina":
                    combustible = "gasolina";
                    valido = true;
                    break;
                case "2":
                case "diesel":
                    combustible = "diesel";
                    valido = true;
                    break;
                case "3":
                case "electrico":
                    combustible = "electrico";
                    valido = true;
                    break;
                default:
                    System.out.println("Error: ingrese 1 (gasolina), 2 (diesel) o 3 (electrico).");
            }
        }

        return combustible;
    }

    public String leerTransmision(Scanner sc) {
        String transmision = "";
        boolean valido = false;

        while (!valido) {
            String entrada = sc.nextLine().trim();

            switch (entrada) {
                case "1":
                case "automatica":
                    transmision = "automatica";
                    valido = true;
                    break;
                case "2":
                case "manual":
                    transmision = "manual";
                    valido = true;
                    break;
                default:
                    System.out.println("Error: ingrese 1 (automatica) o 2 (manual).");
            }
        }

        return transmision;
    }

    public int leerEnteroPositivo(Scanner sc) {
        int numero = 0;
        boolean valido = false;

        while (!valido) {
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            } else if (!entrada.matches("[0-9]+")) {
                System.out.println("Error: solo se permiten numeros enteros positivos.");
            } else {
                numero = Integer.parseInt(entrada);
                if (numero <= 0) {
                    System.out.println("Error: el numero debe ser mayor a 0.");
                } else {
                    valido = true;
                }
            }
        }

        return numero;
    }

    public float leerFloatPositivo(Scanner sc) {
        float numero = 0;
        boolean valido = false;

        while (!valido) {
            String entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            } else if (!entrada.matches("[0-9]+(\\.[0-9]+)?")) {
                System.out.println("Error: solo se permiten numeros positivos (Ej: 10 o 10.5).");
            } else {
                numero = Float.parseFloat(entrada);
                if (numero <= 0) {
                    System.out.println("Error: el numero debe ser mayor a 0.");
                } else {
                    valido = true;
                }
            }
        }

        return numero;
    }

    public String leerFecha(Scanner sc) {
        String fecha = "";
        boolean valido = false;

        while (!valido) {
            fecha = sc.nextLine().trim();

            if (fecha.isEmpty()) {
                System.out.println("Error: la fecha no puede estar vacia.");
            } else if (!fecha.matches("\\d{2}/\\d{2}/\\d{4}")) {
                System.out.println("Error: formato invalido. Use DD/MM/AAAA (Ej: 25/01/2024).");
            } else {
                String[] partes = fecha.split("/");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int anio = Integer.parseInt(partes[2]);

                if (mes < 1 || mes > 12) {
                    System.out.println("Error: el mes debe estar entre 01 y 12.");
                } else if (dia < 1 || dia > diasDelMes(dia, mes, anio)) {
                    System.out.println("Error: el dia no es valido para el mes ingresado.");
                } else if (anio < 1900 || anio > 2026) {
                    System.out.println("Error: el año debe estar entre 1900 y 2026.");
                } else {
                    valido = true;
                }
            }
        }

        return fecha;
    }

    private int diasDelMes(int dia, int mes, int anio) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                boolean bisiesto = (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
                return bisiesto ? 29 : 28;
            default:
                return 0;
        }
    }

    public int calcularDias(String fechaInicio, String fechaFin) {
        String[] partesInicio = fechaInicio.split("/");
        String[] partesFin = fechaFin.split("/");

        int diaI = Integer.parseInt(partesInicio[0]);
        int mesI = Integer.parseInt(partesInicio[1]);
        int anioI = Integer.parseInt(partesInicio[2]);

        int diaF = Integer.parseInt(partesFin[0]);
        int mesF = Integer.parseInt(partesFin[1]);
        int anioF = Integer.parseInt(partesFin[2]);

        // Convertir ambas fechas a dias totales desde el año 0
        long totalInicio = fechaADias(diaI, mesI, anioI);
        long totalFin = fechaADias(diaF, mesF, anioF);

        int diferencia = (int) (totalFin - totalInicio);

        if (diferencia < 0) {
            System.out.println("Error: la fecha de fin no puede ser menor a la fecha de inicio.");
            return -1;
        } else if (diferencia == 0) {
            System.out.println("Error: las fechas no pueden ser iguales.");
            return -1;
        }

        return diferencia;
    }

    private long fechaADias(int dia, int mes, int anio) {
        // Algoritmo de conversion de fecha a numero de dias
        if (mes < 3) {
            mes += 12;
            anio -= 1;
        }
        long s = anio / 100;
        long a = 2 - s + (s / 4);
        return (long) (365.25 * (anio + 4716))
                + (long) (30.6001 * (mes + 1))
                + dia + a - 1524;
    }
}
