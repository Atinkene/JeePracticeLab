<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="beans.Utilisateur" %>

<%
    Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur");
    String erreur = (String) request.getAttribute("erreur");
%>

<%@ include file="../inc/header.jsp" %>

<div class="form-container">
    <h2>Modifier un utilisateur</h2>

    <% if (erreur != null) { %>
        <div class="error"><%= erreur %></div>
    <% } %>

    <form method="post" action="<%= request.getContextPath() %>/modifier">
    
        <input type="hidden" name="id" value="<%= utilisateur != null ? utilisateur.getId() : "" %>" />

        <div class="form-group">
            <label for="prenom">Prénom <span class="required">*</span></label>
            <input type="text" 
                   id="prenom" 
                   name="prenom" 
                   value="<%= utilisateur != null ? utilisateur.getPrenom() : "" %>" 
                   required 
                   maxlength="50" />
        </div>

        <div class="form-group">
            <label for="nom">Nom <span class="required">*</span></label>
            <input type="text" 
                   id="nom" 
                   name="nom" 
                   value="<%= utilisateur != null ? utilisateur.getNom() : "" %>" 
                   required 
                   maxlength="50" />
        </div>

        <div class="form-group">
            <label for="login">Login <span class="required">*</span></label>
            <input type="text" 
                   id="login" 
                   name="login" 
                   value="<%= utilisateur != null ? utilisateur.getLogin() : "" %>" 
                   required 
                   maxlength="30" />
        </div>

        <div class="form-group">
            <label for="password">Mot de passe <span class="required">*</span></label>
            <input type="password" 
                   id="password" 
                   name="password" 
                   value="<%= utilisateur != null ? utilisateur.getPassword() : "" %>" 
                   required 
                   minlength="4" />
        </div>

        <div class="button-group">
            <button type="button" onclick="window.location.href='<%= request.getContextPath() %>/list'">Annuler</button>
            <button type="submit">Enregistrer</button>
        </div>
    </form>
</div>

<%@ include file="../inc/footer.jsp" %>
