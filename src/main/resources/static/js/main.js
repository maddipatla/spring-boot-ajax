$(document).ready(function(){
    $("#search-form").submit(function(event){
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {
    var search = {};
    search["username"] = $("#username").val();
    $("#search-form").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/search",
        data: JSON.stringify(search),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function(data) {
            var json = "<h4> AJAX Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
            $("#feedback").html(json);
            var newRow = "<tr><td>" + data.users[0].username + "</td><td>" + data.users[0].password +
            "</td><td>" + data.users[0].email + "</td>";
            $(newRow).appendTo($("#table"));
            console.log("SUCCESS: ", data);
            $("#btn-search").prop("disabled", false);
        },
        error: function(e) {
            var json = "<h4> AJAX Response</h4><pre>" + e.responseText + "</pre>";
            $("#feedback").html(json);
            console.log("ERROR: ", e);
            $("#btn-search").prop("disabled", false);
        }
    });
}