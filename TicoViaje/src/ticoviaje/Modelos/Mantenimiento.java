package ticoviaje.Modelos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import ticoviaje.Bases_Datos.Conexion;
import ticoviaje.Objetos.Chofer;
import ticoviaje.Vista.TicoViajesVista;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mantenimiento extends Observable {

    private ConjuntoViajes viajes;
    private ArrayList<Chofer> choferes;
    private Flotilla flotilla;
    private Conexion conexion;

    public Mantenimiento(ConjuntoViajes viajes, ArrayList<Chofer> choferes, Flotilla flotilla) {
        this.viajes = viajes;
        this.choferes = choferes;
        this.flotilla = flotilla;
        conexion = new Conexion();
    }

    public void agregar_viaje() {
        if (choferes.size() > 0) {
            String locaciones[] = {"Alajuela", "San Jose", "Cartago", "Heredia", "Puntarenas", "Guanacaste", "Limon"};
            String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
            ArrayList<String> horas = new ArrayList();
            for (int i = 0; i <= 12; i++) {
                String hora = "";
                if (i < 10) {
                    hora = "0";
                }
                hora = hora + i;
                horas.add(hora);
            }
            ArrayList<String> buses = new ArrayList();
            for (int i = 0; i < 20; i++) {
                buses.add(i + 1 + "");
            }
            String minutos[] = {"00", "15", "30", "45"};
            String tiempo[] = {"am", "md", "pm", "mn"};
            ArrayList<String> nombres_choferes = new ArrayList();
            for (Chofer chofer : choferes) {
                nombres_choferes.add(chofer.getNombre());
            }
            String locacion1 = (String) JOptionPane.showInputDialog(null, "Digite la locacion de inicio para la ruta:", "LOCACION INICIO", JOptionPane.QUESTION_MESSAGE, null, locaciones, locaciones[0]);
            if (locacion1 != null) {
                String locacion2 = (String) JOptionPane.showInputDialog(null, "Digite la locacion de finalizacion para la ruta:", "LOCACION FINAL", JOptionPane.QUESTION_MESSAGE, null, locaciones, locaciones[0]);
                if (locacion2 != null && !locacion1.equals(locacion2)) {
                    String ruta = locacion1 + " - " + locacion2;
                    String dia = (String) JOptionPane.showInputDialog(null, "Digite el dia que se realizara el viaje: ", "DIAS", JOptionPane.QUESTION_MESSAGE, null, dias, dias[0]);
                    if (dia != null) {
                        String hora_inicio = (String) JOptionPane.showInputDialog(null, "Digite la hora de inicio del viaje: ", "HORA INICIO", JOptionPane.QUESTION_MESSAGE, null, horas.toArray(), horas.get(0));
                        if (hora_inicio != null) {
                            String minutos_inicio = (String) JOptionPane.showInputDialog(null, "Digite los minutos de inicio del viaje: ", "MINUTOS INICIO", JOptionPane.QUESTION_MESSAGE, null, minutos, minutos[0]);
                            if (minutos_inicio != null) {
                                String tiempo_inicio = (String) JOptionPane.showInputDialog(null, "Digite el tiempo de la hora de inicio del viaje: ", "TIEMPO INICIO", JOptionPane.QUESTION_MESSAGE, null, tiempo, tiempo[0]);
                                if (tiempo_inicio != null) {
                                    String hora_final = (String) JOptionPane.showInputDialog(null, "Digite la hora de finalizacion del viaje: ", "HORA FINAL", JOptionPane.QUESTION_MESSAGE, null, horas.toArray(), horas.get(0));
                                    if (hora_final != null) {
                                        String minutos_final = (String) JOptionPane.showInputDialog(null, "Digite los minutos de finalizacion del viaje: ", "MINUTOS FINAL", JOptionPane.QUESTION_MESSAGE, null, minutos, minutos[0]);
                                        if (minutos_final != null) {
                                            String tiempo_final = (String) JOptionPane.showInputDialog(null, "Digite el tiempo de la hora de final del viaje: ", "TIEMPO FINAL", JOptionPane.QUESTION_MESSAGE, null, tiempo, tiempo[0]);
                                            if (tiempo_final != null) {
                                                String horario = hora_inicio + ":" + minutos_inicio + tiempo_inicio + " - " + hora_final + ":" + minutos_final + tiempo_final;
                                                if (el_viaje_existe(ruta, dia, horario) == false) {
                                                    String kilometros = (String) JOptionPane.showInputDialog(null, "Digite la cantidad de Kilometros del Viaje:");
                                                    if (kilometros != null && !kilometros.equals("") && kilometros.matches("[-+]?\\d*\\.?\\d+") == true) {
                                                        int numero_kilometros = Integer.parseInt(kilometros);
                                                        String costo = (String) JOptionPane.showInputDialog(null, "Digite el costo del Viaje:");
                                                        if (costo != null && !costo.equals("") && costo.matches("[-+]?\\d*\\.?\\d+") == true) {
                                                            int numero_costo = Integer.parseInt(costo);
                                                            String bus = (String) JOptionPane.showInputDialog(null, "Digite el numero del bus del viaje: ", "BUS", JOptionPane.QUESTION_MESSAGE, null, buses.toArray(), buses.get(0));
                                                            if (bus != null && !bus.equals("") && bus.matches("[-+]?\\d*\\.?\\d+") == true) {
                                                                int numero_bus = Integer.parseInt(bus);
                                                                Bus bus_seleccionado = flotilla.getEspecifico(numero_bus - 1);
                                                                String chofer = (String) JOptionPane.showInputDialog(null, "Digite el chofer que conducira el bus: ", "CHOFERES", JOptionPane.QUESTION_MESSAGE, null, nombres_choferes.toArray(), nombres_choferes.get(0));
                                                                if (chofer != null) {
                                                                    bus_seleccionado.setChofer(obtenerChofer(chofer));
                                                                    Viaje nuevo_viaje = new Viaje();
                                                                    nuevo_viaje.setRuta(ruta);
                                                                    nuevo_viaje.setFecha(dia);
                                                                    nuevo_viaje.setHorario(horario);
                                                                    nuevo_viaje.setKilometros(numero_kilometros);
                                                                    nuevo_viaje.setCosto(numero_costo);
                                                                    nuevo_viaje.setUnidad(bus_seleccionado);
                                                                    viajes.add(nuevo_viaje);
                                                                    try {
                                                                        PreparedStatement statement = conexion.getConexion().prepareStatement("INSERT INTO viajes (ruta, fecha, horario, kilometros, costo, idbuses) VALUES (?,?,?,?,?,?);");
                                                                        statement.setString(1, ruta);
                                                                        statement.setString(2, dia);
                                                                        statement.setString(3, horario);
                                                                        statement.setInt(4, numero_kilometros);
                                                                        statement.setInt(5, numero_costo);
                                                                        statement.setInt(6, numero_bus);
                                                                        if (statement.executeUpdate() != 1) {
                                                                            throw new SQLException();
                                                                        }
                                                                        PreparedStatement statement2 = conexion.getConexion().prepareStatement("UPDATE buses SET idchofer =? WHERE idbuses =?");
                                                                        statement2.setInt(1, obtenerLlaveChofer(bus_seleccionado.getChofer().getLicencia()));
                                                                        statement2.setInt(2, numero_bus);
                                                                        if (statement2.executeUpdate() != 1) {
                                                                            throw new SQLException();
                                                                        }
                                                                        setChanged();
                                                                        notifyObservers("El Viaje se ha agregado con Exito");
                                                                        String informacion = informacion_viaje(nuevo_viaje);
                                                                        setChanged();
                                                                        notifyObservers(informacion);
                                                                    } catch (SQLException e) {
                                                                        System.err.println(e);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    setChanged();
                                                    notifyObservers("No se puede agregar el viaje, el viaje ya existe");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            setChanged();
            notifyObservers("No se puede ingresar un viaje, no hay choferes registrados");
        }
    }

    public boolean el_viaje_existe(String ruta, String dia, String horario) {
        for (Viaje viaje : viajes.getViajes()) {
            if (viaje.getRuta().equals(ruta)) {
                if (viaje.getFecha().equals(dia)) {
                    if (viaje.getHorario().equals(horario)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void agregar_chofer() {
        String nombre = (String) JOptionPane.showInputDialog(null, "Digite el nombre del nuevo chofer: ");
        if (nombre != null && !nombre.equals("")) {
            Chofer nuevo_chofer = new Chofer();
            nuevo_chofer.setNombre(nombre);
            choferes.add(nuevo_chofer);
            try {
                Statement statement = conexion.getConexion().createStatement();
                PreparedStatement prepared_statement = conexion.getConexion().prepareStatement("INSERT INTO choferes (nombre, licencia, edad) VALUES (?,?,?);");
                prepared_statement.setString(1, nuevo_chofer.getNombre());
                prepared_statement.setString(2, nuevo_chofer.getLicencia());
                prepared_statement.setInt(3, nuevo_chofer.getEdad());
                if (prepared_statement.executeUpdate() != 1) {
                    throw new SQLException();
                }
                setChanged();
                notifyObservers("Nuevo Chofer Guardado con Exito");

            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    public void regresar() {
        TicoViajesVista vista = new TicoViajesVista();
        vista.iniciar();
        conexion.cerrar();
    }

    public String informacion_viaje(Viaje viaje) {
        String informacion = "Ruta: " + viaje.getRuta() + "\n";
        informacion = informacion + "Fecha: " + viaje.getFecha() + "\n";
        informacion = informacion + "Horario: " + viaje.getHorario() + "\n";
        informacion = informacion + "Kilometros: " + viaje.getKilometros() + "\n";
        informacion = informacion + "Costo: " + viaje.getCosto() + "\n";
        informacion = informacion + "Placa del Bus: " + viaje.getUnidad().getPlaca() + "\n";
        informacion = informacion + "Chofer: " + viaje.getUnidad().getChofer().getNombre() + "\n";
        return informacion;
    }

    public void remover_viaje() {
//        if (viajes.getViajes().size() > 0) {
//            ArrayList<String> listaRuta = viajes.getRutas();
//            String ruta = (String) JOptionPane.showInputDialog(null, "Elija la ruta del viaje que desea eliminar: ", "RUTAS", JOptionPane.QUESTION_MESSAGE, null, listaRuta.toArray(), listaRuta.get(0));
//            if (ruta != null) {
//                ArrayList<String> listaFecha = viajes.getDiasRuta(ruta);
//                String dia = (String) JOptionPane.showInputDialog(null, "Elija el dia del viaje que desea eliminar: ", "DIAS", JOptionPane.QUESTION_MESSAGE, null, listaFecha.toArray(), listaFecha.get(0));
//                if (dia != null) {
//                    ArrayList<String> listaHorarios = viajes.getHorarioDiaRuta(ruta, dia);
//                    String horario = (String) JOptionPane.showInputDialog(null, "Elija el horario del viaje que desea eliminar: ", "HORARIOS", JOptionPane.QUESTION_MESSAGE, null, listaHorarios.toArray(), listaHorarios.get(0));
//                    if (horario != null) {
//                        viajes.remover(ruta, dia, horario);
//                        setChanged();
//                        notifyObservers("Se ha removido el viaje con Exito");
//                    }
//                }
//            }
//        } else {
//            setChanged();
//            notifyObservers("No existe ningun viaje registrado");
//        }
    }

    public void remover_chofer() {
//        if (choferes.size() > 0) {
//            ArrayList<String> nombres_choferes = new ArrayList();
//            for (Chofer chofer : choferes) {
//                nombres_choferes.add(chofer.getNombre());
//            }
//            String chofer = (String) JOptionPane.showInputDialog(null, "Digite el chofer que desea remover del sistema: ", "CHOFERES", JOptionPane.QUESTION_MESSAGE, null, nombres_choferes.toArray(), nombres_choferes.get(0));
//            if (chofer != null) {
//                choferes.remove(obtenerChofer(chofer));
//                setChanged();
//                notifyObservers("Se ha removido el chofer con exito");
//            }
//        } else {
//            setChanged();
//            notifyObservers("No existen choferes registrados");
//        }
    }

    public Chofer obtenerChofer(String nombre) {
        for (Chofer chofer : choferes) {
            if (chofer.getNombre().equals(nombre)) {
                return chofer;
            }
        }
        return null;
    }
    
    public int obtenerLlaveChofer(String licencia) {
        try {
            Statement statement = conexion.getConexion().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM choferes WHERE licencia = \"" + licencia + "\";");
            if (query.next()) {
                return query.getInt("idchoferes");
            }
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public void agregarObservador(Observer observer) {
        addObserver(observer);
        setChanged();
        notifyObservers();
    }
}
