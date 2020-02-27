<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Registration</h1>
    <form:form modelAttribute="registerAtr">
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <form:input path="name" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button>Add Registration </button>
                </td>

            </tr>
        </table>

    </form:form>
</body>
</html>
