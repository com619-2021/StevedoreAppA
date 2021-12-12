<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> 
    <link href="${contextPath}/resources/css/style.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
   

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
    <div class="container">
        <div class="loginFormCenter">
            <div class="loginFormContent">

                <img id="loginPageLogo" src="images/logo.png" alt="Stevedore Logo">
                <div class="loginSubHeading">Login to manage service orders</div>
                <hr />    
                <form method="POST" action="${contextPath}/login">
                        <h3 class="form-heading">Log in</h3>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                              <span>${message}</span>
                              <input name="username" type="text" class="form-control" id="usernameInput" placeholder="Username"
                                     autofocus="true"/>
                        </div>

                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <span>${message}</span>
                           <input name="password" type="password" class="form-control" id="passwordInput" placeholder="Password"/>
                           <span>${error}</span>
                         </div>
                <hr />         
                        <div class="form-group ${error != null ? 'has-error' : ''}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <button class="btn btn-primary loginBtn" type="submit">Log In</button>
                            <h4 class="text-center"><a href="${contextPath}/registration">Create a new account</a></h4>
                            <h4 class="text-center"><a href="${contextPath}/home">Return to home page</a></h4>

                         </div>  
                    </form>       
            </div> <!-- loginFormContent--->    
        </div><!-- loginFormCenter--->  
    </div>
    <!-- /container -->
    
    <script src="./resources/js/jquery.min.js"></script>
    <script src="./resources/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    
</body>
</html>
