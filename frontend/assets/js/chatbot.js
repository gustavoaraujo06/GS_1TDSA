window.watsonAssistantChatOptions = {
    integrationID: "56547c4a-cb39-4b8e-ae10-96da94ed9d56", // The ID of this integration.
    region: "us-south", // The region your integration is hosted in.
    serviceInstanceID: "ec4c7774-007c-4ff9-800b-b9bd98c9fd65", // The ID of your service instance.
    onLoad: async (instance) => { await instance.render(); }
  };
  setTimeout(function(){
    const t=document.createElement('script');
    t.src="https://web-chat.global.assistant.watson.appdomain.cloud/versions/" + (window.watsonAssistantChatOptions.clientVersion || 'latest') + "/WatsonAssistantChatEntry.js";
    document.head.appendChild(t);
  });
