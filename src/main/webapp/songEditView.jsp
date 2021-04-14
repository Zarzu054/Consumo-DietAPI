<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Song Edit</h1>

	
	<% String controller = "songnew"; %>
	
	<c:if test="${not empty song}">
    	<% controller = "songupdate"; %>
	</c:if>
	
	<div class="container">
	 
		<form action="<%= controller %>" method="post">
	
			<label for="artist">Artist: </label> 
			<input id="artist" name="artist" type="text" required="required" value="${song.artist}"> 
			
			<label for="title">Title: </label> 
			<input id="title" name="title" type="text" required="required" value="${song.title}">
			
			<label for="album">Album: </label> 
			<input id="album" name="album" type="text" required="required" value="${song.album}">
			  
			<label for="year">Year: </label> 
			<input id="year" name="year" type="text" pattern="\d{4}" required="required" value="${song.year}">
			
			
			<input name="playlistId" type="hidden" value="${param['playlistId']}">
			
			<c:if test="${not empty song}">
				<input name="songId" type="hidden" value="${song.id}"></input>
				<input name="operation" type="hidden" value="update"></input>
			</c:if>
	
			<div class="bottom_links">
				<button type="submit" class="button">Submit</button>
				<button type="button" onClick="javascript:window.location.href='list?playlistId=${param['playlistId']}'" class="button">Cancel</button>
			</div>
	
		</form>
		
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>