<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/home.css" rel="stylesheet">
    <link href="/resources/css/button.css" rel="stylesheet">
    <title>Finance Tracker</title>
</head>
<body>
    <nav class="slidenav navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbutton navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <p class="navbar-brand" href="index" style="color: white"><a href="/home" style="color: white">Finance Tracker</a></p>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="#" style="color: white">Stock Tracking</a>
                    </li>
                    <li>
                        <a href="#" style="color: white">Exchange Rates</a>
                    </li>
                    <li>
                        <a href="#" style="color: white">About</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

<!-- Закончился navbar -->
    <div class="jumbotron text-center main-image">

    </div>

    <div class="container main-menu">
        <div class="row">
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="../resources/img/stock-market-numbers.jpg">
                    <a class="button" style="vertical-align:middle" href="/tracking"><span>Stock Tracking</span></a>
                    <h3><strong>NASDAQ Stock tracking</strong></h3>
                    <p>Tracking of the main market of NASDAQ quotes</p>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="../resources/img/foreign-1.jpg">
                    <a class="button" style="vertical-align:middle" href="/exchange"><span>Exchange Rates</span></a>
                    <h3><strong>Currency Exchange rates</strong></h3>
                    <p>Actual rates of the basic world Exchange rates</p>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="thumbnail">
                    <img src="../resources/img/electronic_delivery.jpg">
                    <a class="button" style="vertical-align:middle" href="/about"><span>About System</span></a>
                    <h3><strong>Read about this system</strong></h3>
                    <p>Read the basic information about the system</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <p><strong>This site created special for tracking finance information. Access to all functions of the site are absolutely free. Good luck!</strong></p>
            </div>
        </div>
    </div>
</body>
</html>
