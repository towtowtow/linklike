package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def voteLink() 
    {
    	def link = Link.get(params.id)
    	
    	link.voteNumber+=1
    		
    	
    	redirect(action: "index")


    }

    
}
