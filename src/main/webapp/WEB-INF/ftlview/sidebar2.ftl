<div class="card bg-white">
<nav class="navbar navbar-expand-lg">
  <a class="navbar-brand"><span style="color:#623893;">Categories</span></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
    <i class="fas fa-bars"></i>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link <#if (id!"0")== "0">active</#if>" href="/categories">ALL</a>
      </li>
    <#list catalogs as catalog>
    <#assign selectedId="">
    <#if (id!"0")== catalog.id>
    <#assign selectedId="active">
    <#else>
     <#list catalog.children as catalogchild>
                  <#if (id!"0")== catalogchild.id>
                   <#assign selectedId="active">
                  </#if>
               </#list>
     </#if>
     
     <#if (catalog.children?size>0) >
     
       <li class="nav-item dropdown mx-1">
        <a class="nav-link dropdown-toggle ${selectedId}" href="#" data-toggle="dropdown">${catalog.name}</a>
        <div class="dropdown-menu">
         <#list catalog.children as catalogchild>
          <a class="dropdown-item" href="/categories/${catalogchild.id}">${catalogchild.name}</a>
           </#list>
        </div>
      </li>
     <#else>
      <li class="nav-item">
        <a class="nav-link ${selectedId}" href="/categories/${catalog.id}">${catalog.name}</a>
      </li>
     </#if>
       </#list>
    </ul>
  </div>
</nav>
</div>