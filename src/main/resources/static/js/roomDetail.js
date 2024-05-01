var imageList = [
    "../css/images/exRoom.jpg",
    "../css/images/exRoom2.jpg",
    "../css/images/exRoom.jpg"
    // 여기에 추가 이미지 URL 추가
];

$(document).ready(function(){
    // 현재 이미지의 인덱스
    var currentIndex = 0;

    // 이미지 슬라이드 함수
    function showSlide(index) {
        // 현재 이미지의 URL 가져오기
        var imageUrl = imageList[index];
        // 이미지를 변경
        $(".room-details-item img").attr("src", imageUrl);
    }

    // 초기 슬라이드 표시
    showSlide(currentIndex);

    // 다음 슬라이드로 이동하는 함수
    function nextSlide() {
        currentIndex++;
        if (currentIndex >= imageList.length) {
            currentIndex = 0;
        }
        showSlide(currentIndex);
    }

    // 이전 슬라이드로 이동하는 함수
    function prevSlide() {
        currentIndex--;
        if (currentIndex < 0) {
            currentIndex = imageList.length - 1;
        }
        showSlide(currentIndex);
    }

    // 이전 버튼 클릭 시 이벤트 핸들러
    $(".prev").click(function(){
        prevSlide();
    });

    // 다음 버튼 클릭 시 이벤트 핸들러
    $(".next").click(function(){
        nextSlide();
    });
});