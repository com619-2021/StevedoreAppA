<%-- 
    Document   : header
    Created on : Jan 4, 2020, 11:19:01 AM
    Author     : cgallen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<!-- start of header.jsp -->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/navbar/">

    <title>${contextPath}</title>

    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    
    <!--Luke CSS Links-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="${contextPath}/resources/packages/bootstrap5/css/bootstrap-datetimepicker.css" rel="stylesheet">



    <script src="${contextPath}/resources/packages/bootstrap5/js/bootstrap-datetimepicker.js"></script> 
    <script src="${contextPath}/resources/packages/bootstrap5/js/locales/bootstrap-datetimepicker.uk.js"></script>

    <script src="https://kit.fontawesome.com/6faefcd79e.js" crossorigin="anonymous"></script>


</head>

<body>

<header>

    <!-- Static navbar -->
    <nav class="navbar navbar-expand-lg navbar-light pb-10 mb-10 navigation">
        <div class="container-fluid">
            <a class="navbar-brand">
                <img id="headerPageLogo" src="../stevedore/images/logo.png" alt="Stevedore Logo">
            </a>
<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ms-auto">

                    <!-- this jstl should work but problems with multiple if statements -->
                    <!-- selected page = ${selectedPage} home ${'home'.equals(selectedPage) } about ${'about'.equals(selectedPage) } contact ${'contact'.equals(selectedPage) }-->
                    <!--<li <c:if test="${'home'.equals(selectedPage) }"> class="active"  </c:if> ><a href="${contextPath}/home">Home</a></li>-->
                    <!-- this raw java code works !! -->
                    <li  class="nav-item"<% if ("home".equals(request.getAttribute("selectedPage"))) {%> class="active"  <% } %> ><a
                            class="nav-link" href="${contextPath}/home">Home</a></li>
                    <li class="nav-item"<% if ("addUsersToParty".equals(request.getAttribute("selectedPage"))) {%> class="nav-link active"  <% } %> ><a
                            class="nav-link" href="${contextPath}/addUsersToParty">Create Order</a></li>

                    <sec:authorize access="hasRole('ROLE_GLOBAL_ADMIN')">
                 <li class="nav-item"<% if ("resource".equals(request.getAttribute("selectedPage"))) {%> class="nav-link active"  <% } %> ><a
                            class="nav-link" href="${contextPath}/resource">Resource Inventory</a></li>
                    <li class="nav-item"<% if ("catalog".equals(request.getAttribute("selectedPage"))) {%> class="nav-link active"  <% }%> ><a
                            class="nav-link" href="${contextPath}/catalog">Resource Catalogue</a></li>
<div class="dropdown">
  <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false">
    Admin
  </a>

  <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
      <li><a href="${contextPath}/users" class="nav-link">Manage Users</a></li>
                                <li><a href="${contextPath}/partys" class="nav-link">Manage Partys</a></li>
  </ul>
</div>
                            
                    </sec:authorize>

                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <c:if test="${pageContext.request.userPrincipal.name == null}">
                        <li><a href="${contextPath}/login">Login or create a new Account</a></li>
                    </c:if>
                    <c:if test="${pageContext.request.userPrincipal.name != null}">
                        <form id="logoutForm" method="POST" action="${contextPath}/logout">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                        <form id="profile" method="GET" action="${contextPath}/viewModifyUser">
                            <input type="hidden" name="username" value="${pageContext.request.userPrincipal.name}"/>
                        </form>
                        <p class="text-muted"> Welcome ${pageContext.request.userPrincipal.name}&nbsp;&nbsp;
                            <a onclick="document.forms['logoutForm'].submit()">Logout</a><BR>
                            <a onclick="document.forms['profile'].submit()">User Profile</a></p>
                    </c:if>
                </ul>
            </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
    </nav>
</header>
<!-- end of header.jsp -->