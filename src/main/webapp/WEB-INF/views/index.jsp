<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bare - Start Bootstrap Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <style>
        body {
            padding-top: 70px;
            /* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
        }
    </style>



</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Customer data</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div id="content" class="container">

    <div id="container" class="container">
        <h3>The columns titles are merged with the filters inputs thanks to the placeholders attributes</h3>
        <hr>
        <p>Inspired by this <a href="http://bootsnipp.com/snippets/featured/panel-tables-with-filter">snippet</a></p>
        <div class="row">
            <div class="panel panel-primary filterable">
                <div class="panel-heading">
                    <h3 class="panel-title">Users</h3>

                </div>
                <span id="value"></span>
                <div id="feedback"></div>
                <form:form id="form" method="POST" commandName="customer" >
                    <table id="customerTable" class="table" >
                            <thead>
                            <tr class="filters">
                                    <th><form:input type="text" class="form-control" placeholder="ID" path="id" readonly="true"  /></th>
                                    <th><form:input type="text" class="form-control" placeholder="First Name" path="firstName" readonly="true" /></th>
                                    <th><form:input type="text" class="form-control" placeholder="Last Name" path="lastName" readonly="true" /></th>
                                    <th><form:input type="text" class="form-control" placeholder="Patronymic Name" path="patronymicName" readonly="true" /></th>
                                    <th style="display: none;"><form:input type="text" class="form-control" placeholder="id Number" id="phoneId" path="phoneNumber.id" readonly="true" /></th>
                                    <th><form:input type="text" class="form-control" placeholder="Phone Number" id="phone" path="phoneNumber.phoneNumber" /></th>
                                    <th>
                                        <form:select  id="phoneType" cssClass="form-control selcls" path="phoneNumber.type" >
                                            <form:option value="${customer.phoneNumber.type}" label="${customer.phoneNumber.type}" />

                                            <c:forEach var="type" items="${lisType}">
                                                <form:option value="${type}" label="${type}" />
                                            </c:forEach>
                                        </form:select>
                                    </th>
                                    <th><form:input type="text" class="form-control" placeholder="Comment" id="phoneComment" path="phoneNumber.comment" /></th>
                                    <th><input type="submit" class="btn btn-primary" id="submit" name="submit" value="Save" ></th>
                            </tr>
                            </thead>
                        <tbody id="tbody">

                        <c:forEach var="customer" items="${listCustomer}">
                            <tr>
                                <td>${customer.id}</td>
                                <td>${customer.firstName}</td>
                                <td>${customer.lastName}</td>
                                <td>${customer.patronymicName}</td>
                                <td>${customer.phoneNumber.phoneNumber}</td>
                                <td>${customer.phoneNumber.type}</td>
                                <td>${customer.phoneNumber.comment}</td>
                                <td><a id="edit" onclick="" href="/edit/${customer.id}">edit</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form:form>
            </div>
        </div>
    </div>


</div>
<!-- /.container -->

<!-- jQuery Version 1.11.1 -->
<script src="<c:url value="/resources/js/jquery.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!-- Ajax form -->
<script src="<c:url value="/resources/js/ajaxForm.js"/>"></script>


</body>

</html>