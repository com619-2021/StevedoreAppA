<%-- 
    Document   : content
    Created on : Jan 4, 2020, 11:19:47 AM
    Author     : cgallen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "selectedPage" value = "home" scope="request" />
<!-- start of home.jsp selectedPage=${selectedPage}-->
<jsp:include page="header.jsp" />

<!-- Begin page content -->
<body>
<div class="jumbotron">

  <div class="container MkOrderContainer curvedEdges">
    <form>
      <div class="makeBookingHeading text-center">
        <h1>Services</h1>
      </div>
      <div class="container">
        <div class="row">
          <div class="col personalInfo">
            <div class="row text-center d-flex justify-content-center order-subheading">Personal Information </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="nameInput" placeholder="Full Name...">
            </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="emailInput" placeholder="Email...">
            </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="phoneInput" placeholder="Phone Number...">
            </div>
          </div>
          <div class="col servicesRequired">
            <div class="row text-center d-flex justify-content-center order-subheading">Services Required</div>
            <div class="row">
              <div class="col">
                <label class="form-check-label switch-label float-end" for="cargoSwitch" >Cargo: </label>
              </div>
              <div class="col">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" id="cargoSwitch"/>
                </div>
              </div>

            </div>
            <div class="row">
              <div class="col">
                <label class="form-check-label switch-label float-end" for="waterSwitch">Water:</label>
              </div>
				
              <div class="col">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" id="waterSwitch" />
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <label class="form-check-label switch-label float-end" for="wasteSwitch">Waste: </label>
              </div>
              <div class="col">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" id="wasteSwitch" />
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col">
                <label class="form-check-label switch-label float-end" for="foodSwitch">Food: </label>
              </div>
              <div class="col">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" id="foodSwitch" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="container">
        <div class="row">
          <div class="col berthInformation">
            <div class="row text-center d-flex justify-content-center order-subheading">Berth Information </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="berthNameInput" placeholder="Berth Name...">
            </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="berthLocationInput" placeholder="Berth Location...">
            </div>
            <div class="row d-flex justify-content-center">
              <input type="text" class="form-control mkOrderInput" id="portNoInput" placeholder="Port Number...">
            </div>
          </div>
          <div class="col arrivalDate">
            <div class="text-center d-flex justify-content-center order-subheading">Arrival Date </div>
			 <input type="text" class="form-control mkOrderInput datetimepicker" id="arrivalDateInput" autocomplete="off">
            
          </div>
        </div>
      </div>
      <div class="row d-flex justify-content-center">
        <button type="submit" class="btn btn-primary mkOrderBtn justify-content-center text-center">Book</button>
      </div>
    </form>
  </div>
</div>
 <script src="resources/js/dateTimePick.js"></script>
</body>

<jsp:include page="footer.jsp" />
