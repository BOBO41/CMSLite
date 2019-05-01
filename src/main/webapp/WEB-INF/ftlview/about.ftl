<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<header class="pb-2">
<div class="banner-area align-self-center">
<span class="row align-items-center"><h1>About Us</h1></span>
</div>
</header>
<!-- Page Content -->
<div class="container">
  <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/">Home</a></li>
          <li class="breadcrumb-item active">About</li>
  </ol>
   <div class="row">
   ${introContent}
${introAbout}
${team}
${customer}
   </div>
    <div class="row">
    <div class="col-lg-12 text-center">
<h2 class="section-heading text-uppercase"><strong><span style="color: #67409d;">Company News</span></strong></h2>
</div>
     </div>
   <div class="card-columns">
<#list articles.result as article>
  <div class="card">
    <a href="/article/${article.id}" target="_blank"><img src="${article.imgUrl}" class="card-img-top"></a>
    <div class="card-body">
     <a href="/article/${article.id}" target="_blank"> <h5 class="card-title">${article.title}</h5></a>
      <p class="card-text text-truncate">${article.spec}</p>
      <p class="card-text"><small class="text-muted">${article.addTime?datetime}</small></p>
    </div>
  
</div>
</#list>
</div>
</div>

<#include "footer.ftl"/>
</body>
</html>