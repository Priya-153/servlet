<%
String type = request.getParameter("type");
%>

<h2>Enter Report Criteria</h2>

<form action="reportCriteria" method="post">

<input type="hidden" name="type" value="<%=type%>">

<%
if("room".equals(type)){
%>
Enter Room Number: <input type="text" name="room"><br><br>
<%
}
else if("date".equals(type)){
%>
From Date: <input type="date" name="from"><br><br>
To Date: <input type="date" name="to"><br><br>
<%
}
%>

<input type="submit" value="Generate Report">

</form>