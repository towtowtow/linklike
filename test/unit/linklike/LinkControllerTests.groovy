package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@Mock([Link])
class LinkControllerTests {

	 void testCreateNewLink() 
	{
    	params.title = "Facebook"
    	params.url = "www.facebook.com"
    	controller.create()
    	
    	assertEquals 1,Link.count()
    }

     void testCreateNewLink2() 
     {
    	def link = new Link(title: "Facebook", url: "www.facebook.com")
    	link.save()
    	assertEquals 1,Link.count()

    	link = new Link(title: "Google", url: "www.google.com")
    	link.save()
    	assertEquals 2,Link.count()

    	link = new Link(title: "Yahoo", url: "www.yahoo.com")
    	link.save()
    	assertEquals 3,Link.count()
    }

    void testVoteLink()
    {
    	def link = new Link(title: "Facebook", url: "www.facebook.com")
        link.save()
        params.id = 1
    	controller.voteLink()

    	link = new Link(title: "Google", url: "www.google.com")
        link.save()
        params.id = 2

    	assertEquals 1, Link.get(1).voteNumber
    	assertEquals 0, Link.get(2).voteNumber

    }

     

    
}
