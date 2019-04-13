<div id="carouselExampleIndicators" class="carousel slide  shadow" data-ride="carousel">
            <ol class="carousel-indicators">
             <#list imgs as productimg>
            <#if productimg???string(productimg,'')>
              <li data-target="#carouselExampleIndicators" data-slide-to="${productimg_index}" <#if productimg_index==0>class="active"</#if>></li>
              </#if>
              </#list>
            </ol>
            <div class="carousel-inner rounded" role="listbox">
               <#list imgs as productimg>
                <#if productimg???string(productimg,'')>
              <div class="carousel-item<#if productimg_index==0> active</#if>" style="background-image: url('${productimg}')">
                <div class="carousel-caption d-none d-md-block"></div>
              </div>
              </#if>
               </#list>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-dark"></i><i class="fa fa-chevron-circle-left fa-stack-2x"></i></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="fa-stack fa-lg"><i class="fa fa-circle fa-stack-2x text-dark"></i><i class="fa fa-chevron-circle-right fa-stack-2x"></i></span>
              <span class="sr-only">Next</span>
            </a>
</div>