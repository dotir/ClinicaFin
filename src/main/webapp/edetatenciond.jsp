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
         <% persona currentUser = (persona)session.getAttribute("datospersona");%>
        
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
            <li><a href="#">Buscar Venta</a></li>
            <li><a href="#">Registrar Venta</a></li>
          </ul>
        </li>

          <!-- Adminitracion -->
        <%    
            }else if (currentUser.getTipoPersona().equals("paciente")){
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
            }else if (currentUser.getTipoPersona().equals("medico")){
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
                                <p class="card-text">Solicita tu cita desde aqui.</p>
                                <a href="rcita.jsp" class="btn btn-primary">Solicita</a>
                              </div>
                            </div>
                            <div class="card">
                              <img src="img/banner.png" class="card-img-top" alt="...">
                              <div class="card-body">
                                <h5 class="card-title">Citas</h5>
                                <p class="card-text">Ingresa a tus citas aqui.</p>
                                <a href="bcita.jsp" class="btn btn-primary">Ingresa</a>
                              </div>
                            </div>
                            <div class="card">
                              <img src="img/banner.png" class="card-img-top" alt="...">
                              <div class="card-body">
                                <h5 class="card-title">Recetas</h5>
                                <p class="card-text">Consulta tus recetas aqui.</p>
                                <a href="breceta.jsp" class="btn btn-primary">Consulta</a>
                              </div>
                            </div>
                          </div>
                    </div>
                </div>
                <% }else if (currentUser.getTipoPersona().equals("administrador")) {     
                %>
                    <div class="col-lg-12">
                    <div class="single_element">
                        <div class="quick_activity">
                            <div class="row">
                                <div class="col-12">
                                    <div class="quick_activity_wrap">
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="img/icon/man.svg" alt="">
                                            </div>
                                            <% DaoAdmin cantidades=new DaoAdmin();%>
                                            <div class="count_content">
                                                <h3><span class="counter"><%=cantidades.cantidadDoctores()%></span> </h3>
                                                <p>Doctores</p>
                                            </div>
                                        </div>
                                        <div class="single_quick_activity d-flex">
                                            <div class="icon">
                                                <img src="img/icon/wheel.svg" alt="">
                                            </div>
                                            <div class="count_content">
                                                <h3><span class="counter"><%=cantidades.cantidadPacientes()%></span> </h3>
                                                <p>Pacientes</p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <% }else if (currentUser.getTipoPersona().equals("medico")) {     
                %>
                    <div class="col-lg-12">
                    <div class="white_box mb_30">
                        <div class="row justify-content-center">
                            <div class="col-lg-6">
                                <!-- sign_in  -->
                                <div class="modal-content cs_modal">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Historial Clinico</h5>
                                    </div>
                                    <div class="form-group">
                                                 <input type="text" name="tipo_atencion" class="form-control" placeholder="ipo de atencion" required/>
                                    </div>
                                    <div class="form-group">
                                                 <input type="text" name="local" class="form-control" placeholder="local" required/>
                                    </div>
                                    <div class="form-group">
                                                 <input type="text" name="DETALLE" class="form-control" placeholder="DETALLE" required/>
                                    </div>
                                    <div class="modal-body">
<!--                                        <form id="registrocita" name=formcita method="POST" action="CitaRegistro">
                                    
                                            <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">
                                            <div class="form-group">
                                                <select name="docoesp" class="form-control" aria-label="Default select example">
                                                     <option selected>REcetar</option>
                                                     <option value="si">si</option>
                                                     <option value="no">no</option>
                                                </select>
                                            </div>                             
                                            <input type="submit" class="btn btn-primary" value="Siguiente">
                                            
                                        </form>-->
                                    </div>
                                </div>
                                <div class="modal-content cs_modal">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Atencion</h5>
                                    </div>
                                    <div class="modal-body">
                                        <form id="registrocita" name=formcita method="POST" action="CitaAtenciond">
                                    
                                            <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">
                                            <div class="form-group">
                                                <select name="docoesp" class="form-control" aria-label="Default select example">
                                                     <option selected>Recetar</option>
                                                     <option value="si">si</option>
                                                     <option value="no">no</option>
                                                </select>
                                            </div>                             
                                            <input type="submit" class="btn btn-primary" value="Siguiente">
                                            
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