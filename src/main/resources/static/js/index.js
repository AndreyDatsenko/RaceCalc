$(document).ready(function () {
    $('.box:first').show();
    $('ul.tabs').delegate('li:not(.current)', 'click', function() {
        $(this).addClass('current').siblings().removeClass('current')
            .parents('div.section').find('table.box').hide().eq($(this).index()).fadeIn(150);
    });

});