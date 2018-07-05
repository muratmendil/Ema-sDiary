<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<
<style>
<!--
.MakaleYazariAdi {
	line-height: 34px;
}

#BegeniButonlari {
	float: right;
	margin-top: 15px;
}
.thumbnail {
	padding: 0px;
}

.panel {
	position: relative;
}

.panel>.panel-heading:after, .panel>.panel-heading:before {
	position: absolute;
	top: 11px;
	left: -16px;
	right: 100%;
	width: 0;
	height: 0;
	display: block;
	content: " ";
	border-color: transparent;
	border-style: solid solid outset;
	pointer-events: none;
}

.panel>.panel-heading:after {
	border-width: 7px;
	border-right-color: #f7f7f7;
	margin-top: 1px;
	margin-left: 2px;
}

.panel>.panel-heading:before {
	border-right-color: #ddd;
	border-width: 8px;
}
-->
</style>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<a href="#" class="MakaleYazariAdi">John Doe</a>
			<div class="btn-group" style="float: right;">
				<button type="button" class="btn btn-danger dropdown-toggle"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="glyphicon glyphicon-cog"></span> <span class="sr-only">Toggle
						Dropdown</span>
				</button>
				<ul class="dropdown-menu">
					<li><a href="#"><span class="glyphicon glyphicon-pencil"
							aria-hidden="true"></span> Edit</a></li>
					<li role="separator" class="divider"></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span>
							Delete</a></li>
				</ul>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="panel-body">
			<div class="media">
				<div class="media-left">
					<a href="#"> <img class="media-object"
						src="https://upload.wikimedia.org/wikipedia/commons/thumb/2/23/Canis_lupus.jpg/260px-Canis_lupus.jpg"
						alt="Kurt">
					</a>
				</div>
				<div class="media-body">
					<h4 class="media-heading">Lorem ipsum</h4>
					Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus
					nulla sapien, semper in sodales ac, rutrum at orci. Maecenas
					vulputate nec tellus sit amet porttitor. Suspendisse congue porta
					sagittis. Ut erat diam, consectetur sed tempus id, sodales nec
					felis. Donec sagittis nunc sapien, non consequat nunc ultrices non.
					Aliquam accumsan ligula ante, non commodo risus sodales a.
					Vestibulum facilisis, enim in porta fringilla, tortor sapien congue
					purus, porta consectetur sem turpis vitae mauris. Donec dapibus
					justo a elit semper, et scelerisque mauris ullamcorper. Maecenas
					blandit arcu nec euismod pellentesque. Fusce et imperdiet nisi, at
					suscipit sem. Aliquam pulvinar risus id cursus elementum. Nulla
					elementum placerat nibh, in dictum enim mollis non. Morbi vehicula
					eget est et tristique. Aenean condimentum augue id congue
					convallis. Phasellus congue non tellus nec pretium. Maecenas eu
					vulputate lacus, eget feugiat odio.
					<div class="clearfix"></div>
					<div class="btn-group" role="group" id="BegeniButonlari">
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-thumbs-up"></span>
						</button>
						<button type="button" class="btn btn-default">
							<span class="glyphicon glyphicon-thumbs-down"></span>
						</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<h3>User Comment</h3>
		</div>
		<!-- /col-sm-12 -->
	</div>
	<!-- /row -->
	<div class="row">
		<div class="col-sm-1">
			<div class="thumbnail">
				<img class="img-responsive user-photo"
					src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
			</div>
			<!-- /thumbnail -->
		</div>
		<!-- /col-sm-1 -->

		<div class="col-sm-9">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong>myusername</strong> <span class="text-muted">commented
						5 days ago</span>
				</div>
				<div class="panel-body">Panel content</div>
				<!-- /panel-body -->
			</div>
			<!-- /panel panel-default -->
		</div>

		<!-- /col-sm-5 -->
	</div>
	<!-- /row -->

</div>