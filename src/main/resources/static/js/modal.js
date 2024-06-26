document.addEventListener("DOMContentLoaded", function() {
    const modal = document.getElementById("modal");
    const collapseSection = document.getElementById("collapseExample");
    const closeModalBtn = document.getElementById("closeModalBtn");
    const confirmSelectionBtn = document.getElementById("confirmSelectionBtn");
    const dateInInput = document.getElementById("date-in");
    const dateOutInput = document.getElementById("date-out");

    // 오늘 날짜와 내일 날짜 계산
    var today = new Date();
    var tomorrow = new Date();
    tomorrow.setDate(today.getDate() + 1);

    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);
    var nextDay = ('0' + tomorrow.getDate()).slice(-2);

    var startDate = year + '-' + month + '-' + day;
    var endDate = year + '-' + month + '-' + nextDay;

    // flatpickr 설정
    var checkInPicker = flatpickr("#date-in", {
        dateFormat: "Y-m-d",
        defaultDate: startDate,
        minDate: startDate,
        onChange: function(selectedDates, dateStr, instance) {
            var minCheckoutDate = new Date(selectedDates[0]);
            minCheckoutDate.setDate(minCheckoutDate.getDate() + 1);
            checkOutPicker.set('minDate', minCheckoutDate);
            checkOutPicker.setDate(minCheckoutDate);
        }
    });

    var checkOutPicker = flatpickr("#date-out", {
        dateFormat: "Y-m-d",
        defaultDate: endDate,
        minDate: tomorrow
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
                    <div class="count countA">성인 1</div>
                    <button class="increase">+</button>
                </div>
                <div class="counter">
                    <button class="decrease">-</button>
                    <div class="count countC">어린이 1</div>
                    <button class="increase">+</button>
                </div>
                <div class="counter"></div>
            </div>
        `;

        // 새로 생성된 요소들에 이벤트 리스너 추가
        roomInfo.querySelectorAll('.decrease').forEach(function(button) {
            button.addEventListener('click', decreaseCount);
        });

        roomInfo.querySelectorAll('.increase').forEach(function(button) {
            button.addEventListener('click', increaseCount);
        });
    }

    function saveData() {
        // 각 요소의 값을 가져오기
        const openDate = document.getElementById('openDate').textContent;
        const sleepDay = document.getElementById('sleepDay').textContent;
        const finDate = document.getElementById('finDate').textContent;
        const roomCount = document.getElementById('roomCount').textContent;
        const adultCount = document.getElementById('adultCount').textContent;
        const childCount = document.getElementById('childCount').textContent;

        // 로컬 스토리지에 저장
        localStorage.setItem('openDate', openDate);
        localStorage.setItem('sleepDay', sleepDay);
        localStorage.setItem('finDate', finDate);
        localStorage.setItem('roomCount', roomCount);
        localStorage.setItem('adultCount', adultCount);
        localStorage.setItem('childCount', childCount);
    }

    // 객실, 성인, 어린이 수 값 가져오기
    function countModal() {
        // 모든 countA 클래스를 가진 요소를 찾음
        var countA = document.querySelectorAll('.countA');
        var countC = document.querySelectorAll('.countC');
        var countR = document.querySelectorAll('.room-label');

        // 총합을 저장할 변수 초기화
        var totalA = 0;
        var totalC = 0;
        var totalR = 0;

        // 각 요소에 대해 반복문 실행
        countA.forEach(function(element) {
            // 각 요소의 텍스트 콘텐츠를 가져옴
            var textContent = element.textContent;

            // 공백을 기준으로 분할하여 숫자 부분을 추출
            var count = parseInt(textContent.split(' ')[1]);

            // 추출한 숫자를 총합에 더함
            totalA += count;
        });
        countC.forEach(function(element) {
            // 각 요소의 텍스트 콘텐츠를 가져옴
            var textContent = element.textContent;

            // 공백을 기준으로 분할하여 숫자 부분을 추출
            var count = parseInt(textContent.split(' ')[1]);

            // 추출한 숫자를 총합에 더함
            totalC += count;
        });
        countR.forEach(function(element) {
            // 각 요소의 텍스트 콘텐츠를 가져옴
            var textContent = element.textContent;

            // 공백을 기준으로 분할하여 숫자 부분을 추출
            var count = parseInt(textContent.split(' ')[1]);

            // 추출한 숫자를 총합에 더함
            totalR = count;
        });

        // childCount 클래스를 가진 요소를 찾음
        var adultCountElement = document.querySelector('.adultCount');
        var childCountElement = document.querySelector('.childCount');
        var roomCountElement = document.querySelector('.roomCount');

        // childCount 요소의 텍스트 콘텐츠를 totalCount로 설정
        adultCountElement.textContent = totalA;
        childCountElement.textContent = totalC;
        roomCountElement.textContent = totalR;

        var openDate = document.querySelector('.col-1.openDate');
        var finDate = document.querySelector('.col-1.vertical-line.finDate');
        var sleepDate = document.querySelector('.col-1.sleepDay');

        var openYear = dateInInput.value.split('-')[0];
        var openMon = dateInInput.value.split('-')[1];
        var openDay = dateInInput.value.split('-')[2];

        var finYear = dateOutInput.value.split('-')[0];
        var finMon = dateOutInput.value.split('-')[1];
        var finDay = dateOutInput.value.split('-')[2];

        // Date 객체를 사용하여 날짜 차이 계산
        var startDate = new Date(openYear, openMon - 1, openDay);
        var endDate = new Date(finYear, finMon - 1, finDay);
        var timeDiff = endDate - startDate;
        var sleepDay = timeDiff / (1000 * 60 * 60 * 24);

        openDate.textContent = openYear + "-" + openMon + "-" + openDay;
        finDate.textContent = finYear + "-" + finMon + "-" + finDay;
        sleepDate.textContent = sleepDay + "박";
    }

    // 섹션 클릭 시 모달 열기
    collapseSection.addEventListener("click", function() {
        modal.style.display = "block";
    });

    // 모달 닫기
    closeModalBtn.onclick = function() {
        countModal();
        saveData();
        modal.style.display = "none";
    }

    // 선택 완료 버튼 클릭 시 모달 닫기 및 초기화
    confirmSelectionBtn.onclick = function(event) {
        event.preventDefault();
        countModal();
        saveData();

        modal.style.display = "none";
    }

    // 모달 외부 클릭 시 닫기
    window.onclick = function(event) {
        if (event.target == modal) {
            countModal();
            saveData();
            modal.style.display = "none";
        }
    }

    // 감소 버튼
    document.querySelectorAll('.decrease').forEach(function(button) {
        button.addEventListener('click', decreaseCount);
    });

    // 증가 버튼
    document.querySelectorAll('.increase').forEach(function(button) {
        button.addEventListener('click', increaseCount);
    });

    // 객실 추가 버튼
    document.querySelector('.btn-add-room').addEventListener('click', function(event) {
        event.preventDefault(); // 기본 동작 방지
        addRoom();
    });

    // 성인 또는 어린이 수 감소 함수
    function decreaseCount(event) {
        event.preventDefault();
        var button = event.target;
        var countElement = button.nextElementSibling;
        var count = parseInt(countElement.textContent.split(' ')[1]);
        if (count > 0) {
            count--;
            countElement.textContent = countElement.textContent.split(' ')[0] + ' ' + count;
        }
    }

    // 성인 또는 어린이 수 증가 함수
    function increaseCount(event) {
        event.preventDefault();
        var button = event.target;
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
            button.addEventListener('click', decreaseCount);
        });

        clone.querySelectorAll('.increase').forEach(function(button) {
            button.addEventListener('click', increaseCount);
        });
    }
});
