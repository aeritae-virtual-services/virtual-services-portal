<nav class="navbar navbar-default navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-text navbar-left auth-req" id="toggle-menu" href="" data-toggle="tooltip" title="View Menu" data-placement="bottom" onclick="$('#wrapper').toggleClass('toggled'); return false;">
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
    				<a href="" data-toggle="tooltip" title="View Pokes" data-placement="bottom" onclick="return togglePokes();">
    					<i class="white-icon fa fa-hand-o-right"></i>
    					<span class="badge orange-badge">1</span>
    				</a>
    				<div id="poke-view" class="poke-view" style="display: none;">
    					<h4><i class="fa fa-hand-o-right" style="margin-right: 10px;"></i>My Pokes</h4>
    					<div class="poke-item">
    						<table>
    							<tbody>
    								<tr>
    									<td>
				    						<h5>TASK0001001 - Blue Cross Blue Shield</h5>
				    						<h6>Short Description of Task</h6>
				    					</td>
				    					<td style="padding: 10px; text-align: center; white-space: nowrap;">
					    					<a class="icon-save">
				    							<i class="fa fa-check"></i>
				    						</a>
				    						<a class="icon-cancel">
				    							<i class="fa fa-times"></i>
				    						</a>
				    					</td>
				    				</tr>
				    			</tbody>
				    		</table>
    					</div>
    					<div class="poke-item">
    						<img width="100%" src="http://rs108.pbsrc.com/albums/n31/dibbera/Pokes/animated-girl-poke.gif~c200"/>
    					</div>
    				</div>
    			</li>
    			<li>
    				<a href="" data-toggle="tooltip" title="View Notifications" data-placement="bottom" onclick="return toggleNotifications();">
    					<i class="white-icon fa fa-bell"></i>
    					<span class="badge orange-badge">1</span>
    				</a>
    				<div id="notification-view" class="notification-view" style="display: none;">
    					<h4><i class="fa fa-bell" style="margin-right: 10px;"></i>My Notifications</h4>
    					<div class="notification-item">
    						<table>
    							<tbody>
    								<tr>
    									<td>
				    						<h5>TASK0001002 - From: John Zorgdrager</h5>
				    						<h6>Hey, can you take a look at this task?</h6>
				    					</td>
				    					<td style="padding: 10px; text-align: center; white-space: nowrap;">
					    					<a class="icon-save">
				    							<i class="fa fa-check"></i>
				    						</a>
				    					</td>
				    				</tr>
				    			</tbody>
				    		</table>
    					</div>
    				</div>
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