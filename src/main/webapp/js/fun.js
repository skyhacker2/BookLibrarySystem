var player=document.getElementById("audio");

function asplay()
{
	player.play();
}
function key_down(event)
{
	key = event.keyCode;
	if (key == 17)	// Ctrl键按下
		asplay();
}


var timer;
var c = 0;
function time_count() {
	//alert("width:" + c + "%");
	var s=document.getElementById("time_bar");
	s.style.width=c+ "%";
	timer=setTimeout("time_count()",1000)
	c=c+100/15;
	if (c>(100+100/15*2)) {	// 延迟两秒
		document.wordForm.submit();
		return;
	}
}
time_count();

