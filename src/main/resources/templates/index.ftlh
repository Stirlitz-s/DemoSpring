<#import "/parts/common.ftlh" as c>
<@c.page>

<h1>Organizer</h1>
<h3>Add task to list</h3>
<div class="input-group mb-3">
<form action="/add" method="post" enctype="multipart/form-data">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <table border="1px">
        <tr>
            <td>
                <label>Priority</label>
                <input type="number" name="priorityId">
            </td>
            <td>
                <label>Description</label>
                <input type="text" name="description">
            </td>
            <td>
                <label>Image</label>
                <input type="file" name="file">
            </td>
            <td>
                <label>Date</label>
                <input type="date" name="date">
            </td>

            <td>
                <input type="submit" value="add task">
            </td>

        </tr>

    </table>
</form>
</div>
<br>
<h2>Task list(task count : ${taskSize})</h2>
<div class="input-group mb-3">
<table border="1px">
    <tr>
        <td>Id</td>
        <td>Priority</td>
        <td>Task description</td>
        <td>Image</td>
        <td>Date</td>
        <td>User</td>
        <td>Delete from list</td>
        <td>Edit task</td>
    </tr>
    <#list taskList as task>
    <tr>
        <td>${task.id}</td>
        <td>${task.priorityId}</td>
        <td>${task.description}</td>
        <td> <#if task.filename??> <img src="/img/${task.filename}">  </#if></td>
        <td>${task.date}</td>
        <td>${task.userName}</td>
        <td><a href="${'/delete/'+task.id}"">Delete</a></td>
        <td><a href="${'/edit/'+task.id}"">Edit</a></td>
    </tr>
    </#list>
</table>
</div>
</@c.page>
