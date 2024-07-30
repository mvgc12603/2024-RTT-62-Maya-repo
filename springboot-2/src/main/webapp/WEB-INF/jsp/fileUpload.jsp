<jsp:include page="include/header.jsp"/>


<section class="title-section">
    <div class="container">
        <div class="row pt-5 pb-5">
            <h1 class="text-center">Create Employee</h1>
        </div>
    </div>
</section>

<section>
    <form method="post" action="/fileUpload" enctype="multipart/form-data">
        <input type="hidden" name="employeeId" value ="${employeeId}"/>
        <div class="row align-items-center justify-content-center" style="padding: 2em 0 0 15em">
            <div class="col-4"><input type="file" id="file" name="file" class="form-control"></div>

            <div class="col-6">
                <button type="submit" class="btn btn-primary">Upload</button>
            </div>
        </div>
    </form>
<jsp:include page="include/footer.jsp"/>