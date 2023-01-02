/**
 * 
 */

/* flag변수를 통해 true면 오름차순, false면 내림차순 jsp 파일명을 저장하고 해당 url로 이동*/
function send(asc){
	var url;
	url=asc?"guest_jdbc.jsp":"guest_jdbc_desc.jsp";
	location.href=url;
}