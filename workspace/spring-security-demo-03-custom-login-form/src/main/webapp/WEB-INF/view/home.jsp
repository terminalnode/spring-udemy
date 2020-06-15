<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
  <head>
    <title>Super Secure Company Website</title>
  </head>

  <body>
    <h1>Howdy there cowboy!</h1>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" value="Log out" />
    </form:form>
  </body>
</html>
