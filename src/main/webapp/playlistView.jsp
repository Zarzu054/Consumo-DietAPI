<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>AISS Music Application</h1>

	<div class="container">
	
		<p>${message}</p>
		
		<form action="list" method="post">
			Playlist: <select name="playlistId" onchange="this.form.submit()">
				<c:forEach items="${requestScope.playlists}" var="playlist">
    				<option value="${playlist.id}" ${playlist.id == playlistId ? 'selected' : ''}>${playlist.name}</option>
    			</c:forEach>
  			</select>
  			<a href="playlistEditView.jsp?playlistId=${playlistId}" class="button">New playlist</a>
		</form>
		
		<table id="playlist">
			<tr>
				<th>Artist</th>
				<th>Title</th>
				<th>Album</th>
				<th>Year</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${requestScope.plsongs}" var="song">
				<tr>
					<td><c:out value="${song.artist}" /></td>
					<td><c:out value="${song.title}" /></td>
					<td><c:out value="${song.album}" /></td>
					<td><c:out value="${song.year}" /></td>
					<td><a href="songupdate?playlistId=${playlistId}&songId=${song.id}"><img src="./images/edit.png" width="30px"></a> 
						<a href="songdelete?playlistId=${playlistId}&songId=${song.id}"><img src="./images/delete.png" width="30px"></a></td>
				</tr>
			</c:forEach>
		</table>
		

			<form id="songSelector" action="addsong" method="post">
			Add song: <select name="songId" onchange="this.form.submit()">
					<option value="none">Select a song</option>
				<c:forEach items="${requestScope.songs}" var="song">
    				<option value="${song.id}">${song.title}</option>
    			</c:forEach>
  			</select>
  			<input name="playlistId" type="hidden" value="${playlistId}">
			</form>
			<a href="songEditView.jsp?playlistId=${playlistId}" class="button">New song</a>

	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>