<%-- 
    Document   : principal
    Created on : 10/05/2021, 06:45:39 PM
    Author     : Dell
--%>
<%@page import="modelo.Daodatos"%>
<%@page import="modelo.DaoUsuario"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="entidades.AtencionPersona"%>
<%@page import="entidades.detalleatencion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Atencion"%>
<%@page import="entidades.persona"%>
<%@page import="modelo.DaoAtencion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="zxx">


    <!-- Mirrored from demo.dashboardpack.com/hospital-html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 May 2021 22:04:16 GMT -->
    <!-- Added by HTTrack --><meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Clinica</title>

        <!-- <link rel="icon" href="img/favicon.png" type="image/png"> -->
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css" />
        <!-- themefy CSS -->
        <link rel="stylesheet" href="vendors/themefy_icon/themify-icons.css" />
        <!-- swiper slider CSS -->
        <link rel="stylesheet" href="vendors/swiper_slider/css/swiper.min.css" />
        <!-- select2 CSS -->
        <link rel="stylesheet" href="vendors/select2/css/select2.min.css" />
        <!-- select2 CSS -->
        <link rel="stylesheet" href="vendors/niceselect/css/nice-select.css" />
        <!-- owl carousel CSS -->
        <link rel="stylesheet" href="vendors/owl_carousel/css/owl.carousel.css" />
        <!-- gijgo css -->
        <link rel="stylesheet" href="vendors/gijgo/gijgo.min.css" />
        <!-- font awesome CSS -->
        <link rel="stylesheet" href="vendors/font_awesome/css/all.min.css" />
        <link rel="stylesheet" href="vendors/tagsinput/tagsinput.css" />
        <!-- datatable CSS -->
        <link rel="stylesheet" href="vendors/datatable/css/jquery.dataTables.min.css" />
        <link rel="stylesheet" href="vendors/datatable/css/responsive.dataTables.min.css" />
        <link rel="stylesheet" href="vendors/datatable/css/buttons.dataTables.min.css" />
        <!-- text editor css -->
        <link rel="stylesheet" href="vendors/text_editor/summernote-bs4.css" />
        <!-- morris css -->
        <link rel="stylesheet" href="vendors/morris/morris.css">
        <!-- metarial icon css -->
        <link rel="stylesheet" href="vendors/material_icon/material-icons.css" />

        <!-- menu css  -->
        <link rel="stylesheet" href="css/metisMenu.css">
        <!-- style CSS -->
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/colors/default.css" id="colorSkinCSS">
        
        <script src="js/jquery-3.4.1.min.js"></script>
    </head>
    <body class="crm_body_bg">



        <!-- main content part here -->

        <!-- sidebar  -->
        <!-- sidebar part here -->
        <nav class="sidebar">
            <div class="logo d-flex justify-content-between">
                <a href="principal.jsp"><img src="img/logo.png" alt=""></a>
                <div class="sidebar_close_icon d-lg-none">
                    <i class="ti-close"></i>
                </div>
            </div>
            <ul id="sidebar_menu">
                <li class="side_menu_title">
                    <span>Tablero</span>
                </li>
                <li class="mm-active">
                    <a class="has-arrow"  href="#"  aria-expanded="false">
                        <!-- <i class="fas fa-th"></i> -->
                        <img src="img/menu-icon/1.svg" alt="">
                        <span>Tablero</span>
                    </a>
                </li>
                <% persona currentUser = (persona) session.getAttribute("datospersona");
                    Gson gson = new Gson();
                    String nombreReg;
                    int codReg;
                %>

                <%  if (currentUser.getTipoPersona().equals("administrador")) {
                %>        
                <!-- Adminitracion -->
                <li class="side_menu_title">
                    <span>Administracion</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Doctor</span>
                    </a>
                    <ul>
                        <li><a href="bdoctor.jsp">Buscar doctor</a></li>
                        <li><a href="rdoctor.jsp">Agregar doctor</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Paciente</span>
                    </a>
                    <ul>
                        <li><a href="bpaciente.jsp">Buscar Paciente</a></li>
                        <li><a href="rpaciente.jsp">Registrar Paciente</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Citas</span>
                    </a>
                    <ul>
                        <li><a href="bcita.jsp">Buscar Cita</a></li>
                        <li><a href="rcita.jsp">Registrar Cita</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Venta Farmacia</span>
                    </a>
                    <ul>
                        <li><a href="bventa.jsp">Buscar Venta</a></li>
                        <li><a href="rventa.jsp">Registrar Venta</a></li>
                    </ul>
                </li>

                <!-- Adminitracion -->
                <%
                } else if (currentUser.getTipoPersona().equals("paciente")) {
                %>
                <!-- Cliente -->
                <li class="side_menu_title">
                    <span>Atencion</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Citas</span>
                    </a>
                    <ul>
                        <li><a href="bcita.jsp">Buscar cita</a></li>
                        <li><a href="rcita.jsp">Registrar cita</a></li>
                    </ul>
                </li>

                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/3.svg" alt="">
                        <span>Recetas</span>
                    </a>
                    <ul>
                        <li><a href="breceta.jsp">Buscar receta</a></li>
                        <li><a href="#">Pagar receta</a></li>
                    </ul>
                </li>
                <!-- Cliente --> 
                <%
                } else if (currentUser.getTipoPersona().equals("medico")) {
                %>
                <!-- medico -->
                <li class="side_menu_title">
                    <span>Atenciones</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Citas</span>
                    </a>
                    <ul>
                        <li><a href="bcita.jsp">Buscar cita</a></li>
                    </ul>
                </li>

                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/3.svg" alt="">
                        <span>Recetas</span>
                    </a>
                    <ul>
                        <li><a href="breceta.jsp">Asignar receta</a></li>
                    </ul>
                </li>
                <!-- Medico --> 



                <%
                } else if (currentUser.getTipoPersona().equals("recepcionista")) {
                %>
                <!-- medico -->
                <li class="side_menu_title">
                    <span>RECEPCION</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>PACIENTES</span>
                    </a>
                    <ul>
                        <li><a href="bpaciente.jsp">Buscar Paciente</a></li>
                        <li><a href="upaciente.jsp">Editar Paciente</a></li>
                        <li><a href="rpaciente.jsp">Buscar Paciente</a></li>
                    </ul>
                </li>

                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/3.svg" alt="">
                        <span>Citas</span>
                    </a>
                    <ul>
                        <li><a href="bcita.jsp">Buscar receta</a></li>
                        <li><a href="rcita.jsp">Registrar receta</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Farmacia</span>
                    </a>
                    <ul>
                        <li><a href="rventa.jsp">Venta</a></li>
                        <li><a href="#">Estadisticas</a></li>
                        <li><a href="#">Buscar medicamento</a></li>
                    </ul>
                </li>
                <!-- Medico --> 



                <% }%>





            </ul> 

        </nav>
        <!-- sidebar part end -->
        <!--/ sidebar  -->


        <section class="main_content dashboard_part">
            <!-- menu  -->
            <div class="container-fluid no-gutters">
                <div class="row">
                    <div class="col-lg-12 p-0">
                        <div class="header_iner d-flex justify-content-between align-items-center">
                            <div class="sidebar_icon d-lg-none">
                                <i class="ti-menu"></i>
                            </div>
                            <div class="serach_field-area">
                                <div class="search_inner">

                                </div>
                            </div>
                            <div class="header_right d-flex justify-content-between align-items-center">
                                <div class="header_notification_warp d-flex align-items-center">

                                </div>
                                <div class="profile_info">
                                    <img src="img/client_img.png" alt="#">
                                    <% // persona currentUser = (persona)session.getAttribute("datospersona");
