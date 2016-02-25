<nav class="navbar navbar-default navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-text navbar-left auth-req" id="toggle-menu" href="" data-toggle="tooltip" title="Toggle Navigation" data-placement="bottom" onclick="$('#wrapper').toggleClass('toggled'); return false;">
				<i class="white-icon fa fa-bars"></i>
			</a>
			<a class="navbar-text navbar-left navbar-image" href="home">
	       		<img class="navbar-image" alt="Aeritae Consulting Group, Ltd." src="${pageContext.servletContext.contextPath}/resources/images/ae_icon_white.png" />
	    	</a>
    	</div>
    	<div class="collapse navbar-collapse">
    		<ul class="nav navbar-nav navbar-right auth-req">
    			<li>
    				<a href="" data-toggle="tooltip" title="My Account" data-placement="bottom" >
    					<i class="white-icon fa fa-user"></i>
    				</a>
    			</li>
    		</ul>
    		<form class="navbar-form navbar-right auth-req" role="search">
    			<div class="form-group">
    				<div class="left-inner-addon">
						<i class="fa fa-search"></i>
	    				<input id="navbar-global-search" type="text" class="form-control" placeholder="Search">
	    			</div>
    			</div>
    		</form>
    		<ul class="nav navbar-nav navbar-right auth-req">
    			<li>
    				<a href="" data-toggle="tooltip" title="View Pokes" data-placement="bottom" >
    					<i class="white-icon fa fa-hand-o-right"></i>
    					<span class="badge orange-badge">3</span>
    				</a>
    			</li>
    			<li>
    				<a href="" data-toggle="tooltip" title="View Notifications" data-placement="bottom" >
    					<i class="white-icon fa fa-bell"></i>
    					<span class="badge orange-badge">3</span>
    				</a>
    			</li>
    		</ul>
    	</div>
	</div>
</nav>
<c:if test='${valid_session eq "true"}'>
	<style>
		.auth-req {
			visibility: hidden!important;
		}
	</style>
</c:if>