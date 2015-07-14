<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="success">PAY BY CHECK!</p>
    <div>
        <p>
        <div id="content" align="left">
            <h1>Thank you for your registration.</h1>
            <p>Your Confirmation Number is <c:out value="${registrationId}" /></p>
            <p>
                Thank you for registration. The total amount paid is ${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}. Please print this confirmation page and mail your payment.
            </p>         
        </div>
        <hr style="width: 80%; height: 2px;">
        <a id="startFlow" href="cccc-flow">Start Over</a>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
        </script>
        </p>	
    </div>
</div>