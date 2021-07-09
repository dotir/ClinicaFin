<%-- 
    Document   : upaciente
    Created on : 07/07/2021, 04:05:54 PM
    Author     : ALESSO
--%>
<%@page import="modelo.DaoUsuario"%>
<%@page import="entidades.Atencion"%>
<%@page import="entidades.detalleatencion"%>
<%@page import="modelo.DaoAtencion"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="entidades.doctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.DaoDoctor"%>
<%@page import="modelo.DaoAdmin"%>
<%@page import="entidades.persona"%>
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
                <!--        ADMINISTRADOR-->
                <% persona currentUser = (persona) session.getAttribute("datospersona");
                    Gson gson = new Gson();
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
                        <li><a href="#">Agregar doctor</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Paciente</span>
                    </a>
                    <ul>
                        <li><a href="bpaciente.jsp">Buscar Paciente</a></li>
                        <li><a href="#">Registrar Paciente</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Citas</span>
                    </a>
                    <ul>
                        <li><a href="bcita.jsp">Buscar Cita</a></li>
                        <li><a href="#">Registrar Cita</a></li>
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

                <!-- PACIENTE -->
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
                        <li><a href="rcitaexa.jsp">Registrar cita para examen</a></li>
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
                <!-- MEDICO --> 
                <%
                } else if (currentUser.getTipoPersona().equals("medico")) {
                %>
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
                        <li><a href="ucita.jsp">Editar cita</a></li>
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
                <!-- Farmacia --> 
                <%
                } else if (currentUser.getTipoPersona().equals("farmaceutico")) {
                %>

                <li class="side_menu_title">
                    <span>Medicamentos</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Medicamentos</span>
                    </a>
                    <ul>
                        <li><a href="rmedicamento.jsp">ingresar medicamento</a></li>
                        <li><a href="rstock.jsp">ingresar stock de medicamento</a></li>
                        <li><a href="bmedicamento.jsp">Buscar medicamento</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Venta</span>
                    </a>
                    <ul>
                        <li><a href="rventa.jsp">Venta</a></li>
                        <li><a href="#">Estadisticas</a></li>
                        <li><a href="#">Buscar medicamento</a></li>
                    </ul>
                </li>
                <!-- Farmacia --> 

                <!-- Laboratorio --> 
                <%
                } else if (currentUser.getTipoPersona().equals("laboratorio")) {
                %>

                <li class="side_menu_title">
                    <span>Laboratorio</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="principal.jsp" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Medicamentos</span>
                    </a>
                </li>

                <!-- Laboratorio --> 
                <!-- Enfermero --> 
                <%
                } else if (currentUser.getTipoPersona().equals("enfermero")) {
                %>

                <li class="side_menu_title">
                    <span>Atencion</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="principal.jsp" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Atencion Emergencia</span>
                    </a>
                </li>
                <li class="">
                    <a   class="has-arrow" href="bcita.jsp" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Triaje</span>
                    </a>
                </li>
                <!-- Enfermero --> 
                <!-- Recepcionista --> 
                <%
                } else if (currentUser.getTipoPersona().equals("recepcionista")) {
                %>

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
                <!-- Recepcionista --> 
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

                                    <div class="profile_info_iner">
                                        <p><%= currentUser.getTipoPersona()%></p>
                                        <h5><%= currentUser.getNombre()%> <%= currentUser.getApellidoP()%></h5>
                                        <div class="profile_info_details">
                                            <a href="perfil.jsp">My Perfil <i class="ti-user"></i></a>
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


            <div class="main_content_iner ">
                <div class="container-fluid p-0">
                    <div class="row justify-content-center">

                        <% if (currentUser.getTipoPersona().equals("paciente")) {
                        %>

                        <% } else if (currentUser.getTipoPersona().equals("administrador")) {
                        %>
                        <div class="main_content_iner ">
                            <div class="container-fluid p-0">
                                <div class="row justify-content-center">
                                    <div class="col-12">
                                        <div class="QA_section">
                                            <div class="white_box_tittle list_header">
                                                <h4>Doctor</h4>
                                                <div class="box_right d-flex lms_block">
                                                    <div class="serach_field_2">
                                                        <div class="search_inner">
                                                            <form Active="#">
                                                                <div class="search_field">
                                                                    <input type="text" placeholder="Buscar">
                                                                </div>
                                                                <button type="submit"> <i class="ti-search"></i> </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                    <div class="add_button ml-10">

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="QA_table mb_30">
                                                <!-- table-responsive -->
                                                <table class="table lms_table_active">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">Nombre</th>
                                                            <th scope="col">ApellidoP</th>
                                                            <th scope="col">ApellidoM</th>
                                                            <th scope="col">DNI</th>
                                                            <th scope="col">Correo</th>
                                                            <th scope="col">Accion</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>                          
                                                        <%
                                                            DaoUsuario objcita = new DaoUsuario();

                                                            ArrayList<persona> objcitas = objcita.obtenerPacientes();
                                                            //                                                ArrayList<persona> objpersonas = objcita.obtenerDoctoresdet();
                                                        %>
                                                        <% for (int i = 0; i < objcitas.size(); i++) {%>
                                                        <tr>
                                                            <td><%=objcitas.get(i).getNombre()%></td>
                                                            <td><%=objcitas.get(i).getApellidoP()%></td>
                                                            <td><%=objcitas.get(i).getApellidoM().toString()%></td>
                                                            <td><%=objcitas.get(i).getNroDocumento()%></td>
                                                            <td><%=objcitas.get(i).getCorreo()%></td>
                                                            <td>
                                                                <button class="btn btn-info" data-toggle="modal" data-target="#exampleModal" value="<%=gson.toJson(objcitas.get(i)).replaceAll("\"", "'")%>" onclick="modifyPaciente(this)">
                                                                    Inspeccionar </button>
                                                            </td>
                                                        </tr>
                                                        <% }%>

                                                    </tbody>
                                                </table>


                                                <!-- Modal -->
                                                <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Actualizar datos</h5>
                                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                                    <span aria-hidden="true">&times;</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <div class="card-group">
                                                                    <div class="card">
                                                                        <form id="registro" name=form method="POST" action="UsuarioPacienteActualizar" >
                                                                            <input hidden="true" type="text" name="idpersona" value="<%=currentUser.getIdPersona()%>"  class="form-control">
                                                                            <!--{'nombre':'Alessandro Pelayo','apellidosP':'Mollocondo','apellidoM':'Medrano','especialidad':'Cardiología'}-->
                                                                            <div class="form-group">
                                                                                <label for="idPersona" >Numero de persona es: </label>
                                                                                <input type="text" id="idPersona" name="idPersona" class="form-control" placeholder="idPersona">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="Nombre" >Nombre</label>
                                                                                <input type="text" id="Nombre" name="Nombre" class="form-control" placeholder="Nombre">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="ApellidoP" >Apellido Paterno</label>
                                                                                <input type="text" id="ApellidoP" name="ApellidoP" class="form-control" placeholder="ApellidoP">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="ApellidoM" >Apellido Materno</label>
                                                                                <input type="text" id="apellidoM" name="ApellidoM" class="form-control" placeholder="ApellidoM">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="NroDocumento" >dni</label>
                                                                                <input type="text" id="NroDocumento" name="NroDocumento" class="form-control" placeholder="dni">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="FechaNac" >Fecha de nacimiento</label>
                                                                                <input type="date" id="FechaNac" name="FechaNac" class="form-control" placeholder="FechaNac">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="correo" >Correo</label>
                                                                                <input type="text" id="correo" name="correo" class="form-control" placeholder="correo">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="Direccion" >Direccion</label>
                                                                                <input type="text" id="Direccion" name="Direccion" class="form-control" placeholder="Direccion">
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label for="detalle" >Descripcion de la especialidad</label>
                                                                                <input type="text" id="detalle" name="detalle" class="form-control" placeholder="Nombre">
                                                                            </div>
                                                                            <input type="submit" class="btn_1 full_width text-center" value="Actualizar"> 
                                                                        </form>
                                                                    </div>
                                                                </div>                                        
                                                            </div>

                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                                <button type="button" class="btn btn-primary">Save changes</button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% } else if (currentUser.getTipoPersona().equals("medico")) {
                        %>
                        <div class="col-lg-12">
                            <div class="white_box mb_30">
                                <div class="box_header ">
                                    <div class="main-title">
                                        <h3 class="mb-0" >Menu</h3>
                                    </div>
                                </div>
                                <div class="card-group">
                                    <div class="card">
                                        <img src="img/banner.png" class="card-img-top" alt="...">
                                        <div class="card-body">
                                            <h5 class="card-title">Citas</h5>
                                            <p class="card-text">Ingresa a tus cita.</p>
                                            <a href="bcita.jsp" class="btn btn-primary">Ingresa</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>      
                        <% } else if (currentUser.getTipoPersona().equals("recepcionista")) {
                        %>
                        <div class="main_content_iner ">
                            <div class="container-fluid p-0">
                                <div class="row justify-content-center">
                                    <div class="col-12">
                                        <div class="QA_section">
                                            <div class="white_box_tittle list_header">
                                                <h4>Pacientes</h4>
                                                <div class="box_right d-flex lms_block">
                                                    <div class="serach_field_2">
                                                        <div class="search_inner">
                                                            <div class="search_inner">
                                                                <form Active="#">
                                                                    <div class="search_field">
                                                                        <input type="text" id="CodDni" name="CodDni" placeholder="Buscar receta por dni de paciente">
                                                                    </div>
                                                                    <button> <i class="ti-search"></i> </button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="add_button ml-10">

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="QA_table mb_30">
                                                <!-- table-responsive -->
                                                <form id="registro" name=form method="POST" action="#" >
                                                    <input hidden="true" type="text" name="idpersona" value="<%=currentUser.getIdPersona()%>"  class="form-control">
                                                    <!--{'nombre':'Alessandro Pelayo','apellidosP':'Mollocondo','apellidoM':'Medrano','especialidad':'Cardiología'}-->
                                                    <div class="form-group">
                                                        <label for="idPersona" >Numero de persona es: </label>
                                                        <input type="text" id="idPersona" name="idPersona" class="form-control" placeholder="idPersona">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Nombre" >Nombre</label>
                                                        <input type="text" id="Nombre" name="Nombre" class="form-control" placeholder="Nombre">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="ApellidoP" >Apellido Paterno</label>
                                                        <input type="text" id="ApellidoP" name="ApellidoP" class="form-control" placeholder="ApellidoP">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="ApellidoM" >Apellido Materno</label>
                                                        <input type="text" id="apellidoM" name="ApellidoM" class="form-control" placeholder="ApellidoM">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="NroDocumento" >dni</label>
                                                        <input type="text" id="NroDocumento" name="NroDocumento" class="form-control" placeholder="dni">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="FechaNac" >Fecha de nacimiento</label>
                                                        <input type="date" id="FechaNac" name="FechaNac" class="form-control" placeholder="FechaNac">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="correo" >Correo</label>
                                                        <input type="text" id="correo" name="correo" class="form-control" placeholder="correo">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="Direccion" >Direccion</label>
                                                        <input type="text" id="Direccion" name="Direccion" class="form-control" placeholder="Direccion">
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="detalle" >Descripcion de la especialidad</label>
                                                        <input type="text" id="detalle" name="detalle" class="form-control" placeholder="Nombre">
                                                    </div>
                                                    <input type="submit" class="btn_1 full_width text-center" value="Actualizar"> 
                                                </form>

                                            </div>



                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>             
                        <%}%>

                    </div>
                </div>
            </div>




            <!-- footer part -->
            <div class="footer_part">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer_iner text-center">
                                <p>2020 © Influence - Designed by <a href="#"> <i class="ti-heart"></i> </a><a href="#"> Dashboard</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- main content part end -->

        <!-- footer  -->
        <!-- jquery slim -->
        <script src="js/jquery-3.4.1.min.js"></script>
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
    </body>

    <!-- Mirrored from demo.dashboardpack.com/hospital-html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 May 2021 22:04:53 GMT -->
</html>