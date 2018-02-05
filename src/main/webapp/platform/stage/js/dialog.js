(function($) {
	'use strict';

	$.warnDialog = function() {

		var self = this;
		self.div = "<div class='modal' id='dialog-warn'><div class='modal-content center centent-size'>"
				+ "<img src='"+por+"/platform/stage/image/portals/clear-search.png' class='close-regist'  onclick='$.warnDialog().closeThisDialog()'></img>"
				+ "<div class='content-text'></div>"
				+ "<br/><button class='portalBtn  btnSmall' style='margin: 30px 0 0 0 ;' onclick='$.warnDialog().closeThisDialog()'>确认</button>"
				+ "</div></div>";

		$("body").append(self.div);

		self.show = function(text) {
			$("#dialog-warn").find(".content-text").html(text);
			$("#dialog-warn").fadeIn();
		};

		self.closeThisDialog = function() {
			$("#dialog-warn").fadeOut(function(){
				$("#dialog-warn").remove();
			});
		}

		return self;
	};

	$.confirmDialog = function(option) {
		var self = this;
		self.div = "<div class='modal' id='dialog'><div class='modal-content center centent-size'>"
				+ "<img src='"+por+"/platform/stage/image/portals/clear-search.png' class='close-regist closeThisDialog-img'></img>"
				+ "<div class='content-text'></div>"
				+ "<br/><button class='portalBtn  btnSmall closeThisDialog' style='margin: 30px 13px 0 13px ;' >取消</button>"
				+ "<button class='portalBtn  btnSmall confirmThisDialog' style='margin: 30px 13px 0 13px ;' id='confirmThisDialog'>确认</button>"
				+ "</div></div>";
		
		$("body").append(self.div);

		self.showDialog = function(text) {
			$("#dialog").find(".content-text").html(text);
			$("#dialog").show();
			if (typeof option.cancelText != 'undefined') {
				$(".closeThisDialog").html(option.cancelText);
			}
			
			if (typeof option.confirmText != 'undefined') {
				$(".confirmThisDialog").html(option.confirmText);
			}
		};

		self.showDialog(option.text);

		$(".closeThisDialog").click(function() {
			if (typeof option.cancel === 'function') {
				option.cancel();
			}
			$("#dialog").remove();
		});

		$(".closeThisDialog-img").click(function() {
			$("#dialog").remove();
		});

		$('#confirmThisDialog').click(function() {
			if (typeof option.confirm === 'function') {
				option.confirm();
			}
			$("#dialog").remove();
		});

		return self;
	};

})(jQuery);