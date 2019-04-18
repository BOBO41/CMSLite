<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<!-- Page Content -->
  <div class="container">
  <ol class="breadcrumb">
          <li class="breadcrumb-item">
            <a href="/">Home</a>
          </li>
          <li class="breadcrumb-item">
            <a href="/categories/${catalog.id}">${catalog.name}</a>
          </li>
          <li class="breadcrumb-item active">
         ${product.name}
          </li>
        </ol>
<div class="row mb-4">
   
    <div class="col-lg-9">
  <#assign imgs=[product.imgUrl,product.imgUrlA,product.imgUrlB,product.imgUrlC]>
     <#include "detailcarousel.ftl"/>
    </div>
     <div class="col-lg-3"> 
    <div class="card  h-100 border-0 shadow">
        <div class="card-body">
          <h5 class="m-0"> general</h5>
          <hr>
          <p class="small">ModelNo:</p>
           <p>${product.code}</p>
           <p class="small">Style:</p>
           <p>${product.spec}</p>
        </div>
      </div>
    </div>
    
</div>
   <div class="row mb-4">
    <div class="col-lg-12">
   <div class="card border-0 shadow">
        <div class="card-body">
          <h5 class="m-0">Description</h5>
          <hr>
           ${product.content}
        </div>
      </div>
       </div>
   </div>
  </div>

<#include "footer.ftl"/>
</body>
</html>