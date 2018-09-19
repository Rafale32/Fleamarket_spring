$(function(){
	var $container = $('.slideshow'); //슬라이드쇼 전체컨테이너
	var $slideGroup = $('.slideshow-slides');//슬라이더 그룹
	var $slides = $slideGroup.find('.slide');//각각의 슬라이더 4개
	var $nav = $container.find('.slideshow-nav');//네비게이션(prev, next)
	var $indicator = $container.find('.slideshow-indicator');//인디게이터
	
	var currentIndex = 0; //현재 슬라이드의 인덱스를 저장하는 변수
	var indicatorHTML = '';
	var timer;
	
	$slides.each(function(i){
		$(this).css({
			left: 100 * i + '%'
		});
		
		indicatorHTML += '<a href="#">'+(i+1)+'</a>'
	});
	
	$indicator.html(indicatorHTML);
	
	//슬라이더 이동함수
	function goToSlide(index){
		$slideGroup.animate({
			left: -100 * index + '%'
		},/*시간간격*/ 400);
		currentIndex = index;
		updateNav();
	}
	
	//인디케이터 이벤트
	//indicator의 a태그는 원래 있던 태그가 아니라
	//함수로 만든 태그이기 때문에 click이 아닌
	//부모인 indicator에 on함수로 이벤트 적용
	/*$indicator.on('hover','a', function(event){
		event.preventDefault();
		//.index : 몇번째 인덱스인지 반환
		goToSlide($(this).index());
	});*/
	$indicator.find('a').hover(function(event){
		event.preventDefault();
		goToSlide($(this).index());
	});
	//네비게이션 이벤트
	$nav.find('a').click(function(event){
		event.preventDefault();
		if($(this).hasClass('prev')){
			goToSlide(currentIndex -1);
		}else{
			goToSlide(currentIndex +1);
		}
		
		updateNav();
	})
	
	//네비게이션 업데이트 함수
	function updateNav(){
		var $navPrev = $nav.find('.prev');
		var $navNext = $nav.find('.next');
		
		if(currentIndex == 0){
			$navPrev.addClass('disabled');
		}else{
			$navPrev.removeClass('disabled');
		}
		
		if(currentIndex == 2){
			$navNext.addClass('disabled');
		}else{
			$navNext.removeClass('disabled');
		}
		
		//해당 인디게이터에게 'active' 클래스 적용
		$indicator.find('a').removeClass('active')
			.eq(currentIndex).addClass('active');
	}
	
	//마우스 관련 이벤트
	$container.on({ //이벤트 여러개 걸때
		mouseenter : stopTimer,
		mouseleave : startTimer
	});
	
	//타이머 시작함수
	function startTimer(){
		//주기적으로 호출하는 함수
		timer = setInterval(function(){
			var nextIndex = (currentIndex + 1) % 4;
			goToSlide(nextIndex);
		}, 2000);
	}
	
	//타이머 정지함수
	function stopTimer(){
		clearInterval(timer);
	}
	
	updateNav();
	startTimer();
});



