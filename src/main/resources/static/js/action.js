$(document).on('click','.edit',function(){
    var row=$(this).closest("tr");
    var category =$("td:eq(0)",row).find('input').val();
    var name =$("td:eq(1)",row).find('input').val();
    var surname =$("td:eq(2)",row).find('input').val();
    var number =$("td:eq(3)",row).find('input').val();
    var mark =$("td:eq(4)",row).find('input').val();
    var id =$("td:eq(5)",row).find('input').val();

    $.post("/driver/" + id + "/edit",
        {
            name: name,
            surname: surname,
            number: number,
            category: category,
            mark: mark
        }
    );
});

$(document).on('click','.delete',function(){
    var row=$(this).closest("tr");
    var id =$("td:eq(5)",row).find('input').val();
    $.post("/driver/" + id + "/delete");

});

function deleteRow(obj) {
    $(obj).closest('tr').remove();
}

$(document).on('click','.save_time',function() {
    var row = $(this).closest("tr");
    var time1 =$("td:eq(5)",row).find('input').val();
    var time2 =$("td:eq(6)",row).find('input').val();
    var driverId =$("td:eq(7)",row).find('input').val();
    var time = '';

    if(time1 < time2 || time2 == ''){
        time = time1;
    }else {
        time = time2;
    }

    if (!/([0-9]+):([0-5][0-9]):([0-5][0-9]).([0-5][0-9])/.test(time)) {
        alert("Не правильне значення для часу!");
        $(this).css("backgroundColor", "red");

    } else {
        $(this).hide();

        $.post("/lap/qualification/time",
            {
                driverId: driverId,
                time: time,
            }
        );
    }

});