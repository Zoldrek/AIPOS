<#import "../parts/common.ftlh" as c>
<@c.page>
    Product Edit
    <form  method="post" class="form-inline">
        <#list products as product>
            <input type="text" value="${product.vin}" name="vin" class="form-control mr-2 mb-2" >
            <input type="text" value="${product.modelProduct}" name="modelProduct" class="form-control mr-2 mb-2 ">
            <input type="text" value="${product.number}" name="number" class="form-control mr-2 mb-2 ">
            <input type="hidden" value="${product.idProduct}" name="idProduct" class="form-control mr-2 mb-2 ">
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit" class="btn mr-2 mb-2 ">Изменить</button>
            <a href="/productDelete/${product.idProduct}" class="btn btn-primary mb-2 mr-2">Удалить</a>
        </#list>
    </form>
</@c.page>
