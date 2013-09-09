package linklike

class Link {
    String title
    String url
    Integer LikeNumber = 0
    Integer DisLikeNumber = 0
    static hasMany = [comment: Comment]
    static constraints = {
    	
    }
}
