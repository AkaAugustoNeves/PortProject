<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../base/cabecalho.jsp" %>
<main>
    <div class="container">

        <h1>Projeto: ${projeto.nome}</h1>
        
        
        <div class="panel panel-default">
            <table class="table">
                <h2>integrantes:</h2>
                <div class="panel-heading">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                </div>
                <div class="panel-body">
                    <c:forEach var="integrante" items="${integrantes}">
                        <tr>
                            <td>${integrante.nome}</td>
                            <td>
                                <a href="<c:url value='/projetos/${projeto.id}/DESALOCAR/${integrante.id}'/>">Desalocar</a>
                            </td>
                        </tr>
                    </c:forEach>
                </div>
            </table>
        </div>

    <div class="panel panel-default">
        <table class="table">
            <h2>Outros Funcionarios:</h2>
            <div class="panel-heading">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
            </div>
            <div class="panel-body">
                <c:forEach var="funcionario" items="${funcionarios}">
                    <tr>
                        <td>${funcionario.nome}</td>
                        <td>
                            <a href="<c:url value='/projetos/${projeto.id}/ALOCAR/${funcionario.id}'/>">Alocar</a>
                        </td>
                    </tr>
                </c:forEach>
            </div>
        </table>
    </div>
</main>
<%@ include file="../base/rodape.jsp" %>