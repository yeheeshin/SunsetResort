$(document).ready(function() {
    // 모달 요소 가져오기
    var modal = document.getElementById("myModal");

// 모달을 여는 버튼 가져오기
    var btn = document.querySelector(".app-content-headerButton");

// 모달을 닫는 <span> 요소 가져오기
    var span = document.getElementsByClassName("close")[0];

// 사용자가 버튼을 클릭하면 모달 열기
    btn.onclick = function() {
        modal.style.display = "block";
    }

// 사용자가 <span> (x) 요소를 클릭하면 모달 닫기
    span.onclick = function() {
        modal.style.display = "none";
    }

// 모달 외부 영역 클릭 시 모달을 숨김
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }

    $('#addAdmin').submit(function (event) {
        event.preventDefault();

        var formData = new FormData(this);

        $.ajax({
            url: "/addAdmin",
            type: "POST",
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                alert("회원 등록을 완료했습니다.");
                document.getElementById('myModal').style.display = 'none';
                // 폼 안의 텍스트 박스 비우기
                $('#addAdmin')[0].reset();

                location.reload();
            },
            error: function (xhr, status, error){
                alert("오류~~~~~");
            }
        })
    })

});