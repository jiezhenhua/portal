//ajax请求封装，带入token
var HttpRequest = function (options) {
  var defaults = {
    type: 'get',
    headers: {},
    data: {},
    dataType: 'json',
    async: true,
    cache: false,
    beforeSend: null,
    success: null,
    complete: null
  };
  var o = $.extend({}, defaults, options);
  $.ajax({
    url: o.url,
    type: o.type,
    headers: {
      'Content-Type': o.contentType,
      'accessToken': o.token
    },
    data: o.data,
    dataType: o.dataType,
    async: o.async,
    beforeSend: function () {
      o.beforeSend && o.beforeSend();
    },
    success: function (res) {
      o.success && o.success(res);
    },
    complete: function (xhr, status) {
      //拦截器拦截没有权限跳转
      // 通过xhr取得响应头
      var REDIRECT = xhr.getResponseHeader("REDIRECT");
      //如果响应头中包含 REDIRECT 则说明是拦截器返回的
      if (REDIRECT == "REDIRECT")
      {
    	  window.location.href = xhr.getResponseHeader("CONTENTPATH");
      }
    }
  });
};

var loginHttp = function (options) {
  // 登入页无需携带token
  // 后台如果要求 Content-Type 
  if (options.type == 'post') {
    options.contentType = 'application/x-www-form-urlencoded';
  }
  HttpRequest(options);
}
var ajaxHttp = function (options) {
  if (options.type == 'post') {
    options.contentType = 'application/x-www-form-urlencoded';
  }
  // 每次请求携带token
  options.token = localStorage.getItem('accessToken');
  HttpRequest(options);
}
