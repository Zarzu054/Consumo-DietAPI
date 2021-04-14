<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>New playlist</h1>

	
	<div class="container">
	 
		<form action="newplaylist" method="post">
	
			<label for="name">Name: </label> 
			<input id="name" name="name" type="text" required="required"> 
						
			<input name="playlistId" type="hidden" value="${param['playlistId']}">
	
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='list?playlistId=${param['playlistId']}'" class="button">Cancel</button>
			</div>
	
		</form>
		
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>