/**
 * 모달 창 열기/닫기
 */
document.addEventListener('DOMContentLoaded', function () {
    var openModalBtn = document.getElementById('openModalBtn');
    openModalBtn.addEventListener('click', openModal);

    var closeModalBtn = document.getElementById('closeModalBtn');
    closeModalBtn.addEventListener('click', closeModal);

});

// 뒷배경 클릭 시 닫기 이벤트 실성
document.getElementById('modal').addEventListener('click', function(event) {
    if (event.target === modal) {
        closeModal();
    }
});

function openModal() {
    var modal = document.getElementById('modal');
    modal.style.display = 'block';
}

function closeModal() {
    var modal = document.getElementById('modal');
    modal.style.display = 'none';
}

/**
 * 객실 성인/어린이 수 증가/감소
 */
document.querySelectorAll('.decrease').forEach(function(button) {
    button.addEventListener('click', function() {
        decreaseCount(button);
    });
});

document.querySelectorAll('.increase').forEach(function(button) {
    button.addEventListener('click', function() {
        increaseCount(button);
    });
});

document.querySelector('.btn-add-room').addEventListener('click', function() {
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
    count++;
    countElement.textContent = countElement.textContent.split(' ')[0] + ' ' + count;
}

/**
 * 객실 행 추가
 */
function addRoom() {
    var roomInfo = document.querySelector('.room-info');
    var clone = roomInfo.firstElementChild.cloneNode(true);
    var roomNumber = parseInt(roomInfo.lastElementChild.querySelector('.room-label').textContent.split(' ')[1]) + 1;
    clone.querySelector('.room-label').textContent = '객실 ' + roomNumber;

    // 버튼 요소 추가
    var removeButton = document.createElement('button');
    removeButton.textContent = '객실 삭제';
    removeButton.classList.add('btn-remove-room');
    clone.appendChild(removeButton);

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

    // 새로 생성된 버튼에 삭제 이벤트 리스너 추가
    removeButton.addEventListener('click', function() {
        removeRoom(clone);
    });
}

function removeRoom(roomElement) {
    roomElement.parentNode.removeChild(roomElement);
}

/**
 * 콜랩스 기본 값으로 열어 놓기
 */
document.addEventListener('DOMContentLoaded', function () {
    var myCollapse = new bootstrap.Collapse(document.getElementById('collapseExample'), {
        toggle: true // 기본적으로 열려있도록 설정
    });
});