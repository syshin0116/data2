<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {

        var data = google.visualization.arrayToDataTable([
          ['일정', '시간'],
          ['수업', 8],
          ['식사', 3],
          ['이동', 2],
          ['운동', 1],
          ['유툽', 3],
          ['수면', 7]
        ]);

        var options = {
          title: '나의하루'
        };
        var data2 = google.visualization.arrayToDataTable([
            ['메뉴', '횟수'],
            ['중식', 2],
            ['분식', 2],
            ['일식', 1],
            ['한식', 1],
            ['샌드위치', 1]
          ]);

          var options2 = {
            title: '일주일 점심메뉴'
          };
          var data3 = google.visualization.arrayToDataTable([
              ['유툽카테고리', '시간'],
              ['게임', 2],
              ['애완동물', 4],
              ['스포츠', 2],
              ['맛집', 1],
              ['정보', 1]
            ]);

            var options3 = {
              title: '유툽 시청시간'
            };
        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        var chart2 = new google.visualization.PieChart(document.getElementById('piechart2'));
        var chart3 = new google.visualization.PieChart(document.getElementById('piechart3'));

        chart.draw(data, options);
        chart2.draw(data2, options2);
        chart3.draw(data3, options3);
      }
    </script>
  </head>
  <body>
    <div id="piechart" style="width: 500px; height: 300px;"></div><br>
    
    <div id="piechart2" style="width: 500px; height: 300px;"></div><br>
    <div id="piechart3" style="width: 500px; height: 300px;"></div>
  </body>
</html>
