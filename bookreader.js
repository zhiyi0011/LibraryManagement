/**
 * 
 */
 var cols=[
	 {checkbox:true},
	 {
		 field:"book_id",
		 title:"序号"
	 },
	 {
		 field:"bname",
		 title:"书名"
	 } ,
	 {
		 field:"bauthor",
		 title:"作者"
	 },
	 {
		 field:"borrow",
		 title:"是否借出"
	 },
	 {
		 field:"btype",
		 title:"系别"
	 },
	 {
		 field:"Inventory",
		 title:"库存量"
	 },
	 {
		 field:"b_damage",
		 title:"是否损坏"
	 }
	 
	 ];
 $(document).ready(function(){
		//调用mytable函数
		mytable("#booreaTable","showbookreader",cols,"#tbar");
	});