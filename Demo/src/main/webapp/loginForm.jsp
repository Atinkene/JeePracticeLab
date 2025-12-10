<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de connexion</title>
</head>

<style>
	body {
		width : 100%;
		height : 100vh;
		display : flex;
		justify-content : center;
		align-items : center
	}
	
	form {
		border : 1px black solid;
		padding : 50px;
		border-radius : 25px;
		display : flexbox;
	}
	
	input {
		border : 1.5px black solid; 
		margin : 5px;
		padding : 5px;
		border-radius : 15px;
		
	}
	
	button {
		border : 1px gray solid; 
		margin : 5px;
		padding : 10px;
		border-radius : 15px;
		background-color : black;
		color : white;
		font-weight : bold;
	}
	
	button:hover {
		background-color : white;
		color : black;
		border : 1.5px black dashed;
		cursor : pointer;
	
	}
	
	.champs {
		display : flex;
		justify-content : center;
		align-items : center
	}
	
	h1 {
		text-align : center; 
		padding-bottom : 20px;
	}
	
	.extendeAction {
		margin-top : 30px;
		font-size : small;
		display : flex;
		justify-content : center;
		align-items : center;
		margin-inline : 5px; 
		width : 100%
	}
	
	a {
		margin : auto;
		color : gray
	}
	
	a:hover {
		color : black;
		text-decoration-style: dashed;
		cursor : pointer;
	}
</style>

<body>
	<form action="connexion" method="post">
		<h1>Connexion</h1>
		<div class="champs" >
			<input type="text" placeholder="Nom d'utilisateur" name="login" required><br>
			<input type="password" placeholder="Mot de passe" name="password" required><br>
			<button>Se connecter</button>
		</div>
		<div class="extendeAction">
			<a>J'ai oublié mon mot de passe</a>
			<span> | </span>
			<a>Je n'ai pas de compte</a>
		</div>
	</form>
</body>
</html>