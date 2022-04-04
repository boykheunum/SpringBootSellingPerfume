function InitChart(data) {
	var options = {
		chart: {
			width: 1000,
			type: 'line',
			//hình ảnh động biểu đồ
			animations: {
				enabled: true,
				easing: 'linear',
				speed: 800,
				animateGradually: {
					enabled: true,
					delay: 150
				},
				//thay đổi biểu đồ khi dât thay đổi
				dynamicAnimation: {
					enabled: true,
					speed: 350
				}
			}
		},
		series: [{
			data: [[1, 34], [3, 54], [5, 23], [15, 43]]
		}],
		xaxis: {
			type: 'numeric'
		},
		//chú thích biểu đồ
		annotations: {
			//chú thích theo cột y
			yaxis: [{
				y: 36,
				borderColor: 'pink',
				label: {
					borderColor: 'pink',
					style: {
						color: 'white',
						background: 'pink'
					},
					text: 'Y-axis annotation on 8800'
				}
			}],
			//chú thích theo cột x
			xaxis: [{
				x: 3,
				borderColor: 'red',
				label: {
					style: {
						color: 'black',
						background: 'red'
					},
					orientation: "horizontal",
					text: 'X-axis annotation - 22 Nov'
				}
			}],
			//chú thích điểm
			points: [{
				x: 6,
				y: 25,
				marker: {
					size: 10,
				},
				label: {
					borderColor: '#FF4560',
					text: 'Point Annotation'
				}
			}],
			//datalabel
			dataLabels: {
				enabled: true,
				borderColor: '#FF4560',
			},
			grid: {
				show: true,
				borderColor: 'black',
				strokeDashArray: 0,
				position: 'back',
				xaxis: {
					lines: {
						show: false
					}
				},
				yaxis: {
					lines: {
						show: false
					}
				},
				row: {
					colors: undefined,
					opacity: 0.5
				},
				column: {
					colors: undefined,
					opacity: 0.5
				},
				padding: {
					top: 0,
					right: 0,
					bottom: 0,
					left: 0
				},
			}


		}

	}

	var chart = new ApexCharts(document.querySelector("#chart"),
		options);

	chart.render();

}