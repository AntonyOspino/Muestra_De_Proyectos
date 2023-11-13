package conexiones;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 *
 * @author KingServerus
 */
public class ConexionBD {
    public static final String URL=
            "jdbc:mysql://127.0.0.1:33065/base_de_datos";
    public static final String USER="root";
    public static final String CLAVE="";
    private Connection con;
    
    public void ConectarBD(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                    URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println("Error Conectar: "+e.getMessage());
            //e.printStackTrace();
        }
    }
    
    public void DesconectarBD(){
        try {
            if(con.isClosed()==false){
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ResultSet ConsultaBD(String consulta){
        ResultSet resultado = null;
        try {
            PreparedStatement query = con.prepareStatement(consulta);
            resultado = query.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    public Usuario validarUsuario(String usuario, String contraseña){
     Usuario user = new Usuario();
     try{
        PreparedStatement query = con.prepareStatement("SELECT * FROM `usuario` WHERE usuario = ? AND contraseña= ?");
        query.setString(1,usuario);
        query.setString(2,contraseña);
        ResultSet r = query.executeQuery();
     
        if(r.next()){
        user.setId(r.getInt("id"));
        user.setIdentificacion(r.getString("identificacion"));
        user.setNombre(r.getString("nombre"));
        user.setApellido(r.getString("apellido"));
        user.setTelefono(r.getString("telefono"));
        user.setUsuario(r.getString("usuario"));
        user.setContraseña(r.getString("contraseña"));
        user.setFecha(r.getTimestamp("fecha_hora"));
        user.setIdPerfil(r.getInt("idperfil"));
        user.setEstado(r.getString("estado"));
        }
     }catch(SQLException e){
        e.printStackTrace();
     }
     return user;
    }
    
    public boolean ValidarProyecto(String nombre){
        try {
            PreparedStatement query = con.prepareStatement("SELECT count(*) as total from proyectos "+
                " WHERE nombre=?");
            query.setString(1, nombre);
            ResultSet res = query.executeQuery();
            if(res.next()){ //acceso al primer elemento
                if(res.getInt("total")>0){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; 
    }
    
    public int ObtenerIdProyecto(String nombre){
        Proyecto user = new Proyecto();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM proyectos "+
                " WHERE nombre=?");
            query.setString(1, nombre);
            ResultSet r = query.executeQuery();
            if(r.next()){
                user.setId(r.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getId(); 
    }
    
    public int ObtenerIdCarrera(String nombre){
        Carrera user = new Carrera();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM carrera "+
                " WHERE nombre=?");
            query.setString(1, nombre);
            ResultSet r = query.executeQuery();
            if(r.next()){
                user.setId(r.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getId(); 
    }
    
    public int ObtenerIdFuncionalidad(String nombre){
        Funcionalidad user = new Funcionalidad();
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM funcionalidad "+
                " WHERE nombre=?");
            query.setString(1, nombre);
            ResultSet r = query.executeQuery();
            if(r.next()){
                user.setId(r.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user.getId(); 
    }
    
    public void InsertarProyecto(String nombreProyecto, String integrantes, String carrera, String funcionalidad, String descripcion, int semestre, Usuario usuario){
        try {
            PreparedStatement query = con.prepareStatement("INSERT INTO proyectos "+
                "(nombre,descripcion,estado) "+
                " VALUES (?,?,?)");
            query.setString(1, nombreProyecto);
            query.setString(2, descripcion);
            query.setString(3, "ACTIVO");
            query.executeUpdate();
            System.out.println("modificados: "+query.getUpdateCount()+"\n insertado tabla proyectos");
        } catch (SQLException e) {
            System.out.println("error al insertar en tabla proyectos");
            e.printStackTrace();
        }
        
        
        try {
            int idProyecto = this.ObtenerIdProyecto(nombreProyecto);
            int idCarrera = this.ObtenerIdCarrera(carrera);
            int idUsuario = usuario.getId();
  
            PreparedStatement query = con.prepareStatement("INSERT INTO detallesproyectousuario "+
                "(idproyecto, idcarrera, idusuario, semestre, integrantes, estado) "+
                " VALUES (?,?,?,?,?,?)");
            query.setInt(1, idProyecto);
            query.setInt(2, idCarrera);
            query.setInt(3, idUsuario);
            query.setInt(4, semestre);
            query.setString(5, integrantes);
            query.setString(6, "ACTIVO");
            query.executeUpdate();
            System.out.println("modificados: "+query.getUpdateCount()+"\n insertado tabla detallesproyectousuario");
            
        } catch (Exception e) {
            System.out.println("error al insertar en tabla detallesproyectousuario");
             e.printStackTrace();
        }
        
        try {
            int idProyecto = this.ObtenerIdProyecto(nombreProyecto);
            int idFuncionalidad = this.ObtenerIdFuncionalidad(funcionalidad);
            
            PreparedStatement query = con.prepareStatement("INSERT INTO proyectoxfuncionalidad "+
                "(idproyecto, idfuncionalidad, estado) "+
                " VALUES (?,?,?)");
            query.setInt(1, idProyecto);
            query.setInt(2, idFuncionalidad);
            query.setString(3, "ACTIVO");
            query.executeUpdate();
            System.out.println("modificados: "+query.getUpdateCount()+"\n insertado tabla proyectoxfuncionalidad");
            
        } catch (Exception e) {
            System.out.println("error al insertar en tabla ");
            e.printStackTrace();
        }
    }
    
    public ArrayList<Proyecto> obtenerProyectosConDetalles() {
        ArrayList<Proyecto> lp = new ArrayList<>();
    
        try {
            ResultSet s = ConsultaBD("SELECT " +
                "proyectos.id as id_proyecto, "+
                "proyectos.nombre as nombre_proyecto, " +
                "proyectos.descripcion as descripcion_proyecto, " +
                "GROUP_CONCAT(DISTINCT funcionalidad.nombre) as funcionalidades, " +
                "GROUP_CONCAT(DISTINCT detallesproyectousuario.integrantes) as integrantes, " +
                "carrera.nombre as carrera, " +
                "GROUP_CONCAT(DISTINCT detallesproyectousuario.semestre) as semestres " +
                "FROM `proyectos` " +
                "LEFT JOIN proyectoxfuncionalidad ON proyectos.id = proyectoxfuncionalidad.idproyecto " +
                "LEFT JOIN funcionalidad ON proyectoxfuncionalidad.idfuncionalidad = funcionalidad.id " +
                "LEFT JOIN detallesproyectousuario ON proyectos.id = detallesproyectousuario.idproyecto " +
                "LEFT JOIN carrera ON detallesproyectousuario.idcarrera = carrera.id " +
                "GROUP BY proyectos.id, proyectos.nombre, proyectos.descripcion, carrera.nombre");

            while (s.next()) {
                Proyecto p = new Proyecto();
                p.setId(s.getInt("id_proyecto"));
                p.setNombreProyecto(s.getString("nombre_proyecto"));
                p.setDescripcionProyecto(s.getString("descripcion_proyecto"));
                p.setIntegrantesProyectos(s.getString("integrantes"));
                p.setFuncionalidad(s.getString("funcionalidades"));
                p.setCarrera(s.getString("carrera"));
                p.setSemestre(s.getInt("semestres"));

                lp.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    return lp;
}
    
    public void insertarActualizarOpinion(int idProyecto, int idUsuario, String nota, String opinion) {

        try {
            // Verificar si ya existe una opinión para el proyecto y usuario
            PreparedStatement consultaExistencia = con.prepareStatement(
                "SELECT COUNT(*) AS total FROM opinion WHERE idproyecto = ? AND idAdministrativo = ?"
            );
            consultaExistencia.setInt(1, idProyecto);
            consultaExistencia.setInt(2, idUsuario);

            ResultSet resultadoExistencia = consultaExistencia.executeQuery();
            resultadoExistencia.next();
            int totalOpiniones = resultadoExistencia.getInt("total");

            if (totalOpiniones > 0) {
                
               PreparedStatement consultaUpdate = con.prepareStatement(
                    "UPDATE opinion SET nota = ?, opinion = ? WHERE idproyecto = ? AND idAdministrativo = ?"
                );
                consultaUpdate.setInt(1, Integer.parseInt(nota));
                consultaUpdate.setString(2, opinion);
                consultaUpdate.setInt(3, idProyecto);
                consultaUpdate.setInt(4, idUsuario);

                consultaUpdate.executeUpdate();
            } else {
                PreparedStatement consultaInsert = con.prepareStatement(
                    "INSERT INTO opinion (idproyecto, idAdministrativo, nota, opinion,estado) VALUES (?, ?, ?, ?, ?)"
                );
                consultaInsert.setInt(1, idProyecto);
                consultaInsert.setInt(2, idUsuario);
                consultaInsert.setString(3, nota);
                consultaInsert.setString(4, opinion);
                consultaInsert.setString(5, "ACTIVO");

                consultaInsert.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Opiniones obtenerOpinion(int idProyecto, int idUsuario) {
        Opiniones opinion = null;
        try {
            PreparedStatement query = con.prepareStatement("SELECT * FROM opinion " +
                    "WHERE idproyecto = ? AND idAdministrativo = ?");
            query.setInt(1, idProyecto);
            query.setInt(2, idUsuario);
            ResultSet r = query.executeQuery();

            if (r.next()) {
                opinion = new Opiniones();
                opinion.setNota(r.getInt("nota"));
                opinion.setOpinion(r.getString("opinion"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return opinion;
    }
    
}
