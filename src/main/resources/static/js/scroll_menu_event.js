/**
 * 
 */

var didScroll;
var lastScrollTop = 0;
var delta = 5;
var fixHight = $('header').outerHeight();

$(window).scroll(function(event) {
	didScroll = true;
});

// 200ms 초마다 스크롤 이벤트 탐지, hasScrolled 실행
setInterval(function() {
	if (didScroll) {
		hasScrolled();
		didScroll = false;
	}
}, 200);

function hasScrolled() {
	var st = $(this).scrollTop();
	// 전에 실행됬을때위치-현재 스크롤 위치가 delta값보다 작으면 리턴
	if (Math.abs(lastScrollTop - st) <= delta)
		return;

	// 현재 스크롤 위치가 지정해놓은 위치보다 크면
	if (st > fixHight) {
		// 네비게이션 상단 부착
		$('nav').addClass('fix-nav');
	} else {
		if (st < fixHight) {
			// 네비게이션 되돌리기
			$('nav').removeClass('fix-nav');
		}
	}
	lastScrollTop = st;
}