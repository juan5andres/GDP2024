[1mdiff --git a/ProgramaGestionDeInventario/src/main/resources/application.properties b/ProgramaGestionDeInventario/src/main/resources/application.properties[m
[1mindex a616975..292ce55 100644[m
[1m--- a/ProgramaGestionDeInventario/src/main/resources/application.properties[m
[1m+++ b/ProgramaGestionDeInventario/src/main/resources/application.properties[m
[36m@@ -1,4 +1,5 @@[m
 spring.application.name=ProgramaGestionDeInventario[m
[32m+[m[32mserver.port=8081[m
 spring.datasource.url=jdbc:postgresql://localhost:5432/sgi[m
 spring.datasource.username=postgres[m
 spring.datasource.password=postgre[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/application.properties b/ProgramaGestionDeInventario/target/classes/application.properties[m
[1mindex a616975..292ce55 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/application.properties[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/application.properties[m
[36m@@ -1,4 +1,5 @@[m
 spring.application.name=ProgramaGestionDeInventario[m
[32m+[m[32mserver.port=8081[m
 spring.datasource.url=jdbc:postgresql://localhost:5432/sgi[m
 spring.datasource.username=postgres[m
 spring.datasource.password=postgre[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/templates/index.html b/ProgramaGestionDeInventario/target/classes/templates/index.html[m
[1mindex c2562e1..fc4bd6b 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/templates/index.html[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/templates/index.html[m
[36m@@ -91,7 +91,7 @@[m
                         <a class="nav-link font-weight-bold text-white" href="/facturacion">Facturación</a>[m
                     </li>[m
                     <li class="nav-item font-weight-bold">[m
[31m-                        <a class="nav-link text-white" href="nosotros">Nosotros</a>[m
[32m+[m[32m                        <a class="nav-link text-white" href="/nosotros">Nosotros</a>[m
                     </li>[m
                     <li class="nav-item font-weight-bold">[m
                         <a class="nav-link text-white donar-button" href="/cerrarSesion">Cerrar sesión</a>[m
[36m@@ -106,7 +106,7 @@[m
     <div class="row justify-content-center">[m
         <div class="col-md-3 col-sm-6 mb-4">[m
             <div class="square fade-in" style="background-image: url('/static/media/proveedor.jpg');">[m
[31m-                <a href="listarProveedores.html">[m
[32m+[m[32m                <a href="/listarProveedores">[m
                     <div class="square-content">[m
                         Proveedor[m
                     </div>[m
[36m@@ -115,7 +115,7 @@[m
         </div>[m
         <div class="col-md-3 col-sm-6 mb-4">[m
             <div class="square fade-in" style="background-image: url('/static/media/almacen.JPG');">[m
[31m-                <a href="listarArticulos.html">[m
[32m+[m[32m                <a href="/listarArticulos">[m
                     <div class="square-content">[m
                         Almacen[m
                     </div>[m
[36m@@ -124,7 +124,7 @@[m
         </div>[m
         <div class="col-md-3 col-sm-6 mb-4">[m
             <div class="square fade-in" style="background-image: url('/static/media/usuario.JPG');">[m
[31m-                <a href="listarUsuarios.html">[m
[32m+[m[32m                <a href="/listarUsuarios">[m
                     <div class="square-content">[m
                         Usuario[m
                     </div>[m
[36m@@ -133,7 +133,7 @@[m
         </div>[m
         <div class="col-md-3 col-sm-6 mb-4">[m
             <div class="square fade-in" style="background-image: url('/static/media/configuracion.JPG');">[m
[31m-                <a href="configuracion.html">[m
[32m+[m[32m                <a href="/configuracion">[m
                     <div class="square-content">[m
                         Configuración[m
                     </div>[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/templates/listarArticulos.html b/ProgramaGestionDeInventario/target/classes/templates/listarArticulos.html[m
[1mindex b544ae7..10422ae 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/templates/listarArticulos.html[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/templates/listarArticulos.html[m
[36m@@ -7,43 +7,101 @@[m
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">[m
   <style>[m
     .form-group {[m
[31m-        margin-bottom: 1rem;[m
[32m+[m[32m      margin-bottom: 1rem;[m
[32m+[m[32m    }[m
[32m+[m[32m    body {[m
[32m+[m[32m      background-image: url('/static/media/fondoIndex.AVIF');[m
[32m+[m[32m      background-size: cover;[m
[32m+[m[32m      background-position: center;[m
[32m+[m[32m      background-attachment: fixed;[m
[32m+[m[32m      backdrop-filter: blur(3px);[m
[32m+[m[32m    }[m
[32m+[m[32m    @keyframes fadeIn {[m
[32m+[m[32m      from {[m
[32m+[m[32m        opacity: 0;[m
[32m+[m[32m        transform: translateY(20px);[m
[32m+[m[32m      }[m
[32m+[m[32m      to {[m
[32m+[m[32m        opacity: 1;[m
[32m+[m[32m        transform: translateY(0);[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m
[32m+[m[32m    .nav-link {[m
[32m+[m[32m      text-shadow: 4px 4px 5px rgba(0, 0, 0, 1.2);[m
[32m+[m[32m    }[m
[32m+[m[32m    .container {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0);[m
[32m+[m[32m    }[m
[32m+[m[32m    .square a {[m
[32m+[m[32m      display: block;[m
[32m+[m[32m      height: 100%;[m
[32m+[m[32m      width: 100%;[m
[32m+[m[32m      text-decoration: none;[m
[32m+[m[32m    }[m
[32m+[m[32m    #articulosTable {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m      margin-top: 50px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_info,[m
[32m+[m[32m    .dataTables_length label {[m
[32m+[m[32m      color: white !important;[m
[32m+[m[32m    }[m
[32m+[m[32m    h1 {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m    }[m
[32m+[m[32m    .content {[m
[32m+[m[32m      margin-top: 250px;[m
[32m+[m[32m      background-color: rgba(0, 0, 0, 0.5);[m
[32m+[m[32m      padding: 20px;[m
[32m+[m[32m      border-radius: 10px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_filter input {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semi-transparente */[m
[32m+[m[32m      color: black; /* Color del texto negro */[m
[32m+[m[32m      border: 1px solid #ccc; /* Borde claro */[m
[32m+[m[32m      border-radius: 4px; /* Bordes redondeados */[m
[32m+[m[32m      padding: 6px; /* Espaciado interno */[m
[32m+[m[32m      width: auto; /* Ajuste de ancho */[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_filter label {[m
[32m+[m[32m      color: white; /* Color del texto del label blanco */[m
[32m+[m[32m      font-weight: bold; /* Texto en negrita */[m
[32m+[m[32m      margin-right: 8px; /* Espaciado a la derecha */[m
     }[m
   </style>[m
 </head>[m
[31m-<body>[m
[31m-[m
[31m-<nav class="navbar navbar-expand-lg navbar-dark bg-primary">[m
[32m+[m[32m<header style="background-color: rgba(255, 255, 255, 0);">[m
   <div class="container">[m
[31m-    <a class="navbar-brand" href="#">[m
[31m-      <img src="/media/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">[m
[31m-      SVG[m
[31m-    </a>[m
[31m-    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"[m
[31m-            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[31m-      <span class="navbar-toggler-icon"></span>[m
[31m-    </button>[m
[31m-    <div class="collapse navbar-collapse" id="navbarNav">[m
[31m-      <ul class="navbar-nav">[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/adminHome}">Inicio</a>[m
[31m-        </li>[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/}">Pagina principal</a>[m
[31m-        </li>[m
[31m-      </ul>[m
[31m-    </div>[m
[31m-    <form action="#" th:action="@{/login}" th:method="post" class="d-flex">[m
[31m-      <input class="btn btn-danger form-control me-2" type="submit" value="Cerrar sesión"[m
[31m-             onclick="return confirm('¿Desea cerrar sesión?');">[m
[31m-    </form>[m
[32m+[m[32m    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(0, 0, 0, 0.5);">[m
[32m+[m[32m      <a class="navbar-brand text-white font-weight-bold" href="#">[m
[32m+[m[32m        SGI[m
[32m+[m[32m      </a>[m
[32m+[m[32m      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[32m+[m[32m        <span class="navbar-toggler-icon"></span>[m
[32m+[m[32m      </button>[m
[32m+[m[32m      <div class="collapse navbar-collapse" id="navbarNav">[m
[32m+[m[32m        <ul class="navbar-nav ml-auto">[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/reportes">Reportes</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/facturacion">Facturación</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white" href="nosotros">Nosotros</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white donar-button" href="/cerrarSesion">Cerrar sesión</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m        </ul>[m
[32m+[m[32m      </div>[m
[32m+[m[32m    </nav>[m
   </div>[m
[31m-</nav>[m
[31m-[m
[31m-<div class="container mt-4">[m
[31m-  <h1>Lista de Artículos</h1>[m
[31m-[m
[31m-  <table id="articulosTable" class="table table-striped">[m
[32m+[m[32m</header>[m
[32m+[m[32m<body>[m
[32m+[m[32m<div class="container content">[m
[32m+[m[32m  <h1 class="text-center">Lista de Artículos</h1>[m
[32m+[m[32m  <table id="articulosTable" class="table table-striped table-dark">[m
     <thead>[m
     <tr>[m
       <th>Nombre</th>[m
[36m@@ -74,17 +132,23 @@[m
     </tbody>[m
   </table>[m
 </div>[m
[31m-[m
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>[m
 <script>[m
[31m-    $(document).ready(function() {[m
[31m-        $('#articulosTable').DataTable({[m
[31m-            "order": [[0, "asc"]][m
[31m-        });[m
[32m+[m[32m  $(document).ready(function() {[m
[32m+[m[32m    $('#articulosTable').DataTable({[m
[32m+[m[32m      "order": [[0, "asc"]],[m
[32m+[m[32m      "paging": true,[m
[32m+[m[32m      "searching": true,[m
[32m+[m[32m      "lengthChange": true,[m
[32m+[m[32m      "info": true,[m
[32m+[m[32m      "pageLength": 10,[m
[32m+[m[32m      "language": {[m
[32m+[m[32m        "url": "//cdn.datatables.net/plug-ins/1.10.25/i18n/Spanish.json"[m
[32m+[m[32m      }[m
     });[m
[32m+[m[32m  });[m
 </script>[m
[31m-[m
 </body>[m
 </html>[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/templates/listarProveedores.html b/ProgramaGestionDeInventario/target/classes/templates/listarProveedores.html[m
[1mindex a65b3cc..aa6a6f1 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/templates/listarProveedores.html[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/templates/listarProveedores.html[m
[36m@@ -6,44 +6,98 @@[m
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">[m
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">[m
   <style>[m
[31m-        .form-group {[m
[31m-            margin-bottom: 1rem;[m
[31m-        }[m
[31m-    </style>[m
[31m-</head>[m
[31m-<body>[m
[32m+[m[32m    .form-group {[m
[32m+[m[32m      margin-bottom: 1rem;[m
[32m+[m[32m    }[m
[32m+[m[32m    body {[m
[32m+[m[32m      background-image: url('/static/media/fondoIndex.AVIF');[m
[32m+[m[32m      background-size: cover;[m
[32m+[m[32m      background-position: center;[m
[32m+[m[32m      background-attachment: fixed;[m
[32m+[m[32m      backdrop-filter: blur(3px);[m
[32m+[m[32m    }[m
[32m+[m[32m    @keyframes fadeIn {[m
[32m+[m[32m      from {[m
[32m+[m[32m        opacity: 0;[m
[32m+[m[32m        transform: translateY(20px);[m
[32m+[m[32m      }[m
[32m+[m[32m      to {[m
[32m+[m[32m        opacity: 1;[m
[32m+[m[32m        transform: translateY(0);[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m
[32m+[m[32m    .nav-link {[m
[32m+[m[32m      text-shadow: 4px 4px 5px rgba(0, 0, 0, 1.2);[m
[32m+[m[32m    }[m
[32m+[m[32m    .container {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0);[m
[32m+[m[32m    }[m
[32m+[m[32m    .square a {[m
[32m+[m[32m      display: block;[m
[32m+[m[32m      height: 100%;[m
[32m+[m[32m      width: 100%;[m
[32m+[m[32m      text-decoration: none;[m
[32m+[m[32m    }[m
[32m+[m[32m    #proveedoresTable {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m      margin-top: 50px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_info,[m
[32m+[m[32m    .dataTables_length label {[m
[32m+[m[32m      color: white !important;[m
[32m+[m[32m    }[m
[32m+[m[32m    h1 {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m    }[m
[32m+[m[32m    .content {[m
[32m+[m[32m      margin-top: 250px;[m
[32m+[m[32m      background-color: rgba(0, 0, 0, 0.5);[m
[32m+[m[32m      padding: 20px;[m
[32m+[m[32m      border-radius: 10px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_filter input {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semi-transparente */[m
[32m+[m[32m      color: black; /* Color del texto negro */[m
[32m+[m[32m    }[m
[32m+[m
[32m+[m[32m    .dataTables_filter label {[m
[32m+[m[32m      color: white; /* Color del texto del label blanco */[m
[32m+[m[32m    }[m
 [m
[31m-<nav class="navbar navbar-expand-lg navbar-dark bg-primary">[m
[32m+[m[32m  </style>[m
[32m+[m[32m</head>[m
[32m+[m[32m<header style="background-color: rgba(255, 255, 255, 0);">[m
   <div class="container">[m
[31m-    <a class="navbar-brand" href="#">[m
[31m-      <img src="/media/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">[m
[31m-      SVG[m
[31m-    </a>[m
[31m-    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"[m
[31m-            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[31m-      <span class="navbar-toggler-icon"></span>[m
[31m-    </button>[m
[31m-    <div class="collapse navbar-collapse" id="navbarNav">[m
[31m-      <ul class="navbar-nav">[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/adminHome}">Inicio</a>[m
[31m-        </li>[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/}">Pagina principal</a>[m
[31m-        </li>[m
[31m-      </ul>[m
[31m-    </div>[m
[31m-    <form action="#" th:action="@{/login}" th:method="post" class="d-flex">[m
[31m-      <input class="btn btn-danger form-control me-2" type="submit" value="Cerrar sesión"[m
[31m-             onclick="return confirm('¿Desea cerrar sesión?');">[m
[31m-    </form>[m
[32m+[m[32m    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(0, 0, 0, 0.5);">[m
[32m+[m[32m      <a class="navbar-brand text-white font-weight-bold" href="#">[m
[32m+[m[32m        SGI[m
[32m+[m[32m      </a>[m
[32m+[m[32m      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[32m+[m[32m        <span class="navbar-toggler-icon"></span>[m
[32m+[m[32m      </button>[m
[32m+[m[32m      <div class="collapse navbar-collapse" id="navbarNav">[m
[32m+[m[32m        <ul class="navbar-nav ml-auto">[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/reportes">Reportes</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/facturacion">Facturación</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white" href="/nosotros">Nosotros</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white donar-button" href="/cerrarSesion">Cerrar sesión</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m        </ul>[m
[32m+[m[32m      </div>[m
[32m+[m[32m    </nav>[m
   </div>[m
[31m-</nav>[m
[31m-[m
[31m-<div class="container mt-4">[m
[31m-  <h1>Lista de Proveedores</h1>[m
[31m-[m
[31m-  <table id="proveedoresTable" class="table table-striped">[m
[32m+[m[32m</header>[m
[32m+[m[32m<body>[m
[32m+[m[32m<div class="container content">[m
[32m+[m[32m  <h1 class="text-center">Lista de Proveedores</h1>[m
[32m+[m[32m  <table id="proveedoresTable" class="table table-striped table-dark">[m
     <thead>[m
     <tr>[m
       <th>Nombre</th>[m
[36m@@ -57,7 +111,6 @@[m
     </tr>[m
     </thead>[m
     <tbody>[m
[31m-    <!-- Los datos reales se deben llenar usando Thymeleaf en un entorno real -->[m
     <tr th:each="proveedor : ${proveedores}">[m
       <td th:text="${proveedor.nombre}">Nombre</td>[m
       <td th:text="${proveedor.email}">Email</td>[m
[36m@@ -71,17 +124,22 @@[m
     </tbody>[m
   </table>[m
 </div>[m
[31m-[m
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>[m
 <script>[m
[31m-    $(document).ready(function() {[m
[31m-        $('#proveedoresTable').DataTable({[m
[31m-            "order": [[0, "asc"]][m
[31m-        });[m
[32m+[m[32m  $(document).ready(function() {[m
[32m+[m[32m    $('#proveedoresTable').DataTable({[m
[32m+[m[32m      "paging": true,[m
[32m+[m[32m      "searching": true,[m
[32m+[m[32m      "lengthChange": true,[m
[32m+[m[32m      "info": true,[m
[32m+[m[32m      "pageLength": 10,[m
[32m+[m[32m      "language": {[m
[32m+[m[32m        "url": "//cdn.datatables.net/plug-ins/1.10.25/i18n/Spanish.json"[m
[32m+[m[32m      }[m
     });[m
[32m+[m[32m  });[m
 </script>[m
[31m-[m
 </body>[m
 </html>[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/templates/listarUsuarios.html b/ProgramaGestionDeInventario/target/classes/templates/listarUsuarios.html[m
[1mindex 5b94f76..37330d4 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/templates/listarUsuarios.html[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/templates/listarUsuarios.html[m
[36m@@ -6,44 +6,102 @@[m
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">[m
   <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css">[m
   <style>[m
[31m-        .form-group {[m
[31m-            margin-bottom: 1rem;[m
[31m-        }[m
[31m-    </style>[m
[32m+[m[32m    .form-group {[m
[32m+[m[32m      margin-bottom: 1rem;[m
[32m+[m[32m    }[m
[32m+[m[32m    body {[m
[32m+[m[32m      background-image: url('/static/media/fondoIndex.AVIF');[m
[32m+[m[32m      background-size: cover;[m
[32m+[m[32m      background-position: center;[m
[32m+[m[32m      background-attachment: fixed;[m
[32m+[m[32m      backdrop-filter: blur(3px);[m
[32m+[m[32m    }[m
[32m+[m[32m    @keyframes fadeIn {[m
[32m+[m[32m      from {[m
[32m+[m[32m        opacity: 0;[m
[32m+[m[32m        transform: translateY(20px);[m
[32m+[m[32m      }[m
[32m+[m[32m      to {[m
[32m+[m[32m        opacity: 1;[m
[32m+[m[32m        transform: translateY(0);[m
[32m+[m[32m      }[m
[32m+[m[32m    }[m
[32m+[m[32m    .nav-link {[m
[32m+[m[32m      text-shadow: 4px 4px 5px rgba(0, 0, 0, 1.2);[m
[32m+[m[32m    }[m
[32m+[m[32m    .container {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0);[m
[32m+[m[32m    }[m
[32m+[m[32m    .square a {[m
[32m+[m[32m      display: block;[m
[32m+[m[32m      height: 100%;[m
[32m+[m[32m      width: 100%;[m
[32m+[m[32m      text-decoration: none;[m
[32m+[m[32m    }[m
[32m+[m[32m    #usuariosTable {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m      margin-top: 50px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_info,[m
[32m+[m[32m    .dataTables_length label {[m
[32m+[m[32m      color: white !important;[m
[32m+[m[32m    }[m
[32m+[m[32m    h1 {[m
[32m+[m[32m      color: white;[m
[32m+[m[32m    }[m
[32m+[m[32m    .content {[m
[32m+[m[32m      margin-top: 250px;[m
[32m+[m[32m      background-color: rgba(0, 0, 0, 0.5);[m
[32m+[m[32m      padding: 20px;[m
[32m+[m[32m      border-radius: 10px;[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_filter input {[m
[32m+[m[32m      background-color: rgba(255, 255, 255, 0.8); /* Fondo blanco semi-transparente */[m
[32m+[m[32m      color: black; /* Color del texto negro */[m
[32m+[m[32m      border: 1px solid #ccc; /* Borde claro */[m
[32m+[m[32m      border-radius: 4px; /* Bordes redondeados */[m
[32m+[m[32m      padding: 6px; /* Espaciado interno */[m
[32m+[m[32m      width: auto; /* Ajuste de ancho */[m
[32m+[m[32m    }[m
[32m+[m[32m    .dataTables_filter label {[m
[32m+[m[32m      color: white; /* Color del texto del label blanco */[m
[32m+[m[32m      font-weight: bold; /* Texto en negrita */[m
[32m+[m[32m      margin-right: 8px; /* Espaciado a la derecha */[m
[32m+[m[32m    }[m
[32m+[m[32m  </style>[m
 </head>[m
[31m-<body>[m
[31m-[m
[31m-<nav class="navbar navbar-expand-lg navbar-dark bg-primary">[m
[32m+[m[32m<header style="background-color: rgba(255, 255, 255, 0);">[m
   <div class="container">[m
[31m-    <a class="navbar-brand" href="#">[m
[31m-      <img src="/media/logo.png" alt="" width="30" height="24" class="d-inline-block align-text-top">[m
[31m-      SVG[m
[31m-    </a>[m
[31m-    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"[m
[31m-            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[31m-      <span class="navbar-toggler-icon"></span>[m
[31m-    </button>[m
[31m-    <div class="collapse navbar-collapse" id="navbarNav">[m
[31m-      <ul class="navbar-nav">[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/adminHome}">Inicio</a>[m
[31m-        </li>[m
[31m-        <li class="nav-item">[m
[31m-          <a class="nav-link" th:href="@{/}">Pagina principal</a>[m
[31m-        </li>[m
[31m-      </ul>[m
[31m-    </div>[m
[31m-    <form action="#" th:action="@{/login}" th:method="post" class="d-flex">[m
[31m-      <input class="btn btn-danger form-control me-2" type="submit" value="Cerrar sesión"[m
[31m-             onclick="return confirm('¿Desea cerrar sesión?');">[m
[31m-    </form>[m
[32m+[m[32m    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(0, 0, 0, 0.5);">[m
[32m+[m[32m      <a class="navbar-brand text-white font-weight-bold" href="#">[m
[32m+[m[32m        SGI[m
[32m+[m[32m      </a>[m
[32m+[m[32m      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">[m
[32m+[m[32m        <span class="navbar-toggler-icon"></span>[m
[32m+[m[32m      </button>[m
[32m+[m[32m      <div class="collapse navbar-collapse" id="navbarNav">[m
[32m+[m[32m        <ul class="navbar-nav ml-auto">[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/reportes">Reportes</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item">[m
[32m+[m[32m            <a class="nav-link font-weight-bold text-white" href="/facturacion">Facturación</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white" href="nosotros">Nosotros</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m          <li class="nav-item font-weight-bold">[m
[32m+[m[32m            <a class="nav-link text-white donar-button" href="/cerrarSesion">Cerrar sesión</a>[m
[32m+[m[32m          </li>[m
[32m+[m[32m        </ul>[m
[32m+[m[32m      </div>[m
[32m+[m[32m    </nav>[m
   </div>[m
[31m-</nav>[m
[31m-[m
[31m-<div class="container mt-4">[m
[31m-  <h1>Lista de Usuarios</h1>[m
[31m-[m
[31m-  <table id="usuariosTable" class="table table-striped">[m
[32m+[m[32m</header>[m
[32m+[m[32m<body>[m
[32m+[m[32m<div class="container content">[m
[32m+[m[32m  <h1 class="text-center">Lista de Usuarios</h1>[m
[32m+[m[32m  <table id="usuariosTable" class="table table-striped table-dark">[m
     <thead>[m
     <tr>[m
       <th>Nombre</th>[m
[36m@@ -54,6 +112,7 @@[m
     </tr>[m
     </thead>[m
     <tbody>[m
[32m+[m[32m    <!-- Los datos reales se deben llenar usando Thymeleaf en un entorno real -->[m
     <tr th:each="usuario : ${usuarios}">[m
       <td th:text="${usuario.nombre}">Nombre</td>[m
       <td th:text="${usuario.apellido}">Apellido</td>[m
[36m@@ -64,17 +123,23 @@[m
     </tbody>[m
   </table>[m
 </div>[m
[31m-[m
 <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>[m
 <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>[m
 <script>[m
[31m-    $(document).ready(function() {[m
[31m-        $('#usuariosTable').DataTable({[m
[31m-            "order": [[0, "asc"]][m
[31m-        });[m
[32m+[m[32m  $(document).ready(function() {[m
[32m+[m[32m    $('#usuariosTable').DataTable({[m
[32m+[m[32m      "order": [[0, "asc"]],[m
[32m+[m[32m      "paging": true,[m
[32m+[m[32m      "searching": true,[m
[32m+[m[32m      "lengthChange": true,[m
[32m+[m[32m      "info": true,[m
[32m+[m[32m      "pageLength": 10,[m
[32m+[m[32m      "language": {[m
[32m+[m[32m        "url": "//cdn.datatables.net/plug-ins/1.10.25/i18n/Spanish.json"[m
[32m+[m[32m      }[m
     });[m
[32m+[m[32m  });[m
 </script>[m
[31m-[m
 </body>[m
 </html>[m
[1mdiff --git a/ProgramaGestionDeInventario/target/classes/templates/login.html b/ProgramaGestionDeInventario/target/classes/templates/login.html[m
[1mindex 8b40539..bf5bb47 100644[m
[1m--- a/ProgramaGestionDeInventario/target/classes/templates/login.html[m
[1m+++ b/ProgramaGestionDeInventario/target/classes/templates/login.html[m
[36m@@ -2,53 +2,96 @@[m
 <html lang="en">[m
 <head>[m
     <meta charset="UTF-8">[m
[31m-    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />[m
[32m+[m[32m    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">[m
     <title>Login Prueba</title>[m
 [m
[31m-    <link rel="stylesheet" href="/static/login.css"/>[m
[31m-	<script src="https://kit.fontawesome.com/94b10fad32.js" crossorigin="anonymous"></script>[m
[31m-    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">[m
[31m-	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"[m
[31m-		integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">[m
[32m+[m[32m    <link rel="stylesheet" href="/static/login.css">[m
[32m+[m[32m    <script src="https://kit.fontawesome.com/94b10fad32.js" crossorigin="anonymous"></script>[m
[32m+[m[32m    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"[m
[32m+[m[32m          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">[m
[32m+[m[32m    <style>[m
[32m+[m[32m        body {[m
[32m+[m[32m            background-image: url('/static/media/fondoIndex.AVIF');[m
[32m+[m[32m            background-size: cover;[m
[32m+[m[32m            background-position: center;[m
[32m+[m[32m            background-attachment: fixed;[m
[32m+[m[32m            height: 100vh;[m
[32m+[m[32m            margin: 0;[m
[32m+[m[32m            display: flex;[m
[32m+[m[32m            justify-content: center;[m
[32m+[m[32m            align-items: center;[m
[32m+[m[32m            backdrop-filter: blur(5px);[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        .login-form {[m
[32m+[m[32m            margin: 0 auto;[m
[32m+[m[32m            background-color: rgba(213, 201, 201, 0.8);[m
[32m+[m[32m            border: 1px solid #ccc;[m
[32m+[m[32m            border-radius: 10px;[m
[32m+[m[32m            padding: 20px;[m
[32m+[m[32m            max-width: 400px;[m
[32m+[m[32m            width: 100%;[m
[32m+[m[32m            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3);[m
[32m+[m[32m        }[m
[32m+[m
[32m+[m[32m        .footer {[m
[32m+[m[32m            position: absolute;[m
[32m+[m[32m            bottom: 0;[m
[32m+[m[32m            left: 0;[m
[32m+[m[32m            width: 100%;[m
[32m+[m[32m            text-align: center;[m
[32m+[m[32m            background-color: rgba(213, 201, 201, 0.8);[m
[32m+[m[32m            padding: 5px 0;[m
[32m+[m[32m        }[m
[32m+[m[32m    </style>[m
 </head>[m
[31m-<body class="login-page d-flex p-lg-3 align-items-center justify-content-center ">[m
[31m-    <div class="d-flex justify-content-end border-secondary-subtle rounded-4 bg-white overflow-hidden w-50 h-50">[m
[31m-[m
[31m-			<div class="container col-12 col-lg-6 d-flex flex-column justify-content-center align-items-center pe-3 h-100">[m
[31m-				<form class="h-75 d-flex flex-column justify-content-evenly"  method="post">[m
[31m-					<div>[m
[31m-						<h3 class="fs-2 fw-bold text-center m-4 text-dark-emphasis">¡Bienvenido!</h3>[m
[31m-					</div>[m
[31m-					<div>[m
[31m-						<div class="input-group mb-4">[m
[31m-							<span class="input-group-text bg-transparent border-0 border-bottom border-secondary border-2 rounded-0" id="basic-addon1"><i class="fas fa-user" style="color: #737373;"></i></span>[m
[31m-							<input type="text" id="username" name="username" class="login-input form-control border-0 focus-ring focus-ring-light border-bottom border-secondary border-2 rounded-0" placeholder="Nombre de usuario" aria-label="Username" autofocus>[m
[31m-						</div>[m
[31m-						<div class="input-group pt-1 mb-4">[m
[31m-							<span class="input-group-text bg-transparent border-0 border-bottom border-secondary border-2 rounded-0" id="basic-addon1"><i class="fas fa-key" style="color: #737373;"></i></span>[m
[31m-							<input type="password" id="password" name="password" class="login-input form-control border-0 focus-ring focus-ring-light border-bottom border-secondary border-2 rounded-0" placeholder="Contraseña" aria-label="Password">[m
[31m-						</div>[m
[31m-					</div>[m
[31m-					<div>[m
[31m-						<button type="submit" value="Log in" class="w-100 btn btn-success fw-semibold py-1">INGRESAR</button>[m
[31m-						<div class="m-0 d-flex justify-content-center align-items-center pt-2">[m
[31m-							<button class="btn btn-light btn-custom">[m
[31m-                <img src="https://img.icons8.com/color/48/000000/google-logo.png" alt="Google" width="20" height="20">[m
[31m-                Enlazar con Google[m
[31m-            </button>[m
[31m-                        </div>[m
[31m-					</div>[m
[31m-				</form>[m
[31m-      </div>[m
[31m-		</div>[m
[31m-		<footer class="w-100 align-self-end position-absolute position-absolute bottom-0 start-0">[m
[31m-			<p class="text-secondary lh-1 mt-0 m-2">© Estudiantes Unnoba</p>[m
[31m-		</footer>[m
[31m-[m
[31m-	</div>[m
[31m-[m
[31m-[m
[31m-    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>[m
[31m-<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>[m
[32m+[m[32m<body>[m
[32m+[m[32m<div class="container">[m
[32m+[m[32m    <div class="login-form">[m
[32m+[m[32m        <form th:action="@{/login}" method="post">[m
[32m+[m[32m            <h3 class="fs-2 fw-bold text-center mb-4">¡Bienvenido!</h3>[m
[32m+[m
[32m+[m[32m            <div class="input-group mb-4">[m
[32m+[m[32m                <span class="input-group-text bg-transparent border-0 border-bottom border-secondary border-2 rounded-0"[m
[32m+[m[32m                      id="basic-addon1"><i class="fas fa-user" style="color: #737373;"></i></span>[m
[32m+[m[32m                <input type="text" id="username" name="username"[m
[32m+[m[32m                       class="login-input form-control border-0 focus-ring focus-ring-light border-bottom border-secondary border-2 rounded-0"[m
[32m+[m[32m                       placeholder="Nombre de usuario o email" aria-label="Username" autofocus required>[m
[32m+[m[32m            </div>[m
[32m+[m
[32m+[m[32m            <div class="input-group mb-4">[m
[32m+[m[32m                <span class="input-group-text bg-transparent border-0 border-bottom border-secondary border-2 rounded-0"[m
[32m+[m[32m                      id="basic-addon1"><i class="fas fa-key" style="color: #737373;"></i></span>[m
[32m+[m[32m                <input type="password" id="password" name="password"[m
[32m+[m[32m                       class="login-input form-control border-0 focus-ring focus-ring-light border-bottom border-secondary border-2 rounded-0"[m
[32m+[m[32m                       placeholder="Contraseña" aria-label="Password" required>[m
[32m+[m[32m            </div>[m
[32m+[m
[32m+[m[32m            <button type="submit" value="Log in"[m
[32m+[m[32m                    class="w-100 btn btn-dark fw-semibold py-1">INGRESAR</button>[m
[32m+[m
[32m+[m[32m            <div class="m-0 d-flex justify-content-center align-items-center pt-2">[m
[32m+[m[32m                <button type="button" class="btn btn-light btn-custom">[m
[32m+[m[32m                    <img src="https://img.icons8.com/color/48/000000/google-logo.png" alt="Google" width="20"[m
[32m+[m[32m                         height="20">[m
[32m+[m[32m                    Enlazar con Google[m
[32m+[m[32m                </button>[m
[32m+[m[32m            </div>[m
[32m+[m[32m        </form>[m
[32m+[m[32m    </div>[m
[32m+[m[32m</div>[m
[32m+[m
[32m+[m[32m<footer class="footer">[m
[32m+[m[32m    <p class="text-secondary lh-1 mt-0 m-2">[m
[32m+[m[32m        <span class="text-shadow">© Estudiantes Unnoba</span>[m
[32m+[m[32m    </p>[m
[32m+[m[32m</footer>[m
[32m+[m
[32m+[m[32m<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"[m
[32m+[m[32m        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"[m
[32m+[m[32m        crossorigin="anonymous"></script>[m
[32m+[m[32m<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"[m
[32m+[m[32m        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"[m
[32m+[m[32m        crossorigin="anonymous"></script>[m
 </body>[m
[31m-</html>[m
\ No newline at end of file[m
[32m+[m[32m</html>[m
