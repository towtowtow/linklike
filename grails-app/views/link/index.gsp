<h1>Link Like</h1>

<g:form name="linkCreateForm" url="[action:'create']">
  Title: <g:textField name="title"/><br/>
  URL: <g:textField name="url"/><br/>
  <input type="submit" value="Add new link"/>
</g:form>

<hr>

<ul>
  <% if(links.size() == 0) { %>
    <li>No links</li>
  <% } else { %>
    <% for(link in links) { %>


      <g:form name = "voteIncreaseForm" url = "[action:'voteLink']">
      <li><%= link.title %> 

        <g:hiddenField name="id" value="${link.id}"/>
        <input type = "submit" value = "Vote"/>


         => <%= link.voteNumber %></li>
      </g:form>



    <% } %> 
  <% } %>
</ul>
