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
            ['DC', 'District Of Columbia'],
            ['FL', 'Florida'],
            ['GA', 'Georgia'],
            ['GU', 'Guam'],
            ['HI', 'Hawaii'],
            ['IA', 'Iowa'],
            ['ID', 'Idaho'],
            ['IL', 'Illinois'],
            ['IN', 'Indiana'],
            ['KS', 'Kansas'],
            ['KY', 'Kentucky'],
            ['LA', 'Louisiana'],
            ['MA', 'Massachusetts'],
            ['MD', 'Maryland'],
            ['ME', 'Maine'],
            ['MI', 'Michigan'],
            ['MN', 'Minnesota'],
            ['MO', 'Missouri'],
            ['MS', 'Mississippi'],
            ['MT', 'Montana'],
            ['NE', 'Nebraska'],
            ['NH', 'New Hampshire'],
            ['NJ', 'New Jersey'],
            ['NM', 'New Mexico'],
            ['NY', 'New York'],
            ['NV', 'Nevada'],
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
            ['VI', 'Virgin Islands'],
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



<div id="embeddedFlow">
    <p class="notice">step 1 - Enter address and family information</p>
    <form:form id="step1" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table style="text-align: left; width: 470px; border-color: #009; ">
                <caption><b>家庭与个人报名资料: Family and Personal Data</b> </caption><tbody>
                    <tr>
                        <td style="width:40%"></td>
                        <td  style="width:60%"> <form:errors path="address.homeAddress" cssClass="fieldError"/></td>
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
                        <td><form:input path="address.homeCity" name="homeCity"  size="30" maxlength="30"/> </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.ucCountry" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>国家 Country:</td>
                        <td>
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
                                        <td style="width: 40%;" ></td>
                                        <td style="width: 60%;" >
                                            <form:errors path="address.ucState" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>州/省 State/Province: </td>
                                        <td>
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
                                        <td colspan="2" align="center">若非美国和加拿大,
                                            请填写如下信息：If other than
                                            Canada or United States
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 40%;" ></td>
                                        <td style="width: 60%;" >
                                            <form:errors path="address.otherCountry" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>国家 Country: </td>
                                        <td> 
                                            <form:input path="address.otherCountry"  id="otherCountry"  size="30" maxlength="50" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td style="width: 40%;" ></td>
                                        <td style="width: 60%;" >
                                            <form:errors path="address.otherState" cssClass="fieldError"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>州/省 State/Province: </td>
                                        <td> 
                                            <form:input path="address.otherState" id="otherState"  size="10" maxlength="20"  />
                                        </td>
                                    </tr>

                                </table>
                            </div>
                        </td>
                    </tr>
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
                        <td> <form:errors path="primaryChineseName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>Primary Chinese Name: </td>
                        <td><form:input path="primaryChineseName" name="primaryChineseName" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="primaryFirstName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>Primary First Name: </td>
                        <td><form:input path="primaryFirstName" name="primaryFirstName" size="15" maxlength="15"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="primaryLastName" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>Primary Last Name: </td>
                        <td><form:input path="primaryLastName" name="primaryLastName" size="15" maxlength="15"/></td>
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
                        <td><form:input id="email" path="address.misc1" name="email" size="25" maxlength="50"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td> <form:errors path="address.misc2" cssClass="fieldError"/></td>
                    </tr>
                    <tr>
                        <td>确认电邮 Confirm Email: </td>
                        <td><form:input id="confirmEmail" path="address.misc2" name="emailConfirm" size="25" maxlength="50"/></td>
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

    <c:set var="ucCountryValue" value="${form.getAddress().getUcCountry()}" />
    <script>
        setStateDiv("${ucCountryValue}");
    </script>

</div>

