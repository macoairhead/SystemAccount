Scenario: 001: 社内アカウントを削除します

Given ユーザを削除します
When ユーザID 1005 を削除します
Then ユーザID 1005 が存在しないこと

Scenario: 002: 部署を削除します

Given 部署を削除します
When 部署ID 400 を削除します
Then 部署ID 400 が存在しないこと

Scenario: 003: 管理システムを削除します

Given 管理システムを削除します
When 管理システムID 1000 を削除します
Then 管理システムID 1000 が存在しないこと

Scenario: 004: 権限を削除します

Given 権限を削除します
When 管理システムID、権限ID 2000 101 を削除します
Then 管理システムID、権限ID 2000 101 が存在しないこと

Scenario: 005: 保有権限を削除します

Given 保有権限を削除します
When システムアカウントID、管理システムID、権限ID m-tomoe 2000 1 の権限を削除します
Then システムアカウントID、管理システムID、権限ID m-tomoe 2000 1 が存在しないこと
