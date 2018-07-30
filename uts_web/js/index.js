$(document).ready(function(){

    $('button#add_row').on('click', function (e) {
        e.preventDefault();
        addRow();
    });

    $('button#remove_row').on('click', function (e) {
        e.preventDefault();
        removeRow();
    });

    function addRow(){
        var table = $('table#myTable');
        var table_html = '<tr>\n' +
            '          <td><input name="unit_name" type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '          <td><input type="text"></td>\n' +
            '        </tr>';
        table.append(table_html);

    }

    function removeRow() {
        var table = document.getElementById('myTable');
        document.getElementById("myTable").deleteRow(table.rows.length - 1);

    }
});