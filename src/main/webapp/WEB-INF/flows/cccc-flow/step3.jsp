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
                        <td>${form.address.homeAddress2}</td>
                    </tr>
                    <tr>
                        <td>城市 City: </td>
                        <td>${form.address.homeCity}</td>
                    </tr>
                    <tr>
                        <td>州/省 State/Province: </td>
                        <td>${form.address.homeState}</td>
                    </tr>
                    <tr>
                        <td align="rignt">邮政编码 Zipcode/Postal Code:</td>
                        <td>${form.address.homeZip}</td>
                    </tr>
                    <tr>
                        <td align="rignt">国家 Country:</td>
                        <td>${form.address.country}</td>
                    </tr>
                    <tr>
                        <td>聯絡电话 Primary Contact Phone:</td>
                        <td>${form.address.homePhone}</td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td>${form.address.misc1}</td>
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
        <c:forEach items="${form.registrants}" var="registrant" varStatus="count">
            <hr style="width: 70%; height: 2px;">
            <div>
                <table style="text-align: left; margin-left: auto; margin-right: auto; border:2; width: 100%" >
                    <tbody>
                        <tr>
                            <td align="left"> <b>第 ${count.count} 个人的资料 Information of Person No. ${count.count} </b>
                            </td>
                            <td align="right"> 
                                <c:set var="v" value="${count.index}"/>
                                <button id="edit_${v}" type="submit" name="_eventId_edit" value="${v}">Edit</button>
                                <script type="text/javascript">
                                    Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'edit_${v}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${v}"}}));
                                </script>
                                <button id="remove_${v}" type="submit" name="_eventId_remove" value="${v}">Delete</button>
                                <script type="text/javascript">
                                    Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'remove_${v}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${v}"}}));
                                </script>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table style="width: 500px; height: 61px; text-align: left; margin-left: auto; margin-right: auto; border:2; ">
                                    <tbody>
                                        <tr>
                                            <td>中文姓名:</td>
                                            <td>${registrant.person.chineseName}</td>
                                            <td>性别 Gender:</td>
                                            <td>${registrant.person.gender}</td>
                                        </tr>
                                        <tr>
                                            <td>English Lastname:</td>
                                            <td>${registrant.person.lastName}</td>
                                            <td>English Firstname:</td>
                                            <td>${registrant.person.firstName}</td>
                                        </tr>
                                        <tr>
                                            <td>年龄 Age/Age Group:</td>
                                            <td>${registrant.person.age}</td>
                                            <td>年级 Grade:</td>
                                            <td>${registrant.person.status}</td>
                                        </tr>
                                        <tr>
                                            <td>关系 夫妻/子女等:</td>
                                            <td>${registrant.person.relationship}</td>
                                            <td>信主 Beliver:</td>
                                            <td>Y </td>
                                        </tr>
                                        <tr>
                                            <td>语言 Language:</td>
                                            <td>${registrant.person.preferredLanguage}</td>

                                            <td>翻译耳机 <br>
                                                Interpreter Headphone: </td>
                                            <td>${registrant.person.headphone}</td>
                                        </tr>
                                        <tr>
                                            <td>事奉角色:</td>
                                            <td colspan="3">${registrant.person.servingRole}</td>
                                        </tr>
                                        <tr>
                                            <td>电邮 &nbsp;Email:</td>
                                            <td colspan="3">${registrant.person.email}</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                    </tbody>
                </table>                 
            </div>
            <hr style="width: 70%; height: 2px;">
            <c:set var="serve" value="<%=com.cclife.registration.domain.Server.values()%>" />
            <c:forEach items="${serve}" var="se">
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='USHERS' }"><c:set var="ushers" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='NURSERY_HELPER' }"><c:set var="nursery_helper" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='INTERPRETER' }"><c:set var="interpreter" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='AUDIO_VISUAL' }"><c:set var="audio_visual" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='FOLLOWUP' }"><c:set var="followup" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='TRANSPORTATION' }"><c:set var="transportation" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='MEDICAL_SUPPORT' }"><c:set var="medical_support" value="Y" /></c:if>
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='OTHER' }"><c:set var="other" value="Y" /></c:if>
            </c:forEach>
            <div>
                <table style="text-align: left; width: 500px; height: 62px;" align="center" border="0" cellpadding="2" cellspacing="2">
                    <tbody>
                        <tr>
                            <td colspan="4" rowspan="1" align="center"><b>大会义工</b></td>
                        </tr>
                        <tr>
                            <td>招待 &nbsp;${ushers}</td>
                            <td>幼儿看顾 &nbsp;${nursery_helper}</td>
                            <td>翻译 &nbsp;${interpreter}</td>
                            <td>音影 &nbsp;${audio_visual}</td>
                        </tr>
                        <tr>
                            <td>陪谈 &nbsp;${followup}</td>
                            <td>交通 &nbsp;${transportation}</td>
                            <td>医疗 &nbsp;${medical_support}</td>
                            <td>其他 &nbsp;${other}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <hr style="width: 70%; height: 2px;">
            <div>
                <table
                    style="text-align: center; margin-left: auto; margin-right: auto;">
                    <tbody>
                        <tr>
                            <td colspan="3" rowspan="1"><b>订餐</b></td>
                        </tr>
                        <tr>
                            <td>&nbsp; &nbsp;Dec. 28 &nbsp; </td>
                            <td>&nbsp; &nbsp;Dec. 29 &nbsp; </td>
                            <td>&nbsp; Dec. 30 &nbsp;</td>
                        </tr>
                        <tr>
                            <td>午餐 &nbsp;&nbsp;${registrant.mealplan.lunch1}</td>
                            <td>午餐 &nbsp;&nbsp;${registrant.mealplan.lunch2}</td>
                            <td>午餐 &nbsp;&nbsp;${registrant.mealplan.lunch3}</td>
                        </tr>
                        <tr>
                            <td>晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner1}</td>
                            <td>晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner2}</td>
                            <td>晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner3}</td>
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
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'aaaaaaa', event: 'onclick', formId: 'step3', params: {fragments: "body"}}));
        </script>
    </form:form>
</div>
