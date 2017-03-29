$(function(){
    $('#search').click(function () {
        $('.modal-shadow').show();
        $('.modal-window').show();
    });

    $('.modal-shadow').click(function () {
        $('.modal-shadow').hide();
        $('.modal-window').hide();
    });

    $('.close').click(function () {
        $('.modal-shadow').hide();
        $('.modal-window').hide();
    });
});

$(function(){
    $('#rating').click(function () {
        $('.modal-shadow2').show();
        $('.modal-window2').show();
    });

    $('.modal-shadow2').click(function () {
        $('.modal-shadow2').hide();
        $('.modal-window2').hide();
    });

    $('.close2').click(function () {
        $('.modal-shadow2').hide();
        $('.modal-window2').hide();
    });
});
