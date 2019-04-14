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
</div>

<#include "footer.ftl"/>
</body>
</html>