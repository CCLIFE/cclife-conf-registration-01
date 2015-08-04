<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="notice"><b>请先核对您已经输入的信息，如需添加人员请按页面下方的【+add】键 。<br> 
            Please double check the information you entered.  If you have more people to add to this transaction, 
            press the 【+add】button at the bottom of this page.</b> </p>
        <form:form id="step3" action="${flowExecutionUrl}" modelAttribute="form" acceptCharset="UTF-8">
        <div>
            <table align="center">
                <caption> <b>地址信息 Address information</b></caption> 
                <tbody>
                    <tr>
                        <td width="40%">住址 Street Address1: </td>
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
                        <td>邮政编码 Zipcode/Postal Code:</td>
                        <td>${form.address.homeZip}</td>
                    </tr>
                    <tr>
                        <td>国家 Country:</td>
                        <td>${form.address.country}</td>
                    </tr>
                    <tr>
                        <td>联络电话 Primary Contact Phone#:</td>
                        <td>${form.address.homePhone}</td>
                    </tr>
                    <tr>
                        <td>电邮 Email: </td>
                        <td>${form.address.misc1}</td>
                    </tr>
                    <tr>
                        <td>是否需要住宿 Need Hotel: </td>
                        <td>${form.address.hotel}</td>
                    </tr>
                    <tr>
                        <td>所属教会/机构<br>
                            Church or Organization </td>
                        <td>${form.churchName} </td>
                    </tr>
                </tbody>
            </table>

        </div>
        <c:forEach items="${form.registrants}" var="registrant" varStatus="count">
            <hr style="width: 70%; height: 2px;">
            <c:set var="c" value="${count.count}"/><b>
            <c:if test="${c == 1}">  
                第 1 个人的信息  Primary registrant Information
            </c:if>     
            <c:if test="${c != 1}">  
                第 ${count.count} 个人的信息   Information of Person No. ${count.count} 
            </c:if>
            </b>
            <input type="button" onclick="return toggleDiv('registrantsDiv_${c}')" value="点击显示或隐藏个人信息 click to show/hide Information">
            <div id="registrantsDiv_${c}" style="display:none">
                <div>
                <table style="text-align: left; margin-left: auto; margin-right: auto; border:2; width: 100%" >
                    <tbody>
                        <tr>
                            <td align="left"> <b>
                                    <c:set var="c" value="${count.count}"/>
                                    <c:if test="${c == 1}">  
                                        第 1 个人 (主报人) 的信息   Information of Primary Person 
                                    </c:if>     
                                    <c:if test="${c != 1}">  
                                        第 ${count.count} 个人的资料   Information of Person No. ${count.count} 
                                    </c:if>
                                </b>
                            </td>
                            <td align="right"> 
                                <c:set var="v" value="${count.index}"/>
                                <button id="edit_${v}" type="submit" name="_eventId_edit" value="${v}">Edit</button>
                                <script type="text/javascript">
                                    Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'edit_${v}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${v}"}}));
                                </script>
                                <c:if test="${c != 1}">  
                                    <button id="remove_${v}" type="submit" name="_eventId_remove" value="${v}">Delete</button>
                                    <script type="text/javascript">
                                        Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'remove_${v}', event: 'onclick', formId: 'step3', params: {fragments: "body", index: "${v}"}}));
                                    </script>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <table style="width: 500px; height: 61px; text-align: left; margin-left: auto; margin-right: auto; border:2; ">
                                    <tbody>
                                        <tr>
                                            <td width="25%">中文姓名:</td>
                                            <td width="25%">${registrant.person.chineseName}</td>
                                             
                                             
                                            <td width="25%">性別 Gender:</td>
                                            <td width="25%">
                                                <c:set var="vgender" value="${registrant.person.gender}" />
                                                <c:if test= "${vgender == 'M' }" > <c:set var="vgender" value="男" /></c:if>
                                                <c:if test="${vgender == 'F' }"> <c:set var="vgender" value="女" /></c:if>
                                                ${vgender}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>English Lastname:</td>
                                            <td>${registrant.person.lastName}</td>
                                            <td>English Firstname:</td>
                                            <td>${registrant.person.firstName}</td>
                                        </tr>
                                        <tr>
                                            <td>年龄/年龄段 Age/Age Group:</td>
                                            <td>
                                                <c:set var="vage" value="${registrant.person.age}" />
                                                <c:if test= "${vage == 'A2' }" > <c:set var="vage" value="18-30" /></c:if>
                                                <c:if test= "${vage == 'A3' }" > <c:set var="vage" value="31-40" /></c:if>
                                                <c:if test= "${vage == 'A4' }" > <c:set var="vage" value="41-50" /></c:if>
                                                <c:if test= "${vage == 'A5' }" > <c:set var="vage" value="51-60" /></c:if>
                                                <c:if test= "${vage == 'A6' }" > <c:set var="vage" value="61+" /></c:if>
                                                <c:if test= "${vage == '17' }" > <c:set var="vage" value="17" /></c:if>
                                                <c:if test= "${vage == '16' }" > <c:set var="vage" value="16" /></c:if>
                                                <c:if test= "${vage == '15' }" > <c:set var="vage" value="15" /></c:if>
                                                <c:if test= "${vage == '14' }" > <c:set var="vage" value="14" /></c:if>
                                                <c:if test= "${vage == '13' }" > <c:set var="vage" value="13" /></c:if>
                                                <c:if test= "${vage == '12' }" > <c:set var="vage" value="12" /></c:if>
                                                <c:if test= "${vage == '11' }" > <c:set var="vage" value="11" /></c:if>
                                                <c:if test= "${vage == '10' }" > <c:set var="vage" value="10" /></c:if>
                                                <c:if test= "${vage == '9' }" > <c:set var="vage" value="9" /></c:if>
                                                <c:if test= "${vage == '8' }" > <c:set var="vage" value="8" /></c:if>
                                                <c:if test= "${vage == '7' }" > <c:set var="vage" value="7" /></c:if>
                                                <c:if test= "${vage == '6' }" > <c:set var="vage" value="6" /></c:if>
                                                <c:if test= "${vage == '5' }" > <c:set var="vage" value="5" /></c:if>
                                                <c:if test= "${vage == '4' }" > <c:set var="vage" value="4" /></c:if>
                                                <c:if test= "${vage == '3' }" > <c:set var="vage" value="3" /></c:if>
                                                <c:if test= "${vage == '2' }" > <c:set var="vage" value="2" /></c:if>
                                                <c:if test= "${vage == '1' }" > <c:set var="vage" value="1" /></c:if>
                                                <c:if test= "${vage == '0' }" > <c:set var="vage" value="0" /></c:if>
                                                ${vage}
                                            </td>
                                            <td>年级 Grade:</td>
                                            <td>
                                                <c:set var="vgrade" value="${registrant.person.status}" />
                                                <c:if test= "${vgrade == '12th' }" > <c:set var="vgrade" value="十二年级" /></c:if>
                                                <c:if test= "${vgrade == '11th' }" > <c:set var="vgrade" value="十一年级" /></c:if>
                                                <c:if test= "${vgrade == '10th' }" > <c:set var="vgrade" value="十年级" /></c:if>
                                                <c:if test= "${vgrade == '9th' }" > <c:set var="vgrade" value="九年级" /></c:if>
                                                <c:if test= "${vgrade == '8th' }" > <c:set var="vgrade" value="八年级" /></c:if>
                                                <c:if test= "${vgrade == '7th' }" > <c:set var="vgrade" value="七年级" /></c:if>
                                                <c:if test= "${vgrade == '6th' }" > <c:set var="vgrade" value="六年级" /></c:if>
                                                <c:if test= "${vgrade == 'EL' }" > <c:set var="vgrade" value="小学生" /></c:if>
                                                <c:if test= "${vgrade == 'TO' }" > <c:set var="vgrade" value="幼儿" /></c:if>
                                                <c:if test= "${vgrade == 'O' }" > <c:set var="vgrade" value="其他" /></c:if>
                                                ${vgrade}
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>Health Card Number:</td>
                                            <td colspan="3">${registrant.person.healthCardNo}</td>
                                        </tr>

                                        <tr>
                                            <td>关系 夫妻/子女等:</td>
                                            <td>
                                                <c:set var="vrelation" value="${registrant.person.relationship}" />
                                                <c:if test= "${vrelation == 'P' }" > <c:set var="vrelation" value="主报人" /></c:if>
                                                <c:if test= "${vrelation == 'H' }" > <c:set var="vrelation" value="丈夫" /></c:if>
                                                <c:if test= "${vrelation == 'W' }" > <c:set var="vrelation" value="妻子" /></c:if>
                                                <c:if test= "${vrelation == 'S' }" > <c:set var="vrelation" value="儿子" /></c:if>
                                                <c:if test= "${vrelation == 'D' }" > <c:set var="vrelation" value="女儿" /></c:if>
                                                <c:if test= "${vrelation == 'F' }" > <c:set var="vrelation" value="父亲" /></c:if>
                                                <c:if test= "${vrelation == 'M' }" > <c:set var="vrelation" value="母亲" /></c:if>
                                                <c:if test= "${vrelation == 'B' }" > <c:set var="vrelation" value="兄弟" /></c:if>
                                                <c:if test= "${vrelation == 'T' }" > <c:set var="vrelation" value="姊妹" /></c:if>
                                                <c:if test= "${vrelation == 'C' }" > <c:set var="vrelation" value="同学" /></c:if>
                                                <c:if test= "${vrelation == 'O' }" > <c:set var="vrelation" value="同事" /></c:if>
                                                ${vrelation}
                                           </td>
                                            <td>信主 Christian:</td>
                                            <td>
                                                <c:set var="vchristian" value="${registrant.person.acceptedChrist}" />
                                                <c:if test= "${vchristian == 'true' }" > <c:set var="vchristian" value="是" /></c:if>
                                                <c:if test= "${vchristian == 'false' }" > <c:set var="vchristian" value="否" /></c:if>
                                                ${vchristian}
                                             </td>
                                        </tr>
                                        <tr>
                                            <td>语言 Language:</td>
                                            <td>
                                                <c:set var="vlanguage" value="${registrant.person.preferredLanguage}" />
                                                <c:if test= "${vlanguage == 'M' }" > <c:set var="vlanguage" value="普通话" /></c:if>
                                                <c:if test= "${vlanguage == 'C' }" > <c:set var="vlanguage" value="广东话" /></c:if>
                                                <c:if test= "${vlanguage == 'E' }" > <c:set var="vlanguage" value="英文" /></c:if>
                                                ${vlanguage}
                                            </td>

                                            <td>翻译耳机 <br>
                                                Interpreter Headphone: </td>
                                            <td>
                                                <c:set var="vheadphone" value="${registrant.person.headphone}" />
                                                <c:if test= "${vheadphone == '' }" > <c:set var="vheadphone" value="不需要" /></c:if>
                                                <c:if test= "${vheadphone == 'MtoC' }" > <c:set var="vheadphone" value="粤语耳机" /></c:if>
                                                <c:if test= "${vheadphone == 'MtoE' }" > <c:set var="vheadphone" value="英语耳机" /></c:if>
                                                ${vheadphone}
                                                
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>事奉角色:</td>
                                            <td colspan="3">
                                                <c:set var="vservingRole" value="${registrant.person.servingRole}" />
                                                <c:if test= "${vservingRole == '1' }" > <c:set var="vservingRole" value="牧师/传道人" /></c:if>
                                                <c:if test= "${vservingRole == '2' }" > <c:set var="vservingRole" value="神学生" /></c:if>
                                                <c:if test= "${vservingRole == '3' }" > <c:set var="vservingRole" value="教会长执/团契同工" /></c:if>
                                                <c:if test= "${vservingRole == '4' }" > <c:set var="vservingRole" value="福音机构同工" /></c:if>
                                                <c:if test= "${vservingRole == '5' }" > <c:set var="vservingRole" value="教会成员" /></c:if>
                                                <c:if test= "${vservingRole == '6' }" > <c:set var="vservingRole" value="慕道友" /></c:if>
                                                ${vservingRole}
                                            </td>
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
            
            <c:set var="ushers" value=" " />
            <c:set var="nursery_helper" value=" " />
            <c:set var="interpreter" value=" " />
            <c:set var="audio_visual" value=" " />
            <c:set var="followup" value=" " />
            <c:set var="transportation" value=" " />
            <c:set var="medical_support" value=" " />
            <c:set var="other" value=" " />
            <c:set var="small_group_leader" value=" " />

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
                <c:if test="${registrant.volunteerJobs.contains(se) && se=='SMALL_GROUP_LEADER' }"><c:set var="small_group_leader" value="Y" /></c:if>
            </c:forEach>
            <div>
                <table style="text-align: left; width: 500px; height: 62px;" align="center" border="0" cellpadding="2" cellspacing="2">
                    <tbody>
                        <tr>
                            <td colspan="4" rowspan="1" align="center"><b>大会义工</b></td>
                        </tr>
                        <tr>
                            <td style="width:25%">招待 &nbsp;${ushers}</td>
                            <td style="width:25%">幼儿看顾 &nbsp;${nursery_helper}</td>
                            <td style="width:25%">翻译 &nbsp;${interpreter}</td>
                            <td style="width:25%">音影 &nbsp;${audio_visual}</td>
                        </tr>
                        <tr>
                            <td style="width:25%">陪谈 &nbsp;${followup}</td>
                            <td style="width:25%">交通 &nbsp;${transportation}</td>
                            <td style="width:25%">医疗 &nbsp;${medical_support}</td>
                            <td style="width:25%">其他 &nbsp;${other}</td>
                        </tr>
                        <tr>
                            <td colspan="4">Youth group leader &nbsp;${small_group_leader}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <hr style="width: 70%; height: 2px;">
            <div>
                <table style="text-align: left; width: 500px; height: 62px;" align="center" border="0" cellpadding="2" cellspacing="2">
                    <tbody>
                        <tr>
                            <td colspan="3" rowspan="1"><b>订餐</b></td>
                        </tr>
                        <tr>
                            <td style="text-align:center">Dec. 28</td>
                            <td style="text-align:center">Dec. 29</td>
                            <td style="text-align:center">Dec. 30</td>
                        </tr>
                        <tr>
                            <td style="width:33%;text-align:center">午餐 &nbsp;&nbsp;${registrant.mealplan.lunch1}</td>
                            <td style="width:33%;text-align:center">午餐 &nbsp;&nbsp;${registrant.mealplan.lunch2}</td>
                            <td style="width:33%;text-align:center">午餐 &nbsp;&nbsp;${registrant.mealplan.lunch3}</td>
                        </tr>
                        <tr>
                            <td style="width:33%;text-align:center">晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner1}</td>
                            <td style="width:33%;text-align:center">晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner2}</td>
                            <td style="width:33%;text-align:center">晚餐 &nbsp;&nbsp;${registrant.mealplan.dinner3}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
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

<script type="text/javascript">
    function toggleDiv( area ){
        var toggleDivision = document.getElementById( area );
        if( !toggleDivision )return true;
        if( toggleDivision.style.display == "none" ){
            toggleDivision.style.display = "block";
        }
        else{
            toggleDivision.style.display="none";
        }
        return true;
    }
    
</script>
