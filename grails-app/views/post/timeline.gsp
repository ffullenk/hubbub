<html>
<head>
<title>Timeline for ${user.profile.fullName}
</title>
<meta name="layout" content="main" />
</head>
<body>
	<g:if test="${flash.message}">
		<div class="flash">
			${flash.message}
		</div>
	</g:if>

	<h1>
		Timeline for
		${user.profile.fullName}
	</h1>

	<div id="newPost">
		<h3>
			What is
			${user.profile.fullName}
			hacking on right now?
		</h3>

		<p>
			<g:form action="addPost" id="${params.id}">
				<g:textArea id='postContent' name="content" rows="3" cols="50" />
				<br />
				<g:submitButton name="post" value="Post" />
			</g:form>
		</p>
	</div>


	<div class="allPosts">
		<g:each in="${user.posts}" var="post">
			<div class="postEntry">
				<div class="postText">
					${post.content}
				</div>
				<div class="postDate">
					${post.dateCreated}
				</div>
			</div>
		</g:each>
	</div>
</body>
</html>
