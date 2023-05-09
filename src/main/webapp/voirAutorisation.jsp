<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
    <title>Editer Autorisation</title>
    <link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="Css/fontawesome.min.css" rel="stylesheet" type="text/css">
</head>
<body>
    <%@include file="header.jsp" %>
    <p></p>
    <div class="container">
        <div class="card">
            <div class="card-header">
                Editer Autorisation
            </div>
            <div class="card-body">
                <form action="updateAutorisation.do" method="post">
                    <div class="form-group">
                        <label class="control-label">ID Autorisation:</label>
                        <input type="text" name="id" class="form-control" value="${autorisation.id}" readonly />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Institut:</label>
                        <input type="text" name="institut" class="form-control" value="${autorisation.institut}" readonly />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Module:</label>
                        <input type="text" name="module" class="form-control" value="${autorisation.module}" readonly />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Matiere:</label>
                        <input type="text" name="matiere" class="form-control" value="${autorisation.matiere}" readonly/>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nombre d'heures:</label>
                        <input type="text" name="nb_heure" class="form-control" value="${autorisation.nb_heure}" readonly />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Date:</label>
                        <input type="text" name="date" class="form-control" value="${autorisation.date}" readonly/>
                    </div>
                    <div class="form-group">
                        <a href="chercherensgn.do?motCle1=" class="btn btn-secondary">Retour</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
<style>
  input[readonly] {
    cursor: text;
  }
</style>
<style>
.card-header {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
    }
   button[type="submit"] {
 		margin: 10px;     
        padding: 5px 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

  .form-group label {
    font-weight: bold;
  }

  .form-control[readonly] {
    background-color: #e9ecef;
    cursor: not-allowed;
  }

  .btn-primary {
    background-color: #007bff;
    border-color: #007bff;
  }

  .btn-primary:hover {
    background-color: #0069d9;
    border-color: #0062cc;
  }
</style>
