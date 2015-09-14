<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow"  class="span-18">
    <p class="success">PAY BY CHECK!</p>
    <div>
        <div id="content" align="left">
            <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
                <span style="font-size: 12pt; font-family: SimHei;" lang="ZH-CN">亲爱的弟兄姊妹：</span></a> 
            </p>
            <br/>
            <p class="MsoNormal"
               style="margin-bottom: 0.0001pt; line-height: normal;"><span style=""><span
                        style=""><span
                            style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">
                            谢谢您报名参加</span></span></span><span style=""><span style=""><span
                            style="font-size: 12pt; font-family: SimHei; color: blue;">2015<span
                                lang="ZH-CN">年中国福音大会，您在网上报名的大会</span>ID<span lang="ZH-CN">为：</span><b
                                style="">${form.formID}</b><span lang="ZH-CN">您注册的详细资料如下：</span><b style=""><o:p></o:p></b></span></span></span></p>
            <p class="MsoNormal" style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">
                <span style="font-size: 12pt; font-family: SimHei; color: blue;">                   
                </span>
            </p>
            <c:forEach items="${form.registrants}" var="registrant" varStatus="count">
                <p class="MsoNormal"
                   style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                        style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">
                        <c:set var="vrelation1" value="${registrant.person.relationship}" />
                        <c:if test= "${vrelation1 == 'P' }" > <c:set var="vrelation1" value="主报人" /></c:if>
                        <c:if test= "${vrelation1 == 'H' }" > <c:set var="vrelation1" value="丈夫" /></c:if>
                        <c:if test= "${vrelation1 == 'W' }" > <c:set var="vrelation1" value="妻子" /></c:if>
                        <c:if test= "${vrelation1 == 'S' }" > <c:set var="vrelation1" value="儿子" /></c:if>
                        <c:if test= "${vrelation1 == 'D' }" > <c:set var="vrelation1" value="女儿" /></c:if>
                        <c:if test= "${vrelation1 == 'F' }" > <c:set var="vrelation1" value="父亲" /></c:if>
                        <c:if test= "${vrelation1 == 'M' }" > <c:set var="vrelation1" value="母亲" /></c:if>
                        <c:if test= "${vrelation1 == 'B' }" > <c:set var="vrelation1" value="兄弟" /></c:if>
                        <c:if test= "${vrelation1 == 'T' }" > <c:set var="vrelation1" value="姊妹" /></c:if>
                        <c:if test= "${vrelation1 == 'C' }" > <c:set var="vrelation1" value="同学" /></c:if>
                        <c:if test= "${vrelation1 == 'O' }" > <c:set var="vrelation1" value="同事" /></c:if>
                        ${vrelation1}: ${registrant.person.chineseName} ${registrant.person.firstName} ${registrant.person.lastName}</span>
                </p>
            </c:forEach>
            <p class="MsoNormal" style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">

                <span lang="ZH-CN" style="font-size: 12pt; font-family: SimHei; color: blue;">
                    用餐：
                </span>

                <span style="font-size: 12pt; font-family: SimHei; color: blue;">${form.registrants.size()}人${form.expense.lunchCount + form.expense.dinnerCount}餐</span>

            </p>
            <p class="MsoNormal">
                <span style=
                      "font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;">&nbsp;</span>
            </p>
            <br>
            <p class="MsoNormal">

                <span style="">
                    <span lang="ZH-CN" style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;">
                        您所需付的大会费用是：</span>
                </span>
                <span style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;">${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}
                    <span lang=
                          "ZH-CN">，其中报名费：</span>$${form.expense.totalRegistrationFee}
                    <span lang=
                          "ZH-CN">，餐费：</span>$${form.expense.totalMealsFee}
                    <span lang=
                          "ZH-CN">。</span>
                </span>
            </p>
            <p class="MsoNormal">
                <span style=
                      "font-weight: bold">
                    <span lang="ZH-CN" style="background: yellow none repeat scroll 0% 50%; font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                        谢谢您选择以支票付款，请仔细阅读支票付费须知：
                    </span>
                </span>
            </p>
            <p class="MsoNormal">
                <span style=
                      "font-weight: bold">
                    <span style=
                          "background: yellow none repeat scroll 0% 50%; font-size: 12pt; line-height: 107%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                        1.
                        <span lang="ZH-CN">若您用美金支票付款：</span>
                    </span>
                </span>
            </p>
            <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">

                <span lang="ZH-CN" style="font-size: 12pt; font-family: SimHei; color: blue;">
                    支票抬头请写：
                </span>

                <span style=
                      "font-size: 12pt; font-family: SimHei; color: blue;">CCLIFE
                    <span lang=
                          "ZH-CN">，请在</span>Memo
                    <span lang=
                          "ZH-CN">中注明：福音大会报名费（或</span>GFCC2015
                    <span lang=
                          "ZH-CN">），并请注明您的大会报名</span>ID
                    <span lang=
                          "ZH-CN">。请将支票寄至：</span>
                </span>

            </p>
            <p class="MsoNormal" style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">
                <span style="">
                    <span style=
                          "font-size: 12pt; color: blue;">&nbsp;</span>
                </span>
            </p>
            <p class="MsoNormal" style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">
                <span style="">
                    <span style="font-size: 12pt; color: blue;">CCLIFE</span>
                </span>
            </p>
            <p class="MsoNormal" style=
               "margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">

                <span style="font-size: 12pt; color: blue;">670 Bonded
                    Parkway,</span>


            </p>
            <p class="MsoNormal" style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">

                <span style="">
                    <span style="font-size: 12pt; color: blue;">
                        Streamwood, IL 60107&nbsp;USA
                    </span>
                </span>
            </p>
            <br/>
            <p class="MsoNormal">
                <span style="font-weight: bold">
                    <span style="background: yellow none repeat scroll 0% 50%; font-size: 12pt; line-height: 107%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                        2.
                        <span lang="ZH-CN">若您用加币支票付款：</span>
                    </span>
                </span>
                <span style="font-weight: bold">
                    <span style=
                          "font-size: 12pt; line-height: 107%; font-family: SimHei; color: rgb(0, 32, 96);"></span>
                </span>
            </p>
            <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
                <span lang="ZH-CN" style=
                      "font-size: 12pt; font-family: SimHei; color: blue;">支票抬头请写：</span>
                <span lang="ZH-CN" style=
                      "font-size: 12pt; font-family: SimHei; color: blue;">CCLIFE
                    Canada，请在Memo中注明：福音大会报名费（或GFCC2015），并请注明您的大会报名ID
                    ${form.formID}。请将支票寄至：</span>
            </p>
            <br/>
            <p class="MsoNormal"
               style="margin-bottom: 0.0001pt; line-height: normal;"><span style=""><span
                        style=""><span
                            style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></span></span></p>
            <p class="MsoNormal"
               style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                    style=""><span style=""><span style="font-size: 12pt; color: blue;">CCLIFE
                            Canada<o:p></o:p></span></span></span></p>
            <p class="MsoNormal"
               style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                    style=""><span style=""><span style="font-size: 12pt; color: blue;">
                            PO Box 76575 Super Center<o:p></o:p></span></span></span></p>
            <p class="MsoNormal"
               style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                    style=""><span style=""><span style="font-size: 12pt; color: blue;">Markham,
                            L3R0N5 Canada<o:p></o:p></span></span></span></p>
            <p class="MsoNormal"><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></span></span></p>
            <p class="MsoNormal"><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"
                            lang="ZH-CN">我们在收到您的支票后，您的报名才算正式完成。届时您会收到正式的大会报名确认信。</span></span></span><span
                    style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"><o:p></o:p></span></span></span></p>
            <p class="MsoNormal"><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"
                            lang="ZH-CN">若您需要住宿，请浏览生命季刊网站（</span></span></span><a
                    href="http://www.cclifefl.org/"><span style=""><span style=""><span
                                style="font-size: 12pt; line-height: 107%; color: blue;">www.cclifefl.org</span></span></span></a><span
                    style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; color: blue;"> </span></span></span><span
                    style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"
                            lang="ZH-CN">）</span></span></span><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"
                            lang="ZH-CN">，查找预订旅馆房间的方法。</span></span></span><span style=""><span
                        style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"><span
                                style="">&nbsp; </span></span></span></span><span style=""><span
                        style=""><span style="font-size: 12pt; line-height: 107%; color: blue;"><o:p></o:p></span></span></span></p>
            <p class="MsoNormal"><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"
                            lang="ZH-CN">敬请您为大会代祷。愿神祝福你！</span></span></span><span style=""><span
                        style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei; color: blue;"><o:p></o:p></span></span></span></p>
            <p class="MsoNormal"><span style=""><span style=""><span
                            style="font-size: 12pt; line-height: 107%; font-family: SimHei;"><o:p>&nbsp;</o:p></span></span></span></p>

            <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
                <span lang="ZH-CN" style=
                      "font-size: 12pt; font-family: SimHei;">生命季刊同工</span><br/>
                <span lang="ZH-CN" style=
                      "font-family: SimHei; color: black;">生命季刊网页：</span><span style="color: blue;">
                          <a href="http://cclifefl.org/">http://cclifefl.org/</a></span>
                <br/>
                <span lang="ZH-CN" style=
                      "font-family: SimHei; color: black;">生命季刊微信公共号</span><span lang="ZH-CN"
                      style="font-family: SimHei; color: blue;">：</span><span style=
                      "background: yellow none repeat scroll 0%; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">cclife2013gmail<br>
                </span>
                <span lang="ZH-CN" style="font-family: SimHei; color: black;">
                    生命季刊博客：</span><span style="color: blue;"><a href="http://blog.sina.com.cn/pinesther">
                        http://blog.sina.com.cn/pinesther</a>
                </span>
                <br/>
                <span lang="ZH-CN" style=
                      "font-family: SimHei; color: black;">生命季刊微博：</span><a href=
                      "http://weibo.com/cclifeusa/profile">http://weibo.com/cclifeusa/profile</a><span style="color: blue;"></span>
                <br/>
                <span lang="ZH-CN" style=
                      "font-family: SimHei; color: blue;">电话：</span><span style=
                      "color: blue;">630-837-7551</span><span lang="ZH-CN" style=
                      "font-family: SimHei; color: blue;">（美国）</span><span style=
                      "color: blue;"></span>
            </p>
        </div>
        <hr style="width: 80%; height: 2px;">
        <a id="startFlow" href="cccc-flow">Start Over</a>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
        </script>
    </div>
</div>