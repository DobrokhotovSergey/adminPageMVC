var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
// function formatRepo (repo) {
//     // console.log(repo);
//     if (repo.loading) return repo;
// // <option value="3620194" selected="selected">select2/select2</option>
//     var markup = '';
//     markup +='<div class="clearfix">'+repo+'</div>';
//     // var markup = '<div class="clearfix">' +
//     //     '<div class="col-sm-1">' +
//     //     '<img src="' + repo.owner.avatar_url + '" style="max-width: 100%" />' +
//     //     '</div>' +
//     //     '<div clas="col-sm-10">' +
//     //     '<div class="clearfix">' +
//     //     '<div class="col-sm-6">' + repo.full_name + '</div>' +
//     //     '<div class="col-sm-3"><i class="fa fa-code-fork"></i> ' + repo.forks_count + '</div>' +
//     //     '<div class="col-sm-2"><i class="fa fa-star"></i> ' + repo.stargazers_count + '</div>' +
//     //     '</div>';
//
//     // if (repo.description) {
//     //     markup += '<div>' + repo.description + '</div>';
//     // }
//     //
//     // markup += '</div></div>';
//
//     return markup;
// }
//
// function formatRepoSelection (repo) {
//
//     return repo;
// }
// $(document).ready(function(){
//
//     $("#client-name").select2({
//         dropdownParent: $("#searchInvoicesFarm-modal"),
//         width: '100%',
//         ajax: {
//             type: "post",
//             url: "/admin/searchClientName",
//            // dataType: 'json',
//             delay: 250,
//             data: function (params) {
//                 return {
//                     searchClientName: params.term, // search term
//                     page: params.page
//                 };
//             },
//             beforeSend: function(xhr) {
//                 xhr.setRequestHeader(header, token);
//                 beforeSend();
//             },
//             complete: function () {
//                 NProgress.done();
//                 //unblock_screen();
//             },
//             processResults: function (data, page) {
//                 console.log(data);
//                 // parse the results into the format expected by Select2.
//                 // since we are using custom formatting functions we do not need to
//                 // alter the remote JSON data
//                 return {
//                     results: data,
//
//                 };
//             },
//             cache: true
//         },
//         escapeMarkup: function (markup) { return markup; }, // let our custom formatter work
//         minimumInputLength: 1,
//         templateResult: formatRepo, // omitted for brevity, see the source of this page
//         // templateSelection: formatRepoSelection // omitted for brevity, see the source of this page
//
//     });
// });
function ajaxGraphicsFarm(){
    $.ajax({
        type: "post",
        url: "getGraphicsFarm",
        dataType: 'json',
        mimeType: 'application/json',
       //  contentType: "application/json; charset=utf-8",
        // data:JSON.stringify({start:start, end:end}),
        success: function (data) {
            console.log(data);
            $('#graphics-content').show();


            var areaChartData = {
                labels: ["January", "February", "March", "April", "May", "June", "July"],
                datasets: [
                    {
                        label: "Electronics",
                        fillColor: "rgba(210, 214, 222, 1)",
                        strokeColor: "rgba(210, 214, 222, 1)",
                        pointColor: "rgba(210, 214, 222, 1)",
                        pointStrokeColor: "#c1c7d1",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: [65, 59, 80, 81, 56, 55, 40]
                    }
                ]
            };

            var areaChartOptions = {
                //Boolean - If we should show the scale at all
                showScale: true,
                //Boolean - Whether grid lines are shown across the chart
                scaleShowGridLines: false,
                //String - Colour of the grid lines
                scaleGridLineColor: "rgba(0,0,0,.05)",
                //Number - Width of the grid lines
                scaleGridLineWidth: 1,
                //Boolean - Whether to show horizontal lines (except X axis)
                scaleShowHorizontalLines: true,
                //Boolean - Whether to show vertical lines (except Y axis)
                scaleShowVerticalLines: true,
                //Boolean - Whether the line is curved between points
                bezierCurve: true,
                //Number - Tension of the bezier curve between points
                bezierCurveTension: 0.3,
                //Boolean - Whether to show a dot for each point
                pointDot: false,
                //Number - Radius of each point dot in pixels
                pointDotRadius: 4,
                //Number - Pixel width of point dot stroke
                pointDotStrokeWidth: 1,
                //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
                pointHitDetectionRadius: 20,
                //Boolean - Whether to show a stroke for datasets
                datasetStroke: true,
                //Number - Pixel width of dataset stroke
                datasetStrokeWidth: 2,
                //Boolean - Whether to fill the dataset with a color
                datasetFill: true,
                //String - A legend template
                legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].lineColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
                //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,
                //Boolean - whether to make the chart responsive to window resizing
                responsive: true
            };

            //Create the line chart
            // areaChart.Line(areaChartData, areaChartOptions);

            //-------------
            //- LINE CHART -
            //--------------
            var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
            var lineChart = new Chart(lineChartCanvas);
            var lineChartOptions = areaChartOptions;
            lineChartOptions.datasetFill = false;
            lineChart.Line(areaChartData, lineChartOptions);

            //-------------
            //- PIE CHART -
            //-------------
            // Get context with jQuery - using jQuery's .get() method.
            var pieChartCanvas = $("#pieChart").get(0).getContext("2d");
            var pieChart = new Chart(pieChartCanvas);
            var PieData = data;
            var pieOptions = {
                //Boolean - Whether we should show a stroke on each segment
                segmentShowStroke: true,
                //String - The colour of each segment stroke
                segmentStrokeColor: "#fff",
                //Number - The width of each segment stroke
                segmentStrokeWidth: 2,
                //Number - The percentage of the chart that we cut out of the middle
                percentageInnerCutout: 50, // This is 0 for Pie charts
                //Number - Amount of animation steps
                animationSteps: 100,
                //String - Animation easing effect
                animationEasing: "easeOutBounce",
                //Boolean - Whether we animate the rotation of the Doughnut
                animateRotate: true,
                //Boolean - Whether we animate scaling the Doughnut from the centre
                animateScale: false,
                //Boolean - whether to make the chart responsive to window resizing
                responsive: true,
                // Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
                maintainAspectRatio: true,

                //String - A legend template
              legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<segments.length; i++){%><li><span style=\"background-color:<%=segments[i].fillColor%>\"></span><%if(segments[i].label){%><%=segments[i].label%>: <%}%><%= segments[i].value%> invoices</li><%}%></ul>"
            };
            //Create pie or douhnut chart
            // You can switch between pie and douhnut using the method below.

            var myChart  = pieChart.Doughnut(PieData, pieOptions);
            document.getElementById('legend').innerHTML = myChart.generateLegend();


        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Graphics of Farms is not retrieve :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
}

$(".nav-header li a").click(function(e){

    e.preventDefault(); //To prevent the default anchor tag behaviour
    var url = this.href;
    $(".main").load(url);
//  return false;
});





var invoiceShipmentTable = $('#invoiceShipment-table').DataTable({
    autoWidth: false,
    order: [[ 1, 'asc' ]],
    columnDefs: [ {
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [0],
        class:"show-invoice"
    },{
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [1],
        class:"details-control"
    }
    ],
});
var invoiceFarmTable = $('#invoiceFarm-table').DataTable({
    autoWidth: false,
    order: [[ 1, 'asc' ]],
    columnDefs: [ {
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [1],
        class:"details-control"
    },{
        targets  : 'no-sort',
        visible: false,
        searchable: false,
        targets:   [2],
    },
        {
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [4],
    },
        {
            orderable: false,
            targets  : 'no-sort',
            //className: 'select-checkbox',
            targets:   [5],
        }
    ],
    dom: 'Bfrtip',
// {
//     className: "btn btn-success",
//         text: '<i class="fa fa-plus" style="color:white"></i><span style="color:white"> product</span>',
//     action: function ( e, dt, node, config ) {
//     $('#addProduction-modal').modal('show');
//     $('#id-farm-foradd').val(id);
// }

    buttons: [
        {
            className: "btn btn-info",
            text: '<i class="fa fa-file-text-o" style="color:white"></i><span style="color:white">convert to shipment</span>',
            action: function ( e, dt, node, config ) {
                var ids = $.map(dt.rows('.selected').data(), function (item) {
                    return item[2];
                });
                shipmentInvoicesModal(ids);

            }}]
});

function shipmentInvoicesModal(ids){
    $('#shipment-invoice-modal').modal('show');

    // // $('#farm-invoice-modal-id').val(id);
    $( tableShipmentInvoice.table().footer() ).addClass( 'highlight' );
    // // var faCurr = currency.toLowerCase();
    // tableFarmInvoice.clear().draw();
    // tableFarmInvoice.rows.add(rows).draw();
    // console.log(objRows);

    tableShipmentInvoice.clear().draw();
    $.ajax({
        type: "post",
        url: "getInvoiceFarmProduction",
        dataType: 'json',
        data:{"id":ids},
        mimeType: 'application/json',
        complete: function (response) {
            NProgress.done();
            unblock_screen();
            var data = JSON.parse(response.responseText);
            console.log(data);
            var rows = [];
           $.each(data, function (i, item) {
                rows[i] = [
                    item.farmName,1,item.variety,item.clientName,item.type,item.numberStemsInBox,item.prices.price,'',item.currency,'','',item.idInvoiceFarm, item.idProduct, item.idProductionInvoiceFarm
                ];
            });
            tableShipmentInvoice.rows.add(rows).draw();
            $('#table-shipment-invoice').DataTable().MakeCellsEditable({
                "onUpdate": callBackEditableShipmentTable,
                "inputCss":'input-discount',
                "columns": [1,7],
                "inputTypes": [
                    {
                        "column":1,
                        "type": "number",
                        "options":null
                    },
                    {
                        "column":7,
                        "type": "discount",
                        "options":null
                    },
                ],
                "confirmationButton": {
                    "confirmCss": 'btn btn-info btn-xs',
                    "cancelCss": 'btn btn-danger btn-xs'
                },
            });
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        error: function () {
            notifyAfterAjax('error','Sorry, InvoiceFarm Products can not be displayed :(');
        }
    });
}

$(document).on("click", ".editable_text", function() {
    var original_text = $(this).text();
    var new_input = $("<input class=\"text_editor\"/>");
    new_input.val(original_text);
    $(this).replaceWith(new_input);
    new_input.focus();
});

$(document).bind("blur", ".text_editor", function() {
    var new_input = $(this).val();
    var updated_text = $("<span class=\"editable_text\">");
    updated_text.text(new_input);
    $(this).replaceWith(updated_text);
});

function ajaxInvoicesShipment(start, end){
    $('#invoiceFarmDiv').hide();
    $('#farmTableDiv').hide();
    $('#employeeDiv').hide();
    $.ajax({
        type: "post",
        url: "getListInvoicesShipment",
        dataType: 'json',
        mimeType: 'application/json',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify({start:start, end:end}),
        success: function (data) {
            console.log(data);
            invoiceShipmentTable.clear().draw();

            $('#invoiceShipmentDiv').show();

            var rows = [];
            data.forEach(function(item, i, arr) {
                rows[i] = ['','',item.id, item.invoiceName, item.invoiceDate,item.crossUSD_EUR, item.crossEUR_USD,item.totalPrice_USD, item.totalPrice_EUR]
            });
            invoiceShipmentTable.rows.add(rows).draw();
            // drawIcheck();
            // invoiceFarmTable.on( 'draw.dt', function () {
            //     drawIcheck();
            // } );
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but not retrieve list of Invoices for Farms :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
}
function ajaxInvoiceFromFarm(start,end,client){
    $('#farmTableDiv').hide();
    $('#invoiceShipmentDiv').hide();
    $('#employeeDiv').hide();
    $.ajax({
        type: "post",
        url: "getListInvoicesFarm",
        dataType: 'json',
        mimeType: 'application/json',
        contentType: "application/json; charset=utf-8",
        data:JSON.stringify({start:start, end:end, client: client}),
        success: function (data) {
            invoiceFarmTable.clear().draw();
            $('#invoiceFarmDiv').show();

            var rows = [];
            data.forEach(function(item, i, arr) {
                rows[i] = ['<input type="checkbox" class="flat icheckbox1" name="table_records">','',item.id, item.farmName, item.clientName,item.invoiceName, item.invoiceDate,item.currency]
            });
            invoiceFarmTable.rows.add(rows).draw();
            drawIcheck();
            invoiceFarmTable.on( 'draw.dt', function () {
                drawIcheck();
            } );
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but not retrieve list of Invoices for Farms :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
}
$('#addEmployee-submit').on('click', function(){
    var form = $('#addEmployee-form').serializeObject();
    $.ajax({
        type: "post",
        url: "createEmployee",
        dataType: 'json',
        data:JSON.stringify(form),
        contentType: "application/json; charset=utf-8",
        mimeType: 'application/json',
        success: function (data) {
            console.log(data);

        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but new User is not created :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});
function ajaxUsers(){
    $.ajax({
        type: "post",
        url: "getListEmployee",
        dataType: 'json',
        mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            $('#employeeDiv').show();

            var tableEmployee = $('#employee-table').DataTable({
                destroy: true,
                dom: '<lBf<t>ip>',
                buttons: [
                    {
                        className: "btn btn-success",
                        text: '<i class="fa fa-plus" style="color:white"></i><span style="color:white"> Add employee</span>',
                        action: function () {
                            $('#addEmployee-modal').modal('show');
                           // shipmentInvoicesModal(ids);

                        }}]
            });
            tableEmployee.clear().draw();
            var rows = [];
            data.forEach(function(item, i, arr) {
                rows[i] = [item.id,item.userName, item.role, item.status,
                    '<a class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                    '<a class="btn btn-danger btn-xs"><i class="fa  fa-trash-o"></i> Delete </a>']
            });
            tableEmployee.rows.add(rows).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but not retrieve list of Users :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
}
function ajaxFarm(){
    $('#employeeDiv').hide();
    $('#invoiceFarmDiv').hide();
    $('#invoiceShipmentDiv').hide();
    $.ajax({
        type: "post",
        url: "getListFarm",
        dataType: 'json',
        mimeType: 'application/json',
        success: function (data) {
            farmTable.clear().draw();

            $('#farmTableDiv').show();
            var rows = [];
            data.forEach(function(item, i, arr) {
                rows[i] = ['',item.id, item.farmName, item.currency,
                    '<a class="btn btn-info editFarm btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                    '<a class="btn btn-danger deleteFarm btn-xs"><i class="fa  fa-trash-o"></i> Delete </a>']
            });
            farmTable.rows.add(rows).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but not retrieve list of Farms :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
}

// if (window.location.href==(window.location.protocol + "//" + window.location.host + "/admin#farm") ) {
//     ajaxFarm();
// }
// if (window.location.href==(window.location.protocol + "//" + window.location.host + "/admin#invoiceFromFarm") ) {
//     ajaxInvoiceFromFarm();
// }
// $(window).bind('hashchange', function() {
//     var newhash = window.location.hash.substring(1); // it gets id of clicked element
//     if(newhash=='farm'){
//         ajaxFarm();
//     }else if(newhash=='invoiceFromFarm'){
//         ajaxInvoiceFromFarm();
//     }
//
// });
$(".alert").addClass("in").fadeOut(4500);

/* swap open/close side menu icons */
$('[data-toggle=collapse]').click(function(){
    // toggle icon
    $(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
});


var intVal = function (i) {
    return typeof i === 'string' ?
        i.replace(/[, Rs]|(\.\d{5})/g,"")* 1 :
        typeof i === 'number' ?
            i : 0;
};
$('#create-shipment-invoice-btn-save').on('click', function () {
    var data = $('#table-shipment-invoice').DataTable().rows().data().toArray();
    var tempListObj = [];
    data.forEach(function(item, i, arr) {
        console.log(item[11]);
        tempListObj[i] = {"farmName": item[0], "box": item[1],
            "priceForStem":item[6], "priceForBox": item[7],
            "priceCross": item[9], "priceWithBoxCross": item[10], "idInvoiceFarm":item[11],"idProduct":item[12],"idProductionInvoiceFarm":item[13]};
    });
    $('#shipment-invoice-modal').modal('hide');

    $.ajax({
        type: "post",
        url: "createInvoiceShipment",
        //dataType: 'json',
        data:JSON.stringify({
            id:0,
            invoiceName:$('#shipment-invoice').val(),
            invoiceDate:$('#invoiceFarm-date').val(),
            crossUSD_EUR: $('#shipment-invoice-USD_EUR').val(),
            crossEUR_USD: $('#shipment-invoice-EUR_USD').val(),
            totalPrice_USD: $('#shipment-totalPrice_USD').text(),
            totalPrice_EUR: $('#shipment-totalPrice_EUR').text(),
            productionShipmentList:tempListObj,

        }),
        contentType: "application/json; charset=utf-8",
        //mimeType: 'application/json',
        success: function (data) {
            notifyAfterAjax('success','Invoice for Shipment is created!');
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Invoice for Shipment is not created :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});
$('#createInvoiceFarm-btn-save').on('click', function () {
    var data = $('#table-farm-invoice').DataTable().rows().data().toArray();
    var tempListObj = [];
    data.forEach(function(item, i, arr) {
        console.log(item[9]);
        tempListObj[i] = {"idProduct":item[8],"idFarm":item[9],"product":item[0], "grading":item[1],
            "numberStemsInBox":item[2], "prices":{"price":item[3], "priceDiscount":item[4], "discount":item[5], "priceCross":item[6],
                "priceDiscountCross":item[7]}};
    });
    $('#farm-invoice-modal').modal('hide');
    $.ajax({
        type: "post",
        url: "createInvoiceFarm",
        //dataType: 'json',
        data:JSON.stringify({
            id:0,
            idFarm: $('#farm-invoice-modal-id').val(),
            currency: $('#curr-invoiceFarm').val(),
            clientName: $('#invoiceFarm-clientName').val(),
            invoiceName:$('#invoiceFarm-name').val(),
            invoiceDate:$('#invoiceFarm-date').val(),

            listProduction:tempListObj,
            prices: {
                crossCurs:$('#invoiceFarm-crossCurs').text(),
                price: $('#totalPrice').text(),
                priceDiscount: $('#totalPriceDiscount').text(),
                priceCross: $('#totalPriceCross').text(),
                priceDiscountCross: $('#totalPriceDiscountCross').text(),
            }
        }),
        contentType: "application/json; charset=utf-8",
        //mimeType: 'application/json',
        success: function (data) {
            notifyAfterAjax('success','Invoice from Farm is created!');
        },
        beforeSend: function(xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Invoice from Farm is not created :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});

function callBackEditableShipmentTable(updatedCell, updatedRow, oldValue, columnIndex){
    if(columnIndex==7){//
        var oldPrice = intVal(tableShipmentInvoice.row($(updatedRow)).data()[6]);
        if(tableShipmentInvoice.row($(updatedRow)).data()[8] == 'USD'){
            var USD_EUR = intVal($('#shipment-invoice-USD_EUR').val());
            var priceWithBox = USD_EUR*intVal(updatedCell.data())+oldPrice;
            tableShipmentInvoice.cell( tableShipmentInvoice.row($(updatedRow)).node(),10).data(isNaN(priceWithBox) ? 0 : priceWithBox).draw();
        }
        else if(tableShipmentInvoice.row($(updatedRow)).data()[8] == 'EUR'){
            var EUR_USD = intVal($('#shipment-invoice-EUR_USD').val());
            var priceWithBox = EUR_USD*intVal(updatedCell.data())+oldPrice;
            tableShipmentInvoice.cell( tableShipmentInvoice.row($(updatedRow)).node(),10).data(isNaN(priceWithBox) ? 0 : priceWithBox).draw();
        }
    }
}

function myCallbackFunction (updatedCell, updatedRow, oldValue, columnIndex) {
    if(columnIndex==5){//
        var oldPrice = intVal(tableFarmInvoice.row($(updatedRow)).data()[3]);
        var discount = intVal(updatedCell.data());
        var priceWithDiscount = oldPrice - oldPrice*discount/100;
        var cross = intVal($('#invoiceFarm-crossCurs').val());
        var priceDiscountCross = cross*priceWithDiscount;
        tableFarmInvoice.cell( tableFarmInvoice.row($(updatedRow)).node(),4).data(isNaN(priceWithDiscount) ? 0 : priceWithDiscount).draw();
        tableFarmInvoice.cell( tableFarmInvoice.row($(updatedRow)).node(),7).data(isNaN(priceDiscountCross) ? 0 : priceDiscountCross).draw();

    }
}
//shipment-invoice-USD_EUR
$('#shipment-invoice-USD_EUR').on('keyup', function(){
    var cross = intVal($(this).val());
    $('#table-shipment-invoice').DataTable().rows().every( function ( rowIdx, tableLoop, rowLoop ) {
        var row = this.data();
        if(row[8]=='USD'){
            var price =intVal(row[6]);
            var priceBox = intVal(row[7]);
            row[9] = (cross*price);
            row[10] = (cross*(priceBox));
            this.invalidate(); // invalidate the data DataTables has cached for this row
        }
    } );
    $('#table-shipment-invoice').DataTable().draw();
});
$('#shipment-invoice-EUR_USD').on('keyup', function(){
    var cross = intVal($(this).val());
    $('#table-shipment-invoice').DataTable().rows().every( function ( rowIdx, tableLoop, rowLoop ) {
        var row = this.data();
        if(row[8]=='EUR'){
            var price =intVal(row[6]);
            var priceBox = intVal(row[7]);
            row[9] = (cross*price);
            row[10] = (cross*(priceBox));
            this.invalidate(); // invalidate the data DataTables has cached for this row
        }
    } );
    $('#table-shipment-invoice').DataTable().draw();
});


var tableShipmentInvoice = $('#table-shipment-invoice').DataTable({
    "columnDefs": [
        {
            "targets": [ 11 ],
            "visible": false,
            "searchable": false
        }
    ],
    "footerCallback": function (row, data, start, end, display) {
        var api = this.api();
        var USD_EUR = intVal($('#shipment-invoice-USD_EUR').text());
        var EUR_USD = intVal($('#shipment-invoice-EUR_USD').text());

        var total3 = 0, total4=0, total6=0,total7=0;
        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total3 +=intVal(data[5])*intVal(data[6])+intVal(data[7]);
        });

        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total6 +=intVal(data[5])*intVal(data[9])+intVal(data[7]);
        });
        $('#shipment-invoice-totalPrice td').eq(0).html('<span id="shipment-totalPrice_USD">'+total3+'</span>');
        $('#shipment-invoice-totalPrice td').eq(1).html('<span id="shipment-totalPrice_EUR">'+total6+'</span>');
    },
});
// var tableShipmentInvoice = table-shipment-invoice
var tableFarmInvoice = $('#table-farm-invoice').DataTable({
    "columnDefs": [{
        "targets": [ 8 ],
        "visible": false,
        "searchable": false
    },
        {
            "targets": [ 9 ],
            "visible": false,
            "searchable": false
        }
    ],
    "footerCallback": function (row, data, start, end, display) {
        var api = this.api();


        var total3 = 0, total4=0, total6=0,total7=0;
        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total3 +=intVal(data[2])*intVal(data[3]);
        });
        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total4 +=intVal(data[2])*intVal(data[4]);
        });
        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total6 +=intVal(data[2])*intVal(data[6]);
        });
        api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
            var data = this.data();
            total7 +=intVal(data[2])*intVal(data[7]);
        });

        // console.log(api.column(2).data());
        $('#farm-invoice-totalPrice td').eq(0).html('<span id="totalPrice">'+total3+'</span>');
        $('#farm-invoice-totalPrice td').eq(1).html('<span id="totalPriceDiscount">'+total4+'</span>');
        $('#farm-invoice-totalPrice td').eq(2).html('<span id="totalPriceCross">'+total6+'</span>');
        $('#farm-invoice-totalPrice td').eq(3).html('<span id="totalPriceDiscountCross">'+total7+'</span>');
     },
});


function block_screen() {
    $('<div id="screenBlock"></div>').appendTo('#content-main');
    $('#screenBlock').css( { opacity: 0.6, width: $(document).width(), height: $(document).height() } );
    $('#screenBlock').addClass('blockDiv');
    // $('#screenBlock').animate({opacity: 0.1}, 100);
}

function unblock_screen() {
    $('#screenBlock').animate({opacity: 0}, 200, function() {
        $('#screenBlock').remove();
    });
}
function beforeSend(){
    block_screen();
    NProgress.start();
}


var farmTable = $('#farmTable').DataTable({
    autoWidth: false,
    order: [[ 1, 'asc' ]],
    columnDefs: [ {
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [0],
        class:"details-control"
    },{
        orderable: false,
        targets  : 'no-sort',
        //className: 'select-checkbox',
        targets:   [3],
    }
    ],
    dom: '<lBf<t>ip>',
    buttons: [
        {
            className: "btn btn-success",
            text: '<i class="fa fa-plus" style="color:white"></i><span style="color:white"> farm</span>',
            // text: '<i class="fa fa-plus-circle" style="color:green"></i> farm',
            action: function ( e, dt, node, config ) {
                $('#addFarm-modal').modal('show');
                //   alert( 'farm add' );
            }
        },
        // {
        //     text: '<i class="fa fa-file-excel-o" style="color:green"></i> excel',
        //     extend: 'excelHtml5',
        //     exportOptions: {
        //         columns: [ 1, 2 ]
        //     }
        // },
        // 'csvHtml5',
        // {
        //     text: '<i class="fa fa-file-pdf-o" style="color:red"></i> pdf',
        //     extend: 'pdfHtml5',
        //     exportOptions: {
        //         columns: [ 1, 2 ]
        //     }
        // },
        // {
        //     text: '<i class="fa fa-print" style="color:blue"></i> Print',
        //     extend: 'print',
        // },

    ]
} );
function createInvoicePdf(){
    kendo.drawing.drawDOM($("#tab-content")).then(function(group) {
        kendo.drawing.pdf.saveAs(group, "Converted PDF.pdf");
    });
}
// $('#pdf-maker1').on('click', function () {
//     console.log('pdf make');
//
// });
// var docDefinition = { content: $('#tab-content').html() };
// pdfMake.createPdf(docDefinition).download();



$('#deleteProduct-submit').on('click', function(){
    var pos = $('#position-product-delete').val();
    var id = $('#id-product-delete').val();
    var idFarm = $('#id-farmOfProduct-delete').val();
    console.log('pos='+pos);
    console.log('id='+id);
    $.ajax({
        type: "post",
        url: "deleteProduct",
        dataType: 'json',
        data:{idProduct:id},
        // contentType: "application/json; charset=utf-8",
        mimeType: 'application/json',
        success: function (data) {
            console.log(data);
            $('#deleteProduct-modal').modal('hide');
            if(data){
                $('#table-production-'+idFarm).DataTable().row(pos).remove() .draw();
            }else{
                notifyAfterAjax('error','Sorry, but Product is not deleted :(');
            }
        },
        beforeSend: function(xhr) {
            // here it is
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Product is not deleted :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});
$('#deleteFarm-submit').on('click', function(){
    var pos = $('#position-farm-delete').val();
    var id = $('#id-farm-delete').val();
    $.ajax({
        type: "post",
        url: "deleteFarm",
        dataType: 'json',
        data:{id:id},
        mimeType: 'application/json',
        success: function (data) {
            $('#deleteFarm-modal').modal('hide');
            if(data){
                farmTable.row(pos).remove() .draw();
            }else{
                notifyAfterAjax('error','Sorry, but Farm is not deleted :(');
            }
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Farm is not deleted :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});
$('#editFarm-submit').on('click', function(){
    var farm = {
        id:$('#id-farm-edit').val(),
        farmName:$('#edit-farm-name').val(),
    };
    var pos = $('#position-farm-edit').val();
    $('#editFarm-modal').modal('hide');
    $.ajax({
        type: "post",
        url: "editFarm",
        dataType: 'json',
        data:JSON.stringify(farm),
        contentType: "application/json; charset=utf-8",
        mimeType: 'application/json',
        success: function (data) {

            notifyAfterAjax('success','Farm is edited!');

            farmTable.cell(farmTable.row(pos).node(), 2).data(data.farmName).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        complete: function () {
            NProgress.done();
            unblock_screen();
        },
        error: function (xhr, status, error) {
            notifyAfterAjax('error','Sorry, but Farm is not edited :(');
            console.log(xhr);
            console.log(status);
            console.log(error);
        }
    });
});

$('#farmTable tbody ').on('click','tr td table tr td .deleteProduct', function(){
    //tr td .deleteProduct
    var table = $(this).closest('table').DataTable();
    var data = table.row( $(this).parents('tr') ).data();
    var position = table.cell($(this).parents('td') ).index().row;
    $('#position-product-delete').val(position);
    $('#id-product-delete').val(data[1]);
    $('#id-farmOfProduct-delete').val(data[2]);
    $('#deleteProduct-modal').modal('show');
});

$('#farmTable tbody  ').on( 'click', 'tr td .deleteFarm',  function () {
    var data = farmTable.row( $(this).parents('tr') ).data();
    $('#deleteFarm-modal').modal('show');
    var position = farmTable.cell($(this).parents('td') ).index().row;
    $('#position-farm-delete').val(position);
    $('#id-farm-delete').val(data[1]);
    //alert( 'edit row id = '+data[0] );
});
$('#farmTable tbody ').on('click','tr td table tr td .editProduct', function(){
    //tr td .deleteProduct
    var table = $(this).closest('table').DataTable();
    var data = table.row( $(this).parents('tr') ).data();
    var position = table.cell($(this).parents('td') ).index().row;
    $('#position-product-edit').val(position);
    $('#id-product-edit').val(data[1]);
    $('#id-farmOfProduct-edit').val(data[2]);
    $('#product-variety-edit').val(data[3]);
    $('#product-type-edit').val(data[4]);
    $('#product-variety-edit').val(data[3]);
    $('#product-type-edit').val(data[4]);
    $('#product-grading-edit').val(data[5]);
    $('#product-numberStemsInBox-edit').val(data[6]);
    $('#product-name-edit').val(data[7]);
    $('#product-price-edit').val(data[8]);

    $('#editProduct-modal').modal('show');
});
$('#farmTable tbody  ').on( 'click', 'tr td .editFarm',  function (e) {
    var data = farmTable.row( $(this).parents('tr') ).data();
    var position = farmTable.cell($(this).parents('td') ).index().row;
    $('#editFarm-modal').modal('show');
    $('#edit-farm-name').val(data[2]);
    $('#id-farm-edit').val(data[1]);
    $('input:radio[name="farmEditCurrency"][value="'+data[3]+'"]').iCheck('check');
});
$.urlParam = function(name){
    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
    if (results==null){
        return null;
    }
    else{
        return results[1] || 0;
    }
}
function getInvoiceShipment(){
    $('#searchInvoicesShipment-modal').modal('show');
}
function getInvoiceFromFarm(){
    $('#searchInvoicesFarm-modal').modal('show');
    // history.pushState(null, null, '/admin/getListInvoicesFarm');
    // ajaxInvoiceFromFarm();

}
function getGraphicsFarm(){
    history.pushState(null, null, '/admin/getGraphicsFarm');
    ajaxGraphicsFarm();
}
$('#searchInvoicesShipment-submit').on('click', function(){
    $('#searchInvoicesShipment-modal').modal('hide');
    var start = $('#invoiceShipment-search-start').text();
    var end = $('#invoiceShipment-search-end').text();
    history.pushState(null, null, '/admin/getListInvoicesShipment?start='+start+'&end='+end);

    ajaxInvoicesShipment(start,end);
});
$('#searchInvoicesFarm-submit').on('click', function(){
    $('#searchInvoicesFarm-modal').modal('hide');
    var start = $('#invoiceFarm-search-start').text();
    var end = $('#invoiceFarm-search-end').text();
    var client = $('#search-invoiceFarm-client').val();
    history.pushState(null, null, '/admin/getListInvoicesFarm?start='+start+'&end='+end+'&client='+client);

    ajaxInvoiceFromFarm(start,end, client);
});
if(window.location.pathname=='/admin/getListFarm'){
    ajaxFarm();
}else if(window.location.pathname=='/admin/getGraphicsFarm'){
    ajaxGraphicsFarm();
}else if(window.location.pathname=='/admin/getUsers'){
    ajaxUsers();
}
else if(window.location.pathname.indexOf('/admin/getListInvoicesFarm') == 0){
    var start = $.urlParam('start');
    var end = $.urlParam('end');
    var client = $.urlParam('client');
    ajaxInvoiceFromFarm(start, end, client);
}
else if(window.location.pathname.indexOf('/admin/getListInvoicesShipment') == 0){
    var start = $.urlParam('start');
    var end = $.urlParam('end');
    ajaxInvoicesShipment(start, end);
}
function getPageUsers(){
    history.pushState(null, null, '/admin/getListEmployee');
    ajaxUsers();
}

function getFarm(){
    history.pushState(null, null, '/admin/getListFarm');
    ajaxFarm();
    $('#invoiceFarmDiv').hide();
    // window.location.hash = 'farm'; // it appends id to url without refresh

}
$("button").click(function () {
    $(".hidden").show();
});
function notifyAfterAjax(type, msg){
    var delay = 4000;
    if(type == 'danger'){
        delay = 100000;
    }
    new PNotify({
        delay: delay,
        history: false,
        title: 'Regular '+type,
        text: msg,
        type: type,
        styling: 'bootstrap3'
    });
}
var button='<button class="close" type="button" title="Remove this page">×</button>';

function closeTabs(index){
    var tr = invoiceShipmentTable.row(index).node();
    $(tr).removeClass('shownInv')
    //invoiceShipmentTable.row(index).closest('tr').removeClass('shown');
   // console.log($(event).parent('a').attr('href'));
}

function getTableShipment(id){
    $.ajax({
        type: "post",
        url: "getInvoiceProductionShipment",
        dataType: 'json',
        data:{"id":id},
        mimeType: 'application/json',
        complete: function (response) {
            NProgress.done();
            unblock_screen();
            console.log(response);
            var data = JSON.parse(response.responseText);

            var tableProduction = $('#tab'+id).find('.tab-shipment-invoice-table').DataTable({
                order: [[ 1, 'asc' ]],
                aoColumns: [
                    {orderable: false,
                        visible: false,
                        searchable:false,
                        targets:   [0]},
                    {
                        visible: false,
                        targets: [1],
                        searchable:false
                    },
                    {}, {}, {}, {}, {},{},{},{}],
                "footerCallback": function (row, data, start, end, display) {
                    // var api = this.api();
                    // var USD_EUR = intVal($('#shipment-invoice-USD_EUR').text());
                    // var EUR_USD = intVal($('#shipment-invoice-EUR_USD').text());
                    //
                    // var total3 = 0, total4=0, total6=0,total7=0;
                    // api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
                    //     var data = this.data();
                    //     total3 +=intVal(data[5])*intVal(data[6])+intVal(data[7]);
                    // });
                    //
                    // api.rows().every( function ( rowIdx, tableLoop, rowLoop, mult ) {
                    //     var data = this.data();
                    //     total6 +=intVal(data[5])*intVal(data[9])+intVal(data[7]);
                    // });
                    // $('#shipment-invoice-totalPrice td').eq(0).html('<span id="shipment-totalPrice_USD">'+total3+'</span>');
                    // $('#shipment-invoice-totalPrice td').eq(1).html('<span id="shipment-totalPrice_EUR">'+total6+'</span>');
                },
                // dom: 'frtip',
            }).draw();
            var rows = [];
            tableProduction.clear().draw();
            // console.log();
            $.each(data, function (i, item) {
                // console.log(item);
                rows[i] = [
                    item.idInvoiceFarm, item.idProduct,item.farmName,item.box, item.clientName,item.numberStemsInBox, item.priceForStem, item.priceForBox, item.priceCross,item.priceWithBoxCross
                ];
            });
            tableProduction.rows.add(rows).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        error: function () {
            notifyAfterAjax('error','Sorry, InvoiceFarm Products can not be displayed :(');
        }
    });
}

$('#invoiceShipment-table').on('click', 'td.show-invoice', function () {
    var tr = $(this).closest('tr');
    var row = invoiceShipmentTable.row(tr);
    var index = invoiceShipmentTable.row( this ).index();
    var id = row.data()[2];
    var date = row.data()[4];
    var invoiceName = row.data()[3];
    // var currency = row.data()[7];
    if (tr.hasClass('shownInv')) {
        // row.child.hide();
        // tr.removeClass('shown');
    } else {
        $('#tab-list').append($('<li><a href="#tab' + id + '" role="tab" data-toggle="tab">Tab ' + id +
            '<button class="close" onclick="closeTabs('+index+');" type="button" title="Remove this page">×</button></a></li>'));
        console.log(date);

        var invoiceHtml = $('#shipment-invoice-html');
//tab-shipment-invoice
        $('#tab-content').append($('<div class="tab-pane" id="tab' + id + '">' +
            invoiceHtml.html()+
            '</div>'));
        // $('.shipment-date').html(date);
        $('#tab'+id).find('.tab-shipment-invoice').html(invoiceName);
        $('#tab'+id).find('.tab-shipment-date').html(date);
        $('#tab-list a[href="#tab'+id+'"]').tab('show');
        getTableShipment(id);
        tr.addClass('shownInv');
    }
});

$('#tab-list').on('click', '.close', function(event) {
    event.preventDefault();
    var tabID = $(this).parents('a').attr('href');
    $(this).parents('li').remove();
    $(tabID).remove();
    $('#tab-list a[href="#tabInvoiceShipment"]').tab('show');
});
$('#invoiceShipment-table').on('click', 'td.details-control', function () {

    var tr = $(this).closest('tr');
    var row = invoiceShipmentTable.row(tr);
    var id = row.data()[2];
    // var currency = row.data()[8];
    if (row.child.isShown()) {
        row.child.hide();
        tr.removeClass('shown');
    } else {
        formatShipment(row.child, id);
        // formatInvoiceFarm(row.child, id, currency);
        tr.addClass('shown');
    }
});
$('#invoiceFarm-table').on('click', 'td.details-control', function () {
    var tr = $(this).closest('tr');
    var row = invoiceFarmTable.row(tr);
    var id = row.data()[2];
    var currency = row.data()[7];
    if (row.child.isShown()) {
        row.child.hide();
        tr.removeClass('shown');
    } else {
        formatInvoiceFarm(row.child, id, currency);
        tr.addClass('shown');
    }
});
$('#farmTable').on('click', 'td.details-control', function () {
    var tr = $(this).closest('tr');
    var row = farmTable.row(tr);
    var id = row.data()[1];
    var currency = row.data()[3];
    if (row.child.isShown()) {
        row.child.hide();
        tr.removeClass('shown');
    } else {
        format(row.child, id, currency);
        tr.addClass('shown');
    }
});
$('#invoiceFarm-crossCurs').on('keyup', function(){
    var cross = intVal($(this).val());
    $('#table-farm-invoice').DataTable().rows().every( function ( rowIdx, tableLoop, rowLoop ) {
        var row = this.data();
        var discount = intVal(row[5]);
        var price =intVal(row[3]);

        row[6] = (cross*price);
        row[7] = (price*cross-(isNaN(discount) ? 0 : discount)*cross*price/100);
        this.invalidate(); // invalidate the data DataTables has cached for this row
    } );
    $('#table-farm-invoice').DataTable().draw();
});

function formatShipment(callback, id){
    $.ajax({
        type: "post",
        url: "getInvoiceProductionShipment",
        dataType: 'json',
        data:{"id":id},
        mimeType: 'application/json',
        complete: function (response) {
            NProgress.done();
            unblock_screen();
            console.log(response);
            var data = JSON.parse(response.responseText);
            callback($('<table class="table-hover table table-striped table-responsive jambo_table bulk_action table-bordered"' +
                ' id="table-invoiceShipment-production-'+id+'">' +
                '<thead>' +
                '<th>id Shipment</th><th>id Product</th><th>Farm Name</th><th>box</th><th>Client Name</th><th>Number Stems in Box</th><th>price for stem</th><th>price for box</th><th>price cross</th><th>price with box cross</th>' +
                '</thead>'+
                '<tbody></tbody>'), 'child').show();
            var tableProduction = $('#table-invoiceShipment-production-'+id).DataTable({
                order: [[ 1, 'asc' ]],
                aoColumns: [
                    {orderable: false,
                        visible: false,
                        searchable:false,
                        targets:   [0]},
                    {
                        visible: false,
                        targets: [1],
                        searchable:false
                    },
                    {}, {}, {}, {}, {},{},{},{}]
                // dom: 'frtip',
            }).draw();
            var rows = [];
            tableProduction.clear().draw();
            // console.log();
            $.each(data, function (i, item) {
                // console.log(item);
                rows[i] = [
                    item.idInvoiceFarm, item.idProduct,item.farmName,item.box, item.clientName,item.numberStemsInBox, item.priceForStem, item.priceForBox, item.priceCross,item.priceWithBoxCross
                ];
            });
            tableProduction.rows.add(rows).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        error: function () {
            notifyAfterAjax('error','Sorry, InvoiceFarm Products can not be displayed :(');
        }
    });
}
function formatInvoiceFarm(callback, id, currency) {
    $.ajax({
        type: "post",
        url: "getInvoiceFarmProduction",
        dataType: 'json',
        data:{"id":[id]},
        mimeType: 'application/json',
        complete: function (response) {
            NProgress.done();
            unblock_screen();
            var data = JSON.parse(response.responseText);
            callback($('<table class="table-hover table table-striped table-responsive jambo_table bulk_action table-bordered"' +
                ' id="table-invoiceFarm-production-'+id+'">' +
                '<thead>' +
                '<th>idProduct</th><th>idFarm</th><th>product</th><th>grading</th><th>number stems in Box</th><th>currency</th><th>price,<span class="fa fa-'+currency.toLowerCase()+'"></span></th><th>total Price Discount</th><th>cross Curs</th><th>total price cross</th><th>total price cross discount</th><th>type</th><th>variety</th><th>edit</th>' +
                '</thead>'+
                '<tbody></tbody>'), 'child').show();
            var tableProduction = $('#table-invoiceFarm-production-'+id).DataTable({
                order: [[ 1, 'asc' ]],
                aoColumns: [
                    {orderable: false,
                        visible: false,
                        searchable:false,
                        targets:   [0]},
                    {
                        visible: false,
                        targets: [1],
                        searchable:false
                    },
                    {}, {}, {}, {}, {}, {}, {},{},{},{},{}, {
                        orderable: false,
                        targets  : 'no-sort',
                        targets:   [11]}],
               // dom: 'frtip',
            }).draw();
            var rows = [];
            tableProduction.clear().draw();

            $.each(data, function (i, item) {
                // console.log(item);
                rows[i] = [
                    item.idProduct, item.idFarm, item.product, item.grading, item.numberStemsInBox,item.currency, item.prices.price, item.prices.priceDiscount, item.prices.crossCurs, item.prices.priceCross,item.prices.priceDiscountCross, item.type, item.variety,
                    '<a class="btn btn-danger deleteProduct btn-xs"><i class="fa fa-trash-o"></i> Delete </a>'
                ];
            });
            tableProduction.rows.add(rows).draw();
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        error: function () {
            notifyAfterAjax('error','Sorry, InvoiceFarm Products can not be displayed :(');
        }
    });
}
function format(callback, id, currency) {
    $.ajax({
        type: "post",
        url: "getProduction",
        dataType: 'json',
        data:{id:id},
        mimeType: 'application/json',
        complete: function (response) {
            NProgress.done();
            unblock_screen();
            var data = JSON.parse(response.responseText);
            callback($('<table class="table-hover table table-striped table-responsive jambo_table bulk_action table-bordered"' +
                ' id="table-production-'+id+'">' +
                '<thead>' +
                '<th></th><th>idProduct</th><th>idFarm</th><th>variety</th><th>type</th><th>grading</th><th>number stems in Box</th><th>product</th><th>price,<span class="fa fa-'+currency.toLowerCase()+'"></span></th><th>currency</th><th>edit</th>' +
                '</thead>'+
                '<tbody></tbody>'), 'child').show();
            var tableProduction = $('#table-production-'+id).DataTable({
                order: [[ 1, 'asc' ]],
                aoColumns: [
                    {
                        searchable: false,
                        targets:   [0]},
                    {
                        visible: false,
                        searchable: false,
                        targets:   [1]},
                    {
                        visible: false,
                        searchable: false,
                        targets:   [2]
                    }, {}, {}, {}, {}, {}, {}, {}, {
                        orderable: false,
                        targets  : 'no-sort',
                        targets:   [11]}],
                dom: 'Bfrtip',
                buttons: [
                    {
                        className: "btn btn-success",
                        text: '<i class="fa fa-plus" style="color:white"></i><span style="color:white"> product</span>',
                        action: function ( e, dt, node, config ) {
                            $('#addProduction-modal').modal('show');
                            $('#id-farm-foradd').val(id);
                        }
                    },
                    {
                        className: "btn btn-info",
                        text: '<i class="fa fa-file-text-o" style="color:white"></i><span style="color:white"> convert to invoice </span>',
                        action: function ( e, dt, node, config ) {
                            var objRows = $.map(dt.rows('.selected').data(), function (item) {
                                return {a:item};
                            });
                            var rows = [];
                            $.each(objRows, function (i, item) {

                                rows[i] = [item.a[7], item.a[5], item.a[6], item.a[8], item.a[8],'0','','',item.a[1], item.a[2]];
                            });
                            $('#curr-invoiceFarm').val(currency);
                            if(currency=='USD'){
                                $('#invoiceFarm-currencyOther').addClass('fa-eur');
                                $('#invoiceFarm-currencyOther').removeClass('fa-usd');
                                $('.farm-invoice-mainCurrency').addClass('fa-usd');
                                $('.farm-invoice-mainCurrencyDiscount').addClass('fa-usd');
                                $('.farm-invoice-mainCurrency').removeClass('fa-eur');
                                $('.farm-invoice-mainCurrencyDiscount').removeClass('fa-eur');
                                $('.farm-invoice-crossCurrency').addClass('fa-eur');
                                $('.farm-invoice-crossCurrency').removeClass('fa-usd');
                                $('.farm-invoice-crossCurrencyDiscount').addClass('fa-eur');
                                $('.farm-invoice-crossCurrencyDiscount').removeClass('fa-usd');
                            }else if(currency=='EUR'){
                                $('#invoiceFarm-currencyOther').addClass('fa-usd');
                                $('#invoiceFarm-currencyOther').removeClass('fa-eur');
                                $('.farm-invoice-mainCurrency').addClass('fa-eur');
                                $('.farm-invoice-mainCurrencyDiscount').addClass('fa-eur');
                                $('.farm-invoice-mainCurrency').removeClass('fa-usd');
                                $('.farm-invoice-mainCurrencyDiscount').removeClass('fa-usd');
                                $('.farm-invoice-crossCurrency').addClass('fa-usd');
                                $('.farm-invoice-crossCurrency').removeClass('fa-eur');
                                $('.farm-invoice-crossCurrencyDiscount').addClass('fa-usd');
                                $('.farm-invoice-crossCurrencyDiscount').removeClass('fa-eur');
                            }
                            $('#farm-invoice-modal').modal('show');
                            tableFarmInvoice.columns.adjust().responsive.recalc();
                            $('#farm-invoice-modal-id').val(id);
                            $( tableFarmInvoice.table().footer() ).addClass( 'highlight' );
                            var faCurr = currency.toLowerCase();
                            tableFarmInvoice.clear().draw();
                            tableFarmInvoice.rows.add(rows).draw();
                            console.log(objRows);

                            $('#table-farm-invoice').DataTable().MakeCellsEditable({
                                "onUpdate": myCallbackFunction,
                                "inputCss":'input-discount',
                                "columns": [2,5],
                                "inputTypes": [
                                    {
                                        "column":2,
                                        "type": "number",
                                        "options":null
                                    },
                                    {
                                        "column":5,
                                        "type": "discount",
                                        "options":null
                                    },
                                ],
                                "confirmationButton": {
                                    "confirmCss": 'btn btn-info btn-xs',
                                    "cancelCss": 'btn btn-danger btn-xs'
                                },
                            });
                        }
                    }
                ]
            }).draw();
            var rows = [];
            tableProduction.clear().draw();
            console.log(data);
            // '<th></th><th>idProduct</th><th>idFarm</th><th>variety</th><th>type</th><th>garding</th><th>number stems in Box</th>
            // <th>product</th><th>price,<span class="fa fa-'+currency.toLowerCase()+'"></span></th><th>currency</th><th>edit</th>' +

            $.each(data, function (i, item) {
                rows[i] = ['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                    item.idProduct, item.idFarm, item.variety, item.type, item.grading, item.numberStemsInBox, item.product, item.price, item.currency,
                    '<a class="btn btn-info editProduct btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                    '<a class="btn btn-danger deleteProduct btn-xs"><i class="fa fa-trash-o"></i> Delete </a>'
                ];
            });
            tableProduction.rows.add(rows).draw();
            drawIcheck();
            tableProduction.on( 'draw.dt', function () {
                drawIcheck();
            } );
        },
        beforeSend: function(xhr) {
            xhr.setRequestHeader(header, token);
            beforeSend();
        },
        error: function () {
            notifyAfterAjax('error','Sorry, Products can not be displayed :(');
        }
    });
}
function drawIcheck(){
    $('.icheckbox1').iCheck({
        checkboxClass: 'icheckbox_flat-blue'
    });
    $('.bulk_action input').on('ifChecked', function () {
        checkState = '';
        $(this).parent().parent().parent().addClass('selected');
        countChecked();
    });
    $('.bulk_action input').on('ifUnchecked', function () {
        checkState = '';
        $(this).parent().parent().parent().removeClass('selected');
        countChecked();
    });
}
$('body').on('hidden.bs.modal', '.modal-form', function () {
    var idForm = $(this).find("form").attr('id');
    $("form#"+idForm).parsley().reset();
    $("form#"+idForm)[0].reset();
});

function init_parsley() {
    if( typeof (parsley) === 'undefined'){ return; }
    $/*.listen*/('parsley:field:validate', function() {
        validateFront();
        validateFrontProduct();
        validateEditProduct();
    });
    $('#editProduct-submit').on('click', function() {
        $('#editProduction-form').parsley().validate();
        validateEditProduct();
    });
    $('#addFarm-submit').on('click', function() {
        $('#addFarm-form').parsley().validate();
        validateFront();
    });
    $('#addProduct-submit').on('click', function() {
        $('#addProduction-form').parsley().validate();
        validateFrontProduct();
    });
    var validateEditProduct = function () {
        if (true === $('#editProduction-form').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
            $('#editProduction-modal').modal('hide');
            var idFarm = $('#id-farmOfProduct-edit').val();
            $('#editProduct-modal').modal('hide');
            var form = $('#editProduction-form').serializeObject();
            form['idProduct'] = $('#id-product-edit').val();
            form['idFarm'] = idFarm;
            $.ajax({
                type: "post",
                url: "editProduction",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
                data: JSON.stringify(form),
                success: function (item) {
                    var tableProduction = $('#table-production-'+idFarm).DataTable();
                    tableProduction.row($('#position-product-edit').val()).data(['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                        item.idProduct, item.idFarm, item.variety, item.type, item.grading, item.numberStemsInBox, item.product, item.price, item.currency,
                        '<a class="btn btn-info editProduct btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                        '<a class="btn btn-danger deleteProduct btn-xs"><i class="fa fa-trash-o"></i> Delete </a>']).draw();
                    drawIcheck();
                    tableProduction.on( 'draw, draw.dt', function () {
                        drawIcheck();
                    } );
                    notifyAfterAjax('success','product was edited!');
                },
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                    beforeSend();
                },
                complete: function () {
                    NProgress.done();
                    unblock_screen();
                },
                error: function (xhr, status, error) {
                    notifyAfterAjax('error','Sorry, but product not edit :(');
                }
            });
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };
    var validateFrontProduct = function() {
        if (true === $('#addProduction-form').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
            $('#addProduction-modal').modal('hide');
            var idFarm = $('#id-farm-foradd').val();
            $.ajax({
                type: "post",
                url: "addProduction",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
                data: JSON.stringify({
                    idFarm:idFarm,
                    product: $('#product-name').val(),
                    grading: $('#product-grading').val(),
                    numberStemsInBox: $('#product-numberStemsInBox').val(),
                    price: $('#product-price').val(),
                    type: $('#product-type').val(),
                    variety: $('#product-variety').val()
                }),
                success: function (item) {
                    var tableProduction = $('#table-production-'+idFarm).DataTable();
                    tableProduction.row.add(['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                        item.idProduct, item.idFarm, item.variety, item.type, item.grading, item.numberStemsInBox, item.product, item.price, item.currency,
                        '<a class="btn btn-info editProduct btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                        '<a class="btn btn-danger deleteProduct btn-xs"><i class="fa fa-trash-o"></i> Delete </a>']).draw();
                    notifyAfterAjax('success','new product added!');
                    drawIcheck();
                    tableProduction.on( 'draw.dt', function () {
                        drawIcheck();
                    } );
                },
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                    beforeSend();
                },
                complete: function () {
                    NProgress.done();
                    unblock_screen();
                },
                error: function (xhr, status, error) {
                    notifyAfterAjax('error','Sorry, but new product not added :(');
                    console.log(xhr);
                    console.log(status);
                    console.log(error);
                }
            });
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };
    // $('input.flat').iCheck({
    //     checkboxClass: 'icheckbox_flat-blue',
    //     radioClass: 'iradio_flat-blue'
    // });


    $('#addFarm-modal').on('shown.bs.modal', function () {
        $('#farm-USD').iCheck('update');
        $('#farm-EUR').iCheck('update');
    });
    var validateFront = function() {

        if (true === $('#addFarm-form').parsley().isValid()) {
            $('.bs-callout-info').removeClass('hidden');
            $('.bs-callout-warning').addClass('hidden');
            var token = $("meta[name='_csrf']").attr("content");
            var header = $("meta[name='_csrf_header']").attr("content");
            $('#addFarm-modal').modal('hide');
            $.ajax({
                type: "post",
                url: "addFarm",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
                data:JSON.stringify(
                    $('#addFarm-form').serializeObject()
                ),
                success: function (data) {
                    farmTable.row.add(['',data.id,data.farmName, data.currency,
                        '<a class="btn btn-info editFarm btn-xs"><i class="fa fa-pencil"></i> Edit </a>'+
                        '<a class="btn btn-danger deleteFarm btn-xs"><i class="fa fa-trash-o"></i> Delete </a>']).draw();
                    notifyAfterAjax('success','new farm added!');
                },
                beforeSend: function(xhr) {
                    xhr.setRequestHeader(header, token);
                    beforeSend();
                },
                complete: function () {
                    NProgress.done();
                    unblock_screen();
                },
                error: function (xhr, status, error) {
                    notifyAfterAjax('error','Sorry, but new farm not added :(');
                    console.log(xhr);
                    console.log(status);
                    console.log(error);
                }
            });
        } else {
            $('.bs-callout-info').addClass('hidden');
            $('.bs-callout-warning').removeClass('hidden');
        }
    };

    try {
        hljs.initHighlightingOnLoad();
    } catch (err) {}

};
$('#daterange-btn2').daterangepicker(
    {
        ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate: moment()
    },
    function (start, end) {
        $('#daterange-btn2 span').html('from <span id="invoiceShipment-search-start" style="font-weight: bold;">'+start.format('DD-MM-YYYY') + '</span> to <span id="invoiceShipment-search-end" style="font-weight: bold;">' + end.format('DD-MM-YYYY')+'</span>');
    }
);
$('#daterange-btn').daterangepicker(
    {
        ranges: {
            'Today': [moment(), moment()],
            'Yesterday': [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
            'Last 7 Days': [moment().subtract(6, 'days'), moment()],
            'Last 30 Days': [moment().subtract(29, 'days'), moment()],
            'This Month': [moment().startOf('month'), moment().endOf('month')],
            'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
        },
        startDate: moment().subtract(29, 'days'),
        endDate: moment()
    },
    function (start, end) {
        $('#daterange-btn span').html('from <span id="invoiceFarm-search-start" style="font-weight: bold;">'+start.format('DD-MM-YYYY') + '</span> to <span id="invoiceFarm-search-end" style="font-weight: bold;">' + end.format('DD-MM-YYYY')+'</span>');
      //  $('#daterange-btn span').html(start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'));
    }
);

