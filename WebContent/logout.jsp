<% 
session.invalidate();
session = null;
request.getSession().getAttribute("myId");
%>
<jsp:forward page="index.jsp"></jsp:forward>