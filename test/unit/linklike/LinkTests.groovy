package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
@Mock([Link])
class LinkTests {

    void testCreateLink()
    {       

        def links = new Link(title: "google", url:"google.com")

        assert links != null
    }

    void testLikeIncrease(){
        def link = new Link(LikeNumber: 0)
        link.save()
        assert link.LikeNumber == 0

        link.LikeNumber++
        
        assert link.LikeNumber == 1
    }

    void testDisLikeIncrease(){
        def link = new Link(DisLikeNumber: 0)
        link.save()
        assert link.DisLikeNumber == 0

        link.DisLikeNumber++
        
        assert link.DisLikeNumber == 1
    }

}
