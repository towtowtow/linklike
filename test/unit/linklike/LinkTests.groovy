package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests {

    void testCreateNewLink()
    {
    	def link = new Link(title: "Facebook", url: "www.facebook.com")
    	assert link != null
    }

    void testVoteLink()
    {
    	def link = new Link(title: "Facebook", url: "www.facebook.com")
    	assertEquals 0,link.voteNumber

    	link.voteNumber++
    	assertEquals 1,link.voteNumber
    	link.voteNumber = link.voteNumber+20
    	assertEquals 21,link.voteNumber
    	link.voteNumber--
    	assertEquals 20, link.voteNumber
    }

}
