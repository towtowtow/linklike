package linklike

class Comment {

	static belongsTo = [link: Link]
	String comment
    static constraints = {
    	
    }
}
