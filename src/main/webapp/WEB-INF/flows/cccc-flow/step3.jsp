<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="embeddedFlow">
    <p class="notice">Review Registration Summary</p>
    <form:form id="step3" action="${flowExecutionUrl}" modelAttribute="form">
        <div>
            <table align="center">
                <caption><b>目前注册信息 Your Registration Summary</b> </caption> <tbody>
                    <tr>
                        <td>住址 Street Address1: </td>
                        <td>${form.address.homeAddress} </td>
                    </tr>
                    <tr>
                        <td>住址 Street Address2: </td>
                        <td>${form.homeStreetAddress}</td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td>${form.homeCity}</td>
                    </tr>
                    <tr>
                        <td>
                            <table>
                                <tbody>
                                    <tr>
                                        <td>州/省 State/Province: </td>
                                        <td>${form.homeState}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                        <td>
                            <table style="text-align: left; width: 403px; height: 64px;"
                                   border="0" cellpadding="0" cellspacing="0">
                                <tbody>
                                    <tr>
                                        <td align="rignt">邮政编码 Zipcode/Postal Code:</td>
                                        <td>${form.homeZipCode}</td>
                                        <td align="rignt">国家 Country:</td>
                                        <td>${form.homeCountry}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                        <td>住家电话 Home Phone: </td>
                        <td>${form.homePhone}</td>
                    </tr>
                    <tr>
                        <td>手机 Cell Phone: </td>
                        <td>${form.cellPhone}</td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td>${form.email}</td>
                    </tr>
                    <tr>
                        <td>所属教会/机构<br>
                            Church / Organization Affiliation </td>
                        <td>${form.churchName} </td>
                    </tr>
                    <!--
                    <tr>
                        <td colspan="2" align="center"> <input name="fixAddress"
                                                               value="更正地址错误 Correct Address" type="submit"></td>
                    </tr>
                    -->
                </tbody>
            </table>

        </div>
        <c:forEach items="${form.registrants}" var="person">
            <hr style="width: 70%; height: 2px;">
            <div>
                <table style="text-align: left; margin-left: auto; margin-right: auto;">
                    <tbody>
                        <tr>
                            <td align="left"> <b>第一个人的资料 Information of Person No. 1 </b>

                            </td>
                            <td align="right">  </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table style="width: 900px; height: 61px; text-align: left; margin-left: auto; margin-right: auto;" border="0" cellpadding="2" cellspacing="2">
                                    <tbody>
                                        <tr>
                                            <td>中文姓名:</td>
                                            <td>${person.chineseName}</td>
                                            <td>English Lastname:</td>
                                            <td>${person.lastName}</td>
                                            <td>English Firstname:</td>
                                            <td>${person.firstName}</td>
                                        </tr>
                                        <tr>
                                            <td>性别 Gender:</td>
                                            <td>${person.gender}</td>
                                            <td>年龄 Age/Age Group:</td>
                                            <td>${person.age}</td>
                                            <td>年级 Grade:</td>

                                            <td>[TODO]
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>关系 夫妻/子女等:</td>
                                            <td>${person.relationship}</td>
                                            <td>信主 Beliver:</td>

                                            <td>Y </td>
                                            <td>事奉角色:</td>
                                            <td>${person.status}</td>
                                        </tr>
                                        <tr>
                                            <td>语言 Language:</td>
                                            <td>${person.preferedLanguage}</td>

                                            <td>翻译耳机 <br>
                                                Interpreter Headerphone: </td>
                                            <td>[TODO]</td>
                                        </tr>
                                        <tr>
                                            <td>电邮 &nbsp;Email:</td>
                                            <td colspan="5" rowspan="1">${person.email}</td>

                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>                 
            </div>
        </c:forEach>
        <hr style="width: 80%; height: 2px;">

        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="new" type="submit" name="_eventId_new">+ Add</button>
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'previous', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'new', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
        </script>
    </form:form>
</div>