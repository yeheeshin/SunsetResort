$(function(){
    var $ppc = $('.progress-pie-chart'),
        rank = $('#membershipRank').text().trim(), // 숨겨진 요소에서 등급 값을 가져옴
        percent = 0;

    // 등급에 따른 퍼센티지 설정
    switch(rank) {
        case 'Basic':
            percent = 25;
            break;
        case 'Standard':
            percent = 50;
            break;
        case 'Deluxe':
            percent = 75;
            break;
        case 'Premium':
            percent = 100;
            break;
        default:
            percent = 0;
    }

    var deg = 360 * percent / 100;
    if (percent > 50) {
        $ppc.addClass('gt-50');
    }
    $('.ppc-progress-fill').css('transform', 'rotate(' + deg + 'deg)');
});
