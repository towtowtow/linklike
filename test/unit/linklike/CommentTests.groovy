package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Comment)
@Mock([Link,Comment])
class CommentTests {

	def link
	def comment

	@Before void init()
	{
		link = new Link(title: "Facebook", url: "www.facebook.com")
		link.save()
		comment = new Comment(comment: "hello")
		comment.link = link
		comment.save()
	}

    void testCommentEmpty()
    {
        assert comment != null
    }

    void testCommentAdd()
    {
    	comment = new Comment(comment: "test comment")
    	comment.link = link
    	comment.save()
    	assertEquals 2, comment.count

    	comment = new Comment(comment: "test comment")
    	comment.link = link
    	comment.save()
    	comment = new Comment(comment: "test comment2")
    	comment.link = link
    	comment.save()
    	comment = new Comment(comment: "test comment3")
    	comment.link = link
    	comment.save()
    	comment = new Comment(comment: "test comment4")
    	comment.link = link
    	comment.save()
    	assertEquals 6, comment.count
    }



}
