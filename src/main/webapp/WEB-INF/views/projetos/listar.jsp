<%@ include file="../base/cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="content">
    <h1 class="content__title">projetos</h1>
    <main class="content__section">
        <div class="datatable">
            <div class="datatable__filters">
                <div class="input-group">
                    <label for="risco">Risco:</label>
                    <select class="form-control" id="filtro-risco" name="filtro-risco">
                        <option value="" selected>--Selecione--</option>
                        <c:forEach items="${riscos}" var="risco">
                        <option value="${risco}">${risco}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br>
            <table class="datatable__table">
                <thead>
                    <tr>
                      <th>ID</th>
                      <th>Nome</th>
                      <th class="lg-field">Descrição</th>
                      <th class="md-field">Data de Início</th>
                      <th class="xl-field">Data de Previsão de Término</th>
                      <th class="lg-field">Data de Real Término</th>
                      <th class="xl-field">Orçamento Total</th>
                      <th class="md-field">Gerente Responsável</th>
                      <th class="xl-field">Empresa</th>
                      <th>Risco</th>
                      <th>Status</th>
                      <th>Ações</th>
                    </tr>
                </thead>
                <tbody id="tabela-projetos">
                    <c:forEach var="projeto" items="${projetos}">
                        <tr>
                            <td>${projeto.id}</td>
                            <td>${projeto.nome}</td>
                            <td class="lg-field">${projeto.descricao}</td>
                            <td class="md-field"><fmt:formatDate value="${projeto.dataInicio}" pattern="dd/MM/yyyy" /></td>
                            <td class="xl-field"><fmt:formatDate value="${projeto.dataPrevisaoTermino}" pattern="dd/MM/yyyy" /></td>
                            <td class="lg-field">
                                <c:if test="${empty projeto.dataRealTermino}">
                                    <span>Data não definida</span>
                                </c:if>
                                <c:if test="${not empty projeto.dataRealTermino}">
                                    <fmt:formatDate value="${projeto.dataRealTermino}" pattern="dd/MM/yyyy" />
                                </c:if>
                            </td>
                            <td class="xl-field">${projeto.orcamentoTotal}</td>
                            <td class="md-field">${projeto.gerenteResponsavel.nome}</td>
                            <td class="xl-field">${projeto.empresa.nome}</td>
                            <td>${projeto.risco}</td>
                            <td>${projeto.status}</td>
                            <td>
                                <a href="<c:url value='/projetos/${projeto.id}/funcionarios'/>">
                                    <img src="https://tinypic.host/images/2023/05/02/funcionarios.png" alt="funcionarios.png" border="0" />
                                </a>
                                <a href="<c:url value='/projetos/${projeto.id}/editar'/>">
                                    <img src="https://tinypic.host/images/2023/05/02/lapis.png" alt="lapis.png" border="0" />
                                </a>
                                <a href="<c:url value='/projetos/${projeto.id}/deletar'/>">
                                    <img src="https://tinypic.host/images/2023/05/02/lixeira.png" alt="lixeira.png" border="0" />
                                </a> 
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
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