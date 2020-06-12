<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
  <head>
    <title>Customer Confirmation</title>
  </head>

  <body>
    <h1>Customer Confirmation successful!1!1oneone!</h1>
    <p>
      Customer confirmed:
      ${customer.firstName}
      ${customer.lastName}
      (free passes: ${customer.freePasses})
      (postal code: ${customer.postalCode})
      (course code: ${customer.courseCode})
    </p>
  </body>
</html>
