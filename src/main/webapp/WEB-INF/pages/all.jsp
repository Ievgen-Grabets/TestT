<!doctype html>
<html class="no-js">
<head>
    <title>All</title>
</head>
<>
<table width="600px">
    <tr>
        <td><b>ID</b></td>
        <td><b>Name</b></td>
        <td><b>Number</b></td>
        <td><b>E-mail</b></td>
        <td><b>Action</b></td>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.number}</td>
            <td>${contact.email}</td>
            <td><a href="/edit?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/add">Add new one</a>
        </td>
    </tr>
</table>


<!-- original  -->
<%--<p>
    test player: original
</p>
<script src="http://localhost:9000/_adaptivem.js" data-player
        data-placement="RXk6A-V6m5qhulVM"
        data-ads="//agora-direct.mediagraph.com/vast/RXk6A-V6m5qhulVM.xml"
        data-width="425"
        data-height="319"
        data-debug="true"
        data-adFail="adFailCallback"
        data-adLoad="adLoadCallback">
</script>
<script type="application/javascript">
    function adFailCallback(){
        console.log('**********************************');
        console.log('from adFailCallback');
        console.log('**********************************');
    }

    function adLoadCallback(){
        console.log('**********************************');
        console.log('from adLoadCallback');
        console.log('**********************************');
    }
</script>--%>



<%--<p>
    foZWicWwtS80l7G_
</p>
<!-- BEGIN ADAPTIVE EMBED CODE -->
<script src="http://localhost:9000/_adaptivem.js"
        data-player
        data-placement="foZWicWwtS80l7G_"
        data-adFail="adFailCallback"
        data-adLoad="adLoadCallback"
        data-ads="http://ad4.liverail.com/?LR_PUBLISHER_ID=147476&LR_SCHEMA=vast2-vpaid&LR_VERTICALS=TN&LR_ALLOW_RETRY=2&LR_SCHEMA=vast2-vpaid&LR_TITLE=InsertTitle&LR_VIDEO_ID=InsertVideoID&LR_FORMAT=application/x-shockwave-flash;application/javascript">
</script>
<script type="application/javascript">
    function adFailCallback(){
        console.log('**********************************');
        console.log('from adFailCallback');
        console.log('**********************************');
    }

    function adLoadCallback(){
        console.log('**********************************');
        console.log('from adLoadCallback');
        console.log('**********************************');
    }
</script>
<!-- END ADAPTIVE EMBED CODE -->--%>


<p>
cFGBIhZ_WnadCzZH
</p>
<!-- BEGIN ADAPTIVE EMBED CODE -->
<script src="https://cdn-v2.mediagraph.com/video-js/3.0/_adaptivem.js"
        data-player
        data-placement="cFGBIhZ_WnadCzZH"
        data-ads="http://search.spotxchange.com/vast/2.00/98909?VPAID=1&content_page_url=%referrer_url&cb=%cache_buster&vid_duration=%video_duration&vid_url=%video_url&vid_id=%video_id&vid_title=%video_title&vid_description=%video_description&content_type=REPLACE_ME&vidip=REPLACE_ME">
</script>
<!-- END ADAPTIVE EMBED CODE -->


</body>
</html>