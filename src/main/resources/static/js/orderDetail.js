function updateTotalCost() {
    // 사용자가 입력한 포인트 값 가져오기
    var pointInput = document.getElementById("point").value;
    // 포인트가 숫자인지 확인
    if (!pointInput) pointInput = 0;
    pointInput = parseInt(pointInput, 10);

    // 잔여 포인트 가져오기
    var userPoint = parseInt(document.getElementById("hiddenPoint").value, 10);

    // 총 요금 가져오기
    var totalPrice = parseInt(document.getElementById("total_price").value, 10);

    // 잔여 포인트 or 총 요금 중 작은 걸 max로 설정
    var maxUsePoint = Math.min(userPoint, totalPrice);
    document.getElementById("point").setAttribute('max', maxUsePoint);

    if (pointInput > maxUsePoint) {
        pointInput = maxUsePoint;
        document.getElementById("point").value = maxUsePoint;
    } else if (pointInput < 0) {
        pointInput = 0;
        document.getElementById("point").value = 0;
    }

    // 새로운 총 요금 계산
    var newTotal = totalPrice - pointInput;
    if (newTotal < 0) newTotal = 0;

    // 포맷팅된 총 요금 업데이트
    document.querySelector(".total-cost").innerText = '총 요금 : ' + newTotal.toLocaleString() + ' KRW';
    console.log(pointInput + '포인트');
    console.log(totalPrice + '총 요금');
    console.log(newTotal);
}
