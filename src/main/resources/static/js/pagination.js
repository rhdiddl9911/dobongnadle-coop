/**
 * 
 */

function pagination(pagedata){
		// 페이지 뿌리기
		// 뿌릴(보여줄) 첫페이지와 마지막 페이지
		var start = Math.floor(pagedata.number/10)*10 + 1;
		var last = (start+9 < pagedata.totalPages ? start+9 : pagedata.totalPages);
		
		var pagelist = $("<ul></ul>");
		
		// 1페이지로 되돌아가기
		var first = $("<a></a>").text("처음").attr("href", "javascript:loadBoardList('"+1+"')");
		if(pagedata.first){first.removeAttr("href").attr("class", "disabled");}
		$("<li>").append(first).appendTo(pagelist);
		//pagelist.append();

		// 전 세트로 돌아가기 (-10)
		var pre = $("<a></a>").text("<").attr("href", "javascript:loadBoardList('"+(start-10)+"')");
		if(start-10 < 0){pre.removeAttr("href").attr("hidden", "hidden");}
		pagelist.append($("<li></li>").append(pre));
		
		// 페이지 뿌리기 1~10
		for(var i = start; i <= last*1; i++) {
			var page = $("<a></a>").text(i).attr("href", "javascript:loadBoardList('"+i+"')");
			if(i==pagedata.number+1){
				page.removeAttr("href").attr("class","disabled");
			}
			pagelist.append($("<li></li>").append(page));
		}
		
		// 후 세트로 가기 (+10)
		var next = $("<a></a>").text(">").attr("href", "javascript:loadBoardList('"+(start+10)+"')");
		if(last==pagedata.totalPages){next.removeAttr("href").attr("hidden", "hidden");}
		pagelist.append($("<li></li>").append(next));
		
		var lastPage = $("<a></a>").text("마지막").attr("href", "javascript:loadBoardList('"+pagedata.totalPages+"')");
		if(pagedata.last){
			lastPage.removeAttr("href").attr("class", "disabled");
		}
		pagelist.append($("<li></li>").append(lastPage));
		
		return pagelist;
	};