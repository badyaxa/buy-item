makeRequest();
$('#page').change(makeRequest);
$('#size').change(makeRequest);
$('#direction').change(makeRequest);

function makeRequest() {
    $.ajax({
        url: 'http://localhost:8080/api/categories/page'
        , type: 'POST'
        , contentType: 'application/json'
        , data: JSON.stringify(getPaginationRequest())
        , success: function (res) {
            appendCarsToContainer(res.content)
        }
        , error: function (e) {
            console.log(e)
        }
    })
}

function appendCarsToContainer(items) {
    let $container = $('.container');
    $container.html('');
    for (let item of items) {
        let img = item.pathToImage ? 'http://localhost:8080/img/' + item.pathToImage : 'http://denrakaev.com/wp-content/uploads/2015/03/no-image.png';
        $container.append(`
                    <div class="item">
                         <a href="http://localhost/brand/${item.id}">
                            <h3 class="item-title">
                                 ${item.name}
                            </h3>
                            <p class="item-id"> ID ${item.id}</p>
                            <p class="item-parent-id"> parentID ${item.parentId}</p>
                            <img class="item-image" src="${img}">
                        </a>
                    </div>
            `)
    }
}

function getPaginationRequest() {
    return {
        page: $('#page').val() - 1
        , size: $('#size').val()
        , sortRequest: {
            field: 'name'
            , direction: $('#direction').val()
        }
    };
}

// $('#pagePlus0').click(() = > {
// 	$('#page').val(1);
// 	makeRequest()
// })
// $('#pagePlus1').click(() = > {
// 	$('#page').val(2);
// 	makeRequest()
// })
// $('#pagePlus2').click(() = > {
// 	$('#page').val(3);
// 	makeRequest()
// })
// $('#pagePlus3').click(() = > {
// 	$('#page').val(4);
// 	makeRequest()
// })
// $('#pagePlus4').click(() = > {
// 	$('#page').val(5);
// 	makeRequest())
// })