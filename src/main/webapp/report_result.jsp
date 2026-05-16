

<%@ page import="java.util.*, com.model.student" %>

<h2>Report Result</h2>

<table border="1">
<tr>
<th>ID</th>
<th>Name</th>
<th>Room</th>
<th>Date</th>
<th>Fees Paid</th>
<th>Pending Fees</th>
</tr>

<%
List<student> list = (List<student>) request.getAttribute("reportList");

if(list != null && !list.isEmpty()){
    for(student s : list){
%>

<tr>
<td><%= s.getStudentID() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getRoomNumber() %></td>
<td><%= s.getAdmissionDate() %></td>
<td><%= s.getFeesPaid() %></td>
<td><%= s.getPendingFees() %></td>
</tr>

<%
    }
} else {
%>
<tr>
<td colspan="6">No records found</td>
</tr>
<%
}
%>

</table>

<br>
<a href="reports.jsp">Back to Reports</a>