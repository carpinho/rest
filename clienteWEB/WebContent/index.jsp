<!DOCTYPE html>
<html>
 <head>
  <title>Form to create a new resource</title>
  <script>
  	function ejecutar(accion){
  		alert(accion);
  		document.getElementById("elemento").a
  		return;
  	}
  </script>
 </head>
<body>
  <form id="elemento" action="pruebaREST">
	  <label for="id">ID</label>
	  <input name="id" />
	  <br/>
	  <label for="summary">Summary</label>
	  <input name="summary" />
	  <br/>
	  Description:
	  <TEXTAREA NAME="description" COLS=40 ROWS=6></TEXTAREA>
	  <br/>
	  <input type="submit" value="Insertar" name="accion"/>
	  <input type="submit" value="Actualizar" name="accion"/>
	  <input type="submit" value="Eliminar" name="accion"/>
	  <input type="submit" value="Resultado" name="accion"/>
  </form>
</body>
</html>