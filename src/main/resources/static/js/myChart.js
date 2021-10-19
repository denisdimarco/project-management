new Chart(document.getElementById("myPieChart"), {
	type: 'pie',
	data: {
		labels: ['Jannuary', 'February', 'March'],
		datasets: [{
			label: 'My first dataset',
			backgroundColor: ["#001195", "#FFAA00", "#ADC6FF"],
			borderColor: 'rgb(255,255,255)',
			data: [2, 10, 5]
		}]
	},
	options: {}
});

function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}