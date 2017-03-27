$(document).on('click', '.get_driver', function () {
    var row = $(this).closest("tr");
    var id = $("th:eq(4)", row).find('input').val();

    $.get("/driver/" + id + "/get", function (data) {
        var driver = '';

        driver += ("<tr>" +
        "<td>" + data.carCategory + "</td>" +
        "<td>" + data.surname + "</td>" +
        "<td>" + data.name + "</td>" +
        "<td>" + data.number + "</td>" +
        "<td>" + data.carMark + "<input type='hidden' name='id' value='" + data.id + "'/></td>" +
        "<td id='first_lap_time'><input class='input' type='text' size='13' placeholder='час 1-го заїзду'/></td>" +
        "<td id='first_lap_chip_board'><input type='checkbox' name='penalty' value='chip_board'/>ФБ</td>" +
        "<td id='first_lap_chip_front'><input type='checkbox' name='penalty' value='chip_front'/>ФФ</td>" +
        "<td id='first_lap_false_start'><input type='checkbox' name='penalty' value='false_start'/>ФС</td>" +
        "<th id='first_lap_a'><a href='#' id='first_lap'>закінчити 1-й заїзд</th>" +
        "</tr>");

        $("#general_table").after(driver);
    });
});

$(document).on('click', '#first_lap', function () {
    var row = $(this).closest("tr");
    var driverId = $("td:eq(4)", row).find('input').val();
    var time = $("td:eq(5)", row).find('input').val();
    var chipBoard = $("td:eq(6)", row).find('input').is(":checked");
    var chipFront = $("td:eq(7)", row).find('input').is(":checked");
    var falseStart = $("td:eq(8)", row).find('input').is(":checked");
    var lapNumber = 1;

    if (!/([0-9]+):([0-5][0-9]):([0-5][0-9]).([0-5][0-9])/.test(time)) {
        alert("Не правильне значення для часу!");
        $(this).css("backgroundColor", "red");
    } else {
        $.post("/lap/" + driverId + "/save/time",
            {
                lapNumber: lapNumber,
                time: time,
                chipBoard: chipBoard,
                chipFront: chipFront,
                falseStart: falseStart
            });

        var time2 = "<td id='second_lap_time'><input class='input' type='text' size='13' placeholder='час 2-го заїзду'/></td>";
        $('#first_lap_time').replaceWith(time2);

        var chipBoard2 = "<td id='second_lap_chip_board'><input type='checkbox' name='penalty' value='chip_board'/>ФБ</td>";
        $('#first_lap_chip_board').replaceWith(chipBoard2);

        var chipFront2 = "<td id='second_lap_chip_front'><input type='checkbox' name='penalty' value='chip_front'/>ФФ</td>"
        $('#first_lap_chip_front').replaceWith(chipFront2);

        var falseStart2 = "<td id='second_lap_false_start'><input type='checkbox' name='penalty' value='false_start'/>ФС</td>";
        $('#first_lap_false_start').replaceWith(falseStart2);

        var link2 = "<th id='second_lap_a'><a href='#' id='second_lap'>закінчити 2-й заїзд</th>";
        $('#first_lap_a').replaceWith(link2);
    }
});

$(document).on('click', '#second_lap', function () {
    var row = $(this).closest("tr");
    var driverId = $("td:eq(4)", row).find('input').val();
    var time = $("td:eq(5)", row).find('input').val();
    var chipBoard = $("td:eq(6)", row).find('input').is(":checked");
    var chipFront = $("td:eq(7)", row).find('input').is(":checked");
    var falseStart = $("td:eq(8)", row).find('input').is(":checked");
    var lapNumber = 2;

    if (!/([0-9]+):([0-5][0-9]):([0-5][0-9]).([0-5][0-9])/.test(time)) {
        alert("Не правильне значення для часу!");
        $(this).css("backgroundColor", "red");
    } else {
        $.post("/lap/" + driverId + "/save/time",
            {
                lapNumber: lapNumber,
                time: time,
                chipBoard: chipBoard,
                chipFront: chipFront,
                falseStart: falseStart
            });

        var time3 = "<td><input class='input' type='text' size='13' placeholder='час 3-го заїзду'/></td>";
        $('#second_lap_time').replaceWith(time3);

        var chipBoard3 = "<td><input type='checkbox' name='penalty' value='chip_board'/>ФБ</td>";
        $('#second_lap_chip_board').replaceWith(chipBoard3);

        var chipFront3 = "<td><input type='checkbox' name='penalty' value='chip_front'/>ФФ</td>"
        $('#second_lap_chip_front').replaceWith(chipFront3);

        var falseStart3 = "<td><input type='checkbox' name='penalty' value='false_start'/>ФС</td>";
        $('#second_lap_false_start').replaceWith(falseStart3);

        var link3 = "<th id='third_lap_a'><a href='#' id='third_lap'>закінчити 3-й заїзд</th>";
        $('#second_lap_a').replaceWith(link3);

    }
});

$(document).on('click', '#third_lap', function () {
    var row = $(this).closest("tr");
    var driverId = $("td:eq(4)", row).find('input').val();
    var time = $("td:eq(5)", row).find('input').val();
    var chipBoard = $("td:eq(6)", row).find('input').is(":checked");
    var chipFront = $("td:eq(7)", row).find('input').is(":checked");
    var falseStart = $("td:eq(8)", row).find('input').is(":checked");
    var lapNumber = 3;

    if (!/([0-9]+):([0-5][0-9]):([0-5][0-9]).([0-5][0-9])/.test(time)) {
        alert("Не правильне значення для часу!");
        $(this).css("backgroundColor", "red");
    } else {
        $(this).hide();

        $.post("/lap/" + driverId + "/save/time",
            {
                lapNumber: lapNumber,
                time: time,
                chipBoard: chipBoard,
                chipFront: chipFront,
                falseStart: falseStart
            });
    }
});

function deleteRow(obj) {
    $(obj).closest('tr').remove();
}
