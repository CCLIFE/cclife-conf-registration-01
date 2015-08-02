<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="span-2">
    <br/>
</div>
<div id="embeddedFlow" class="span-18">
    <p class="success">Registration successfully!</p>
    <div>
        <p class="MsoNormal" 
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">亲
                爱的弟兄</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">/<span
                    lang="ZH-CN">姊妹：</span><o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">
                祝贺您在网上注册参加“中国福音大会</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">2015<span
                    lang="ZH-CN">”成功。您在网上报名的大会</span>ID<span lang="ZH-CN">为：</span>${form.formID}.<span
                    lang="ZH-CN">您注册的详细资料如下：</span><o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></p>
        <p class="MsoNormal"
           style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">主
                报人：</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">XXX<o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">妻
                子：</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">XX<o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">儿
                子：</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">XX<o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin: 0in 0in 0.0001pt 0.5in; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">餐
                费：</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">$${form.expense.totalMealsFee}<o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;" lang="ZH-CN">您
                已经在网上支付大会费用：</span><span
                style="font-size: 12pt; font-family: SimHei; color: blue;">${form.paymentCurrency} $${form.expense.totalMealsFee + form.expense.totalRegistrationFee}<span
                    lang="ZH-CN">，其中报名费：</span>$${form.expense.totalRegistrationFee}<span lang="ZH-CN">，餐费：</span>${form.paymentCurrency} $${form.expense.totalMealsFee}<span
                    lang="ZH-CN">。</span><o:p></o:p></span></p>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei; color: blue;"><o:p>&nbsp;</o:p></span></p><br/>
        <p class="MsoNormal"><b style=""><span
                    style="background: yellow none repeat scroll 0%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;"
                    lang="ZH-CN">敬请您留意以下会前注意事项：</span></b><b style=""><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><o:p></o:p></span></b></p>
        <p class="MsoNormal"><b style=""><span
                    style="background: yellow none repeat scroll 0%; font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96); -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">1<span
                        lang="ZH-CN">．若您需要住宿，请您击点这里的链接</span>
                    Http<span lang="ZH-CN">：</span>//xxx<span lang="ZH-CN">，其中有预订旅馆房间的方法及大会优
                        惠价格</span>code<span lang="ZH-CN">。</span></span></b><b style=""><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: rgb(0, 32, 96);"><o:p></o:p></span></b></p>
        <p class="MsoNormal"><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">2<span
                    lang="ZH-CN">．“中国福音大会</span>2015<span lang="ZH-CN">”将于</span>12<span
                    lang="ZH-CN">月</span>28<span lang="ZH-CN">日上午</span>9<span lang="ZH-CN">：</span>00<span
                    lang="ZH-CN">开幕，</span>30<span lang="ZH-CN">日晚上</span>9<span
                    lang="ZH-CN">：</span>30<span lang="ZH-CN">结束。外地赴会者请订机票抵达多伦多机场（</span>Toronto
                Pearson International Airport <span lang="ZH-CN">机场代码：</span>YZZ, <span
                    lang="ZH-CN">机场网站：</span>http://www.torontopearson.com/<span
                    lang="ZH-CN">），<b style=""><span
                            style="background: yellow none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">您
                            需要在</span></b></span><b style=""><span
                        style="background: yellow none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">27<span
                            lang="ZH-CN">日下午到达，</span>31<span lang="ZH-CN">日上午离开</span></span></b><span
                    lang="ZH-CN">。大会场地及住宿地均在机场附近。开车赴会者请在生命季刊网站（</span></span><a
                href="http://www.cclifefl.org/"><span
                    style="font-family: SimHei; color: windowtext; text-decoration: none;">www.cclifefl.org</span></a><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">
                <span lang="ZH-CN">）中查询如何开车赴会的信息。</span><o:p></o:p></span></p>
        <p class="MsoNormal"><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">3<span
                    lang="ZH-CN">．若您因故需要取消大会报名的话，敬请您直接发电子邮件至</span></span><a
                href="mailto:cclife@sbcglobal.net"><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">cclife@sbcglobal.net</span></a><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">
                <span lang="ZH-CN">，同工们在收到您的电邮后，会以支票的形式退还给您费用（注意：报名费不能退还，餐费可以退，但</span>12<span
                    lang="ZH-CN">月</span>10<span lang="ZH-CN">日以后，餐费也不能退还，敬请谅解）。敬请不要私自通知信用卡
                    公司</span>Cancel
                Payment<span lang="ZH-CN">，若您</span>Cancel<span lang="ZH-CN">的话，大会将会支付信用
                    卡公司更多的罚款。谢谢您的合作。</span><o:p></o:p></span></p>
        <p class="MsoNormal"><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">4<span
                    lang="ZH-CN">．请您常常浏览大会网页（</span></span><a
                href="http://www.cclifefl.org/"><span
                    style="font-family: SimHei; color: windowtext; text-decoration: none;">www.cclifefl.org</span></a><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">
                <span lang="ZH-CN">），我们会及时更新关于福音大会的筹备进展。<b style=""><span
                            style="background: yellow none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">我
                            们会在</span></b></span><b style=""><span
                        style="background: yellow none repeat scroll 0%; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">12<span
                            lang="ZH-CN">月初给您寄出福音大会赴会的资料（包括大会名牌及大会餐券），敬请您届时留意。</span>< /span><o:p></o:p></b></span></p>
        <p class="MsoNormal"><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;">5<span
                    lang="ZH-CN">．我们也会通过微信及时发布大会筹备进展及赴会注意事项，您若使用微信，敬请您扫描生命季刊微信二维码：</span><o:p></o:p></span></p>
        <p class="MsoNormal"><b style=""><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><v:shapetype
                        id="_x0000_t75" coordsize="21600,21600" o:spt="75" o:preferrelative="t"
                        path="m@4@5l@4@11@9@11@9@5xe" filled="f" stroked="f"> <v:stroke
                            joinstyle="miter"> <v:formulas> <v:f
                                    eqn="if lineDrawn pixelLineWidth 0"> <v:f eqn="sum @0 1 0"> <v:f
                                            eqn="sum 0 0 @1"> <v:f eqn="prod @2 1 2"> <v:f
                                                    eqn="prod @3 21600 pixelWidth"> <v:f eqn="prod @3 21600 pixelHeight">
                                                        <v:f eqn="sum @0 0 1"> <v:f eqn="prod @6 1 2"> <v:f
                                                                    eqn="prod @7 21600 pixelWidth"> <v:f eqn="sum @8 21600 0"> <v:f
                                                                            eqn="prod @7 21600 pixelHeight"> <v:f eqn="sum @10 21600 0"> </v:f> <v:path
                                                                                o:extrusionok="f" gradientshapeok="t" o:connecttype="rect"> <o:lock
                                                                                    v:ext="edit" aspectratio="t">
                                                                                </o:lock><v:shape id="Picture_x0020_1" o:spid="_x0000_i1025"
                                                                                                  type="#_x0000_t75" alt="qrcode_for_gh_785a6e62ca80_344"
                                                                                                  style="width: 60pt; height: 60pt; visibility: visible;"> <v:imagedata
                                                                                        src="clip_image001.jpg"
                                                                                        o:title="qrcode_for_gh_785a6e62ca80_344"></v:imagedata></v:shape></v:path></v:f></v:f></v:f></v:f></v:f></v:f></v:f></v:f></v:f></v:f></v:f></v:formulas></v:stroke></v:shapetype></span></b><b
                style=""><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><o:p></o:p></span></b></p>
        <p class="MsoNormal"><span
                style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"
                lang="ZH-CN">敬请您为大会代祷，愿神借着这次大会使我们“回归圣经、活出圣洁、火热宣教、教会复兴”！愿神祝福你！</span><span
                    style="font-size: 12pt; line-height: 115%; font-family: SimHei; color: blue;"><o:p></o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-size: 12pt; font-family: SimHei;" lang="ZH-CN">生命季刊同工</span><span
                style="font-size: 12pt; font-family: SimHei;"><o:p></o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-family: SimHei; color: black;" lang="ZH-CN">生命季刊网页：</span><a
                href="http://cclifefl.org/"><span style="">http://cclifefl.org/</span></a><span
                style="color: blue;"><o:p></o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-family: SimHei; color: black;" lang="ZH-CN">生命季刊微信公共号</span><span
                style="font-family: SimHei; color: blue;" lang="ZH-CN">：</span><span
                style="background: yellow none repeat scroll 0%; color: blue; -moz-background-clip: -moz-initial; -moz-background-origin: -moz-initial; -moz-background-inline-policy: -moz-initial;">cclife2013gmail<br>
            </span><span style="font-family: SimHei; color: black;" lang="ZH-CN">生命季
                刊博客：</span><a href="http://blog.sina.com.cn/pinesther"><span style="">http://blog.sina.com.cn/pinesther</span></a><span
                style="color: blue;"><o:p></o:p></span></p><br/>
        <p class="MsoNormal"
           style="margin-bottom: 0.0001pt; line-height: normal;"><span
                style="font-family: SimHei; color: black;" lang="ZH-CN">生命季刊微博：</span><a
                href="http://weibo.com/cclifeusa/profile"><span style="">http://weibo.com/cclifeusa/profile</span></a><span
                style="color: blue;"><span style="">&nbsp;&nbsp;&nbsp;&nbsp; </span></span><span
                style="font-family: SimHei; color: blue;" lang="ZH-CN">电话：</span><span
                style="color: blue;">630-87-7551</span><span
                style="font-family: SimHei; color: blue;" lang="ZH-CN">（美国）</span><span
                style="color: blue;"><o:p></o:p></span></p><br/>
        <p class="MsoNormal"><o:p>&nbsp;</o:p></p>
        <p>
            <a id="startFlow" href="cccc-flow">Start Over</a>
            <script type="text/javascript">
                Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
            </script>
        </p>	
    </div>
</div>