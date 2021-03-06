<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
  <head>
    <title>Student Registration Form</title>
  </head>
  <body>
    <h1></h1>
    <form:form action="processForm" modelAttribute="student">
      First name: <form:input path="firstName" />
      <br />

      Last name: <form:input path="lastName" />
      <br />

      Favourite language:
      <br />
      <form:radiobutton path="favouriteLanguage" value="Java" /> Java
      <form:radiobutton path="favouriteLanguage" value="Haskell" /> Haskell
      <form:radiobutton path="favouriteLanguage" value="Ruby" /> Ruby
      <form:radiobutton path="favouriteLanguage" value="Python" /> Python
      <br />

      Favourite operating system:
      <form:checkbox path="operatingSystems" value="ArchLinux" /> ArchLinux
      <form:checkbox path="operatingSystems" value="Ubuntu" /> Ubuntu
      <form:checkbox path="operatingSystems" value="Fedora" /> Fedora
      <form:checkbox path="operatingSystems" value="NixOS" /> NixOS
      <br />

      Country:
      <form:select path="country">
        <form:options items="${student.countryOptions}" />
      </form:select>
      <br />

      <input type="submit" value="Submit" />
    </form:form>
  </body>
</html>
