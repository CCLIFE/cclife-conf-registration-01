<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="notice"><b>2. 请输入个人信息<br>step 2 - Enter individual information</b><br></p>

    <li><font color='red'>有 * 號的攔目務必填寫 (* indicates required field) <br></font></li>
    <li><font color='red'>所添加人员须与主报人同一地址，并由同一人付费 (Newly added registrant needs to have the same mailing 
        address as the primary person, and all fees are paid by the same person.)</font></li>

    <form:form id="step2" action="${flowExecutionUrl}" modelAttribute="registrant" acceptCharset="UTF-8">
        <form:hidden  path="countryVal" id="country" />
        <form:hidden  path="person.relationship" id="relationValue" />

        <script>
            document.getElementById("country").value = "${form.address.country}";
        </script>
        
        <table
            style="text-align: left; margin-left: auto; margin-right: auto;">
            <tbody>
                <tr>
                    <td>
                        <table
                            style="text-align: left; margin-left: auto; margin-right: auto;">
                            <tbody>
                                <tr> 
                                    <td>中文姓名:</td>
                                    <td><form:input path="person.chineseName" size="20"  /></td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.firstName" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>English Firstname:<font color="red"> &nbsp;* &nbsp;</font></td>
                                    <td><form:input id="firstName" path="person.firstName" size="20" maxlength="30"/></td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.lastName" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>English Lastname:<font color="red"> &nbsp;* &nbsp;</font></td>
                                    <td><form:input id="lastName" path="person.lastName" size="20" maxlength="30"/></td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.gender" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>性别 Gender:<font color="red"> &nbsp;* &nbsp;</font></td>
                                    <td>
                                        男 Male <form:radiobutton path="person.gender" value="M" />
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        女 Female <form:radiobutton path="person.gender" value="F" />
                                    </td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.age" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>年龄 Age/Age Group:<font color="red"> &nbsp;* &nbsp;</font></td>
                                    <td>
                                        <form:select id="age" path="person.age">
                                            <form:option value="" label="-- Select Age --" />
                                            <form:options items="${form.ageGroup}" itemValue="value" itemLabel="label" />
                                        </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.status" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>年级 Grade: <br> (18岁以下请填写)</td>
                                    <td>
                                        <form:select id="gradeStatus" path="person.status">
                                            <form:option value="" label="-- Select Status --" />
                                            <form:options items="${form.statusGroup2}" itemValue="value" itemLabel="label" />
                                        </form:select>
                                    </td>
                                </tr>

                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.healthCardNo" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>Health Card Number <font color="red"> &nbsp;* &nbsp;</font><br>（加拿大 18 歲以下請必須填寫）</td>
                                    <td>
                                        <form:input id="healthCardNo" path="person.healthCardNo" size="30" maxlength="50"/>
                                    </td>
                                </tr>

                                <tr>
                                    <td>与主报人关系 <br>Relationship with <br>primary person</td>
                                    <td>                                  
                                        <select id="relationStatus" onchange="setRelationValue();"> 
                                            <option value="" label="-- Select relationship --" />
                                            <option value="H" label="H 丈夫" />
                                            <option value="W" label="W 妻子" />
                                            <option value="S" label="S 兒子" />
                                            <option value="D" label="D 女兒" />
                                            <option value="F" label="F 父親" />
                                            <option value="M" label="M 母親" />
                                            <option value="B" label="B 兄弟" />
                                            <option value="T" label="T 姊妹" />
                                            <option value="C" label="C 同学" />
                                            <option value="O" label="O 同事" />
                                        <select>
                                    </td>
                                </tr>
                                <script type="text/javascript">
                                    function setRelationValue(){
                                        var rel = document.getElementById( "relationStatus" );
                                        var relVal = rel.options[rel.selectedIndex].value;

                                        document.getElementById( "relationValue").value=relVal;
                                    }
                                    function setPrimary(){
                                        var size = "${form.registrants.size()}";
                                        var relVal = document.getElementById( "relationStatus" ).value;

                                        if(( size==1 ) || ( relVal == "P" )){
                                            var relList = document.getElementById( "relationStatus" );
                                            var opt = new Option("P 主報人", "P");               

                                            relList.appendChild(opt);
                                            relList.value="P";
                                            relList.disabled=true;

                                            document.getElementById( "relationValue").value = "P";
                                        }
                                        else{
                                            document.getElementById( "relationStatus").value = "${registrant.person.relationship}";
                                        }
                                    }
                                    setPrimary();
                                </script>
                                    
                                
                                <tr>
                                    <td>语言 Language:</td>
                                    <td>
                                        <form:select id="language" path="person.preferredLanguage">
                                            <form:options items="${form.languages}" itemValue="value" itemLabel="label" />
                                        </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>翻译耳机 
                                        Interpreter Headphone: <br>
                                        (如果您听不懂普通话， <br>可以选择翻译耳机)</td>
                                    <td>                                       
                                        <form:select id="headphone" path="person.headphone">
                                            <form:option value="" label="-- 不需要 (No Need) --" />
                                            <form:options items="${form.headphones}" itemValue="value" itemLabel="label" />
                                        </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td  colspan="2" style="text-align:center"> <form:errors path="person.email" cssClass="fieldError"/></td>
                                </tr>
                                <tr>
                                    <td>电邮 &nbsp;Email:</td>
                                    <td><form:input id="email" path="person.email" size="30" maxlength="50"/></td>
                                </tr>

                                <tr>
                                    <td>信主 Christian:</td>
                                    <td>

                                        是 Yes <form:radiobutton path="person.acceptedChrist" value="1"/>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                        否 No<form:radiobutton path="person.acceptedChrist" value="0"/> <br>

                                    </td>
                                </tr>
                                <tr>
                                    <td>事奉角色:</td>
                                    <td>
                                        <form:select id="status" path="person.servingRole">
                                            <form:option value="" label="-- 事奉 --" />
                                            <form:options items="${form.statusGroup}" itemValue="value" itemLabel="label" />
                                        </form:select>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </td>
                </tr>
            </tbody>
        </table>
        <hr style="width: 80%; height: 2px;">


        <table style="text-align: left; width: 500px; height: 62px;"
               align="center" border="0" cellpadding="2" cellspacing="2">
            <tbody>
                <tr>
                    <td colspan="4" rowspan="1" align="center"><b>我愿意做义工，参与大会事奉</b></td>
                </tr>
                <tr>
                    <td></td>
                    <td> <form:errors path="volunteerJobs" cssClass="fieldError"/></td>
                </tr>
                <tr>
                    <td style="width:25%">招待 &nbsp;<form:checkbox path="volunteerJobs" value="USHERS"/></td>
                    <td style="width:25%">幼儿看顾 &nbsp;<form:checkbox path="volunteerJobs" value="NURSERY_HELPER"/></td>
                    <td style="width:25%">翻译 &nbsp;<form:checkbox path="volunteerJobs" value="INTERPRETER"/></td>
                    <td style="width:25%">音影 &nbsp;<form:checkbox path="volunteerJobs" value="AUDIO_VISUAL"/></td>
                </tr>
                <tr>
                    <td style="width:25%">陪谈 &nbsp;<form:checkbox path="volunteerJobs" value="FOLLOWUP"/></td>
                    <td style="width:25%">交通 &nbsp;<form:checkbox path="volunteerJobs" value="TRANSPORTATION"/></td>
                    <td style="width:25%">医疗 &nbsp;<form:checkbox path="volunteerJobs" value="MEDICAL_SUPPORT"/></td>
                    <td style="width:25%">其他 &nbsp;<form:checkbox path="volunteerJobs" value="OTHER"/></td>
                </tr>
                <tr>
                    <td colspan="4">Youth Small Group Leader &nbsp;<form:checkbox path="volunteerJobs" value="SMALL_GROUP_LEADER"/></td>
                </tr>
            </tbody>
        </table>
        <hr style="width: 80%; height: 2px;">
        <table
            style="text-align: center; margin-left: auto; margin-right: auto;">
            <tbody>
                <tr>
                    <td colspan="3">
                        <b>我需要订餐<br></b>(大会提供28，29，30日三天的午餐和晚餐。午餐美金$6/加元$7，晚餐美金$7/加元$8，沒有兒童餐。12 月 10 日後，若退餐，餐费恕無法退還。)
                    </td>
                </tr>
                <tr>
                    <td style="text-align:center">Dec. 28</td>
                    <td style="text-align:center">Dec. 29</td>
                    <td style="text-align:center">Dec. 30</td>
                </tr>
                <tr>
                    <td style="width:33%;text-align:center">午餐 &nbsp;<form:checkbox id="l1" path="mealplan.lunch1" value="1"/></td>
                    <td style="width:33%;text-align:center">午餐 &nbsp;<form:checkbox id="l2" path="mealplan.lunch2" value="1"/></td>
                    <td style="width:33%;text-align:center">午餐 &nbsp;<form:checkbox id="l3" path="mealplan.lunch3" value="1"/></td>
                </tr>
                <tr>
                    <td style="width:33%;text-align:center">晚餐 &nbsp;<form:checkbox id="d1" path="mealplan.dinner1" value="1"/></td>
                    <td style="width:33%;text-align:center">晚餐 &nbsp;<form:checkbox id="d2" path="mealplan.dinner2" value="1"/></td>
                    <td style="width:33%;text-align:center">晚餐 &nbsp;<form:checkbox id="d3" path="mealplan.dinner3" value="1"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button id="selectAll" type="button" onclick="selectAllMeal();">全选 (select all)</button></td>
                    <td>${person.status}</td>
                </tr>
            </tbody>
        </table>
        <hr style="width: 80%; height: 2px;">

        <button id="cancel" type="submit" name="_eventId_cancel">Cancel</button>
        <!--
        <button id="previous" type="submit" name="_eventId_previous">&lt;&lt; Previous</button>
        <button id="popup" type="submit" name="_eventId_popup" >Popup &gt;&gt;</button>
        -->
        <button id="next" type="submit" name="_eventId_next">Next &gt;&gt;</button>

        
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'next', event: 'onclick', formId: 'step2', params: {fragments: "body"}}));
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: 'cancel', event: 'onclick', formId: 'step2', popup: true, params: {fragments: "body"}}));
        </script>

    </form:form>
</div>

<script type="text/javascript">
    function selectAllMeal() {
        document.getElementById("l1").checked = true;
        document.getElementById("l2").checked = true;
        document.getElementById("l3").checked = true;
        document.getElementById("d1").checked = true;
        document.getElementById("d2").checked = true;
        document.getElementById("d3").checked = true;
    }
    
    var e = document.getElementById("relationship");
    var value = e.options[e.selectedIndex].value;
    if (value === "A") {
        e.disabled = true ;
    }
</script>
