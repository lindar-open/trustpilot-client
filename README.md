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

## Example of TrustPilot response bodies

### Request an access token
https://api.trustpilot.com/v1/oauth/oauth-business-users-for-applications/accesstoken


```json 
{
    "access_token": "tpa-XXXXXXXXXXXXXXXXXXXXXXXX",
    "refresh_token": "tpr-XXXXXXXXXXXXXXXXXXXXXXXX",
    "issued_at": "1740395920",
    "expires_in": "360000",
    "token_type": "BearerToken",
    "refresh_token_issued_at": "1740395920",
    "refresh_token_expires_in": "7776000",
    "refresh_token_status": "approved",
    "app_enduser": "XXXXXXXXXXXXXXXXXXXXXX",
    "client_id": "XXXXXXXXXXXXXXXXXXXXXX"
}
```
### Refresh an access token
https://api.trustpilot.com/v1/oauth/oauth-business-users-for-applications/refresh
```json 
{
    "access_token": "tpa-XXXXXXXXXXXXXXXXXXXXXXXX",
    "refresh_token": "tpr-XXXXXXXXXXXXXXXXXXXXXXXX",
    "issued_at": "1740396560",
    "expires_in": "360000",
    "token_type": "BearerToken",
    "refresh_token_issued_at": "1740396560",
    "refresh_token_expires_in": "7776000",
    "refresh_token_status": "approved"
}
```