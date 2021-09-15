<#import "/parts/common.ftlh" as c>
<#import "/parts/login.ftlh" as l>
<@c.page>
<@l.logout />
<h1>Organizer</h1>
<h3>Edit task</h3>
<form action="/change" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <table border="1px">
        <tr>
            <td>
                <label>Id</label>
                <input type="number" readonly name="Id" value=${id}>
            </td>
            <td>
                <label>Priority</label>
                <input type="number" name="priorityId" value=${task2.priorityId}>
            </td>
            <td>
                <label>Description</label>
                <input type="text" name="description" value="${task2.description}">            
            </td>
            <td>
                <label>Date</label>
                <input type="date" name="date" value=${task2.date}>
            </td>
            <td>
                <input type="submit" value="change task">
            </td>
        </tr>
    </table>
</form>
</@c.page>