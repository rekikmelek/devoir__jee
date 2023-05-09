<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>IIT</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
<link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="Css/fontawesome.min.css" rel="stylesheet" type="text/css">
<script src="Css/all.min.js"></script>
</head>
<body>
<%@include file="header.jsp" %>
<p></p>
<div class="container">
<div class="card">
  <div class="card-header">    Recherche des Enseignant  </div>
  <div class="card-body">
      <form action="chercherensgn.do" method="get">
        <label>Mot Clé</label>
        <input type="text" name="motCle1" value="${model1.motCle1}"/>
       <button type="submit" class="btn btn-primary" title="Rechercher"><i class="fas fa-search"></i></button>
      </form>     
<table class="table table-striped table-bordered">
        <tr>
            <th style="text-align: center;">#</th>
          <th style="text-align: center;">ID</th>
          <th style="text-align: center;">Nom</th>
          <th style="text-align: center;">Prenom</th>
          <th style="text-align: center;">Matricule</th>
          <th style="text-align: center;">Statut</th>
          <th style="text-align: center;">Heures</th>  
		  <th style="text-align: center;" title="Nombre d'heures restantes">N.H.Restant</th>
          <th style="text-align: center;">Suppression</th>
          <th style="text-align: center;">Edition</th>
          <th style="text-align: center;">Visualiser</th>
          <th style="text-align: center;">Autorisation</th>  
         </tr>
<c:forEach items="${model1.enseignants}" var="en" varStatus="loop">
   <tr>
      <td style="text-align: center;">${loop.index + 1}</td>
      <td style="text-align: center;">${en.id_enseignant}</td>
      <td style="text-align: center;">${en.nom}</td>
      <td style="text-align: center;">${en.prenom}</td>
      <td style="text-align: center;">${en.matricule}</td>
      <td style="text-align: center;">${en.statut}</td>
      <td style="text-align: center;">${en.heur}</td>
	  <td style="text-align: center;">${208 - en.heur}</td>
      <td style="text-align: center;" title="Supprimer cet Enseignant"><a onclick="return confirm('Etes-vous sûr ?')" href="supprimerEnseignant.do?id=${en.id_enseignant}"><i class="fa fa-trash" style="color: red;"></i></a></td>
	  <td style="text-align: center;" title="Editer cet Enseignant"><a href="editerEnseignant.do?id=${en.id_enseignant}"><i class="fas fa-edit" style="color: #4CAF50;"></i></a></td>	
	  <td style="text-align: center;" title="Voir cet Enseignant">  <a href="voirEnseignant.do?id=${en.id_enseignant}">    <i class="fas fa-eye" style="color: #FFA500;"></i>  </a></td>	
	  <td style="text-align: center;" ${en.heur > 208 ? 'style="display:none"' : ''} title="${en.heur > 208 ? 'Nombre d\'heures dépassé' : 'Saisir une autorisation d\'enseigner'}"><a href="autEnse.do?id=${en.id_enseignant}"><i class="fas fa-check-circle"></i></a></td>
   </tr>
</c:forEach>

      </table>
  </div>
</div>
</div>
</body>
</html>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    
    th {
        background-color: #4CAF50;
        color: white;
    }
    
    tr:hover {
        background-color: #f5f5f5;
    }
    
    .card {
        margin-top: 20px;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
    }
    
    .card-header {
        background-color: #4CAF50;
        color: white;
        padding: 10px;
    }
    
    .card-body {
        padding: 10px;
    }
    
    label {
        display: inline-block;
        width: 100px;
        margin-right: 10px;
    }
    
    input[type="text"] {
        width: 200px;
        padding: 5px;
        border-radius: 4px;
        border: 1px solid #ccc;
    }
    
    button[type="submit"] {
        padding: 5px 10px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    
    a {
        color: #007bff;
        text-decoration: none;
    }
    
    a:hover {
        text-decoration: underline;
    }
    
    .hide {
        display: none;
    }
</style>
