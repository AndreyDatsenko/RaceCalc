
$(document).ready(function () {
    $("#add_driver").click(function () {
        if (!/^[0-9]*$/.test($("input[name=number]").val())) {
            alert("Не правильне значення для номера!");
        } else {
            saveDriver();
        }
    });
    $('#list_drivers').click(function () {

        replaceTable();
        replaceButton();

        $('#flip').hide();
        $('#panel').hide();
    });
    loadDrivers();
});

function loadDrivers() {
    var competitionId = $("input[name=competition_id]").val();

    $.get("/competition/" + competitionId + "/drivers", function (data) {
        var content = '';
        $.each(data, function () {
            content += ( "<tr><td><input form='" + this.id + "' class='input' type='text' name='category' value='" + this.carCategory + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='name' value='" + this.name + "'></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='surname' value='" + this.surname + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='number' value='" + this.number + "'/></td>" +
            "<td><input form='" + this.id + "' class='input' type='text' name='mark' value='" + this.carMark + "'/></td>" +
            "<td><a href='#' class='edit'>редагувати</a><input type='hidden' name='id' value='" + this.id + "'/></td>" +
            "<th><a class='delete' onClick='deleteRow(this);' href='#'>видалити</a></th></tr>");
        });
        $("#driver").html(content)
    });
}

function saveDriver() {
    var surname = $("input[name=surname]").val();
    var name = $("input[name=name]").val();
    var number = $("input[name=number]").val();
    var carCategory = $( "#select option:selected" ).text();
    var carMark = $("input[name=mark]").val();
    var competitionId = $("input[name=competition_id]").val();

    $.post("/driver/" + competitionId + "/create",
        {
            surname: surname,
            name: name,
            number: number,
            carCategory: carCategory,
            carMark: carMark
        }
    ).then(function() {
        loadDrivers();
    });
}

function replaceTable() {
    var competitionId = $("input[name=competition_id]").val();

    $.get("/competition/" + competitionId + "/drivers", function (data) {
        var tableContent = "<tr></tr><th width=20'>Класс</th>" +
            "<th width='15%'>Прізвище водія</th>" +
            "<th width='15%'>Ім'я водія</th>" +
            "<th width='10%'>Номер</th>" +
            "<th width='15%'>Автомобіль</th>" +
            "<th width='10%'>1-й заїзд</th>" +
            "<th width='10%'>2-й заїзд</th>" +
            "<th width='15'></th><tr>";

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
    var competitionId = $("input[name=competition_id]").val();
    var submit = "<form action='/competition/" + competitionId + "/qualification/result'>" +
        "<input type='submit' value='Результати заїзду'/></form>"

    $('#list_drivers').replaceWith(submit);
}
