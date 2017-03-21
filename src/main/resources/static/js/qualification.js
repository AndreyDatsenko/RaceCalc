$(document).ready(function () {
    $("#add_driver").click(function () {
        if (!/^[0-9]*$/.test($("input[name=number]").val())) {
            alert("Не правильне значення для номера!");

        } else {
            saveDriver();
            loadDrivers();
        }
    });
    $('#list_drivers').click(function () {
        replaceTable();
        replaceButton();
        $('#flip').hide();
    });
    loadDrivers();
});

function loadDrivers() {
    $.get("/driver/list", function (data) {
        var content = '';
        $.each(data, function () {
            content += ( "<tr><td><input form='" + this.id + "' class='input' type='text' name='category' value='" + this.carCategory + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='name' value='" + this.surname + "'></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='surname' value='" + this.name + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='number' value='" + this.number + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='mark' value='" + this.carMark + "'/></td>" +
            "<td><a href='#' class='edit'>редагувати</a><input type='hidden' name='id' value='" + this.id + "'/></td>" +
            "<td><a class='delete' onClick='deleteRow(this);' href='#'>видалити</a></td></tr>");
        });
        $("#driver").html(content)
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

function replaceTable() {
    $.get("/driver/list", function (data) {
        var tableContent = "<tr></tr><th width=20'>Класс</th>" +
            "<th width='15%'>Прізвище водія</th>" +
            "<th width='15%'>Ім'я водія</th>" +
            "<th width='10%'>Номер</th>" +
            "<th width='15%'>Автомобіль</th>" +
            "<th width='10%'>1-й заїзд</th>" +
            "<th width='10%'>2-й заїзд</th>" +
            "<td width='15'></td><tr>";

        $.each(data, function () {
            tableContent += ( "<tr><td>" + this.carCategory + "</td>" +
            "<td>" + this.surname + "</td>" +
            "<td>" + this.name + "</td>" +
            "<td>" + this.number + "</td>" +
            "<td>" + this.carMark + "</td>" +
            "<td><input class='input' form='" + this.id + "' name='time' placeholder='час'/></td>" +
            "<td><input class='input' form='" + this.id + "' name='time' placeholder='час'/></td>" +
            "<td><input type='hidden' name='id' value='" + this.id + "'/>" +
            "<a class='save_time' href='#'>закінчити заїзди</a> </td></tr>");
        });
        $("#drivers_table").replaceWith(tableContent);

    });
}

function replaceButton() {
    var submit = "<form action='/driver/qualification/result'>" +
        "<input type='submit' value='Результати заїзду'/></form>"

    $('#list_drivers').replaceWith(submit);
}
