<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Sensors</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h2>Sensor Table</h2>


    <div class="col-sm-11">
        <form action="${contextPath}/search/result" method="get">
            <div style="display: inline-block">
                <input type="text" class="form-control" placeholder="Enter text to search" name="searchSensorParam">
            </div>
            <div style="display: inline-block">
                <button class="btn btn-success" type="submit">Go</button>
            </div>
        </form>
    </div>
    <div class="col-sm-1">
        <sec:authorize access="isAuthenticated()">
            <h4><a href="/logout">Выйти</a></h4>
        </sec:authorize>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Edit</th>
            <th>Name</th>
            <th>Model</th>
            <th>Type</th>
            <th>Range</th>
            <th>Unit</th>
            <th>Location</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty sensorsList}">
            <c:forEach items="${sensorsList}" var="sensor">
                <tr>
                    <td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="${contextPath}/edit/sensor?idSensor=${sensor.id}">
                                <button>Edit</button>
                            </a>
                        </sec:authorize>
                    </td>
                    <td title="${sensor.description}">${sensor.name}</td>
                    <td>${sensor.model}</td>
                    <td>${sensor.type}</td>
                    <td>${sensor.rangeFrom}-${sensor.rangeTo}</td>
                    <td>${sensor.unit}</td>
                    <td>${sensor.location}</td>
                    <td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <a href="${contextPath}/delete/sensor?idSensor=${sensor.id}">
                                <button>Delete</button>
                            </a>
                        </sec:authorize>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>


    <a href="${pageContext.request.contextPath}/add/sensor">
        <button>add sensor</button>
    </a>


    <div class="container">
        <ul class="pagination">
            <li>
                <a href="${contextPath}/sensor/pagination?pageNumber=${previous}&pageSize=4&sortField=name&sortDirection=ASC">Previous</a>
            </li>
            <c:if test="${not empty pages}">
                <c:forEach items="${pages}" var="pages">
                    <li>
                        <a href="${contextPath}/sensor/pagination?pageNumber=${pages}&pageSize=4&sortField=name&sortDirection=ASC">${pages}</a>
                    </li>
                </c:forEach>
            </c:if>
            <li>
                <a href="${contextPath}/sensor/pagination?pageNumber=${next}&pageSize=4&sortField=name&sortDirection=ASC">Next</a>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
