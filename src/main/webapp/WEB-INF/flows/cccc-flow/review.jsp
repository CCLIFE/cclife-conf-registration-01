<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/webflow-registration/resources/styles/blueprint/screen.css" type="text/css" media="screen, projection" />
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="notice">Review Payment</p>
    <form:form id="review" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table align="center">
                <tbody>
                    <tr>
                        <td>總報名人數 Number of persons:</td>
                        <td>${form.registrants.size()}</td>
                    </tr>
                    <tr>
                        <td>總報名費 Total Registration Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalRegistrationFee}</td>
                    </tr>
                    <tr>
                        <td>總餐費 Total Meal Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee}</td>
                    </tr>
                    <tr>
                        <td>總費用 Total:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}</td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;" />
            
            <table>
                <tr>
                    <td>1. 報名費（報名截止日期 12 月 10 日；報名費恕不退還）</td>
                </tr>
               <tr>
                   <td>&nbsp;&nbsp;&nbsp;請按 2015年 12 月 28日的年齡計算，12歲以上均需交報名費， 12 歲以下免費。</td>
                </tr>
            </table>
            <table style="border:1px solid black">
                <tr>
                    <td style="text-align:center; border:1px solid black">年齡</td>
                    <td style="text-align:center; border:1px solid black">9/15 日前</td>
                    <td style="text-align:center; border:1px solid black">11/15 日前</td>
                    <td style="text-align:center; border:1px solid black">12/10 日前</td>
                </tr>
                <tr>
                    <td style="text-align:center; border:1px solid black">12 歲以上</td>
                    <td style="text-align:center; border:1px solid black">美元 10/加幣 12</td>
                    <td style="text-align:center; border:1px solid black">美元 15/加幣 18</td>
                    <td style="text-align:center; border:1px solid black">美元 25/加幣 30</td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>2.  餐費（12 月 10 日後恕無法退還;現場訂餐有限,餐費會更貴）</td>
                </tr>
               <tr>
                   <td>&nbsp;&nbsp;&nbsp;午餐美金$6/加元$7；晚餐美金$7/加元$8，沒有兒童餐.</td>
                </tr>
            </table>
            <hr style="width: 80%; height: 2px;" />
           <table align="center">
                <tbody>
                    <!-- the following code is commented out for issue83.
                    <tr>
                        <td>
                            <form:errors path="chkPmt" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td> <form:checkbox path="chkPmt"/>
                            <span style="font-weight: bolder; font-size: 14px;">
                                I authorize CC Life to collect ${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                                from my account.</span><br />
                        </td>
                    </tr>  
                    -->
                    <tr>
                        <td>
                            <form:errors path="paymentMethod" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Payment methods 付款方式  <form:radiobutton id="creditcard" path="paymentMethod" value="CREDIT_CARD"/>Debit/Credit
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

    <!--
    <script>
        showAmount();
    </script>
    -->
</div>

