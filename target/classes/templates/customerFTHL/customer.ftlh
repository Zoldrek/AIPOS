<#import "../parts/common.ftlh" as c>
<@c.page>
    <div>
        <form method="post" class="form-inline">
            <div class="form-group mx-sm-3 mb-2">
                <input type="text" class="form-control mr-2" id="inputPassword2" name="customerName" placeholder="имя" />
                <input type="text" class="form-control mr-2" id="inputPassword2" name="year" placeholder="год рождения">
                <button type="submit" class="btn mr-2 btn-primary">Добавить</button>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            </div>
        </form>
    </div>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Имя</th>
                <th>Год рождения</th>
                <th>Изменить</th>
            </tr>
        </thead>
        <tbody>
        <#list customers as customer>
            <tr>
                <td>${customer.idCustomer}</td>
                <td>${customer.customerName}</td>
                <td>${customer.year}</td>
                <td><a href="/customerList/${customer.idCustomer}" class="btn btn-primary">Изменить</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>