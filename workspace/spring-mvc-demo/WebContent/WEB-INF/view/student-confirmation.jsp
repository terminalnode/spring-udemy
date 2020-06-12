<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
  <head>
    <title>Student Confirmation</title>
  </head>

  <body>
    <h1></h1>
    <p>
      Student confirmed: ${student.firstName} ${student.lastName}
    </p>

    <p>
      Country: ${student.country}
    </p>

    <p>
      Favourite language: ${student.favouriteLanguage}
    </p>

    <p>
      Favourite operating system(s):
      <ul>
        <c:forEach var="temp" items="${student.operatingSystems}">
          <li>${temp}</li>
        </c:forEach>
      </ul>
    </p>
  </body>
</html>
