import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.sql.*;

import java.util.*;

public class FinalProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String confirmarEnvio;

        // Datos de conexión a la base de datos
        String DBurl = "jdbc:mysql://localhost:3306/geemarie";
        String DBusuario = "root";
        String DBpass = "mysql";

        // Consulta SQL para seleccionar datos
        String sql = "SELECT * FROM mockdata2";

        // Ejecutar la consulta SQL (Donde solo encuentro APTO y VERDADERO)
        String queryEnviarCorreo = "SELECT ID, Nombre, Apellido, Correo, Estado_Postulacion, Pendiente_Correo FROM mockdata2 " + "WHERE Estado_Postulacion = 'Apto' AND Pendiente_Correo = 'VERDADERO'";

        // menu
        menu(sc,DBpass,DBurl,DBusuario,queryEnviarCorreo);

    }

    private static void menu(Scanner sc,String DBpass,String DBurl, String DBusuario,String queryEnviarCorreo) {
        String opcion;
        System.out.println("Escoja una de las siguientes opciones para continuar:\n" +
                "1 agregar un nuevo candidato\n" +
                "2 buscar un candidato existente por DNI\n" +
                "3 filtrar candidatos por puesto\n" +
                "4 enviar correos a los candidatos aptos");
        System.out.print("Ingrese el numero elegido (1/2/3/4): ");
        opcion = sc.nextLine();
        if (opcion.equals("1")) {
            nuevoCandidato(sc,DBpass,DBurl,DBusuario);
        } else if (opcion.equals("2")) {
            buscarPorDocumento(sc,DBpass,DBusuario,DBurl);
        } else if (opcion.equals("3")) {
                filtarCandidatosPuesto(sc,DBurl,DBusuario,DBpass);
        } else if (opcion.equals("4")) {
                enviarCorreos(DBurl,DBusuario,DBpass,queryEnviarCorreo);
        } else {
            System.out.println("\033[0;31m" + "\nopcion invalida, intente de nuevo\n" + "\033[0m");
            menu(sc,DBpass,DBurl,DBusuario,queryEnviarCorreo);
        }
    }

    private static void buscarPorDocumento(Scanner sc, String DBpass, String DBusuario, String DBurl) {
        String documento;
        System.out.print("Ingrese el numero de documento para buscar: ");
        documento = sc.nextLine();
        String queryCandidatoPorDocumento = "SELECT Nombre, Apellido, Correo, Estado_Postulacion FROM mockdata2 " + "WHERE Numero_Documento =  ? ";

        // Establecer la conexión a la base de datos y preparar la consulta
        try (Connection conn = DriverManager.getConnection(DBurl, DBusuario, DBpass);
             PreparedStatement pstmt = conn.prepareStatement(queryCandidatoPorDocumento)) {

            // Configurar el parámetro en la consulta preparada
            pstmt.setString(1, documento);

            // Ejecutar la consulta
            ResultSet rs = pstmt.executeQuery();

            // Verificar si se encontraron resultados y mostrarlos
            if (rs.next()) {
                // Obtener los datos del candidato
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String correo = rs.getString("Correo");
                String estadoPostulacion = rs.getString("Estado_Postulacion");

                // Mostrar los datos del candidato
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Correo: " + correo);
                System.out.println("Estado de Postulación: " + estadoPostulacion);
            } else {
                // Si no se encontraron resultados, mostrar un mensaje
                System.out.println("No se encontró ningún candidato con el número de documento proporcionado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    private static void filtarCandidatosPuesto(Scanner sc, String DBurl, String DBusuario, String DBpass) {
        String opcion;
        System.out.println("Escoja uno de los siguientes puestos para mostrar:\n" +
                "1 Desarrollador Frontend \n" +
                "2 Desarrollador Backend \n" +
                "3 Diseñador ux/ui\n" +
                "4 Social media manager");
        System.out.print("Ingrese el numero elegido (1/2/3/4): ");
        opcion = sc.nextLine();
        String puesto = "";
        if (opcion.equals("1")) {
             puesto = "Frontend developer";
        } else if (opcion.equals("2")) {
            puesto = "Backend developer";
        } else if (opcion.equals("3")) {
            puesto = "Diseñador ux/ui";
        } else if (opcion.equals("4")) {
            puesto = "Social media manager";
        } else {
            System.out.println("\033[0;31m" + "\nopcion invalida, intente de nuevo\n" + "\033[0m");
            filtarCandidatosPuesto(sc, DBurl, DBusuario, DBpass);
            return;
        }

        // Realizar la consulta con el puesto seleccionado
        String query = "SELECT ID, Nombre, Apellido, Correo, Puesto, Estado_Postulacion, Pendiente_Correo FROM mockdata2 WHERE Puesto = ?";
        try (Connection conn = DriverManager.getConnection(DBurl, DBusuario, DBpass);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, puesto);
            ResultSet rs = pstmt.executeQuery();

            // Mostrar los resultados
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                String correo = rs.getString("Correo");
                System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void nuevoCandidato(Scanner sc, String DBpass, String DBurl, String DBusuario) {
        String nombres;
        String apellidos;
        String correo;

        // estos dos campos se llenan automaticamente de esta manera
        String estadoPostulacion = "Apto";
        String pendienteCorreo = "VERDADERO";

        System.out.print("Ingrese los datos del nuevo candidato\nNombre: ");
        nombres = sc.nextLine();
        System.out.print("Apellido: ");
        apellidos = sc.nextLine();
        System.out.print("Correo: ");
        correo = sc.nextLine();

        System.out.println(nombres + apellidos + correo);

        String sql = "INSERT INTO mockdata2 (Nombre, Apellido, Correo, Estado_Postulacion, Pendiente_Correo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DBurl, DBusuario, DBpass);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Configurar los valores en la consulta preparada
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, correo);
            pstmt.setString(4, estadoPostulacion);
            pstmt.setString(5, pendienteCorreo);

            // Ejecutar la consulta
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Filas afectadas: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void enviarCorreos(String DBurl,String DBusuario,String DBpass,String queryEnviarCorreo){
        // Lista para almacenar los correos y los IDs
        List<String> correos = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();


        try {
            // Establecer conexión a la base de datos
            Connection conn = DriverManager.getConnection(DBurl, DBusuario, DBpass);

            // Preparar la consulta
            Statement st = conn.createStatement();

            // Ejecutar la consulta SQL
            ResultSet resultado = st.executeQuery(queryEnviarCorreo);



            // Recorrer los resultados y almacenar correos e IDs en las listas
            while (resultado.next()) {
                String nombre = resultado.getString("Nombre");
                String apellido = resultado.getString("Apellido");
                String correo = resultado.getString("Correo");
                int id = resultado.getInt("ID");

                System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo);
                correos.add(correo);
                ids.add(id);

            }

            // Imprimir los correos obtenidos
            System.out.println("Correos obtenidos:");
            for (String correo : correos) {
                System.out.println(correo);
            }


            // Configuración del servidor SMTP y credentials

            String MAILhost = "smtp.gmail.com"; // Cambia esto al servidor SMTP que corresponda
            String MAILuser = "mariesdev@gmail.com"; // Cambia esto al correo de RRHH.
            String MAILpass = "cvtr sxvf ufnv nyye"; // Cambia esto a tu contraseña // ENV BUSCAR!

            Properties props = new Properties();

            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", MAILhost);
            props.put("mail.smtp.port", "587");

            // Creación de la sesión
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(MAILuser, MAILpass);
                }
            });


            // Envío de correos a los destinatarios obtenidos
            for (int i = 0; i < correos.size(); i++) {
                String destinatario = correos.get(i);
                int id = ids.get(i);

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(MAILuser));
                    message.setSubject("¡Felicidades pasaste a la siguiente etapa!");

                    // Configurar destinatarios del mensaje
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));

                    // Contenido del mensaje
                    message.setText("Estamos interesados en tu talento por lo que hemos separado un espacio especial en nuestra agenda para conocerte un poco más. En el transcurso del día te contactaremos para coordinar el día y hora de tu siguiente entrevista.\n" +
                            "\n" +
                            "Recomendaciones adicionales:\n" +
                            "•\tMantener video y audio encendido durante la reunión.\n" +
                            "•\tElegir un ambiente iluminado y sin distracciones.\n" +
                            "•\tImportante asistir presentable para ser el candidato favorito del entrevistador.\n" +
                            "•\tSi tienes algún inconveniente, avísame previamente para reprogramarte.\n" +
                            "•\tResponder el presente correo confirmando su asistencia.  \n" +
                            "\n" +
                            "¡Muchos éxitos!  \n" +
                            "\n" +
                            "HHunters\n");

                    // Enviar mensaje
                    Transport.send(message);
                    System.out.println("Correo enviado con éxito!");


                    // Actualizar el campo pendiente_Correo a FALSO
                    // Definir la consulta SQL de actualización, donde se establece el campo pendiente_Correo a 'FALSO' para un registro específico identificado por su id
                    String updateSQL = "UPDATE mockdata2 SET Pendiente_Correo = 'FALSO' WHERE ID = ?";
                    // Preparar la consulta de actualización utilizando un PreparedStatement para ejecutar la consulta SQL
                    PreparedStatement updateStmt = conn.prepareStatement(updateSQL);
                    // Asignar el valor del id en el lugar del parámetro (el signo ?) de la consulta SQL
                    updateStmt.setInt(1, id);
                    // Ejecutar la consulta de actualización en la base de datos
                    updateStmt.executeUpdate();
                    // Cerrar el PreparedStatement para liberar los recursos
                    updateStmt.close();

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
            // Cerrar la conexión
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
