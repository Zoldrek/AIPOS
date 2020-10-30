<#import "../parts/common.ftlh" as c>
<@c.page>
    Customer Edit
    <form  method="post" class="form-inline">
        <#list customers as customer>
            <input type="text" value="${customer.customerName}" name="customerName" class="form-control mr-2">
            <input type="text" value="${customer.year}" name="year" class="form-control mr-2">
            <input type="hidden" value="${customer.idCustomer}" name="idCustomer" class="form-control mr-2">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn mb-2 mr-2">Изменить</button>
            <a href="/customerDelete/${customer.idCustomer}" class="btn btn-primary mb-2 mr-2">Удалить</a>
        </#list>
    </form>
</@c.page>
