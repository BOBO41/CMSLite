<section class="py-5 bg-light">
<div class="mb-5 sb-nav-tabs-wrapper">
      <div class="container">
        <ul class="nav nav-tabs sb-nav-tabs border-0" id="myTab" role="tablist">
        <#list comproducts as comproduct>
          <li class="nav-item">
            <a class="nav-link nav-link-template<#if comproduct_index == 0> active</#if>" id="tab-${comproduct.id}" data-toggle="tab" href="#nav${comproduct.id}" role="tab" aria-controls="con${comproduct.id}" <#if comproduct_index == 0>aria-selected="true"<#else>aria-selected="false"</#if>>${comproduct.name}</a>
          </li>
          </#list>
        </ul>
      </div>
      
      <div class="container">
        <div class="row"> 
           <div class="col-lg"> 
            <div class="tab-content mb-5 mb-lg-0" id="myTabContent"> 
            
            <#list comproducts as comproduct>
              <div class="tab-pane fade<#if comproduct_index == 0> show active</#if>" id="nav${comproduct.id}" role="tabpanel" aria-labelledby="tab-${comproduct.id}"> 
                <div class="row">
                <#list comproduct.products as product>
                <div class="col-md-4">
                <div class="item-preview mb-5">
                <a class="item-preview-img box-shadow-lg d-block mb-3" href="/cms/product/${product.id}"><img class="img-fluid" src="${product.imgUrl}" alt="${product.name}"></a>
                <div class="item-preview-title">${product.name}</div>
                <div class="item-preview-description"></div>
                </div>
                </div>
                 </#list>
                 <div class="col-12 text-center"><a href="/categories.html" class="btn btn-xl btn-template shadow">Browse All</a></div>
                </div>
                </div>
             </#list>
            </div>
           </div>
        </div>
      </div>
      
    </div>
</section>