<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Add/edit sensor</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        .error {
            color: red;
            font-weight: bold;
        }
    </style>

</head>
<body>
<div class="container">
    <h2>Add/edit</h2>
    <form:form method="POST" action="${contextPath}/add/sensor/new" modelAttribute="sensor">
        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" placeholder="name" type="text"/>
            <form:errors path="name" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="model">Model</label>
            <form:input path="model" placeholder="model" type="text"/>
            <form:errors path="model" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="range">Range:</label>
            From <input name="rangeFrom" type="text" id="range">
            To <input name="rangeTo" type="text" id="range1">
        </div>
        <div class="form-group">
            <label for="type">Type:</label>
            <form:select path="type">
                <form:option value="Pressure" label="Pressure"/>
                <form:option value="Voltage" label="Voltage"/>
                <form:option value="Temperature" label="Temperature"/>
                <form:option value="Humidity" label="Humidity"/>
            </form:select>
            <form:errors path="type" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="unit">Unit</label>
            <form:select path="unit">
                <form:option value="bar" label="bar"/>
                <form:option value="Voltage" label="Voltage"/>
                <form:option value="C" label="C"/>
                <form:option value="%" label="%"/>
            </form:select>
            <form:errors path="unit" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="location">Location</label>
            <form:input path="location" placeholder="location" type="text"/>
            <form:errors path="location"/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <form:input path="description" placeholder="descriptiom" type=":textarea"/>
            <form:errors path="description"/>
        </div>
        <button type="submit" class="btn btn-secondary">Save</button>
        <button type="reset" class="btn btn-secondary">Cancel</button>
    </form:form>
</div>

</body>
</html>
