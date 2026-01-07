This is a simple SpringBoot application that provides a RESTful API for managing items. It allows users to create, read, update and delete items. 
<b>Controllers</b> handle HTTP requests and responses. <b>Models</b> represent the data structure of an item. <b>Service</b> contains the logic for managing items.
The technologies used are <b>Java</b>, <b>SpringBoot</b> and <b>Maven</b>
<br/>
<h2>Endpoints:</h2>
<br/>
<table>
  <tr>
    <th>HTTP Method</th>
    <th>Endpoint</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>GET</td>
    <td>/api/items</td>
    <td>Fetch all items</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/api/items/{id}</td>
    <td>Fetch an item by ID</td>
  </tr>
  <tr>
    <td>POST</td>
    <td>/api/items</td>
    <td>Create a new item</td>
  </tr>
  <tr>
    <td>PUT</td>
    <td>/api/items/{id}</td>
    <td>Update an existing item</td>
  </tr>
  <tr>
    <td>DELETE</td>
    <td>/api/items/{id}</td>
    <td>Delete an existing item</td>
  </tr>
  <tr>
    <td>GET</td>
    <td>/api/items/sum</td>
    <td>Adds the two numbers which are passed in as params</td>
  </tr>
</table>
