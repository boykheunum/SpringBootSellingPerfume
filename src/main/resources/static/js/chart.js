function InitChart(data) {
	console.log(data);
	let chartTypeControlButtons = $('input[name=graphicType]');
	let initialChartType = $('input[name=graphicType]:checked').val();
	let aLuong = [], aName = [];
	$.each(data, function(key, value) {
		console.log(value.employeeName);
		console.log(value.salary);
		aLuong.push(value.salary);
		aName.push(value.employeeName);
	})

	// CHART OPTIONS by chart type
	let chartOptions = {
		bar: {
			chart: {
				type: 'bar',
			},
			series: [{
				name: 'Luong',
				data: aLuong
			},],
			dataLabels: {
				enabled: true,
				offsetX: -6,
				style: {
					fontSize: '12px',
					colors: ['black']
				}
			},
			xaxis: {
				categories: aName
			},


		},
		line: {
			chart: {
				type: 'line',
			},
			series: [{
				name: 'Luong',
				data: aLuong
			},],
			
			dataLabels: {
				enabled: true,
				offsetX: -6,
				style: {
					fontSize: '12px',
					colors: ['black']
					
				}
			},
			stroke: {
				curve: 'smooth',
				width: 5
			},
			title: {
				text: 'Average High & Low Temperature',
				align: 'left'
			},
			grid: {
				borderColor: '#e7e7e7',
				row: {
					colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
					opacity: 0.5
				},
			},
			markers: {
				size: 1
			},
			xaxis: {
				categories: aName,
				title: {
					text: 'Name'
				}
			},
			yaxis: {
				title: {
					text: 'Luong'
				},

			},
			legend: {
				position: 'top',
				horizontalAlign: 'right',
				floating: true,
				offsetY: -25,
				offsetX: -5
			}
		},
		pie: {
			chart: {
				type: 'pie'
			},
			labels: ['ADS', 'GPI', 'GRH'],
			series: [50, 15, 35],
			stroke: {
				width: 0
			}
		},

	}

	// Chart type changing (HANDLER)
	chartTypeControlButtons.change(function() {
		let selectedChartType = $(this).val();
		let updatedChartOptions = chartOptions[selectedChartType];
		chart.updateOptions(updatedChartOptions);
	})

	// think of it as a preparing the ground
	// USE 'bar' as the type. If you choose 'pie' ... you will get glithes
	var options = {
		chart: {
			width: 1000,
			type: 'bar',

		},

		series: []
	}

	var chart = new ApexCharts(document.querySelector("#chart"),
		options);

	chart.render();
	chart.updateOptions(chartOptions[initialChartType]);
}