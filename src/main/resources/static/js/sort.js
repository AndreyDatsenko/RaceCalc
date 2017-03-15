$(document).ready(function() {
    $('table#drivers_table').each(function() {
        var $table = $(this);
        $('th', $table).each(function(column) {
            var $header = $(this);
            if ($header.is('.sort-alpha')) {
                $header.addClass('clickable').hover(function() {
                    $header.addClass('hover');
                }, function() {
                    $header.removeClass('hover');
                }).click(function() {
                    var rows = $table.find('tbody > tr').get();
                    rows.sort(function(a, b) {
                        var keyA = $(a).children('td').eq(column).text()
                            .toUpperCase();
                        var keyB = $(b).children('td').eq(column).text()
                            .toUpperCase();
                        if (keyA < keyB) return -1;
                        if (keyA > keyB) return 1;
                        return 0;
                    });
                    $.each(rows, function(index, row) {
                        $table.children('tbody').append(row);
                    });
                });
            }
        });
    });
});
