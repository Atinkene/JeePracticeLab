<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.Utilisateur" %>
<%@ include file="../inc/header.jsp" %>

 <script>
        function confirmerSuppression(id, nom, prenom) {
            const nomComplet = prenom + ' ' + nom;
            if (confirm('Êtes-vous sûr de vouloir supprimer l\'utilisateur "' + nomComplet + '" ?\n\nCette action est irréversible.')) {
                window.location.href = '<%= request.getContextPath() %>/supprimer?id=' + id;
            }
            return false;
        }
  </script>

<section class="container">
    <h2>Liste des utilisateurs</h2>
    
    <%
        String success = (String) session.getAttribute("success");
        String error = (String) session.getAttribute("erreur");

        if (success != null) {
            session.removeAttribute("success");
    %>
        <div class="message success">${success}</div>
    <%
        }

        if (error != null) {
            session.removeAttribute("erreur");
    %>
        <div class="message error">${error}</div>
    <%
        }
    %>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Prénom</th>
                <th>Nom</th>
                <th>Login</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Utilisateur> utilisateurs = (List<Utilisateur>) request.getAttribute("utilisateurs");
            if (utilisateurs != null && !utilisateurs.isEmpty()) {
                for (Utilisateur u : utilisateurs) {
                    // Stocker l'utilisateur courant dans pageContext pour EL
                    pageContext.setAttribute("u", u);
        %>
            <tr>
                <td>${u.id}</td>
                <td>${u.prenom}</td>
                <td>${u.nom}</td>
                <td>${u.login}</td>
                <td class="actions">
                    <a href="${pageContext.request.contextPath}/modifier?id=${u.id}"
                       class="action-link"
                       title="Modifier cet utilisateur">
                        Modifier
                    </a>
                    <span class="separator">|</span>
                    <a href="#"
                       onclick="return confirmerSuppression(${u.id}, '${u.nom}', '${u.prenom}');"
                       class="action-link delete"
                       title="Supprimer cet utilisateur">
                        Supprimer
                    </a>
                </td>
            </tr>
        <%
                }
            } else {
        %>
            <tr>
                <td colspan="5" class="empty-state">
                    <p>Aucun utilisateur trouvé</p>
                    <p style="font-size: 14px; color: #999;">Commencez par ajouter votre premier utilisateur</p>
                </td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
    
    <div class="btn-container">
        <a class="btn" href="${pageContext.request.contextPath}/addUser">
            + Ajouter un utilisateur
        </a>
    </div>
</section>

<%@ include file="../inc/footer.jsp" %>