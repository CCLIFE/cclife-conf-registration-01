<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="notice">Pay by CREDIT</p>
    <hr style="width: 80%; height: 2px;">
    <div id="content" align="left">
        <h3>Pay by CREDIT CARD or PayPal 付款方式：信用卡或PayPal</h3>
        <div>
            <table>
                <tr>
                    <td>
                        <b>I authorize CCLiFe to collet $${form.expense.totalMealsFee + form.expense.totalRegistrationFee} from my account.</b>
                    </td>
                </tr>
                <tr>
                    <td>
                        我授權生命季刊從我的賬號中支取下述金額：$${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                    </td>
                </tr>
            </table>
            <p>在您點擊“Pay Now”進入下一頁前，請閱讀有關下一頁的註意事項：</p>
            <ul type="circle">
                <li>如果您使用信用卡付款，請點擊” Don’t have a PayPal account” 按鈕，無須登錄PayPal賬戶。</li>
                <li>請勿點擊瀏覽器的退回鍵，以免丟失您的所有信息。</li>
            </ul>
            <b>Pay now with credit card or PayPal 點擊下方按鈕付款</b>
            <form:form method="post" modelAttribute="paymentProvider" action="${paymentUrl}">
                <form:hidden path="cmd"/>
                <form:hidden path="redirect_cmd"/>
                <form:hidden path="business"/>
                <form:hidden path="item_name"/>
                <form:hidden path="item_number"/>
                <form:hidden path="amount"/>
                <form:hidden path="custom"/>
                <form:hidden path="no_shipping"/>
                <form:hidden path="no_note"/>
                <form:hidden path="currency_code"/>
                <form:hidden path="lc"/>
                <form:hidden path="bn"/>
                <form:hidden path="return"/>
                <form:hidden path="rm"/>
                <form:hidden path="email"/>
                <form:hidden path="first_name"/>
                <form:hidden path="last_name"/>
                <form:hidden path="address1"/>
                <form:hidden path="address2"/>
                <form:hidden path="city"/>
                <form:hidden path="state"/>
                <form:hidden path="zip"/>
                <form:hidden path="notify_url"/>
                <p>
                    <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but06.gif" cssClass="button" key="button.pay" theme="simple"/>
                </p>
            </form:form>
        </div>
        <hr style="width: 100%; height: 2px;"/>
        <br/>
    </div>
    

</div>