<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="success">网上注册成功!</p>
    <div>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <a id="OLE_LINK8" name="OLE_LINK8"><span style=""><span lang="ZH-CN" style=
                                                                    "font-size: 12pt; font-family: SimHei; color: blue;">亲爱的弟兄姊妹：</span></span></a><span style=""><span style=""><span style="font-size: 12pt; font-family: SimHei; color: blue;"></span></span></span></p>
        <br/>

        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span style=""><span style=""><span lang="ZH-CN" style=
                                                "font-size: 12pt; font-family: SimHei; color: blue;">祝贺您在网上注册参加"中国福音大会</span></span></span><span style=""><span style=""><span style="font-size: 12pt; font-family: SimHei; color: blue;">2015<span lang="ZH-CN">"成功。您在网上报名的大会</span>ID<span lang="ZH-CN">为:</span><span style="background: lime none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">${form.formID}</span></span></span></span><span style=""><span style=""><span lang="ZH-CN"
                                                                                                                                                                                                        style=
                                                                                                                                                                                                        "font-size: 12pt; font-family: SimHei; color: blue;">。</span></span></span><span style=""><span style=""><span style="font-size: 12pt; font-family: SimHei; color: blue;"><span lang="ZH-CN">您注册的详细资料如下：</span></span></span></span></p>

        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span style=""><span style=""><span style=
                                                "font-size: 12pt; font-family: SimHei; color: blue;">&nbsp;</span></span></span></p>

        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></p>
                    <c:forEach items="${form.registrants}" var="registrant" varStatus="count">

            <p class="MsoNormal"
               style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                    style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN"> 
                    <c:set var="vrelation2" value="${registrant.person.relationship}" />
                    <c:if test= "${vrelation2 == 'P' }" > <c:set var="vrelation2" value="主报人" /></c:if>
                    <c:if test= "${vrelation2 == 'H' }" > <c:set var="vrelation2" value="丈夫" /></c:if>
                    <c:if test= "${vrelation2 == 'W' }" > <c:set var="vrelation2" value="妻子" /></c:if>
                    <c:if test= "${vrelation2 == 'S' }" > <c:set var="vrelation2" value="儿子" /></c:if>
                    <c:if test= "${vrelation2 == 'D' }" > <c:set var="vrelation2" value="女儿" /></c:if>
                    <c:if test= "${vrelation2 == 'F' }" > <c:set var="vrelation2" value="父亲" /></c:if>
                    <c:if test= "${vrelation2 == 'M' }" > <c:set var="vrelation2" value="母亲" /></c:if>
                    <c:if test= "${vrelation2 == 'B' }" > <c:set var="vrelation2" value="兄弟" /></c:if>
                    <c:if test= "${vrelation2 == 'T' }" > <c:set var="vrelation2" value="姊妹" /></c:if>
                    <c:if test= "${vrelation2 == 'C' }" > <c:set var="vrelation2" value="同学" /></c:if>
                    <c:if test= "${vrelation2 == 'O' }" > <c:set var="vrelation2" value="同事" /></c:if>
                    ${vrelation2}: ${registrant.person.chineseName} ${registrant.person.firstName} ${registrant.person.lastName}</span>
            </p>
        </c:forEach>
        <p class="MsoNormal" style=
           "margin: 0in 0in 0.0001pt 0.5in; line-height: normal;">
            <span lang="ZH-CN" style="font-size: 12pt; font-family: SimHei; color: blue;">
                餐费：${form.paymentCurrency} $${form.expense.totalMealsFee}</span>
        </p>
        <br/>
        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span style=""><span style=""><span lang="ZH-CN" style=
                                                "font-size: 12pt; font-family: SimHei; color: blue;">
                        您已经在网上支付大会费用：</span></span></span><span style=""><span style=""><span style=
                                                                                  "background: lime none repeat scroll 0% 50%; font-size: 12pt; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}</span></span></span><span style=""><span style=""><span lang="ZH-CN"
                                                                                                                                                                                                        style="font-size: 12pt; font-family: SimHei; color: blue;">，
                        其中报名费：</span></span></span><span style=""><span style=""><span style=
                                                                           "background: lime none repeat scroll 0% 50%; font-size: 12pt; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">${form.paymentCurrency} $${form.expense.totalRegistrationFee}</span></span></span><span style=""><span style=""><span lang="ZH-CN"
                                                                                                                                                                                                        style="font-size: 12pt; font-family: SimHei; color: blue;">，
                        餐费：</span></span></span><span style=""><span style=""><span style=
                                                                        "background: lime none repeat scroll 0% 50%; font-size: 12pt; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">${form.paymentCurrency} $${form.expense.totalMealsFee}</span></span></span><span style=""><span style=""><span lang="ZH-CN"
                                                                                                                                                                                                        style="font-size: 12pt; font-family: SimHei; color: blue;">。<span style=
                                                                                      "background: lime none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;"></span></span></span></span><span style=""><span style=""><span style=
                                                                                                                                                                                                        "font-size: 12pt; font-family: SimHei; color: blue;"></span></span></span></p>

        <br/>
        <p class="MsoNormal"><span style=""><span style=
                                                  "font-weight: bold;"><span lang="ZH-CN" style=
                                           "background: yellow none repeat scroll 0% 50%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                        敬请您留意以下会前注意事项：</span></span></span><span style=""><span style=
                                                                    "font-weight: bold;"><span style=
                                           "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"></span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=
                                                  "font-weight: bold;"><span style=
                                           "background: yellow none repeat scroll 0% 50%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                        1<span lang="ZH-CN">．若您需要住宿，请您击点这里的链接</span> https<span lang=
                                                                                "ZH-CN"></span>://www.cclifefl.org<span lang=
                                                                                "ZH-CN">，其中有预订旅馆房间的方法及大会优惠价格</span>code<span lang=
                                                                                "ZH-CN">。</span></span></span></span> <span style=""><span style=
                                                                       "font-weight: bold;"><span style=
                                           "font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96);">
                    </span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=""><span style=
                                                                 "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">2<span lang="ZH-CN">．<a id="OLE_LINK6"
                                                                                                                    name="OLE_LINK6"><span style="">"中国福音大会</span></a></span><span style=
    ""><span style="">2015<span lang="ZH-CN">"将于</span>12<span lang=
                                                                                 "ZH-CN">月</span>28<span lang="ZH-CN">日上午</span>9<span lang=
                                                                                 "ZH-CN">:</span>00<span lang="ZH-CN">开 幕，</span>30<span lang=
                                                                                 "ZH-CN">日晚上</span>9<span lang="ZH-CN">:</span>30<span lang=
                                                                                 "ZH-CN">结束。外地赴会者请订机票抵达多伦多机场（</span>Toronto Pearson International Airport
                                <span lang="ZH-CN">机场代码：</span>YZZ, <span lang=
                                                                          "ZH-CN">机场网站：</span>http://www.torontopearson.com/<span lang=
                                                                          "ZH-CN">）</span></span></span><span lang="ZH-CN">，<b style=""><span style=
                                                                                            "background: yellow none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                                    您需要在</span></b></span><b style=""><span style=
                                                                "background: yellow none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">27<span lang="ZH-CN">日下午到达，</span>31<span lang="ZH-CN">日上午离开</span></span></b><span lang="ZH-CN">。大会场地及住宿地均在机场附近。</span></span></span></span><a id="OLE_LINK1"
                                                                                                                                                                                                        name="OLE_LINK1"><span style=""><span style=""><span style=""><span style=
    ""><span style=""><span style=""><span lang="ZH-CN" style=
                                                                 "background: aqua none repeat scroll 0% 50%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">开车赴会者请输入您预订旅馆的地址，在</span></span>
                                </span></span></span></span></span></a><span style=""><span style=
    ""><span style=""><span style=""><span style=""><span style=""><span style=
    ""><span style=
                                           "background: aqua none repeat scroll 0% 50%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">google<span lang="ZH-CN">中查询旅行指南。</span></span></span>
                                </span></span></span></span><span style=""></span><span style=
    ""></span><span style=""></span><span style=""><span style=""><span style=
    ""><span style=""><span style=
                                                  "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"></span></span></span></span></span></span></span></p><span style=""></span><span style=""></span>

        <p class="MsoNormal"><span style=""><span style=""><span style=
                                                                 "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">3<span lang="ZH-CN">．若您因故需要取消大会报名的话，敬请您直接发电子邮件至</span></span></span></span><a href="mailto:cclife@sbcglobal.net"><span style=""><span style=""><span style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">cclife@sbcglobal.net</span></span></span><span style=""><span style=""></span></span></a><span style=""><span style=""><span style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><span lang="ZH-CN">，同工们在收到您的电邮后，会以支票的形式退还给您费用（注意：报名费不能退还，餐费可以退，但</span>12<span lang="ZH-CN">月</span>10<span lang="ZH-CN">日以后，餐费也不能退还，敬请谅解）。敬请不要私自通知信用卡
                            公司</span>Cancel Payment<span lang="ZH-CN">，若您</span>Cancel<span lang=
                                                                                        "ZH-CN">的话，大会将会支付信用 卡公司更多的罚款。谢谢您的合作。</span></span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=""><span style=
                                                                 "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">4<span lang="ZH-CN">．请您常常浏览大会网页（</span></span></span></span><a href="http://www.cclifefl.org/"><span style=""><span style=""><span style="font-family: SimHei; color: windowtext; text-decoration: none;">www.cclifefl.org</span></span></span></a><span style=""><span style=""><span style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><span lang="ZH-CN">），我们会及时更新关于福音大会的筹备进展。<b style=""><span style="background: yellow none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">
                                    我们会在</span></b></span><b style=""><span style=
                                                                "background: yellow none repeat scroll 0% 50%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">12<span lang="ZH-CN">月初给您寄出福音大会赴会的资料（包括大会名牌及大会餐券），敬请您届时留意。</span>
                            </span></b></span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=""><span style=
                                                                 "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">5<span lang="ZH-CN">．我们也会通过微信及时发布大会筹备进展及赴会注意事项，您若使用微信，敬请您扫描生命季刊微信二维码:</span></span></span></span><br>

            <img alt="qrcode" height="100" src=
                 "http://gfcc21c.com/gfcc2015/resources/styles/images/qrcode.jpg" width=
                 "100"></p>

        <p class="MsoNormal"><span style=""><span style=""><span style=
                                                                 "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><span lang="ZH-CN">
                            <br></span></span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=
                                                  "font-weight: bold;"><span style=
                                           "font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"></span></span></span></p>

        <p class="MsoNormal"><span style=""><span style=""><span lang="ZH-CN"
                                                                 style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">
                        敬请您为大会代祷，愿神借着这次大会使我们"回归圣经、活出圣洁、火热宣教、教会复兴"！愿神祝福你！</span></span></span><span style=""><span style=""><span style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"></span></span></span></p>

        <p class="MsoNormal" style="margin-bottom: 0.0001pt; line-height: normal;">
            <span style=""><span style=""><span lang="ZH-CN" style=
                                                "font-size: 12pt; font-family: SimHei;">生命季刊同工</span></span></span><span style=""><span style=""><span style="font-size: 12pt; font-family: SimHei;"></span><br>

                    <span lang="ZH-CN" style=
                          "font-family: SimHei; color: black;">生命季刊网页：</span></span></span><span style=""><span style=""></span></span><a href="http://cclifefl.org/"><span style=""><span style=""><span style="">http://cclifefl.org/</span></span></span><span style=""><span style=""></span></span></a><span style=""><span style=""><span style="color: blue;"></span><br>

                    <span lang="ZH-CN" style=
                          "font-family: SimHei; color: black;">生命季刊微信公共号</span></span></span><span style=""><span style=""><span lang="ZH-CN"
                                                                                                                   style=
                                                                                                                   "font-family: SimHei; color: blue;">：</span></span></span><span style=""><span style=""><span style="background: yellow none repeat scroll 0% 50%; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">cclife2013gmail<br>
                    </span></span></span> <span style=""><span style=""><span lang="ZH-CN"
                                                                      style=
                                                                      "font-family: SimHei; color: black;">生命季刊博客：</span></span></span><span style=""><span style=""></span></span><a href="http://blog.sina.com.cn/pinesther"><span style=""><span style=""><span style="">http://blog.sina.com.cn/pinesther</span></span></span><span style=""><span style=""></span></span></a><span style=""><span style=""><span style="color: blue;"></span><br>

                    <span lang="ZH-CN" style=
                          "font-family: SimHei; color: black;">生命季刊微博：</span></span></span><span style=""><span style=""></span></span><a href="http://weibo.com/cclifeusa/profile"><span style=""><span style=""><span style="">http://weibo.com/cclifeusa/profile</span></span></span><span style=""><span style=""></span></span></a><span style=""><span style=""><span style="color: blue;"><span style="">&nbsp;&nbsp;&nbsp;&nbsp;</span></span></span></span>
            <span style=""><span style=""><span lang="ZH-CN" style=
                                                "font-family: SimHei; color: blue;">电话:</span></span></span><span style=
    ""><span style=""><span style=
                                  "color: blue;">630-87-7551</span></span></span><span style=""><span style=
    ""><span lang="ZH-CN" style="font-family: SimHei; color: blue;">
                        （美国）</span></span></span><span style=""><span style=""><span style=
                                                                         "color: blue;"></span></span></span></p><span style=""></span><span style=
    ""></span>

        <p class="MsoNormal">&nbsp;</p> 

        <p>
            <a id="startFlow" href="cccc-flow">Start Over</a>
            <script type="text/javascript">
                Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
            </script>
        </p>	
    </div>
</div>