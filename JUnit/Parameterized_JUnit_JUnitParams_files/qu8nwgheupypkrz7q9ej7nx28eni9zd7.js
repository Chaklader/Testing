var zr_alert_response_handler = (function(){  var unescape_html = function(str) {
    var temp = document.createElement("div");
    temp.innerHTML = str;
    return temp.childNodes[0].nodeValue;
  };
  var form_html = unescape_html('&lt;link rel=&quot;stylesheet&quot; href=&quot;https://www.zipalerts.com/css/alerts-widget.css&quot; media=&quot;all&quot; /&gt; &lt;!--[if lte IE 9]&gt; &lt;link rel=&quot;stylesheet&quot; href=&quot;https://www.zipalerts.com/css/alerts-widget-ie.css&quot;&gt; &lt;![endif]--&gt; &lt;!-- BEGIN WIDGET &gt;&gt;&gt;&gt;&gt;&gt;--&gt; &lt;div class=&quot;zr_alerts_widget_container&quot;&gt; &lt;div class=&quot;zr_alerts_header_container&quot;&gt; &lt;div class=&quot;zr_alerts_title&quot;&gt; &lt;svg viewBox=&quot;0 0 17 13&quot; version=&quot;1.1&quot; xmlns=&quot;http://www.w3.org/2000/svg&quot; xmlns:xlink=&quot;http://www.w3.org/1999/xlink&quot;&gt; &lt;g id=&quot;Page-1&quot; stroke=&quot;none&quot; stroke-width=&quot;1&quot; fill-rule=&quot;evenodd&quot;&gt; &lt;g id=&quot;zs_alerts&quot; transform=&quot;translate(-1145.000000, -341.000000)&quot; fill=&quot;#333333&quot;&gt; &lt;g id=&quot;Group-13&quot; transform=&quot;translate(384.000000, 95.000000)&quot;&gt; &lt;g id=&quot;zspro_preview&quot; transform=&quot;translate(109.000000, 56.000000)&quot;&gt; &lt;g id=&quot;Group-22&quot; transform=&quot;translate(627.000000, 175.000000)&quot;&gt; &lt;path d=&quot;M40.763466,26.4225508 L40.763466,19.5719098 C40.5756159,19.7859923 40.3698754,19.9822346 40.1462443,20.1606367 C38.8670746,21.1418483 37.5789597,22.1409002 36.335571,23.1756324 C35.6646779,23.7375991 34.8327703,24.4244472 33.9024651,24.4244472 L33.8845746,24.4244472 C32.9542694,24.4244472 32.1223619,23.7375991 31.4514687,23.1756324 C30.20808,22.1409002 28.9199651,21.1418483 27.6407954,20.1606367 C27.4171644,19.9822346 27.2114238,19.7859923 27.0235737,19.5719098 L27.0235737,26.4225508 C27.0235737,26.5741926 27.1577523,26.7079942 27.3098215,26.7079942 L40.4772183,26.7079942 C40.6292874,26.7079942 40.763466,26.5741926 40.763466,26.4225508 Z M40.763466,17.0475199 C40.763466,16.8245173 40.8171375,16.4320326 40.4772183,16.4320326 L27.3098215,16.4320326 C27.1577523,16.4320326 27.0235737,16.5658342 27.0235737,16.717476 C27.0235737,17.734368 27.5334525,18.6174585 28.3385243,19.250786 C29.5371868,20.1873971 30.7358493,21.1329282 31.9255665,22.0784594 C32.3996644,22.462024 33.2584077,23.2826737 33.8845746,23.2826737 L33.9024651,23.2826737 C34.5286321,23.2826737 35.3873754,22.462024 35.8614732,22.0784594 C37.0511904,21.1329282 38.2498529,20.1873971 39.4485154,19.250786 C40.0299562,18.7958606 40.763466,17.8057289 40.763466,17.0475199 Z M41.9084571,16.717476 L41.9084571,26.4225508 C41.9084571,27.2075201 41.2643996,27.8497677 40.4772183,27.8497677 L27.3098215,27.8497677 C26.5226401,27.8497677 25.8785827,27.2075201 25.8785827,26.4225508 L25.8785827,16.717476 C25.8785827,15.9325067 26.5226401,15.2902591 27.3098215,15.2902591 L40.4772183,15.2902591 C41.2643996,15.2902591 41.9084571,15.9325067 41.9084571,16.717476 Z&quot; id=&quot;&quot;&gt;&lt;/path&gt; &lt;/g&gt; &lt;/g&gt; &lt;/g&gt; &lt;/g&gt; &lt;/g&gt; &lt;/svg&gt; &lt;h3&gt;Sign Up for Job Alerts&lt;/h3&gt; &lt;/div&gt; &lt;/div&gt; &lt;div class=&quot;inner_container&quot;&gt; &lt;p&gt;Get the latest jobs to your inbox daily!&lt;/p&gt; &lt;div class=&quot;zr_alerts_errors zr_alerts_errors_hidden&quot;&gt;&lt;/div&gt; &lt;form action=&quot;https://www.zipalerts.com/subscribe-widget/qu8nwgheupypkrz7q9ej7nx28eni9zd7.js&quot; method=&quot;post&quot;&gt; &lt;label&gt;Your name:&lt;/label&gt; &lt;input type=&quot;text&quot; name=&quot;name&quot; class=&quot;zr_alerts_input&quot; placeholder=&quot;Enter your name&quot;/&gt; &lt;label&gt;Your email:&lt;/label&gt; &lt;input type=&quot;email&quot; name=&quot;email_address&quot; class=&quot;zr_alerts_input&quot; placeholder=&quot;Enter your email&quot;/&gt; &lt;label&gt;What job do you want?&lt;/label&gt; &lt;input type=&quot;text&quot; name=&quot;search&quot; class=&quot;zr_alerts_input&quot; placeholder=&quot;What job do you want?&quot; value=&quot;&quot;/&gt; &lt;label&gt;Location:&lt;/label&gt; &lt;input type=&quot;text&quot; name=&quot;location&quot; class=&quot;zr_alerts_input&quot; placeholder=&quot;Enter city, state or zip&quot; value=&quot;&quot;/&gt; &lt;input type=&quot;hidden&quot; name=&quot;submitted&quot; value=&quot;Send me jobs!&quot;/&gt; &lt;div class=&quot;zr_submit_container&quot;&gt; &lt;input type=&quot;submit&quot; value=&quot;Send me jobs!&quot;/&gt; &lt;div id=&quot;zr_attributed&quot;&gt;&lt;a rel=&quot;nofollow&quot; href=&quot;&lt;: $jobs_widget_link :&gt;&quot; id=&quot;jobs_widget_link&quot;&gt;&lt;span&gt;Job Search by&lt;/span&gt; &lt;span id=&quot;zr_logo_container&quot;&gt;&lt;img id=&quot;zr_logo&quot; src=&quot;https://www.ziprecruiter.com/img/ziprecruiter-logo-200px.png&quot; alt=&quot;ZipRecruiter&quot; width=&quot;100&quot; /&gt;&lt;/a&gt;&lt;/span&gt;&lt;/div&gt; &lt;/div&gt; &lt;/form&gt; &lt;/div&gt; &lt;/div&gt; &lt;!-- &lt;&lt;&lt;&lt;&lt;&lt; END WIDGET --&gt; ');  var jsonp_url = 'https://www.zipalerts.com/subscribe-widget/qu8nwgheupypkrz7q9ej7nx28eni9zd7.js';  var element_id = null;
  var has_class = function(element,class_name) {
    var class_regex = new RegExp('(?:^| )' + class_name + '(?: |$)');
    return class_regex.test(element.className);
  };
  var error_element = function(widget) {
    var divs = widget.getElementsByTagName('div');
    for ( var i=0; i < divs.length; i++ ) {
      var div = divs[i];
      if ( has_class(div,'zr_alerts_errors') ) {
        return div;
      }
    }
    return null;
  }
  var handle_field_errors = function(widget,form,errors) {
    if ( typeof(errors[0]) == 'object' ) {
      form[errors[0].field].focus();
    }

    var error_html = '<ul>';
    for ( var i=0; i < errors.length; i++ ) {
      var error = errors[i];
      var msg = (typeof(error) == 'object') ? error.message : error;
      error_html = error_html + '<li>' + msg + '</li>';
    }
    error_html = error_html + '</ul>';

    var error_div = error_element(widget);
    if ( error_div ) {
      error_div.innerHTML = error_html;
      error_div.className = 'zr_alerts_errors';
    }
  };
  var handle_success = function(widget,content) {
    widget.innerHTML = unescape_html(content);
  };
  var handle_error = function(widget,errors) {
    console.log('ERROR: ',errors);
    var form = widget.getElementsByTagName('form')[0];
    handle_field_errors(widget,form,errors);
  };
  var subscribe_jsonp = function(name,email,search,location,widget) {
    var first_separator = jsonp_url.match(/\?/) ? '&' : '?';
    var url = jsonp_url
          + first_separator
          + 'name=' + encodeURIComponent(name)
          + '&email_address=' + encodeURIComponent(email)
          + '&search=' + encodeURIComponent(search)
          + '&location=' + encodeURIComponent(location)
          + '&jsonp_widget=' + encodeURIComponent(widget.id);

    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = url;
    head.appendChild(script);
    return true;
  };
  var initialize_form = function(form,widget) {
    form.onsubmit = function() {
      var error_div = error_element(widget);
      if ( error_div ) {
        error_div.innerHTML = '';
        error_div.className = 'zr_alerts_errors zr_alerts_errors_hidden';
      }

      var name = form['name'].value.replace(/^\s+|\s+$/g,'');
      var email = form['email_address'].value.replace(/^\s+|\s+$/g,'');
      var search = form['search'].value.replace(/^\s+|\s+$/g,'');
      var location = form['location'].value.replace(/^\s+|\s+$/g,'');

      var errors = [];

      if ( email == '' ) {
        errors.push({ field: 'email_address', message: 'An email address is required.' });
      } else if ( ! email.match(/^[a-z0-9_.\-+%]+@(?:[a-z0-9_\-]+\.)+[a-z]{2,}$/i) ) {
        errors.push({ field: 'email_address', message: 'Please enter a valid email address.' });
      }

      if ( search == '' ) {
        errors.push({ field: 'search', message: 'Please enter your job search criteria.' });
      }

      if ( location == '' ) {
        errors.push({ field: 'location', message: 'Please enter your job search location.' });
      }

      if ( errors.length > 0 ) {
        handle_field_errors(widget,form,errors);
        return false;
      }

      if ( subscribe_jsonp(name,email,search,location,widget) ) {
        return false;
      } else {
        return true;
      }
    };
  };
  var initialize_widget = function(widget) {
    while ( ! widget.id ) {
      var new_id = 'zr_alerts_widget_container_' + Math.floor(Math.random()*999999);
      if ( ! document.getElementById(new_id) ) {
        widget.id = new_id;
      }
    }
    var form = widget.getElementsByTagName('form')[0];
    if ( ! form ) return;
    initialize_form(form,widget);
  };
  var initialize_page = function() {
    var start_element = document;
    if ( element_id ) {
      start_element = document.getElementById(element_id);
      if ( ! start_element ) return;
      start_element.innerHTML = form_html;
    }

    var elements = start_element.getElementsByTagName('div');
    for ( var i=0; i < elements.length; i++ ) {
      var element = elements[i];
      if ( has_class(element,'zr_alerts_widget_container') ) {
        initialize_widget(element);
      }
    }
  };
  if ( ! element_id ) {
    document.write(form_html);
  }
  if (document.readyState !== 'loading') {
    initialize_page();
  }
  else if ( document.addEventListener ) {
    document.addEventListener('DOMContentLoaded',initialize_page,false);
  } else if ( document.attachEvent ) {
    document.attachEvent('onreadystatechange',initialize_page);
  }
  return function(widget_id,status,msg) {
    var widget = document.getElementById(widget_id);
    if ( status == 201 ) {
      handle_success(widget,msg);
    } else {
      handle_error(widget,msg);
    }
  };
})();
