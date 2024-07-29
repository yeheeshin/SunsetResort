$(document).ready(function() {

    document.querySelector(".grid").addEventListener("click", function () {
        document.querySelector(".list").classList.remove("active");
        document.querySelector(".grid").classList.add("active");
        document.querySelector(".products-area-wrapper").classList.add("gridView");
        document
            .querySelector(".products-area-wrapper")
            .classList.remove("tableView");
        document.querySelector(".wantNone").classList.add("wantHidden");

        // 삭제 수정 한 줄에 뜨게 바꾸기
        var cells = document.querySelectorAll(".userCRUD");

        cells.forEach(function (cell) {
            cell.style.display = 'inline-block';
            cell.style.marginRight = '10px';
        });
    });

    document.querySelector(".list").addEventListener("click", function () {
        document.querySelector(".list").classList.add("active");
        document.querySelector(".grid").classList.remove("active");
        document.querySelector(".products-area-wrapper").classList.remove("gridView");
        document.querySelector(".products-area-wrapper").classList.add("tableView");
        document.querySelector(".wantNone").classList.remove("wantHidden");
    });
});