$(document).ready(function() {
    const pricePerBreakfast = 56000;

    function updateBreakfastInfo(quantity) {
        const totalPrice = pricePerBreakfast * quantity;
        const formattedPrice = totalPrice.toLocaleString('ko-KR'); // 한국어 지역 설정을 사용하여 가격 포맷
        $(".breakfast-count").text(`성인 조식 ${quantity} * 박`);
        $(".breakfast-price").text(`${formattedPrice} KRW`);
    }

    $(".qtyminus").on("click", function() {
        var now = $(".qty").val();
        if ($.isNumeric(now)) {
            if (parseInt(now) - 1 >= 0) {
                now--;
                $(".qty").val(now);
                updateBreakfastInfo(now);
            }
        }
    });

    $(".qtyplus").on("click", function() {
        var now = $(".qty").val();
        var max = $(".qty").attr('max');
        if ($.isNumeric(now)) {
            if (max === undefined || (parseInt(now) + 1 <= parseInt(max))) {
                now++;
                $(".qty").val(now);
                updateBreakfastInfo(now);
            }
        }
    });

    // For direct input change in the number field
    $(".qty").on("input", function() {
        var now = $(".qty").val();
        if ($.isNumeric(now) && parseInt(now) >= 0) {
            updateBreakfastInfo(now);
        } else {
            $(".qty").val(0);
            updateBreakfastInfo(0);
        }
    });

    const roomPricePerAdult = parseInt($("#hidden_room_price").val()) || 0;
    const adultCount = parseInt($("#hidden_adult_count").val()) || 0;
    const roomPrice = roomPricePerAdult * adultCount;
    const taxRate = 0.04;

    function formatPrice(price) {
        return price.toLocaleString('ko-KR') + ' KRW';
    }

    function updateBreakfastInfo(quantity) {
        const totalPrice = pricePerBreakfast * quantity;
        const formattedPrice = formatPrice(totalPrice);
        $(".breakfast-count").text(`성인 조식 ${quantity} * 박`);
        $(".breakfast-price").text(formattedPrice);
        return totalPrice;
    }

    function updateTax(totalPrice) {
        const tax = totalPrice * taxRate;
        const formattedTax = formatPrice(tax);
        $(".tax").text(formattedTax);
        return tax;
    }

    function updateTotalPrice() {
        const quantity = parseInt($(".qty").val()) || 0;
        const breakfastTotal = updateBreakfastInfo(quantity);
        const taxTotal = updateTax(roomPrice + breakfastTotal);
        const totalPrice = roomPrice + breakfastTotal + taxTotal;
        const formattedTotalPrice = formatPrice(totalPrice);
        $(".total-price").text(`총 금액: ${formattedTotalPrice}`);
        $(".total-res").text(`${formattedTotalPrice} 으로 예약하기`);
        $(".room-price").text(formatPrice(roomPrice));
        $(".break-price").text(formatPrice(breakfastTotal));
        $(".tax-price").text(formatPrice(taxTotal));
        $(".total").text(`${formattedTotalPrice}`);

        $("#roomPrice").val(formatPrice(roomPrice));
        $("#breakPrice").val(formatPrice(breakfastTotal));
        $("#taxPrice").val(formatPrice(taxTotal));


        console.log(`Type of totalPrice: ${totalPrice}`);
        console.log(`Type of totalPrice: ${typeof quantity}`);

        $("#total_price").val(totalPrice);
        $("#breakfast").val(quantity);
    }

    $(".qtyminus, .qtyplus, .qty").on("click input", function() {
        updateTotalPrice();
    });

    $("#roomOrderForm").submit(function(event) {
        // 텍스트 영역의 값을 숨겨진 필드에 설정
        var additionalRequest = $("#requests1").val();
        $("#add_request").val(additionalRequest);

        // breakfast 필드가 비어 있으면 기본값을 설정
        if ($("#breakfast").val() === "") {
            $("#breakfast").val(0);
        }
    });


    // Initial call to set the values correctly
    updateTotalPrice();

});
