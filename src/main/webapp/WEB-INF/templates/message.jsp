<%@page import="org.jsoup.safety.Whitelist"%>
<%@page import="org.jsoup.Jsoup"%>
<%
    try {
        String success = Jsoup.clean((String) session.getAttribute("success-message"), Whitelist.basic());
        if (success != null) {%>
<div class="alert alert-success" role="alert">
    <%=success%>
</div>
<%
            session.removeAttribute("success-message");
        }
    } catch (Exception e) {
    }
%>
<%
    try {
        String failed = Jsoup.clean((String) session.getAttribute("faliure-message"), Whitelist.basic());
        if (failed != null) {%>
<div class="alert alert-danger" role="alert">
    <%=failed%>
</div>
<%
            session.removeAttribute("success-message");
        }
    } catch (Exception e) {
    }
%>
