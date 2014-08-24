Scenario: 001:  社内アカウントに一件追加します

Given 空の社員を作成します
When フランスからの新入社員を追加します
|UserID|UnitID|UserNameFirst|UserNameLast|
|1005|200|クロエ|ルメール|
Then 以下の社員が追加されていること
|UserID|UnitID|UserNameFirst|UserNameLast|
|1005|200|クロエ|ルメール|


Scenario: 002:  部署を一件追加します

Given 新しい部署を作成します
When 人事部を追加します
|UnitID|UnitName|
|400|人事部|
Then 以下の部署が追加されていること
|UnitID|UnitName|
|400|人事部|


Scenario: 003: 管理システムを一件追加します

Given 新しい管理システムを作成します
When 給与システムを作成します
|ManagementSystemID|ManagementSystemName|
|1000|給料奉行|
Then 以下の管理システムが追加されていること
|ManagementSystemID|ManagementSystemName|
|1000|給料奉行|


Scenario: 004: 権限を一件追加します

Given 新しい権限を作成します
When システム管理者権限を作成します
|ManagementSystemID|PermissionID|PermissionName|
|2000|101|システム管理者|
Then 以下の権限が追加されていること
|ManagementSystemID|PermissionID|PermissionName|
|2000|101|システム管理者|


Scenario: 005: 権限を付与します

Given 新しい権限を付与します
When 以下のシステムアカウントに新しい権限を付与します
|UserID|LoginID|ManagementSystemID|PermissionID|
|1000|m-tomoe|2000|101|
Then 以下の権限が付与されていること
|UserID|LoginID|ManagementSystemID|PermissionID|
|1000|m-tomoe|2000|101|