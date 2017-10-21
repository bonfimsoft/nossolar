<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">

<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" media="screen" />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<script type="text/javascript" src="resources/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>


<title>Nosso Lar - Principal</title>
</head>

<body>
	    <!-- Static navbar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">SYNDIC</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="dataTable.html">DataTables</a></li>
            <li><a href="tabs.html">Tabs</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
              	<li><a href="#">Action</a></li>
                <li><a href="#">Another action</a></li>
                <li><a href="#">Something else here</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li><a href="#">Separated link</a></li>
                <li><a href="#">One more separated link</a></li>
                <li class="dropdown-submenu">
                	<a tabindex="-1" href="#">Mais opções -</a>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                    	<li><a href="#">teste2</a></li>
                        <li><a href="#">teste2</a></li>
                    </ul>
                </li>
              </ul>
            </li>
          </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                <a href="#" id="drop3" role="button" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span> Fábio Seixas Sales<b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href="#perfil"><span class="glyphicon glyphicon-user"></span> Perfil</a></li>
                    <li class="divider"></li>
                    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Sair</a></li>
                </ul>
                </li>
            </ul>
          
        </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
    
        <ol class="breadcrumb">
            <li><a href="#">Home</a></li>
            <li><a href="#">Library</a></li>
            <li class="active">Data</li>
        </ol>
        
       
        <h2>Formulário <small>Endereço</small></h2>
        <hr>
        
        <form role="form">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control ng-pristine ng-invalid ng-invalid-required" id="exampleInputEmail1" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control ng-pristine ng-invalid ng-invalid-required" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-group">
                <div class="row">
                    <div class="col-md-3">
                        <label for="">Teste 1</label>
                        <input type="text" class="form-control ng-pristine ng-invalid ng-invalid-required" required name="type_something" data-ng-trim="false" data-ng-model="form.type_something">                        
                    </div>
                    <div class="col-md-3">
                        <label for="">Teste 2</label>
                        <input type="text" class="form-control ng-pristine ng-invalid ng-invalid-required" required name="type_something" data-ng-trim="false" data-ng-model="form.type_something">                        
                    </div>
                    <div class="col-md-3">
                        <label for="">Teste 3</label>
                        <input type="text" class="form-control ng-pristine ng-invalid ng-invalid-required" required name="type_something" data-ng-trim="false" data-ng-model="form.type_something">                        
                    </div>
                    <div class="col-md-3">
                        <label for="">Teste 4</label>
                        <input type="text" class="form-control ng-pristine ng-invalid ng-invalid-required ng-invalid-equal" required name="confirm_type" data-ng-trim="false" data-ng-model="form.confirm_type" data-validate-equals="form.type_something">                        
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="exampleInputFile">File input</label>
                <input type="file" id="exampleInputFile">
                <p class="help-block">Example block-level help text here.</p>
            </div>
            <div class="checkbox">
                <label>
                	<input type="checkbox"> Check me out
                </label>
            </div>
            <button type="submit" class="btn btn-default btn-primary">Submit</button>
        </form>
      

    </div> <!-- /container -->
</html>
