<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div id="embeddedFlow">
    <p class="success">PAY BY CHECK!</p>
    <div>
        <p>
            Registration at ${form.address.homeCity}
        <hr style="width: 80%; height: 2px;">
        <a id="startFlow" href="cccc-flow">Start Over</a>
        <script type="text/javascript">
            Spring.addDecoration(new Spring.AjaxEventDecoration({elementId: "startFlow", event: "onclick", params: {fragments: "body", mode: "embedded"}}));
        </script>
        </p>	
    </div>
</div>