$(document).on('click','.edit',function(){
    var row=$(this).closest("tr");
    var id =$("td:eq(5)",row).find('input').val();

    $.get("/driver/" + id + "/get", function (data) {
        var driver = '';
        $.each(data, function () {
            driver += ("<tr>" +
            "<td>" + this.carCategory + "</td>" +
            "<td>" + this.surname + "</td>" +
            "<td>" + this.name + "</td>" +
            "<td>" + this.number + "</td>" +
            "<td>" + this.carMark + "</td>" +
            "<td><input type='text' size='13' placeholder='time' form='my_form' /></td>" +
            "<td><input type='checkbox' name='penalty' value='chip_bord' form='my_form'/>ФБ</td>" +
            "<td><input type='checkbox' name='penalty' value='chip_front' form='my_form'/>ФФ</td>" +
            "<td><input type='checkbox' name='penalty' value='fail_finish' form='my_form'/>ФС</td>" +
            "<td><input type='text' size='13' placeholder='time' form='my_form' /></td>" +
            "<td><input type='checkbox' name='penalty' value='chip_bord' form='my_form'/>ФБ</td>" +
            "<td><input type='checkbox' name='penalty' value='chip_front' form='my_form'/>ФФ</td>" +
            "<td><input type='checkbox' name='penalty' value='fail_finish' form='my_form'/>ФС</td>" +
            "<td><input type='text' size='13' placeholder='time' form='my_form'/></td>" +
            "<td><input type='checkbox' name='penalty' value='chip_bord' form='my_form'/>ФБ</td>" +
            "<td><input type='checkbox' name='penalty' value='chip_front' form='my_form'/>ФФ</td>" +
            "<td><input type='checkbox' name='penalty' value='fail_finish' form='my_form'/>ФС</td>" +
            "</tr>");
        })
    });
});
