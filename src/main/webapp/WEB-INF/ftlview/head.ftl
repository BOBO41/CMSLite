<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <#if head_keywords??>
 <meta name="keywords" content="${head_keywords}">
 <#else>
  <meta name="keywords" content="${default_keywords}">
 </#if>
 <#if head_description??>
 <meta name="description" content="${head_description}">
 <#else>
  <meta name="description" content="${default_description}">
 </#if>
  <#if head_title??>
  <title>${head_title}</title>
 <#else>
  <title>${default_title}</title>
 </#if>
  <!-- Flag Icons -->
  <link href="vendor/flag-icon/css/flag-icon.min.css" rel="stylesheet" type="text/css">
    <!-- Font Awesome Icons -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
  <!-- Bootstrap core CSS -->
  <!-- Custom styles for this template -->
  <link rel="stylesheet" href="assets/styles.min.css">
  <link href="css/modern-business.css" rel="stylesheet">
</head>