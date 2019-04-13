<!DOCTYPE html>
<html lang="en">
<#include "head.ftl"/>
<body>
<#include "nav.ftl"/>
<!-- Page Content -->
<div class="container">
  <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="/">Home</a></li>
          <li class="breadcrumb-item active">About</li>
  </ol>
   <div class="row">
   ${introContent}
${introAbout}
${team}
${customer}
   </div>
</div>

<#include "footer.ftl"/>
</body>
</html>