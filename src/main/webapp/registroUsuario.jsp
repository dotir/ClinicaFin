<%@page import="modelo.Daodatos"%>
<%@page import="modelo.DaoDirecciones"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">

<meta http-equiv="content-type" content="text/html;charset=UTF-8" /><!-- /Added by HTTrack -->
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
    <!-- comobox cargar -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/ubigeo.js"></script>
    <script src="js/app.js"></script>
</head>
<body class="crm_body_bg">
    
    <div class="container-fluid no-gutters"><h1 class="text-center">Bienvenido a la clinica Salud Utp</h1></div>


    <!--/ menu  -->
    <div class="main_content_iner ">
        <div class="container-fluid p-0">
            <div class="row justify-content-center">
                <div class="col-lg-12">
                    <div class="white_box mb_30">
                        <div class="row justify-content-center">
                            <div class="col-lg-6">
                                <!-- sign_in  -->
                                <div class="modal-content cs_modal">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Registro</h5>
                                    </div>
                                    <div class="modal-body">
                                        <form id="registro" name=form method="POST" action="UsuarioRegistro" >
                                            <div class="form-group">
                                                <input type="text" name="nombre" class="form-control" placeholder="Nombre" required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="apellidop" class="form-control" placeholder="Apellido Paterno" required/>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="apellidom" class="form-control" placeholder="Apellido Materno" required/>
                                            </div>
                                            <div class="input_wrap common_date_picker mb_20">
                                                <input type="datetime" class="input_form" name="fechanac" id="start_datepicker" placeholder="Fecha nacimiento" required/>
                                            </div>
                                            <div class="form-group">
                                                <select name="tdoumento" class="form-control" aria-label="Default select example" required>
                                                    <option selected>Tipo documento</option>
                                                    <% Daodatos objdi = new Daodatos(); %>
                                                    <% for (int i = 0; i < objdi.obtenerdocumentos().size(); i++) {%>
                                                    <option value="<%=i%>"><%= objdi.obtenerdocumentos().get(i)%></option>  
                                                    <%}%>
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <input type="number" maxlength="8" name="ndoumento" placeholder="Nro Documento" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="number" maxlength="9" name="ncelular" class="form-control" placeholder="Nro Celular" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="text" name="direccion" class="form-control" placeholder="Direccion" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="ubigeo_dep">Departamento</label>
                                                <select class="form-control" id="ubigeo_dep">			  
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="ubigeo_pro">Provincia</label>
                                                <select class="form-control" id="ubigeo_pro">
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="ubigeo_dis">Distrito</label>
                                                <select class="form-control" id="ubigeo_dis">
                                                </select>
                                            </div>                                                   
                                            <div class="form-group">
                                                <input type="email" name="correo" class="form-control" placeholder="Correo" required>
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="contrasena" class="form-control" placeholder="Contraseña" required>
                                            </div>
                                            <input type="submit" class="btn_1 full_width text-center" value="Registrar"> 
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>



            </div>
        </div>
    </div>
<!-- footer part -->

<div class="footer_iner text-center">
    <p>2021 © Diseñado por<a href="#"> Alumnos Utp</a></p>
</div>


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

</body>
</html>
