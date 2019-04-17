<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<header class="pb-2">
<div class="banner-area align-self-center">
<span class="row align-items-center"><h1>News</h1></span>
</div>
</header>
<!-- Page Content -->
<div class="container">
  <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/">Home</a></li>
          <li class="breadcrumb-item active"><a href="/news">News</a></li>
  </ol>
<div class="row">
      <div class="col-lg-4">
        <img class="img-fluid rounded mb-4" src="${article.imgUrl}" alt="">
      </div>
      <div class="col-lg-8">
        <h2 style="color: #6f37a3;">${article.title}</h2>
        <p>${article.spec}</p>
      </div>
    </div>
    <section id="about">
      <div class="container">
        ${article.content}
      </div>
    </section>
</div>

<#include "footer.ftl"/>
</body>
</html>