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
                        <td>总报名人数 Number of persons:</td>
                        <td>${form.registrants.size()}</td>
                    </tr>
                    <tr>
                        <td>总报名费 Total Registration Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalRegistrationFee}</td>
                    </tr>
                    <tr>
                        <td>总餐费 Total Meal Fee:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee}</td>
                    </tr>
                    <tr>
                        <td>总费用 Total:</td>
                        <td>${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}</td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;" />
            
            <table align="center">
                <tr>
                    <td style="text-align:center">
                        <font style="font-size:12pt">
                        <b>
                            关于大会费用
                        </b>
                        </font>      
                    </td>
                </tr>               
                <tr>
                    <td>1. 报名费（报名截止日期 12 月 10 日；报名费恕不退还）</td>
                </tr>
               <tr>
                   <td>&nbsp;&nbsp;&nbsp;请按 2015年 12 月 28日的年龄计算，12岁以上均需交报名费， 12 岁以下免费。</td>
                </tr>
            </table>
            <table  style="border:1px solid black; alignment-adjust:central; margin-left:auto; margin-right:auto">
                <tr>
                    <td style="text-align:center; border:1px solid black">年龄</td>
                    <td style="text-align:center; border:1px solid black">9/15 日前</td>
                    <td style="text-align:center; border:1px solid black">11/15 日前</td>
                    <td style="text-align:center; border:1px solid black">12/10 日前</td>
                </tr>
                <tr>
                    <td style="text-align:center; border:1px solid black">12 岁以上</td>
                    <td style="text-align:center; border:1px solid black">美元 10/加币 12</td>
                    <td style="text-align:center; border:1px solid black">美元 15/加币 18</td>
                    <td style="text-align:center; border:1px solid black">美元 25/加币 30</td>
                </tr>
            </table>
            <table>
                <tr>
                    <td>2.  餐费（12 月 10 日后恕无法退还;现场订餐有限,餐费会更贵）</td>
                </tr>
               <tr>
                   <td>&nbsp;&nbsp;&nbsp;午餐美金$6/加元$7；晚餐美金$7/加元$8，没有儿童餐.</td>
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
                        <td style="text-align:center">
                            <form:errors path="paymentMethod" cssClass="fieldError"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align:center">Payment methods 付款方式  <form:radiobutton id="creditcard" path="paymentMethod" value="CREDIT_CARD"/>Debit/Credit
                            Card&nbsp;&nbsp; <form:radiobutton id="check" path="paymentMethod" value="PERSONAL_CHECK"/>check </td>
                    </tr>
                    <tr><td></td></tr>
                    <tr>
                        <td style="text-align:center">请仔细核对，确认信息正确后，按 ”Next“</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                </tbody>
            </table>
        </div>
                    
        <hr style="width: 80%; height: 2px;">

        <table align="center" style="width:100%;">
            <tr>
                <td style="width:30%"></td>
                <td style="width:40%; text-align:center;">
                    <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
                    <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
                    <button id="payment" type="submit" name="_eventId_next">Next &gt;&gt;</button>
                </td>
                <td style="width:30%"></td>
            </tr>
        </table>
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

