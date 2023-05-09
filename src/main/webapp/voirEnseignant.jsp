<%@ page language="java" contentType="text/html; charset=windows-1256" pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>View</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
<link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="Css/fontawesome.min.css" rel="stylesheet" type="text/css">
<script src="Css/all.min.js"></script>
<style>
.card-header {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
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

  .table {
    width: 100%;
    border-collapse: collapse;
  }

  .table th,
  .table td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
  }

  .table th {
    background-color: #f2f2f2;
    font-weight: bold;
  }

  .table tr:hover {
    background-color: #f5f5f5;
  }
</style>

</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
  <div class="card">
    <div class="card-header">
      Visualiser l'Enseignant
    </div>
    <div class="card-body">
      <form action="updateEnseignant.do" method="post">
        <div hidden class="form-group">
          <label class="control-label">ID Enseignant:</label>
          <input type="text" name="id" class="form-control" value="${enseignant.id_enseignant}" readonly />
        </div>
        <div class="form-group">
          <label class="control-label">Nom:</label>
          <input type="text" name="nom" class="form-control" value="${enseignant.nom}" readonly />
        </div>
        <div class="form-group">
          <label class="control-label">Prenom:</label>
          <input type="text" name="prenom" class="form-control" value="${enseignant.prenom}" readonly />
        </div>
        <div class="form-group">
          <label class="control-label">Matricule:</label>
          <input type="text" name="matricule" class="form-control" value="${enseignant.matricule}" readonly />
        </div>
        <div class="form-group">
          <label class="control-label">Statut:</label>
          <input type="text" name="statut" class="form-control" value="${enseignant.statut}" readonly />
        </div>
        <div class="form-group">
          <label class="control-label">Heures:</label>
          <input type="text" name="heur" class="form-control" value="${enseignant.heur}" readonly />
        </div>
        
        <h3>Autorisations:</h3>
        <table class="table">
          <thead>
            <tr>
            
              <th style="text-align: center;">#</th>
              <th style="text-align: center;">ID</th>
              <th style="text-align: center;">Institut</th>
              <th style="text-align: center;">Module</th>
              <th style="text-align: center;">Matiere</th>
              <th style="text-align: center;">Nombre d'heures</th>
              <th style="text-align: center;">Date</th>
              <th style="text-align: center;">Suppression</th>
	          <th style="text-align: center;">Edition</th>
    	      <th style="text-align: center;">Visualiser</th>

              
            </tr>
          </thead>
          <tbody>
            <c:forEach 
             items="${autorisations}" var="autorisation" varStatus="loop">
              <tr>
                <td style="text-align: center;">${loop.index + 1}</td>
                <td style="text-align: center;">${autorisation.id}</td>       
                <td style="text-align: center;">${autorisation.institut}</td>
                <td style="text-align: center;">${autorisation.module}</td>
                <td style="text-align: center;">${autorisation.matiere}</td>
                <td style="text-align: center;">${autorisation.nb_heure}</td>
                <td style="text-align: center;">${autorisation.date}</td>                                
<td style="text-align: center;"><a href="supprimerAutorisation.do?id=${autorisation.id}" onclick="return confirm('Etes-vous sûr ?')" title="Supprimer cette autorisation"> <i class="fa fa-trash" style="color: red;"></i></a></td>
<td style="text-align: center;"><a href="editerAutorisation.do?id=${autorisation.id}" title="Editer cette autorisation"><i class="fas fa-edit" style="color: #4CAF50;"></i></a></td>
<td style="text-align: center;"><a href="voirAutorisation.do?id=${autorisation.id}" title="Voir cette autorisation"><i class="fas fa-eye" style="color: #FFA500;"></i></a></td>              
              </tr>
            </c:forEach>
          </tbody>
        </table>
        
      </form>
    </div>
  </div>
</div>
</body>
</html>
