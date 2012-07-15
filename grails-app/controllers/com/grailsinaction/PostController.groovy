package com.grailsinaction

class PostController {

	def postService
	def scaffold = true

	def index() {
		if (!params.id)
			params.id = "admin"
		redirect(action: 'timeline', params: params)
	}

	def timeline(){
		def user = User.findByUserId(params.id)
		[user: user]
	}

	def addPost(){


		try{
			def newPost = postService.createPost(params.id,params.content)
			flash.message = "Added new post: ${newPost.content}"
		} catch (PostException pe) {
			flash.message = pe.message
		}
		redirect(action: 'timeline', id: params.id)
	}
}
