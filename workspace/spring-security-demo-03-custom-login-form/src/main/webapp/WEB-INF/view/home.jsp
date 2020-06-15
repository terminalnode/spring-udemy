<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Super Secure Company Website</title>
  </head>

  <body>
    <h1>Howdy there cowboy!</h1>
    <p>
      Could it be...? You must be the infamous <security:authentication property="principal.username" />!
      The greatest <security:authentication property="principal.authorities" /> in all the land!
    </p>

    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
      <input type="submit" value="Log out" />
    </form:form>
  </body>
</html>
