package linklike

import static org.junit.Assert.*
import org.junit.*

class LinkLikeTests {

    def link
    def comment

    @Before
    void setUp() {
        link = new Link(title: "Google", url:"www.google.com")
        link.save()
        comment = new Comment(comment: "hello google")
        comment.link = link
        comment.save()
        link = new Link(title: "Facebook", url:"www.facebook.com")
        link.save()
        link = new Link(title: "Hotmail", url:"www.hotmail.com")
        link.save()
        comment = new Comment(comment: "hello hotmail")
        comment.link = link
        comment.save()
        comment = new Comment(comment: "hello hotmail test comment 2")
        comment.link = link
        comment.save()
        comment = new Comment(comment: "hello hotmail test comment 3")
        comment.link = link
        comment.save()
        link = new Link(title: "Kapook", url:"www.kapook.com")
        link.save()

    }

    @Test
    void testEmptyList() {
        assert link != null
    }

    void testListCount()
    {
        assertEquals 4, link.count
    }

    void testCreateLink()
    {
        assertEquals 4, link.count
        link = new Link(title: "Yahoo", url:"www.yahoo.com")
        link.save()
        assertEquals 5, link.count
    }

}
