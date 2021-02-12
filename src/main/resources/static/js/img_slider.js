/**
 * 
 */

$(function() {
	$('#slides').slidesjs({
		width : 400,
		height : 300,
		// 재생 옵션 추가
		// play, stop 클래스 정의하면 옵션 설정 가능
		play : {
			// 재성 버튼의 표시 가능 여부
			active : false,
			// 자동 재생 on
			auto : true,
			// 슬라이드 재생 간격
			interval : 3000,
			// true인 경우 버튼이 상황에 따라 표시됨 false인 경우 항상 표시됨
			swap : false,
			//효과제어 slide, fade
			effect : "slide"
		},
		navigation: {
			active : false
		}
	});
});