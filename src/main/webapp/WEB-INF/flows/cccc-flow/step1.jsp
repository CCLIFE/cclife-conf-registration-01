<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="embeddedFlow">
    <p class="notice">step 1 - Enter address and family information</p>
    <form:form id="step1" action="${flowExecutionUrl}" modelAttribute="form" >
        <div>
            <table align="center" border="2" >
                <caption><b>家庭与个人报名资料: Family and Personal Data ABC</b> </caption><tbody>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.homeAddress" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>住址 Street Address1: </td>
                        <td><form:input path="address.homeAddress" name="homeAddress" size="30" maxlength="60"/></td>
                    </tr>
                    <tr>
                        <td>住址 Street Address2: </td>
                        <td><form:input path="address.homeAddress2" name="homeAddress2" size="30" maxlength="60"/> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.homeCity" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td><form:input path="address.homeCity" name="homeCity"  size="30" maxlength="50"/> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.country" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>国家 Country:</td>
                        <td>
                            <form:select id="country" path="address.country">
                                <form:option value="" label="-- Select Country --" /> 
                                <form:options items="${form.countries}" itemValue="value" itemLabel="label" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.homeState" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td>
                            <form:select id="homeState" path="address.homeState">
                                <form:option value="" label="-- Select State --" />
                                <form:options items="${form.stateList}" itemValue="value" itemLabel="label" />
                            </form:select>
                        </td>
                    </tr>
<!--                    <tr>
                        <td colspan="2" align="center">若非美国和加拿大,
                            请填写如下信息：If other than
                            Canada or United States
                        </td>
                    </tr>
                    <tr>
                        <td>国家 Country: </td>
                        <td> 
                            <form:input path="address.country" name="country"  size="30" maxlength="50"/>

                        </td>
                    </tr>
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td> 
                            <form:input path="address.homeState" name="state"  size="30" maxlength="50"/>
                        </td>
                    </tr>
-->
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.homeZip" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>邮政编码 Zipcode/Postal Code:</td>
                        <td>
                            <form:input path="address.homeZip" name="homeZip" size="10" maxlength="15"/>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.homePhone" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>聯絡电话 Primary Contact Phone: </td>
                        <td><form:input path="address.homePhone" name="homePhone" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.misc1" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td><form:input path="address.misc1" name="email" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.misc2" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>确认电邮 Confirm Email: </td>
                        <td><form:input path="address.misc2" name="emailConfirm" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td>所属教会/机构<br>
                            Church / Organization Affiliation<br>
                            （若无教会，可暂不填写<br>
                            Leave it blank, if no church right now.)</td>
                        <td><form:input path="churchName" name="churchName" size="20" maxlength="50"/></td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;">

        </div>
        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
        </script>
    </form:form>

</div>