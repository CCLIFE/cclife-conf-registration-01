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
                        我授权生命季刊从我的账号中支取下述金额：$${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                    </td>
                </tr>
            </table>
            <p>在您点击“Pay Now”进入下一页前，请阅读有以下的注意事项：</p> 
            
            <font color='red'>
            <table>
                <tr>
                    <td>1. </td>
                    <td>您若选择 PayPal Account, 请点击 "Pay with my PayPal Account"。您也可以用信用卡付款，请点击 "Don't have a PayPal Account"。
                    请注意不同的浏览器，提示会略有不同，请仔细阅读再操作。</td>
                </tr>
                <tr>
                    <td>2. </td>
                    <td>付款后，请点击 "Return to Christian Life Press Inc." 以结束您的付款。只有这样您才能收到注册码和确认邮件。</td>
                </tr>
                <tr>
                    <td>3. </td>
                    <td><b>请勿点击浏览器的退回键，以免丢失您的输入信息。</b></td>
                </tr>
            </table>
            </font>
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
            <table>
                <tr>
                    <td style="text-align:center">
                        <b>Pay now with credit card or PayPal 点击下方图标付款</b>
                    </td>
                </tr>
                <tr>
                    <td style="text-align:center">

                        <input type="image" src="http://www.paypal.com/en_US/i/btn/x-click-but06.gif" cssClass="button" key="button.pay" theme="simple"/>
                    </td>
                </tr>
            </table>
            </form:form>
        </div>
        <hr style="width: 100%; height: 2px;"/>
        <br/>
    </div>
    

</div>