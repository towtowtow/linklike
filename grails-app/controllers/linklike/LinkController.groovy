package linklike

class LinkController {

    def index() 
    { 
        def links = Link.findAll()
        def comments = Comment.findAll()
        [ links: links , comments: comments]
      
    }

    def create() 
    {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def LikeLink() 
    {
        def link = Link.get(params.id)
        link.LikeNumber = link.LikeNumber+1
        redirect(action: "index")
    }

    def DislikeLink() 
    {
        def link = Link.get(params.id)
        link.DisLikeNumber = link.DisLikeNumber+1
        redirect(action: "index")
    }

    def nameEdit()
    {
        def link = Link.get(params.id)
        link.title = ""+params.title
        redirect(action: "index")
    }

    def deleteTable()
    {
        def link = Link.get(params.id)
        link.delete(flush: true)
        redirect(action: "index")
    }

    def commentLink()
    {
        def link = Link.get(params.id)
        def comment = new Comment(comment: params.commentArea)
        comment.link = link
        comment.save()
        redirect(action: "index")
    }

    
}
