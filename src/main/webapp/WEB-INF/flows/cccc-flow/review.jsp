<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/webflow-registration/resources/styles/blueprint/screen.css" type="text/css" media="screen, projection" />

<script type="text/javascript" >
function showAmount()
{
    var span = document.getElementById('payAmount');
    var registrationFee = ${form.expense.totalRegistrationFee};
    var mealFee = ${form.expense.totalMealsFee};
    
    var donationAmt = document.getElementById('donationAmt').value;
    
    var totalPayment = Number( registrationFee ) + Number( mealFee ) + Number( donationAmt );

    if( isNaN(donationAmt ) )
    {
        alert("Please input valid amount. Thanks!");
        return;
    }
    span.innerText = span.textContent = Number( totalPayment );
}

</script>

<div id="embeddedFlow">
    <p class="notice">Review Payment</p>
    <form:form id="review" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table align="center">
                <tbody>
                    <tr>
                        <td>总报名人数 Number of persons:</td>
                        <td>${form.registrants.size()}</td>
                    </tr>
                    <tr>
                        <td>总报名费 Total Registration Fee:</td>
                        <td>${form.expense.totalRegistrationFee}</td>
                    </tr>
                    <tr>
                        <td>总餐费 Total Meal Fee:</td>
                        <td>${form.expense.totalMealsFee}</td>
                    </tr>
                    <tr>
                        <td>总费用 Total:</td>
                        <td>${form.expense.totalMealsFee + form.expense.totalRegistrationFee}</td>
                    </tr>
                    <tr>
                        <td>我愿为大会奉献 I will donate $</td>
                        <td> 
                            <form:input id="donationAmt" path="donationAmt" size="30" maxlength="50" onkeyup="showAmount()"/>
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;" />
            <table align="center">
                <tbody>
                    <tr>
                        <td>
                            <form:errors path="chkPmt" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td> <form:checkbox path="chkPmt"/>
                            <span style="font-weight: bolder; font-size: 14px;">
                                I authorize CC Life to collect $<span id="payAmount">0.00</span>
                                from my account.</span><br />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:errors path="paymentMethod" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Payment Information <form:radiobutton id="creditcard" path="paymentMethod" value="CREDIT_CARD"/>Debit/Credit
                            Card&nbsp;&nbsp; <form:radiobutton id="check" path="paymentMethod" value="PERSONAL_CHECK"/>check </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <hr style="width: 80%; height: 2px;">

        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="payment" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'payment', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'review', params: {fragments: "body"}}));
        </script>
    </form:form>    
        
    <script>
        showAmount();
    </script>
    
</div>

