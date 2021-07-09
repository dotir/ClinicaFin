<%-- 
    Document   : bdetcita
    Created on : 09/06/2021, 11:33:18 AM
    Author     : ALESSO
--%>

<%@page import="entidades.HelperSelect"%>
<%@page import="modelo.Daodatos"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="entidades.AtencionPersona"%>
<%@page import="entidades.detalleatencion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Atencion"%>
<%@page import="entidades.persona"%>
<%@page import="modelo.DaoAtencion"%>
<%@page import="java.util.Date"%>
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
//                    ArrayList<AtencionPersona> objAtenDet = (ArrayList<AtencionPersona>) session.getAttribute("DetAten");
                    ArrayList<persona> objAtenDet = (ArrayList<persona>) session.getAttribute("personas");
//                    ArrayList<persona> objAtenDeta = (ArrayList<persona>) session.getAttribute("Nombre");
//                    ArrayList<persona> objAtenDet = (ArrayList<persona>) session.getAttribute("DetAten");
//                    ArrayList<AtencionPersona> objAtenDet = (ArrayList<AtencionPersona>) session.getAttribute("DetAten");
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
                <%
                } else if (currentUser.getTipoPersona().equals("enfermero")) {
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
                        <li><a href="principal.jsp">Buscar cita</a></li>
                        <li><a href="rcita.jsp">Registrar cita</a></li>
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
                        <div class="col-lg-12">
                            <div class="white_box mb_30">
                                <div class="row justify-content-center">
                                    <div class="col-lg-12">
                                        <!-- sign_in  -->
                                        <div class="modal-content cs_modal">
                                            <div class="modal-header">
                                                <h5 class="modal-title">Cita</h5>
                                            </div>
                                            <div class="modal-body">
                                                    <div class="form-group">
                                                        <% System.out.print(objAtenDet.get(0).getIdPersona());%>
                                                        <% System.out.print(objAtenDet.get(0).getIdEspcialidad());%>
                                                        <h5>Numero de Persona: <%=objAtenDet.get(0).getIdEspcialidad()%></h5>
                                                        <input type="text" name="idPersona" class="form-control" placeholder="Numero de atencion " value="<%=objAtenDet.get(0).getIdPersona()%>" disabled>
                                                    </div>
                                                    <div class="form-group">
                                                        <h5>Nombre del paciente </h5>
                                                        <input type="text" name="NombreP" class="form-control" placeholder="Numero de detalle atencion" value="<%=objAtenDet.get(0).getNombre()%>" disabled>
                                                    </div>
                                                    <h5>Diagnostico</h5>
                                                    <textarea name="diagnostico" class="form-control"  rows="5"></textarea>
                                                    <button name="AgregarReceta" id="AgregarReceta" class="btn_1 full_width">Agregar Nueva Receta</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="white_box mb_30" id="form2v" style="display:none">
                                    <div class="row justify-content-center">
                                        <div class="col-md-12">
                                            <div class="card">
                                                <div class="card-header">
                                                    <h5 class="card-title">Agregar Receta</h5>
                                                </div>
                                                <div class="modal-body">
                                                    <div class="row justify-content-center">
                                                        <div class="col-lg-6 col-sm-12">
                                                            <div class="card">
                                                                <div class="card-header">
                                                                    <h5 class="card-title">Agregar Medicamento</h5>
                                                                </div>
                                                                <div class="card-body">
                                                                    <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">
                                                                    <div class="QA_table mb_30">
                                                                        <% Daodatos obj = new Daodatos();%>

                                                                        <div class="form-group">
                                                                            <select id="idMedicamento" name="idmedicamento" class="form-control" aria-label="Default select example">
                                                                                <option value="null">Eliga el Medicamento</option>   
                                                                                <%ArrayList<HelperSelect> medicamento = obj.obtenerMedicamentos();%>
                                                                                <%for (HelperSelect p : medicamento) {%>       
                                                                                <!-- se itera el array para almacenarlo en un combo box -->
                                                                                <option value="<%=p.getId()%>"><%=p.getNombre()%></option>
                                                                                <% }%>
                                                                            </select>
                                                                        </div>

                                                                        <div class="form-group">
                                                                            <select id="tipoMedicamento" name="TipoMedicamento" class="form-control" aria-label="Default select example">
                                                                                <option value="null">Eliga el tipo de medicamento</option>                                                   
                                                                            </select>
                                                                        </div>
                                                                        <div class="form-group" id="CantidadMax">
                                                                            <label for="Camtodad" name="lCantidad">Cantidad Maxima: </label>
                                                                            <input type="number" id="Cantidad" name="Cantidad" class="form-control" placeholder="Cantidad" value="">
                                                                        </div>
                                                                        <h5>Observacion</h5>
                                                                        <textarea id="observacion" name="Observacion" class="form-control"  rows="5"></textarea>
                                                                        <br/>
                                                                        <button id="btnAddReceta" class="btn btn-primary">Añadir Medicamento</button>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-6 col-sm-12"><div class="card">
                                                                <div class="card-header">
                                                                    <h5 class="card-title">Agregar Examen</h5>
                                                                </div>

                                                                <div class="card-body">
                                                                    <div class="QA_table mb_30">
                                                                        <input hidden="true" type="text" value="<%= currentUser.getIdPersona()%>" name="idper" class="form-control" placeholder="Ingrese el detalle">

                                                                        <div class="form-group">
                                                                            <select id="idTipoExamen" name="idtipoexamen" class="form-control" aria-label="Default select example">
                                                                                <option value="null">Eliga el tipo de examen</option>   
                                                                                <%ArrayList<HelperSelect> tipoexamen = obj.obtenerTipoExamen();%>
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
                                                                        <textarea id="observacionExamne" name="Observacion" class="form-control" rows="5" disabled>Examen</textarea>
                                                                        <br/>
                                                                        <button id="btnAddExamen" class="btn btn-primary">Añadir Examen</button>
                                                                    </div>
                                                                </div>
                                                            </div>



                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-sm-12">
                                                            <table class="table table-dark">
                                                                <thead>
                                                                    <tr>
                                                                        <th scope="col">Descripcion</th>
                                                                        <th scope="col">Cantidad</th>
                                                                        <th scope="col">Observacion</th>
                                                                        <th scope="col">Opciones</th>
                                                                    </tr>
                                                                </thead>
                                                                <tbody id="table">
                                                                </tbody>
                                                            </table></div>
                                                    </div>
                                                    <br/>
                                                        <input type="hidden" value="<%=objAtenDet.get(0).getIdPersona()%>" name="CodePac"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=currentUser.getIdPersona()%>" name="CodeDoc"> <!-- etiquetado sin meta --> 
                                                        <input type="hidden" value="<%=objAtenDet.get(0).getIdEspcialidad()%>" name="CodeAtencio"> <!-- etiquetado sin meta --> 
                                                    <button id="btnEnviarReceta" class="btn btn-primary" value="Registrar">Registra receta</button>

                                                </div>
                                        </div>
                                    </div>
                                </div>
                                
                            </div>

                        </div>
                    </div>
                </div>
                <script>
                    let carritoRecetas = [];

                    const origen = {carritoRecetas};

                    // Destino
                    let $data = new Proxy(origen, {
                        set(target, name, value) {
                            if (name === "carritoRecetas") {
                                const html = value.reduce((prev,{Descripcion, 
                                Cantidad,
                                Observacion},index)=>{
                                const col = '<tr role="row" class="odd">'+
                                   ' <td> <input type="text" style="width:400px" class="form-control text-center"  value="'+Descripcion+'" readonly="readonly" disabled/></td>'+
                                   ' <td> <input type="text" style="width:50px" class="form-control text-center"  value="'+Cantidad+'" readonly="readonly" disabled/></td>'+
                                   ' <td> <input type="text" style="width:200px" class="form-control text-center"  value="'+Observacion+'" readonly="readonly" disabled/></td>'+
                                   ' <td> <button onclick="EliminarMedicamento(' + index + ')" >Eliminar</button></td>'+
                                   '</tr>'
                                    return prev +col
                                },'')
                                
                                $("tbody[id='table']").html(html)
                            }
                        }
                    });
                    function EliminarMedicamento(index) {
                        carritoRecetas.splice(index, 1);
                        Reflect.set($data, "carritoRecetas", carritoRecetas);

                    }
                    console.log($)
                    $("button[name=AgregarReceta]").on("click", function () {
//                        e.preventDefault();
//                    ("#AgregarReceta").on("click", function () {
                        //e.preventDefault();
//                            var datos = new FormData();
//                            var docoesp = $("select[name=docoesp]").val();
//                            var idper = $("input[name=idper]").val();
                        console.log("hola");
//                                $("#form2v").attr("style", "display:none");
                        $("#form2v").removeAttr("style");
                        $("#form3v").removeAttr("style");
                    });
                    $("select[name=idmedicamento]").on("change", function () {
                        var id = $(this).val();
//                        alert(id);
                        $.post('SeleccionarTipoPresentacionCantidad', {
                            id: id,
                        }, function (msg) {
                            console.log(msg);
                            $("select[name=TipoMedicamento]").html('<option value="null">Eliga el tipo de medicamento</option> ');
                            for (let i = 0; i < msg.length; i++) {
                                $("select[name=TipoMedicamento]").append('<option value="' + msg[i].id + '">' + msg[i].Nombre + '</option>');
                            }
//                            cantidadMaxTM();  
                        });
                    });
                    $("select[name=TipoMedicamento]").on("change", function () {
                        const id1 = $("select[name=idmedicamento]").val();
                        const id2 = $("select[name=TipoMedicamento]").val();

                        if (id1 && id2) {
                            console.log(id1)
                            console.log(id2)
                            $.post('SeleccionarCantidadMaxima', {
                                id1: id1,
                                id2: id2,
                            }, function (msg) {
                                console.log(msg);
                                $("div[id=CantidadMax]").html('<label for="Camtodad" name="lCantidad">Cantidad Maxima:'
                                        + msg
                                        + '</label><input type="number" id="Cantidad" name="Cantidad" class="form-control" placeholder="Cantidad" value="" '
                                        + 'max="' + msg + '" >');
                                console.log(msg);
                            });
                        }
                    });
                    $("button[id=btnAddExamen]").on("click", function () {
                        const idTipoExamen1 = $("select[id=idTipoExamen]").val()
                        const idTipoExamen = document.querySelector("select[id='idTipoExamen'] option[value='" + idTipoExamen1 + "']").text
                        //idReceta, idDoctor,idPaciente, Fecha,Estado
                        
                        //idDetalle Receta, IdReceta, Descripcion, CAntidad, Observcion Estado
                        const Examen1 = $("select[id=Examen]").val()
                        const Examen = document.querySelector("select[id='Examen'] option[value='" + Examen1 + "']").text

                        const observacion = $("textarea[id=observacionExamne]").val()
                        const receta={
                            Descripcion:idTipoExamen+" "+Examen, 
                            Cantidad:1,
                            Observacion:"Examen",
                            Estado:"Emitido"
                        }
                        carritoRecetas.push(receta)
                        console.log(receta);
                        Reflect.set($data, "carritoRecetas", carritoRecetas);
                         $("select[id=idTipoExamen]").val("null")
                         $("select[id=Examen]").val("null")
                         $("textarea[id=observacionExamne]").val(null)
                    })
                    
                    $("button[id=btnAddReceta]").on("click", function () {
                        const medicamentos1 = $("select[id=idMedicamento]").val();
                        const medicamentos = document.querySelector("select[id='idMedicamento'] option[value='" + medicamentos1 + "']").text;
                        //idReceta, idDoctor,idPaciente, Fecha,Estado
                        
                        //idDetalle Receta, IdReceta, Descripcion, CAntidad, Observcion Estado
                        const tipoMedicamento1 = $("select[id=tipoMedicamento]").val();
                        const tipoMedicamento = document.querySelector("select[id='tipoMedicamento'] option[value='" + tipoMedicamento1 + "']").text;

                        const cantidad = $("input[id=Cantidad]").val();
                        const observacion = $("textarea[id=observacion]").val();
                        
                        const receta={
                            Descripcion:medicamentos+" "+tipoMedicamento, 
                            Cantidad:cantidad,
                            Observacion:observacion,
                            Estado:"Emitido"
                        }
                        
                        carritoRecetas.push(receta)
                        Reflect.set($data, "carritoRecetas", carritoRecetas);
                        $("select[id=idMedicamento]").val("null")
                         $("select[id=tipoMedicamento]").val("null")
                         $("input[id=Cantidad]").val(null)
                         $("textarea[id=observacion]").val(null)
                    })
                    
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

                    $("button[id=btnEnviarReceta]").on("click", function () {
                        const CodePac=$("input[name=CodePac]").val();
                        const CodeDoc=$("input[name=CodeDoc]").val();
                        const CodeAtencio=$("input[name=CodeAtencio]").val();
                        const diagnostico=$("textarea[name=diagnostico]").val();
                        $.post('RecetaAgregar', {
                            CodePac:CodePac,
                            CodeDoc:CodeDoc,
                            CodeAtencio:CodeAtencio,
                            diagnostico:diagnostico,
                            carritoRecetas: JSON.stringify(carritoRecetas),
                            
                        }, function (msg) {
                            console.log(msg);
                        });
                    })


                </script>
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
                    function modifyDoctors(ev) {
                        let value = ev.value.replaceAll("'", "\"");
                        value = JSON.parse(value);
                        console.log(value)
                        //let nombre = document.querySelector("#nombre");               
                        //                let nombre = document.getElementById("nombre");

                        //                nombre.value=value.nombre;
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