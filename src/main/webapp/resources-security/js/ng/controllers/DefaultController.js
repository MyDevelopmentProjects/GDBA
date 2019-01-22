

angular.module('app').controller('DefaultController',
    ['$scope', '$http', function ($scope, $http) {

        $scope.updateData = false;


        $scope.grapStyle = {
            colors: ['#a88add', '#0cc2aa', '#fcc100'],
            series: {shadowSize: 3},
            xaxis: {show: true, font: {color: '#ccc'}, position: 'bottom'},
            yaxis: {show: true, font: {color: '#ccc'}},
            grid: {hoverable: true, clickable: true, borderWidth: 0, color: 'rgba(120,120,120,0.5)'},
            tooltip: true,
            tooltipOpts: {
                content: '%x.0 is %y.4', defaultTheme: false, shifts: {x: 0, y: -40}
            }
        };

        $scope.graphData = [
            { data: [[1,3.6],[2,3.5],[3,6],[4,4],[5,4.3],[6,3.5],[7,3.6]],
                points: { show: true, radius: 0},
                splines: { show: true, tension: 0.45, lineWidth: 2, fill: 1 }
            },
            { data: [[1,3],[2,2.6],[3,3.2],[4,3],[5,3.5],[6,3],[7,3.5]],
                points: { show: true, radius: 0},
                splines: { show: true, tension: 0.45, lineWidth: 2, fill: 1 }
            },
            { data: [[1,2],[2,1.6],[3,2.4],[4,2.1],[5,1.7],[6,1.5],[7,1.7]],
                points: { show: true, radius: 0},
                splines: { show: true, tension: 0.45, lineWidth: 2, fill: 1 }
            }
        ];


        setTimeout(function(){

            $scope.graphData = [
                { data: [[1,3.6],[2,3.5],[3,6],[4,4],[5,4.3],[6,3.5],[7,3.6]],
                    points: { show: true, radius: 0},
                    splines: { show: true, tension: 0.45, lineWidth: 2, fill: 1 }
                },
                { data: [[1,3],[2,2.6],[3,3.2],[4,3],[5,3.5],[6,3],[7,3.5]],
                    points: { show: true, radius: 0},
                    splines: { show: true, tension: 0.45, lineWidth: 2, fill: 1 }
                }
            ];

            $("#plotter").plot($scope.graphData, $scope.grapStyle);

            $scope.showData = true;
            console.log("Lunched")
        }, 3000);

    }]);
