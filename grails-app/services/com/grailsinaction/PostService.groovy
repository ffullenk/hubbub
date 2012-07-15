package com.grailsinaction

class PostException extends RuntimeException {
	String message
	Post post
}


class PostService {

	boolean transactional = true

	def serviceMethod() {
	}

	Post createPost(String userId, String content) {
		def user = User.findByUserId(userId)

		if(user){
			def post = new Post(content)
			user.addToPosts(post)
			if(user.save()){
				return post
			}
			else{
				throw new PostException(
				message: "Invalid or empty post", post: post)
			}
		}
		else{
			throw new PostException(message: "Invalid User Id")
		}
	}
}


