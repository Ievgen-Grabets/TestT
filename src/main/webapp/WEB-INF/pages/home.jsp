<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title></title>
  <script>
    globalDate = new Date();
    console.log("Timestamp from head"+new Date());
  </script>
  <script>
    window.tdiff = [];
    window.document.onload = function (e) {
      console.log("window.document.onload", Date.now());
    };
    window.onload = function (e) {
      console.log("window.onload", e, "delta =", new Date() - globalDate);

      //var data_player = document.getElementById('data-player');
      //data_player.setAttribute("src", "http://localhost:9000/_adaptivem.js")

    };
    document.onload = function (e) {
      console.log("document.onload", Date.now());
    };
  </script>
</head>
<body>

<script type="text/javascript" src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js"></script>

Home !

<script>
  setInterval(function () {
    var btn = document.createElement("BUTTON");        // Create a <button> element
    var t = document.createTextNode("CLICK ME");       // Create a text node
    btn.appendChild(t);                                // Append the text to <button>
    document.body.appendChild(btn);
  }, 500)
</script>

(function(){ console.log('fakescript');})();

<div>
  <p>
    huge wallpaper!!!
  </p>
  <p>
    <img height="100" width="100" src="http://cache.desktopnexus.com/cropped-wallpapers/2025/2025156-1920x1080-[DesktopNexus.com].jpg?st=fj8YmmVEruGhUFAMt9X9jQ&e=1443791645">
  </p>
</div>

<script>

  function afterLoadPlayer() {
    console.log("from adFail");
    var head = document.getElementsByTagName('head')[0];
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'http://localhost:8080/scripts/fakescript.js';
    script.onload = function() {
      console.log('script.onload');
    };
    head.appendChild(script);
  }

 // (function (){

    //setTimeout(function(){
    /*console.log('from set timeout!');
    var body = document.getElementsByTagName('body')[0];
    var script = document.createElement('script');
    script.async = true;
    script.src = 'http://localhost:9000/_adaptivem.js';
    script.setAttribute('data-player', "");
    script.setAttribute('data-placement', 'rzj1UaLkhEya69jV');
    script.setAttribute('data-ads', 'null');
    script.setAttribute('data-adFail', 'afterLoadPlayer');
    script.onload = function () {
      console.log('player.onload');
    };
    body.appendChild(script);*/
    //}, 1000);


/*
    setTimeout(function() {
      var s = document.scripts[0];
      var body = document.getElementsByTagName('body')[0];
      var script = document.createElement('script');
      script.async = true;
      script.src = 'http://localhost:9000/_adaptivem.js';
      /!*script.setAttribute('data-player', "");
      script.setAttribute('data-placement', 'rzj1UaLkhEya69jV');
      script.setAttribute('data-ads', 'null');
      script.setAttribute('data-adFail', 'afterLoadPlayer');*!/
      script.onload = function () {
        console.log('player script on load');
      };
      s.parentNode.insertBefore(script, s);
    }, 0);
*/



  //})();

</script>

<!-- BEGIN ADAPTIVE EMBED CODE -->
<div>
    <p>
        player!!!!
    </p>
    <script id="data-player" data-player src="http://localhost:9000/_adaptivem.js"
            data-placement="rzj1UaLkhEya69jV"
            data-ads="null"
            data-adFail="afterLoadPlayer">
    </script>
</div>



<!-- END ADAPTIVE EMBED CODE -->

<div>
  <p>
    huge wallpaper!!!
  </p>
  <p>
    <img height="100" width="100" src="http://cache.desktopnexus.com/wallpapers/2022/2022435-1920x1080-cruise-ship-1920x1080-wide-wallpapers.net.jpg?st=kqNMOO9ImKoOUSQa02pf4Q&e=1443791075">
  </p>
</div>



<%--
  <script>
    alert("blocked! 1");
  </script>

--%>

<%--
  <script>
    alert("blocked! 2");
  </script>--%>

<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript" src="//s7.addthis.com/js/300/addthis_widget.js#pubid=ra-5538f27f2d3a3b74"></script>
</body>
</html>
