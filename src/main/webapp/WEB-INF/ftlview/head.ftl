<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <#if head_keywords?? && head_keywords?has_content>
 <meta name="keywords" content="${head_keywords}">
 <#else>
  <meta name="keywords" content="${siteinfo.keyword}">
 </#if>
 <#if head_description?? && head_description?has_content>
 <meta name="description" content="${head_description}">
 <#else>
  <meta name="description" content="${siteinfo.description}">
 </#if>
  <#if head_title?? && head_title?has_content>
  <title>${head_title}</title>
 <#else>
  <title>${siteinfo.title}</title>
 </#if>
  <!-- Flag Icons -->
  <link href="/vendor/flag-icon/css/flag-icon.min.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome Icons -->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="/assets/styles.min.css">
  <link href="/css/modern-business.css" rel="stylesheet">
</head>