//                             Gson gson = new Gson();%>
                                    <div class="profile_info_iner">
                                        <p><%= currentUser.getTipoPersona()%></p>
                                        <h5><%= currentUser.getNombre()%> <%= currentUser.getApellidoP()%></h5>
                                        <div class="profile_info_details">
                                            <a href="index.jsp">Salir <i class="ti-shift-left"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--/ menu  -->
            <!--/ menu  -->
            <div class="main_content_iner ">
                <div class="container-fluid p-0">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="QA_section">
                                <div class="white_box_tittle list_header">
                                    <h4>Citas</h4>
                                    <div class="box_right d-flex lms_block">
                                        <div class="serach_field_2">
                                            <div class="search_inner">

                                            </div>
                                        </div>
                                        <div class="add_button ml-10">

                                        </div>
                                    </div>
                                </div> 

                                <div class="QA_table mb_30">
                                    <!-- table-responsive -->

                                    <%
                                        DaoAtencion objcita = new DaoAtencion();
                                        DaoUsuario objcitar = new DaoUsuario();
                                        ArrayList<Atencion> objcitasp = objcita.obtenerCitaPacientes(currentUser.getIdPersona());
//                                                ArrayList<detalleatencion> objcitasp = objcita.obtenerCitaPacientes(currentUser.getIdPersona());
                                        ArrayList<Atencion> objcitasd = objcita.obtenerCitadoctoresdet(currentUser.getIdPersona());
                                        ArrayList<persona> objcitasr = objcitar.obtenerPacientesRecep();
                                        if (currentUser.getTipoPersona().equals("paciente")) {
                                    %>
                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">Numero de Atencion</th>
                                                <th scope="col">Nombre Dcotor</th>
                                                <th scope="col">Especialidad</th>
                                                <th scope="col">Nombre Paciente</th>
                                                <th scope="col">Tipo de atencion</th>
                                                <th scope="col">Local</th>
                                                <th scope="col">Fecha Programada</th>
                                                <th scope="col">Hora inicio</th>
                                                <th scope="col">TOTAL</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (int i = 0; i < objcitasp.size(); i++) {%>
                                            <tr>
                                                <td><%=objcitasp.get(i).getIdAtencion()%></td>
                                                <td><%=objcitasp.get(i).getNombreMedico()%></td>
                                                <td><%=objcitasp.get(i).getEspecialidad()%></td>
                                                <td><%=objcitasp.get(i).getNombrePaciente()%></td>
                                                <td><%=objcitasp.get(i).getTipoAtencion()%></td>
                                                <td><%=objcitasp.get(i).getLocal()%></td>
                                                <td><%=objcitasp.get(i).getFechaProgramada()%></td>
                                                <td><%=objcitasp.get(i).getHoraInicio()%></td>
                                                <td><%=objcitasp.get(i).getTotal()%></td>
                                            </tr>
                                            <% }%>
                                        </tbody>
                                    </table>
                                    <!--MEDICO-->

                                    <%} else if (currentUser.getTipoPersona().equals("medico")) {%>
                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">Numero de Atencion</th>
                                                <th scope="col">Nombre Paciente</th>
                                                <th scope="col">Tipo de Atencion</th>
                                                <th scope="col">Local</th>
                                                <th scope="col">Fecha Programada</th>
                                                <th scope="col">Emergencia</th>
                                                <th scope="col">Estado</th>
                                                <th scope="col">Diagnostico</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (int i = 0; i < objcitasd.size(); i++) {%>
                                            <tr>
                                                <td><%=objcitasd.get(i).getIdAtencion()%></td>
                                                <td><%=objcitasd.get(i).getNombrePaciente()%></td>
                                                <td><%=objcitasd.get(i).getTipoAtencion()%></td>
                                                <td><%=objcitasd.get(i).getLocal()%></td>
                                                <td><%=objcitasd.get(i).getFechaProgramada()%></td>
                                                <td><%=objcitasd.get(i).isEmergencia()%></td>
                                                <td><%=objcitasd.get(i).getEstado()%></td>
                                                <td>
                                                    <form method="get" action="CitaDetDoc">
                                                        <input type="hidden" value="<%=objcitasd.get(i).getIdAtencion()%>" name="CodeAtencio"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=objcitasd.get(i).getIdUPaciente()%>" name="CodePac"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=objcitasd.get(i).getNombrePaciente()%>" name="NombrePac"> <!-- etiquetado sin meta --> 
                                                        <button type="submit" class="btn_1 full_width text-center">Continue</button>
                                                    </form>

                                                </td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%} else if (currentUser.getTipoPersona().equals("recepcionista")) {%>

                                    <div class="serach_field_2">
                                        <div class="search_inner">
                                            <div class="search_inner">
                                                <form Active="#">
                                                    <div class="search_field">
                                                        <input type="text" id="TxtRecDni" name="TxtRecDni" placeholder="Buscar receta por dni de paciente">
                                                    </div>
                                                    <button> <i class="ti-search"></i> </button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">Numero de paciente</th>
                                                <th scope="col">Nombre Nombre completo</th>
                                                <th scope="col">Numero de documento</th>
                                                <th scope="col">Correo</th>
                                                <th scope="col">Agregar cita</th>
                                                <th scope="col">Confimar cita</th>
                                            </tr>
                                        </thead>
                                        <tbody id="tabRecPac">
                                            <%for (int i = 0; i < objcitasr.size(); i++) {%>
                                            <tr>
                                                <td><%=objcitasr.get(i).getIdPersona()%></td>
                                                <td><%=objcitasr.get(i).getNombre()%></td>
                                                <td><%=objcitasr.get(i).getNroDocumento()%></td>
                                                <td><%=objcitasr.get(i).getCorreo()%></td>
                                                <td>
                                                    <form method="get" action="#">
                                                        <%codReg = objcitasr.get(i).getIdPersona();%>
                                                        <%nombreReg = objcitasr.get(i).getNombre();%>
                                                        <input type="hidden" value="<%=objcitasr.get(i).getIdPersona()%>" name="CodePac"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=objcitasr.get(i).getNombre()%>" name="NombrePac"> <!-- etiquetado sin meta --> 
                                                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Continue</button>
                                                    </form>
                                                </td>
                                                <td>
                                                    <form method="get" action="#">
                                                        <input type="hidden" value="<%=objcitasr.get(i).getIdPersona()%>" name="CodePac"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=objcitasr.get(i).getNombre()%>" name="NombrePac"> <!-- etiquetado sin meta --> 
                                                        <button type="submit" class="btn_1 full_width text-center">Continue</button>
                                                    </form>
                                                </td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%}%>

                                    <!-- Modal -->
                                    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                        <div class="modal-dialog modal-dialog-centered" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLongTitle">CREAR CITA</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <form id="registro" name=form method="POST" action="#" >
                                                        <input hidden="true" type="text" name="idpersona" value="<%=currentUser.getIdPersona()%>"  class="form-control">
                                                        <!--{'nombre':'Alessandro Pelayo','apellidosP':'Mollocondo','apellidoM':'Medrano','especialidad':'Cardiología'}-->
                                                        <div class="form-group">
                                                            <label for="idAtencion">Numero del paciente: </label>
                                                            <input type="text" id="idAtencion" name="idAtencion" class="form-control" placeholder="Nombre" value="">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="TipoAtencion">Nombre del paciente: </label>
                                                            <input type="text" id="TipoAtencion" name="TipoAtencion" class="form-control" placeholder="Nombre" value="">
                                                        </div>
                                                        <div class="form-group">
                                                            <select name="especialidad" class="form-control" aria-label="Default select example">
                                                                <option selected>Eliga la especialidad</option>
                                                                <% Daodatos obj = new Daodatos();%>
                                                                <% for (int i = 0; i < obj.obtenerEspecialidad().size(); i++) {
                                                                %>
                                                                <option value="<%=i%>"><%= obj.obtenerEspecialidad().get(i)%></option>
                                                                <% } %>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <select name="iddoctor" class="form-control" aria-label="Default select example">
                                                                <option selected>Eliga el doctor</option>
                                                                <%for (AtencionPersona p : obj.obtenerDoctores()) {%>       
                                                                <!-- se itera el array para almacenarlo en un combo box -->
                                                                <option value="<%=p.getIdUsuarioMedico()%>"><%=p.getNombre_Medico()%></option>
                                                                <% }%>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <select name="idlocal" class="form-control" aria-label="Default select example">
                                                                <option selected>Eliga el local</option>
                                                                <option value="1">Local 1</option>
                                                                <option value="2">Local 2</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-group">
                                                            <select name="tatencion" class="form-control" aria-label="Default select example">
                                                                <option selected>Eliga el tipo atencion</option>               
                                                                <option value="1">presencial</option>
                                                            </select>
                                                        </div>
                                                        <div class="form-check">
                                                            <input name="Emergenecia" class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                                                            <label class="form-check-label" for="flexCheckDefault">
                                                                Emergencia
                                                            </label>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="precio">precio: </label>
                                                            <input type="text" id="idAtencion" name="subtotal" class="form-control" placeholder="precio" value="">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="IGV">precio: </label>
                                                            <input type="text" id="idAtencion" name="igv" class="form-control" placeholder="IGV" value="">
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="TOTAL">precio: </label>
                                                            <input type="text" id="idAtencion" name="total" class="form-control" placeholder="TOTAL" value="">
                                                        </div>
                                                        <div style="float:right;">
                                                            <script type="text/javascript">
                                                                //<![CDATA[
                                                                var today = new Date();
                                                                var m = today.getMonth() + 1;
                                                                var mes = (m < 10) ? '0' + m : m;
                                                                document.write('Fecha: ' + today.getDate(), '/' + mes, '/' + today.getYear());
                                                                //]]> 
                                                            </script>
                                                        </div>
                                                        <input type="submit" class="btn_1 full_width text-center" value="Registrar cita"> 
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <!-- Modal -->

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- footer part -->
            <div class="footer_part">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer_iner text-center">
                                <p>2021 Diseñado <a href="#"> <i class="ti-heart"></i> </a><a href="#"> Dashboard</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- main content part end -->

        <!-- footer  -->
        <!-- jquery slim -->
        <!-- popper js -->
        <script src="js/popper.min.js"></script>
        <!-- bootstarp js -->
        <script src="js/bootstrap.min.js"></script>
        <!-- sidebar menu  -->
        <script src="js/metisMenu.js"></script>
        <!-- waypoints js -->
        <script src="vendors/count_up/jquery.waypoints.min.js"></script>
        <!-- waypoints js -->
        <script src="vendors/chartlist/Chart.min.js"></script>
        <!-- counterup js -->
        <script src="vendors/count_up/jquery.counterup.min.js"></script>
        <!-- swiper slider js -->
        <script src="vendors/swiper_slider/js/swiper.min.js"></script>
        <!-- nice select -->
        <script src="vendors/niceselect/js/jquery.nice-select.min.js"></script>
        <!-- owl carousel -->
        <script src="vendors/owl_carousel/js/owl.carousel.min.js"></script>
        <!-- gijgo css -->
        <script src="vendors/gijgo/gijgo.min.js"></script>
        <!-- responsive table -->
        <script src="vendors/datatable/js/jquery.dataTables.min.js"></script>
        <script src="vendors/datatable/js/dataTables.responsive.min.js"></script>
        <script src="vendors/datatable/js/dataTables.buttons.min.js"></script>
        <script src="vendors/datatable/js/buttons.flash.min.js"></script>
        <script src="vendors/datatable/js/jszip.min.js"></script>
        <script src="vendors/datatable/js/pdfmake.min.js"></script>
        <script src="vendors/datatable/js/vfs_fonts.js"></script>
        <script src="vendors/datatable/js/buttons.html5.min.js"></script>
        <script src="vendors/datatable/js/buttons.print.min.js"></script>

        <script src="js/chart.min.js"></script>
        <!-- progressbar js -->
        <script src="vendors/progressbar/jquery.barfiller.js"></script>
        <!-- tag input -->
        <script src="vendors/tagsinput/tagsinput.js"></script>
        <!-- text editor js -->
        <script src="vendors/text_editor/summernote-bs4.js"></script>

        <script src="vendors/apex_chart/apexcharts.js"></script>

        <!-- custom js -->
        <script src="js/custom.js"></script>

        <script src="vendors/apex_chart/bar_active_1.js"></script>
        <script src="vendors/apex_chart/apex_chart_list.js"></script>

        <script>
            $("input[name=TxtRecDni]").on("keyup", function () {
                    var busq = $(this).val();
                    console.log("hola");
                    console.log(busq);
                    if (busq.length > 0) {
                        $.post('PacienteBusquedaRecepcionistaLike', {
                            busq: busq
                        }, function (msg) {
                            console.log(msg);
                            console.log("holaaaaaaaaaaaaaaaaaaaaaaaa");
                            var aaa = JSON.parse(msg);
                            const html = aaa.reduce((prev, {idPersona,
                                    Nombre,
                                    NroDocumento,
                                    correo,
                                    cont,
                                    conf}) => {
                                const col = '<tr role="row" class="odd">' +
                                        ' <td>' + idPersona + '</td>' +
                                        ' <td>' + Nombre + '</td>' +
                                        ' <td>' + NroDocumento + '</td>' +
                                        ' <td>' + correo + '</td>' +
                                        + '<td>'
                                        + '<form method="get" action="#">'
                                        + '<input type="hidden" value="'+ idPersona +'" name="CodePac">'
                                        + '<input type="hidden" value="'+ Nombre  + '" name="NombrePac">'
                                        + '<button type="button" id="btn1" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Continuar</button>'
                                        + '</form>'
                                        + '</td>'
                                        + '<td>'
                                        + '<form method="get" action="#">'
                                        + '<input type="hidden" value="'+ idPersona +'" name="CodePac">'
                                        + '<input type="hidden" value="'+ Nombre  + '" name="NombrePac">'
                                        + '<button type="button" id="btn1" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Agregar</button>'
                                        + '</form>'
                                        + '</td>'
                                        + '<td>'
                                        + '<form method="get" action="#">'
                                        + '<input type="hidden" value="'+ idPersona +'" name="CodePac">'
                                        + '<input type="hidden" value="'+ Nombre  + '" name="NombrePac">'
                                        + '<button type="button" id="btn2" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Confirmar</button>'
                                        + '</form>'
                                        + '</td>'
                                        + '</tr>';
                                return prev + col
                            }, '')

                            $("tbody[id='tabRecPac']").html(html)
                        });
                        console.log("si entro :D");
                    } else {
                        
                    }
                });
                                                                function modifyDoctors(ev) {
                                                                    let value = ev.value.replaceAll("'", "\"");
                                                                    value = JSON.parse(value);
                                                                    console.log(value);

                                                                    let idAtencion = document.querySelector("#idAtencion");
                                                                    idAtencion.value = value.idAtencion;

                                                                    let TipoAtencion = document.querySelector("#TipoAtencion");
                                                                    TipoAtencion.value = value.TipoAtencion;

                                                                    let NombreLocal = document.querySelector("#NombreLocal");
                                                                    NombreLocal.value = value.NombreLocal;

                                                                    let Detalle = document.querySelector("#Detalle");
                                                                    Detalle.value = value.Detalle;
                                                                }
                                                                function modifyReceta(ev) {
                                                                    let value = ev.value.replaceAll("'", "\"");
                                                                    value = JSON.parse(value);
                                                                    console.log(value)
                                                                    //let nombre = document.querySelector("#nombre");               
                                                                    //                let nombre = document.getElementById("nombre");

                                                                    //                nombre.value=value.nombre;
                                                                    let idAtencion = document.querySelector("#idAtencion");
                                                                    idAtencion.value = value.idAtencion;


                                                                }



        </script>


    </body>

    <!-- Mirrored from demo.dashboardpack.com/hospital-html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 May 2021 22:04:53 GMT -->
</html>