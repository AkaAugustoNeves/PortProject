<%@ include file="../base/cabecalho.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Criar Projeto</h5>
        </div>
        <div class="modal-body">
          <form action="/projetos/novo" method="post">
            <div class="form-group">
              <label for="nome">Nome:</label>
              <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="form-group">
              <label for="descricao">Descrição:</label>
              <textarea class="form-control" id="descricao" name="descricao"></textarea>
            </div>
            <div class="form-group">
              <label for="dataInicio">Data de Início:</label>
              <input type="date" class="form-control" id="dataInicio" name="dataInicio">
            </div>
            <div class="form-group">
              <label for="dataPrevisaoTermino">Data de Previsão de término:</label>
              <input type="date" class="form-control" id="dataPrevisaoTermino" name="dataPrevisaoTermino">
            </div> 
            <div class="form-group">
              <label for="orcamentoTotal">Orçamento Total:</label>
              <input type="number" class="form-control" id="orcamentoTotal" name="orcamentoTotal">
            </div>
            <div class="form-group">
              <label for="gerenteResponsavel">Gerente Responsável:</label>
              <select class="form-control" id="gerenteResponsavel" name="gerenteResponsavel.id">
                <c:forEach items="${gerentes}" var="gerente">
                  <option value="${gerente.id}">${gerente.nome}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group">
              <label for="empresa">Empresa:</label>
              <select class="form-control" id="empresa" name="empresa.id">
                <c:forEach items="${empresas}" var="empresa">
                  <option value="${empresa.id}">${empresa.nome}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group">
              <label for="risco">Risco:</label>
              <select class="form-control" id="risco" name="risco">
                <c:forEach items="${riscos}" var="risco">
                  <option value="${risco}">${risco}</option>
                </c:forEach>
              </select>
            </div>
            <div class="form-group">
              <label for="risco">Status:</label>
              <select class="form-control" id="risco" name="risco">
                <c:forEach items="${status}" var="status">
                  <option value="${status}">${status}</option>
                </c:forEach>
              </select>
            </div>
            <button type="submit" class="btn btn-primary">Criar</button>
          </form>
        </div>
      </div>
    </div>
  </div>
<%@ include file="../base/rodape.jsp" %>