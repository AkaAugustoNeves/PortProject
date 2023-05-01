<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../base/cabecalho.jsp" %>

<main>
    ${projeto.nome} <br>
    ${projeto.descricao}<br>
    ${projeto.dataInicio}<br>
    ${projeto.dataPrevisaoTermino}<br>
    ${projeto.dataRealTermino}<br>
    ${projeto.orcamentoTotal}<br>
    ${projeto.gerenteResponsavel.nome}<br>
    ${projeto.empresa.nome}<br>
    ${projeto.risco}<br>
    ${projeto.status}<br>


    <c:choose>
        <c:when test="${projeto.status == 'INICIADO' || projeto.status == 'EM_ANDAMENTO' || projeto.status == 'CANCELADO'}">
            <p>rapaz tem como deletar não viu, por causa do status</p>
        </c:when>
        <c:otherwise>
            <h2>Confirmar Deleção</h2>
            <p>Tem certeza que deseja deletar o projeto <strong>${projeto.nome}</strong>?</p>
            <form method="post" action="/projetos/${projeto.id}/deletar">
                <input type="hidden" name="_method" value="PUT">
                <button type="submit" class="btn btn-danger">Deletar</button>
                <a href="/projetos" class="btn btn-secondary">Cancelar</a>
            </form>
        </c:otherwise>
    </c:choose>
<%@ include file="../base/rodape.jsp" %>