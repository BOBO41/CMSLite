<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light bg-light sb-navbar">
    <div class="container">
      <a class="navbar-brand" href="/">
        <img src="/assets/img/logo.png">
      </a>
      <!--折叠按钮-->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <i class="fas fa-bars"></i>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <!--栏目menu ui-->
        <ul class="navbar-nav mr-auto pt-3 pt-lg-0">
        <#list navs as nav>
        <li class="nav-item  <#if nav.children?? && nav.children?size != 0>dropdown</#if>">
        <#if nav.children?? && nav.children?size != 0>
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              ${nav.title}
            </a>
            <div class="dropdown-menu dropdown-templates border-0 shadow animate slideIn" aria-labelledby="navbarDropdown">
                <div class="d-lg-flex flex-row">
                  <div class="dropdown-themes-callout d-none d-lg-flex p-5 text-center text-white align-items-center">
                    <div>
                      <h5>${nav.title}</h5>
                      <p>${nav.content}</p>
                      <a href="${nav.link}" class="btn btn-door btn-xl">Browse All<i class="fas fa-angle-right"></i></a>
                    </div>
                  </div>
                  <div class="py-lg-3">
                    <a class="dropdown-item font-weight-bold" href="${nav.link}"> Browse All</a>
                    <div class="dropdown-divider"></div>
                    <h6 class="dropdown-header">${nav.title} Categories:</h6>
                    <#list nav.children as children>
                    <a class="dropdown-item" href="${children.link}">${children.title}</a>
                    </#list>
                  </div>
                </div>
              </div>
        <#else>
         <a class="nav-link" href="${nav.link}">${nav.title}</a>
        </#if>
        </li>
         </#list>
        </ul>
         <!--国际化图标-->
        <ul class="navbar-nav pb-3 pb-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="/"><span class="flag-icon flag-icon-cn"></span> </a> 
          </li>
          <li class="nav-item">
              <a class="nav-link" href="/"><span class="flag-icon flag-icon-gb"></span> </a> 
        </li>
        </ul>
      </div>
    </div>
  </nav>