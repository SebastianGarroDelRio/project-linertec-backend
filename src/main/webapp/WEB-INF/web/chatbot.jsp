<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<body>

<script>
  window.watsonAssistantChatOptions = {
    integrationID: "7e3b2113-3591-4861-81a1-98f452f0160e", // The ID of this integration.
    region: "us-south", // The region your integration is hosted in.
    serviceInstanceID: "2d2f64fb-0b70-482d-950c-d8d7ba9194d0", // The ID of your service instance.
    onLoad: async (instance) => { await instance.render(); }
  };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
    document.head.appendChild(t);
  });
</script>

</body>
</html>