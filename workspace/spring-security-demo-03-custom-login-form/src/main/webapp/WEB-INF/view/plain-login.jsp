<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Super Secure Company Website - Login</title>
  </head>

  <body>
    <form:form action="${pageContext.request.contextPath}/auth" method="POST">
    <c:if test="${param.error != null}">
      <p><i>
        Invalid credentials! Do not try again!
      </i></p>
    </c:if>

    <p>
      Username: <input type="text" name="username" />
    </p>

    <p>
      Password: <input type="password" name="password" />
    </p>
    
    <input type="submit" value="Login" />
    </form:form>
  </body>
</html>
