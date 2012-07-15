import com.grailsinaction.Profile
import com.grailsinaction.User


class BootStrap {
	def init = { servletContext ->
		    environments { 
               development { 
				createAdminUserIfRequired()
               }
			production{
				println "No special configuration required"
			}
		}
	}
	
	def destroy = {
	}
	void createAdminUserIfRequired() {
		if (!User.findByUserId("admin")) {
			println "Fresh Database. Creating ADMIN user."
			def profile = new Profile(email: "admin@yourhost.com", fullName: "Administrador")
			def user = new User(userId: "admin",
					password: "secret", profile: profile).save()
		} else {
			println "Existing admin user, skipping creation"
		}
	}
}
