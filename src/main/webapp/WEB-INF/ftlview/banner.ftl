<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
      <#list banners as banner>
        <li data-target="#carouselExampleIndicators" data-slide-to="${banner_index}"  <#if banner_index == 0>class="active"</#if>></li>
        </#list>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide -->
          <#list banners as banner>
        <div class="carousel-item <#if banner_index == 0>active</#if>" style="background-image: url('${banner.imgUrl}')">
          <div class="carousel-caption d-none d-md-block">
            <h3>${banner.title}</h3>
            <p>${banner.content}</p>
          </div>
        </div>
        </#list>
      </div>
      <!--翻页按钮-->
      <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div>