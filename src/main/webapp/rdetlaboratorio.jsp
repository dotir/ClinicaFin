<%-- 
    Document   : rdetlaboratorio
    Created on : 07/07/2021, 05:18:07 PM
    Author     : ALESSO
--%>
<%@page import="entidades.HelperSelect"%>
<%@page import="modelo.Daodatos"%>
<%@page import="entidades.DetalleReceta"%>
<%@page import="modelo.DaoRecetas"%>
<%@page import="modelo.DaoProducto"%>
<%@page import="entidades.TratamientoStock"%>
<%@page import="entidades.detalleatencion"%>
<%@page import="modelo.DaoTratamiento"%>
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
                <!--        ADMINISTRADOR-->
                <% persona currentUser = (persona) session.getAttribute("datospersona");
                    String CodeRec111 = session.getAttribute("CodeRec").toString();
                    String NombrePac111 = session.getAttribute("NombrePac").toString();
                    String idUPaciente111 = session.getAttribute("idUPaciente").toString();
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
                <!-- medico -->
                <li>
                    <button type="button" class="btn btn-danger btn-block">EMERGENCIA</button>
                    <!--<a href="#" class="btn btn-danger">EMERGENCIA</a>-->
                </li>

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
                        <li><a href="bcita.jsp">Buscar medicamento</a></li>
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
                <!-- Farmacia --> 

                <!-- Laboratorio --> 
                <%
                } else if (currentUser.getTipoPersona().equals("laboratorio")) {
                %>

                <li class="side_menu_title">
                    <span>Laboratorio</span>
                </li>
                <li class="">
                    <a   class="has-arrow" href="#" aria-expanded="false">
                        <img src="img/menu-icon/2.svg" alt="">
                        <span>Laboratorio</span>
                    </a>
                    <ul>
                        <li><a href="rlaboratorio.jsp">Laboratorio</a></li>
                        <li><a href="#">Resultados de Examenes</a></li>
                        <li><a href="#">Buscar de Examenes</a></li>
                    </ul>
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
                <% }%>




            </ul>  
        </nav>
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
            <div class="main_content_iner ">
                <div class="container-fluid p-0">
                    <div class="row justify-content-center">
                        <div class="col-12">
                            <div class="QA_section">
                                <div class="white_box_tittle list_header">
                                    <h4>Detalle de receta </h4>
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
                                    <div class="form-group">
                                        <input type="text" name="NombrePaciente" value="El paciente es: <%=NombrePac111%>"  class="form-control" placeholder="Nombre del tratamiento" disabled>
                                    </div> 
                                    <table class="table lms_table_active">
                                        <thead>
                                            <tr>
                                                <th scope="col">Numero Receta</th>
                                                <th scope="col">Nombre de Detalle Receta</th>
                                                <th scope="col">Descripcion</th>
                                                <th scope="col">Cantidad</th>
                                                <th scope="col">Observacion</th>
                                                <th scope="col">Estado</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                DaoRecetas obj = new DaoRecetas();
                                                ArrayList<DetalleReceta> medicamento = obj.obtenerDetalleRecetasLaboratorio(Integer.parseInt(CodeRec111));
                                                for (int i = 0; i < medicamento.size(); i++) {
                                            %>
                                            <tr>
                                                <td><%=medicamento.get(i).getIdReceta()%></td>
                                                <td><%=(i + 1)%></td>
                                                <td><%=medicamento.get(i).getDescripcion()%></td>
                                                <td><%=medicamento.get(i).getCantidad()%></td>
                                                <td><%=medicamento.get(i).getObservacion()%></td>
                                                <td><%=medicamento.get(i).getEstado()%></td>
                                            </tr>
                                            <%
                                                }
                                            %> 
                                        </tbody>
                                    </table>
                                    <div class="card-body">
                                        <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">

                                        <% Daodatos obj123 = new Daodatos();%>

                                        <div class="card-body">
                                            <% Daodatos obj1 = new Daodatos();%>
                                            <div class="QA_table mb_30">
                                                <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">

                                                <div class="form-group">
                                                    <select id="idTipoExamen" name="idtipoexamen" class="form-control" aria-label="Default select example">
                                                        <option selected>Eliga el tipo de examen</option>   
                                                        <%ArrayList<HelperSelect> tipoexamen = obj1.obtenerTipoExamen();%>
                                                        <%for (HelperSelect p : tipoexamen) {%>       
                                                        <!-- se itera el array para almacenarlo en un combo box -->
                                                        <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                                                        <% }%>
                                                    </select>
                                                </div>
                                                <div class="form-group">
                                                    <select id="Examen" name="Examen" class="form-control" aria-label="Default select example">
                                                        <option value="null">Eliga el tipo de Examen</option>                                                   
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="QA_table mb_30">
                                                <button id="btnAddExamen" name="btnAddExamen" class="btn btn-primary">Añadir Examen</button>
                                            </div>

                                            <table class="table lms_table_active" id="tabvent" name="tabvent" style="display:none">
                                                <thead>
                                                    <tr>
                                                        <th scope="col" style="width:50px"># Examen</th>
                                                        <th scope="col">Nombre del Examen</th>
                                                        <th scope="col" style="width:500px" >Cant. Recetada</th>
                                                        <th scope="col" style="width:50px" >Precio</th>
                                                        <th scope="col" style="width:100px" >IGV</th>
                                                        <th scope="col">TOTAL</th>
                                                        <th scope="col"> OPCIONES </th>

                                                    </tr>
                                                </thead>
                                                <tbody id="tabventDet">

                                                </tbody>
                                            </table>
                                            <div class="QA_table mb_30">
                                                <input type="hidden" value="<%=idUPaciente111%>" name="CodePac"> <!-- etiquetado sin meta --> 
                                                <input type="hidden" value="<%=currentUser.getIdPersona()%>" name="CodeDoc"> <!-- etiquetado sin meta --> 
                                                <button id="btnAddLaboratorio" name="btnAddLaboratorio" class="btn btn-primary">Realizar Laboratorio</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    let carritoVentas = [];
                    let aaa = [];
                    const origen = {carritoVentas};
                    // Destino
                    let $data = new Proxy(origen, {
                        set(target, name, value) {
                            if (name === "carritoVentas") {
                                console.log(value);
                                console.log("lllego");
                                const html = value.reduce((prev, {idExamen,
                                        Examen,
                                        Precio,
                                        Total = (Precio + (Precio * 0.18))}, index) => {//para eliminar se agrega el index
                                    const col = '<tr role="row" class="odd">' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:50px" id="Producto ' + idExamen + '" value="' + idExamen + '" readonly="readonly" disabled/></td>' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:500px" id="DescProduct ' + idExamen + 'o" value="' + Examen + '" readonly="readonly" disabled/></td>' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:50px" id="Cantidad ' + idExamen + '" value="1" readonly="readonly" /></td>' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:100px" id="Precio ' + idExamen + '" value="S/' + Precio + '" readonly="readonly" /></td>' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:100px" id="IGV ' + idExamen + '" value="S/' + (Precio * 18) / 100 + '" readonly="readonly" /></td>' +
                                            ' <td> <input type="text" class="form-control text-center" style="width:100px" id="Subtotal ' + idExamen + '" value="S/' + Total + '" readonly="readonly" /></td>' +
                                            ' <td> <button onclick="EliminarMedicamento(' + index + ')" >Eliminar</button></td>' + //para eliminar se agrega un boton
                                            '</tr>'
                                    return prev + col
                                }, '')

                                $("tbody[id='tabventDet']").html(html)
                            }
                        }
                    });
                    //para eliminar se agrega la funcion
                    function EliminarMedicamento(index) {
                        carritoVentas.splice(index, 1);
                        Reflect.set($data, "carritoVentas", carritoVentas);

                    }
                    $("button[name=btnAddLaboratorio]").on("click", function () {
                        let sub = JSON.stringify(carritoVentas);
                        const CodePac = $("input[name=CodePac]").val();
                        const CodeDoc = $("input[name=CodeDoc]").val();
                        const CodeAtencio = $("input[name=CodeAtencio]").val();
                        $.post('LaboratorioAgregar', {
                            sub: sub,
                            CodePac: CodePac,
                            CodeDoc: CodeDoc,
                            CodeAtencio: CodeAtencio
                        }, function (msg) {
                            console.log(msg);
                        });
                    });
                    $("button[name=btnAddExamen]").on("click", function () {
                        var idtipoexamen = $("select[name=idtipoexamen]").val();
                        var Examen = $("select[name=Examen]").val();
                        console.log(idtipoexamen);
                        console.log(Examen);
                        $.post('SeleccionarExamenPrecio', {
                            idtipoexamen: idtipoexamen,
                            Examen: Examen,
                            Producto: "",
                            NombreProducto: "",
                            Cantidad: "",
                            Precio: ""

                        }, function (msg) {
                            //                        det = msg;
                            console.log(msg);
                            const det = JSON.parse(msg);
                            carritoVentas.push(det[0]);
                            Reflect.set($data, "carritoVentas", carritoVentas);
                        });
                    });
                    $("select[name=idtipoexamen]").on("change", function () {
                        var id = $(this).val();
                        //                        alert(id);
                        $.post('SeleccionarTipoExamen', {
                            id: id,
                        }, function (msg) {
                            console.log(msg);
                            $("select[name=Examen]").html('<option value="null">Eliga el tipo de Examen</option> ');
                            for (let i = 0; i < msg.length; i++) {
                                $("select[name=Examen]").append('<option value="' + msg[i].id + '">' + msg[i].Nombre + '</option>');
                            }
                        });
                    });
                    $("select[name=Examen]").on("change", function () {
                        var busq = $(this).val();
                        var busq1 = $("select[name=Examen]").val();
                        console.log(busq);
                        console.log(busq1);
                        $("#tabvent").removeAttr("style");
                    });
                </script>
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

    </body>

    <!-- Mirrored from demo.dashboardpack.com/hospital-html/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Mon, 10 May 2021 22:04:53 GMT -->
</html>