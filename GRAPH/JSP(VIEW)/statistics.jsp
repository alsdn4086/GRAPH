<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script>

	google.charts.load('current', {
		packages : [ 'corechart' ]
	});

	//google.charts.setOnLoadCallback(columnChart1);
	// 세로 막대형 차트 
	function NumberCheck(){
		var year = $('#year option:selected').val();
		/* alert(year); */
		if(year == "2018"){
			columnChart2();	
		}
		else if(year == "2019"){
			columnChart3();
		}
		else if(year == "all"){
			columnChart1();
		}
	}
	function columnChart1() {

		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/statistics.do",
			contentType : "application/json; charset=UTF-8",
			success : function(result) {
				showchart(result.chart);
			},
			error : function(request, status, error) {				
				alert("code:" + request.status + "\n" + "message:"	
				+ request.responseText + "\n" + "error:"				
				+ error);				
				}	
		});

			
			/*  [ [ '월', '회의횟수'], [ '1',12 ],
			[ '2',39 ], [ '3',34 ], [ '4',19 ],
			[ '5',11 ], [ '6',9 ], [ '7',0 ],
			[ '8',0], [ '9',6], [ '10',5],
			[ '11',33 ],[ '12',7 ]] ; */
	} 
	function columnChart2() {

		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/statistics2.do",
			contentType : "application/json; charset=UTF-8",
			success : function(result) {
				showchart(result.chart);
			},
			error : function(request, status, error) {				
				alert("code:" + request.status + "\n" + "message:"				
				+ request.responseText + "\n" + "error:"				
				+ error);				
				}	
		});
	}
	function columnChart3() {

		$.ajax({
			type : "POST",
			dataType : "json",
			url : "/statistics3.do",
			contentType : "application/json; charset=UTF-8",
			success : function(result) {
				showchart(result.chart);
			},
			error : function(request, status, error) {				
				alert("code:" + request.status + "\n" + "message:"				
				+ request.responseText + "\n" + "error:"				
				+ error);				
				}	
		});
	} 
	/* // 버튼 동작
	$(document).ready(function() {
		$('button').on('click', function() {
			columnChart1();
		});
	}); */
	function showchart(api){
		
		var dataTable = new google.visualization.arrayToDataTable(api); 

		var options = {
			title : '월별 회의 횟수',
			hAxis : {
				title : '월',
				titleTextStyle : {
					color : 'black'
				}
			}
		};
		
		var objDiv = document.getElementById('column_chart_div1');

		var chart = new google.visualization.ColumnChart(objDiv);

		chart.draw(dataTable, options);
	}
</script>
<!--<button type="button" id="btn" onclick="columnChart1();">전체년도 월별 회의 횟수</button>/ <button type="button" id="btn" onclick="columnChart2();">2018년도 회의횟수</button>/<button type="button" id="btn" onclick="columnChart3();">2019년도 회의횟수</button> -->
월별 회의 횟수
<select id="year">
	<option>년도를 선택해주세요</option>
	<option value="all">전체년도</option>
	<option value="2018">2018년도</option>
	<option value="2019">2019년도</option>
</select>
<input type="button" value="확인" onclick="NumberCheck()">
<div id="column_chart_div1" style="width: 900px; height: 500px; /* border:1px solid black" */></div>