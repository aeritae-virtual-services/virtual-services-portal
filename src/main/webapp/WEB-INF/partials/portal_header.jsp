<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.vsportal.user.*" %>
<%@ page import="com.vsportal.task.*" %>
<%@ page import="java.util.ArrayList" %>

<%
	if(request.getAttribute("valid_session") == "true") {
		int numPokes = 0;
		try {
			User sessUsr = (User)request.getAttribute("sessionUser");
			ArrayList<Task> pokeList = sessUsr.getMyPokedTasks();
			if(pokeList != null) {
				numPokes = pokeList.size();
			}
		} catch(Error e){}
	}
%>

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
    					<c:if test='${numPokes ne 0} && ${valid_session eq "true"}'>
    						<span class="badge orange-badge">
    							${numPokes}
    						</span>
    					</c:if>
    				</a>
    				<div id="poke-view" class="poke-view" style="display: none;">
    					<h4><i class="fa fa-hand-o-right" style="margin-right: 10px;"></i>My Pokes</h4>
    					<c:forEach var="pokedTask" items="${sessionUser.myPokedTasks}">
	    					<div class="poke-item">
		    					<table>
		    						<tbody>
		    							<tr>
		    								<td>
					    						<h5><a href="/update_task/id=${pokedTask.id}">${pokedTask.number}</a> - ${pokedTask.client.displayValue}</h5>
					    						<h6>${pokedTask.instructions}</h6>
					    					</td>
					    					<td style="padding: 10px; text-align: center; white-space: nowrap;">
						    					<a onclick="acceptPoke(this, '${pokedTask.id}')" class="icon-save">
						    						<i class="fa fa-check"></i>
						    					</a>
						    					<a onclick="declinePoke(this, '${pokedTask.id}')" class="icon-cancel">
						    						<i class="fa fa-times"></i>
						    					</a>
						   					</td>
						   				</tr>
						   			</tbody>
						   		</table>
	    					</div>
	    				</c:forEach>
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
<c:if test='${valid_session eq "false"}'>
	<style>
		.auth-req {
			visibility: hidden!important;
		}
	</style>
</c:if>
<script type="text/javascript">
	//Accept Poke
	function acceptPoke(el, taskId) {
		$.ajax({
			url: "accept_poke",
			type: "POST",
			data: ({
				task_id: taskId
			}),
			success: function() {
				window.location.href = 'update_task/id=' + taskId;
			},
			error: function() {
				showDangerMessage('Accepting poke failed. Please try again.');
			}
		});
	}
	//Decline Poke
	function declinePoke(el, taskId) {
		$.ajax({
			url: "decline_poke",
			type: "POST",
			data: ({
				task_id: taskId
			}),
			success: function() {
				showInfoMessage('Poke was successfully declined.');
				$(el).closest('.poke-item').slideUp();
			},
			error: function() {
				showDangerMessage('Declining poke failed. Please try again.');
			}
		});
	}
</script>