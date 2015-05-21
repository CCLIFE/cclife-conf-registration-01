<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="embeddedFlow">
    <p class="notice">Pay by CREDIT</p>
    <hr style="width: 80%; height: 2px;">
    <div id="content" align="left">
        <h3>付款方式：信用卡或PayPal</h3>
        <div id="radio" class="span-7 last">
            <p>點擊”Pay Now” 進入PayPal網頁</p>
            <ul type="circle">
                <li>信用卡支付者請選擇第二項，無須登入PayPal帳戶</li>
                <li>付款後，請點擊 <b>return to GFCC 2015</b> 回到GFCC 2015付款確認頁面</li>
                <li>請勿點擊瀏覽器的<b>退回鍵</b>,以免丟失您所有信息。</li>
            </ul>
            <b>Pay Now with Credit Card or PayPal</b>
            <form:form method="post" modelAttribute="payObj" action="https://www.sandbox.paypal.com/cgi-bin/webscr">
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
    <hr style="width: 80%; height: 2px;">
    <a id="startFlow" href="cccc-flow">Start Over</a>
    <script type="text/javascript">
        Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
    </script>
</div>