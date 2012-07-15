<%@ page import="com.grailsinaction.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'profile', 'error')} ">
	<label for="profile">
		<g:message code="user.profile.label" default="Profile" />
		
	</label>
	<g:select id="profile" name="profile.id" from="${com.grailsinaction.Profile.list()}" optionKey="id" value="${userInstance?.profile?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'userId', 'error')} ">
	<label for="userId">
		<g:message code="user.userId.label" default="User Id" />
		
	</label>
	<g:textField name="userId" maxlength="20" value="${userInstance?.userId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'homepage', 'error')} ">
	<label for="homepage">
		<g:message code="user.homepage.label" default="Homepage" />
		
	</label>
	<g:field type="url" name="homepage" value="${userInstance?.homepage}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="user.password.label" default="Password" />
		
	</label>
	<g:textField name="password" maxlength="8" value="${userInstance?.password}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'following', 'error')} ">
	<label for="following">
		<g:message code="user.following.label" default="Following" />
		
	</label>
	<g:select name="following" from="${com.grailsinaction.User.list()}" multiple="multiple" optionKey="id" size="5" value="${userInstance?.following*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'posts', 'error')} ">
	<label for="posts">
		<g:message code="user.posts.label" default="Posts" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.posts?}" var="p">
    <li><g:link controller="post" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="post" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'post.label', default: 'Post')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="user.tags.label" default="Tags" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${userInstance?.tags?}" var="t">
    <li><g:link controller="tag" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="tag" action="create" params="['user.id': userInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'tag.label', default: 'Tag')])}</g:link>
</li>
</ul>

</div>

