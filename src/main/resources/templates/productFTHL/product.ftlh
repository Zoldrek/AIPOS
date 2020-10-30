<#import "../parts/common.ftlh" as c>
<@c.page>
    <div>
        <form method="post" class="form-inline">
            <div class="form-group mx-sm-3 mb-2 ml-2">
                <input class="form-control mb-2 mr-2" type="text" name="modelProduct" placeholder="Название" />
                <input class="form-control mb-2 mr-2" type="text" name="vin" placeholder="Номер">
                <input class="form-control mb-2 mr-2" type="text" name="number" placeholder="Цена">
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mb-2">Добавить</button>
            </div>
        </form>
    </div>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Номер</th>
                <th>Цена</th>
                <th>Изменить</th>
            </tr>
        </thead>
        <tbody>
            <#list products as product>
                <tr>
                    <td>${product.idProduct}</td>
                    <td>${product.modelProduct}</td>
                    <td>${product.vin}</td>
                    <td>${product.number}</td>
                    <td><a href="/productList/${product.idProduct}" class="btn btn-primary">Изменить</a></td>
                </tr>
            </#list>
        </tbody>
    </table>

</@c.page>