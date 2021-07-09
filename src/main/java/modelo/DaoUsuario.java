package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import entidades.persona;
import entidades.telefono;
import entidades.usuario;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class DaoUsuario {

    static Connection currenctCon = null;
    static ResultSet rs = null;

    //login 
    public persona login(String usuario, String contraseña) {
        Statement stmt = null;
        boolean more = false;
        persona objpersona = new persona();
        String searchQuery
                = "SELECT P.idPersona,P.Nombre,P.ApellidoPaterno,P.ApellidoMaterno,P.NroDocumento,D.Descripcion,P.Correo,P.TipoDocumento,TP.Tipo FROM persona P INNER JOIN tipopersona TP ON P.idTipoPersona = TP.idTipoPersona INNER JOIN direccion D ON P.id_Direccion = D.ID_Direccion"
                + " WHERE p.Usuario ='"
                + usuario + "' AND p.Contrasena='"
                + contraseña + "';";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                objpersona.setIdPersona(Integer.parseInt(rs.getString("P.idPersona")));
                objpersona.setNombre(rs.getString("P.Nombre"));
                objpersona.setApellidoP(rs.getString("P.ApellidoPaterno"));
                objpersona.setApellidoM(rs.getString("P.ApellidoMaterno"));
                objpersona.setNroDocumento(rs.getString("P.NroDocumento"));
                objpersona.setDireccion(rs.getString("D.Descripcion"));
                objpersona.setCorreo(rs.getString("P.Correo"));
//                objpersona.setTipoDocumento(rs.getString("P.TipoDocumento"));
                objpersona.setTipoPersona(rs.getString("TP.Tipo"));
            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return objpersona;
    }

    //obtener telefono
    public telefono obtenerTelefono(int id) {
        Statement stmt = null;
        boolean more = false;
        telefono objtelefono = new telefono();
        String searchQuery
                = "SELECT * FROM persona p inner join telefono t on p.idPersona=t.idPersona"
                + " where p.idPersona='"
                + id + "';";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                objtelefono.setIdTelefono(Integer.parseInt(rs.getString("idTelefono")));
                objtelefono.setNrotelefono(rs.getString("NroTelefono"));
                objtelefono.setDetalle(rs.getString("Detalle(Propiedad)"));
                objtelefono.setIdPersona(Integer.parseInt(rs.getString("idPersona")));
                ;
            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return objtelefono;
    }

    //obtener contraseña
    public usuario obtenerContrasena(String id) {
        Statement stmt = null;
        boolean more = false;
        usuario objpersona = new usuario();
        String searchQuery
                = "SELECT * FROM persona p"
                + " INNER JOIN tipopersona tp ON p.idTipoPersona = tp.idTipoPersona"
                + " WHERE p.NroDocumento ='"
                + id + "';";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                objpersona.setIdUsuario(Integer.parseInt(rs.getString("idUsuario")));
                objpersona.setNombre(rs.getString("Nombre"));
                objpersona.setContraseña(rs.getString("Contrasena"));
                objpersona.setIdPersona(Integer.parseInt(rs.getString("idPersona")));

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return objpersona;
    }

    //cantidad de personas
    public int cantidad() {
        int cant = 0;
        Statement stmt = null;
        boolean more = false;
        persona objpersona = new persona();
        String searchQuery
                = "select * from persona order by idPersona desc LIMIT 1";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                cant = Integer.parseInt(rs.getString("idpersona"));

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return cant;
    }

    //cantidad usuarios
    public int cantidadu() {
        int cant = 0;
        Statement stmt = null;
        boolean more = false;
        persona objpersona = new persona();
        String searchQuery
                = "select * from usuario order by idPersona desc LIMIT 1";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                cant = Integer.parseInt(rs.getString("idUsuario"));

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return cant;
    }

    public int cantidaddi() {
        int cant = 0;
        Statement stmt = null;
        boolean more = false;
        persona objpersona = new persona();
        String searchQuery
                = "select * from direccion order by ID_Direccion desc LIMIT 1";

        System.out.println(searchQuery);

        try {
            System.out.println(searchQuery);
            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            more = rs.next();

            do {
                cant = Integer.parseInt(rs.getString("ID_Direccion"));

            } while (rs.next());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return cant;
    }

    //registroPaciente
    public persona RegistroP(persona bean, String celular) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
//        PreparedStatement ps2 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement stmt = null;
        try {
            String nombre = bean.getNombre();
            String apellidop = bean.getApellidoP();
            String apellidom = bean.getApellidoM();

            String usuario = bean.getNroDocumento();
            String contrasena = bean.getNroDocumento();

            String fechan = bean.getFechaNac();
            String tipodocu;
            String ndocu = bean.getNroDocumento();
            String direccion = bean.getDireccion();
            String distrito = bean.getDistrito();
            String provincia = bean.getProvincia();
            String departamento = bean.getDepartamento();
            String correo = bean.getCorreo();
            String in=bean.getTipoDocumento();
            if("1".equals(in)){
                tipodocu="dni";
            }else{
                tipodocu="Carnet de Extrangeria";
            }
//            String contrasena=contra;
            bean.setEstado(true);
            boolean a = true;

//            INSERT INTO `persona` (`idPersona`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `Usuario`, `Contrasena`, `FechaNacimiento`, `TipoDocumento`, `NroDocumento`, `id_Direccion`, `Correo`, `idEspecialidad`, `Estado`, `idTipoPersona
//            `) VALUES(NULL, '', NULL, NULL, '', '', '', '', '', '', '', NULL, NULL
//            , '')
//            String sql="INSERT INTO `persona`"
//                        + " (`idPersona`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`, `FechaNacimiento`,"
//                        + " `TipoDocumento`, `NroDocumento`, `id_Direccion`, `Correo`, `idEspecialidad`,"
//                        + " `Estado`, `idTipoPersona`)"
//                        + " VALUES"
//                        + " (NULL, '" + nombre + "', '" + apellidop + "', '" + apellidom + "','"+fechan+"',"
//                        + " '" + tipodocu + "','" + ndocu + "', '" + (cantidaddi()) + "','" + correo + "', NULL,"
//                        + " '1','3')";
            String sql = "INSERT INTO `persona`"
                    + " (`idPersona`, `Nombre`, `ApellidoPaterno`, `ApellidoMaterno`,"
                    + " `Usuario`, `Contrasena`, `FechaNacimiento`, `TipoDocumento`,"
                    + " `NroDocumento`, `id_Direccion`, `Correo`, `idEspecialidad`,"
                    + " `Estado`, `idTipoPersona`)"
                    + " VALUES"
                    + " (NULL, '" + nombre + "', '" + apellidop + "', '" + apellidom + "',"
                    + " '" + usuario + "', '" + contrasena + "', '" + fechan + "', '" + tipodocu + "',"
                    + " '" + ndocu + "', '" + (cantidaddi()) + "', '" + correo + "', NULL,"
                    + " '1','3')";
            String sql2 = "INSERT INTO `telefono`"
                    + " (`idTelefono`, `NroTelefono`, `Detalle(Propiedad)`, `idPersona`)"
                    + " VALUES"
                    + " (NULL, '" + celular + "', '', '" + (cantidad() + 1) + "')";
            String sql3 = "INSERT INTO `direccion`"
                    + " (`ID_Direccion`, `Id_Dist`, `Descripcion`)"
                    + " VALUES"
                    + " (NULL, '"+distrito+"', '" + direccion + "')";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
            System.out.println(sql3);
            ps3 = cn.prepareStatement(sql3);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
            ps3.execute();
            ps.execute();
            ps2.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
//                if(ps2 != null) ps2.close();
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return bean;
    }

    //Actualizarusuario
    public persona ActualizarU(persona bean, String contra, String celular) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        Statement stmt = null;
        try {
            int idu = bean.getIdPersona();
            String nombre = bean.getNombre();
            String apellidop = bean.getApellidoP();
            String apellidom = bean.getApellidoM();
            String correo = bean.getCorreo();
            String direc = bean.getDireccion();
            bean.setEstado(true);
            String sql = "UPDATE `persona` SET Nombre='" + nombre + "',ApellidoPaterno='" + apellidop + "',ApellidoMaterno='" + apellidom + "',`Correo`='" + correo + "' WHERE idPersona='" + idu + "'";
//            String sql = "UPDATE `persona` SET `Nombre` ='" + nombre + "',`ApellidoPaterno` ='" + apellidop + "', `ApellidoMaterno` ='" + apellidom + "', `TipoDocumento` ='" + tipodocu + "', `NroDocumento` ='" + ndocu + "', `Correo` ='" + correo + "' where idPersona='" + idu + "'";
//            String sql2 = "UPDATE`usuario` SET `Nombre` ='" + direc + "',`Contraseña` ='" + contrasena + "' where idPersona='" + idu + "'";
            String sql2 = "UPDATE direccion SET Descripcion='" + direc + "' WHERE  ID_Direccion=(SELECT p.id_Direccion from persona as p where p.idPersona='" + idu + "')";
//            String sql3 = "UPDATE `telefono` SET `NroTelefono` ='" + celular + "' where idPersona='" + idu + "'";
            cn = ConnectionManager.getConn();
            System.out.println(sql);
            System.out.println(sql2);
//            System.out.println(sql3);
            ps = cn.prepareStatement(sql);
            ps2 = cn.prepareStatement(sql2);
//            ps3 = cn.prepareStatement(sql3);
            ps.execute();
            ps2.execute();
            ps3.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return bean;
    }

    public persona ActualizarPaciente(persona bean) {
        Connection cn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Statement stmt = null;
        try {
            int idu = bean.getIdPersona();
            String nombre = bean.getNombre();
            String apellidop = bean.getApellidoP();
            String apellidom = bean.getApellidoM();
            String fecha_nacimiento = bean.getFechaNac();
            String ndocu = bean.getNroDocumento();
            String direccion = bean.getDireccion();
            String correo = bean.getCorreo();
//            idDoctor,nombre,apellidop,apellidom,fecha_nacimiento,dni,direccion,correo
            bean.setEstado(true);
            String sql = "UPDATE `persona` SET `Nombre` ='" + nombre + "',"
                    + "`ApellidoPaterno` ='" + apellidop + "', "
                    + "`ApellidoMaterno` ='" + apellidom + "', "
                    + "`FechaNacimiento` ='" + fecha_nacimiento + "', "
                    //                                 + "`TipoDocumento` ='"+tipodocu+"', "
                    + "`NroDocumento` ='" + ndocu + "', "
                    + "`Correo` ='" + correo + "' "
                    + "where idPersona='" + idu + "'";

            cn = ConnectionManager.getConn();
            System.out.println(sql);
            ps = cn.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return bean;
    }

    public ArrayList<persona> obtenerPacientes() {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT * FROM persona p INNER JOIN direccion d ON d.ID_Direccion=p.id_Direccion INNER JOIN ubdistrito ud ON ud.idDist=d.Id_Dist INNER JOIN ubprovincia up ON up.idProv=ud.idProv INNER JOIN ubdepartamento udp ON udp.idDepa=up.idDepa WHERE p.idTipoPersona = 3";
//                "SELECT * FROM persona p INNER JOIN especialidad e ON p.idEspecialidad = e.idEspecialidad WHERE idTipoPersona = 3 ";

        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                bean.setNombre(Nombre);
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                bean.setApellidoP(ApellidoPaterno);
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setApellidoM(ApellidoMaterno);
                String FechaNacimiento = rs.getString("p.FechaNacimiento");
                bean.setFechaNac(FechaNacimiento);
                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                String Direccion = rs.getString("d.Descripcion");
                bean.setDireccion(Direccion);

                String Distrito = rs.getString("ud.distrito");
                bean.setDistrito(Distrito);
                String Provincia = rs.getString("up.provincia");
                bean.setProvincia(Provincia);
                String Departamento = rs.getString("udp.departamento");
                bean.setDepartamento(Departamento);

                String correo = rs.getString("p.Correo");
                bean.setCorreo(correo);
                String estado = rs.getString("p.Estado");
                bean.setEstado(true);

                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }
    
    public ArrayList<persona> obtenerPacientesLikes(int document) {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT * FROM persona p INNER JOIN direccion d ON d.ID_Direccion = p.id_Direccion INNER JOIN ubdistrito ud ON ud.idDist = d.Id_Dist INNER JOIN ubprovincia up ON up.idProv = ud.idProv INNER JOIN ubdepartamento udp ON udp.idDepa = up.idDepa WHERE p.idTipoPersona = 3 AND p.NroDocumento LIKE '%"+ document +"%'";
        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                bean.setNombre(Nombre);
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                bean.setApellidoP(ApellidoPaterno);
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setApellidoM(ApellidoMaterno);
                String FechaNacimiento = rs.getString("p.FechaNacimiento");
                bean.setFechaNac(FechaNacimiento);
                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                String Direccion = rs.getString("d.Descripcion");
                bean.setDireccion(Direccion);

                String Distrito = rs.getString("ud.distrito");
                bean.setDistrito(Distrito);
                String Provincia = rs.getString("up.provincia");
                bean.setProvincia(Provincia);
                String Departamento = rs.getString("udp.departamento");
                bean.setDepartamento(Departamento);

                String correo = rs.getString("p.Correo");
                bean.setCorreo(correo);
                String estado = rs.getString("p.Estado");
                bean.setEstado(true);

                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }
    
    public ArrayList<persona> obtenerPacientesEnfermero() {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT p.idPersona,p.ApellidoPaterno,p.ApellidoMaterno,p.Nombre,p.NroDocumento,p.Estado FROM persona p WHERE p.idTipoPersona = 3";
//                "SELECT * FROM persona p INNER  e ON p.idEspecialidad = e.idEspecialidad WHERE idTipoPersona = 3 ";

        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setNombre(ApellidoPaterno + " " + ApellidoMaterno + ", " +Nombre);

                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                
                int estado = Integer.parseInt(rs.getString("p.Estado"));
                if (estado==1){
                    bean.setPerEstado("Activo");
                }else{
                    bean.setPerEstado("No Activo");
                }
                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }
    
    public ArrayList<persona> obtenerPacientesLikesEnfermero(int document) {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT * FROM persona p INNER JOIN direccion d ON d.ID_Direccion = p.id_Direccion INNER JOIN ubdistrito ud ON ud.idDist = d.Id_Dist INNER JOIN ubprovincia up ON up.idProv = ud.idProv INNER JOIN ubdepartamento udp ON udp.idDepa = up.idDepa WHERE p.idTipoPersona = 3 AND p.NroDocumento LIKE '%"+ document +"%'";
        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setNombre(ApellidoPaterno + " " + ApellidoMaterno + ", " +Nombre);

                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                
                int estado = Integer.parseInt(rs.getString("p.Estado"));
                if (estado==1){
                    bean.setPerEstado("Activo");
                }else{
                    bean.setPerEstado("No Activo");
                }
                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }

    public ArrayList<persona> obtenerPacientesRec() {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT p.idPersona, p.Nombre, p.ApellidoPaterno, p.ApellidoMaterno, p.TipoDocumento, p.NroDocumento, p.FechaNacimiento, d.Descripcion, d.Id_Dist, p.Estado FROM persona p INNER JOIN direccion d ON d.ID_Direccion = p.id_Direccion INNER JOIN ubdistrito ud ON ud.idDist = d.Id_Dist INNER JOIN ubprovincia up ON up.idProv = ud.idProv INNER JOIN ubdepartamento udp ON udp.idDepa = up.idDepa WHERE p.idTipoPersona = 3";
//                "SELECT * FROM persona p INNER JOIN especialidad e ON p.idEspecialidad = e.idEspecialidad WHERE idTipoPersona = 3 ";

        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setNombre(ApellidoPaterno + " " + ApellidoMaterno + ", " + Nombre);

                String tipoDocumento = rs.getString("p.TipoDocumento");
                bean.setTipoDocumento(tipoDocumento);
                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                String FechaNacimiento = rs.getString("p.FechaNacimiento");
                bean.setFechaNac(FechaNacimiento);

                String Direccion = rs.getString("d.Descripcion");
                bean.setDireccion(Direccion);

                String estado = rs.getString("p.Estado");
                if (estado == "1") {
                    bean.setEstado(true);
                } else {
                    bean.setEstado(false);
                }

                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }

    //obtener todas los pacientes con tal dni
    public ArrayList<persona> obtenerPacientesRecLike(int NroDNI) {
        ArrayList<persona> obj_paciente = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery
                = "SELECT p.idPersona, p.Nombre, p.ApellidoPaterno, p.ApellidoMaterno, p.TipoDocumento, p.NroDocumento, p.Correo, p.FechaNacimiento, d.Descripcion, d.Id_Dist, p.Estado FROM persona p INNER JOIN direccion d ON d.ID_Direccion = p.id_Direccion INNER JOIN ubdistrito ud ON ud.idDist = d.Id_Dist INNER JOIN ubprovincia up ON up.idProv = ud.idProv INNER JOIN ubdepartamento udp ON udp.idDepa = up.idDepa WHERE p.idTipoPersona = 3 AND P.NroDocumento LIKE '%"+ NroDNI +"%'";
//                "SELECT * FROM persona p INNER JOIN especialidad e ON p.idEspecialidad = e.idEspecialidad WHERE idTipoPersona = 3 ";

        System.out.println(searchQuery);

        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
//            boolean more= rs.next();
            System.out.println("llenando");
            while (rs.next()) {
                persona bean = new persona();

                String idPaciente = rs.getString("p.idPersona");
                bean.setIdPersona(Integer.parseInt(idPaciente));

                String Nombre = rs.getString("p.Nombre");
                String ApellidoPaterno = rs.getString("p.ApellidoPaterno");
                String ApellidoMaterno = rs.getString("p.ApellidoMaterno");
                bean.setNombre(ApellidoPaterno + " " + ApellidoMaterno + ", " + Nombre);

                String tipoDocumento = rs.getString("p.TipoDocumento");
                bean.setTipoDocumento(tipoDocumento);
                String dni = rs.getString("p.NroDocumento");
                bean.setNroDocumento(dni);
                String Correo = rs.getString("p.Correo");
                bean.setCorreo(Correo);
                String FechaNacimiento = rs.getString("p.FechaNacimiento");
                bean.setFechaNac(FechaNacimiento);

                String Direccion = rs.getString("d.Descripcion");
                bean.setDireccion(Direccion);

                String estado = rs.getString("p.Estado");
                if (estado == "1") {
                    bean.setEstado(true);
                } else {
                    bean.setEstado(false);
                }

                obj_paciente.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_paciente;
    }

    //obtener todas los pacientes con tal dni
    public ArrayList<persona> obtenerPacientesRecep() {
        ArrayList<persona> obj_citas = new ArrayList<persona>();
        Statement stmt = null;

        String searchQuery = "SELECT p.idPersona, p.Nombre, p.ApellidoPaterno, p.ApellidoMaterno,"
                + " p.TipoDocumento, p.NroDocumento, p.Correo"
                + " FROM persona p"
                + " where p.idTipoPersona=3";
        System.out.println(searchQuery);
        try {

            currenctCon = ConnectionManager.getConn();
            stmt = currenctCon.createStatement();
            rs = stmt.executeQuery(searchQuery);

            while (rs.next()) {
                persona bean = new persona();
                int idUsuarioCliente = Integer.parseInt(rs.getString("p.idPersona"));
                bean.setIdPersona(idUsuarioCliente);

                String Nombre_Paciente = rs.getString("p.Nombre");
                String Apellido1_Paciente = rs.getString("p.ApellidoPaterno");
                String Apellido2_Paciente = rs.getString("p.ApellidoMaterno");
                bean.setNombre(Nombre_Paciente + " " + Apellido1_Paciente + " " + Apellido2_Paciente);

                String TipoDocumento = rs.getString("p.TipoDocumento");
                bean.setTipoDocumento(TipoDocumento);
                String NroDocumento = rs.getString("p.NroDocumento");
                bean.setNroDocumento(NroDocumento);
                String Correo = rs.getString("p.Correo");
                bean.setCorreo(Correo);

                obj_citas.add(bean);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                    stmt = null;
                }
            }
            if (currenctCon != null) {
                try {
                    currenctCon.close();
                } catch (Exception e) {
                    currenctCon = null;
                }
            }
        }
        return obj_citas;
    }

}
