/*Source: https://www.yandex.ru/turbo?text=https%3A%2F%2Fwww.internet-technologies.ru%2Farticles%2Fsortirovka-tablicy-s-pomoschyu-jquery.html*/
/*  Sort by id  */
function sort_id()
{
    var table = $('.table');
    var tbody = $('.tbody');

    tbody.find('tr').sort(function(a, b)
    {
        if($('#id_order').val()=='asc')
        {
            var an = parseInt($('.id', a).text());
            var bn = parseInt($('.id', b).text());
            return an - bn;
        }
        else
        {
            var an = parseInt($('.id', a).text());
            var bn = parseInt($('.id', b).text());
            return bn - an;
        }

    }).appendTo(tbody);

    var sort_order=$('#id_order').val();
    if(sort_order=="asc")
    {
        document.getElementById("id_order").value="desc";
    }
    if(sort_order=="desc")
    {
        document.getElementById("id_order").value="asc";
    }
}

/*  Sort by Manufacturer  */
function sort_manufacturer()
{
    var table=$('.table');
    var tbody =$('.tbody');

    tbody.find('tr').sort(function(a, b)
    {
        if($('#manufacturer_order').val()=='asc')
        {
            return $('.manufacturer', a).text().localeCompare($('.manufacturer', b).text());
        }
        else
        {
            return $('.manufacturer', b).text().localeCompare($('.manufacturer', a).text());
        }

    }).appendTo(tbody);

    var sort_order=$('#manufacturer_order').val();
    if(sort_order=="asc")
    {
        document.getElementById("manufacturer_order").value="desc";
    }
    if(sort_order=="desc")
    {
        document.getElementById("manufacturer_order").value="asc";
    }
}

/*  Sort by Model  */
function sort_model()
{
    var table=$('.table');
    var tbody =$('.tbody');

    tbody.find('tr').sort(function(a, b)
    {
        if($('#model_order').val()=='asc')
        {
            return $('.model', a).text().localeCompare($('.model', b).text());
        }
        else
        {
            return $('.model', b).text().localeCompare($('.model', a).text());
        }

    }).appendTo(tbody);

    var sort_order=$('#model_order').val();
    if(sort_order=="asc")
    {
        document.getElementById("model_order").value="desc";
    }
    if(sort_order=="desc")
    {
        document.getElementById("model_order").value="asc";
    }
}

/*  Sort by Price  */
function sort_price()
{
    var table=$('.table');
    var tbody =$('.tbody');

    tbody.find('tr').sort(function(a, b)
    {
        if($('#price_order').val()=='asc')
        {
            var an = parseInt($('.price', a).text());
            var bn = parseInt($('.price', b).text());
            return an - bn;
        }
        else
        {
            var an = parseInt($('.price', a).text());
            var bn = parseInt($('.price', b).text());
            return bn - an;
        }

    }).appendTo(tbody);

    var sort_order=$('#price_order').val();
    if(sort_order=="asc")
    {
        document.getElementById("price_order").value="desc";
    }
    if(sort_order=="desc")
    {
        document.getElementById("price_order").value="asc";
    }
}

/*  Sort by Color  */
function sort_color()
{
    var table=$('.table');
    var tbody =$('.tbody');

    tbody.find('tr').sort(function(a, b)
    {
        if($('#color_order').val()=='asc')
        {
            return $('.color', a).text().localeCompare($('.color', b).text());
        }
        else
        {
            return $('.color', b).text().localeCompare($('.color', a).text());
        }

    }).appendTo(tbody);

    var sort_order=$('#color_order').val();
    if(sort_order=="asc")
    {
        document.getElementById("color_order").value="desc";
    }
    if(sort_order=="desc")
    {
        document.getElementById("color_order").value="asc";
    }
}

