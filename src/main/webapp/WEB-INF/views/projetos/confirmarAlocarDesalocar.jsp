<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../base/cabecalho.jsp" %>
<main>
    <div class="container">
        
        <h1>${acao} Usuario:</h1>
        <p>Deseja realmente ${acao}, o usuario ${pessoa.nome} do projeto ${projeto.nome}?</p>
        <button class="btn btn-default" id="acao-button">${acao}</button>
        
        <script>
        document.getElementById('acao-button').addEventListener('click', function() {
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '/projetos/${projeto.id}/${acao}/${pessoa.id}');
            xhr.send();
            setTimeout(function() {
                window.location.replace("/projetos/${projeto.id}/funcionarios");
            }, 700);
        });
        
        </script>
    </div>
</main>

<%@ include file="../base/rodape.jsp" %>