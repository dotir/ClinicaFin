<%-- 
    Document   : ucita
    Created on : 06/07/2021, 08:56:31 AM
    Author     : ALESSO
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
        <script src="js/jquery-3.4.1.min.js"></script>
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



                <%
                } else if (currentUser.getTipoPersona().equals("recepcionista")) {
                %>
                <!-- medico -->
                <li class="side_menu_title">
                    <span>RECEPCION</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="bcita.jsp" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>PACIENTES</span>
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
                                <div class="form-group">
                                    <label for="NombrePac123">Nombre del Paciente: </label>
                                    <input type="text" id="NombrePac" name="NombrePac" class="form-control" placeholder="Nombre" value="">
                                </div>
                                <div class="form-group">
                                    <label for="dniPac123">Numero de DNI del Paciente: </label>
                                    <input type="text" id="dniPac" name="dniPac" class="form-control" placeholder="Nombre" value="">
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
                                        <tbody  id="TabalaBusPac">
                                        </tbody>
                                    </table>
                                    <%} else if (currentUser.getTipoPersona().equals("recepcionista")) {%>
                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">Numero de paciente</th>
                                                <th scope="col">Nombre Nombre completo</th>
                                                <th scope="col">Tipo de docuemunto</th>
                                                <th scope="col">Numero de documento</th>
                                                <th scope="col">Correo</th>
                                                <th scope="col">Agregar cita</th>
                                                <th scope="col">Confimar cita</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%for (int i = 0; i < objcitasr.size(); i++) {%>
                                            <tr>
                                                <td><%=objcitasr.get(i).getIdPersona()%></td>
                                                <td><%=objcitasr.get(i).getNombre()%></td>
                                                <td><%=objcitasr.get(i).getTipoDocumento()%></td>
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

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <script>
                $("input[name=NombrePac]").on("keyup", function () {
                        var busq = $(this).val();
                        var dniPac = $("input[name='dniPac']").val();
                        console.log("hola");
                        console.log(busq);
                        console.log(dniPac);
                        if(busq.length>0){
                            $.post('CitaConsulta', {
                            busq: busq,
                            dniPac: dniPac
                        }, function (msg) {
                            console.log(msg); 
                            console.log("holaaaaaaaaaaaaaaaaaaaaaaaa");
                            var aaa = JSON.parse(msg);
                            const html = aaa.reduce((prev,{IdAtencion, 
                                IdUPaciente,
                                NombrePaciente,
                                Local,
                                TipoAtencion,
                                FechaProgramada})=>{
                                const col = '<tr role="row" class="odd">'+
                                   ' <td>'+IdAtencion+'</td>'+
                                   ' <td>'+IdUPaciente+'</td>'+
                                   ' <td>'+NombrePaciente+'</td>'+
                                   ' <td>'+Local+'</td>'+
                                   ' <td>'+TipoAtencion+'</td>'+
                                   ' <td>'+FechaProgramada+'</td>'+
                                   '</tr>'
                                    return prev +col
                                },'')
                                
                                $("tbody[id='TabalaBusPac']").html(html)
                        });
                        }
                    });
            </script>

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