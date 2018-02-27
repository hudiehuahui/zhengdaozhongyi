<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<%-- <style>
       * {
           margin: 0;
           padding: 0;
       }
       /*放大镜的大盒子*/
       .box {
           width: 350px;
           height: 350px;
           margin: 100px;
           border: 1px solid #ccc;
           position: relative;
       }
       /*大图片外面的盒子*/
       .big {
           width: 400px;
           height: 400px;
           position: absolute;
           top: 0;
           left: 360px;
           border: 1px solid #ccc;
           overflow: hidden;
           display: none;
       }
       /*遮挡层*/
       .mask {
           width: 175px;
           height: 175px;
           background: rgba(255, 255, 0, 0.4);
           position: absolute;
           top: 0px;
           left: 0px;
           cursor: move;
           display: none;
       }
       /*小图片外面的大盒子*/
       .small {
           position: relative;
       }
   </style>
<div class="bjui-pageContent">
	<!--放大镜的整体-->
	 <div class="box" id="box">
	     <!--小图的模块-->
	     <div class="small">
	         <!--小图-->
	         <img alt="穴位图" src="<c:url value='${path}'/>">
	         <!--遮挡层-->
	         <div class="mask"></div>
	     </div>
	
	     <!--大图的模块-->
	     <div class="big">
	          <!--大图-->
	         <img alt="穴位图" src="<c:url value='${path}'/>">
	     </div>
	 </div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">关闭</button></li>
    </ul>
</div>
<script type="text/javascript">
//获取元素
    var box = document.getElementById("box");
    //获取显示小图的div
    var small = box.children[0];
    //获取小图中的遮挡的div
    var mask = small.children[1];
    //获取显示大图的div
    var big = box.children[1];
    //获取大div中的大图
    var imgObj = big.children[0];

//显示遮挡层和显示大图的的层
//鼠标进入事件
box.onmouseover = function () {
    mask.style.display = "block";
    big.style.display = "block";
};
//鼠标离开事件
box.onmouseout = function () {
    mask.style.display = "none";
    big.style.display = "none";
};

//为小层注册鼠标移动的事件
small.onmousemove = function (e) {
    var left = e.clientX - mask.offsetWidth / 2;//横坐标
    var top = e.clientY - mask.offsetHeight / 2;//纵坐标
//设置遮挡层的left和top
    var x = left - 100;//margin
    var y = top - 100;//margin

    x=x<0?0:x;//如果横坐标小于0就设置为0
    y=y<0?0:y;//如果纵坐标小于0就设置为0
    x=x>small.offsetWidth-mask.offsetWidth?small.offsetWidth-mask.offsetWidth:x;
    y=y>small.offsetHeight-mask.offsetHeight?small.offsetHeight-mask.offsetHeight:y;
    
//设置遮挡层的定位值
    mask.style.left = x + "px";
    mask.style.top = y + "px";

//设置大图的移动距离
    //大图的最大的移动距离
    var imgMaxMove=imgObj.offsetWidth-big.offsetWidth;
    //遮挡层的最大的移动距离
    var maskMaxMove=small.offsetWidth-mask.offsetWidth;
    //大图的横向移动的距离
    var imgMoveLeft=x*imgMaxMove/maskMaxMove;
    //大图的纵向移动的距离
    var imgMoveTop=y*imgMaxMove/maskMaxMove;

    //设置大图的left和top---移动的是margin-left和margin-top

    imgObj.style.marginLeft=-imgMoveLeft+"px";
    imgObj.style.marginTop=-imgMoveTop+"px";
};
</script> --%>

<%-- <head>
<style type="text/css">
  * {
  margin: 0;
  padding: 0;
  }
  img{
  vertical-align: top;
  }
  .fdj {
  width: 350px;
  height: 350px;
  position: relative;
  margin: 80px 80px;
  border: 1px solid gainsboro;
  }
  .small {
  position: relative;
  }
  .small img {
  width: 350px;
  }
  .mask {
  width: 100px;
  height: 100px;
  background: rgba(255, 255, 0, 0.4);
  position: absolute;
  left: 0;
  top: 0;
  cursor: move;
  display: none;
  }
  .big {
  position: absolute;
  top: 0;
  left: 360px;
  width: 500px;
  height: 500px;
  border: 1px solid gainsboro;
  overflow: hidden;
  display: none;
  }
  .big img{
  position: absolute;
  left: 0;
  top: 0;
  }
 </style>
 </head>
 <body>
 <div class="fdj">
  <div class="small">
  <img alt="穴位图" src="<c:url value='${path}'/>">
  <div class="mask"></div>
  </div>
  <div class="big">
  <img alt="穴位图" src="<c:url value='${path}'/>">
  </div>
 </div>
 </body>
 <script type="text/javascript">
 var fdj = document.querySelector('.fdj') // 获得最大的盒子
 var small = document.querySelector('.small'); //获取小图片盒子
 var big = document.querySelector('.big'); //获取大图片盒子
 var bigs = big.children[0] //大图片 
 var smalls = small.children[0] //小图片
 var mask = small.children[1]; //遮罩
 
 //鼠标移入小图片盒子
 small.onmouseover = function() {
  //鼠标移入图片盒子将遮罩与大图片显示
  mask.style.display = 'block';
  big.style.display = ' block';
 };
 
 //鼠标移出小图片盒子
 small.onmouseout = function() {
  //鼠标移出小图片盒子将遮罩与大图片隐藏
  mask.style.display = 'none';
  big.style.display = 'none';
 };
 
 var x=0;
 var y=0;
 //鼠标在小图片上移动时
 small.onmousemove = function(ev) {
  var ev = event || window.event;
//  var target = ev.srcElement||ev.target;
//  alert(target.value);
 //让鼠标在遮罩正中
  //鼠标X坐标与Y坐标
  x = ev.clientX -this.offsetParent.offsetLeft- mask.offsetWidth / 2 ; 
  y = ev.clientY -this.offsetParent.offsetTop- mask.offsetHeight / 2 ;
  //将遮罩限制在小图片盒子中
 
  if (x<0) {
  x=0;
  }else if(x>small.offsetWidth-mask.offsetWidth){
  x = small.offsetWidth-mask.offsetWidth;
  }
 
  if(y<0){
  y=0;
  }else if(y>small.offsetHeight-mask.offsetHeight){
  y= small.offsetHeight-mask.offsetHeight
  }
  mask.style.left = x + 'px';
  mask.style.top = y + 'px';
 
  //大图与小图的比例
 
  /*var scalX = bigs.offsetWidth/small.offsetWidth;
  var scalY = bigs.offsetHeight/small.offsetHeight;*/
 
  var scalX = x/(small.offsetWidth-mask.offsetWidth);
  var scalY = y/(small.offsetHeight-mask.offsetHeight);
 
  bigs.style.left = -(x*scalX)+'px';
  bigs.style.top = -(y*scalY)+'px';
 
 };
 
 </script> --%>
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
 
 