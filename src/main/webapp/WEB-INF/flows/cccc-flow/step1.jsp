<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    var countryStateArray = {
        'US': [
            ['', 'State/Province'],
            ['AL', 'Alabama'],
            ['AK', 'Alaska'],
            ['AR', 'Arkansas'],
            ['AZ', 'Arizona'],
            ['CA', 'California'],
            ['CO', 'Colorado'],
            ['CT', 'Connecticut'],
            ['DE', 'Delaware'],
            ['FL', 'Florida'],
            ['GA', 'Georgia'],
            ['HI', 'Hawaii'],
            ['IA', 'Iowa'],
            ['ID', 'Idaho'],
            ['IL', 'Illinois'],
            ['IN', 'Indiana'],
            ['KS', 'Kansas'],
            ['KY', 'Kentucky'],
            ['LA', 'Louisiana'],
            ['ME', 'Maine'],
            ['MD', 'Maryland'],
            ['MA', 'Massachusetts'],
            ['MI', 'Michigan'],
            ['MN', 'Minnesota'],
            ['MS', 'Mississippi'],
            ['MO', 'Missouri'],
            ['MT', 'Montana'],
            ['NE', 'Nebraska'],
            ['NV', 'Nevada'],
            ['NH', 'New Hampshire'],
            ['NJ', 'New Jersey'],
            ['NM', 'New Mexico'],
            ['NY', 'New York'],
            ['NC', 'North Carolina'],
            ['ND', 'North Dakota'],
            ['OH', 'Ohio'],
            ['OK', 'Oklahoma'],
            ['OR', 'Oregon'],
            ['PA', 'Pennsylvania'],
            ['RI', 'Rhode Island'],
            ['SC', 'South Carolina'],
            ['SD', 'South Dakota'],
            ['TN', 'Tennessee'],
            ['TX', 'Texas'],
            ['UT', 'Utah'],
            ['VT', 'Vermont'],
            ['VA', 'Virginia'],
            ['WA', 'Washington'],
            ['WV', 'West Virginia'],
            ['WI', 'Wisconsin'],
            ['WY', 'Wyoming']
        ],
        'CA': [
            ['', 'State/Province'],
            ['AB', 'Alberta'],
            ['BC', 'British Columbia'],
            ['MB', 'Manitoba'],
            ['NB', 'New Brunswick'],
            ['NL', 'Newfoundland and Labrador'],
            ['NS', 'Nova Scotia'],
            ['NT', 'Northwest Territories'],
            ['NU', 'Nunavut'],
            ['ON', 'Ontario'],
            ['PE', 'Prince Edward Island'],
            ['QC', 'Quebec'],
            ['SK', 'Saskatchewan'],
            ['YT', 'Yukon']
        ]
    };

    function setStates() {

        var stateList = document.getElementById("stateId");

        var countryList = document.getElementById("countryId");

        var countryValue = countryList.value;

        var opt;

        if (countryStateArray[countryValue]) {
            stateList.options.length = 0;
            // states exist for this country, append them and show the select
            for (var i = 0; i < countryStateArray[countryValue].length; i++) {
                var state = countryStateArray[countryValue][i];
                opt = new Option(state[1], state[0]);
                stateList.appendChild(opt);
            }
        }
    }

    function countrySelected($val) {

        setStates();
        setStateDiv($val);

        if ($val == 'OC') {
            document.getElementById("otherCountryDiv").style.display = "block";
            document.getElementById("usStateDiv").style.display = "none";
        }
        else {
            document.getElementById("otherCountryDiv").style.display = "none";
            document.getElementById("usStateDiv").style.display = "block";
        }
    }

    function setStateDiv($val) {
        var countryList = document.getElementById("countryId");
        var countryValue = countryList.valueOf();

        if ($val == 'OC') {
            document.getElementById("otherCountryDiv").style.display = "block";
            document.getElementById("usStateDiv").style.display = "none";
        }
        else {
            document.getElementById("otherCountryDiv").style.display = "none";
            document.getElementById("usStateDiv").style.display = "block";
        }

    }
</script>


