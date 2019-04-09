<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<!-- Page Content -->
  <div class="container">
  <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="index.html">Home</a>
          </li>
          <li class="breadcrumb-item active">Detail</li>
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