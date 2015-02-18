<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="embeddedFlow">
    <p class="notice">step 1 - Enter address and family information</p>
    <form:form id="step1" action="${flowExecutionUrl}" modelAttribute="form" >
        <div>
            <table align="center">
                <caption><b>家庭与个人报名资料: Family and Personal Data</b> </caption><tbody>
                    <tr>
                        <td>住址 Street Address1: </td>
                        <td><form:input path="address.homeAddress" name="address" size="30" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td>住址 Street Address2: </td>
                        <td><form:input path="homeStreetAddress" name="homeStreetAddress" size="30" maxlength="50"/> </td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td><form:input path="homeCity" name="homeCity"  size="30" maxlength="50"/> </td>
                    </tr>
                    <tr>
                        <td>国家 Country:</td>
                        <td>
                            [TODO]
                        </td>
                    </tr>
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td>
                            [TODO]
                        </td>
                    </tr>
                    <tr>
                        <td>邮政编码 Zipcode/Postal Code:</td>
                        <td><form:input path="homeZipCode" name="homeZipCode" size="10" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">若非美国和加拿大,
                            请填写如下信息：If other than
                            Canada or United States
                        </td>
                    </tr>
                    <tr>
                        <td>国家 Country: </td>
                        <td> [TODO]</td>
                    </tr>
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td>[TODO]</td>
                    </tr>
                    <tr>
                        <td>邮政编码 Zipcode/Postal Code:</td>
                        <td><form:input path="homeZipCode" name="homeZipCode" size="10" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td>住家电话 Home Phone: </td>
                        <td><form:input path="homePhone" name="homePhone" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td>手机 Cell Phone: </td>
                        <td><form:input path="homePhone" name="homePhone" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td><form:input path="email" name="email" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td>确认电邮 Confirm Email: </td>
                        <td><form:input path="emailConfirm" name="emailConfirm" size="25" maxlength="50"/></td>
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