<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<head>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}
.magnify{
	width: 350px;
	margin: 80px auto;
	position: relative;
}

/* 在这里我们来设置放大镜的样式 */
.large {
	width: 350px;
	height: 350px;
	position: absolute;
	/* 圆角 */
	border-radius: 100%;
	/* 这里使用多重阴影、来实现玻璃的效果 */
	box-shadow: 0 0 0 7px rgba(255,255,255,0.8),0 0 7px 7px rgba(0,0,0,0.3),inset 0 0 40px 2px rgba(0,0,0,0.3); 
	/* 加载放大镜的图片 */
	background: url(<c:url value='${path}'/>) no-repeat;
	/* 放大镜默认隐藏 */
	display: none;
}

/* 解决放大镜在放大的过程中边缘重叠的BUG */
.small {
	display: block;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	// 定义图像的实际尺寸、
	var native_width = 0;
	var native_height = 0;
	// 首先、我们应该获得图像的实际尺寸、（本地的图片）
	$('.small').load(function(){
		// 这里我们需要重新创建一个和之前相同的图像对象、
		// 因为我们不能直接获得图像尺寸的宽高、
		// 因为我们在HTML里已经指定了图片宽度为200px、
		var img_obj = new Image();
		img_obj.src = $(this).attr('src');
		//  在这里这段代码写在这里是非常有必要的、
		//  如果在图像加载之前就访问的话、return的宽高值为0、
		native_width = img_obj.width;
		native_height = img_obj.height;
		// 现在、我来开始写鼠标移动的函数、mousemove()
		$('.magnify').mousemove(function(e){
			// 获得鼠标X轴和Y轴的坐标
			//  先获得magnify相对与document的定位position
			var magnify_offset = $(this).offset();
			// 这里我们用鼠标相对与文档的位置减去鼠标相对于magnify这个人容器的位置 来得到鼠标的位置
			var mouse_x = e.pageX - magnify_offset.left;
			var mouse_y = e.pageY - magnify_offset.top;
			// 现在、我们来调整一下放大镜的隐藏与显示、
			if( mouse_x > 0 && mouse_y > 0 && mouse_x < $(this).width() && mouse_y < $(this).height() ){
				$('.large').fadeIn(100);
			}else{
				$('.large').fadeOut(100);
			}
			if($('.large').is(':visible')){
				// 放大镜图片背景的定位是根据鼠标在小图片上改变的位置来改变的、
				// 因此、我们应该先得到放大的比例、来定位这个放大镜里背景图片的定位、
				/*
				var ratio_x = mouse_x/$('.small').width();//得到的是缩放的比例		
				var large_x = ratio_x*native_width;
				// 我们需要让它在放大镜的中间位置显示、
				large_x = large_x - $('.large').width()/2;
				// 因为背景图片的定位、这里需要转化为负值、
				large_x = large_x*-1;
				// 现在我们来整合一下所有的计算步骤、
				*/
				var rx = Math.round(mouse_x/$('.small').width()*native_width - $('.large').width()/2)*-1;
				var ry = Math.round(mouse_y/$('.small').height()*native_height - $('.large').height()/2)*-1;
				var bgp = rx + 'px ' + ry + 'px';
				// 现在我们应该来写放大镜跟随鼠标的效果、
				// 放大镜移动的位置 相对于文档的位置 减去 放大镜相对于放大这个层的offset的位置、
				// 再减去放大镜宽高的一半、保证放大镜的中心跟随鼠标
				var gx = mouse_x - $('.large').width()/2;
				var gy = mouse_y - $('.large').height()/2;
				$('.large').css({
					'left':gx,
					'top':gy,
					'backgroundPosition':bgp
				})
			}
		})
	})
	// 最后、我们来把这个mousemove()这个函数来放在这个load这个函数里
})
</script>
</head>
<body>
	<div class='magnify'>
		<div class='large'></div>
		<img src="<c:url value='${path}'/>" width="350px" class='small'>
	</div>
	<center>
</center>
</body>



<%-- 
<div class="bjui-pageContent">
	<div class="container" >
         <div class="demo" style="text-align: center;">
             <img id="zoom_01" src="<c:url value='${path}'/>" width="350px" />
         </div>
     </div>
</div>

<script type="text/javascript">
$('#zoom_01').elevateZoom({
    zoomType: "lens",//类型：透镜效果 
    lensShape: "round", //透镜形状：圆形 
    lensSize: 350 //透镜尺寸：长和宽：200px 
});//默认效果
</script>
  --%>
 