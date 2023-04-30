<%@ include file="../base/cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<main>
    <h1>Listar projetos</h1>
    <a href="<c:url value='/projetos/novo'/>">novo</a>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Data de Início</th>
                    <th>Data de Previsão de Término</th>
                    <th>Data de Real Término</th>
                    <th>Orçamento Total</th>
                    <th>Gerente Responsável</th>
                    <th>Empresa</th>
                    <th>Risco</th>
                    <th>Status</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
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
            </tbody>
        </table>

        
<%@ include file="../base/rodape.jsp" %>