<div class="span-2 colborder">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="notice"><b>1. 请输入主报人的姓名和家庭地址 （第一位輸入的人為主報人） <br>
            step 1 - Enter address and family information</b></p>
    <li><font color='red'>有 * 號的攔目務必填寫 (* indicates required field) <br></font></li>

    <form:form id="step1" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table style="text-align: left; width: 470px; border-color: #009; ">

                <tbody>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="primaryChineseName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">主報人中文姓名<br>Primary Chinese Name: </td>
                        <td><form:input path="primaryChineseName" name="primaryChineseName" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="primaryFirstName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">主報人英文名<br>Primary First Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td><form:input path="primaryFirstName" name="primaryFirstName" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="primaryLastName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">主報人英文姓<br>Primary Last Name: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td><form:input path="primaryLastName" name="primaryLastName" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><br/><hr style="width: 100%; height: 2px;"></td>
                    </tr>
                    <tr>
                        <td  colspan="2" style="text-align:center"> <form:errors path="address.homeAddress" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width:40%">住址 Street Address1: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td style="width:60%"><form:input path="address.homeAddress" name="homeAddress" size="30" maxlength="60"/></td>
                    </tr>
                    <tr>
                        <td>住址 Street Address2: </td>
                        <td><form:input path="address.homeAddress2" name="homeAddress2" size="30" maxlength="60"/> </td>
                    </tr>

                    <tr>
                        <td colspan="2" style="text-align:center"> <form:errors path="address.homeCity" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width:40%">城市 City: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td style="width:60%"><form:input path="address.homeCity" name="homeCity"  size="30" maxlength="30"/> </td>
                    </tr>

                    <tr>
                        <td colspan="2" style="text-align:center"> <form:errors path="address.ucCountry" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width:40%">国家 Country: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td style="width:40%">
                            <form:select id="countryId" path="address.ucCountry" onchange="countrySelected(value);">
                                <form:option value="" label="-- Select Country --" /> 
                                <form:options items="${form.countries}" itemValue="value" itemLabel="label" />
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="usStateDiv" style="display:block;">

                                <table style="text-align: left; width: 470px; border: blue;">
                                    <tr>
                                        <td colspan="2" style="text-align:center" >
                                            <form:errors path="address.ucState" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width:40%">州/省 State/Province: <font color="red"> &nbsp;* &nbsp;</font></td>
                                        <td style="width:60%">
                                            <form:select id="stateId" path="address.ucState" >
                                                <form:option value="" label="-- Select State --" />
                                                <form:options items="${form.stateList}" itemValue="value" itemLabel="label" />
                                            </form:select>
                                        </td>
                                    </tr>

                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="otherCountryDiv" style="display:none;">

                                <table>
                                    <tr>
                                        <td colspan="2" style="text-align:center">若非美国和加拿大,
                                            请填写如下信息：If other than
                                            Canada or United States
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align:center" >
                                            <form:errors path="address.otherCountry" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 40%;">国家 Country: <font color="red"> &nbsp;* &nbsp;</font></td>
                                        <td style="width: 40%;"> 
                                            <form:input path="address.otherCountry"  id="otherCountry"  size="30" maxlength="50" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2" style="text-align:center" >
                                            <form:errors path="address.otherState" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>州/省 State/Province: <font color="red"> &nbsp;* &nbsp;</font></td>
                                        <td> 
                                            <form:input path="address.otherState" id="otherState"  size="10" maxlength="20"  />
                                        </td>
                                    </tr>

                                </table>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="address.homeZip" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">邮政编码<br>Zipcode/Postal Code: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td>
                            <form:input path="address.homeZip" name="homeZip" size="10" maxlength="15"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="address.homePhone" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">聯絡电话<br>Primary Contact Phone: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td><form:input path="address.homePhone" name="homePhone" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="address.misc1" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">电邮 Email: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td><form:input id="email" path="address.misc1" name="email" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center" >
                            <form:errors path="address.misc2" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">确认电邮 Confirm Email: <font color="red"> &nbsp;* &nbsp;</font></td>
                        <td><form:input id="confirmEmail" path="address.misc2" name="emailConfirm" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">是否需要住宿 Need Hotel: </td>
                        <td>
                            需要 Yes <form:radiobutton path="address.hotel" value="true" />
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            不需要 No <form:radiobutton path="address.hotel" value="false" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width: 40%;">所属教会/机构<br>
                            Church / Organization Affiliation<br>
                            （若无教会，可不填写<br>
                            Leave it blank, if no church right now.)</td>
                        <td><form:input path="churchName" name="churchName" size="20" maxlength="50"/></td>
                    </tr>
                </tbody>
            </table>
            <hr style="width: 80%; height: 2px;">

        </div>
        <button id="cancel" type="button" name="_eventId_cancel">Cancel</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step1', params: {fragments: "body"}}));
        </script>
    </form:form>

    <c:set var="ucCountryValue" value="${form.getAddress().getUcCountry()}" />
    <script>
        setStateDiv("${ucCountryValue}");
    </script>

</div>

