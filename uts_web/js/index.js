$(document).ready(function(){
$('#alertDanger').hide();


    $('#add').on('submit', function(e) {
      e.preventDefault();
        $.ajax({
            url: 'add-unit.php',
            method: 'POST',
            data: $(this).serialize(),
            success: function (data) {
                data = JSON.parse(data);
                prevData(data);
            }
        });
    })


});

function prevData(data) {
if(data['error'] == false) {
    var table = $('#myPrevTable');
    var initial_html = $('#myPrevTable').html();
    var table_html = '<tr id="' + data['id'] + '">\n' +
        '    <td>' + data["name"] + '</td>\n' +
        '    <td>' + data["code"] + '</td>\n' +
        '    <td>' + data["cf"] + '</td>\n' +
        '    <td>' + data["lecture"] + '</td>\n' +
        '    <td>' + data["practical"] + '</td>\n' +
        '    <td>' + data["students"] + '</td>\n' +
        '    <td>' + data["lecturer"] + '</td>\n' +
        '    <td><button class="btn btn-danger" onclick="removeUnit(' + data["id"] + ')">Delete</button></td>\n' +
        '  </tr>';

    initial_html += table_html;
    table.html(initial_html);
}else {
    $('#alertDanger').show();
    $('#alertDanger').html(data['message']);
    setTimeout(function () {
        $('#alertDanger').hide();
    }, 3000);
}
}

function removeUnit(id) {
    $.ajax({
        url: 'remove-unit.php?id=' + id,
        method: 'GET',
        success: function (data) {
            data = JSON.parse(data);
            if(data['error'] == false) {
                $('#' + data['id']).hide();
            }
        }
    });
}
