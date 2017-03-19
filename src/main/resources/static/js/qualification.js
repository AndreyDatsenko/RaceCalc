function loadDrivers() {
    $(document).ready(function () {
        $.get("/driver/list", function (data) {
            var content = '';
            $.each(data, function () {
                content += ( "<tr><td><input form='" + this.id + "' id='input' type='text' name='category' value='" + this.carCategory + "'/></td>" +
                "<td><input form='" + this.id + "' id='input' type='text' name='name' value='" + this.surname + "'></td>" +
                "<td><input form='" + this.id + "' id='input' type='text' name='surname' value='" + this.name + "'/></td>" +
                "<td><input form='" + this.id + "' id='input' type='text' name='number' value='" + this.number + "'/></td>" +
                "<td><input form='" + this.id + "' id='input' type='text' name='mark' value='" + this.carMark + "'/></td>" +
                "<td><a href='#' class='edit'>редагувати</a><input type='hidden' name='id' value='" + this.id + "'/></td>" +
                "<td><a class='delete' onClick='deleteRow(this);' href='#'>видалити</a></td></tr>");
            });
            $("#driver").html(content)
        });
    });
}

function saveDriver() {
    var name = $("input[name=name]").val();
    var surname = $("input[name=surname]").val();
    var number = $("input[name=number]").val();
    var category = $("input[name=category]").val();
    var mark = $("input[name=mark]").val();

    $.post("/driver/save",
        {
            name: name,
            surname: surname,
            number: number,
            category: category,
            mark: mark
        }
    );
}

function deleteRow(obj) {
    $(obj).closest('tr').remove();
}

