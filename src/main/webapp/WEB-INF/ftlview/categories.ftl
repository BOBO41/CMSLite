<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<header class="pb-2">
<div class="banner-area align-self-center">
<span class="row align-items-center"><h1>Categories</h1></span>
</div>
</header>
<!-- Page Content -->

  <div class="container">

        <div class="row mb-2">
         <div class="col">
         <#include "sidebar2.ftl"/>
         </div>
        </div>
   <div class="row">
    <div class="col-lg-12">
    <#if productlist.result?? && productlist.result?size != 0>
    <#assign products=productlist.result>
     <#include "products.ftl"/>
     </#if>
    </div>
   </div>
  </div>

<#include "footer.ftl"/>
</body>
</html>