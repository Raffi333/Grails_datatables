<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
    <asset:javascript src="datatables.min.js"/>
    %{--    <asset:javascript src="jquery-1.11.1.js.min.js"/>--}%
    %{--    <asset:stylesheet src="datatables.min.css"/>--}%
</head>

<body>
<script>

    $(document).ready(function () {
        $('#dt').DataTable({
            sScrollY: "75%",
            sScrollX: "100%",
            bProcessing: true,
            bServerSide: true,
            sAjaxSource: "/Country/dataTablesRenderer",
            bJQueryUI: false,
            bAutoWidth: false,
            sPaginationType: "full_numbers",
            aLengthMenu: [5, 10, 25, 50, 100, 200],
            iDisplayLength: 10,
            aoColumnDefs: [
                {
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).attr('style', 'font-size: 30px;text-align:center');
                    },
                    bSearchable: false,
                    bSortable: false,
                    aTargets: [3]
                },
                {
                    createdCell: function (td, cellData, rowData, row, col) {
                        $(td).attr('style', 'font-size: 30px;text-align:center');
                    },
                    render: function (data, type, full, meta) {
                        if (full) {
                            return '<img src="' + full[4] + '" width="50" height="50">'
                        } else {
                            return data;
                        }
                    },
                    bSearchable: false,
                    bSortable: false,
                    aTargets: [4]
                },
            ]
        });
    });


</script>

<div class="m-3">
    <table class="display dataTable" id="dt">
        <thead>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>capital</th>
            <th>flag</th>
            <th>coatOfArms</th>

        </tr>
        </thead>
    </table>
</div>

</body>
</html>
