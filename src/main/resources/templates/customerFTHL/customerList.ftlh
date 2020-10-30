<#import "../parts/common.ftlh" as c>
<@c.page>
    <table>
        List
        <#list customers as customer>
            <tr>
                <td>${customer.customerName}</td>
                <td>${customer.year}</td>
                <td><a href="/productList/${customer.idCustomer}">edit</a></td>
            </tr>
        </#list>
    </table>
</@c.page>