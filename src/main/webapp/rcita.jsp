<%-- 
    Document   : principal
    Created on : 10/05/2021, 06:45:39 PM
    Author     : Dell
--%>
<%@page import="java.util.Calendar"%>
<%@page import="entidades.HelperSelect"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="entidades.persona"%>
<%@page import="modelo.Daodatos"%>
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
        <script src="js/jquery-3.4.1.min.js"></script>
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
                        <li><a href="#">Buscar doctor</a></li>
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
                        <li><a href="#">Buscar Cita</a></li>
                        <li><a href="#">Registrar Cita</a></li>
                    </ul>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Venta Farmacia</span>
                    </a>
                    <ul>
                        <li><a href="#">Buscar Venta</a></li>
                        <li><a href="#">Registrar Venta</a></li>
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


                }
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
                                    <% // persona currentUser = (persona)session.getAttribute("datospersona");%>
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
            <<!--/ menu  -->
            <div class="main_content_iner ">
                <div class="container-fluid p-0">
                    <div class="row justify-content-center">
                        <div class="col-lg-12">
                            
                            <div class="white_box mb_30" id="form2v">
                                <div class="row justify-content-center">
                                    <div class="col-lg-6">
                                        <div class="modal-content cs_modal">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Registrar Cita</h5>
                                            </div>
                                            <div class="modal-body">
                                                                                            <% Daodatos obj1 = new Daodatos();%>
                                                <form id="registrocita" name=formdetcita method="POST" action="CitaREgistroE">

                                                    <input hidden="true" type="text"   name="idper" class="form-control" placeholder="Ingrese el detalle" value="<%= currentUser.getIdPersona()%>" disable>
                                                    <div class="form-group">
                                                        <label for="especialidad"> Escoger la especialidad: </label>
                                                        <select name="especialidad" class="form-control" aria-label="Default select example">
                                                            <option value="null">Eliga la especialidad</option>
                                                            <%ArrayList<HelperSelect> tipoexamen = obj1.obtenerEspecialidad();%>
                                                        <%for (HelperSelect p : tipoexamen) {%>       
                                                        <!-- se itera el array para almacenarlo en un combo box -->
                                                        <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                                                        <% }%>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="especialidad"> Escoger el doctor: </label>
                                                        <select name="doctor" class="form-control" aria-label="Default select example">
                                                            <option value="null">Eliga el doctor</option>                                                   
                                                        </select>
                                                    </div>
                                                    <div class="form-group">                                                        
                                                        <label for="especialidad"> El costo es: </label>
                                                        <input name="costo" type="text" class="form-control" aria-label="Costo" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="especialidad"> Escoger el local: </label>
                                                        <select name="idlocal" class="form-control" aria-label="Default select example">
                                                            <option selected>Eliga el local</option>
                                                            <option value="1">Local 1</option>
                                                            <option value="2">Local 2</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="especialidad"> Escoger el tipo de atencion que desea: </label>
                                                        <select name="tatencion" class="form-control" aria-label="Default select example">
                                                            <option selected>Eliga el tipo atencion</option>               
                                                            <option value="1">presencial</option>
                                                            <option value="2">virtual</option>

                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <label for="fecha"> Escoger el dia: </label>
                                                        <input type="date" class="input_form" name="fecha" min="<%=Calendar.getInstance().getTime()%>" placeholder="Ingrese la fecha de la cita">
                                                    </div>
<!--                                                    <div class="input_wrap common_date_picker mb_20">
                                                        <input name="hora_inicio" placeholder="Seleccionar hora inicio" type="datetime-local" id="input_starttime" class="form-control timepicker">
                                                    </div>-->

                                                    <div class="input_wrap common_date_picker mb_20">
                                                        <label for="especialidad"> Escoger la hora: </label>
                                                        <input name="hora_fin" placeholder="Seleccionar hora fin" type="time" id="input_starttime" class="form-control timepicker">
                                                    </div>
                                                    <input type="submit" class="btn btn-primary" value="Registrar">

                                                </form>
                                            </div>
                                        </div>
                                    </div></div></div>
                        </div>
                        <script>
                            var id = $("select[name=especialidad]").val();
                            $("select[name=especialidad]").on("change", function () {
                                var id = $(this).val();
//                                alert(id);
                                $.post('SeleccionarDoctor', {
                                    id: id,
                                }, function (msg) {
                                    console.log(msg);
                                    $("select[name=doctor]").html('<option value="null">Eliga la especialidad</option>');
                                    
                                    for (var i = 0; i < msg.length; i++) {                                        
                                        $("select[name=doctor]").append('<option value="' + msg[i].id + '">' + msg[i].Nombre + '</option>');
                                    }
                                    console.log(msg);
                                });
                            });
                            var id = $("select[name=doctor]").val();
                            $("select[name=doctor]").on("change", function () {
                                var id = $(this).val();
//                                alert(id);
                                $.post('SeleccionarCostoEspecialidad', {
                                    id: id,
                                }, function (msg) {
                                    console.log("entro");
                                    console.log(msg);
                                    $("input[name=costo]").val('S/' + msg +'.00');
                                });
                            });
                        </script>


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
                                                        function showHint(str)
                                                        {
                                                            if (str.length == 0) {
                                                                document.getElementById("txtHint").innerHTML = "";
                                                                return;
                                                            } else {
                                                                var xmlhttp = new XMLHttpRequest();
                                                                xmlhttp.onreadystatechange = function () {
                                                                    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                                                                        document.getElementById("txtHint").innerHTML = xmlhttp.responseText;
                                                                    }
                                                                }
                                                                xmlhttp.open("GET", "srvTest2?q=" + str, true);
                                                                xmlhttp.send();
                                                            }
                                                        }
        </script>
    </body>

    <!-- Mirrored from demo.dashboardpack.com/hospital-html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 May 2021 22:04:53 GMT -->
</html>