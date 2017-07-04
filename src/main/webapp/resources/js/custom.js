jQuery.noConflict();

jQuery(document).ready(function(){
	
	function mainwrapperHeight() {
		var windowHeight = jQuery(window).height();
		var mainWrapperHeight = jQuery('.mainwrapper').height();
		var leftPanelHeight = jQuery('.leftpanel').height();
		if(leftPanelHeight > mainWrapperHeight)
			jQuery('.mainwrapper').css({minHeight: leftPanelHeight});	
		if(jQuery('.mainwrapper').height() < windowHeight)
			jQuery('.mainwrapper').css({minHeight: windowHeight});
	}
	
	function responsive() {
		
		var windowWidth = jQuery(window).width();
		
		// hiding and showing left menu
		if(!jQuery('.showmenu').hasClass('clicked')) {
			
			if(windowWidth < 767)
				hideLeftPanel();
			else
				showLeftPanel();
		}
		
		// rearranging widget icons in dashboard
		if(windowWidth < 768) {
			if(jQuery('.widgeticons .one_third').length == 0) {
				var count = 0;
				jQuery('.widgeticons li').each(function(){
					jQuery(this).removeClass('one_fifth last').addClass('one_third');
					if(count == 2) {
						jQuery(this).addClass('last');
						count = 0;
					} else { count++; }
				});	
			}
		} else {
			if(jQuery('.widgeticons .one_firth').length == 0) {
				var count = 0;
				jQuery('.widgeticons li').each(function(){
					jQuery(this).removeClass('one_third last').addClass('one_fifth');
					if(count == 4) {
						jQuery(this).addClass('last');
						count = 0;
					} else { count++; }
				});	
			}
		}
	}
	
	// when resize window event fired
	jQuery(window).resize(function(){
		mainwrapperHeight();
		responsive();
	});
	
	
	
	// hide left panel
	function hideLeftPanel() {
		jQuery('.top').addClass('hide');
		jQuery('.top').hide();
	}
	
	// show left panel
	function showLeftPanel() {
		jQuery('.top').removeClass('hide');
		jQuery('.top').show();
	}
	
	// show and hide left panel
	jQuery('.showmenu').click(function() {
		jQuery(this).addClass('clicked');
		if(jQuery('.top').hasClass('hide'))
			showLeftPanel();
		else
			hideLeftPanel();
		return false;
	});
	
	
	// show/hide widget content or widget content's child	
	if(jQuery('.showhide').length > 0 ) {
		jQuery('.showhide').click(function(){
			var t = jQuery(this);
			var p = t.parent();
			var target = t.attr('href');
			target = (!target)? p.next() :	p.next().find('.'+target);
			t.text((target.is(':visible'))? 'View Source' : 'Hide Source');
			(target.is(':visible'))? target.hide() : target.show(100);
			return false;
		});
	}
	
	
});