var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++) {
	
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
} 


new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
		labels: labelData,
		datasets: [{
			label: 'My first dataset',
			backgroundColor: ["#001195", "#FFAA00", "#ADC6FF"],
			borderColor: 'rgb(255,255,255)',
			data: numericData
		}]
	},
	options: {
		title: {
			display: true,
			text: 'Project Status'
		}
	}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}