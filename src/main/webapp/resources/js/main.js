$(document).ready(function() {
    var board = JXG.JSXGraph.initBoard('box', {boundingbox: [-10, 10, 10, -10], axis:true});
    var coordinates;

    function getCoordinates() {
        $.ajax({
            type: 'GET',
            url: 'coordinate',
            success: function(data){
                coordinates = data;
                coordinates.forEach(function(coordinate) {
                    board.create('point',[coordinate.x,coordinate.y]);
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.status);
                alert(thrownError);
            }
        });
    };

    $("#add").click(function() {
        var isContains = false;
        coordinates.forEach(function(coordinate) {
            if(coordinate.x == $("#x").val() && coordinate.y == $("#y").val()) {
                alert("Point with such coordinates already exists.");
                isContains = true;
                return ;
            }
        });
        if(!isContains) {
            var data = $("#x").val().concat(",").concat($("#y").val());
            $.ajax({
                type: 'POST',
                url: 'coordinate',
                dataType: "text",
                data: {x : $("#x").val(),
                       y : $("#y").val()},
                success: function (data) {
                    alert("Point was successfully added.");
                    board.create('point', [$("#x").val(), $("#y").val()]);
                    coordinates.push({"id": data, "x": $("#x").val(), "y": $("#y").val()})
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(xhr.status);
                    alert(thrownError);
                }
            });
        }
    });

    $("#delete").click(function() {
        var isContains = false;
        coordinates.forEach(function(coordinate) {
            if(coordinate.x == $("#x").val() && coordinate.y == $("#y").val()) {
                $.ajax({
                    type: 'DELETE',
                    url: 'coordinate/' + coordinate.id,
                    success: function(){
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert(xhr.status);
                        alert(thrownError);
                    }
                });
                isContains = true;
                return ;
            }
        });
        if(isContains) {
            alert("Point was successfully deleted.");
            window.location.replace("/");
        } else {
            alert("There is no point with such coordinates.");
        }
    });

    $("#box").click(function() {
        return ;
    });

    getCoordinates();
});

