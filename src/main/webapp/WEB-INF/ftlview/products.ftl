   <div class="row">
   <#list products as product>
    <div class="col-md-4">
              <div class="item-preview mb-5">
              <a class="item-preview-img box-shadow-lg d-block mb-3" href="/item.html">
              <img class="img-fluid" src="/assets/img/screenshots/themes/sb-admin-2.png" alt="${product.name}">
              </a>
              <div class="item-preview-title">${product.name}</div>
              <div class="item-preview-description"></div>
              </div>
              </div>
</#list>
   </div>