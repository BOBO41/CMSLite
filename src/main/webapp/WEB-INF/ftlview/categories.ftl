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
  <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="/">Home</a>
          </li>
          <li class="breadcrumb-item active">
          <#if currentCatalog??>${currentCatalog.name}<#else>Detail</#if>
          </li>
        </ol>
   <div class="row">
    <div class="col-lg-3"> 
    <#include "sidebar.ftl"/>
    </div>
    <div class="col-lg-9">
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