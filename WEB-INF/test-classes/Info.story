Scenario: 001: 社内アカウントを表示します

Given 社員を表示します
When ユーザID 1000 を表示します
Then 以下が表示されていること
|UserID|UserNameFirst|UserNameLast|
|1000|まみ|ともえ|

Scenario: 002: 部署を表示します

Given 部署を表示します
When 部署ID 200 を表示します
Then 以下の部署が表示されていること
|UnitID|UnitName|
|200|財務部|

Scenario: 003: 管理システムを表示します

Given 管理システムを表示します
When 管理システムID 2000 を表示します
Then 以下の管理システムが表示されていること
|ManagementSystemID|ManagementSystemName|
|2000|財務番長|
