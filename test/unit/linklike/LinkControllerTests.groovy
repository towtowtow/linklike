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

    void testLikeLink()
    {
        def link = new Link(title: "Facebook", url: "www.facebook.com")
        link.save()
        params.id = 1
        controller.LikeLink()

        link = new Link(title: "Google", url: "www.google.com")
        link.save()
        params.id = 2

        assertEquals 1, Link.get(1).LikeNumber
        assertEquals 0, Link.get(2).LikeNumber

    }

    void testDisLikeLink()
    {
        def link = new Link(title: "Facebook", url: "www.facebook.com")
        link.save()
        params.id = 1
        controller.DislikeLink()

        link = new Link(title: "Google", url: "www.google.com")
        link.save()
        params.id = 2

        assertEquals 1, Link.get(1).DisLikeNumber
        assertEquals 0, Link.get(2).DisLikeNumber

    }

    void testNameEdit()
    {
        def link = new Link(title: "Facebook", url: "www.facebook.com")
        link.save()
        params.id = link.id
        params.title = "test"
        controller.nameEdit()


        assert link.title != "Facebook"
        assert link.title == "test"

    }

     void testDeleteLink() 
    {
        def link = new Link(title: "Facebook", url: "www.facebook.com")
        link.save()
        params.id = 1

        link = new Link(title: "Google", url: "www.google.com")
        link.save()
        params.id = 2

        controller.deleteTable()

        assertEquals 1,Link.count()

       

        
       
    }

     

    
}
