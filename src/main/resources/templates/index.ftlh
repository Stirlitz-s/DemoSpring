<#import "/parts/common.ftlh" as c>
<@c.page>

<h1>Organizer</h1>
<h3>Add task to list</h3>
<a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new event
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form action="/add" method="post" enctype="multipart/form-data">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group mt-3">
                <input type="number" class="form-control" name="priorityId" placeholder="Priority">
            </div>
            <div class="form-group mt-3">
                <input type="text" class="form-control" name="description" placeholder="Description">
            </div>
            <div class="form-group mt-3">
                <input type="file" class="custom-file" name="file" placeholder="Image">
            </div>
            <div class="form-group mt-3">
                <input type="date" name="date" placeholder="Date">
            </div>
            <div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Add Task</button>
            </div>
        </form>
    </div>
</div>

<h2>Task list(task count : ${taskSize})</h2>
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
</table>
    <#list taskList as task>
    <div class="card" style="width: 18rem;">
        <#if task.filename??> 
            <img src="/img/${task.filename}" class="card-img-top">
        </#if>
        <b>${task.id}</b>
        <label>Priority</label><span>${task.priorityId}</span>
        <span>${task.description}</span>
        <span>${task.date}</span>
        <a href="${'/delete/'+task.id}"">Delete</a>
        <a href="${'/edit/'+task.id}"">Edit</a>
        <div class="card-footer text-muted">
            ${task.userName}
        </div>
    </div>
    </#list>
</@c.page>
