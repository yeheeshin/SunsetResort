$(document).ready(function() {

    document.querySelector(".grid").addEventListener("click", function () {
        document.querySelector(".list").classList.remove("active");
        document.querySelector(".grid").classList.add("active");
        document.querySelector(".products-area-wrapper").classList.add("gridView");
        document
            .querySelector(".products-area-wrapper")
            .classList.remove("tableView");

        // 모든 .wantNone 클래스를 가진 요소를 선택
        const elements = document.querySelectorAll(".wantNone");

        // 각 요소에 대해 wantHidden 클래스를 추가
        elements.forEach(element => {
            element.classList.add("wantHidden");
        });


        // 삭제 수정 한 줄에 뜨게 바꾸기
        var cells = document.querySelectorAll(".userCRUD");

        cells.forEach(function (cell) {
            cell.style.display = 'inline-block';
        });
    });

    document.querySelector(".list").addEventListener("click", function () {
        document.querySelector(".list").classList.add("active");
        document.querySelector(".grid").classList.remove("active");
        document.querySelector(".products-area-wrapper").classList.remove("gridView");
        document.querySelector(".products-area-wrapper").classList.add("tableView");

        // 모든 .wantNone 클래스를 가진 요소를 선택
        const elements = document.querySelectorAll(".wantNone");

        // 각 요소에 대해 wantHidden 클래스를 제거
        elements.forEach(element => {
            element.classList.remove("wantHidden");
        });

    });


    $('#addUser').submit(function (event) {
        event.preventDefault();

        var formData = new FormData(this);

        $.ajax({
            url: "/sign",
            type: "POST",
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert("회원 등록을 완료했습니다.");
                document.getElementById('myModal').style.display = 'none';
                // 폼 안의 텍스트 박스 비우기
                $('#addUser')[0].reset();

                location.reload();
            },
            error: function (xhr, status, error){
                alert("오류~~~~~");
            }
        })
    })

});