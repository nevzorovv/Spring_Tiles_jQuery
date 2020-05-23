<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link type="text/css" rel="stylesheet" href="styles.css" media="all">
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="filter"/>
    <tiles:insertAttribute name="body"/>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
<%--<script src="js/jquery.js"></script>--%>

<!-- jQuery script -->
<script>
    /*  Sort by id  */
    function sort_id()
    {
        var table=$('.table');
        var tbody =$('.tbody');

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
</script>

<%--Filtering--%>
<script>
    var fActive = '';

    function filter(manufacturer){
        if(fActive != manufacturer){
            var tbody = $('.tbody');
            tbody.find('tr').find('th').filter('#' + manufacturer).slideDown();
            tbody.find('tr').find('th').filter(':not(#' + manufacturer + ')').slideUp();
            /*tbody.find('tr').filter('.'+color).slideDown();
            $('div').filter(':not(.'+color+')').slideUp();*/
            fActive = manufacturer;
        }
    }

    $('#Samsung_fl').click(function(){ filter('Samsung'); });
    $('.f-blue').click(function(){ filterColor('blue'); });
    $('.f-green').click(function(){ filterColor('green'); });

    $('.f-all').click(function(){
        $('div').slideDown();
        fActive = 'all';
    });
</script>

</body>
</html>