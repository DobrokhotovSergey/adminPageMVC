
function myCallbackFunction (updatedCell, updatedRow, oldValue) {
    //console.log(updatedCell.columns().header().data());
    //var title = tableFarmInvoice.column( idx ).header();
    // console.log(title);
    var idx = tableFarmInvoice.cell( this ).index().column;
    console.log(idx);
    var title = tableFarmInvoice.columns( idx ).header();
    console.log(title);

    //console.log(tableFarmInvoice.row($(updatedCell)).column().header());
    var oldPrice = parseFloat(tableFarmInvoice.row($(updatedRow)).data()[3]).toFixed(10);
    var discount = parseFloat(updatedCell.data()).toFixed(10);
    var priceWithDiscount = oldPrice - oldPrice*discount/100;
    var cross = parseFloat($('#invoiceFarm-crossCurs').val()).toFixed(10);
    var priceDiscountCross = cross*priceWithDiscount;
    tableFarmInvoice.cell( tableFarmInvoice.row($(updatedRow)).node(),4).data(isNaN(priceWithDiscount) ? 0 : priceWithDiscount).draw();
    tableFarmInvoice.cell( tableFarmInvoice.row($(updatedRow)).node(),7).data(isNaN(priceDiscountCross) ? 0 : priceDiscountCross).draw();
}
var tableFarmInvoice = $('#table-farm-invoice').DataTable({
    "footerCallback": function (row, data, start, end, display) {
        var api = this.api(),
            intVal = function (i) {
                return typeof i === 'string' ?
                    i.replace(/[, Rs]|(\.\d{2})/g,"")* 1 :
                    typeof i === 'number' ?
                        i : 0;
            },

            total3 = api.column(3).data().reduce(function (a, b) {

                return intVal(a) + intVal(b);}, 0),
            total4 = api.column(4).data().reduce(function (a, b) {return intVal(a) + intVal(b);}, 0),
            total6 = api.column(6).data().reduce(function (a, b) {return intVal(a) + intVal(b);}, 0),
            total7 = api.column(7).data().reduce(function (a, b) {return intVal(a) + intVal(b);}, 0);
        $(api.column(3).footer()).html('total price:  ' + total3 + ' ');
        $(api.column(4).footer()).html('total with discount:  ' + total4 + ' ');
        $(api.column(6).footer()).html('total cross:  ' + total6 + ' ');
        $(api.column(7).footer()).html('total cross with discount:  ' + total7 + ' ');



    },
});
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
function block_screen() {
    $('<div id="screenBlock"></div>').appendTo('#main');
    $('#screenBlock').css( { opacity: 0.1, width: $(document).width(), height: $(document).height() } );
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
    dom: 'Bfrtip',
    buttons: [
        {
            text: '<i class="fa fa-plus-circle" style="color:green"></i> farm',
            action: function ( e, dt, node, config ) {
                $('#addFarm-modal').modal('show');
             //   alert( 'farm add' );
            }
        },
        {
            text: '<i class="fa fa-file-excel-o" style="color:green"></i> excel',
            extend: 'excelHtml5',
            exportOptions: {
                columns: [ 1, 2 ]
            }
        },
        'csvHtml5',
        {
           text: '<i class="fa fa-file-pdf-o" style="color:red"></i> pdf',
            extend: 'pdfHtml5',
            exportOptions: {
                columns: [ 1, 2 ]
            }
        },
        {
            text: '<i class="fa fa-print" style="color:blue"></i> Print',
            extend: 'print',
        },

    ]
} );

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
        currency: $("input:radio[name='farmEditCurrency']:checked").val(),
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
            farmTable.cell(farmTable.row(pos).node(), 3).data(data.currency).draw();
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
    $('#product-name-edit').val(data[3]);
    $('#product-grading-edit').val(data[4]);
    $('#product-numberStemsInBox-edit').val(data[5]);
    $('#product-price-edit').val(data[6]);

    $('#product-type-edit').val(data[8]);
    $('#product-variety-edit').val(data[9]);
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
function getFarm(){
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
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
    var cross = parseFloat($(this).val());
    $('#table-farm-invoice').DataTable().rows().every( function ( rowIdx, tableLoop, rowLoop ) {
        var row = this.data();
        var discount = parseFloat(row[5]);
        var price =parseFloat(row[3]);
        row[6] = (cross.toFixed(10)*price.toFixed(10));
        row[7] = (price*cross-(isNaN(discount) ? 0 : discount)*cross*price/100);
        this.invalidate(); // invalidate the data DataTables has cached for this row
    } );
    $('#table-farm-invoice').DataTable().draw();
});
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
             callback($('<table class="table table-striped table-responsive jambo_table bulk_action table-bordered"' +
                ' id="table-production-'+id+'">' +
                '<thead>' +
                '<th></th><th>idProduct</th><th>idFarm</th><th>product</th><th>grading</th><th>number stems in Box</th><th>price,<span class="fa fa-'+currency.toLowerCase()+'"></span></th><th>currency</th><th>type</th><th>variety</th><th>edit</th>' +
                '</thead>'+
                    '<tbody></tbody>'), 'child').show();
            var tableProduction = $('#table-production-'+id).DataTable({
                order: [[ 1, 'asc' ]],
                aoColumns: [
                    {orderable: false,
                        targets  : 'no-sort',
                        targets:   [0]},
                    {}, {}, {}, {}, {}, {}, {}, {}, {}, {
                    orderable: false,
                        targets  : 'no-sort',
                        targets:   [11]}],
                dom: 'Bfrtip',
                buttons: [
                        {
                       text: '<i class="fa fa-plus-circle" style="color:green"></i> product',
                        action: function ( e, dt, node, config ) {
                            $('#addProduction-modal').modal('show');
                            $('#id-farm-foradd').val(id);
                        }
                    },
                    {
                        text: '<i class="fa fa-file-text-o" style="color:green"></i> convert to invoice',
                        action: function ( e, dt, node, config ) {
                           var objRows = $.map(dt.rows('.selected').data(), function (item) {
                                return {a:item};
                            });
                           var rows = [];
                            $.each(objRows, function (i, item) {
                                rows[i] = [item.a[3], item.a[4], item.a[6], item.a[5], item.a[5],'0','',''];
                            });
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
            $.each(data, function (i, item) {
                rows[i] = ['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                    item.idProduct, item.idFarm, item.product, item.grading, item.numberStemsInBox, item.price, item.currency, item.type, item.variety,
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
        checkboxClass: 'icheckbox_flat-green'
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
            $.ajax({
                type: "post",
                url: "editProduction",
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                mimeType: 'application/json',
                data: JSON.stringify({
                    id: $('#id-product-edit').val(),
                    idFarm:idFarm,
                    product: $('#product-name-edit').val(),
                    grading: $('#product-grading-edit').val(),
                    numberStemsInBox: $('#product-numberStemsInBox-edit').val(),
                    price: $('#product-price-edit').val(),
                    type: $('#product-type-edit').val(),
                    variety: $('#product-variety-edit').val()
                }),
                success: function (data) {
                    var tableProduction = $('#table-production-'+idFarm).DataTable();
                    tableProduction.row($('#position-product-edit').val()).data(['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                            data.id, data.idFarm, data.product, data.grading, data.numberStemsInBox, data.price, data.currency, data.type,data.variety,
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
                success: function (data) {
                    var tableProduction = $('#table-production-'+idFarm).DataTable();
                    tableProduction.row.add(['<input type="checkbox" class="flat icheckbox1" name="table_records">',
                        data.idProduct, data.idFarm, data.product, data.grading, data.numberStemsInBox, data.price, data.currency, data.type,data.variety,
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
                data:JSON.stringify({
                    farmName:$('#farm-name').val(),
                    currency:$("input:radio[name='farmCurrency']:checked").val()
                }),
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