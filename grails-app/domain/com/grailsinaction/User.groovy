package com.grailsinaction

class User {
	
	String userId
	String password
	String homepage
	Date dateCreated
	Profile profile
	
    static constraints = {
		profile(nullable: true)
		
		userId(size:3..20, unique:true)
     	homepage(url:true, nullable:true)
	    password(size: 6..8,
			validator: { passwd, user ->return passwd != user.userId	})
			
			
    }
	static mapping = {
		profile lazy:false
		posts sort:'dateCreated'
		
		}
		
	static hasMany = [ posts : Post, tags : Tag, following : User ]


	
}
