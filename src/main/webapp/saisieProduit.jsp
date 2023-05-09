<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert Enseignant</title>
<link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">
    Saisie des Enseignant
  </div>
  <div class="card-body">
      <form action="save.do" method="post">
      <div class="form-group">
       <label class="control-label">Nom Enseignant :</label>
       <input type="text" name="Nom" class="form-control"/>
      </div>
      <div class="form-group">
       <label class="control-label">Prenom Enseignant :</label>
       <input type="text" name="Prenom" class="form-control"/>
      </div>
      
      
      <div class="form-group">
       <label class="control-label">Matricule :</label>
       <input type="text" name="matricule" class="form-control"/>
      </div>
      <div>
      <div class="form-group">
       <label class="control-label">Statut :</label>
       <input type="text" name="Statut" class="form-control"/>
      </div>
   <div class="form-group">
       <label class="control-label">Heures :</label>
       <input type="text" name="heur" class="form-control" value="0" readonly/>
      </div>
      
      <div>
        <button type="submit" class="btn btn-primary">Ajouter</button>
      </div>
      </form>     
     
  </div>
</div>
</div>
</body>
</html>
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

  input[readonly] {
    cursor: text;
  }
</style>
