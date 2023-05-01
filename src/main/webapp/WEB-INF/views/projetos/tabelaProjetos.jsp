<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:forEach var="projeto" items="${projetos}">
    <tr>
        <td>${projeto.id}</td>
        <td>${projeto.nome}</td>
        <td>${projeto.descricao}</td>
        <td><fmt:formatDate value="${projeto.dataInicio}" pattern="dd/MM/yyyy" /></td>
        <td><fmt:formatDate value="${projeto.dataPrevisaoTermino}" pattern="dd/MM/yyyy" /></td>
        <td>
            <c:if test="${empty projeto.dataRealTermino}">
                <span>Data não definida</span>
            </c:if>
            <c:if test="${not empty projeto.dataRealTermino}">
                <fmt:formatDate value="${projeto.dataRealTermino}" pattern="dd/MM/yyyy" />
            </c:if>
        </td>
        <td>${projeto.orcamentoTotal}</td>
        <td>${projeto.gerenteResponsavel.nome}</td>
        <td>${projeto.empresa.nome}</td>
        <td>${projeto.risco}</td>
        <td>${projeto.status}</td>
        <td>
            <a href="<c:url value='/projetos/${projeto.id}/editar'/>">Editar</a>
            <a href="<c:url value='/projetos/${projeto.id}/deletar'/>">Excluir</a>
        </td>
    </tr>
</c:forEach>