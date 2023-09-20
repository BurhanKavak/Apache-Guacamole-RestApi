# 🚩 Apache Guacamole

![](/images/2.png)

**Apache Guacamole, açık kaynaklı bir uzak masaüstü yönetim uygulamasıdır. Guacamole, kullanıcıların web tarayıcıları üzerinden uzak sunuculara erişmelerine olanak tanır. Bu, sunuculara veya makinelerinize fiziksel olarak erişim sağlamadan, uzaktan çalışan sistemleri yönetmek için kullanışlı bir araçtır.**

**Guacamole, web tabanlı bir arabirime sahiptir ve bu nedenle kullanıcılar sadece bir tarayıcı kullanarak uzak sunuculara erişebilirler. Ayrıca, farklı uzak masaüstü protokollerini destekler, böylece farklı işletim sistemlerini ve sunucu türlerini yönetmek için kullanılabilir.**

**Bu uygulama, IT yöneticileri, sistem yöneticileri ve uzak sunucularla çalışan herkes için oldukça kullanışlıdır. Apache Guacamole, açık kaynaklı bir proje olduğu için, topluluk tarafından desteklenir ve geliştirilir, bu da onu popüler bir uzak masaüstü yönetim aracı haline getirir.**

**Apache Guacamole bir uzak masaüstü oturumu yönetmenizi sağlayan HTML5 VNC tabanlı bir uygulamadır. Kısaca Server-Client yapısından oluşur ve bu iki yapı birden aynı makinaya kurulması gerekmektedir. Son kullanıcıların tek yapması gereken desteklenen browserlar üzerinden bu uygulamanın web arayüzüne girmeleridir.**

**Kısaca mimari şu şekildedir:**

![](/images/1.png)


**Birden fazla kimlik doğrulama yöntemleri bulunmaktadır, bunlar:**

- **Database Authentication**
- **LDAP Authentication**
- **TOTP Authentication**
- **DUO Two-Factor Authentication**
- **HTTP Header Authentication**
- **CAS Authentication**
- **OpenID Authentication**

**İstenildiği gibi kimlik doğrulama yöntemleri ayarlanabilmektedir.**

**Sistem gereksinimlerine gelecek olursak, klasik bir java web uygulamasını nasıl bir şartlarda çalıştırmanız gerekiyorsa o şartlara uygun bir Linux tabanlı sistem kurmanız yeterli olacaktır.**









<!-- omit in toc -->
### POST guacamole/api/tokens

#### Headers

None.

#### Path Parameters

None.

#### Query Parameters

None.

#### Request Body

Body must be `x-www-form-urlencoded`.

- username (string, required) - Kullanıcının adı.
- password (string, required) - Kullanıcının şifresi.

```
username: guacadmin
password: guacadmin
```

### Response

#### Status Kodu

- 200 - OK

#### Response Body

Returns a JSON object.

- authToken (string) - Auth token.
- username (string) - Username.
- dataSource (string) - Datasource.
- availableDatasources (array) - Mevcut veri kaynaklarının listesi.

#### Response Örneği

```json
{
  "authToken": "0BDA2CED0580DEB052C34B596AB401993BFD66551FADEF06FC7144F1D6318EE8",
  "username": "guacadmin",
  "dataSource": "postgresql",
  "availableDataSources": ["postgresql", "postgresql-shared"]
}
```

## Get token

```
curl -X POST -d 'username=MYUSERNAME&password=MYPASSWORD' http://localhost:8080/guacamole/api/tokens
```
output
```
{
  "authToken": "C90FE11682EE3A8CCA339F1135FF02D0A97CDDDE440A970B559D005517BE6EA8",
  "username": "guacadmin",
  "dataSource": "postgresql",
  "availableDataSources": [
    "postgresql",
    "postgresql-shared"
  ]
}
```


## RDP Connection Oluşturma

Bir RDP bağlantısı oluşturur.

<!-- omit in toc -->
### POST guacamole/api/session/data/{{data_source}}/connections

#### Headers

- Content-Type (string, required) - application/json

#### Path Parameters

- data_source (string, required) - Data source

#### Query Parameters

- token (string, required) - Auth Token

#### Request Body

**@TODO**

```json
{
  "parentIdentifier": "ROOT",
  "name": "test",
  "protocol": "rdp",
  "parameters": {
    "port": "",
    "read-only": "",
    "swap-red-blue": "",
    "cursor": "",
    "color-depth": "",
    "clipboard-encoding": "",
    "disable-copy": "",
    "disable-paste": "",
    "dest-port": "",
    "recording-exclude-output": "",
    "recording-exclude-mouse": "",
    "recording-include-keys": "",
    "create-recording-path": "",
    "enable-sftp": "",
    "sftp-port": "",
    "sftp-server-alive-interval": "",
    "enable-audio": "",
    "security": "",
    "disable-auth": "",
    "ignore-cert": "",
    "gateway-port": "",
    "server-layout": "",
    "timezone": "",
    "console": "",
    "width": "",
    "height": "",
    "dpi": "",
    "resize-method": "",
    "console-audio": "",
    "disable-audio": "",
    "enable-audio-input": "",
    "enable-printing": "",
    "enable-drive": "",
    "create-drive-path": "",
    "enable-wallpaper": "",
    "enable-theming": "",
    "enable-font-smoothing": "",
    "enable-full-window-drag": "",
    "enable-desktop-composition": "",
    "enable-menu-animations": "",
    "disable-bitmap-caching": "",
    "disable-offscreen-caching": "",
    "disable-glyph-caching": "",
    "preconnection-id": "",
    "hostname": "",
    "username": "",
    "password": "",
    "domain": "",
    "gateway-hostname": "",
    "gateway-username": "",
    "gateway-password": "",
    "gateway-domain": "",
    "initial-program": "",
    "client-name": "",
    "printer-name": "",
    "drive-name": "",
    "drive-path": "",
    "static-channels": "",
    "remote-app": "",
    "remote-app-dir": "",
    "remote-app-args": "",
    "preconnection-blob": "",
    "load-balance-info": "",
    "recording-path": "",
    "recording-name": "",
    "sftp-hostname": "",
    "sftp-host-key": "",
    "sftp-username": "",
    "sftp-password": "",
    "sftp-private-key": "",
    "sftp-passphrase": "",
    "sftp-root-directory": "",
    "sftp-directory": ""
  },
  "attributes": {
    "max-connections": "",
    "max-connections-per-user": "",
    "weight": "",
    "failover-only": "",
    "guacd-port": "",
    "guacd-encryption": "",
    "guacd-hostname": ""
  }
}
```

### Response

#### Status Kodu

- 200 - OK

#### Response Body

**@TODO**
