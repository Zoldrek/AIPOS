<#import "../parts/common.ftlh" as c>
<@c.page>
<table>
    List
    <#list products as product>
        <tr>
            <td>${product.idProduct}</td>
            <td>${product.modelProduct}</td>
            <td>${product.vin}</td>
            <td>${product.number}</td>
            <td><a href="/productList/${product.idProduct}">Изменить</a></td>
        </tr>
    </#list>
</table>
</@c.page>