function doLogin(){
	var publicKey = null;//获取公钥
	var encrypt = new JSEncrypt();
	ajaxHttp({
        url: "login/getPublicKey/portal",
        type: "POST",
        dataType: "json",
        success: function(res) {
            if(res){
            	console.log(res);
                publicKey = res.data;
                login(publicKey,encrypt);
			};
			if(publicKey==null){
				$("#msgTip").html("获取publicKey失败，请联系管理员！");
				$("#login_btn").removeAttr("disabled");
				return;
			};
        }
    });
}
function login(publicKey,encrypt){
	var username = $("#username").val();
	var password = $("#password").val();
	//采用RSA密码加密
	//var newPassword = hex_md5(password);
    encrypt.setPublicKey(publicKey);
    var rsaPassword = encrypt.encrypt(password.trim());
    console.log(rsaPassword);
	var params = {username:username,password:rsaPassword};//rsa加密
	loginHttp({
	      type: "POST",
	      url: "login/dologin",
	      contentType : "application/json",
	      data: JSON.stringify(params),
	      dataType : "json",
	      success: function(res){
	    	  console.log(res);
	    	  if(res.code == -1){
	    		  $("#msgTip").html(res.msg);
	    		  return ;
	    	  }
			    // 本地存入token
		        localStorage.setItem('accessToken',res.accessToken);
		        window.location.href = "welcome/home/portal";
		        /*ajaxHttp({
		            url: "welcome/home",
		            type: 'get', 
		            data:{}, 
		            success: function (res) {
		            },
		          })*/
		      }
	   });
}