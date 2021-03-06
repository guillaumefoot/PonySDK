<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>PonySDK</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<link rel="stylesheet" href="css/reset.css" />
	<link rel="stylesheet" href="css/styles.css" />
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.roundabout-1.0.min.js"></script> 
	<script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
	<script type="text/javascript">		
		$(document).ready(function() {
			$('#featured ul').roundabout({
				easing: 'easeOutInCirc',
				duration: 600
			});
		});
	</script>  

	<!--[if IE 6]>
	<script src="js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script>
	  DD_belatedPNG.fix('.button');
	</script>
	<![endif]-->
</head>
<body>
	<div id="wrapper" class="container_12 clearfix">
		<?php include "header.php" ?>
		
		<div class="hr grid_12">&nbsp;</div>
		<div class="clear"></div>
		
		<div id="featured" class="clearfix grid_12">
			<ul> 
				<li>
					<a href="portfolio_single.html">
						<span>Read about this project</span>
						<img src="images/slide/1.png" alt="" />
					</a>
				</li>  
				<li>
					<a href="portfolio_single.html">
						<span>Java FrameWork</span>
						<img src="images/slide/2.png" alt="" />
					</a>	
				</li>  
				<li>
					<a href="portfolio_single.html">
						<span>Read about this project</span>
						<img src="images/600x300.gif" alt="" />
					</a>
				</li>  
				<li>
					<a href="portfolio_single.html">
						<span>Read about this project</span>
						<img src="images/600x300.gif" alt="" />
					</a>
				</li>  
				<li>
					<a href="portfolio_single.html">
						<span>Read about this project</span>
						<img src="images/600x300.gif" alt="" />
					</a>
				</li>  
			</ul> 
		</div>
		<div class="hr grid_12 clearfix">&nbsp;</div>
			
		<h2 class="grid_12 caption clearfix">Welcome! to <span>PonySDK</span>, a Java framework to make web applications by combining the power of Java and GWT (Google Web Toolkit)</h2>
		
		<div class="hr grid_12 clearfix quicknavhr">&nbsp;</div>
		<div id="quicknav" class="grid_12">
			<a class="quicknavgrid_3 quicknav alpha" href="showcase.php">
					<h4 class="title ">Demo</h4>
					<p>See the online showcase.</p>
					<p style="text-align:center;"><img alt="" src="images/Art_Artdesigner.lv.png" width="120px" height="120px" /></p>
				
			</a>
			<a class="quicknavgrid_3 quicknav" href="download.php">
					<h4 class="title ">Download SDK</h4>
					<p>Download the Pony SDK.</p>
					<p style="text-align:center;"><img alt="" src="images/download.png" width="120px" height="120px" /></p>
			</a>
			<a class="quicknavgrid_3 quicknav" href="developer.php">
					<h4 class="title ">Developer</h4>
					<p>The space for developer.</p>
					<p style="text-align:center;"><img alt="" src="images/info.png" width="120px" height="120px" /></p>
			</a>
			<a class="quicknavgrid_3 quicknav" href="discuss.php">
					<h4 class="title ">Discuss</h4>
					<p>Google Groups, Skype discussions.</p>
					<p style="text-align:center;"><img alt="" src="images/Blog_Artdesigner.lv.png" width="120px" height="120px"  /></p>
			</a>
		</div>
		<div class="hr grid_12 clearfix">&nbsp;</div>

		<?php include "footer.php" ?>
		
	</div>
</body>
</html>
