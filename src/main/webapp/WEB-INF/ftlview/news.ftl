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
<#list articles.result as article>


<div class="card w-50">
    <a href="/article/${article.id}" target="_blank"><img src="${article.imgUrl}" class="card-img-top"></a>
    <div class="card-body">
     <a href="/article/${article.id}" target="_blank"> <h5 class="card-title">${article.title}</h5></a>
      <p class="card-text">${article.spec}</p>
      <p class="card-text"><small class="text-muted">${article.addTime}</small></p>
    </div>
  </div>

</#list>
<div class="row">
<#assign totalPage=(articles.total/articles.limit)?ceiling>
 <div class="col-12">
                  <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                    <ul class="pagination">
                    <li class="paginate_button page-item"><a href="/news/1/${articles.limit}" tabindex="0" class="page-link">Home</a></li>
                      <li class="paginate_button page-item previous<#if articles.page==1> disabled</#if>" id="dataTable_previous">
                      <a href="/news/${articles.page-1}/${articles.limit}/${id}" tabindex="0" class="page-link">Pre</a>
                      </li>
                       <#list 0..4 as t>
                       <#if (articles.page-5+t) gt 0>
                         <li class="paginate_button page-item"><a href="/news/${articles.page-5+t}/${articles.limit}" tabindex="0" class="page-link">${articles.page-5+t}</a></li>
                         </#if>
                        </#list>
                         <li class="paginate_button page-item active"><a href="/news/${articles.page}/${articles.limit}/${id}" tabindex="0" class="page-link">${articles.page}</a></li>
                        <#list 1..5 as t>
                        <#if (articles.page+t) lte totalPage>
                         <li class="paginate_button page-item"><a href="/news/${articles.page+t}/${articles.limit}/${id}" tabindex="0" class="page-link">${articles.page+t}</a></li>
                         </#if>
                        </#list>
                        <li class="paginate_button page-item next<#if (articles.page*articles.limit) gte articles.total> disabled</#if>" id="dataTable_next">
                        <a href="/news/${articles.page+1}/${articles.limit}/${id}" tabindex="0" class="page-link">Next</a>
                        </li>
                        <li class="paginate_button page-item"><a href="/news/${totalPage}/${articles.limit}/${id}" tabindex="0" class="page-link">Last</a></li>
                        </ul>
                    </div>
</div>
</div>
</div>
<#include "footer.ftl"/>
</body>
</html>