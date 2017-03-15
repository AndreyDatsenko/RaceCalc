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

