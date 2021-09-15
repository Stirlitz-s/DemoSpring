<#import "/parts/common.ftlh" as c>
<#import "/parts/login.ftlh" as l>
<@c.page>
    <body>
        <#if RequestParameters.error??>
        <div>
            Invalid username and password.
        </div>
        </#if>
       <#if RequestParameters.logout??>
        <div>
            You have been logged out.
        </div>
        </#if>
    </body>
    <h2>Login page</h2>
    <@l.login "/login" false/>
</@c.page>