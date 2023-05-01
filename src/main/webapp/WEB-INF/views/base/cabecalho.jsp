<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html:5>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>PortProject</title>
    <style>
      <%@include file="/WEB-INF/views/base/css/style.css"%>
    </style>     
    
  </head>
  <body>
    <div class="container">
      <header>
        <div class="header-itens">
          <img src="https://go.trader.ca/wp-content/uploads/2022/02/250X250.png" alt="logo">
        </div>
        <div class="header-itens"></div>
        <div class="header-itens">
          <a href="/projetos">Inicio</a>
          <a href="<c:url value='/projetos/novo'/>">novo</a>
        </div>
      </header>
      


