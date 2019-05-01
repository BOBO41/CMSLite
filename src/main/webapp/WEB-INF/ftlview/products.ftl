   <div class="row">
   <#list products as product>
    <div class="col-md-3">
              <div class="item-preview mb-5">
              <a class="item-preview-img box-shadow-lg d-block mb-3" href="/detail/${product.id}" target="_blank">
              <img class="img-fluid" src="${product.imgUrl}.300x300.jpg" alt="${product.name}">
              </a>
              <div class="item-preview-title">${product.name}</div>
             <div class="item-preview-description">${product.code}</div>
              </div>
              </div>
</#list>
<#assign totalPage=(productlist.total/productlist.limit)?ceiling>

 <div class="col-12">
                  <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
                    <ul class="pagination">
                    <li class="paginate_button page-item"><a href="/categories/1/${productlist.limit}/${id}" tabindex="0" class="page-link">Home</a></li>
                      <li class="paginate_button page-item previous<#if productlist.page==1> disabled</#if>" id="dataTable_previous">
                      <a href="/categories/${productlist.page-1}/${productlist.limit}/${id}" tabindex="0" class="page-link">Pre</a>
                      </li>
                       <#list 0..4 as t>
                       <#if (productlist.page-5+t) gt 0>
                         <li class="paginate_button page-item"><a href="/categories/${productlist.page-5+t}/${productlist.limit}/${id}" tabindex="0" class="page-link">${productlist.page-5+t}</a></li>
                         </#if>
                        </#list>
                         <li class="paginate_button page-item active"><a href="/categories/${productlist.page}/${productlist.limit}/${id}" tabindex="0" class="page-link">${productlist.page}</a></li>
                        <#list 1..5 as t>
                        <#if (productlist.page+t) lte totalPage>
                         <li class="paginate_button page-item"><a href="/categories/${productlist.page+t}/${productlist.limit}/${id}" tabindex="0" class="page-link">${productlist.page+t}</a></li>
                         </#if>
                        </#list>
                        <li class="paginate_button page-item next<#if (productlist.page*productlist.limit) gte productlist.total> disabled</#if>" id="dataTable_next">
                        <a href="/categories/${productlist.page+1}/${productlist.limit}/${id}" tabindex="0" class="page-link">Next</a>
                        </li>
                        <li class="paginate_button page-item"><a href="/categories/${totalPage}/${productlist.limit}/${id}" tabindex="0" class="page-link">Last</a></li>
                        </ul>
                    </div>
              </div>
   </div>