<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion rounded shadow mb-4" id="accordionSidebar">

 <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
              <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
              </div>
              <div class="sidebar-brand-text mx-3">Categories</div>
            </a>
      
          
            <!-- Divider -->
            <hr class="sidebar-divider">

<#list catalogs as catalog>
 <li class="nav-item">
<#if catalog.children?? && catalog.children?size != 0>
  <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse${catalog.id}" aria-expanded="true" aria-controls="collapse${catalog.id}">
                <i class="fas fa-fw fa-folder"></i>
                <span>${catalog.name}</span>
              </a>
              
               <div id="collapse${catalog.id}" class="collapse" data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                <#list catalog.children as catalogchild>
                  <a class="collapse-item" href="buttons.html">${catalogchild.name}</a>
                   </#list>
                </div>
              </div>
              <#else>
 <a class="nav-link" href="charts.html"><i class="fas fa-fw fa-table"></i><span>${catalog.name}</span></a>
</#if>
 </li>
 </#list>
</ul>