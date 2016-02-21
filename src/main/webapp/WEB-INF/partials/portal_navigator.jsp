<div id="sidebar-wrapper">
	<div width="100%" style="padding: 10px;">
		
	</div>
	<ul class="sidebar-nav list" style="margin-top: 40px;">
		<li>
			<a class="menu-option" href="/SCRUMware/project/projects">Projects</a>
		</li>
		<li>
			<a class="menu-option" href="/SCRUMware/sprint/sprints">Sprints</a>
		</li>
		<li>
			<a class="menu-option" href="/SCRUMware/story/stories">Stories</a>
		</li>
		<li>
			<a class="menu-option" href="/SCRUMware/task/tasks">Tasks</a>
		</li>
		<c:if test="${sessionScope.role<3}">
			<li>
				<a class="menu-option" href="/SCRUMware/user/users">Users</a>
			</li>
		</c:if>
	</ul>
</div>