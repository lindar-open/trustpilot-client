# trustpilot-client

https://documentation-apidocumentation.trustpilot.com/

To import:

```xml
<dependency>
    <groupId>com.lindar</groupId>
    <artifactId>trustpilot-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

To use:
- Create an instance of the client
- Get the desired resource (Authentication API, Invitation API, Product Reviews Api, etc.)
- Call the API by passing the necessary authentication credentials alongside the eventual request object

E.g. to send review invitation(s): 

    new TrustpilotClient().invitation().createInvitations(accessToken, businessUnitId, createInvitationsRequest)

Note: since every API call can have a different authentication method (OAuth2, basic, ApiKey or unauthenticated), authentication credentials are passed alongside each individual API call. 
