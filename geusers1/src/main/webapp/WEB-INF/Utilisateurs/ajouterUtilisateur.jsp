<%@ include file="../inc/header.jsp" %>

<div class="form-container">
    <h2>Ajouter un utilisateur</h2>

    <form method="post">
        <input type="text" name="prenom" placeholder="Prénom" required />
        <input type="text" name="nom" placeholder="Nom" required />
        <input type="text" name="login" placeholder="Login" required />
        <input type="password" name="password" placeholder="Mot de passe" required />
        <button type="submit">Enregistrer</button>
    </form>
</div>

<%@ include file="../inc/footer.jsp" %>
