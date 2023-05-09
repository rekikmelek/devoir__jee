<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<link href="Css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<% String alertMessage = (String) request.getAttribute("alertMessage");
   if (alertMessage != null) {
       out.println("<script>alert('" + alertMessage + "');</script>");
   }
%>
<%@include file="header.jsp" %>
<p></p>

<div class="container">
<div class="card">

  <div class="card-header">
    Autorisation des Enseignant
  </div>
  <div class="card-body">
      <form action="autorisation.do" method="post"  onsubmit="return checkForm()">
      <div class="form-group"  >
       <label class="control-label">ID Enseignant :</label>
       <input required type="text" name="enseignant_id" class="form-control" value="${enseignant.id_enseignant}"/>
      </div>
        <div class="form-group"  >
       <label class="control-label">NOM :</label>
       <input required type="text" name="nom" class="form-control" value="${enseignant.nom}"/>
      </div>
        <div class="form-group"  >
       <label class="control-label">Prenom :</label>
       <input required type="text" name="prenom" class="form-control" value="${enseignant.prenom}"/>
      </div>
      <div class="form-group"  >
       <label class="control-label">Matricule :</label>
       <input required type="text" name="matricule" class="form-control" value="${enseignant.matricule}"/>
      </div>
       <div class="form-group">
       <label class="control-label">Institute :</label>
       <input required type="text" name="institut" class="form-control" />
      </div>
      <div class="form-group">
       <label class="control-label">Module :</label>
       <input required type="text" name="module" class="form-control" />
      </div>
      <div class="form-group">
       <label class="control-label">Matiere :</label>
       <input required type="text" name="matiere" class="form-control"/>
      </div>
      <div class="form-group">
       <label class="control-label">Date :</label>
       <input required type="date" name="date" class="form-control"/>
      </div>
       <div class="form-group"  hidden >
       <label class="control-label">Heur :</label>
       <input  type="text" name="heurre" class="form-control" value="${enseignant.heur}"/>
      </div>
      <div class="form-group" >
       <label class="control-label">Heures :</label>
 <input required type="text" name ="nb_heure" id="heurInput" onkeyup="checkHeurValue(event)" class="form-control"  >

      </div>
<button onclick="/recupens.do" type="submit" class="btn btn-primary">Confirmer</button>
      </div>
      </form>     
  </div>
</div>
</div>
</body>
</html>

<script>
		function checkHeurValue(event) {
			var heurInput = document.getElementById("heurInput");
			var heur = heurInput.value;
			   
	        if (heur > 4) {
	            alert("Attention!!! La valeur des heures ne doit pas dépasser 4.");
	        }
	        
	        if (heur < 1) {
	            alert("Attention!!! La valeur des heures doit être supérieure à 0.");
	        }
		}
</script>
<script>
    function checkForm() {
        var inputs = document.getElementsByTagName("input");
        for (var i = 0; i < inputs.length; i++) {
            var input = inputs[i];
            if (input.getAttribute("required") && input.value.trim() === "") {
                alert("Veuillez remplir tous les champs obligatoires.");
                return false;
            }
        }
        return true;
    }
</script>
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
    
.button printButton{
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


<style>
  input[readonly] {
    cursor: text;
  }
</style>
