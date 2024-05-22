document.addEventListener("DOMContentLoaded", function() {
    const modal = document.getElementById("modal");
    const collapseSection = document.getElementById("collapseExample");
    const closeModalBtn = document.getElementById("closeModalBtn");
    const confirmSelectionBtn = document.getElementById("confirmSelectionBtn");
    const dateInInput = document.getElementById("date-in");
    const dateOutInput = document.getElementById("date-out");

    // Flatpickr 설정
    flatpickr(dateInInput, {
        dateFormat: "Y-m-d"
    });
    flatpickr(dateOutInput, {
        dateFormat: "Y-m-d"
    });

    // 모달 초기화 함수 (아직 사용 안 함)
    function resetModal() {
        const roomInfo = document.querySelector('.room-info');
        // 기본 상태로 초기화
        roomInfo.innerHTML = `
            <div class="room">
                <div class="room-label">객실 1</div>
                <div class="counter">
                    <button class="decrease">-</button>
                    <div class="count">성인 1</div>
                    <button class="increase">+</button>
                </div>
                <div class="counter">
                    <button class="decrease">-</button>
                    <span class="count">어린이 1</span>
                    <button class="increase">+</button>
                </div>
                <div class="counter">
            
                </div>
            </div>

        `;

        // 새로 생성된 요소들에 이벤트 리스너 추가
        roomInfo.querySelectorAll('.decrease').forEach(function(button) {
            button.addEventListener('click', function() {
                decreaseCount(button);
            });
        });

        roomInfo.querySelectorAll('.increase').forEach(function(button) {
            button.addEventListener('click', function() {
                increaseCount(button);
            });
        });
    }

    // 섹션 클릭 시 모달 열기
    collapseSection.addEventListener("click", function() {
        modal.style.display = "block";
    });

    // 모달 닫기
    closeModalBtn.onclick = function() {
        modal.style.display = "none";
    }

    // 선택 완료 버튼 클릭 시 모달 닫기 및 초기화
    confirmSelectionBtn.onclick = function() {
        modal.style.display = "none";
    }

    // 모달 외부 클릭 시 닫기
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

    // 증가 버튼
    document.querySelectorAll('.decrease').forEach(function(button) {
        button.addEventListener('click', function() {
            decreaseCount(button);
        });
    });

    // 감소 버튼
    document.querySelectorAll('.increase').forEach(function(button) {
        button.addEventListener('click', function() {
            increaseCount(button);
        });
    });

    // 객실 추가 버튼
    document.querySelector('.btn-add-room').addEventListener('click', function(event) {
        event.preventDefault(); // 기본 동작 방지
        addRoom();
    });

    // 성인 또는 어린이 수 감소 함수
    function decreaseCount(button) {
        var countElement = button.nextElementSibling;
        var count = parseInt(countElement.textContent.split(' ')[1]);
        if (count > 0) {
            count--;
            countElement.textContent = countElement.textContent.split(' ')[0] + ' ' + count;
        }
    }

    // 성인 또는 어린이 수 증가 함수
    function increaseCount(button) {
        var countElement = button.previousElementSibling;
        var count = parseInt(countElement.textContent.split(' ')[1]);
        if (count < 2) {
            count++;
            countElement.textContent = countElement.textContent.split(' ')[0] + ' ' + count;
        }
    }

    // 객실 추가 함수
    function addRoom() {
        var roomInfo = document.querySelector('.room-info');
        var clone = roomInfo.firstElementChild.cloneNode(true);
        var roomNumber = parseInt(roomInfo.lastElementChild.querySelector('.room-label').textContent.split(' ')[1]) + 1;
        clone.querySelector('.room-label').textContent = '객실 ' + roomNumber;

        // 마지막 카운터 div에 삭제 버튼 포함한 새로운 div 추가
        var lastCounter = clone.querySelector('.counter:last-child');
        var deleteButton = document.createElement("button");
        deleteButton.classList.add("btn", "btn-delete-room");
        deleteButton.textContent = "삭제";
        deleteButton.addEventListener('click', function() {
            clone.remove();
        });

        lastCounter.appendChild(deleteButton);

        roomInfo.appendChild(clone);

        // 새로 생성된 요소들에 이벤트 리스너 추가
        clone.querySelectorAll('.decrease').forEach(function(button) {
            button.addEventListener('click', function() {
                decreaseCount(button);
            });
        });

        clone.querySelectorAll('.increase').forEach(function(button) {
            button.addEventListener('click', function() {
                increaseCount(button);
            });
        });
    }
});
