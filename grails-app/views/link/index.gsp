<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>

<hr>

<ol>


  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>


  <table border="10" bordercolor="#660000">
  <tr>
  <td>


      <li><%= link.title %> 
      <a href="http://<%= link.url %>"> => (<%= link.url %></a>)
      <br><br>



      
      <g:form name = "LikeForm" url = "[action:'LikeLink']">
        <g:hiddenField name="id" value="${link.id}"/>
        <input type = "submit" value = "Like ! (<%= link.LikeNumber %>)"/>
         
      </g:form>



      <g:form name = "DislikeForm" url = "[action:'DislikeLink']">
        <g:hiddenField name="id" value="${link.id}"/>
        <input type = "submit" value = "Dislike ! (<%= link.DisLikeNumber %>)"/>
      
        <br>
      </g:form>



      <g:form name = "editTitleForm" url = "[action:'nameEdit']">
        <g:hiddenField name="id" value="${link.id}"/>
        <g:textField name="title" placeholder = "Type to change Title"/>
        <input type = "submit" value = "Edit Title" />
        <br>
      </g:form>



      <g:form name = "deleteForm" url = "[action:'deleteTable']">
        <g:hiddenField name="id" value="${link.id}"/>
        <input type = "submit" value = "Delete Link!" />
        <br>
      </g:form>



      <g:form name = "commentForm" url = "[action:'commentLink']">
        <g:hiddenField name="id" value="${link.id}"/>

        Comment:
        <br>


        <% for(commenter in link.comment) { %>
        <ul>
        <li>
        <%= commenter.comment%> 
        </li>
          </ul>
        <br>
        <% } %> 


        <br>
        <textarea name = "commentArea" rows="4" cols="50" placeholder = "Type to Comment ..."></textarea>
        <br>
        <input type = "submit" value = "Sent" />
        <br><br>
      </g:form>


  </td>
  </tr>
  </table>

    <% } %> 
  <% } %>
</ol>
