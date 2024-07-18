<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp"/>

<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Employee</h1>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <div class="row pt-5 justify-content-center">
            <div class="col-auto justify-content-center">
                <form class="card" style="width: 500px;" action="/employee/createSubmit">
                    <div class="card-body p-3">
                        <div>
                            <label for="emailId" class="col-form-label">Email</label>
                            <input type="text" id="emailId" name="email"
                                   class="form-control <c:if test="${bindingResult.hasFieldErrors('email')}">is-invalid</c:if>"
                                   value="${form.email}">
                            <c:if test="${bindingResult.hasFieldErrors('email')}">
                                <c:forEach items="${bindingResult.getFieldErrors('email')}" var="error">
                                    <div class="text-danger">${error.defaultMessage}</div>
                                </c:forEach>
                            </c:if>
                        </div>

                        <div>
                            <label for="firstNameId" class="col-form-label">First Name</label>
                            <input type="text" id="firstNameId" name="firstname" class="form-control"
                                   value="${form.firstname}">
                        </div>
                        <div>
                            <label for="lastNameId" class="col-form-label">Last Name</label>
                            <input type="text" id="lastNameId" name="lastname" class="form-control"
                                   value="${form.lastname}">
                        </div>
                        <div>
                            <label for="jobTitleId" class="col-form-label">Job Title</label>
                            <input type="text" id="jobTitleId" name="jobTitle" class="form-control">
                        </div>
                        <div>
                            <label for="officeId" class="col-form-label">Office</label>
                            <select id="officeId" name="officeId" class="form-control">
                                <c:forEach items="${offices}" var="office">
                                    <option value="${office.id}"
                                            <c:if test="${office.id == form.officeId}">selected</c:if>
                                    >${office.city}, ${office.country}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="extensionId" class="col-form-label">Extension</label>
                            <input type="text" id="extensionId" name="extension" class="form-control">
                        </div>
                        <div>
                            <label for="vacationHoursId" class="col-form-label">Vacation Hours</label>
                            <input type="number" id="vacationHoursId" name="vacationHours" class="form-control">
                        </div>
                        <div>
                            <label for="reportsTo" class="col-form-label">Reports To</label>
                            <select id="reportsTo" name="reportsTo" class="form-control">
                                <c:forEach items="${employees}" var="employee">
                                    <option
                                            value="${employee.id}"
                                            <c:if test="${employee.id == form.reportsTo}">selected</c:if>
                                    >
                                            ${employee.firstname} ${employee.lastname}
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mt-5">
                            <button type="submit" class="btn btn-success w-100">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="include/footer.jsp"/>