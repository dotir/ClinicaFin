<%@page import="modelo.DaoDirecciones"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <link href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css" rel="stylesheet" />

<html>
    <head>
        

     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dependent Select Option</title>
        </style>
    </head>
    <body>
        <div class ="col-lg-12" style="padding-top:8px;">
            <div class="card">
                <div class="card-header">
                    SELECT ANIDADO
                </div>
                <div class="card-body"
                <div class="row">                
                    <div class="col-lg-4">
                        <label for="">Departamento:</label>
                        <select class="js-example-basic-single" name="state"
                                id="sel_departamento" style="width:100%">
                        </select>
                    </div>
                    <div>
                        <select name="doctor" class="form-control" aria-label="Default select example">
                        <option selected>Eliga el doctor</option>
                        <% for (int i = 0; i < obj.obtenerDoctores().size(); i++) {    
                        %>
                        <option value="<%=i%>"><%= obj.obtenerDoctores().get(i) %></option>
                        <% } %>
                        </select>                        
                    </div>
                    <div class="col-lg-4">
                        <label for="">Provincia:</label>
                        <select class="js-example-basic-single" name="state" id="sel_provincia"
                                id="sel_provincia" style="width:100%">
                        </select>
                    </div>
                    <div class="col-lg-4">
                        <label for="">Distrito:</label>
                        <select class="js-example-basic-single" name="state" id="sel_distrito"
                                id="sel_distrito" style="width:100%">
                        </select>
                    </div>
                </div>
            </div>  
            </div>
        </div>
        
    </body>
</html>
<script src="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/js/select2.min.js"></script>
<script>
    $(document).ready(function(){
        $('.js-example-basic-single').select2();
    });
</script>