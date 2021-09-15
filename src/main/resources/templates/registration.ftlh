<#import "/parts/common.ftlh" as c>
<#import "/parts/login.ftlh" as l>
Add new user
${message?ifExists}
    <body>
        <#if message??>
        <div>
            ${message}
        </div>
        </#if>
    </body>
<@c.page>
        <h2>Add new user</h2>
        <@l.login "/registration" true/>
</@c.page>
