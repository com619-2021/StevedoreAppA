<%-- 
    Document   : content
    Created on : Jan 4, 2020, 11:19:47 AM
    Author     : cgallen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- start of resource.jsp selectedPage=${selectedPage}-->
<jsp:include page="header.jsp"/>

<!-- Begin page content -->
<main role="main" class="container">
    <div>
        <h1>Manage Resources</h1>
        <p>showing ${abstractResourceListSize} resources: </p>
        <div class="container table-responsive tableContainer backgroundBlur curvedEdges">
            <div class="manageOrdersTitle">Manage Orders</div>
            <table class="table table-hover">
                <thead class="thead-table">
                <tr>
                    <th scope="col">Order ID</th>
                    <th scope="col">Order Type</th>
                    <th scope="col">Order Date</th>
                    <th scope="col">Destination</th>
                    <th scope="col">Order Status</th>
                    <th scope="col">Order Description</th>
                    <th scope="col">End Date</th>
                    <th scope="col">Edit</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${abstractResourceList}" var="abstractResource">
                    <tr>
                        <td>${abstractResource.id}</td>
                        <td>${abstractResource.orderType}</td>
                        <td>${abstractResource.orderDate}</td>
                        <td>${abstractResource.name}</td>
                        <td>${abstractResource.orderStatus}</td>
                        <td>${abstractResource.description}</td>
                        <td>${abstractResource.endDate}</td>
                        <td>
                            <form action="./viewModifyResource" method="GET">
                                <input type="hidden" name="abstractResourceUuid" value="${abstractResource.uuid}">
                                <button class="btn" type="submit">Modify Resource</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <form action="./viewModifyResource" method="POST">
            <div class="row">
                <div class="col"><p>Select Owning Party</p>
                    <select class="form-control" name="ownerPartyUUID">
                        <c:forEach var="party" items="${partyList}">
                            <option value="${party.uuid}">${party.firstName} ${party.uuid}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col"><p>Select Catalogue Template </p>
                    <select class="form-control" name="catalogUUID">
                        <c:if test="${empty catalogList}">
                            <option value="notDefined">You need to define a catalogue entry first</option>
                        </c:if>

                        <c:forEach var="catalog" items="${catalogList}">
                            <option value="${catalog.uuid}">TYPE: ${catalog.resourceTypeName}
                                UUID: ${catalog.uuid}</option>
                        </c:forEach>

                    </select></div>
            </div>

            <!-- creates a new resource -->
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="action" value="createAbstractResource">

            <button class="btn" type="submit"
                    <c:if test="${empty catalogList}">disabled </c:if> >Add Resource
            </button>
        </form>
    </div>
</main>
