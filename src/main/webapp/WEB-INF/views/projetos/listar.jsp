<%@ include file="../base/cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<main>
    <div class="title-button">
        <div class="title">
            <div class="title-txt">
                <h1>projetos</h1>
            </div>
            <div class="title-options">
                <label for="risco">Risco:</label>
                <select class="form-control" id="filtro-risco" name="filtro-risco">
                    <option value="" selected>--Selecione--</option>
                    <c:forEach items="${riscos}" var="risco">
                    <option value="${risco}">${risco}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="button">
            
        </div>
    </div>
    <div class="table">
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
            <tbody id="tabela-projetos" >
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
    </div>     
    <script>
        document.getElementById('filtro-risco').addEventListener('change', function() {
        var risco = this.value;
        console.log(risco);
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById('tabela-projetos').innerHTML = this.responseText;
            }
        };
        xhr.open('GET', '/projetos/filtro?filtro-risco=' + risco);
        xhr.send();
        });

    </script>   
<%@ include file="../base/rodape.jsp" %>